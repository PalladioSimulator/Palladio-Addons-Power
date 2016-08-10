package de.fzi.power.profilingimport;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.edp2.EDP2Plugin;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataFactory;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementRange;
import org.palladiosimulator.edp2.models.ExperimentData.MeasuringType;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;

import com.google.common.base.Strings;
import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;

import de.fzi.power.profilingimport.mapping.MappingRepository;
import de.fzi.power.profilingimport.mapping.MetricToCsvMapping;

public class Edp2Importer {
    
    private static final MeasuringpointFactory MEASURING_POINT_FACTORY = MeasuringpointFactory.eINSTANCE;    
    private static final ExperimentDataFactory EXPERIMENT_DATA_FACTORY = ExperimentDataFactory.eINSTANCE;

    private MappingRepository mappingRepo;

    private MarkerParser markerParser;

    private ExperimentGroup group;
    private MeasuringPointRepository measuringPointRepo;

    public Edp2Importer(final MappingRepository mappingRepo) {
        this.mappingRepo = mappingRepo;
    }
    
    public void importResults(Repository repo) throws IOException {
        RepositoryManager.addRepository(EDP2Plugin.INSTANCE.getRepositories(), repo);
        this.markerParser = new MarkerParser(mappingRepo.getMarkerLog());
        this.group = EXPERIMENT_DATA_FACTORY.createExperimentGroup();
        this.measuringPointRepo = MEASURING_POINT_FACTORY
                .createMeasuringPointRepository();
        this.group.getMeasuringPointRepositories().add(this.measuringPointRepo);
        Map<MetricToCsvMapping,PeekingIterator<CSVRecord>> metricsMap = new HashMap<MetricToCsvMapping, PeekingIterator<CSVRecord>>();
        for(MetricToCsvMapping curMapping : mappingRepo.getMappings()) {
            CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new FileReader(curMapping.getCsvFileUri()));
            metricsMap.put(curMapping, Iterators.peekingIterator(parser.iterator()));
        }
        group.setPurpose("Experiment run on SuT");
        group.setRepository(repo);
        // TODO check if we need to include first new label
        ExperimentSetting experimentSetting = null;
        String prevLabel = "";
        do {
            long minTimeStamp = markerParser.getCurTimeStamp();
            String curLabel = markerParser.getCurLabel();
            markerParser.moveToEnd();
            long maxTimeStamp = markerParser.getCurTimeStamp();
            // Only add stable measurements. This should be made configurable via the wizard.
            if(curLabel.endsWith(this.mappingRepo.getMarkerLog().getMeasurementSuffix()) && prevLabel.endsWith(this.mappingRepo.getMarkerLog().getStartSuffix())) {
                experimentSetting = EXPERIMENT_DATA_FACTORY.createExperimentSetting(group, curLabel);
                addResults(metricsMap, curLabel, minTimeStamp, maxTimeStamp, experimentSetting);
            }
            if(markerParser.hasNext()) {
                markerParser.step();
            }
            prevLabel = curLabel;
        } while (markerParser.hasNext());
    }

    private void addResults(Map<MetricToCsvMapping, PeekingIterator<CSVRecord>> metricsMap, String curLabel,
            final long minTimeStamp, final long maxTimeStamp, ExperimentSetting experimentSetting) {
        final ExperimentRun run = EXPERIMENT_DATA_FACTORY.createExperimentRun(experimentSetting);
        run.setStartTime(new Date(minTimeStamp));
        run.setDuration(javax.measure.Measure.valueOf((maxTimeStamp-minTimeStamp)/1000d, SI.SECOND));
        for(Entry<MetricToCsvMapping, PeekingIterator<CSVRecord>> curEntry : metricsMap.entrySet()) {
            final StringMeasuringPoint mPoint = MEASURING_POINT_FACTORY.createStringMeasuringPoint();
            mPoint.setMeasuringPoint(curLabel);
            mPoint.setMeasuringPointRepository(this.measuringPointRepo);
            MetricToCsvMapping mapping = curEntry.getKey();
            MetricSetDescription descr = null;
            if(mapping.getConversionDivisor() != null) {
                descr = mapping.getConversionDivisor().getResultingMetric();
            } else {
                descr = curEntry.getKey().getMetric();
            }
            final MeasuringType mType = EXPERIMENT_DATA_FACTORY.createMeasuringType(mPoint, descr);
            mType.setExperimentGroup(group);
            experimentSetting.getMeasuringTypes().add(mType);
            PeekingIterator<CSVRecord> curIt = curEntry.getValue();
            NumericalBaseMetricDescription metricDescription = (NumericalBaseMetricDescription) mapping.getMetric().getSubsumedMetrics().get(1);
            long curTime = 0;
            final Measurement measurement = EXPERIMENT_DATA_FACTORY.createMeasurement(mType);
            final MeasurementRange range = EXPERIMENT_DATA_FACTORY.createMeasurementRange(measurement);
            measurement.getMeasurementRanges().add(range);
            run.getMeasurement().add(measurement);
            MeasurementsUtility.createDAOsForRawMeasurements(EXPERIMENT_DATA_FACTORY.createRawMeasurements(range));
            CSVRecord curRecord = null;
            // Move forward to initial timestamp
            while(curIt.hasNext() && curTime < minTimeStamp) {
                curRecord = curIt.next();
                curTime = Long.parseLong(curRecord.get(Constants.TIME_LABEL));
            }
            long lastTimeStamp = minTimeStamp;
            for(;curIt.hasNext();curRecord=curIt.next()) {
                // handle delays/backwarps
                curTime = Long.parseLong(curRecord.get(Constants.TIME_LABEL));
                if(curTime-lastTimeStamp <= 0l) {
                    continue;
                }
                // TODO move on all parsers correctly
                if(curTime > maxTimeStamp) {
                    break;
                }
                MetricSetDescription metric = null;
                Double curDoubleValue = Double.parseDouble(curRecord.get(Constants.VALUE_LABEL));
                // We skip negative error measurements. E.g. LMG95 reports -2 on unsuccessful measurement.
                if(curDoubleValue >= 0d) {
                    Measure<Double, ?> rawMeasure = javax.measure.Measure.valueOf(curDoubleValue, mapping.getUnit());
                    if(mapping.getConversionDivisor() != null) {
                        Measure<Double,Quantity> value = mapping.getConversionDivisor().getValue();
                        Amount divAmount = Amount.valueOf(value.getValue(), value.getUnit());
                        Amount rawAmount = Amount.valueOf(rawMeasure.getValue(), rawMeasure.getUnit());
                        Amount tempResult = rawAmount.divide(divAmount);
                        tempResult = tempResult.to(((NumericalBaseMetricDescription) mapping.getConversionDivisor().getResultingMetric().getSubsumedMetrics().get(1)).getDefaultUnit());
                        rawMeasure = Measure.valueOf(tempResult.getEstimatedValue(), tempResult.getUnit());
                        metric = mapping.getConversionDivisor().getResultingMetric();
                    } else {
                        metric = (MetricSetDescription) mType.getMetric();
                    }
                    final MeasuringValue m1 = new TupleMeasurement(metric,
                            javax.measure.Measure.valueOf((curTime-minTimeStamp)/1000d, SI.SECOND), rawMeasure);
                    MeasurementsUtility.storeMeasurement(measurement, m1);
                }
                lastTimeStamp = curTime;
            }
        }
    }
}
