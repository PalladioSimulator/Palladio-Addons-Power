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
     * Gets a {@link IDataSource} which contains the new metrics.
     * 
     * @param availableDataSources the available data sources
     * @return the respective IDataSource
     */
    public abstract IDataSource getDataSource(Set<IDataSource> availableDataSources);
    
    
    /**
     * Given the set of {@code availableDataSources} the method returns true, iff the provider is 
     * able to provide the desired metric.
     *
     * @param desiredMetric the desired metric
     * @param set the available data sources
     * @return true, if metric is available
     */
    public boolean canProvideMetric(final MetricDescription desiredMetric, Set<MetricDescription> availableSourceMetrics) {
        //Check if the desired metric is element of the output metrics
        MetricDescription target = CollectionUtils.find(getTargetMetrics(), new Predicate<MetricDescription>() {
            @Override
            public boolean evaluate(MetricDescription arg0) {
                return InterpreterUtils.isRequiredMetricSatisfiedBy(desiredMetric, arg0);
            }
        });

        //if not, this is the wrong provider
        if (target == null) {
            return false;
        }

        //Check if required input metrics are provided 
        return CollectionUtils.isSubCollection(getSourceMetrics(), availableSourceMetrics);
    }
}