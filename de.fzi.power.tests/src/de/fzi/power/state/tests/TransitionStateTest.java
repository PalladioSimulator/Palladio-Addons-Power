/**
 */
package de.fzi.power.state.tests;

import de.fzi.power.state.StateFactory;
import de.fzi.power.state.TransitionState;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Transition State</b></em>'. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class TransitionStateTest extends AbstractPowerStateTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(TransitionStateTest.class);
    }

    /**
     * Constructs a new Transition State test case with the given name. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public TransitionStateTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Transition State test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected TransitionState getFixture() {
        return (TransitionState) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(StateFactory.eINSTANCE.createTransitionState());
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

} // TransitionStateTest
