package de.fzi.power.interpreter.calculators;

import java.util.Map;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;

import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.specification.DistributionPowerModelSpecification;

/**
 * Subsumes a calculator responsible for evaluating the power consumption of a
 * {@link DistributionPowerModelSpecification}.
 * 
 * @author stier
 *
 */
public abstract class AbstractDistributionPowerModelCalculator {

    // The binding for which the calculator evaluates the power consumption.
    DistributionPowerBinding binding;

    /**
     * Creates a calculator for a distribution power model that is associated with a
     * {@link PowerProvidingEntity}.
     * 
     * @param powerProvidingEntity
     *            The entity for which the distribution power model is created.
     */
    public AbstractDistributionPowerModelCalculator(DistributionPowerBinding binding) {
        this.binding = binding;
    }

    /**
     * Calculates the power consumption based on the power consumption measured or evaluated for a
     * set of outlets of the {@link PowerProvidingEntity}.
     * 
     * @param outletConsumptions
     *            The consumptions measured/evaluated at the outlets of a set of connected entities.
     * @return The consumption predicted by the calculator.
     */
    public abstract Amount<Power> calculate(Map<PowerConsumingEntity, Amount<Power>> outletConsumptions);

}
