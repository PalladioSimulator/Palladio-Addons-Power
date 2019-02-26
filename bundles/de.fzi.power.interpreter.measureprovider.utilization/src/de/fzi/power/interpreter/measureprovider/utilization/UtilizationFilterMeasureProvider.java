package de.fzi.power.interpreter.measureprovider.utilization;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.experimentanalysis.utilizationfilter.UtilizationFilter;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.interpreter.measureprovider.AbstractFilterMeasureProvider;

/**
 * Extended measure provider which is able to calculate measures for the metric
 * {@link MetricDescriptionConstants}.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE based on
 * {@link MetricDescriptionConstants}.STATE_OF_ACTIVE_RESOURCE_METRIC_TUPLE or
 * {@link MetricDescriptionConstants}.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE (for multi-core
 * resources) measurements.
 * 
 * @author Sebastian Krach, Florian Rosenthal
 *
 */
public class UtilizationFilterMeasureProvider extends AbstractFilterMeasureProvider {

    private static final Map<String, MetricDescription> SOURCE_METRIC_OPTIONS = new HashMap<>();

    static {
        SOURCE_METRIC_OPTIONS.put(MetricDescriptionConstants.STATE_OF_ACTIVE_RESOURCE_METRIC_TUPLE.getId(),
                MetricDescriptionConstants.STATE_OF_ACTIVE_RESOURCE_METRIC_TUPLE);
        SOURCE_METRIC_OPTIONS.put(MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE.getId(),
                MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE);
    }

    /**
     * Creates a new UtilizationFilterMeasureProvider
     */
    public UtilizationFilterMeasureProvider() {
        super(new UtilizationFilter());
    }

    @Override
    protected Map<String, MetricDescription> getAllowedSourceMetrics() {
        return SOURCE_METRIC_OPTIONS;
    }

    @Override
    protected MetricDescription getTargetMetric() {
        return MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE;
    }

}
