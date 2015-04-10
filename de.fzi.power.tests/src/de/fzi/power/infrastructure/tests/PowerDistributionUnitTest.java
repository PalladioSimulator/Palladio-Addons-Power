/**
 */
package de.fzi.power.infrastructure.tests;

import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerDistributionUnit;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Power Distribution Unit</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PowerDistributionUnitTest extends PowerConsumingProvidingEntityTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(PowerDistributionUnitTest.class);
    }

    /**
     * Constructs a new Power Distribution Unit test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PowerDistributionUnitTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Power Distribution Unit test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected PowerDistributionUnit getFixture() {
        return (PowerDistributionUnit) fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(InfrastructureFactory.eINSTANCE.createPowerDistributionUnit());
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

} //PowerDistributionUnitTest
