package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.BinaryOperatorExpression;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.expressions.ExpressionVisitor;
import org.vedantatree.expressionoasis.expressions.IdentifierExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.DivideExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.MultiplyExpression;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.interpreter.calculator.expressionoasis.custom.MeasuredValuesCompositeValueObject;
import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;

abstract class EvaluationVisitor implements ExpressionVisitor {

    private Iterable<Double> values;
    private boolean operandsVisited = false;

    final ValueObject evaluate(Expression operand) {
        reset();
        operand.accept(this);
        return new ValueObject(fold(this.values), Type.DOUBLE);
    }

    protected abstract double fold(Iterable<Double> values);

    private void reset() {
        this.values = Collections.emptyList();
        this.operandsVisited = false;
    }

    @Override
    public void visit(Expression expression) {
        if (!this.operandsVisited) {
            if (expression instanceof IdentifierExpression) {
                this.values = internalVisit((IdentifierExpression) expression);
                this.operandsVisited = false;
            } else if (expression instanceof BinaryOperatorExpression) {
                try {
                    this.values = internalVisit((BinaryOperatorExpression) expression);
                    this.operandsVisited = true;
                } catch (ExpressionEngineException e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.values = internalVisitDefault(expression);
                this.operandsVisited = true;
            }
        }
    }

    private Iterable<Double> internalVisitDefault(Expression expression) {
        ValueObject valueObject = null;
        try {
            valueObject = expression.getValue();
        } catch (ExpressionEngineException e) {
            throw new RuntimeException(e);
        }
        if (ExpressionOasisHelper.hasCompositeType(valueObject)) {
            return ((MeasuredValuesCompositeValueObject) valueObject).getValue();
        }
        return Collections.singletonList((double) valueObject.getValue());
    }

    private Iterable<Double> internalVisit(BinaryOperatorExpression binaryExpression) throws ExpressionEngineException {
        Iterable<Double> result = null;
        if (binaryExpression instanceof MultiplyExpression) {
            result = handleMultiply((MultiplyExpression) binaryExpression);
        } else if (binaryExpression instanceof DivideExpression) {
            result = handleDivide((DivideExpression) binaryExpression);
        }
        return result;
    }

    private Iterable<Double> handleDivide(DivideExpression divideExpression) throws ExpressionEngineException {
        List<Double> result = new ArrayList<>();

        ValueObject dividendValue = divideExpression.getLeftOperandExpression().getValue();
        if (ExpressionOasisHelper.hasCompositeType(dividendValue)) {
            Number divisor = (Number) divideExpression.getRightOperandExpression().getValue().getValue();
            Iterable<Double> measuredValues = ((MeasuredValuesCompositeValueObject) dividendValue).getValue();
            for (double measuredValue : measuredValues) {
                result.add(measuredValue / divisor.doubleValue());
            }
        } else {
            result.add((Double) divideExpression.getValue().getValue());
        }
        return result;
    }

    private Iterable<Double> handleMultiply(MultiplyExpression multiplyExpression) throws ExpressionEngineException {
        List<Double> result = new ArrayList<>();
        Iterable<Double> compositeOperand = null;
        Number factor = 0;
        ValueObject leftOperandValue = multiplyExpression.getLeftOperandExpression().getValue();
        ValueObject rightOperandValue = multiplyExpression.getRightOperandExpression().getValue();

        if (ExpressionOasisHelper.hasCompositeType(leftOperandValue)) {
            compositeOperand = ((MeasuredValuesCompositeValueObject) leftOperandValue).getValue();
            factor = (Number) rightOperandValue.getValue();
        } else if (ExpressionOasisHelper.hasCompositeType(rightOperandValue)) {
            compositeOperand = ((MeasuredValuesCompositeValueObject) rightOperandValue).getValue();
            factor = (Number) leftOperandValue.getValue();
        }
        if (compositeOperand == null) {
            result.add((double) multiplyExpression.getValue().getValue());
        } else {
            for (double value : compositeOperand) {
                result.add(value * factor.doubleValue());
            }
        }
        return result;
    }

    private Iterable<Double> internalVisit(IdentifierExpression identifierExpression) {
        ValueObject valueObject = null;
        try {
            valueObject = identifierExpression.getValue();
        } catch (ExpressionEngineException e) {
            throw new RuntimeException(e);
        }
        if (ExpressionOasisHelper.hasCompositeType(valueObject)) {
            return ((MeasuredValuesCompositeValueObject) valueObject).getValue();
        }
        return Collections.singletonList((double) valueObject.getValue());
    }
}
