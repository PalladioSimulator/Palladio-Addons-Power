package de.fzi.power.interpreter.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Power;
import javax.measure.unit.SI;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.jscience.physics.amount.Amount;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.experimentanalysis.utilizationfilter.UtilizationFilterConfiguration;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;

import de.fzi.power.binding.PowerBindingRepository;
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
import de.fzi.power.interpreter.calculators.ExtensibleCalculatorInstantiatorImpl;
import de.fzi.power.interpreter.measureprovider.ExtendedMeasureProvider;
import de.fzi.power.interpreter.measureprovider.utilization.UtilizationFilterMeasureProvider;
import de.fzi.power.interpreter.tests.utils.MockStateOfActiveResourceTupleDataSource;

/**
 * This class contains test cases for the {@link PowerConsumptionSwitch}.
 * 
 * @author Florian Rosenthal
 *
 */
public class PowerConsumptionSwitchTest {

    private static final String BINDING_REPO_LOCATION = "platform:/plugin/de.fzi.power.interpreter.tests/resources/testBinding.binding";
    private static final String INFRASTRUCTURE_REPO_LOCATION = "platform:/plugin/de.fzi.power.interpreter.tests/resources/testInfrastructure.infrastructure";

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

    @BeforeClass
    public static void setupBeforeClass() {
        final ResourceSet resourceSet = new ResourceSetImpl();
        bindingResource = resourceSet.createResource(URI.createURI(BINDING_REPO_LOCATION, true));
        try {
            bindingResource.load(Collections.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        infrastructureResource = resourceSet.createResource(URI.createURI(INFRASTRUCTURE_REPO_LOCATION, true));
        try {
            infrastructureResource.load(Collections.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownAfterClass() {
        try {
            bindingResource.delete(Collections.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            infrastructureResource.delete(Collections.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {

        this.powerBindingRepo = (PowerBindingRepository) bindingResource.getEObject("_Ey4nUETHEeSB-oPaAunQcg");
        this.rootPdu = (PowerDistributionUnit) infrastructureResource.getEObject("_98ByQEWMEeSZH5zlL3RMGg");
        this.infrastructureRepo = this.rootPdu.getPowerInfrastructureModel();
        
        List<PowerConsumingEntity> nestedPces = this.rootPdu.getNestedPowerConsumingEntities();
        this.mountedPdu = (MountedPowerDistributionUnit) nestedPces.get(0);
        this.nestedMountedPdu2 = (MountedPowerDistributionUnit) nestedPces.get(1);
        this.nestedMountedPdu1 = (MountedPowerDistributionUnit) this.mountedPdu.getNestedPowerConsumingEntities().get(0);
        this.cpu1 = (PowerConsumingResourceSet) this.nestedMountedPdu1.getNestedPowerConsumingEntities().get(0);
        this.cpu2 = (PowerConsumingResourceSet) this.nestedMountedPdu2.getNestedPowerConsumingEntities().get(0);

        this.windowLength = Measure.valueOf(10d, SI.SECOND);
        this.cpu1MeasuringPoint = PcmmeasuringpointFactory.eINSTANCE.createActiveResourceMeasuringPoint();
        this.cpu1MeasuringPoint.setActiveResource(this.cpu1.getProcessingResourceSpecifications().get(0));
        this.cpu2MeasuringPoint = PcmmeasuringpointFactory.eINSTANCE.createActiveResourceMeasuringPoint();
        this.cpu2MeasuringPoint.setActiveResource(this.cpu2.getProcessingResourceSpecifications().get(0));

        this.measurementsCpu1 = new MockStateOfActiveResourceTupleDataSource(this.windowLength, this.cpu1MeasuringPoint);
        this.measurementsCpu2 = new MockStateOfActiveResourceTupleDataSource(this.windowLength, this.cpu2MeasuringPoint);

        this.modelRegistry = new PowerModelRegistry();
        // set the calculators/attach power models
        new PowerModelUpdaterSwitch(this.modelRegistry, new ExtensibleCalculatorInstantiatorImpl()).doSwitch(this.infrastructureRepo);
    }

    private void initializeSwitch() {
        List<IDataSource> datasources = new ArrayList<IDataSource>();
        datasources.add(this.measurementsCpu1);
        datasources.add(this.measurementsCpu2);
        
        ExtendedMeasureProvider prov = new UtilizationFilterMeasureProvider();
        Map<String, Object> filterProperties = 
                new HashMap<String, Object>(prov.getProperties());
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_INCREMENT_KEY, 
                this.windowLength);
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_LENGTH_KEY, 
                this.windowLength);
        prov.setProperties(filterProperties);

        this.evaluationScope = EvaluationScope.createScope(datasources, 
                Collections.singleton(prov));
        
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
        Amount<Power> expected = Amount.valueOf(600d, SI.WATT).plus(Amount.valueOf(300d, SI.WATT));
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
        Amount<Power> expected = Amount.valueOf(500d, SI.WATT).plus(Amount.valueOf(250d, SI.WATT));
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
