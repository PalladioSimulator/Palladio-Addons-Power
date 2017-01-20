/**
 */
package de.fzi.power.binding.tests;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.PowerStateBinding;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Power State Binding</b></em>'.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class PowerStateBindingTest extends AbstractPowerStateBindingTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(PowerStateBindingTest.class);
    }

    /**
     * Constructs a new Power State Binding test case with the given name. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public PowerStateBindingTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Power State Binding test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected PowerStateBinding getFixture() {
        return (PowerStateBinding) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(BindingFactory.eINSTANCE.createPowerStateBinding());
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

} // PowerStateBindingTest
