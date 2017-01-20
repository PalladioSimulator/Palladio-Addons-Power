/**
 */
package de.fzi.power.binding.tests;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.ConsumptionBehavior;
import de.fzi.power.util.tests.EntityTest;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Consumption Behavior</b></em>'.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConsumptionBehaviorTest extends EntityTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(ConsumptionBehaviorTest.class);
    }

    /**
     * Constructs a new Consumption Behavior test case with the given name. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ConsumptionBehaviorTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Consumption Behavior test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected ConsumptionBehavior getFixture() {
        return (ConsumptionBehavior) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(BindingFactory.eINSTANCE.createConsumptionBehavior());
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

} // ConsumptionBehaviorTest
