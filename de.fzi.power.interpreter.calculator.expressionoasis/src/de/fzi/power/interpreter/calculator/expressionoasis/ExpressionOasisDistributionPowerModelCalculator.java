package de.fzi.power.interpreter.calculator.expressionoasis;

import java.util.Map;
import java.util.Objects;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;

import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.specification.DeclarativePowerModelSpecification;

public class ExpressionOasisDistributionPowerModelCalculator extends AbstractDistributionPowerModelCalculator {

    private final InternalExpressionOasisCalculator calculator;

    ExpressionOasisDistributionPowerModelCalculator(PowerProvidingEntity powerProvidingEntity) {
        super(Objects.requireNonNull(powerProvidingEntity));
        this.calculator = new InternalExpressionOasisCalculator(
                powerProvidingEntity.getDistributionPowerAssemblyContext(),
                (DeclarativePowerModelSpecification) powerProvidingEntity.getDistributionPowerAssemblyContext()
                        .getDistributionPowerModel());
    }

    @Override
    public Amount<Power> calculate(Map<PowerConsumingEntity, Amount<Power>> outletConsumptions) {
        return this.calculator.calculate(Objects.requireNonNull(outletConsumptions));
    }

}
