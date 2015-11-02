/**
 * 
 */
package de.fzi.power.interpreter.tests;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Power;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;
import org.junit.Before;
import org.junit.Test;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.interpreter.calculators.essential.LinearPowerModelCalculator;
import de.fzi.power.specification.resources.PowerModelConstants;

/**
 * @author stier
 *
 */
public class LinearPowerModelCalculatorTest {

    private PowerConsumingResource resource;
    private ResourcePowerBinding binding;
    private FixedFactorValue idleConsumption;
    private FixedFactorValue maxConsumption;
    private LinearPowerModelCalculator calculatorUnderTest;

    @Before
    public void setUp() {
        this.resource = InfrastructureFactory.eINSTANCE.createPowerConsumingResource();
        this.binding = BindingFactory.eINSTANCE.createResourcePowerBinding();
        this.binding.setResourcePowerModelSpecification(PowerModelConstants.LINEAR_POWER_MODEL);
        this.resource.setResourcePowerAssemblyContext(this.binding);

        this.idleConsumption = BindingFactory.eINSTANCE.createFixedFactorValue();
        this.idleConsumption.setBoundFactor(PowerModelConstants.LINEAR_POWER_MODEL_MIN_CONSUMPTION);
        this.idleConsumption.setValue(Measure.valueOf(200.0, SI.WATT));
        this.binding.getFixedFactorValues().add(this.idleConsumption);

        this.maxConsumption = BindingFactory.eINSTANCE.createFixedFactorValue();
        this.maxConsumption.setBoundFactor(PowerModelConstants.LINEAR_POWER_MODEL_MAX_CONSUMPTION);
        this.maxConsumption.setValue(Measure.valueOf(400.0, SI.WATT));
        binding.getFixedFactorValues().add(this.maxConsumption);

        this.calculatorUnderTest = new LinearPowerModelCalculator(this.resource.getResourcePowerAssemblyContext());
    }

    /**
     * Test method for
     * {@link de.fzi.power.interpreter.calculators.essential.LinearPowerModelCalculator#calculate(Collection)}
     * .
     */
    @Test
    public void testCalculate() {
        testUtilization(0.0);
        testUtilization(0.5);
        testUtilization(1);
    }

    private void testUtilization(double utilizationValue) {
        Set<MeasuringValue> input = new HashSet<>();
        input.add(this.createUtilizationTupleMeasurement(utilizationValue));
        Amount<Power> resLowUtil = this.calculatorUnderTest.calculate(input);
        assertTrue(resLowUtil.approximates(Amount.valueOf(200.0, SI.WATT).times(utilizationValue)
                .plus(Amount.valueOf(200.0, SI.WATT))));
    }

    private MeasuringValue createUtilizationTupleMeasurement(double utilizationValue) {
        return new BasicMeasurement<Double, Dimensionless>(Measure.valueOf(utilizationValue, Unit.ONE),
                MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE);
    }
}
