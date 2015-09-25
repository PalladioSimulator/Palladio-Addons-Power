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

public class ExpressionOasisResourcePowerModelCalculator extends AbstractResourcePowerModelCalculator {

    private final InternalExpressionOasisCalculator calculator;

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
