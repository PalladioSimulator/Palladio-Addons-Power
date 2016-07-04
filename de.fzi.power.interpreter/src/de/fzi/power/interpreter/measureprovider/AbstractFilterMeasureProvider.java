package de.fzi.power.interpreter.measureprovider;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.filter.AbstractFilter;
import org.palladiosimulator.metricspec.MetricDescription;

/**
 * Subclass that encapsulates an {@link AbstractFilter} as measure provider. Therefore it only
 * supports the combination of a single input and a single output metric.<br>
 * Yet, it is possible that more than one metric can be used as input.
 * 
 * The measure provider relays property configuration to the encapsulated filter.
 * 
 * @author Sebastian Krach, Florian Rosenthal
 *
 */
public abstract class AbstractFilterMeasureProvider extends ExtendedMeasureProvider {

    private final AbstractFilter filter;

    public AbstractFilterMeasureProvider(AbstractFilter filter) {
        this.filter = Objects.requireNonNull(filter, "Filter to use must not be null.");
    }

    /**
     * To be implemented by subclasses in order to specify the supported output metric.
     * 
     * @return A {@link MetricDescription} denoting the output metric.
     */
    protected abstract MetricDescription getTargetMetric();

    /**
     * To be implemented by the subclasses: Each element specifies an allowed input metric.
     * 
     * @return A collection of the different supported input metrics, mapped by their corresponding
     *         ids. <br>
     *         For each contained metric it should hold that: <br>
     *         {@code filter.canAccept(dataSource) == true <=> this.getSourceMetrics().contains(dataSource.getMetricDescription())}
     *         , where {@code filter} is the {@link AbstractFilter} associated with this instance.
     */
    protected abstract Map<String, MetricDescription> getAllowedSourceMetrics();

    /**
     * Gets the different metrics that can be used as input metrics.
     * 
     * @return A {@link Collection} of singleton sets of {@link MetricDescription}s, each of which
     *         containing an allowed input metric.
     */
    @Override
    public final Collection<Set<MetricDescription>> getSourceMetrics() {
        return getAllowedSourceMetrics().values().stream().map(Collections::singleton).collect(Collectors.toList());
    }

    /**
     * Gets the ids of the different metrics that can be used as input metrics.
     * 
     * @return A {@link Collection} of singleton sets of Strings, each of which containing an id of
     *         an allowed input metric.
     */
    @Override
    protected final Collection<Set<String>> getSourceMetricIds() {
        return getAllowedSourceMetrics().keySet().stream().map(Collections::singleton).collect(Collectors.toList());
    }

    /**
     * @return Since instances of this class do only support one output metric, this method simply
     *         returns {@code Collections.singleton(getTargetMetric()).}
     */
    @Override
    public final Set<MetricDescription> getTargetMetrics() {
        return Collections.singleton(getTargetMetric());
    }

    @Override
    public IDataSource getDataSource(Set<IDataSource> availableDataSources) {
        for (IDataSource source : availableDataSources) {
            if (filter.canAccept(source)) {
                filter.setDataSource(source);
                return filter;
            }
        }
        return null;
    }

    @Override
    public Set<String> getKeys() {
        return filter.getKeys();
    }

    @Override
    public Class<?> getPropertyType(String key) {
        return filter.getPropertyType(key);
    }

    @Override
    public Map<String, Object> getProperties() {
        return filter.getProperties();
    }

    @Override
    public void setProperties(Map<String, Object> properties) {
        filter.setProperties(properties);
    }

    @Override
    public Map<? extends String, ? extends Object> getDefaultConfiguration() {
        return filter.getDefaultConfiguration();
    }

    @Override
    public boolean isPropertyNotSet(String key) {
        return filter.isPropertyNotSet(key);
    }

    @Override
    public void unsetProperty(String key) {
        filter.unsetProperty(key);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(Class adapter) {
        return filter.getAdapter(adapter);
    }
}
