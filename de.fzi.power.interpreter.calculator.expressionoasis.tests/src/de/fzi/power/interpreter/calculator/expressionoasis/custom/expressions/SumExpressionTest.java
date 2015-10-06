package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Power;
import javax.measure.unit.SI;

import org.hamcrest.CoreMatchers;
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
import org.vedantatree.expressionoasis.expressions.DecimalExpression;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.extensions.DefaultVariableProvider;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.interpreter.calculator.expressionoasis.custom.CustomExpressionContext;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationFactory;

public class SumExpressionTest {

    private static final String MEASURED_FACTOR_NAME = "testMeasuredFactor";
    private static final NumericalBaseMetricDescription POWER_METRIC_DESCRIPTION = (NumericalBaseMetricDescription) MetricDescriptionConstants.POWER_CONSUMPTION;

    private CustomExpressionContext context;
    private MeasuredFactor measuredFactor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        this.measuredFactor = SpecificationFactory.eINSTANCE.createMeasuredFactor();
        this.measuredFactor.setName(MEASURED_FACTOR_NAME);
        this.measuredFactor.setMetricType(POWER_METRIC_DESCRIPTION);
        Iterable<FixedFactorValue> fixedFactorValues = Collections.<FixedFactorValue> emptyList();
        List<ConsumptionFactor> consumptionFactors = new ArrayList<>();
        consumptionFactors.add(this.measuredFactor);
        this.context = new CustomExpressionContext(fixedFactorValues, consumptionFactors);
    }

    @Test
    public void testInitializeWrongExpressionContext() throws ExpressionEngineException {
        SumExpression expression = new SumExpression();
        this.expectedException.expect(AssertionError.class);
        // this call should fail now
        expression.initialize(new ExpressionContext(), new DecimalExpression(), false);
    }

    @Test
    public void testSumNoMeasuredFactor() throws ExpressionEngineException {
        this.expectedException.expect(ExpressionEngineException.class);
        this.expectedException.expectCause(CoreMatchers.nullValue(Throwable.class));
        this.expectedException.expectMessage(CoreMatchers
                .startsWith("Operand is not supported by \"SUM\", for it does not contain any measured factor!"));
        // this should fail now
        ExpressionEngine.compileExpression("SUM(42)", this.context, true);
    }

    @Test
    public void testGetReturnType() {
        SumExpression sumExpression = new SumExpression();
        assertEquals(Type.DOUBLE, sumExpression.getReturnType());
    }

    @Test
    public void testGetValue() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(400d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);

        Expression sumExpression = ExpressionEngine.compileExpression("SUM(" + MEASURED_FACTOR_NAME + ")", context,
                true);
        assertEquals(Double.valueOf(800d), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueMeasuredValuesWithDifferentUnits() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(400d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);

        measuringValue = new BasicMeasurement<>(Measure.valueOf(500d, SI.MILLI(Power.UNIT)), POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        Expression sumExpression = ExpressionEngine.compileExpression("SUM(" + MEASURED_FACTOR_NAME + ")", context,
                true);
        assertEquals(Double.valueOf(400.5), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueMeasuredValuesWithConstMultiplication() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(400d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);

        Expression sumExpression = ExpressionEngine.compileExpression("SUM(" + MEASURED_FACTOR_NAME + " * 10.0)",
                this.context, true);
        assertEquals(Double.valueOf(8000d), sumExpression.getValue().getValue());

    }

    @Test
    public void testGetValueMeasuredValuesWithConstDivisor() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(400d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);

        Expression sumExpression = ExpressionEngine.compileExpression("SUM( 1 / " + MEASURED_FACTOR_NAME + ")",
                this.context, true);

        assertEquals(Double.valueOf(1 / 200d), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueMeasuredValuesWithConstDividend() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(400d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);

        Expression sumExpression = ExpressionEngine.compileExpression("SUM(" + MEASURED_FACTOR_NAME + " / 2)",
                this.context, true);

        assertEquals(Double.valueOf(400d), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueMeasuredValuesWithConstMultiplicationDivide() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(400d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);

        Expression sumExpression = ExpressionEngine
                .compileExpression("SUM(" + MEASURED_FACTOR_NAME + " * (20.0 / 2.0))", this.context, true);
        assertEquals(Double.valueOf(8000d), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueMeasuredValuesWithMultiplication() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(400d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);
        DefaultVariableProvider provider = new DefaultVariableProvider();
        provider.addVariable("factor", new ValueObject(10.0, Type.DOUBLE));
        this.context.addVariableProvider(provider);

        Expression sumExpression = ExpressionEngine.compileExpression("SUM(" + MEASURED_FACTOR_NAME + " * factor)",
                this.context, true);
        assertEquals(Double.valueOf(8000d), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueMeasuredValuesWithMultiplicationAndExponentiation() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(10d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);
        DefaultVariableProvider provider = new DefaultVariableProvider();
        provider.addVariable("factor", new ValueObject(20.0, Type.DOUBLE));
        this.context.addVariableProvider(provider);

        Expression sumExpression = ExpressionEngine
                .compileExpression("SUM(POW(" + MEASURED_FACTOR_NAME + ", 2) * factor)", this.context, true);
        assertEquals(Double.valueOf(4000d), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueMeasuredValuesWithMultiplicationAndExponentiation2() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(10d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);
        DefaultVariableProvider provider = new DefaultVariableProvider();
        provider.addVariable("factor", new ValueObject(2.5, Type.DOUBLE));
        this.context.addVariableProvider(provider);

        // POW(SUM(measuredFactor * factor), 3) should yield 125000: (10*2.5 + 10*2.5)^3
        Expression sumExpression = ExpressionEngine
                .compileExpression("POW(SUM(" + MEASURED_FACTOR_NAME + " * factor), 3)", this.context, true);
        assertEquals(Double.valueOf(125000d), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueQuadraticPolynomial() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(10d, Power.UNIT),
                POWER_METRIC_DESCRIPTION);
        this.context.addBasicMeasurement(measuringValue);
        this.context.addBasicMeasurement(measuringValue);
        DefaultVariableProvider provider = new DefaultVariableProvider();
        provider.addVariable("firstFactor", new ValueObject(2.5, Type.DOUBLE));
        provider.addVariable("secondFactor", new ValueObject(5.0, Type.DOUBLE));
        this.context.addVariableProvider(provider);

        // ax² + bx + c:
        // SUM(factor * POW(measuredFactor, 2)) + SUM(secondFactor * measuredFactor) + 42 should
        // yield
        // 642:
        // (2.5 * 10^2 + 2.5 * 10^2) + (5 * 10 + 5 * 10) + 42
        Expression sumExpression = ExpressionEngine.compileExpression("SUM(firstFactor * POW(" + MEASURED_FACTOR_NAME
                + ", 2)) + SUM(secondFactor * " + MEASURED_FACTOR_NAME + ") + 42", this.context, true);
        assertEquals(Double.valueOf(642d), sumExpression.getValue().getValue());
    }

    @Test
    public void testGetValueOneMeasuredValue() throws ExpressionEngineException {
        BasicMeasurement<Double, Power> measuringValue = new BasicMeasurement<>(Measure.valueOf(400d, Power.UNIT),
                MetricDescriptionConstants.POWER_CONSUMPTION);
        this.context.addBasicMeasurement(measuringValue);

        Expression sumExpression = ExpressionEngine.compileExpression("SUM(" + MEASURED_FACTOR_NAME + ")", context,
                true);
        assertEquals(Double.valueOf(400d), sumExpression.getValue().getValue());
    }

}
