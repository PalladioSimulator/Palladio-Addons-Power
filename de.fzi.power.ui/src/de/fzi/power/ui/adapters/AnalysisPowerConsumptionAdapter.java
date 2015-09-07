package de.fzi.power.ui.adapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Predicate;
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
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
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

public class AnalysisPowerConsumptionAdapter extends AbstractDataSource implements IPersistable, IPersistableElement,
        IPropertyListener {

    private static final MetricSetDescription FILTER_OUTPUT_METRIC = MetricDescriptionConstants.POWER_CONSUMPTION_TUPLE;

    private final PowerModelRegistry registry = new PowerModelRegistry();

    private final PowerModelUpdaterSwitch modelUpdaterSwitch = new PowerModelUpdaterSwitch(registry,
            new ExtensibleCalculatorInstantiatorImpl());

    private Set<ExtendedMeasureProvider> extendedMeasureProviders;

    private PowerProvidingEntity powerProvidingEntity;
    private ExperimentRun experimentRun;
    private MeasuringPoint measuringPoint;

    private Collection<MeasuringValue> evaluatedPowerMeasurements = null;

    public AnalysisPowerConsumptionAdapter() {
        super(FILTER_OUTPUT_METRIC);
    }

    private Set<IDataSource> collectScopeDataSources(Set<ProcessingResourceSpecification> processingResourceSpecs) {
        Vector<Measurement> scopeMeasurements = new Vector<>();
        for (final ProcessingResourceSpecification spec : processingResourceSpecs) {
            Vector<Measurement> resourceMeasurements = new Vector<>();

            CollectionUtils.select(this.experimentRun.getMeasurement(), new Predicate<Measurement>() {

                @Override
                public boolean evaluate(Measurement measurement) {
                    ProcessingResourceSpecification proc = InterpreterUtils.PCMMEASURINGPOINT_SWITCH
                            .doSwitch(measurement.getMeasuringType().getMeasuringPoint());
                    return proc != null && proc.getId().equals(spec.getId());
                }
            }, resourceMeasurements);

            scopeMeasurements.addAll(resourceMeasurements);
        }
        Set<IDataSource> resultSet = new HashSet<IDataSource>(scopeMeasurements.size());
        for (Measurement m : scopeMeasurements) {
            resultSet.add(new Edp2DataTupleDataSource(m.getMeasurementRanges().get(0).getRawMeasurements()));
        }
        return resultSet;
    }

    @Override
    public MeasuringPoint getMeasuringPoint() {
        if (this.powerProvidingEntity == null) {
            return null;
        } else {
            if (measuringPoint == null) {
                measuringPoint = MeasuringpointFactory.eINSTANCE.createStringMeasuringPoint();
                ((StringMeasuringPoint) measuringPoint)
                        .setMeasuringPoint(AnalysisPowerConsumptionAdapter.this.powerProvidingEntity.getName());
                measuringPoint.setStringRepresentation(this.powerProvidingEntity.getName());
            }
        }
        return measuringPoint;
    }

    private Collection<MeasuringValue> obtainPowerConsumptionMeasurements(PowerBindingRepository bindingRepo,
            Iterable<IDataSource> scopeDataSources) {
        Collection<MeasuringValue> result = new ArrayList<>();

        this.modelUpdaterSwitch.doSwitch(this.powerProvidingEntity);

        EvaluationScope scope = EvaluationScope.createScope(scopeDataSources, extendedMeasureProviders);

        ConsumptionContext context = ConsumptionContext.createConsumptionContext(bindingRepo, scope, this.registry);

        PowerConsumptionSwitch consumptionSwitch = PowerConsumptionSwitch.createPowerConsumptionSwitch(context);

        while (scope.hasNext()) {
            scope.next();
            Amount<Power> powerAmount = consumptionSwitch.doSwitch(this.powerProvidingEntity);
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
        if (this.powerProvidingEntity == null) {
            throw new IllegalArgumentException("The given PowerProvidingEntity must not be null.");
        }
        if (this.experimentRun == null) {
            throw new IllegalArgumentException(
                    "Power consumption can only be analyzed with regards to an experiment run. Thus, this expRun must not be null.");
        }

        if (this.evaluatedPowerMeasurements == null) {
            PowerBindingRepository bindingRepo = this.powerProvidingEntity.getDistributionPowerAssemblyContext()
                    .getPowerBindingRepository();

            evaluatedPowerMeasurements = obtainPowerConsumptionMeasurements(bindingRepo,
                    collectScopeDataSources(InterpreterUtils
                            .getProcessingResourceSpecsFromInfrastructureElement(this.powerProvidingEntity)));
        }

        final Collection<MeasuringValue> powerMeasurements = this.evaluatedPowerMeasurements;

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
                return powerMeasurements.iterator();
            }

            @Override
            public int size() {
                return powerMeasurements.size();
            }

            @Override
            public void close() {
                // don't do nothing

            }
        };
    }

    public void setPowerProvidingEntity(PowerProvidingEntity powerProvidingEntity) {
        this.powerProvidingEntity = powerProvidingEntity;

        resetAdapter();
    }

    public void setExperimentRun(ExperimentRun experimentRun) {
        this.experimentRun = experimentRun;

        resetAdapter();
    }

    private void resetAdapter() {
        this.evaluatedPowerMeasurements = null;
        this.measuringPoint = null;
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
        if (extendedMeasureProviders == null) {
            extendedMeasureProviders = new HashSet<ExtendedMeasureProvider>(Arrays.asList(MeasureProviderHelper
                    .getMeasureProviderExtensions()));
        }
        PropertyConfigurable properties = new NestedPropertyConfigurableConfiguration(extendedMeasureProviders);
        properties.addObserver(this);
        return properties;
    }

    @Override
    public void propertyChangeCompleted() {
        this.evaluatedPowerMeasurements = null;
    }

    @Override
    public void propertyChanged(String key, Object oldValue, Object newValue) {

    }
}
