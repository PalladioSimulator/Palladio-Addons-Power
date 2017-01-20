/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.BlackBoxDistributionPowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Black Box Distribution Power Model Specification</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class BlackBoxDistributionPowerModelSpecificationTest extends DistributionPowerModelSpecificationTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(BlackBoxDistributionPowerModelSpecificationTest.class);
    }

    /**
     * Constructs a new Black Box Distribution Power Model Specification test case with the given
     * name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BlackBoxDistributionPowerModelSpecificationTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Black Box Distribution Power Model Specification test case. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected BlackBoxDistributionPowerModelSpecification getFixture() {
        return (BlackBoxDistributionPowerModelSpecification) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(SpecificationFactory.eINSTANCE.createBlackBoxDistributionPowerModelSpecification());
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

} // BlackBoxDistributionPowerModelSpecificationTest
