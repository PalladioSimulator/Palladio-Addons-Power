package de.fzi.power.interpreter.tests.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.edp2.datastream.AbstractDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.measurementframework.measureprovider.IMeasureProvider;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

public class MockStateOfActiveResourceTupleDataSource extends AbstractDataSource {

    private List<MeasuringValue> data = new ArrayList<>();
    private final Amount<Duration> windowLength;
    private final MeasuringPoint point;
    private static final MetricSetDescription expectedInputDataMetric = MetricDescriptionConstants.STATE_OF_ACTIVE_RESOURCE_METRIC_TUPLE;
    private static final Measure<Long, Dimensionless> idleStateMeasure = Measure.valueOf(0L, Unit.ONE);
    private static final Measure<Long, Dimensionless> busyStateMeasure = Measure.valueOf(42L, Unit.ONE);
    
  
    public MockStateOfActiveResourceTupleDataSource(Measure<Double, Duration> windowLength, MeasuringPoint point) {
        this(Amount.valueOf(windowLength.doubleValue(windowLength.getUnit()), windowLength.getUnit()), point);
    }
    
    public MockStateOfActiveResourceTupleDataSource(Amount<Duration> windowLength, MeasuringPoint point) {
        super(expectedInputDataMetric);
        
        this.windowLength = windowLength;
        this.point = point;
    }
    
    public void createData100PercentUtilization(Amount<Duration> intervalStart) {
        // create the filter input data, (point in time, state of active
        // resource) tuples
   
        // start with utilization
        Measure<Double, Duration> pointInTimeMeasure = Measure.valueOf(intervalStart.doubleValue(SI.SECOND), SI.SECOND);
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, busyStateMeasure));

        // again some processes active
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.3)).doubleValue(SI.MILLI(SI.SECOND)), SI.MILLI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, busyStateMeasure));

        // again some processes active
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.8)).doubleValue(SI.CENTI(SI.SECOND)), SI.CENTI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, busyStateMeasure));

        // this setup should yield a utilization of 1 (100%)
        // 100% of window is activity, rest is idleness
    }
    
    public void createData75PercentUtilization(Amount<Duration> intervalStart) {
        // create the filter input data, (point in time, state of active
        // resource) tuples

        // start with utilization
        Measure<Double, Duration> pointInTimeMeasure = Measure.valueOf(intervalStart.doubleValue(SI.SECOND), SI.SECOND);
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, busyStateMeasure));

        // no utilization next
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.3)).doubleValue(SI.MILLI(SI.SECOND)), SI.MILLI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, idleStateMeasure));

        // again some processes active
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.55)).doubleValue(SI.CENTI(SI.SECOND)), SI.CENTI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, busyStateMeasure));

        // this setup should yield a utilization of 0.75 (75%)
        // 75% of window is activity, rest is idleness
    }
    
    public void createData50PercentUtilization(Amount<Duration> intervalStart) {
        // create the filter input data, (point in time, state of active
        // resource) tuples
   
        // start with utilization
        Measure<Double, Duration> pointInTimeMeasure = Measure.valueOf(intervalStart.doubleValue(SI.SECOND), SI.SECOND);
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, busyStateMeasure));

        // no utilization next
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.3)).doubleValue(SI.MILLI(SI.SECOND)), SI.MILLI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, idleStateMeasure));

        // again some processes active
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.8)).doubleValue(SI.CENTI(SI.SECOND)), SI.CENTI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, busyStateMeasure));

        // this setup should yield a utilization of 0.50 (50%)
        // 50% of window is activity, rest is idleness
    }

    public void createData25PercentUtilization(Amount<Duration> intervalStart) {
        // create the filter input data, (point in time, state of active
        // resource) tuples
     
        // start with utilization
        Measure<Double, Duration> pointInTimeMeasure = Measure.valueOf(intervalStart.doubleValue(SI.SECOND), SI.SECOND);
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, busyStateMeasure));

        // no utilization next
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.25)).doubleValue(SI.MILLI(SI.SECOND)), SI.MILLI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, idleStateMeasure));

        // this setup should yield a utilization of 0.25 (25%)
        // 25% of window is activity, rest is idleness
    }

    public void createDataNoUtilization(Amount<Duration> intervalStart) {
        // create the filter input data, (point in time, state of active
        // resource) tuples
             
        // start with idleness
        Measure<Double, Duration> pointInTimeMeasure = Measure.valueOf(intervalStart.doubleValue(SI.SECOND), SI.SECOND);
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, idleStateMeasure));

        // no utilization next
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.25)).doubleValue(SI.MILLI(SI.SECOND)), SI.MILLI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, idleStateMeasure));

        // no utilization next
        pointInTimeMeasure = Measure.valueOf(intervalStart.plus(this.windowLength.times(0.75)).doubleValue(SI.CENTI(SI.SECOND)), SI.CENTI(SI.SECOND));
        this.data.add(new TupleMeasurement(expectedInputDataMetric, pointInTimeMeasure, idleStateMeasure));
        
        // this setup should yield a utilization of 0 (0%)
    }
    
    // this gets the input data, i.e., (point in time, state of active resource) tuples
    @Override
    public <M extends IMeasureProvider> IDataStream<M> getDataStream() {
        return new IDataStream<M>() {

            @Override
            public Iterator<M> iterator() {
                @SuppressWarnings("unchecked")
                // that cast is type safe as Measurement implements the IMeasureProvider interface
                Iterator<M> result = (Iterator<M>) MockStateOfActiveResourceTupleDataSource.this.data.iterator();
                return result;
            }

            @Override
            public MetricDescription getMetricDesciption() {
                return expectedInputDataMetric;
            }

            @Override
            public boolean isCompatibleWith(MetricDescription other) {
                return getMetricDesciption().equals(other);
            }

            @Override
            public void close() {
                MockStateOfActiveResourceTupleDataSource.this.data.clear();
            }

            @Override
            public int size() {
                return MockStateOfActiveResourceTupleDataSource.this.data.size();
            }
        };
    }

    @Override
    protected PropertyConfigurable createProperties() {
        return new PropertyConfigurable() {

            @Override
            public Class<?> getPropertyType(String key) {
                return null;
            }

            @Override
            public Set<String> getKeys() {
                return Collections.emptySet();
            }

            @Override
            public Map<String, Object> getDefaultConfiguration() {
                return Collections.emptyMap();
            }
        };
    }

    @Override
    public MeasuringPoint getMeasuringPoint() {
        return this.point;
    }

}
