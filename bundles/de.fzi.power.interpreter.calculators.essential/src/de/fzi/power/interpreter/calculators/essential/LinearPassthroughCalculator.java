package de.fzi.power.interpreter.calculators.essential;

import java.util.Map;
import java.util.Objects;

import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jscience.physics.amount.Amount;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.resources.PowerModelConstants;

/**
 * A calculator that calculates the power consumption of a {@link PowerProvidingEntity} by summing
 * up the power consumption of all nested elements.
 * 
 * @author stier
 *
 */
public class LinearPassthroughCalculator extends AbstractDistributionPowerModelCalculator {

    // TODO add loss constant factors
    private Amount<Power> constantLoss;

    /**
     * Creates an {@link AbstractDistributionPowerModelCalculator} that calculates the power
     * consumption of a {@link PowerProvidingEntity} by summing up the power consumption of its
     * {@link PowerProvidingEntity#getNestedPowerConsumingEntities()}.
     * 
     * @param powerProvidingEntity
     *            The entity for which the calculator is created.
     * @throws NullPointerException
     *             In case the required {@link FixedFactor} is not set.
     */
    public LinearPassthroughCalculator(final DistributionPowerBinding binding) {
        super(binding);
        if (!binding.getDistributionPowerModel().getId()
                .equals(PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION.getId())) {
            throw new IllegalArgumentException("Referred model wasn't the linear power model from"
                    + PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION.getName() + ".");
        }

        for (FixedFactorValuePower value : EcoreUtil.<FixedFactorValuePower>getObjectsByType(binding.getFixedFactorValues(), BindingPackage.eINSTANCE.getFixedFactorValuePower())) {
            if (value.getBoundFactor().getId()
                    .equals(PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION_CONSTANT_LOSS.getId())) {
                Unit<Power> unit = value.getValue().getUnit();
                Amount<Power> valueInAmount = Amount.valueOf(value.getValue().doubleValue(unit), unit);
                this.constantLoss = valueInAmount;
            } else {
                throw new IllegalArgumentException("Factor value referred to constant " + value.getBoundFactor().getId()
                        + "that didn't match up with "
                        + PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION_CONSTANT_LOSS);
            }
        }
        Objects.requireNonNull(this.constantLoss,
                "FixedFactor '" + PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION_CONSTANT_LOSS + "' not set!");
    }

    @Override
    public Amount<Power> calculate(Map<PowerConsumingEntity, Amount<Power>> outletConsumptions) {
        Amount<Power> sum = PowerModelConstants.ZERO_POWER;
        for (Amount<Power> power : outletConsumptions.values()) {
            sum = sum.plus(power);
        }
        return sum.minus(this.constantLoss);
    }

}
