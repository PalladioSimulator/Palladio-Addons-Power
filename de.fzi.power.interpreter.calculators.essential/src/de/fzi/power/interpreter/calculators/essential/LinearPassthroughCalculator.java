package de.fzi.power.interpreter.calculators.essential;

import java.util.Map;

import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;

import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
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
     */
    public LinearPassthroughCalculator(PowerProvidingEntity powerProvidingEntity) {
        super(powerProvidingEntity);
        DistributionPowerBinding binding = this.powerProvidingEntity.getDistributionPowerAssemblyContext();
        if (!binding.getDistributionPowerModel().getId().equals(PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION.getId())) {
            throw new IllegalArgumentException("Referred model wasn't the linear power model from"
                    + PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION.getName() + ".");
        }

        for (FixedFactorValue value : binding.getFixedFactorValues()) {
            if (value.getBoundFactor().getId().equals(PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION_CONSTANT_LOSS.getId())) {
                Unit<Power> unit = value.getValue().getUnit();
                Amount<Power> valueInAmount = Amount.valueOf(value.getValue().doubleValue(unit), unit);
                this.constantLoss = valueInAmount;
            } else {
                throw new IllegalArgumentException("Factor value referred to constant "
                        + value.getBoundFactor().getId() + "that didn't match up wih "
                        + PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION_CONSTANT_LOSS);
            }
        }
    }

    // TODO actually implement this; will involve metamodel changes (added parameters
    @Override
    public Amount<Power> calculate(Map<PowerConsumingEntity, Amount<Power>> outletConsumptions) {
        Amount<Power> sum = PowerModelConstants.ZERO_POWER;
        for (Amount<Power> power : outletConsumptions.values()) {
            sum.plus(power);
        }
        return sum.minus(this.constantLoss);
    }

}
