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
 * Calculator responsible for evaluating the power consumption of a {@link ResourcePowerBinding}.
 * @author stier
 *
 */
public abstract class AbstractResourcePowerModelCalculator implements IResourcePowerModelCalculator {
	protected ResourcePowerBinding binding;
	
	/**
	 * Create the power model calculator for a passed power-consuming resource.
	 * @param powerConsumingResource The resource for which the calculator is created.
	 */
	public AbstractResourcePowerModelCalculator(final ResourcePowerBinding binding) {
	    this.binding = binding;
	}
	
	/* (non-Javadoc)
     * @see de.fzi.power.interpreter.calculators.IResourcePowerModelCalculator#calculate(java.util.Collection)
     */
	@Override
    public abstract Amount<Power> calculate(Collection<MeasuringValue> list);
	
	/* (non-Javadoc)
     * @see de.fzi.power.interpreter.calculators.IResourcePowerModelCalculator#getInputMetrics()
     */
	@Override
    public abstract Set<MetricDescription> getInputMetrics();
}
