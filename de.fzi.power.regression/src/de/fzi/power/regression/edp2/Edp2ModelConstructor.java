package de.fzi.power.regression.edp2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.measure.Measure;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.filter.exponentialsmoothing.ExponentialDecayingFilter;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.edp2.util.MetricDescriptionUtility;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.MetricSpecPackage;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.FixedFactorValueDimensionless;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.util.BindingSwitch;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.DeclarativeResourcePowerModelSpecification;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.ResourceReplicaMeasuredFactor;
import de.fzi.power.specification.SpecificationFactory;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.util.SpecificationSwitch;
import de.fzi.power.regression.r.AbstractNonLinearRegression;
import de.fzi.power.regression.r.ConstantModelParameter;
import de.fzi.power.regression.r.DoubleModelParameter;
import de.fzi.power.regression.r.EarthRegression;
import de.fzi.power.regression.r.Measurements;
import de.fzi.power.regression.r.RobustNonLinearSquaresRegression;
import de.fzi.power.regression.r.SymbolicRegression;
import de.fzi.power.regression.r.TargetMeasurements;
import de.fzi.power.regression.r.VariableMeasurements;

public class Edp2ModelConstructor {
    private ExperimentGroup runResults;

    public Edp2ModelConstructor(ExperimentGroup runResults) {
        this.runResults = runResults;
    }
    
    public AbstractNonLinearRegression<Power> constructPowerModel(ResourcePowerBinding binding) {
        Expression expression = null;            
        String expressionString = ((DeclarativePowerModelSpecification) binding.getResourcePowerModelSpecification()).getFunctionalExpression();
        try {
            expression = ExpressionEngine.compileExpression(expressionString, new ExpressionContext(), false);
        } catch (ExpressionEngineException e) {
            throw new IllegalArgumentException("Could not compile the expression \"" + expressionString + "\".", e);
        }
        
        List<ConstantModelParameter<?, ? extends Quantity>> params = new ArrayList<ConstantModelParameter<?, ? extends Quantity>>();
        for(AbstractFixedFactorValue<?> curValue : binding.getFixedFactorValues()) {
            new BindingSwitch<Void>() {
                public Void caseFixedFactorValuePower(FixedFactorValuePower value) {
                    Measure<Double, Power> curMeasure = value.getValue();
                    Amount<Power> valueAmount = Amount.valueOf(curMeasure.doubleValue(curMeasure.getUnit()), curMeasure.getUnit());
                    params.add(new DoubleModelParameter<Power>(value.getBoundFactor().getName(), 
                            Measure.valueOf(valueAmount.getEstimatedValue(), valueAmount.getUnit())));
                    return null;
                };
                public Void caseFixedFactorValueDimensionless(FixedFactorValueDimensionless value) {
                    Measure<Double, Dimensionless> curMeasure = value.getValue();
                    Amount<Dimensionless> valueAmount = Amount.valueOf(curMeasure.doubleValue(curMeasure.getUnit()), curMeasure.getUnit());
                    params.add(new DoubleModelParameter<Dimensionless>(value.getBoundFactor().getName(), 
                            Measure.valueOf(valueAmount.getEstimatedValue(), valueAmount.getUnit())));
                    return null;
                };
            }.doSwitch(curValue);

        }
        
        Pair<List<VariableMeasurements>, TargetMeasurements> resultPair = getMeasurementsFromRepository(binding);
        
        return new RobustNonLinearSquaresRegression<Power>(expression, resultPair.getFirst(), params, resultPair.getSecond());
    }
    
    public SymbolicRegression<Power> constructSymbolicModel(PowerBindingRepository repo, PowerModelRepository modelRepo, DeclarativeResourcePowerModelSpecification spec) {
        List<IDataSource> availableSources = getDatasourcesOfFirstRun().stream()
                .filter(m -> !m.getMetricDesciption().getId().equals(MetricDescriptionConstants.POWER_CONSUMPTION_TUPLE.getId())).collect(Collectors.toList());
        ResourcePowerBinding binding = BindingFactory.eINSTANCE.createResourcePowerBinding();
        binding.setResourcePowerModelSpecification(spec);
        binding.setPowerBindingRepository(repo);
        for(IDataSource source : availableSources) {
            MeasuredFactor factor = SpecificationFactory.eINSTANCE.createMeasuredFactor();
            NumericalBaseMetricDescription curMetric = (NumericalBaseMetricDescription) ((MetricSetDescription) source.getMetricDesciption()).getSubsumedMetrics().get(1);
            factor.setMetricType(curMetric);
            String name = curMetric.getName().replace(" ", "");
            name += new PcmmeasuringpointSwitch<String>() {
                public String caseActiveResourceMeasuringPoint(ActiveResourceMeasuringPoint object) {
                    return Integer.toString(object.getReplicaID());
                };
                public String defaultCase(EObject object) {
                    return "";
                };
            }.doSwitch(source.getMeasuringPoint());
            factor.setName(name);
            spec.getConsumptionFactors().add(factor);
        }
        spec.setPowermodelrepository(modelRepo);
        Pair<List<VariableMeasurements>, TargetMeasurements> resultPair = getMeasurementsFromRepository(binding);
        return new SymbolicRegression<Power>(resultPair.getFirst(), resultPair.getSecond());
    }
    
    public EarthRegression<Power> constructEarthModel(PowerBindingRepository repo, PowerModelRepository modelRepo, 
            DeclarativeResourcePowerModelSpecification spec) {
        List<IDataSource> availableSources = getDatasourcesOfFirstRun().stream()
                .filter(m -> !m.getMetricDesciption().getId().equals(MetricDescriptionConstants.POWER_CONSUMPTION_TUPLE.getId())).collect(Collectors.toList());
        ResourcePowerBinding binding = BindingFactory.eINSTANCE.createResourcePowerBinding();
        binding.setResourcePowerModelSpecification(spec);
        binding.setPowerBindingRepository(repo);
        for(IDataSource source : availableSources) {
            NumericalBaseMetricDescription curMetric = (NumericalBaseMetricDescription) ((MetricSetDescription) source.getMetricDesciption()).getSubsumedMetrics().get(1);
            String name = curMetric.getName().replace(" ", "");
            MeasuredFactor factor = SpecificationFactory.eINSTANCE.createMeasuredFactor();
            factor.setName(name);
            factor.setMetricType(curMetric);
            spec.getConsumptionFactors().add(factor);
        }
        spec.setPowermodelrepository(modelRepo);
        Pair<List<VariableMeasurements>, TargetMeasurements> resultPair = getMeasurementsFromRepository(binding);
        EarthRegression<Power> regression = new EarthRegression<Power>(resultPair.getSecond(), resultPair.getFirst());
        String expression = null;
        try {
            expression = regression.getMaximumForm();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        expression = expression.replaceAll("\n", "");
        expression = expression.replaceAll(" ", "");
        spec.setFunctionalExpression(expression);
        spec.setName("EARTH model");
        binding.setName("EARTH model");
        return regression;
    }
    
    private List<IDataSource> getDatasourcesOfFirstRun() {
        List<IDataSource> availableSources = new LinkedList<IDataSource>();
        ExperimentSetting workletResults = runResults.getExperimentSettings().get(0);
        for(ExperimentRun run : workletResults.getExperimentRuns()) {
            for(Measurement curMeasurement : run.getMeasurement()) {
                final IDataSource dataSource = new Edp2DataTupleDataSource(curMeasurement.getMeasurementRanges().get(0).getRawMeasurements());
                availableSources.add(dataSource);
            }
            // TODO for now assume that all runs contain results for all runs.
            return availableSources;
        }
        return null;
    }

    private Pair<List<VariableMeasurements>, TargetMeasurements> getMeasurementsFromRepository(ResourcePowerBinding binding) {
            List<List<Measurements>> allMeasurements = getMeasurementsForFixedValues(binding);
            
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
            return new Pair<List<VariableMeasurements>, TargetMeasurements>(variableMeasurements, targetMeasurements);
            
    }

    private List<List<Measurements>> getMeasurementsForFixedValues(ResourcePowerBinding binding) {
        final List<List<Measurements>> allMeasurements = new ArrayList<List<Measurements>>(); 
        for(ExperimentSetting workletResults : runResults.getExperimentSettings()) {
            for(ExperimentRun run : workletResults.getExperimentRuns()) {
                final Map<IDataSource,MeasuredFactor> mappedFactors = new HashMap<IDataSource,MeasuredFactor>();
                final Collection<IDataSource> measurements = new ArrayList<IDataSource>();
                for(Measurement curMeasurement : run.getMeasurement()) {
                    final String curId = curMeasurement.getMeasuringType().getMetric().getId();
                    IDataSource dataSource = new Edp2DataTupleDataSource(curMeasurement.getMeasurementRanges().get(0).getRawMeasurements());
                    if(curId.equals(MetricDescriptionConstants.HDD_READ_RATE_TUPLE.getId()) ||
                            curId.equals(MetricDescriptionConstants.HDD_WRITE_RATE_TUPLE.getId())) {
                        dataSource = new ExponentialDecayingFilter(dataSource, dataSource.getMetricDesciption());
                    }
                    measurements.add(dataSource);
                    MetricSetDescription metricSet = (MetricSetDescription) dataSource.getMetricDesciption();
                    MetricDescription secondMetric = metricSet.getSubsumedMetrics().get(1);
                    if(MetricSpecPackage.eINSTANCE.getNumericalBaseMetricDescription().isInstance(secondMetric)) {
                        final IDataSource passedSource = dataSource;
                        for(MeasuredFactor curFactor : EcoreUtil.<MeasuredFactor>getObjectsByType(binding.getResourcePowerModelSpecification().getConsumptionFactors(), SpecificationPackage.eINSTANCE.getMeasuredFactor())) {
                            if(MetricDescriptionUtility.isBaseMetricDescriptionSubsumedByMetricDescription(curFactor.getMetricType(), curMeasurement.getMeasuringType().getMetric())) {
                                if(isSameResourceReplica(curFactor, passedSource.getMeasuringPoint())) {
                                    mappedFactors.put(passedSource, curFactor);
                                } else if(passedSource.getMeasuringPoint() instanceof StringMeasuringPoint) {
                                    mappedFactors.put(passedSource, curFactor);
                                }
                            }
                        }
                    }
                }
                List<Measurements> curMeasurements = EDP2RUtil.combineDatasets(measurements, mappedFactors, MetricDescriptionConstants.POWER_CONSUMPTION);
                allMeasurements.add(curMeasurements);
            }
        }
        return allMeasurements;
    }

    private boolean isSameResourceReplica(final MeasuredFactor curFactor, final MeasuringPoint measuringPoint) {
        if(curFactor instanceof ResourceReplicaMeasuredFactor && measuringPoint instanceof ActiveResourceMeasuringPoint) {
            ResourceReplicaMeasuredFactor replicatedFactor = (ResourceReplicaMeasuredFactor) curFactor;
            ActiveResourceMeasuringPoint activeMeasuringPoint = (ActiveResourceMeasuringPoint) measuringPoint;
            if(replicatedFactor.getReplicaId() == activeMeasuringPoint.getReplicaID()) {
                return true;
            }
        }
        return false;
    }
}
