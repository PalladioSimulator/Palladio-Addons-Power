package de.fzi.power.interpreter.measureprovider;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.configurable.IPropertyConfigurable;
import org.palladiosimulator.metricspec.MetricDescription;

import de.fzi.power.interpreter.EvaluationScope;
import de.fzi.power.interpreter.InterpreterUtils;

/**
 * ExtendedMeasureProviders allow to extend the {@link EvaluationScope} with the capability to
 * automatically create additional metrics potentially from other existing metrics.
 */
public abstract class ExtendedMeasureProvider implements IPropertyConfigurable {

    /**
     * Gets a collection of the sets of metrics the measure provider requires to be able to provide
     * the additional target metrics. Since it is conceivable that a provider is capable to deal
     * with different source metrics (or metric combinations) combinations to provide its results
     * this method returns a collection of sets.<br>
     * For instance, if a provider requires two metrics at the same time to provide its results, a
     * collection with a set of these two should be returned. In contrast, if the provider needs
     * only either of the two, a collection of two singleton sets should be returned here. In case,
     * no input metrics are required, the resulting collection should contain empty or contain a
     * single, empty set.
     *
     * @return A {@link Collection} of the sets of required source metrics.
     */
    public abstract Collection<Set<MetricDescription>> getSourceMetrics();

    protected abstract Collection<Set<String>> getSourceMetricIds();

    /**
     * Gets the set of metrics the measure provider has to offer in case all of the source metrics
     * requirements are satisfied.
     *
     * @return the set of target metrics
     */
    public abstract Set<MetricDescription> getTargetMetrics();

    /**
     * Gets a {@link IDataSource} which contains the new metrics.
     * 
     * @param availableDataSources
     *            the available data sources
     * @return the respective IDataSource
     */
    public abstract IDataSource getDataSource(Set<IDataSource> availableDataSources);

    /**
     * Given the set of {@code availableDataSources} the method returns true, iff the provider is
     * able to provide the desired metric.
     *
     * @param desiredMetric
     *            the desired metric
     * @param availableSourceMetrics
     *            the available data sources
     * @return true, if metric is available
     * @throws NullPointerException
     *             In case either argument is {@code null}.
     */
    public boolean canProvideMetric(final MetricDescription desiredMetric,
            Collection<MetricDescription> availableSourceMetrics) {
        Objects.requireNonNull(desiredMetric, "Desired target metric must not be null.");
        Objects.requireNonNull(availableSourceMetrics, "Set of available source metrics must not be null.");
        if(getSourceMetrics().isEmpty()) {
        	return true;
        }
        if (getTargetMetrics().stream()
                .anyMatch(metric -> InterpreterUtils.isRequiredMetricSatisfiedBy(desiredMetric, metric))) {
            Collection<String> metricIds = availableSourceMetrics.stream().map(MetricDescription::getId)
                    .collect(Collectors.toList());
            return getSourceMetricIds().stream().anyMatch(metricIds::containsAll);
        }
        return false;
    }
}