package de.fzi.power.interpreter.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.jscience.physics.amount.Amount;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.experimentanalysis.utilizationfilter.UtilizationFilterConfiguration;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentFactory;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;

import de.fzi.power.interpreter.EvaluationScope;
import de.fzi.power.interpreter.measureprovider.ExtendedMeasureProvider;
import de.fzi.power.interpreter.measureprovider.utilization.UtilizationFilterMeasureProvider;
import de.fzi.power.interpreter.tests.utils.MockStateOfActiveResourceTupleDataSource;

public class EvaluationScopeTest {

    private static final MetricSetDescription expectedOutputDataMetric = MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE_TUPLE;
    private static final MetricDescription expectedUtilizationMetric = MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE;
    private static final double DELTA = Math.pow(10, -12);
    private static final Amount<Duration> ZERO_DURATION = Amount.valueOf(0, SI.SECOND);

    private EvaluationScope scope;
    private ProcessingResourceSpecification cpu;
    private ActiveResourceMeasuringPoint cpuMeasuringPoint;
    private ProcessingResourceSpecification hdd;
    private ActiveResourceMeasuringPoint hddMeasuringPoint;
    private UtilizationFilterConfiguration config;
    private Amount<Duration> windowLengthAmount;
    private List<IDataSource> scopeInputDatasources;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setUp() throws Exception {
        this.scopeInputDatasources = new LinkedList<IDataSource>();
        this.config = new UtilizationFilterConfiguration();
        this.windowLengthAmount = Amount.valueOf(
                config.getWindowLength().doubleValue(config.getWindowLength().getUnit()), config.getWindowLength()
                        .getUnit());
        this.hdd = ResourceenvironmentFactory.eINSTANCE.createProcessingResourceSpecification();
        this.hdd.setId("HDD");
        this.cpu = ResourceenvironmentFactory.eINSTANCE.createProcessingResourceSpecification();
        this.cpu.setId("CPU");

        this.cpuMeasuringPoint = PcmmeasuringpointFactory.eINSTANCE.createActiveResourceMeasuringPoint();
        this.cpuMeasuringPoint.setActiveResource(this.cpu);
        this.hddMeasuringPoint = PcmmeasuringpointFactory.eINSTANCE.createActiveResourceMeasuringPoint();
        this.hddMeasuringPoint.setActiveResource(this.hdd);

        MockStateOfActiveResourceTupleDataSource cpuInputStream = new MockStateOfActiveResourceTupleDataSource(
                config.getWindowLength(), this.cpuMeasuringPoint);
        cpuInputStream.createData75PercentUtilization(ZERO_DURATION); // within the first interval
        cpuInputStream.createData50PercentUtilization(ZERO_DURATION.plus(this.windowLengthAmount));

        MockStateOfActiveResourceTupleDataSource hddInputStream = new MockStateOfActiveResourceTupleDataSource(
                config.getWindowLength(), this.hddMeasuringPoint);
        hddInputStream.createData50PercentUtilization(ZERO_DURATION); // within the first interval
        hddInputStream.createData75PercentUtilization(ZERO_DURATION.plus(this.windowLengthAmount));

        this.scopeInputDatasources.add(cpuInputStream);
        this.scopeInputDatasources.add(hddInputStream);
        
        ExtendedMeasureProvider prov = new UtilizationFilterMeasureProvider();
        Map<String, Object> filterProperties = 
                new HashMap<String, Object>(prov.getProperties());
        //we use window length as window increment here, so that expectations should be met
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_INCREMENT_KEY, 
                config.getWindowIncrement());
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_LENGTH_KEY, 
                config.getWindowLength());
        prov.setProperties(filterProperties);
 
        this.scope = EvaluationScope.createScope(this.scopeInputDatasources, 
                Collections.singleton(prov));
        
        Map<ProcessingResourceSpecification, Set<MetricDescription>> desiredMetrics = 
                new HashMap<ProcessingResourceSpecification, Set<MetricDescription>>(2);
        desiredMetrics.put(cpu, Collections.<MetricDescription>singleton(expectedOutputDataMetric));
        desiredMetrics.put(hdd, Collections.<MetricDescription>singleton(expectedOutputDataMetric));
        this.scope.setResourceMetricsToEvaluate(desiredMetrics);
    }
    
    @Test
    public void testCreateEvaluationScopeNullMeasure() {
        expectedException.expect(IllegalArgumentException.class);
        ExtendedMeasureProvider prov = new UtilizationFilterMeasureProvider();
        
        Map<String, Object> filterProperties = 
                new HashMap<String, Object>(prov.getProperties());
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_INCREMENT_KEY, 
                null);
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_LENGTH_KEY, 
                config.getWindowLength());
        prov.setProperties(filterProperties);
    }

    @Test
    public void testCreateEvaluationScopeNegativeDurationMeasure() {
        ExtendedMeasureProvider prov = new UtilizationFilterMeasureProvider();
        expectedException.expect(new BaseMatcher<Object>() {

             @Override
            public void describeTo(Description description) {
            }

            @Override
            public boolean matches(Object item) {
               return item instanceof UndeclaredThrowableException &&
                       ((UndeclaredThrowableException) item).getUndeclaredThrowable() instanceof InvocationTargetException
                       && ((InvocationTargetException) ((UndeclaredThrowableException) item).getUndeclaredThrowable()).getTargetException() 
                       instanceof IllegalArgumentException;
                       
            }
        });
        Map<String, Object> filterProperties = 
                new HashMap<String, Object>(prov.getProperties());
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_INCREMENT_KEY, 
                config.getWindowIncrement());
        filterProperties.put(UtilizationFilterConfiguration.WINDOW_LENGTH_KEY, 
                Measure.valueOf(-5d, NonSI.HOUR));
            prov.setProperties(filterProperties);
        
    }

    @Test
    public void testGetMeasurementsForProcessingResource() {
        Iterator<MeasuringValue> actual = 
                this.scope.getMeasurementsForProcessingResource(this.cpu, expectedUtilizationMetric);
        assertTrue(actual.hasNext());
        // first measurement
        TupleMeasurement expectedCpuUtilization = new TupleMeasurement(expectedOutputDataMetric,
                config.getWindowLength(), Measure.valueOf(0.75, Unit.ONE));
        Measure<Double, Dimensionless> expected = expectedCpuUtilization.getMeasureForMetric(expectedUtilizationMetric);
        assertEquals(expected.getValue(), (Double) actual.next().getMeasureForMetric(expectedUtilizationMetric)
                .getValue(), DELTA);
        // second measurement
        assertTrue(actual.hasNext());
        expectedCpuUtilization = new TupleMeasurement(expectedOutputDataMetric, config.getWindowLength(),
                Measure.valueOf(0.5, Unit.ONE));
        expected = expectedCpuUtilization.getMeasureForMetric(expectedUtilizationMetric);
        assertEquals(expected.getValue(), (Double) actual.next().getMeasureForMetric(expectedUtilizationMetric)
                .getValue(), DELTA);

        assertFalse(actual.hasNext());
    }
    
    @Test
    public void testIteratorNoSuchElementException() {
         // there's two elements available per processing resource, so let's access the third
        Iterator<?> it = this.scope.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        // now the exception should be thrown
        expectedException.expect(NoSuchElementException.class);
        it.next();
    }

    @Test
    public void testIteratorRemoveUnsupportedOperationException() {
        Iterator<?> it = this.scope.iterator();
        assertTrue(it.hasNext());
        // let's try to remove the current element, now the exception should be thrown
        expectedException.expect(UnsupportedOperationException.class);
        it.remove();
    }
    
    /**
     * Test adding multiple measurement and pulling them from the EvaluationScope.
     */
    @Test
    public void testGetFirstMeasurement() {
        this.scope.next();
        // check cpu utilization
        TupleMeasurement expectedCpuUtilization = new TupleMeasurement(expectedOutputDataMetric,
                config.getWindowLength(), Measure.valueOf(0.75, Unit.ONE));
        Collection<MeasuringValue> measurements = scope.getMeasurements(cpu);
        Measure<Double, Dimensionless> expected = expectedCpuUtilization.getMeasureForMetric(expectedUtilizationMetric);
        assertEquals(measurements.size(), 1);
        assertEquals(expected.getValue(), (Double) measurements.iterator().next()
                    .getMeasureForMetric(expectedUtilizationMetric).getValue(), DELTA);
        
        // check hdd utilization
        TupleMeasurement expectedHddUtilization = new TupleMeasurement(expectedOutputDataMetric,
                config.getWindowLength(), Measure.valueOf(0.5, Unit.ONE));
        expected = expectedHddUtilization.getMeasureForMetric(expectedUtilizationMetric);
        measurements = scope.getMeasurements(hdd);
        assertEquals(measurements.size(), 1);
        assertEquals(expected.getValue(), (Double) measurements.iterator().next()
                    .getMeasureForMetric(expectedUtilizationMetric).getValue(), DELTA);
    }

    @Test
    public void testGetSecondMeasurement() {
        this.scope.next();
        this.scope.next();
        // check cpu utilization
        TupleMeasurement expectedCpuUtilization = new TupleMeasurement(expectedOutputDataMetric,
                config.getWindowLength(), Measure.valueOf(0.5, Unit.ONE));
        Collection<MeasuringValue> measurements = scope.getMeasurements(cpu);
        Measure<Double, Dimensionless> expected = expectedCpuUtilization.getMeasureForMetric(expectedUtilizationMetric);
        assertEquals(measurements.size(), 1);
        assertEquals(expected.getValue(), (Double) measurements.iterator().next()
                .getMeasureForMetric(expectedUtilizationMetric).getValue(), DELTA);
        // check hdd utilization
        TupleMeasurement expectedHddUtilization = new TupleMeasurement(expectedOutputDataMetric,
                config.getWindowLength(), Measure.valueOf(0.75, Unit.ONE));
        expected = expectedHddUtilization.getMeasureForMetric(expectedUtilizationMetric);
        measurements = scope.getMeasurements(hdd);
        assertEquals(measurements.size(), 1);
        assertEquals(expected.getValue(), (Double) measurements.iterator().next()
                    .getMeasureForMetric(expectedUtilizationMetric).getValue(), DELTA);

    }
}
