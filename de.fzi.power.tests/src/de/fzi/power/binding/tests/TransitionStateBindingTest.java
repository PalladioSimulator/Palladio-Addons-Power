/**
 */
package de.fzi.power.binding.tests;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.TransitionStateBinding;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Transition State Binding</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class TransitionStateBindingTest extends AbstractPowerStateBindingTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(TransitionStateBindingTest.class);
    }

    /**
     * Constructs a new Transition State Binding test case with the given name. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TransitionStateBindingTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Transition State Binding test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected TransitionStateBinding getFixture() {
        return (TransitionStateBinding) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(BindingFactory.eINSTANCE.createTransitionStateBinding());
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

} // TransitionStateBindingTest
