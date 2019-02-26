/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.BlackBoxResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Black Box Resource Power Model Specification</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class BlackBoxResourcePowerModelSpecificationTest extends ResourcePowerModelSpecificationTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(BlackBoxResourcePowerModelSpecificationTest.class);
    }

    /**
     * Constructs a new Black Box Resource Power Model Specification test case with the given name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BlackBoxResourcePowerModelSpecificationTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Black Box Resource Power Model Specification test case. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected BlackBoxResourcePowerModelSpecification getFixture() {
        return (BlackBoxResourcePowerModelSpecification) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(SpecificationFactory.eINSTANCE.createBlackBoxResourcePowerModelSpecification());
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

} // BlackBoxResourcePowerModelSpecificationTest
