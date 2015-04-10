package de.fzi.power.interpreter.calculators;

import java.util.Collection;
import java.util.Set;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;

import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.PowerConsumingResource;

/**
 * Calculator responsible for evaluating the power consumption of a {@link PowerConsumingResource}.
 * @author stier
 *
 */
public abstract class AbstractResourcePowerModelCalculator {
	protected PowerConsumingResource powerConsumingResource;
	protected ResourcePowerBinding binding;
	
	/**
	 * Create the power model calculator for a passed power-consuming resource.
	 * @param powerConsumingResource The resource for which the calculator is created.
	 */
	public AbstractResourcePowerModelCalculator(PowerConsumingResource powerConsumingResource) {
		this.powerConsumingResource = powerConsumingResource;
		binding = this.powerConsumingResource.getResourcePowerAssemblyContext();
	}
	
	/**
	 * Evaluates the power consumption of a resource using a set of measurements collected for
	 * the resource.
	 * @param list The list of collected measurements.
	 * @return The power consumption.
	 */
	public abstract Amount<Power> calculate(Collection<MeasuringValue> list);
	
	/**
	 * Returns the set of metrics for which this calculator needs measurements to be able to 
	 * calculate the power consumption. 
	 * @return The set of required metric descriptions.
	 */
	public abstract Set<MetricDescription> getInputMetrics();
}
