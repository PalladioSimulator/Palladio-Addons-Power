package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import static de.fzi.power.interpreter.calculator.expressionoasis.custom.CustomFunctionProvider.POW;
import static de.fzi.power.interpreter.calculator.expressionoasis.custom.CustomFunctionProvider.SQRT;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.grammar.Grammar;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.specification.ConsumptionFactor;

public class CustomFunctionProviderTest {

    private CustomFunctionProvider providerUnderTest;
    private CustomExpressionContext expressionContext;

    private static final String UNKNOWN_FUNCTION = "EXP";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        this.providerUnderTest = new CustomFunctionProvider();
        EList<AbstractFixedFactorValue<?>> fixedFactorValues = new BasicEList<>();
        Iterable<ConsumptionFactor> consumptionFactors = Collections.<ConsumptionFactor> emptyList();
        this.expressionContext = new CustomExpressionContext(fixedFactorValues, consumptionFactors);
    }

    @Test
    public void testInitializeWrongExpressionContext() throws ExpressionEngineException {
        this.expectedException.expect(AssertionError.class);
        // this call should fail now
        this.providerUnderTest.initialize(new ExpressionContext());
    }

    @Test
    public void testInitialize() {
        this.providerUnderTest.initialize(this.expressionContext);
        Grammar grammar = ExpressionEngine.getGrammar();

        assertTrue(grammar.isFunction(POW));
        assertTrue(grammar.isFunction(SQRT));
        assertFalse(grammar.isFunction(UNKNOWN_FUNCTION));
    }

    @Test
    public void testGetFunctionTypeUnknownFunction() throws ExpressionEngineException {
        String functionName = UNKNOWN_FUNCTION;
        Type[] paramTypes = new Type[0];

        assertNull(this.providerUnderTest.getFunctionType(functionName, paramTypes));
    }

    @Test
    public void testGetFunctionTypePOW() throws ExpressionEngineException {
        String functionName = POW;
        Type[] paramTypes = new Type[2];
        paramTypes[0] = Type.DOUBLE;
        paramTypes[1] = Type.LONG;

        assertThat(this.providerUnderTest.getFunctionType(functionName, paramTypes), is(Type.DOUBLE));
    }

    @Test
    public void testGetFunctionTypeSQRT() throws ExpressionEngineException {
        String functionName = SQRT;
        Type[] paramTypes = new Type[1];
        paramTypes[0] = Type.DOUBLE;

        assertThat(this.providerUnderTest.getFunctionType(functionName, paramTypes), is(Type.DOUBLE));
    }

    @Test
    public void testGetFunctionValueUnknownFunction() throws ExpressionEngineException {
        String functionName = UNKNOWN_FUNCTION;
        ValueObject[] params = new ValueObject[0];

        assertNull(this.providerUnderTest.getFunctionValue(functionName, params));
    }

    @Test
    public void testGetFunctionValueSQRT() throws ExpressionEngineException {
        String functionName = SQRT;
        ValueObject[] params = new ValueObject[1];
        params[0] = new ValueObject(4.0, Type.DOUBLE);

        ValueObject result = this.providerUnderTest.getFunctionValue(functionName, params);
        assertThat(result, isA(ValueObject.class));
        assertThat(result.getValueType(), is(Type.DOUBLE));
        assertThat((double) result.getValue(), is(2.0));
    }

    @Test
    public void testGetFunctionValueSQRTComposite() throws ExpressionEngineException {
        String functionName = SQRT;
        ValueObject[] params = new ValueObject[2];
        params[0] = new MeasuredValuesCompositeValueObject(Arrays.asList(100d, 100d));

        ValueObject result = this.providerUnderTest.getFunctionValue(functionName, params);
        assertThat(result.getValue(), instanceOf(Iterable.class));

        @SuppressWarnings("unchecked")
        Iterator<Double> resultValues = ((Iterable<Double>) result.getValue()).iterator();

        assertThat(resultValues.next(), is(10d));
        assertThat(resultValues.next(), is(10d));
    }

    @Test
    public void testGetFunctionValuePOW() throws ExpressionEngineException {
        String functionName = POW;
        ValueObject[] params = new ValueObject[2];
        params[0] = new ValueObject(2.0, Type.DOUBLE);
        params[1] = new ValueObject(4, Type.INTEGER);

        ValueObject result = this.providerUnderTest.getFunctionValue(functionName, params);
        assertThat(result, isA(ValueObject.class));
        assertThat(result.getValueType(), is(Type.DOUBLE));
        assertThat((double) result.getValue(), is(16.0));
    }

    @Test
    public void testGetFunctionValuePOWComposite() throws ExpressionEngineException {
        String functionName = POW;
        ValueObject[] params = new ValueObject[2];
        params[0] = new MeasuredValuesCompositeValueObject(Arrays.asList(10d, 10d));
        params[1] = new ValueObject(4, Type.INTEGER);

        ValueObject result = this.providerUnderTest.getFunctionValue(functionName, params);
        assertThat(result.getValue(), instanceOf(Iterable.class));

        @SuppressWarnings("unchecked")
        Iterator<Double> resultValues = ((Iterable<Double>) result.getValue()).iterator();

        assertThat(resultValues.next(), is(10000d));
        assertThat(resultValues.next(), is(10000d));
    }

    @Test
    public void testSupportsFunctionUnknownFunction() throws ExpressionEngineException {
        String functionName = UNKNOWN_FUNCTION;
        Type[] paramTypes = new Type[0];

        assertFalse(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }

    @Test
    public void testSupportsFunctionWrongParamsSQRT() throws ExpressionEngineException {
        String functionName = SQRT;
        Type[] paramTypes = new Type[2];
        paramTypes[0] = Type.DOUBLE;
        paramTypes[1] = Type.STRING;

        assertFalse(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }

    @Test
    public void testSupportsFunctionWrongParamsPOW() throws ExpressionEngineException {
        String functionName = POW;
        Type[] paramTypes = new Type[2];
        paramTypes[0] = Type.DOUBLE;
        paramTypes[1] = Type.STRING;

        assertFalse(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }

    @Test
    public void testSupportsFunctionCorrectSQRT() throws ExpressionEngineException {
        String functionName = SQRT;
        Type[] paramTypes = new Type[1];
        paramTypes[0] = Type.FLOAT;

        assertTrue(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }

    @Test
    public void testSupportsFunctionCorrectPOW() throws ExpressionEngineException {
        String functionName = POW;
        Type[] paramTypes = new Type[2];
        paramTypes[0] = Type.DOUBLE;
        paramTypes[1] = Type.LONG;

        assertTrue(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }
}
