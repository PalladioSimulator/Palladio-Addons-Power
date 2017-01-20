/**
 */
package de.fzi.power.infrastructure.tests;

import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Stateful Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class StatefulPowerConsumingResourceTest extends AbstractPowerConsumingResourceTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(StatefulPowerConsumingResourceTest.class);
    }

    /**
     * Constructs a new Stateful Power Consuming Resource test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public StatefulPowerConsumingResourceTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Stateful Power Consuming Resource test case. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected StatefulPowerConsumingResource getFixture() {
        return (StatefulPowerConsumingResource) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(InfrastructureFactory.eINSTANCE.createStatefulPowerConsumingResource());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        this.setFixture(null);
    }

} // StatefulPowerConsumingResourceTest
