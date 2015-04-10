package de.fzi.power.interpreter;

import java.util.Iterator;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Duration;

import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * The interface EvaluationScopeIterator encapsulated the Iterator specification for the 
 * {@link AbstractEvaluationScope} class. It allows to iterate the Scope and returns the 
 * current element as {@link Map} linking {@link Measurement}s first to the {@link MetricDescription} 
 * of the {@link IDataSource} they originate, second to the {@link ProcessingResourceSpecification} 
 * the Measurement was taken at.
 * 
 * @author Sebastian Krach
 *
 */
public interface EvaluationScopeIterator extends Iterator<Map<ProcessingResourceSpecification, Map<MetricDescription,MeasuringValue>>>{

    /**
     * Returns the point in time of the most recent measurement in the set returned 
     * last call to {@link EvaluationScopeIterator}.next();
     * 
     * @return the most recent point in time
     */
    public Measure<Double, Duration> getCurrentPointInTime();
    
}
