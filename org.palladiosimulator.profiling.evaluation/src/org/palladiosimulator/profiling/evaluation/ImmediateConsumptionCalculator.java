package org.palladiosimulator.profiling.evaluation;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Power;
import org.apache.commons.collections15.IteratorUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.util.MathArrays;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.filter.exponentialsmoothing.ExponentialDecayingFilter;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementRange;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.util.MetricDescriptionUtility;
import org.palladiosimulator.measurementframework.measureprovider.IMeasureProvider;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentFactory;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;

import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.interpreter.ConsumptionContext;
import de.fzi.power.interpreter.EvaluationScope;
import de.fzi.power.interpreter.PowerConsumptionSwitch;
import de.fzi.power.interpreter.PowerModelRegistry;
import de.fzi.power.interpreter.PowerModelUpdaterSwitch;
import de.fzi.power.interpreter.calculators.ExtensibleCalculatorInstantiatorImpl;
import de.fzi.power.interpreter.measureprovider.ExtendedMeasureProvider;

public class ImmediateConsumptionCalculator {
    
    private static final NumericalBaseMetricDescription POWER = MetricDescriptionConstants.POWER_CONSUMPTION;
    private static final NumericalBaseMetricDescription TIME = MetricDescriptionConstants.POINT_IN_TIME_METRIC;
    private static final MetricDescription ENERGY = MetricDescriptionConstants.ENERGY_CONSUMPTION;
    
    public EvaluationResult calculate(ExperimentRun run, ResourcePowerBinding binding) {
        PowerModelRegistry registry = new PowerModelRegistry(); 
        final PowerModelUpdaterSwitch modelUpdaterSwitch = new PowerModelUpdaterSwitch(registry,
                new ExtensibleCalculatorInstantiatorImpl());
        ProcessingResourceSpecification spec = ResourceenvironmentFactory.eINSTANCE.createProcessingResourceSpecification();
        PowerConsumingResource tempResource = InfrastructureFactory.eINSTANCE.createPowerConsumingResource();
        tempResource.setProcessingResourceSpecification(spec);
        tempResource.setResourcePowerAssemblyContext(binding);
        Measurement powerMeasurement = getMeasurementForMetric(run, MetricDescriptionConstants.POWER_CONSUMPTION_TUPLE);
        ActiveResourceMeasuringPoint measuringPoint = PcmmeasuringpointFactory.eINSTANCE.createActiveResourceMeasuringPoint();
        measuringPoint.setStringRepresentation("");
        measuringPoint.setActiveResource(spec);
        RawMeasurements rawMeasurements = powerMeasurement.getMeasurementRanges().get(0).getRawMeasurements();
        Edp2DataTupleDataSource powerSource = new Edp2DataTupleDataSource(rawMeasurements);
        // Adjust measuring point
        run.getMeasurement().stream().forEach(m -> m.getMeasuringType().setMeasuringPoint(measuringPoint));
        Measurement hddWriteMeasurement = getMeasurementForMetric(run, MetricDescriptionConstants.HDD_WRITE_RATE_TUPLE);
        Measurement hddReadMeasurement = getMeasurementForMetric(run, MetricDescriptionConstants.HDD_READ_RATE_TUPLE);
        List<IDataSource> dataSourcesUnfiltered = run.getMeasurement().stream().filter(m -> !m.getId().equals(powerMeasurement.getId()) 
                && !m.equals(hddWriteMeasurement) && !m.equals(hddReadMeasurement))
            .map( m -> m.getMeasurementRanges().get(0)).map(MeasurementRange::getRawMeasurements).map(Edp2DataTupleDataSource::new).collect(toList());
        List<IDataSource> dataSources = new ArrayList<IDataSource>();
        dataSources.addAll(dataSourcesUnfiltered);
        dataSources.add(new ExponentialDecayingFilter(new Edp2DataTupleDataSource(hddWriteMeasurement.getMeasurementRanges().get(0).getRawMeasurements()), MetricDescriptionConstants.HDD_WRITE_RATE_TUPLE));
        dataSources.add(new ExponentialDecayingFilter(new Edp2DataTupleDataSource(hddReadMeasurement.getMeasurementRanges().get(0).getRawMeasurements()), MetricDescriptionConstants.HDD_READ_RATE_TUPLE));
        modelUpdaterSwitch.doSwitch(tempResource);
        
        // Get total energy consumption
        Iterator<IMeasureProvider> powerIterator = powerSource.getDataStream().iterator();
        
        List<IMeasureProvider> powerList = IteratorUtils.toList(powerIterator);
        double[] powerValues = ArrayUtils.toPrimitive(powerList.stream().map(m -> m.getMeasureForMetric(POWER).doubleValue(POWER.getDefaultUnit())).toArray(size -> new Double[size]));
        double[] timeValues = ArrayUtils.toPrimitive(powerList.stream().map(m -> m.getMeasureForMetric(TIME).doubleValue(TIME.getDefaultUnit())).toArray(size -> new Double[size]));
        
        MathArrays.sortInPlace(timeValues, powerValues);
        
        PolynomialSplineFunction powerInterpolator = (new SplineInterpolator()).interpolate(timeValues, powerValues);
        
        SimpsonIntegrator integrator = new SimpsonIntegrator(); 
        
        // Get estimated energy consumption
        EvaluationScope scope = EvaluationScope.createScope(dataSources, Collections.<ExtendedMeasureProvider>emptySet());
        ConsumptionContext context = ConsumptionContext.createConsumptionContext(binding.getPowerBindingRepository(), scope, registry);
        PowerConsumptionSwitch consumptionSwitch = PowerConsumptionSwitch.createPowerConsumptionSwitch(context);
        
        List<Amount<Power>> powerPredicted = new ArrayList<Amount<Power>>();
        List<Measure<Double, Duration>> timePredicted = new ArrayList<Measure<Double, Duration>>();
        Measure<Double, Duration> lastTime = Measure.valueOf(-100d, Duration.UNIT);
        while (scope.hasNext()) {
            scope.next();
            Amount<Power> consumption = consumptionSwitch.doSwitch(tempResource);
            if(scope.getCurrentPointInTime().compareTo(lastTime) != 0) {
                powerPredicted.add(consumption);
                timePredicted.add(scope.getCurrentPointInTime());
            } else {
                powerPredicted.set(powerPredicted.size()-1, consumption);
            }
            lastTime = scope.getCurrentPointInTime();
        }
        
        double[] powerPred = ArrayUtils.toPrimitive(powerPredicted.stream().map(p -> p.to(POWER.getDefaultUnit()).getEstimatedValue()).toArray(s -> new Double[s]));
        double[] timePred = ArrayUtils.toPrimitive(timePredicted.stream().map(t -> t.doubleValue(Duration.UNIT)).toArray(s -> new Double[s]));
        MathArrays.sortInPlace(timePred, powerPred);
        PolynomialSplineFunction powerPredInterpolator = (new SplineInterpolator()).interpolate(timePred, powerPred);
        // TODO upper bound determined to prevent out-of-bounds calculations
        double tMin = Math.max(timeValues[0], timePred[0]);
        double tMax = timeValues[timeValues.length-1];
        double totalEnergyConsumption = integrator.integrate(SimpsonIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, powerInterpolator, timeValues[0], timeValues[timeValues.length-1]);   
        double predictedTotalEnergyConsumption = integrator.integrate(SimpsonIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, powerPredInterpolator, timePred[0], 
                Math.min(timePred[timePred.length-1], timePred[0]+(timeValues[timeValues.length-1]-timeValues[0])));

        return new EvaluationResult(run.getExperimentSetting().getDescription(), totalEnergyConsumption, predictedTotalEnergyConsumption, 
                Math.abs(predictedTotalEnergyConsumption - totalEnergyConsumption));
    }

    private Measurement getMeasurementForMetric(ExperimentRun run, MetricSetDescription metricSetDesc) {
        return run.getMeasurement().stream().filter(m -> MetricDescriptionUtility.metricDescriptionIdsEqual(m.getMeasuringType().getMetric(), metricSetDesc)).findAny().get();
    }
}
