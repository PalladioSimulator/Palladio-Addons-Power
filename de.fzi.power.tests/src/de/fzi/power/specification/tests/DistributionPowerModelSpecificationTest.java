/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.DistributionPowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Distribution Power Model Specification</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DistributionPowerModelSpecificationTest extends PowerModelSpecificationTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(DistributionPowerModelSpecificationTest.class);
    }

    /**
     * Constructs a new Distribution Power Model Specification test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DistributionPowerModelSpecificationTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Distribution Power Model Specification test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected DistributionPowerModelSpecification getFixture() {
        return (DistributionPowerModelSpecification) fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(SpecificationFactory.eINSTANCE.createDistributionPowerModelSpecification());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        setFixture(null);
    }

} //DistributionPowerModelSpecificationTest
