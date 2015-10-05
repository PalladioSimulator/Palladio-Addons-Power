package de.fzi.power.interpreter.calculator.expressionoasis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;

import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.specification.DeclarativePowerModelSpecification;

/**
 * This class is an {@link AbstractResourcePowerModelCalculator} that makes use of the
 * ExpressionOasis library to calculate the power consumption of {@link PowerConsumingResource}s
 * whose behavior is specified by {@link DeclarativePowerModelSpecification}s.
 * 
 * @see CalculatorFactoryImpl
 * @author Florian Rosenthal
 *
 */
public class ExpressionOasisResourcePowerModelCalculator extends AbstractResourcePowerModelCalculator {

    private final InternalExpressionOasisCalculator calculator;

    /**
     * Initializes a new instance of the {@link ExpressionOasisResourcePowerModelCalculator}.
     * 
     * @param powerConsumingResource
     *            The {@link PowerConsumingResource} whose consumption shall be calculated.
     * @throws NullPointerException
     *             In case the given argument is {@code null}.
     */
    ExpressionOasisResourcePowerModelCalculator(PowerConsumingResource powerConsumingResource) {
        super(Objects.requireNonNull(powerConsumingResource));

        this.calculator = new InternalExpressionOasisCalculator(super.binding,
                (DeclarativePowerModelSpecification) super.binding.getResourcePowerModelSpecification());
    }

    @Override
    public Set<MetricDescription> getInputMetrics() {
        return new HashSet<MetricDescription>(this.calculator.getMeasuredFactors());
    }

    @Override
    public Amount<Power> calculate(Collection<MeasuringValue> list) {
        return this.calculator.calculate(Objects.requireNonNull(list));
    }
}
