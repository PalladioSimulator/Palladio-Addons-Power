/**
 */
package de.fzi.power.state.tests;

import de.fzi.power.state.PowerStateMachine;
import de.fzi.power.state.StateFactory;
import de.fzi.power.util.tests.EntityTest;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Power State Machine</b></em>'.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class PowerStateMachineTest extends EntityTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(PowerStateMachineTest.class);
    }

    /**
     * Constructs a new Power State Machine test case with the given name. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public PowerStateMachineTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Power State Machine test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected PowerStateMachine getFixture() {
        return (PowerStateMachine) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(StateFactory.eINSTANCE.createPowerStateMachine());
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

} // PowerStateMachineTest
