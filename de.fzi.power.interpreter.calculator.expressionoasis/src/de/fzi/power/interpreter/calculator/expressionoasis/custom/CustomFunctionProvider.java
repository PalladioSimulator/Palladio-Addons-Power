package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.extensions.FunctionProvider;
import org.vedantatree.expressionoasis.grammar.Grammar;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;
import de.fzi.power.specification.MeasuredFactor;

public final class CustomFunctionProvider implements FunctionProvider {

    /**
     * The provided composite 'POW' function.
     */
    public static final String POW = "POW";
    /**
     * The provided composite 'SQRT' function.
     */
    public static final String SQRT = "SQRT";

    private static final List<String> KNOWN_FUNCTIONS = Arrays.asList(POW, SQRT);

    public CustomFunctionProvider() {
    }

    /**
     * @throws AssertionError
     *             In case the passed {@link ExpressionContext} is not a
     *             {@link CustomExpressionContext} instance.
     */
    @Override
    public void initialize(ExpressionContext expressionContext) {
        ExpressionOasisHelper.assertCorrectExpressionContext(expressionContext, getClass());
        Grammar grammar = ExpressionEngine.getGrammar();
        for (String function : KNOWN_FUNCTIONS) {
            grammar.addFunction(function);
        }
    }

    /**
     * @return {@link Type#DOUBLE} in case {@link #supportsFunction(String, Type[])} called with the
     *         given arguments returns {@code true}, otherwise {@code null}.
     */
    @Override
    public Type getFunctionType(String functionName, Type[] parameterTypes) throws ExpressionEngineException {
        return supportsFunction(functionName, parameterTypes) ? Type.DOUBLE : null;
    }

    private ValueObject evaluatePow(ValueObject[] parameters) {
        assert parameters != null && parameters.length == 2;
        Number exponent = (Number) parameters[1].getValue();
        ValueObject result = null;
        ValueObject firstParam = parameters[0];
        if (ExpressionOasisHelper.hasCompositeType(firstParam)) {
            Iterable<Double> values = ((MeasuredValuesCompositeValueObject) firstParam).getValue();
            List<Double> resultValues = new ArrayList<>();
            for (double base : values) {
                resultValues.add(Math.pow(base, exponent.doubleValue()));
            }
            result = new MeasuredValuesCompositeValueObject(resultValues);
        } else {
            // this reduces to a simple exponentiation of a value
            double base = (double) firstParam.getValue();
            result = new ValueObject(Math.pow(base, exponent.doubleValue()), Type.DOUBLE);
        }

        return result;
    }

    private ValueObject evaluateSqrt(ValueObject[] parameters) {
        assert parameters != null && parameters.length == 1;

        ValueObject result = null;
        ValueObject radicandValueObj = parameters[0];
        if (ExpressionOasisHelper.hasCompositeType(radicandValueObj)) {
            Iterable<Double> radicands = ((MeasuredValuesCompositeValueObject) radicandValueObj).getValue();
            List<Double> squareRoots = new ArrayList<>();
            for (double radicand : radicands) {
                squareRoots.add(Math.sqrt(radicand));
            }
            result = new MeasuredValuesCompositeValueObject(squareRoots);
        } else {
            Number radicand = (Number) radicandValueObj.getValue();
            result = new ValueObject(Math.sqrt(radicand.doubleValue()), Type.DOUBLE);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @return
     *         <ul>
     *         <li>{@code null} is returned in case the function denoted by the given name is not
     *         provided by this instance.</li>
     *         <li>A {@link ValueObject} of {@link Type#DOUBLE} is returned if none of the
     *         parameters is a {@link MeasuredFactor}.</li>
     *         <li>A {@link MeasuredValuesCompositeValueObject} is returned in any other case.</li>
     *         </ul>
     */
    @Override
    public ValueObject getFunctionValue(String functionName, ValueObject[] parameters)
            throws ExpressionEngineException {
        switch (functionName) {
        case POW:
            return evaluatePow(parameters);
        case SQRT:
            return evaluateSqrt(parameters);
        default:
            return null;
        }
    }

    private static boolean typesMatch(String functionName, Type[] paramTypes) {
        switch (functionName) {
        case POW:
            return paramTypes.length == 2 && ExpressionOasisHelper.isNumericType(paramTypes[0])
                    && ExpressionOasisHelper.isNumericType(paramTypes[1]);
        case SQRT:
            return paramTypes.length == 1 && ExpressionOasisHelper.isNumericType(paramTypes[0]);
        }
        return false;
    }

    @Override
    public boolean supportsFunction(String functionName, Type[] parameterTypes) throws ExpressionEngineException {
        return KNOWN_FUNCTIONS.contains(functionName) && typesMatch(functionName, parameterTypes);
    }
}
