package de.fzi.power.interpreter.measureprovider;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.filter.AbstractFilter;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;

/**
 * Subclass that encapsulates an {@link AbstractFilter} as measure provider. Therefore it 
 * only supports exactly one input and one output metric.
 * 
 * The measure provider relays property configuration to the encapsulated filter.
 * 
 * @author Sebastian Krach
 *
 */
public abstract class AbstractFilterMeasureProvider extends ExtendedMeasureProvider {
    
    private final AbstractFilter filter;

    public AbstractFilterMeasureProvider(AbstractFilter filter) {
        this.filter = filter;
    }
    
    protected abstract MetricDescription getSourceMetric();
    
    protected abstract MetricDescription getTargetMetric();
    
    @Override
    public Set<MetricDescription> getSourceMetrics() {
        return Collections.<MetricDescription> singleton(getSourceMetric());
    }

    @Override
    public Set<MetricDescription> getTargetMetrics() {
        return Collections.<MetricDescription> singleton(getTargetMetric());
    }

    
    @Override
    public IDataStream<MeasuringValue> getDataStream(Set<IDataSource> availableDataSources)  {
        for (IDataSource source : availableDataSources) {
            if (source.getMetricDesciption().equals(getSourceMetric())) {
                filter.setDataSource(source);
                return filter.getDataStream();
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
