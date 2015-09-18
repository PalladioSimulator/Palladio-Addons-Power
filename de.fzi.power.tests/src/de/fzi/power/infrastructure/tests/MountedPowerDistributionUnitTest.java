/**
 */
package de.fzi.power.infrastructure.tests;

import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Mounted Power Distribution Unit</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class MountedPowerDistributionUnitTest extends PowerDistributionUnitTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(MountedPowerDistributionUnitTest.class);
    }

    /**
     * Constructs a new Mounted Power Distribution Unit test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public MountedPowerDistributionUnitTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Mounted Power Distribution Unit test case. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected MountedPowerDistributionUnit getFixture() {
        return (MountedPowerDistributionUnit) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(InfrastructureFactory.eINSTANCE.createMountedPowerDistributionUnit());
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

} // MountedPowerDistributionUnitTest
