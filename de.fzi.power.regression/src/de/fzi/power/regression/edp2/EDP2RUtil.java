package de.fzi.power.regression.edp2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.util.MathArrays;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.util.MetricDescriptionUtility;
import org.palladiosimulator.measurementframework.measureprovider.IMeasureProvider;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.regression.r.Measurements;
import de.fzi.power.regression.r.TargetMeasurements;
import de.fzi.power.regression.r.VariableMeasurements;

public class EDP2RUtil {
    private static final String TARGET_METRIC_NAME = "P";

    public static List<Measurements> combineDatasets(Collection<IDataSource> measurements, Map<IDataSource, MeasuredFactor> mappedFactors, MetricDescription targetMetric) {
        measurements.stream().filter(t -> !t.getMetricDesciption().getId().equals(targetMetric.getId())).forEach(dataSource -> {
            if(!MetricDescriptionUtility.isBaseMetricDescriptionSubsumedByMetricDescription(MetricDescriptionConstants.POINT_IN_TIME_METRIC, dataSource.getMetricDesciption())) {
                throw new IllegalArgumentException("The passed metric " + dataSource.getMetricDesciption().getName() + " does not contain a time dimension.");
            }
        });;
        SortedMap<Measure<Object,Quantity>, Iterator<IMeasureProvider>> nextValuesIterators = new TreeMap<Measure<Object,Quantity>, Iterator<IMeasureProvider>>();
        measurements.forEach(m -> {
            Iterator<IMeasureProvider> curIterator = m.getDataStream().iterator();
            nextValuesIterators.put(curIterator.next().getMeasureForMetric(MetricDescriptionConstants.POINT_IN_TIME_METRIC), curIterator);
        });
        
        List<Measure<Object,Quantity>> sortedPointsInTime = new ArrayList<Measure<Object,Quantity>>();

        Measure<Object,Quantity> lastMeasure = null;
        while(!nextValuesIterators.isEmpty()) {
            Measure<Object,Quantity> curMeasure = nextValuesIterators.firstKey();
            if(lastMeasure == null || curMeasure.compareTo(lastMeasure) > 0) {
                sortedPointsInTime.add(curMeasure);
            }
            Iterator<IMeasureProvider> curIterator = nextValuesIterators.remove(curMeasure);
            if(curIterator.hasNext()) {
                nextValuesIterators.put(curIterator.next().getMeasureForMetric(MetricDescriptionConstants.POINT_IN_TIME_METRIC), curIterator);
            }
            lastMeasure = curMeasure;
        }
        
        List<Measurements> resultingMeasurementsList = new ArrayList<Measurements>();

        measurements.forEach(m -> {
           double[] timeVals = new double[m.getDataStream().size()];
           double[] targetVals = new double[timeVals.length];
           
           MetricDescription wantedMetric = ((MetricSetDescription) m.getMetricDesciption()).getSubsumedMetrics().stream().filter(s -> !s.getId().equals(MetricDescriptionConstants.POINT_IN_TIME_METRIC.getId())).findAny().get();
           int idx = 0;
           for(IMeasureProvider curMeasureProvider : m.getDataStream()) {
               Measure<Object, Quantity> targetMeasure = curMeasureProvider.getMeasureForMetric(wantedMetric);
               Measure<Object, Quantity> timeMeasure = curMeasureProvider.getMeasureForMetric(MetricDescriptionConstants.POINT_IN_TIME_METRIC);
               
               timeVals[idx] = timeMeasure.doubleValue(timeMeasure.getUnit());
               targetVals[idx] = targetMeasure.doubleValue(targetMeasure.getUnit());
               idx++;
           }
           MathArrays.sortInPlace(timeVals, targetVals);
           PolynomialSplineFunction interpolationFct = new LinearInterpolator().interpolate(timeVals, targetVals);
           double[] interpolatedTargetValues = new double[sortedPointsInTime.size()];
           Measurements curMeasurements;
           if(mappedFactors.containsKey(m)) {
               curMeasurements = new VariableMeasurements(mappedFactors.get(m).getName(), m.getDataStream().iterator().next().getMeasureForMetric(wantedMetric).getUnit(), interpolatedTargetValues);
           } else {
               curMeasurements = new TargetMeasurements(TARGET_METRIC_NAME, m.getDataStream().iterator().next().getMeasureForMetric(targetMetric).getUnit(), interpolatedTargetValues);
           }
           idx = 0;
           for(Measure<Object,Quantity> curTime : sortedPointsInTime) {
               double curValue = curTime.doubleValue(curTime.getUnit());
               // truncate
               if(curValue < timeVals[0]) {
                   interpolatedTargetValues[idx] = targetVals[0];
               // upper bound    
               } else if(curValue > timeVals[timeVals.length-1]) {
                   interpolatedTargetValues[idx] = targetVals[targetVals.length-1];
               } else {
                   interpolatedTargetValues[idx] = interpolationFct.value(curValue);
               }
               idx++;
           }
           resultingMeasurementsList.add(curMeasurements);
        });
        
        return resultingMeasurementsList;
    }
}
