package de.fzi.power.interpreter.calculator.expressionoasis;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.PowerBinding;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.interpreter.calculator.expressionoasis.custom.CustomExpressionContext;
import de.fzi.power.specification.DeclarativePowerModelSpecification;

final class InternalExpressionOasisCalculator {

    private final CustomExpressionContext expressionContext;
    private final Expression predictorExpression;

    InternalExpressionOasisCalculator(PowerBinding binding, DeclarativePowerModelSpecification specification) {
        String functionalExpression = Objects.requireNonNull(specification).getFunctionalExpression();
        if (functionalExpression == null || functionalExpression.isEmpty()) {
            throw new IllegalArgumentException(
                    "Function expression of given DeclarativePowerModelSpecification is null or empty!");
        }
        try {
            this.expressionContext = new CustomExpressionContext(binding.getFixedFactorValues(),
                    specification.getConsumptionFactors());
            this.predictorExpression = ExpressionEngine.compileExpression(functionalExpression, this.expressionContext,
                    true);
        } catch (ExpressionEngineException e) {
            throw new RuntimeException(e);
        }
    }

    Amount<Power> calculate(Iterable<MeasuringValue> measuringValues) {
        for (MeasuringValue measurement : measuringValues) {
            this.expressionContext.addBasicMeasurement(measurement);
        }
        Amount<Power> result = calculate();
        this.expressionContext.clearMeasurements();
        return result;
    }

    private Amount<Power> calculate() {
        ValueObject result = null;
        try {
            result = this.predictorExpression.getValue();
        } catch (ExpressionEngineException e) {
            throw new RuntimeException(e);
        }
        double value = this.expressionContext.toDouble(result);
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            value = 0.0;
        }
        return Amount.valueOf(Math.max(value, 0.0), Power.UNIT);
    }

    Amount<Power> calculate(Map<PowerConsumingEntity, Amount<Power>> outletConsumptions) {
        this.expressionContext.addPowerConsumptions(outletConsumptions.values());
        Amount<Power> result = calculate();
        this.expressionContext.clearMeasurements();
        return result;
    }

    Collection<MetricDescription> getMeasuredFactors() {
        return this.expressionContext.getMeasuredFactors();
    }

}
