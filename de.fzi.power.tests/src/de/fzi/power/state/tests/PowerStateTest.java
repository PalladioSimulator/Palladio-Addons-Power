/**
 */
package de.fzi.power.state.tests;

import de.fzi.power.state.PowerState;
import de.fzi.power.state.StateFactory;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Power State</b></em>'. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class PowerStateTest extends AbstractPowerStateTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(PowerStateTest.class);
    }

    /**
     * Constructs a new Power State test case with the given name. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public PowerStateTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Power State test case. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    protected PowerState getFixture() {
        return (PowerState) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(StateFactory.eINSTANCE.createPowerState());
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

} // PowerStateTest
