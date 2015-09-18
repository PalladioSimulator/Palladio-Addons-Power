/**
 */
package de.fzi.power.binding.tests;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.ResourcePowerBinding;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Resource Power Binding</b></em>
 * '. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ResourcePowerBindingTest extends PowerBindingTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(ResourcePowerBindingTest.class);
    }

    /**
     * Constructs a new Resource Power Binding test case with the given name. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourcePowerBindingTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Resource Power Binding test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected ResourcePowerBinding getFixture() {
        return (ResourcePowerBinding) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(BindingFactory.eINSTANCE.createResourcePowerBinding());
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

} // ResourcePowerBindingTest
