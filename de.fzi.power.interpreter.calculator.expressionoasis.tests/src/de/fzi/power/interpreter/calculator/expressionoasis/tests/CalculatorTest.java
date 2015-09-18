package de.fzi.power.interpreter.calculator.expressionoasis.tests;

import static org.junit.Assert.assertTrue;

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
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.interpreter.calculator.expressionoasis.ExpressionOasisPowerModelCalculator;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;

public class CalculatorTest {
    
    private ResourcePowerModelSpecification specification;
    private PowerConsumingResource resource;
    private ResourcePowerBinding binding;
    private FixedFactorValue idleConsumption;
    private FixedFactorValue maxConsumption;
    
    private AbstractResourcePowerModelCalculator calculatorUnderTest; 
    
    @Before
    public void setUp() {
        this.specification = SpecificationFactory.eINSTANCE.createResourcePowerModelSpecification();
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(ExpressionOasisPowerModelCalculator.REGRESSION_POWER_MODEL_IDENTIFIER);
        nameBuilder.append(ExpressionOasisPowerModelCalculator.MODEL_NAME_SPECIFICATION_SEPARATOR);
        nameBuilder.append("Idle_Consumption+Utilization*(Maximum_Consumption-Idle_Consumption)");
        this.specification.setName(nameBuilder.toString());
        
        FixedFactor idleFactor = SpecificationFactory.eINSTANCE.createFixedFactor();
        idleFactor.setName("Idle_Consumption");
        this.specification.getConsumptionFactors().add(idleFactor);
        
        FixedFactor loadFactor = SpecificationFactory.eINSTANCE.createFixedFactor();
        loadFactor.setName("Maximum_Consumption");
        this.specification.getConsumptionFactors().add(loadFactor);
        
        MeasuredFactor mf = SpecificationFactory.eINSTANCE.createMeasuredFactor();
        mf.setName("Utilization");
        mf.setMetricType((NumericalBaseMetricDescription) 
                MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE);
        this.specification.getConsumptionFactors().add(mf);
        
        this.resource = InfrastructureFactory.eINSTANCE.createPowerConsumingResource();
        this.binding = BindingFactory.eINSTANCE.createResourcePowerBinding();
        this.binding.setResourcePowerModelSpecification(this.specification);
        this.resource.setResourcePowerAssemblyContext(this.binding);

        this.idleConsumption = BindingFactory.eINSTANCE.createFixedFactorValue();
        this.idleConsumption.setBoundFactor(idleFactor);
        this.idleConsumption.setValue(Measure.valueOf(200.0, SI.WATT));
        this.binding.getFixedFactorValues().add(this.idleConsumption);

        this.maxConsumption = BindingFactory.eINSTANCE.createFixedFactorValue();
        this.maxConsumption.setBoundFactor(loadFactor);
        this.maxConsumption.setValue(Measure.valueOf(400.0, SI.WATT));
        binding.getFixedFactorValues().add(this.maxConsumption);
        
        calculatorUnderTest = new ExpressionOasisPowerModelCalculator(this.resource);
    }
    
    @Test
    public void testCalculate() {
        testUtilization(0.0);
        testUtilization(0.5);
        testUtilization(1);
    }

    private void testUtilization(double utilizationValue) {
        Set<MeasuringValue> input = new HashSet<MeasuringValue>();
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
