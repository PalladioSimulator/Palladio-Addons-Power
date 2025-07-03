package de.fzi.power.interpreter.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Power;
import javax.measure.unit.SI;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.jscience.physics.amount.Amount;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.experimentanalysis.utilizationfilter.UtilizationFilterConfiguration;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingResourceSet;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.interpreter.ConsumptionContext;
import de.fzi.power.interpreter.EvaluationScope;
import de.fzi.power.interpreter.PowerConsumptionSwitch;
import de.fzi.power.interpreter.PowerModelRegistry;
import de.fzi.power.interpreter.PowerModelUpdaterSwitch;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.CalculatorFactory;
import de.fzi.power.interpreter.calculators.ExtensibleCalculatorInstantiatorImpl;
import de.fzi.power.interpreter.calculators.IResourcePowerModelCalculator;
import de.fzi.power.interpreter.calculators.essential.InterpolationModelCalculator;
import de.fzi.power.interpreter.calculators.essential.LinearPassthroughCalculator;
import de.fzi.power.interpreter.calculators.essential.LinearPowerModelCalculator;
import de.fzi.power.interpreter.calculators.essential.NonlinearRegressionCalculator;
import de.fzi.power.interpreter.measureprovider.ExtendedMeasureProvider;
import de.fzi.power.interpreter.measureprovider.utilization.UtilizationFilterMeasureProvider;
import de.fzi.power.interpreter.tests.utils.MockStateOfActiveResourceTupleDataSource;
import de.fzi.power.interpreter.util.IExtensionHelper;
import de.fzi.power.specification.BlackBoxDistributionPowerModelSpecification;
import de.fzi.power.specification.BlackBoxResourcePowerModelSpecification;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.resources.PowerModelConstants;

/**
 * This class contains test cases for the {@link PowerConsumptionSwitch}.
 * 
 * @author Florian Rosenthal
 *
 */
public class PowerConsumptionSwitchTest {

    private PowerConsumptionSwitch switchUnderTest;
    private EvaluationScope evaluationScope;
    private Measure<Double, Duration> windowLength;
    private ConsumptionContext context;
    private PowerBindingRepository powerBindingRepo;
    private PowerInfrastructureRepository infrastructureRepo;
    private PowerDistributionUnit rootPdu;
    private MountedPowerDistributionUnit mountedPdu;
    private MountedPowerDistributionUnit nestedMountedPdu1;
    private MountedPowerDistributionUnit nestedMountedPdu2;
    private PowerConsumingResourceSet cpu1;
    private PowerConsumingResourceSet cpu2;
    private PowerModelRegistry modelRegistry;
    private ActiveResourceMeasuringPoint cpu1MeasuringPoint;
    private ActiveResourceMeasuringPoint cpu2MeasuringPoint;
    private MockStateOfActiveResourceTupleDataSource measurementsCpu1;
    private MockStateOfActiveResourceTupleDataSource measurementsCpu2;

    private static Resource bindingResource;
    private static Resource infrastructureResource;
    private static final double DELTA = Math.pow(10, -12);
    private static final Amount<Duration> ZERO_DURATION = Amount.valueOf(0, SI.SECOND);

    @Mock
    private IExtensionHelper extensionHelper;
    @Mock
    private CalculatorFactory calculatorFactory;

    @BeforeClass
    public static void setupBeforeClass() throws IOException, URISyntaxException {
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Registry packageRegistry = EPackage.Registry.INSTANCE;

        reg.getExtensionToFactoryMap()
            .put("spec", new XMIResourceFactoryImpl());
        packageRegistry.put(SpecificationPackage.eNS_URI, SpecificationPackage.eINSTANCE);

        reg.getExtensionToFactoryMap()
            .put("binding", new XMIResourceFactoryImpl());
        packageRegistry.put(BindingPackage.eNS_URI, BindingPackage.eINSTANCE);
        reg.getExtensionToFactoryMap()
            .put("infrastructure", new XMIResourceFactoryImpl());
        packageRegistry.put(InfrastructurePackage.eNS_URI, InfrastructurePackage.eINSTANCE);

        ClassLoader classLoader = PowerModelConstants.class.getClassLoader();
        URL resourceURL = classLoader.getResource("commonSpecification.spec");
        URL resourceFileURL = FileLocator.toFileURL(resourceURL);
        URI resourceFileURI = URI.createURI(resourceFileURL.toURI()
            .toString());
        URI sourceURI = URI.createURI("pathmap://POWER_MODELS_MODELS/models/commonSpecification.spec");
        URI targetURI = resourceFileURI;
        URIMappingRegistryImpl.INSTANCE.put(sourceURI, targetURI);

        URI sourceURI2 = URI
            .createURI("platform:/plugin/de.fzi.power.specification.resources/models/commonSpecification.spec");
        URIMappingRegistryImpl.INSTANCE.put(sourceURI2, targetURI);

        bindingResource = createResource(resourceSet, "testBinding.binding");
        try {
            bindingResource.load(Collections.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        infrastructureResource = createResource(resourceSet, "testInfrastructure.infrastructure");
        try {
            infrastructureResource.load(Collections.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Resource createResource(ResourceSet resourceSet, String path)
            throws IOException, URISyntaxException {
        ClassLoader classLoader = PowerConsumptionSwitchTest.class.getClassLoader();
        URL resourceURL = classLoader.getResource(path);

        URL resourceFileURL = FileLocator.toFileURL(resourceURL);
        URI resourceFileURI = URI.createURI(resourceFileURL.toURI()
            .toString());
        Resource resource = resourceSet.createResource(resourceFileURI);
        return resource;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        try {
            if (bindingResource != null) {
                bindingResource.delete(Collections.emptyMap());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (infrastructureResource != null) {
                infrastructureResource.delete(Collections.emptyMap());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        this.powerBindingRepo = (PowerBindingRepository) bindingResource.getEObject("_Ey4nUETHEeSB-oPaAunQcg");
        this.rootPdu = (PowerDistributionUnit) infrastructureResource.getEObject("_98ByQEWMEeSZH5zlL3RMGg");
        this.infrastructureRepo = this.rootPdu.getPowerInfrastructureModel();

        List<PowerConsumingEntity> nestedPces = this.rootPdu.getNestedPowerConsumingEntities();
        this.mountedPdu = (MountedPowerDistributionUnit) nestedPces.get(0);
        this.nestedMountedPdu2 = (MountedPowerDistributionUnit) nestedPces.get(1);
        this.nestedMountedPdu1 = (MountedPowerDistributionUnit) this.mountedPdu.getNestedPowerConsumingEntities()
            .get(0);
        this.cpu1 = (PowerConsumingResourceSet) this.nestedMountedPdu1.getNestedPowerConsumingEntities()
            .get(0);
        this.cpu2 = (PowerConsumingResourceSet) this.nestedMountedPdu2.getNestedPowerConsumingEntities()
            .get(0);

        this.windowLength = Measure.valueOf(10d, SI.SECOND);
        this.cpu1MeasuringPoint = PcmmeasuringpointFactory.eINSTANCE.createActiveResourceMeasuringPoint();
        this.cpu1MeasuringPoint.setActiveResource(this.cpu1.getProcessingResourceSpecifications()
            .get(0));
        this.cpu2MeasuringPoint = PcmmeasuringpointFactory.eINSTANCE.createActiveResourceMeasuringPoint();
        this.cpu2MeasuringPoint.setActiveResource(this.cpu2.getProcessingResourceSpecifications()
            .get(0));

        this.measurementsCpu1 = new MockStateOfActiveResourceTupleDataSource(this.windowLength,
                this.cpu1MeasuringPoint);
        this.measurementsCpu2 = new MockStateOfActiveResourceTupleDataSource(this.windowLength,
                this.cpu2MeasuringPoint);

        this.modelRegistry = new PowerModelRegistry();
        // set the calculators/attach power models
        // extensionHelper = IExtensionHelper.INSTANCE;
        setupExtensionHelper();

        ExtensibleCalculatorInstantiatorImpl calcInstantiator = new ExtensibleCalculatorInstantiatorImpl(
                extensionHelper);
        PowerModelUpdaterSwitch powerModelUpdaterSwitch = new PowerModelUpdaterSwitch(this.modelRegistry,
                calcInstantiator);
        powerModelUpdaterSwitch.doSwitch(this.infrastructureRepo);
    }

    private void setupExtensionHelper() {
        when(extensionHelper.getExecutableExtensions(
                ExtensibleCalculatorInstantiatorImpl.CALCULATOR_FACTORY_EXTENSION_POINT, "calculatorFactory",
                "factory")).thenReturn(Collections.singletonList(calculatorFactory));
        when(calculatorFactory.isCompatibleWith(any(PowerModelSpecification.class))).thenAnswer(new Answer<Boolean>() {

            @Override
            public Boolean answer(InvocationOnMock invocation) throws Throwable {
                PowerModelSpecification spec = invocation.getArgument(0);
                String specId = spec.getId();
                String linearId = PowerModelConstants.LINEAR_POWER_MODEL.getId();
                String nonLinearId = PowerModelConstants.NONLINEAR_REGRESSION_MODEL.getId();
                String interpolId = PowerModelConstants.INTERPOLATION_MODEL.getId();
                String passThroughId = PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION.getId();
                if (spec instanceof BlackBoxResourcePowerModelSpecification) {
                    HashSet<String> ids = new HashSet<>(Arrays.asList(linearId, nonLinearId, interpolId));
                    if (ids.contains(specId)) {
                        return true;
                    }
                }
                //ResourcePowerModelSpecification
                //ResourceCalculator  de.fzi.power.specification.impl.BlackBoxResourcePowerModelSpecificationImpl (Linear Power Model : _daqEMDgXEeSFuYf_V61WsQ)

                if (spec instanceof BlackBoxDistributionPowerModelSpecification) {
                    if (passThroughId.equals(specId)) {
                        return true;
                    }
                }
                return false;
            }
        });
        when(calculatorFactory.instantiateResourcePowerModelCalculator(any(ResourcePowerBinding.class)))
            .thenAnswer(new Answer<IResourcePowerModelCalculator>() {

                @Override
                public IResourcePowerModelCalculator answer(InvocationOnMock invocation) throws Throwable {
                    ResourcePowerBinding binding = invocation.getArgument(0);
                    // return new LinearPowerModelCalculator(binding);
                    ResourcePowerModelSpecification resourcePowerModelSpecification = binding.getResourcePowerModelSpecification();
                    if (resourcePowerModelSpecification.getId()
                        .equals(PowerModelConstants.LINEAR_POWER_MODEL.getId())) {
                        return new LinearPowerModelCalculator(binding);
                    } else if (resourcePowerModelSpecification.getId()
                        .equals(PowerModelConstants.NONLINEAR_REGRESSION_MODEL.getId())) {
                        return new NonlinearRegressionCalculator(binding);
                    } else if (resourcePowerModelSpecification.getId()
                        .equals(PowerModelConstants.INTERPOLATION_MODEL.getId())) {
                        return new InterpolationModelCalculator(binding);
                    }
                    return null;
                }
            });
        when(calculatorFactory.instantiateDistributionPowerModelCalculator(any(DistributionPowerBinding.class)))
            .thenAnswer(new Answer<AbstractDistributionPowerModelCalculator>() {

                @Override
                public AbstractDistributionPowerModelCalculator answer(InvocationOnMock invocation) throws Throwable {
                    DistributionPowerBinding binding = invocation.getArgument(0);
                    return new LinearPassthroughCalculator(binding);
                }
            });
    }

    private void initializeSwitch() {
        List<IDataSource> datasources = new ArrayList<>();
        datasources.add(this.measurementsCpu1);
        datasources.add(this.measurementsCpu2);

        ExtendedMeasureProvider prov = new UtilizationFilterMeasureProvider();
        Map<String, Object> filterProperties = new HashMap<>(prov.getProperties());
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_INCREMENT_KEY, this.windowLength);
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_LENGTH_KEY, this.windowLength);
        prov.setProperties(filterProperties);

        this.evaluationScope = EvaluationScope.createScope(datasources, Collections.singleton(prov));

        this.context = ConsumptionContext.createConsumptionContext(this.powerBindingRepo, this.evaluationScope,
                this.modelRegistry);
        this.switchUnderTest = PowerConsumptionSwitch.createPowerConsumptionSwitch(this.context);
        this.evaluationScope.next();
    }

    @Test
    public void testPowerAtRootPdu() {
        this.measurementsCpu1.createData100PercentUtilization(ZERO_DURATION);
        this.measurementsCpu2.createData100PercentUtilization(ZERO_DURATION);

        initializeSwitch();

        Amount<Power> actual = this.switchUnderTest.doSwitch(this.rootPdu);
        Amount<Power> expected = Amount.valueOf(600d, SI.WATT)
            .plus(Amount.valueOf(300d, SI.WATT));
        assertEquals(expected.doubleValue(SI.WATT), actual.doubleValue(SI.WATT), DELTA);
    }

    @Test
    public void testPowerAtMountedPdu() {
        this.measurementsCpu1.createData100PercentUtilization(ZERO_DURATION);
        this.measurementsCpu2.createData100PercentUtilization(ZERO_DURATION);

        initializeSwitch();

        Amount<Power> actual = this.switchUnderTest.doSwitch(this.mountedPdu);
        Amount<Power> expected = Amount.valueOf(600d, SI.WATT);
        assertEquals(expected.doubleValue(SI.WATT), actual.doubleValue(SI.WATT), DELTA);
    }

    @Test
    public void testPowerAtRepo() {
        this.measurementsCpu1.createData50PercentUtilization(ZERO_DURATION);
        this.measurementsCpu2.createData50PercentUtilization(ZERO_DURATION);

        initializeSwitch();

        Amount<Power> actual = this.switchUnderTest.doSwitch(this.infrastructureRepo);
        Amount<Power> expected = Amount.valueOf(500d, SI.WATT)
            .plus(Amount.valueOf(250d, SI.WATT));
        assertEquals(expected.doubleValue(SI.WATT), actual.doubleValue(SI.WATT), DELTA);
    }

    @Test
    public void testPowerAtNestedMountedPdu2() {
        this.measurementsCpu1.createData75PercentUtilization(ZERO_DURATION);
        this.measurementsCpu2.createData75PercentUtilization(ZERO_DURATION);

        initializeSwitch();

        Amount<Power> actual = this.switchUnderTest.doSwitch(this.nestedMountedPdu2);
        Amount<Power> expected = Amount.valueOf(275d, SI.WATT);
        assertEquals(expected.doubleValue(SI.WATT), actual.doubleValue(SI.WATT), DELTA);
    }

    @Test
    public void testPowerAtCpu2() {
        this.measurementsCpu1.createData75PercentUtilization(ZERO_DURATION);
        this.measurementsCpu2.createData75PercentUtilization(ZERO_DURATION);

        initializeSwitch();

        Amount<Power> actual = this.switchUnderTest.doSwitch(this.cpu2);
        Amount<Power> expected = Amount.valueOf(275d, SI.WATT);
        assertEquals(expected.doubleValue(SI.WATT), actual.doubleValue(SI.WATT), DELTA);
    }

    @Test
    public void testPowerAtNestedMountedPdu1() {
        this.measurementsCpu1.createData25PercentUtilization(ZERO_DURATION);
        this.measurementsCpu2.createData25PercentUtilization(ZERO_DURATION);

        initializeSwitch();

        Amount<Power> actual = this.switchUnderTest.doSwitch(this.nestedMountedPdu1);
        Amount<Power> expected = Amount.valueOf(450d, SI.WATT);
        assertEquals(expected.doubleValue(SI.WATT), actual.doubleValue(SI.WATT), DELTA);
    }

    @Test
    public void testPowerAtCpu1() {
        this.measurementsCpu1.createData25PercentUtilization(ZERO_DURATION);
        this.measurementsCpu2.createData25PercentUtilization(ZERO_DURATION);

        initializeSwitch();

        Amount<Power> actual = this.switchUnderTest.doSwitch(this.nestedMountedPdu1);
        Amount<Power> expected = Amount.valueOf(450d, SI.WATT);
        assertEquals(expected.doubleValue(SI.WATT), actual.doubleValue(SI.WATT), DELTA);
    }
}
