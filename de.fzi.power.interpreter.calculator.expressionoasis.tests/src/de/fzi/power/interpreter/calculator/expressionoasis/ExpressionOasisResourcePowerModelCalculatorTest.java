package de.fzi.power.interpreter.calculator.expressionoasis;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;
import javax.measure.unit.NonSI;

import org.jscience.physics.amount.Amount;
import org.junit.Before;
import org.junit.Test;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationFactory;

public class ExpressionOasisResourcePowerModelCalculatorTest {

    private static final MetricDescription UTILIZATION_METRIC = MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE;

    private DeclarativePowerModelSpecification powerModelSpecification;
    private ResourcePowerBinding binding;
    private MeasuredFactor measuredFactor;
    private FixedFactor fixedFactor;
    private FixedFactorValuePower fixedFactorValue;
    private ExpressionOasisResourcePowerModelCalculator calculatorUnderTest;
    private PowerConsumingResource powerConsumingResource;

    @Before
    public void setUp() throws Exception {
        this.powerModelSpecification = SpecificationFactory.eINSTANCE.createDeclarativePowerModelSpecification();
        this.powerModelSpecification.setName("PowerModelSpec");
        this.powerModelSpecification
                .setFunctionalExpression("(0.5 * measuredFactor * measuredFactor +  2 * measuredFactor) * fixedFactor");

        this.measuredFactor = SpecificationFactory.eINSTANCE.createMeasuredFactor();
        this.measuredFactor.setName("measuredFactor");
        this.measuredFactor.setMetricType((NumericalBaseMetricDescription) UTILIZATION_METRIC);
        this.measuredFactor.setPowerModel(this.powerModelSpecification);
        this.powerModelSpecification.getConsumptionFactors().add(this.measuredFactor);

        this.fixedFactor = SpecificationFactory.eINSTANCE.createFixedFactor();
        this.fixedFactor.setName("fixedFactor");
        this.fixedFactor.setPowerModel(this.powerModelSpecification);
        this.powerModelSpecification.getConsumptionFactors().add(this.fixedFactor);

        this.binding = BindingFactory.eINSTANCE.createResourcePowerBinding();
        this.binding.setName("ResourcePowerBinding");
        this.binding.setResourcePowerModelSpecification(this.powerModelSpecification);

        this.fixedFactorValue = BindingFactory.eINSTANCE.createFixedFactorValuePower();
        this.fixedFactorValue.setBoundFactor(this.fixedFactor);
        this.fixedFactorValue.setPowerBinding(this.binding);
        this.binding.getFixedFactorValues().add(this.fixedFactorValue);
        this.fixedFactorValue.setValue(Measure.valueOf(200d, Power.UNIT));

        this.powerConsumingResource = InfrastructureFactory.eINSTANCE.createPowerConsumingResource();
        this.powerConsumingResource.setName("TestResource");
        this.powerConsumingResource.setId("ResourceId");
        this.powerConsumingResource.setResourcePowerAssemblyContext(this.binding);

        CalculatorFactoryImpl calculatorFactory = new CalculatorFactoryImpl();
        this.calculatorUnderTest = (ExpressionOasisResourcePowerModelCalculator) calculatorFactory
                .instantiateResourcePowerModelCalculator(this.binding);
    }

    @Test
    public void testCalculate() {
        Measure<Double, Dimensionless> utilMeasure = Measure.valueOf(75d, NonSI.PERCENT);
        Amount<Dimensionless> utilAmount = Amount.valueOf(75d, NonSI.PERCENT);
        Amount<Power> fixedFactorValue = Amount.valueOf(this.fixedFactorValue.getValue().doubleValue(Power.UNIT),
                Power.UNIT);
        MeasuringValue utilMeasurement = new BasicMeasurement<Double, Dimensionless>(utilMeasure,
                (BaseMetricDescription) UTILIZATION_METRIC);
        Amount<Power> consumedPower = this.calculatorUnderTest.calculate(Collections.singletonList(utilMeasurement));
        Amount<? extends Quantity> expected = utilAmount.pow(2).times(0.5).plus(utilAmount.times(2))
                .times(fixedFactorValue);

        assertTrue(consumedPower.approximates(expected));
    }

    @Test
    public void testGetInputMetrics() {
        Set<MetricDescription> inputMetrics = this.calculatorUnderTest.getInputMetrics();

        assertTrue(inputMetrics.size() == 1);

        MetricDescription inputMetric = inputMetrics.iterator().next();
        assertThat(inputMetric, is(UTILIZATION_METRIC));
    }

}
