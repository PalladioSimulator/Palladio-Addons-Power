package de.fzi.power.ui.adapters;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistable;
import org.eclipse.ui.IPersistableElement;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.filter.AbstractAdapter;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.interpreter.calculators.energy.AbstractCumulativeEnergyCalculator;
import de.fzi.power.specification.resources.PowerModelConstants;

public class AnalysisCumulativeEnergyConsumptionAdapter extends AbstractAdapter
        implements IPersistable, IPersistableElement {

    private static final MetricDescription ADAPTER_INPUT_METRIC = MetricDescriptionConstants.POWER_CONSUMPTION_TUPLE;
    private static final MetricSetDescription ADAPTER_OUTPUT_METRIC = MetricDescriptionConstants.CUMULATIVE_ENERGY_CONSUMPTION_TUPLE;
    private static final Unit<Energy> WATT_HOURS = PowerModelConstants.WATT_HOURS;

    private final AbstractCumulativeEnergyCalculator energyCalculator;

    public AnalysisCumulativeEnergyConsumptionAdapter(AbstractCumulativeEnergyCalculator calculator) {
        super(ADAPTER_INPUT_METRIC);
        this.energyCalculator = Objects.requireNonNull(calculator, "Passed energy calculator must not be null.");
    }

    private static TupleMeasurement createTupleMeasurement(Measure<Double, Duration> pointInTime,
            Amount<Energy> energySample) {
        return new TupleMeasurement(ADAPTER_OUTPUT_METRIC, pointInTime,
                Measure.valueOf(energySample.doubleValue(energySample.getUnit()), energySample.getUnit()));
    }

    private Collection<MeasuringValue> obtainEnergyMeasurements(IDataStream<MeasuringValue> powerMeasurements) {
        @SuppressWarnings("unchecked")
        Amount<Power>[] powerAmounts = (Amount<Power>[]) new Amount<?>[powerMeasurements.size()];
        @SuppressWarnings("unchecked")
        Measure<Double, Duration>[] pointsInTime = (Measure<Double, Duration>[]) new Measure<?, ?>[powerAmounts.length];

        int index = 0;
        for (MeasuringValue measurement : powerMeasurements) {
            Measure<Double, Power> tmp = measurement.getMeasureForMetric(MetricDescriptionConstants.POWER_CONSUMPTION);
            powerAmounts[index] = Amount.valueOf(tmp.doubleValue(tmp.getUnit()), tmp.getUnit());
            pointsInTime[index++] = measurement.getMeasureForMetric(MetricDescriptionConstants.POINT_IN_TIME_METRIC);
        }

        // assume equidistant samples (aka window increment)
        Amount<Duration> samplingRate = Amount
                .valueOf(pointsInTime[1].doubleValue(pointsInTime[1].getUnit()), pointsInTime[1].getUnit()).minus(Amount
                        .valueOf(pointsInTime[0].doubleValue(pointsInTime[0].getUnit()), pointsInTime[0].getUnit()));

        // reset calculator first so that its internal state is cleared
        this.energyCalculator.reset();
        this.energyCalculator.setSamplingPeriod(samplingRate);
        this.energyCalculator.setOffset(Amount.valueOf(pointsInTime[0].getValue(), pointsInTime[0].getUnit()));

        return IntStream.range(0, pointsInTime.length)
                .mapToObj(i -> createTupleMeasurement(pointsInTime[i],
                        this.energyCalculator.calculateNext(powerAmounts[i]).to(WATT_HOURS)))
                .collect(Collectors.toList());
    }

    @Override
    public boolean canAccept(IDataSource dataSource) {
        if (null == dataSource || dataSource.getDataStream() == null) {
            return false;
        }
        return dataSource.getDataStream().isCompatibleWith(ADAPTER_INPUT_METRIC);

    }

    @Override
    @SuppressWarnings("unchecked")
    public IDataStream<MeasuringValue> getDataStream() {
        IDataSource source = getDataSource();
        if (source == null) {
            throw new IllegalStateException("No data source set. Adapter cannot be applied.");
        }

        IDataStream<MeasuringValue> stream = source.getDataStream();
        return new OutputDataStream(obtainEnergyMeasurements(stream));
    }

    @Override
    public String getFactoryId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveState(IMemento memento) {
        // TODO Auto-generated method stub

    }

    private static class OutputDataStream implements IDataStream<MeasuringValue> {

        private final Collection<MeasuringValue> outputData;

        public OutputDataStream(Collection<MeasuringValue> energyMeasurements) {
            this.outputData = energyMeasurements;
        }

        @Override
        public boolean isCompatibleWith(MetricDescription other) {
            return getMetricDesciption().equals(other);
        }

        @Override
        public MetricDescription getMetricDesciption() {
            return ADAPTER_OUTPUT_METRIC;
        }

        @Override
        public Iterator<MeasuringValue> iterator() {
            return outputData.iterator();
        }

        @Override
        public int size() {
            return outputData.size();
        }

        @Override
        public void close() {
            // don't do nothing
        }
    }
}
