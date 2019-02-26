package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.extensions.DefaultVariableProvider;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationFactory;

public class CustomExpressionContextTest {

    private static final String MEASURED_FACTOR_NAME = "testMeasuredFactor";
    private static final NumericalBaseMetricDescription POWER_METRIC_DESCRIPTION = (NumericalBaseMetricDescription) MetricDescriptionConstants.POWER_CONSUMPTION;

    private CustomExpressionContext context = null;
    private MeasuredFactor measuredFactor;

    @Before
    public void setUpTest() throws ExpressionEngineException {

        this.measuredFactor = SpecificationFactory.eINSTANCE.createMeasuredFactor();
        this.measuredFactor.setName(MEASURED_FACTOR_NAME);
        this.measuredFactor.setMetricType(POWER_METRIC_DESCRIPTION);
        EList<AbstractFixedFactorValue<?>> fixedFactorValues = new BasicEList<>();
        List<ConsumptionFactor> consumptionFactors = new ArrayList<>();
        consumptionFactors.add(this.measuredFactor);
        this.context = new CustomExpressionContext(fixedFactorValues, consumptionFactors);
    }

    @Test
    public void testExpressionContextDefaultVariable() throws ExpressionEngineException {
        DefaultVariableProvider dvp = new DefaultVariableProvider();
        dvp.addVariable("C1", new ValueObject(2.0, Type.DOUBLE));
        dvp.addVariable("C2", new ValueObject(1.0, Type.DOUBLE));
        dvp.addVariable("C3", new ValueObject(1.0, Type.DOUBLE));
        context.addVariableProvider(dvp);

        Expression expression = ExpressionEngine.compileExpression("C1 + C2 + C3", context, true);
        ValueObject actual = expression.getValue();

        assertThat(actual.getValueType(), CoreMatchers.is(Type.DOUBLE));
        assertThat(actual.getValue(), CoreMatchers.instanceOf(double.class));
        assertThat((double) actual.getValue(), CoreMatchers.is(4.0));
    }

    @Test
    public void testToDoubleValueObjectNumericType() {
        ValueObject valueObject = new ValueObject(42, Type.INTEGER);

        double actual = this.context.toDouble(valueObject);
        assertThat(actual, CoreMatchers.is(42.0));
    }

    @Test
    public void testToDoubleValueObjectCompositeType() {
        ValueObject valueObject = new MeasuredValuesCompositeValueObject(Arrays.asList(12.25, 8.15, 42.0));

        double actual = this.context.toDouble(valueObject);
        assertThat(actual, CoreMatchers.is(12.25));
    }

    @Test
    public void testToDoubleValueObjectOtherType() {
        ValueObject valueObject = new ValueObject("test", Type.STRING);

        double actual = this.context.toDouble(valueObject);
        assertThat(actual, CoreMatchers.is(0.0));
    }
}
