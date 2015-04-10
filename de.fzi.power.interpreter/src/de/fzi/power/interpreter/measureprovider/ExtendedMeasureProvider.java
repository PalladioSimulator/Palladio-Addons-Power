package de.fzi.power.interpreter.measureprovider;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Predicate;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.configurable.IPropertyConfigurable;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;

import de.fzi.power.interpreter.EvaluationScope;
import de.fzi.power.interpreter.InterpreterUtils;

/**
 * ExtendedMeasureProvider allow to extend the {@link EvaluationScope} with 
 * the capability to automatically create additional metrics potentially from
 * other existing metrics.
 */
public abstract class ExtendedMeasureProvider implements IPropertyConfigurable {

    /**
     * Gets the set of metrics the measure provider requires to be able to 
     * provide the additional target metrics. If the provider does not need
     * any input metrics this set is empty.
     *
     * @return the set of source metrics
     */
    public abstract Set<MetricDescription> getSourceMetrics();

    /**
     * Gets the set of metrics the measure provider has to offer in case all of the
     * source metrics requirements are satisfied.
     *
     * @return the set of target metrics
     */
    public abstract Set<MetricDescription> getTargetMetrics();

    /**
     * Gets a {@link IDataStream} which contains the new metrics. For each of the required 
     * source metrics there has to be one {@link IDataSource} which provides values for it.
     *
     * @param availableDataSources the available data sources
     * @return the resulting data stream
     */
    public abstract IDataStream<MeasuringValue> getDataStream(Set<IDataSource> availableDataSources);
    
    
    /**
     * Given the set of {@code availableDataSources} the method returns true, iff the provider is 
     * able to provide the desired metric.
     *
     * @param desiredMetric the desired metric
     * @param availableDataSources the available data sources
     * @return true, if metric is available
     */
    public boolean canProvideMetric(final MetricDescription desiredMetric, Set<IDataSource> availableDataSources) {
        MetricDescription target = CollectionUtils.find(getTargetMetrics(), new Predicate<MetricDescription>() {
            @Override
            public boolean evaluate(MetricDescription arg0) {
                return InterpreterUtils.isRequiredMetricSatisfiedBy(desiredMetric, arg0);
            }
        });

        if (target == null) {
            return false;
        }

        Set<MetricDescription> availableMetrics = new HashSet<MetricDescription>();
        for (IDataSource source : availableDataSources) {
            availableMetrics.add(source.getMetricDesciption());
        }

        return CollectionUtils.isSubCollection(getSourceMetrics(), availableMetrics);
    }
}