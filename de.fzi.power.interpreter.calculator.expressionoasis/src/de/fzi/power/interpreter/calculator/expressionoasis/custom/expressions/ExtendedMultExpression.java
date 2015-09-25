package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.arithmatic.MultiplyExpression;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.interpreter.calculator.expressionoasis.custom.CustomExpressionContext;
import de.fzi.power.interpreter.calculator.expressionoasis.custom.MeasuredValuesCompositeValueObject;
import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;

public final class ExtendedMultExpression extends MultiplyExpression {

    static {
        addTypePair(ExtendedMultExpression.class, CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE, Type.DOUBLE,
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE);
        addTypePair(ExtendedMultExpression.class, Type.DOUBLE, CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE,
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE);

        addTypePair(ExtendedMultExpression.class, CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE, Type.INTEGER,
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE);
        addTypePair(ExtendedMultExpression.class, Type.INTEGER, CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE,
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE);
        addTypePair(ExtendedMultExpression.class, CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE, Type.LONG,
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE);
        addTypePair(ExtendedMultExpression.class, Type.LONG, CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE,
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE);

        addTypePair(ExtendedMultExpression.class, Type.DOUBLE, Type.DOUBLE, Type.DOUBLE);
        addTypePair(ExtendedMultExpression.class, Type.LONG, Type.LONG, Type.LONG);
    }

    public ExtendedMultExpression() {
    }

    private Type getLeftOperandType() throws ExpressionEngineException {
        return super.leftOperandExpression.getReturnType();
    }

    private Type getRightOperandType() throws ExpressionEngineException {
        return super.rightOperandExpression.getReturnType();
    }

    @Override
    public Type getReturnType() throws ExpressionEngineException {
        Type returnType = null;
        if (ExpressionOasisHelper.typesEqual(getLeftOperandType(),
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)
                || ExpressionOasisHelper.typesEqual(getRightOperandType(),
                        CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)) {
            returnType = CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE;
        } else {
            returnType = super.getReturnType();
        }
        return returnType;
    }

    @Override
    protected void validate(ExpressionContext expressionContext) throws ExpressionEngineException {
        if (expressionContext instanceof CustomExpressionContext) {
            super.validate(expressionContext);
        } else {
            throw new AssertionError(getClass().getSimpleName() + " only works with "
                    + CustomExpressionContext.class.getSimpleName() + " instances!");
        }
    }

    @Override
    public ValueObject getValue() throws ExpressionEngineException {
        ValueObject result = null;

        Collection<Double> compositeOperand = null;
        Number factor = 0;
        if (ExpressionOasisHelper.typesEqual(getLeftOperandType(),
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)) {
            @SuppressWarnings("unchecked")
            Collection<Double> temp = (Collection<Double>) super.leftOperandExpression.getValue().getValue();
            compositeOperand = temp;
            factor = (Number) super.rightOperandExpression.getValue().getValue();
        } else if (ExpressionOasisHelper.typesEqual(getRightOperandType(),
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)) {
            @SuppressWarnings("unchecked")
            Collection<Double> temp = (Collection<Double>) super.rightOperandExpression.getValue().getValue();
            compositeOperand = temp;
            factor = (Number) super.leftOperandExpression.getValue().getValue();
        }
        if (compositeOperand != null) {
            List<Double> resultValues = new ArrayList<>();
            double factorValue = factor.doubleValue();
            for (double operand : compositeOperand) {
                resultValues.add(factorValue * operand);
            }
            result = new MeasuredValuesCompositeValueObject(resultValues);
        } else {
            result = super.getValue();
        }
        return result;
    }
}
