package de.fzi.power.interpreter;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.measure.Measure;

import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

import de.fzi.power.interpreter.measureprovider.ExtendedMeasureProvider;

// TODO: Auto-generated Javadoc
// TODO extract abstract super class allowing to use a simulation-time scope and an analytical scope.
/**
 * This class represents the scope under which the energy consumption of a software system is
 * evaluated. It subsumes a set of measurements or probes on the measurement. Specifically, a set of
 * {@link MetricDescriptionConstants.STATE_OF_ACTIVE_RESOURCE_METRIC_TUPLE} on resources is
 * translated into a set of discrete evaluations on the utilization.
 * 
 * @author stier, Florian Rosenthal, Sebastian Krach
 *
 */

public final class EvaluationScope extends AbstractEvaluationScope {


    /** The available measurements. */
    private final Map<ProcessingResourceSpecification, Set<IDataSource>> availableMeasurements;
    
    /** The extended measure providers. */
    private final Set<ExtendedMeasureProvider> extendedMeasureProviders;

    /**
     * Construct an empty evaluation scope. Please refer to
     * {@link EvaluationScope#createScope(List, Measure, Measure)}.
     */
    private EvaluationScope() {
        this.availableMeasurements = 
                InterpreterUtils.<ProcessingResourceSpecification, Set<IDataSource>>createIdentifierMatchingHashMap();
        this.extendedMeasureProviders = new HashSet<ExtendedMeasureProvider>();
    }

     /**
     * Creates an evaluation scope for which the energy consumption of a software system is
     * evaluated. The scope is created for a set of available {@code experimentMeasures}.
     *
     * @param experimentMeasurements set of measurement sources each 
     *            collected on an active resource within the system.
     * @param extendedMeasureProviders set of extended measurement providers, allowing to
     *              derive one metric from another (e.g.
     *              {@link MetricDescriptionConstants}.UTILIZATION_TUPLE measurements from
     *              {@link MetricDescriptionConstants}.STATE_OF_ACTIVE_RESOURCE_TUPLE
     *              measurements)
     *              
     * @return The created scope representing the context for the energy consumption evaluation.
     */
    public static EvaluationScope createScope(Iterable<IDataSource> experimentMeasurements,
            Set<ExtendedMeasureProvider> extendedMeasureProviders) {

        EvaluationScope scope = new EvaluationScope();

        for (IDataSource source : experimentMeasurements) {
            ProcessingResourceSpecification spec = 
                    InterpreterUtils.PCMMEASURINGPOINT_SWITCH.doSwitch(source.getMeasuringPoint());
            if (spec != null) {
                Set<IDataSource> sources = scope.availableMeasurements.get(spec);
                if (sources == null) {
                    sources = new HashSet<IDataSource>();
                    
                    scope.availableMeasurements.put(spec, sources);
                    scope.resourceMeasurements.put(spec, new HashSet<IDataStream<MeasuringValue>>());
                }
                
                sources.add(source);
            }
        }
        
        scope.extendedMeasureProviders.addAll(extendedMeasureProviders);

        scope.reset();
        return scope;
    }

    
    /**
     * Resets the context to its initial state.
     * @see EvaluationScope#next()
     */
    @Override
    public void reset() {
        this.iterator = this.iterator();
    }
    
         
    /* (non-Javadoc)
     * @see de.fzi.power.interpreter.AbstractEvaluationScope#setResourceMetricsToEvaluate(java.util.Map)
     */
    @Override
    public void setResourceMetricsToEvaluate(Map<ProcessingResourceSpecification, Set<MetricDescription>> metricsMap) {
        for (Entry<ProcessingResourceSpecification, Set<MetricDescription>> entry : metricsMap.entrySet()) {
            Set<IDataSource> availableSourcesForResource = availableMeasurements.get(entry.getKey());

            for (MetricDescription desc : entry.getValue()) {
                boolean handled = false;
                for (IDataSource source : availableSourcesForResource) {         
                    if (InterpreterUtils.isRequiredMetricSatisfiedBy(desc, source.getMetricDesciption())) {
                        this.resourceMeasurements.get(entry.getKey()).add(
                                source.<MeasuringValue>getDataStream());
                        handled = true;
                        break;
                    } 
                }
                
                if (!handled) {
                    for (ExtendedMeasureProvider prov : extendedMeasureProviders) {
                        if (prov.canProvideMetric(desc, availableSourcesForResource)) {
                            this.resourceMeasurements.get(entry.getKey()).add(
                                    prov.getDataStream(availableSourcesForResource));
                            handled = true;
                            break;
                        }
                    }
                }
                
                if (!handled) {
                    throw new IllegalArgumentException("No data source available for processing resource " + 
                            entry.getKey() + " for the metric: " + desc.getName());
                }
            }
        }
        this.reset();
    }
    

}
