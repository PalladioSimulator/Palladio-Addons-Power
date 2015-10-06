package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Iterator;

import javax.measure.Measure;
import javax.measure.quantity.Power;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Predicate;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.extensions.DefaultVariableProvider;
import org.vedantatree.expressionoasis.extensions.VariableProvider;
import org.vedantatree.expressionoasis.grammar.Grammar;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationFactory;

public class CustomFunctionProviderTest {

    private CustomFunctionProvider providerUnderTest;
    private CustomExpressionContext expressionContext;
    private VariableProvider variableProvider;
    private MeasuredFactor measuredFactor;

    private static final String MEASURED_FACTOR_NAME = "testMeasuredFactor";
    private static final NumericalBaseMetricDescription POWER_METRIC_DESCRIPTION = (NumericalBaseMetricDescription) MetricDescriptionConstants.POWER_CONSUMPTION;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        this.measuredFactor = SpecificationFactory.eINSTANCE.createMeasuredFactor();
        this.measuredFactor.setName(MEASURED_FACTOR_NAME);
        this.measuredFactor.setMetricType(POWER_METRIC_DESCRIPTION);

        this.providerUnderTest = new CustomFunctionProvider();
        Iterable<FixedFactorValue> fixedFactorValues = Collections.<FixedFactorValue> emptyList();
        Iterable<ConsumptionFactor> consumptionFactors = Collections.<ConsumptionFactor> singleton(this.measuredFactor);
        this.expressionContext = new CustomExpressionContext(fixedFactorValues, consumptionFactors);
        // the following should yield an instance of the ConsumptionFactorsVariableProvider class
        // which is not publicly accessible
        this.variableProvider = CollectionUtils.find(this.expressionContext.getVariableProviders(),
                new Predicate<VariableProvider>() {

                    @Override
                    public boolean evaluate(VariableProvider provider) {
                        return provider.getClass() != DefaultVariableProvider.class;
                    }
                });
    }

    @After
    public void tearDown() throws Exception {
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

        assertTrue(grammar.isFunction("POW"));
        assertTrue(grammar.isFunction("SQRT"));
    }

    @Test
    public void testGetFunctionTypeUnknownFunction() throws ExpressionEngineException {
        String functionName = "EXP";
        Type[] paramTypes = new Type[0];

        assertNull(this.providerUnderTest.getFunctionType(functionName, paramTypes));
    }

    @Test
    public void testGetFunctionTypePOW() throws ExpressionEngineException {
        String functionName = "POW";
        Type[] paramTypes = new Type[2];
        paramTypes[0] = Type.DOUBLE;
        paramTypes[1] = Type.LONG;

        assertThat(this.providerUnderTest.getFunctionType(functionName, paramTypes), CoreMatchers.is(Type.DOUBLE));
    }

    @Test
    public void testGetFunctionTypeSQRT() throws ExpressionEngineException {
        String functionName = "SQRT";
        Type[] paramTypes = new Type[1];
        paramTypes[0] = Type.DOUBLE;

        assertThat(this.providerUnderTest.getFunctionType(functionName, paramTypes), CoreMatchers.is(Type.DOUBLE));
    }

    @Test
    public void testGetFunctionValueUnknownFunction() throws ExpressionEngineException {
        String functionName = "EXP";
        ValueObject[] params = new ValueObject[0];

        assertNull(this.providerUnderTest.getFunctionValue(functionName, params));
    }

    @Test
    public void testGetFunctionValueSQRT() throws ExpressionEngineException {
        String functionName = "SQRT";
        ValueObject[] params = new ValueObject[1];
        params[0] = new ValueObject(4.0, Type.DOUBLE);

        ValueObject result = this.providerUnderTest.getFunctionValue(functionName, params);
        assertThat(result, CoreMatchers.isA(ValueObject.class));
        assertThat(result.getValueType(), CoreMatchers.is(Type.DOUBLE));
        assertThat((double) result.getValue(), CoreMatchers.is(2.0));
    }

    @Test
    public void testGetFunctionValueSQRTComposite() throws ExpressionEngineException {
        // we have to use the variable provider/expression context to get a composite value object
        Measure<Double, Power> powerMeasure = Measure.valueOf(100d, Power.UNIT);
        this.expressionContext
                .addBasicMeasurement(new BasicMeasurement<Double, Power>(powerMeasure, POWER_METRIC_DESCRIPTION));
        this.expressionContext
                .addBasicMeasurement(new BasicMeasurement<Double, Power>(powerMeasure, POWER_METRIC_DESCRIPTION));

        String functionName = "SQRT";
        ValueObject[] params = new ValueObject[2];
        params[0] = this.variableProvider.getVariableValue(MEASURED_FACTOR_NAME);

        ValueObject result = this.providerUnderTest.getFunctionValue(functionName, params);
        assertThat(result.getValue(), CoreMatchers.instanceOf(Iterable.class));

        @SuppressWarnings("unchecked")
        Iterator<Double> resultValues = ((Iterable<Double>) result.getValue()).iterator();

        assertThat(resultValues.next(), CoreMatchers.is(10d));
        assertThat(resultValues.next(), CoreMatchers.is(10d));
    }

    @Test
    public void testGetFunctionValuePOW() throws ExpressionEngineException {
        String functionName = "POW";
        ValueObject[] params = new ValueObject[2];
        params[0] = new ValueObject(2.0, Type.DOUBLE);
        params[1] = new ValueObject(4, Type.INTEGER);

        ValueObject result = this.providerUnderTest.getFunctionValue(functionName, params);
        assertThat(result, CoreMatchers.isA(ValueObject.class));
        assertThat(result.getValueType(), CoreMatchers.is(Type.DOUBLE));
        assertThat((double) result.getValue(), CoreMatchers.is(16.0));
    }

    @Test
    public void testGetFunctionValuePOWComposite() throws ExpressionEngineException {
        // we have to use the variable provider/expression context to get a composite value object
        Measure<Double, Power> powerMeasure = Measure.valueOf(10d, Power.UNIT);
        this.expressionContext
                .addBasicMeasurement(new BasicMeasurement<Double, Power>(powerMeasure, POWER_METRIC_DESCRIPTION));
        this.expressionContext
                .addBasicMeasurement(new BasicMeasurement<Double, Power>(powerMeasure, POWER_METRIC_DESCRIPTION));

        String functionName = "POW";
        ValueObject[] params = new ValueObject[2];
        params[0] = this.variableProvider.getVariableValue(MEASURED_FACTOR_NAME);
        params[1] = new ValueObject(4, Type.INTEGER);

        ValueObject result = this.providerUnderTest.getFunctionValue(functionName, params);
        assertThat(result.getValue(), CoreMatchers.instanceOf(Iterable.class));

        @SuppressWarnings("unchecked")
        Iterator<Double> resultValues = ((Iterable<Double>) result.getValue()).iterator();

        assertThat(resultValues.next(), CoreMatchers.is(10000d));
        assertThat(resultValues.next(), CoreMatchers.is(10000d));
    }

    @Test
    public void testSupportsFunctionUnknownFunction() throws ExpressionEngineException {
        String functionName = "EXP";
        Type[] paramTypes = new Type[0];

        assertFalse(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }

    @Test
    public void testSupportsFunctionWrongParamsSQRT() throws ExpressionEngineException {
        String functionName = "SQRT";
        Type[] paramTypes = new Type[2];
        paramTypes[0] = Type.DOUBLE;
        paramTypes[1] = Type.STRING;

        assertFalse(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }

    @Test
    public void testSupportsFunctionWrongParamsPOW() throws ExpressionEngineException {
        String functionName = "POW";
        Type[] paramTypes = new Type[2];
        paramTypes[0] = Type.DOUBLE;
        paramTypes[1] = Type.STRING;

        assertFalse(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }

    @Test
    public void testSupportsFunctionCorrectSQRT() throws ExpressionEngineException {
        String functionName = "SQRT";
        Type[] paramTypes = new Type[1];
        paramTypes[0] = Type.FLOAT;

        assertTrue(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }

    @Test
    public void testSupportsFunctionCorrectPOW() throws ExpressionEngineException {
        String functionName = "POW";
        Type[] paramTypes = new Type[2];
        paramTypes[0] = Type.DOUBLE;
        paramTypes[1] = Type.LONG;

        assertTrue(this.providerUnderTest.supportsFunction(functionName, paramTypes));
    }
}
