package de.fzi.power.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;

/**
 * This class provides basic functionality for all classes that wish to provide a scope to evaluate
 * the power/energy consumption of resources.
 * 
 * @author Sebastian Krach, Florian Rosenthal
 *
 */
public abstract class AbstractEvaluationScope
        implements Iterable<Map<ProcessingResourceSpecification, Map<MetricDescription, MeasuringValue>>> {
    private static final MetricDescription POINT_IN_TIME_METRIC = MetricDescriptionConstants.POINT_IN_TIME_METRIC;

    protected final Map<ProcessingResourceSpecification, Set<IDataStream<MeasuringValue>>> resourceMeasurements;
    protected EvaluationScopeIterator iterator;
    private Map<ProcessingResourceSpecification, Map<MetricDescription, MeasuringValue>> curElement;

    /**
     * Initializes a new instance of the {@link AbstractEvaluationScope} class.
     */
    protected AbstractEvaluationScope() {
        this.resourceMeasurements = InterpreterUtils.createIdentifierMatchingHashMap();
        this.curElement = InterpreterUtils.createIdentifierMatchingHashMap();
        this.iterator = iterator();

    }

    /**
     * Sets for each {@link ProcessingResourceSpecification} which metrics are supposed to be
     * evaluated. The method is to be provided by implementing subclasses.<br>
     * 
     * A call to this method results in initializing the {@code resourceMeasurements} used to when
     * iterating the scope.
     * 
     * If for a certain {@link ProcessingResourceSpecification} and {@link MetricDescription} there
     * are no measurements available or there is no way to create the measurements from the
     * available data, an {@link IllegalArgumentException} is thrown.
     * 
     * @param metricsMap
     *            the Map linking {@link ProcessingResourceSpecification}s to the metrics needed by
     *            the {@link AbstractResourcePowerModelCalculator} in use.
     */
    public abstract void setResourceMetricsToEvaluate(
            Map<ProcessingResourceSpecification, Set<MetricDescription>> metricsMap);

    /**
     * Resets the scope to its initial state.<br>
     * In particular, the currently available set of measurements is discarded.
     * 
     * @see AbstractEvaluationScope#next()
     */
    public void reset() {
        this.curElement.clear();
    }

    /**
     * Return {@code true} if the evaluation scope can move forward in a timely fashion. That is
     * basically the case if there is at least one datastream that contains additional measurements.
     * 
     * @return true, if scope can move forward.
     */
    public final boolean hasNext() {
        return this.iterator.hasNext();
    }

    /**
     * Moves on to the next set of context elements. Specifically, this moves the underlying
     * utilization sliding window forward and evaluates the utilization to the next point in time
     * for which we want to evaluate the power consumption.<br>
     * 
     * @see AbstractEvaluationScope#reset()
     */
    public final void next() {
        this.curElement = this.iterator.next();
    }

    public Measure<Double, Duration> getCurrentPointInTime() {
        return this.iterator.getCurrentPointInTime();
    }

    /**
     * This methods provides access to all the {@link MeasuringValue}s of a certain
     * {@link ProcessingResourceSpecification} for a certain {@link MetricDescription}.
     * 
     * @param processingResourceSpecification
     *            The {@link ProcessingResourceSpecification} to retrieve the measurements for.
     * @param metric
     *            The {@link MetricDescription} which characterizes the measurements to collect.
     * @return An {@link Iterator} that contains all the measurements this scope evaluated for the
     *         given processing resource. If no measurements are available for the resource or for
     *         the specified metric, the method returns an empty iterator.
     */
    public final Iterator<MeasuringValue> getMeasurementsForProcessingResource(
            ProcessingResourceSpecification processingResourceSpecification, MetricDescription metric) {

        for (IDataStream<MeasuringValue> stream : resourceMeasurements.get(processingResourceSpecification)) {
            if (InterpreterUtils.isRequiredMetricSatisfiedBy(metric, stream.getMetricDesciption())) {
                return stream.iterator();
            }
        }
        return Collections.emptyIterator();
    }

    /**
     * Gets the current set of measurements that are evaluated for a specific resource.
     * 
     * @param processingResourceSpecification
     *            The resource for which the utilization is retrieved.
     * @return An UNMODIFIABLE collection consisting of the utilization measurements for the
     *         requested resource for the current scope state, or an empty collection if no
     *         measurements are present.
     */
    public final Collection<MeasuringValue> getMeasurements(
            ProcessingResourceSpecification processingResourceSpecification) {
        Collection<MeasuringValue> result;
        if (this.curElement.containsKey(processingResourceSpecification)) {
            Map<MetricDescription, MeasuringValue> resourceMap = this.curElement.get(processingResourceSpecification);
            result = Collections.unmodifiableCollection(resourceMap.values());
        } else {
            result = Collections.emptyList();
        }
        return result;
    }

    @Override
    public EvaluationScopeIterator iterator() {
        return new EvaluationScopeIteratorImpl(this.resourceMeasurements);
    }

    /**
     * The default implementation for this {@link EvaluationScopeIterator} allows to iterate the
     * measurements of the evaluation scope, returning the elements of the subsumed
     * {@link IDataStream}s in a monotonous increasing manner for the respective point in time
     * measures. The point in time of the next iteration is determined by the earliest point in time
     * measure of all the subsumed measurements. It is guaranteed that at least one
     * {@link IDataStream} iterator is advanced to its next value. Every iteration returns for each
     * {@link ProcessingResourceSpecification} and each evaluated {@link MetricDescription} the most
     * recent measure for the current point in time of the iterator.
     * 
     * @see EvaluationScopeIterator
     *
     */
    private static class EvaluationScopeIteratorImpl implements EvaluationScopeIterator {

        private final Map<ProcessingResourceSpecification, Map<MetricDescription, Iterator<MeasuringValue>>> resourceMeasurementIterators;
        private final Map<ProcessingResourceSpecification, Map<MetricDescription, MeasuringValue>> nextElement;
        private final Map<ProcessingResourceSpecification, Map<MetricDescription, MeasuringValue>> currentElement;
        private final PriorityQueue<Measure<Double, Duration>> nextIterationTimingQueue;
        private Measure<Double, Duration> currentPointInTime = Measure.valueOf(0.0, SI.SECOND);

        private EvaluationScopeIteratorImpl(
                Map<ProcessingResourceSpecification, Set<IDataStream<MeasuringValue>>> resourceMeasurements) {
            this.resourceMeasurementIterators = InterpreterUtils
                    .createIdentifierMatchingHashMap(resourceMeasurements.size());

            this.currentElement = InterpreterUtils.createIdentifierMatchingHashMap(resourceMeasurements.size());

            this.nextElement = InterpreterUtils.createIdentifierMatchingHashMap(resourceMeasurements.size());

            this.nextIterationTimingQueue = new PriorityQueue<Measure<Double, Duration>>();

            for (Entry<ProcessingResourceSpecification, Set<IDataStream<MeasuringValue>>> measurements : resourceMeasurements
                    .entrySet()) {
                Map<MetricDescription, Iterator<MeasuringValue>> resourceIteratorMap = InterpreterUtils
                        .createIdentifierMatchingHashMap(measurements.getValue().size());

                Map<MetricDescription, MeasuringValue> nextElementMap = InterpreterUtils
                        .createIdentifierMatchingHashMap(measurements.getValue().size());

                Map<MetricDescription, MeasuringValue> currentElementMap = InterpreterUtils
                        .createIdentifierMatchingHashMap(measurements.getValue().size());

                for (IDataStream<MeasuringValue> stream : measurements.getValue()) {
                    Iterator<MeasuringValue> iterator = stream.iterator();
                    resourceIteratorMap.put(stream.getMetricDesciption(), iterator);
                    if (iterator.hasNext()) {
                        MeasuringValue nextValue = iterator.next();
                        this.nextIterationTimingQueue
                                .add(nextValue.<Double, Duration> getMeasureForMetric(POINT_IN_TIME_METRIC));
                        nextElementMap.put(stream.getMetricDesciption(), nextValue);
                    }
                }
                this.resourceMeasurementIterators.put(measurements.getKey(), resourceIteratorMap);
                this.currentElement.put(measurements.getKey(), currentElementMap);
                this.nextElement.put(measurements.getKey(), nextElementMap);
            }

        }

        @Override
        public boolean hasNext() {
            return !nextIterationTimingQueue.isEmpty();
        }

        @Override
        public Map<ProcessingResourceSpecification, Map<MetricDescription, MeasuringValue>> next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("No more elements available.");
            }

            currentPointInTime = nextIterationTimingQueue.poll();

            // If multiple iterators have new values for the same point in time
            // remove all of them
            while (currentPointInTime.equals(nextIterationTimingQueue.peek())) {
                nextIterationTimingQueue.poll();
            }

            for (Entry<ProcessingResourceSpecification, Map<MetricDescription, MeasuringValue>> nextResourceEntry : nextElement
                    .entrySet()) {
                for (Entry<MetricDescription, MeasuringValue> measurementEntry : nextResourceEntry.getValue()
                        .entrySet()) {
                    if (measurementEntry.getValue().<Double, Duration> getMeasureForMetric(POINT_IN_TIME_METRIC)
                            .compareTo(currentPointInTime) <= 0) {

                        // Set current element for metric and resource to measurement of next
                        // element
                        MeasuringValue newValue = nextElement.get(nextResourceEntry.getKey())
                                .get(measurementEntry.getKey());
                        if (newValue != null) {
                            currentElement.get(nextResourceEntry.getKey()).put(measurementEntry.getKey(), newValue);
                        }

                        // If iterator for next element has next, update next element
                        Iterator<MeasuringValue> nextIterator = resourceMeasurementIterators
                                .get(nextResourceEntry.getKey()).get(measurementEntry.getKey());
                        if (nextIterator.hasNext()) {
                            MeasuringValue nextValue = nextIterator.next();
                            nextElement.get(nextResourceEntry.getKey()).put(measurementEntry.getKey(), nextValue);
                            nextIterationTimingQueue
                                    .add(nextValue.<Double, Duration> getMeasureForMetric(POINT_IN_TIME_METRIC));
                        }
                    }
                }
            }
            return this.currentElement;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported by this iterator");

        }

        @Override
        public Measure<Double, Duration> getCurrentPointInTime() {
            return currentPointInTime;
        }
    }

}
