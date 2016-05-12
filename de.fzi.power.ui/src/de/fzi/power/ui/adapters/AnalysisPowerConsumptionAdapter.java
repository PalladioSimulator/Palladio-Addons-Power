package de.fzi.power.ui.adapters;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static org.palladiosimulator.edp2.util.MeasurementsUtility.SLIDING_WINDOW_BASED_MEASUREMENT_TAG_KEY;
import static org.palladiosimulator.edp2.util.MeasurementsUtility.SLIDING_WINDOW_BASED_MEASUREMENT_TAG_VALUE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistable;
import org.eclipse.ui.IPersistableElement;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.edp2.datastream.AbstractDataSource;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.configurable.IPropertyListener;
import org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementRange;
import org.palladiosimulator.edp2.models.ExperimentData.MeasuringType;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.edp2.util.MetricDescriptionUtility;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.ConsumptionContext;
import de.fzi.power.interpreter.EvaluationScope;
import de.fzi.power.interpreter.InterpreterUtils;
import de.fzi.power.interpreter.PowerConsumptionSwitch;
import de.fzi.power.interpreter.PowerModelRegistry;
import de.fzi.power.interpreter.PowerModelUpdaterSwitch;
import de.fzi.power.interpreter.calculators.ExtensibleCalculatorInstantiatorImpl;
import de.fzi.power.interpreter.measureprovider.ExtendedMeasureProvider;
import de.fzi.power.interpreter.measureprovider.MeasureProviderHelper;

public class AnalysisPowerConsumptionAdapter extends AbstractDataSource
        implements IPersistable, IPersistableElement, IPropertyListener {

    private static final MetricSetDescription FILTER_OUTPUT_METRIC = MetricDescriptionConstants.POWER_CONSUMPTION_TUPLE;
    private static final MetricSetDescription STATE_OF_ACTIVE_RESOURCE_METRIC = MetricDescriptionConstants.STATE_OF_ACTIVE_RESOURCE_METRIC_TUPLE;
    private static final MetricSetDescription OVERALL_UTILIZATION_METRIC = MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE;

    private final PowerModelRegistry registry = new PowerModelRegistry();

    private final PowerModelUpdaterSwitch modelUpdaterSwitch = new PowerModelUpdaterSwitch(registry,
            new ExtensibleCalculatorInstantiatorImpl());

    private Set<ExtendedMeasureProvider> extendedMeasureProviders;

    private Optional<PowerProvidingEntity> powerProvidingEntity = Optional.empty();
    private Optional<ExperimentRun> experimentRun = Optional.empty();
    private Optional<MeasuringPoint> measuringPoint = Optional.empty();

    private Optional<Collection<MeasuringValue>> evaluatedPowerMeasurements = Optional.empty();

    public AnalysisPowerConsumptionAdapter() {
        super(FILTER_OUTPUT_METRIC);
    }

    private static Collection<IDataSource> collectScopeDataSources(
            Set<ProcessingResourceSpecification> processingResourceSpecs, ExperimentRun experimentRun) {

        List<String> processingResourceSpecIds = processingResourceSpecs.stream()
                .collect(mapping(ProcessingResourceSpecification::getId, toList()));

        return experimentRun.getMeasurement().stream().filter(m -> isDataSource(m, processingResourceSpecIds))
                .map(Measurement::getMeasurementRanges).map(ranges -> ranges.get(0))
                .map(MeasurementRange::getRawMeasurements).map(Edp2DataTupleDataSource::new).collect(toList());

    }

    private static boolean isDataSource(Measurement measurement, List<String> processingResourceSpecIds) {
        MeasuringType type = measurement.getMeasuringType();
        boolean result = true;
        ProcessingResourceSpecification correspondingProcessingResourceSpecification = InterpreterUtils
                .getProcessingResourceSpecificationFromMeasuringPoint(type.getMeasuringPoint());
        if (correspondingProcessingResourceSpecification == null
                || !processingResourceSpecIds.contains(correspondingProcessingResourceSpecification.getId())) {
            result = false;
        } else {
            // exclude if metric constraints are not met
            MetricDescription measurementMetric = type.getMetric();
            if (MetricDescriptionUtility.metricDescriptionIdsEqual(OVERALL_UTILIZATION_METRIC, measurementMetric)) {
                // only use 'overall utilization' for power analysis of multi-core resource that has
                // not been aggregated yet during runtime
                // (those should have been tagged)
                result = correspondingProcessingResourceSpecification.getNumberOfReplicas() > 1
                        && !isTagged(measurement.getAdditionalInformation());
            } else if (MetricDescriptionUtility.metricDescriptionIdsEqual(STATE_OF_ACTIVE_RESOURCE_METRIC,
                    measurementMetric)) {
                // consequently, only 'state of active resource' for utilization-based power
                // analysis if we have a single-core resource
                result = correspondingProcessingResourceSpecification.getNumberOfReplicas() == 1;
            }
        }
        return result;
    }

    private static boolean isTagged(EMap<String, Object> measInfo) {
        return measInfo.containsKey(SLIDING_WINDOW_BASED_MEASUREMENT_TAG_KEY)
                && Boolean.logicalAnd(SLIDING_WINDOW_BASED_MEASUREMENT_TAG_VALUE,
                        Boolean.valueOf(measInfo.get(SLIDING_WINDOW_BASED_MEASUREMENT_TAG_KEY).toString()));
    }

    @Override
    public MeasuringPoint getMeasuringPoint() {
        return this.powerProvidingEntity.map((ppe) -> this.measuringPoint.orElse(createMeasuringPoint())).orElse(null);
    }

    private MeasuringPoint createMeasuringPoint() {
        assert this.powerProvidingEntity.isPresent();

        StringMeasuringPoint mp = MeasuringpointFactory.eINSTANCE.createStringMeasuringPoint();
        mp.setMeasuringPoint(this.powerProvidingEntity.get().getName());
        mp.setStringRepresentation(this.powerProvidingEntity.get().getName());

        return mp;
    }

    private Collection<MeasuringValue> obtainPowerConsumptionMeasurements(PowerBindingRepository bindingRepo,
            Iterable<IDataSource> scopeDataSources) {
        assert this.powerProvidingEntity.isPresent();

        Collection<MeasuringValue> result = new ArrayList<>();

        this.modelUpdaterSwitch.doSwitch(this.powerProvidingEntity.get());

        EvaluationScope scope = EvaluationScope.createScope(scopeDataSources, this.extendedMeasureProviders);
        ConsumptionContext context = ConsumptionContext.createConsumptionContext(bindingRepo, scope, this.registry);
        PowerConsumptionSwitch consumptionSwitch = PowerConsumptionSwitch.createPowerConsumptionSwitch(context);

        while (scope.hasNext()) {
            scope.next();
            Amount<Power> powerAmount = consumptionSwitch.doSwitch(this.powerProvidingEntity.get());
            Measure<Double, ? extends Quantity> powerMeasure = Measure.valueOf(powerAmount.doubleValue(SI.WATT),
                    SI.WATT);
            Measure<Double, Duration> pointInTime = scope.getCurrentPointInTime();
            result.add(new TupleMeasurement(FILTER_OUTPUT_METRIC, pointInTime, powerMeasure));
        }

        context.cleanUp();

        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public IDataStream<MeasuringValue> getDataStream() {
        ExperimentRun run = this.experimentRun.orElseThrow(() -> new IllegalArgumentException(
                "Power consumption can only be analyzed with regards to an experiment run. Thus, this expRun must not be null."));

        PowerProvidingEntity ppe = this.powerProvidingEntity
                .orElseThrow(() -> new IllegalStateException("PowerProvidingEntity has not been set yet!"));

        if (!this.evaluatedPowerMeasurements.isPresent()) {
            this.evaluatedPowerMeasurements = Optional.of(obtainPowerConsumptionMeasurements(
                    ppe.getDistributionPowerAssemblyContext().getPowerBindingRepository(), collectScopeDataSources(
                            InterpreterUtils.getProcessingResourceSpecsFromInfrastructureElement(ppe), run)));
        }

        return new IDataStream<MeasuringValue>() {
            @Override
            public boolean isCompatibleWith(MetricDescription other) {
                return getMetricDesciption().equals(other);
            }

            @Override
            public MetricDescription getMetricDesciption() {
                return FILTER_OUTPUT_METRIC;
            }

            @Override
            public Iterator<MeasuringValue> iterator() {
                return AnalysisPowerConsumptionAdapter.this.evaluatedPowerMeasurements.get().iterator();
            }

            @Override
            public int size() {
                return AnalysisPowerConsumptionAdapter.this.evaluatedPowerMeasurements.get().size();
            }

            @Override
            public void close() {
                // don't do nothing

            }
        };
    }

    public void setPowerProvidingEntity(PowerProvidingEntity powerProvidingEntity) {
        this.powerProvidingEntity = Optional
                .of(Objects.requireNonNull(powerProvidingEntity, "PowerProvidingEntity must not be null."));

        resetAdapter();
    }

    public void setExperimentRun(ExperimentRun experimentRun) {
        this.experimentRun = Optional.of(Objects.requireNonNull(experimentRun, "ExperimentRun must not be null."));

        resetAdapter();
    }

    private void resetAdapter() {
        this.evaluatedPowerMeasurements = Optional.empty();
        this.measuringPoint = Optional.empty();
    }

    @Override
    public String getFactoryId() {
        return null;
    }

    @Override
    public void saveState(IMemento memento) {
    }

    @Override
    protected PropertyConfigurable createProperties() {
        // called from base class constructor due to dynamic binding!
        // hence, the extended measure providers will be null
        if (this.extendedMeasureProviders == null) {
            this.extendedMeasureProviders = new HashSet<>(
                    Arrays.asList(MeasureProviderHelper.getMeasureProviderExtensions()));
        }
        PropertyConfigurable properties = new NestedPropertyConfigurableConfiguration(this.extendedMeasureProviders);
        properties.addObserver(this);
        return properties;
    }

    @Override
    public void propertyChangeCompleted() {
        this.evaluatedPowerMeasurements = Optional.empty();
    }

    @Override
    public void propertyChanged(String key, Object oldValue, Object newValue) {

    }
}
