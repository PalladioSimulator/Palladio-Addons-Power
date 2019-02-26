/**
 */
package de.fzi.power.infrastructure.tests;

import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerConsumingResourceSet;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PowerConsumingResourceTest extends AbstractPowerConsumingResourceTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(PowerConsumingResourceTest.class);
    }

    /**
     * Constructs a new Power Consuming Resource test case with the given name. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PowerConsumingResourceTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Power Consuming Resource test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected PowerConsumingResourceSet getFixture() {
        return (PowerConsumingResourceSet) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(InfrastructureFactory.eINSTANCE.createPowerConsumingResourceSet());
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

} // PowerConsumingResourceTest
