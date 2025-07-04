/**
 * 
 */
package de.fzi.power.interpreter.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Power;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.jscience.physics.amount.Amount;
import org.junit.Before;
import org.junit.Test;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerConsumingResourceSet;
import de.fzi.power.interpreter.calculators.essential.LinearPowerModelCalculator;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.resources.PowerModelConstants;

/**
 * @author stier
 *
 */
public class LinearPowerModelCalculatorTest {

    private PowerConsumingResourceSet resource;
    private ResourcePowerBinding binding;
    private FixedFactorValuePower idleConsumption;
    private FixedFactorValuePower maxConsumption;
    private LinearPowerModelCalculator calculatorUnderTest;

    @Before
    public void setUp() throws IOException, URISyntaxException {
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Registry packageRegistry = EPackage.Registry.INSTANCE;
        reg.getExtensionToFactoryMap()
            .put("spec", new XMIResourceFactoryImpl());
        packageRegistry.put(SpecificationPackage.eNS_URI, SpecificationPackage.eINSTANCE);

        ClassLoader classLoader = PowerModelConstants.class.getClassLoader();
        URL resourceURL = classLoader.getResource("commonSpecification.spec");
        URL resourceFileURL = FileLocator.toFileURL(resourceURL);
        URI resourceFileURI = URI.createURI(resourceFileURL.toURI()
            .toString());
        URI sourceURI = URI.createURI("pathmap://POWER_MODELS_MODELS/models/commonSpecification.spec");
        URI targetURI = resourceFileURI;
        URIMappingRegistryImpl.INSTANCE.put(sourceURI, targetURI);

        this.resource = InfrastructureFactory.eINSTANCE.createPowerConsumingResourceSet();
        this.binding = BindingFactory.eINSTANCE.createResourcePowerBinding();
        this.binding.setResourcePowerModelSpecification(PowerModelConstants.LINEAR_POWER_MODEL);
        this.resource.setResourcePowerAssemblyContext(this.binding);

        this.idleConsumption = BindingFactory.eINSTANCE.createFixedFactorValuePower();
        this.idleConsumption.setBoundFactor(PowerModelConstants.LINEAR_POWER_MODEL_MIN_CONSUMPTION);
        this.idleConsumption.setValue(Measure.valueOf(200.0, SI.WATT));
        this.binding.getFixedFactorValues()
            .add(this.idleConsumption);

        this.maxConsumption = BindingFactory.eINSTANCE.createFixedFactorValuePower();
        this.maxConsumption.setBoundFactor(PowerModelConstants.LINEAR_POWER_MODEL_MAX_CONSUMPTION);
        this.maxConsumption.setValue(Measure.valueOf(400.0, SI.WATT));
        binding.getFixedFactorValues()
            .add(this.maxConsumption);

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
        assertTrue(resLowUtil.approximates(Amount.valueOf(200.0, SI.WATT)
            .times(utilizationValue)
            .plus(Amount.valueOf(200.0, SI.WATT))));
    }

    private MeasuringValue createUtilizationTupleMeasurement(double utilizationValue) {
        return new BasicMeasurement<>(Measure.valueOf(utilizationValue, Unit.ONE),
                MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE);
    }
}
