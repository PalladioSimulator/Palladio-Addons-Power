/**
 */
package de.fzi.power.binding.tests;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.DistributionPowerBinding;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Distribution Power Binding</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DistributionPowerBindingTest extends PowerBindingTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(DistributionPowerBindingTest.class);
    }

    /**
     * Constructs a new Distribution Power Binding test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DistributionPowerBindingTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Distribution Power Binding test case. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected DistributionPowerBinding getFixture() {
        return (DistributionPowerBinding) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(BindingFactory.eINSTANCE.createDistributionPowerBinding());
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

} // DistributionPowerBindingTest
