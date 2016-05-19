package de.fzi.power.regression.edp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.measure.Measure;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Power;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.net4j.util.ArrayUtil;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.MetricSpecPackage;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;

import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.regression.r.AbstractNonLinearRegression;
import de.fzi.power.regression.r.ConstantModelParameter;
import de.fzi.power.regression.r.DoubleModelParameter;
import de.fzi.power.regression.r.Measurements;
import de.fzi.power.regression.r.RobustNonLinearSquaresRegression;
import de.fzi.power.regression.r.TargetMeasurements;
import de.fzi.power.regression.r.VariableMeasurements;

public class Edp2ModelConstructor {
    private ExperimentGroup runResults;

    public Edp2ModelConstructor(ExperimentGroup runResults) {
        this.runResults = runResults;
    }

    public AbstractNonLinearRegression<Power> constructPowerModel(ResourcePowerBinding binding) {
            List<List<Measurements>> allMeasurements = new ArrayList<List<Measurements>>(); 
            for(ExperimentSetting workletResults : runResults.getExperimentSettings()) {
                for(ExperimentRun run : workletResults.getExperimentRuns()) {
                    Map<IDataSource,MeasuredFactor> mappedFactors = new HashMap<IDataSource,MeasuredFactor>();
                    Collection<IDataSource> measurements = new ArrayList<IDataSource>();
                    for(Measurement curMeasurement : run.getMeasurement()) {
                        final IDataSource dataSource = new Edp2DataTupleDataSource(curMeasurement.getMeasurementRanges().get(0).getRawMeasurements());
                        measurements.add(dataSource);
                        MetricSetDescription metricSet = (MetricSetDescription) dataSource.getMetricDesciption();
                        MetricDescription secondMetric = metricSet.getSubsumedMetrics().get(1);
                        if(MetricSpecPackage.eINSTANCE.getNumericalBaseMetricDescription().isInstance(secondMetric)) {
                            NumericalBaseMetricDescription baseMetric = (NumericalBaseMetricDescription) secondMetric;
                            for(MeasuredFactor curFactor : EcoreUtil.<MeasuredFactor>getObjectsByType(binding.getResourcePowerModelSpecification().getConsumptionFactors(), SpecificationPackage.eINSTANCE.getMeasuredFactor())) {
                                if(baseMetric.getDefaultUnit().isCompatible(((NumericalBaseMetricDescription) curFactor.getMetricType()).getDefaultUnit())) {
                                    mappedFactors.put(dataSource, curFactor);
                                    continue;
                                }
                            }
                        }
                    }
                    List<Measurements> curMeasurements = EDP2RUtil.combineDatasets(measurements, mappedFactors, MetricDescriptionConstants.POWER_CONSUMPTION);
                    allMeasurements.add(curMeasurements);
                }
            }
            
            List<Measurements> measurements = allMeasurements.stream().reduce((List<Measurements> a, List<Measurements> b) -> {
                List<Measurements> result = new ArrayList<Measurements>();
                a.forEach(consumer -> {
                    Measurements matchingMsmnts = b.stream().filter(curMeasurements -> curMeasurements.getName().equals(consumer.getName())).findAny().get();
                    UnitConverter converter = matchingMsmnts.getUnit().getConverterTo(consumer.getUnit());
                    double[] correctedValues = Arrays.stream(matchingMsmnts.getValues()).map(d -> converter.convert(d)).toArray();
                    result.add(matchingMsmnts.instantiate(consumer.getName(), consumer.getUnit(), ArrayUtils.addAll(consumer.getValues(), correctedValues)));
                });
                return result;
            }).get();
            
            List<VariableMeasurements> variableMeasurements = measurements.stream().filter(m -> m instanceof VariableMeasurements).map(p -> (VariableMeasurements) p).collect(Collectors.toList());
            TargetMeasurements targetMeasurements = measurements.stream().filter(m -> m instanceof TargetMeasurements).findAny().map(p -> (TargetMeasurements) p).get();
            
            Expression expression = null;            
            String expressionString = ((DeclarativePowerModelSpecification) binding.getResourcePowerModelSpecification()).getFunctionalExpression();
            try {
                expression = ExpressionEngine.compileExpression(expressionString, new ExpressionContext(), false);
            } catch (ExpressionEngineException e) {
                throw new IllegalArgumentException("Could not compile the expression \"" + expressionString + "\".", e);
            }
            
            List<ConstantModelParameter<?, Power>> params = new ArrayList<ConstantModelParameter<?, Power>>();
            for(FixedFactorValue value : binding.getFixedFactorValues()) {
                Measure<Double, Power> curMeasure = value.getValue();
                Amount<Power> valueAmount = Amount.valueOf(curMeasure.doubleValue(curMeasure.getUnit()), curMeasure.getUnit());
                params.add(new DoubleModelParameter<Power>(value.getBoundFactor().getName(), 
                        Measure.valueOf(valueAmount.getEstimatedValue(), valueAmount.getUnit())));
            }
            
            return new RobustNonLinearSquaresRegression<Power>(expression, variableMeasurements, params, targetMeasurements);
    }
}
