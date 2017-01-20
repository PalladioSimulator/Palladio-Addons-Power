/**
 */
package de.fzi.power.binding.tests;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Stateful Resource Power Binding</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class StatefulResourcePowerBindingTest extends PowerBindingTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(StatefulResourcePowerBindingTest.class);
    }

    /**
     * Constructs a new Stateful Resource Power Binding test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public StatefulResourcePowerBindingTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Stateful Resource Power Binding test case. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected StatefulResourcePowerBinding getFixture() {
        return (StatefulResourcePowerBinding) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(BindingFactory.eINSTANCE.createStatefulResourcePowerBinding());
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

} // StatefulResourcePowerBindingTest
