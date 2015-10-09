package de.fzi.power.interpreter.calculator.expressionoasis;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Power;
import javax.measure.unit.SI;

import org.apache.commons.collections15.map.HashedMap;
import org.jscience.physics.amount.Amount;
import org.junit.Before;
import org.junit.Test;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationFactory;

public class ExpressionOasisDistributionPowerModelCalculatorTest {

    private static final int CONSUMER_COUNT = 4;

    private DeclarativePowerModelSpecification powerModelSpecification;
    private ExpressionOasisDistributionPowerModelCalculator calculatorUnderTest;
    private PowerProvidingEntity powerProvidingEntity;
    private DistributionPowerBinding distributionBinding;
    private MeasuredFactor outletConsumption;
    private FixedFactor constantLoss;
    private FixedFactorValue constantLossValue;

    private List<PowerConsumingEntity> consumers;

    @Before
    public void setUp() throws Exception {
        this.powerModelSpecification = SpecificationFactory.eINSTANCE.createDeclarativePowerModelSpecification();
        this.powerModelSpecification.setName("PowerModelSpec");
        this.powerModelSpecification.setFunctionalExpression(
                "SUM(0.5 * POW(outletConsumption, 2)) +  SUM(2 * outletConsumption) + constantLoss");

        this.distributionBinding = BindingFactory.eINSTANCE.createDistributionPowerBinding();
        this.distributionBinding.setName("DistributionBinding");
        this.distributionBinding.setDistributionPowerModel(this.powerModelSpecification);

        this.outletConsumption = SpecificationFactory.eINSTANCE.createMeasuredFactor();
        this.outletConsumption.setName("outletConsumption");
        this.outletConsumption
                .setMetricType((NumericalBaseMetricDescription) MetricDescriptionConstants.POWER_CONSUMPTION);
        this.outletConsumption.setPowerModel(this.powerModelSpecification);
        this.powerModelSpecification.getConsumptionFactors().add(this.outletConsumption);

        this.constantLoss = SpecificationFactory.eINSTANCE.createFixedFactor();
        this.constantLoss.setName("constantLoss");
        this.constantLoss.setPowerModel(this.powerModelSpecification);
        this.powerModelSpecification.getConsumptionFactors().add(this.constantLoss);

        this.constantLossValue = BindingFactory.eINSTANCE.createFixedFactorValue();
        this.constantLossValue.setBoundFactor(this.constantLoss);
        this.constantLossValue.setPowerBinding(this.distributionBinding);
        this.distributionBinding.getFixedFactorValues().add(this.constantLossValue);
        this.constantLossValue.setValue(Measure.valueOf(100d, Power.UNIT));

        this.powerProvidingEntity = InfrastructureFactory.eINSTANCE.createMountedPowerDistributionUnit();
        this.powerProvidingEntity.setName("MountedPDU");
        this.powerProvidingEntity.setId("PDUId");
        this.powerProvidingEntity.setSuppliablePeakPower(Measure.valueOf(5, SI.KILO(SI.WATT)));
        this.powerProvidingEntity.setDistributionPowerAssemblyContext(this.distributionBinding);

        this.consumers = new ArrayList<PowerConsumingEntity>();
        for (int i = 0; i < CONSUMER_COUNT; ++i) {
            PowerConsumingResource consumer = InfrastructureFactory.eINSTANCE.createPowerConsumingResource();
            consumer.setPowerProvidingEntity(this.powerProvidingEntity);
            this.powerProvidingEntity.getNestedPowerConsumingEntities().add(consumer);
            this.consumers.add(consumer);
        }

        this.calculatorUnderTest = (ExpressionOasisDistributionPowerModelCalculator) new CalculatorFactoryImpl()
                .instantiateDistributionPowerModelCalculator(this.powerProvidingEntity);
    }

    @Test
    public void testCalculate() {
        int individualConsumptionValue = 100;
        Amount<Power> individualConsumption = Amount.valueOf(individualConsumptionValue, Power.UNIT);
        Map<PowerConsumingEntity, Amount<Power>> outletConsumptions = new HashedMap<>(CONSUMER_COUNT);
        for (PowerConsumingEntity comsumer : this.consumers) {
            outletConsumptions.put(comsumer, individualConsumption);
        }
        Amount<Power> actualConsumption = this.calculatorUnderTest.calculate(outletConsumptions);
        double expectedValue = this.constantLossValue.getValue().doubleValue(Power.UNIT);
        expectedValue += individualConsumptionValue * 2d * CONSUMER_COUNT;
        expectedValue += Math.pow(individualConsumptionValue, 2) * 0.5 * CONSUMER_COUNT;
        Amount<Power> expectedConsumption = Amount.valueOf(expectedValue, Power.UNIT);

        assertTrue(actualConsumption.approximates(expectedConsumption));
    }

}
