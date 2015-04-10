package de.fzi.power.interpreter.measureprovider.utilization;

import org.palladiosimulator.experimentanalysis.utilizationfilter.UtilizationFilter;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.interpreter.measureprovider.AbstractFilterMeasureProvider;

/**
 * Extended measure provider which is able to calculate measures for the metric
 * {@link MetricDescriptionConstants}.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE based on  
 * {@link MetricDescriptionConstants}.STATE_OF_ACTIVE_RESOURCE_METRIC_TUPLE 
 * measurements.
 * 
 * @author Sebastian Krach
 *
 */
public class UtilizationFilterMeasureProvider extends AbstractFilterMeasureProvider {

    /**
     * Creates a new UtilizationFilterMeasureProvider
     */
    public UtilizationFilterMeasureProvider() {
        super(new UtilizationFilter());
    }
    
    @Override
    protected MetricDescription getSourceMetric() {
        return MetricDescriptionConstants.STATE_OF_ACTIVE_RESOURCE_METRIC_TUPLE;
    }

    @Override
    protected MetricDescription getTargetMetric() {
        return MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE;
    }
    
}
