package de.fzi.power.interpreter.calculator.expressionoasis;

import java.util.Map;
import java.util.Objects;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;

import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.specification.DeclarativePowerModelSpecification;

/**
 * This class is an {@link AbstractDistributionPowerModelCalculator} that makes use of the
 * ExpressionOasis library to calculate the power consumption of {@link PowerProvidingEntity}s whose
 * behavior is specified by {@link DeclarativePowerModelSpecification}s.
 * 
 * @see CalculatorFactoryImpl
 * @author Florian Rosenthal
 *
 */
public class ExpressionOasisDistributionPowerModelCalculator extends AbstractDistributionPowerModelCalculator {

    private final InternalExpressionOasisCalculator calculator;

    /**
     * Initializes a new instance of the {@link ExpressionOasisDistributionPowerModelCalculator}.
     * 
     * @param powerProvidingEntity
     *            The {@link PowerProvidingEntity} whose consumption shall be calculated.
     * @throws NullPointerException
     *             In case the given argument is {@code null}.
     */
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
