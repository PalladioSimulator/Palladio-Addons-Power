package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.BinaryOperatorExpression;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.expressions.ExpressionVisitor;
import org.vedantatree.expressionoasis.expressions.IdentifierExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.AddExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.DivideExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.MultiplyExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.SubtractExpression;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.interpreter.calculator.expressionoasis.custom.MeasuredValuesCompositeValueObject;
import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;

/**
 * {@link ExpressionVisitor} implementation to evaluate {@link MeasuredFactorsFoldExpression}s. In
 * particular, this class provides the {@code fold} method that is used to processthe set of
 * measurements.
 * 
 * @author Florian Rosenthal
 *
 */
abstract class EvaluationVisitor implements ExpressionVisitor {

    private Iterable<Double> values;
    private boolean operandsVisited = false;

    /**
     * This method evaluates the {@link MeasuredFactorsFoldExpression}.
     * 
     * @param operand
     *            The operand {@link Expression} of the {@link MeasuredFactorsFoldExpression} to
     *            evaluate.
     * @return
     */
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
                this.values = handleIdentifier((IdentifierExpression) expression);
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
        } else if (binaryExpression instanceof AddExpression) {
            result = handleAdd((AddExpression) binaryExpression);
        } else if (binaryExpression instanceof SubtractExpression) {
            result = handleSubtract((SubtractExpression) binaryExpression);
        } else {
            throw new ExpressionEngineException("Binary expression type " + binaryExpression.getClass().getSimpleName()
                    + " [" + binaryExpression.toString() + "] not yet supported by EvaluationVisitor so far!");
        }
        return result;
    }

    private Iterable<Double> handleDivide(DivideExpression divideExpression) throws ExpressionEngineException {
        List<Double> result = new ArrayList<>();

        ValueObject dividendValue = divideExpression.getLeftOperandExpression().getValue();
        ValueObject divisorValue = divideExpression.getRightOperandExpression().getValue();
        if (ExpressionOasisHelper.hasCompositeType(dividendValue)) {
            Number divisor = (Number) divisorValue.getValue();
            Iterable<Double> dividends = ((MeasuredValuesCompositeValueObject) dividendValue).getValue();
            for (double dividend : dividends) {
                result.add(dividend / divisor.doubleValue());
            }
        } else if (ExpressionOasisHelper.hasCompositeType(divisorValue)) {
            Number dividend = (Number) dividendValue.getValue();
            Iterable<Double> divisors = ((MeasuredValuesCompositeValueObject) divisorValue).getValue();
            for (double divisor : divisors) {
                result.add(dividend.doubleValue() / divisor);
            }
        } else {
            // reduces to a simple '/' operation, just get the value
            result.add((Double) divideExpression.getValue().getValue());
        }
        return result;
    }

    private Iterable<Double> handleSubtract(SubtractExpression subtractExpression) throws ExpressionEngineException {
        List<Double> result = new ArrayList<>();

        ValueObject minuendValue = subtractExpression.getLeftOperandExpression().getValue();
        ValueObject subtrahendValue = subtractExpression.getRightOperandExpression().getValue();
        if (ExpressionOasisHelper.hasCompositeType(minuendValue)) {
            Number subtrahend = (Number) subtrahendValue.getValue();
            Iterable<Double> minuends = ((MeasuredValuesCompositeValueObject) minuendValue).getValue();
            for (double minuend : minuends) {
                result.add(minuend - subtrahend.doubleValue());
            }
        } else if (ExpressionOasisHelper.hasCompositeType(subtrahendValue)) {
            Number minuend = (Number) minuendValue.getValue();
            Iterable<Double> subtrahends = ((MeasuredValuesCompositeValueObject) subtrahendValue).getValue();
            for (double subtrahend : subtrahends) {
                result.add(minuend.doubleValue() - subtrahend);
            }
        } else {
            // reduces to a simple '-' operation, just get the value
            result.add((Double) subtractExpression.getValue().getValue());
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

    private Iterable<Double> handleAdd(AddExpression addExpression) throws ExpressionEngineException {
        List<Double> result = new ArrayList<Double>();
        Iterable<Double> compositeSummand = null;
        Number summand = 0;
        ValueObject leftSummand = addExpression.getLeftOperandExpression().getValue();
        ValueObject rightSummand = addExpression.getRightOperandExpression().getValue();

        if (ExpressionOasisHelper.hasCompositeType(leftSummand)) {
            compositeSummand = ((MeasuredValuesCompositeValueObject) leftSummand).getValue();
            summand = (Number) rightSummand.getValue();
        } else if (ExpressionOasisHelper.hasCompositeType(rightSummand)) {
            compositeSummand = ((MeasuredValuesCompositeValueObject) rightSummand).getValue();
            summand = (Number) leftSummand.getValue();
        }
        if (compositeSummand == null) {
            result.add((double) addExpression.getValue().getValue());
        } else {
            for (double value : compositeSummand) {
                result.add(value + summand.doubleValue());
            }
        }

        return result;
    }

    private Iterable<Double> handleIdentifier(IdentifierExpression identifierExpression) {
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
