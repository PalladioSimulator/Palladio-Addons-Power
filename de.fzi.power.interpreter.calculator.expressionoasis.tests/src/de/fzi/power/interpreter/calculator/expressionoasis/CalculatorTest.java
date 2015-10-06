package de.fzi.power.interpreter.calculator.expressionoasis;

public class CalculatorTest {

    // private ResourcePowerModelSpecification specification;
    // private PowerConsumingResource resource;
    // private ResourcePowerBinding binding;
    // private FixedFactorValue idleConsumption;
    // private FixedFactorValue maxConsumption;
    //
    // private AbstractResourcePowerModelCalculator calculatorUnderTest;
    //
    // @Before
    // public void setUp() {
    // this.specification = SpecificationFactory.eINSTANCE.createResourcePowerModelSpecification();
    // StringBuilder nameBuilder = new StringBuilder();
    // nameBuilder.append(ExpressionOasisPowerModelCalculator.REGRESSION_POWER_MODEL_IDENTIFIER);
    // nameBuilder.append(ExpressionOasisPowerModelCalculator.MODEL_NAME_SPECIFICATION_SEPARATOR);
    // nameBuilder.append("Idle_Consumption+Utilization*(Maximum_Consumption-Idle_Consumption)");
    // this.specification.setName(nameBuilder.toString());
    //
    // FixedFactor idleFactor = SpecificationFactory.eINSTANCE.createFixedFactor();
    // idleFactor.setName("Idle_Consumption");
    // this.specification.getConsumptionFactors().add(idleFactor);
    //
    // FixedFactor loadFactor = SpecificationFactory.eINSTANCE.createFixedFactor();
    // loadFactor.setName("Maximum_Consumption");
    // this.specification.getConsumptionFactors().add(loadFactor);
    //
    // MeasuredFactor mf = SpecificationFactory.eINSTANCE.createMeasuredFactor();
    // mf.setName("Utilization");
    // mf.setMetricType((NumericalBaseMetricDescription)
    // MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE);
    // this.specification.getConsumptionFactors().add(mf);
    //
    // this.resource = InfrastructureFactory.eINSTANCE.createPowerConsumingResource();
    // this.binding = BindingFactory.eINSTANCE.createResourcePowerBinding();
    // this.binding.setResourcePowerModelSpecification(this.specification);
    // this.resource.setResourcePowerAssemblyContext(this.binding);
    //
    // this.idleConsumption = BindingFactory.eINSTANCE.createFixedFactorValue();
    // this.idleConsumption.setBoundFactor(idleFactor);
    // this.idleConsumption.setValue(Measure.valueOf(200.0, SI.WATT));
    // this.binding.getFixedFactorValues().add(this.idleConsumption);
    //
    // this.maxConsumption = BindingFactory.eINSTANCE.createFixedFactorValue();
    // this.maxConsumption.setBoundFactor(loadFactor);
    // this.maxConsumption.setValue(Measure.valueOf(400.0, SI.WATT));
    // binding.getFixedFactorValues().add(this.maxConsumption);
    //
    // calculatorUnderTest = new
    // CalculatorFactoryImpl().instantiateResourcePowerModelCalculator(this.resource);
    // }
    //
    // @Test
    // public void testCalculate() {
    // testUtilization(0.0);
    // testUtilization(0.5);
    // testUtilization(1);
    // }
    //
    // private void testUtilization(double utilizationValue) {
    // Set<MeasuringValue> input = new HashSet<MeasuringValue>();
    // input.add(this.createUtilizationTupleMeasurement(utilizationValue));
    // Amount<Power> resLowUtil = this.calculatorUnderTest.calculate(input);
    // assertTrue(resLowUtil.approximates(
    // Amount.valueOf(200.0, SI.WATT).times(utilizationValue).plus(Amount.valueOf(200.0,
    // SI.WATT))));
    // }
    //
    // private MeasuringValue createUtilizationTupleMeasurement(double utilizationValue) {
    // return new BasicMeasurement<Double, Dimensionless>(Measure.valueOf(utilizationValue,
    // Unit.ONE),
    // MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE);
    // }

}
