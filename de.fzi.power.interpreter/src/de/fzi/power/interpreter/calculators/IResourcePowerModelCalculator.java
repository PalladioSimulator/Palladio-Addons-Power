package de.fzi.power.interpreter.calculators;

import java.util.Collection;
import java.util.Set;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;

public interface IResourcePowerModelCalculator {

    /**
     * Evaluates the power consumption of a resource using a set of measurements collected for
     * the resource.
     * @param list The list of collected measurements.
     * @return The power consumption.
     */
    Amount<Power> calculate(Collection<MeasuringValue> list);

    /**
     * Returns the set of metrics for which this calculator needs measurements to be able to 
     * calculate the power consumption. 
     * @return The set of required metric descriptions.
     */
    Set<MetricDescription> getInputMetrics();

}