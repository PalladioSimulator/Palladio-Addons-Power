package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.extensions.FunctionProvider;
import org.vedantatree.expressionoasis.grammar.Grammar;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;

public final class CustomFunctionProvider implements FunctionProvider {

    private static final String MULT = "MULT";
    private static final String SUM = "SUM";
    private static final String POW = "POW";

    private static final List<String> KNOWN_FUNCTIONS = Arrays.asList(SUM, MULT, POW);

    public CustomFunctionProvider() {
    }

    @Override
    public void initialize(ExpressionContext expressionContext) throws ExpressionEngineException {
        Grammar grammar = ExpressionEngine.getGrammar();
        for (String function : KNOWN_FUNCTIONS) {
            grammar.addFunction(function);
        }
    }

    @Override
    public Type getFunctionType(String functionName, Type[] parameterTypes) throws ExpressionEngineException {
        Type resultType = null;
        if (supportsFunction(functionName, parameterTypes)) {
            if (functionName.equals(POW) && !ExpressionOasisHelper.typesEqual(parameterTypes[0],
                    CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)) {
                resultType = CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE;
            } else {
                resultType = Type.DOUBLE;
            }
        }
        return resultType;
    }

    private ValueObject evaluateSum(ValueObject[] parameters) {
        assert parameters != null && parameters.length == 1;
        double result = 0;
        for (ValueObject param : parameters) {
            if (ExpressionOasisHelper.typesEqual(param.getValueType(),
                    CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)) {
                @SuppressWarnings("unchecked")
                Collection<Double> values = (Collection<Double>) param.getValue();
                for (double value : values) {
                    result += value;
                }
            } else {
                result += (double) param.getValue();
            }
        }
        return new ValueObject(result, Type.DOUBLE);
    }

    private ValueObject evaluateMult(ValueObject[] parameters) {
        assert parameters != null && parameters.length == 1;

        double result = 1;
        for (ValueObject param : parameters) {
            if (ExpressionOasisHelper.typesEqual(param.getValueType(),
                    CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)) {
                @SuppressWarnings("unchecked")
                Collection<Double> values = (Collection<Double>) param.getValue();
                for (double value : values) {
                    result *= value;
                }
            } else {
                result *= (double) param.getValue();
            }
        }
        return new ValueObject(result, Type.DOUBLE);
    }

    private ValueObject evaluatePow(ValueObject[] parameters) {
        assert parameters != null && parameters.length == 2;
        double exponent = (double) parameters[1].getValue();
        ValueObject result = null;
        if (ExpressionOasisHelper.typesEqual(parameters[0].getValueType(),
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)) {
            @SuppressWarnings("unchecked")
            Collection<Double> values = (Collection<Double>) parameters[0].getValue();
            List<Double> resultValues = new ArrayList<>();
            for (double base : values) {
                resultValues.add(Math.pow(base, exponent));
            }
            result = new MeasuredValuesCompositeValueObject(resultValues);
        } else {
            // this reduces to a simple exponentiation of a value
            double base = (double) parameters[0].getValue();
            result = new ValueObject(Math.pow(base, exponent), Type.DOUBLE);
        }

        return result;
    }

    @Override
    public ValueObject getFunctionValue(String functionName, ValueObject[] parameters)
            throws ExpressionEngineException {
        switch (functionName) {
        case SUM:
            return evaluateSum(parameters);
        case MULT:
            return evaluateMult(parameters);
        case POW:
            return evaluatePow(parameters);
        default:
            return null;
        }
    }

    private boolean typesMatch(String functionName, Type[] paramTypes) {
        switch (functionName) {
        case SUM:
        case MULT:
            return paramTypes.length == 1 && (ExpressionOasisHelper.typesEqual(paramTypes[0],
                    CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)
                    || ExpressionOasisHelper.isNumericType(paramTypes[0]));
        case POW:
            return paramTypes.length == 2
                    && (ExpressionOasisHelper.typesEqual(paramTypes[0],
                            CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE)
                    || ExpressionOasisHelper.isNumericType(paramTypes[0]))
                    && ExpressionOasisHelper.isNumericType(paramTypes[1]);
        }
        return false;
    }

    @Override
    public boolean supportsFunction(String functionName, Type[] parameterTypes) throws ExpressionEngineException {
        return KNOWN_FUNCTIONS.contains(functionName) && typesMatch(functionName, parameterTypes);
    }
}
