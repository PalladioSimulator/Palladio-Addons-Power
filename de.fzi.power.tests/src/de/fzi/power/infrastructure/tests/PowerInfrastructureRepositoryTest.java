/**
 */
package de.fzi.power.infrastructure.tests;

import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Power Infrastructure Repository</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PowerInfrastructureRepositoryTest extends TestCase {

    /**
     * The fixture for this Power Infrastructure Repository test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected PowerInfrastructureRepository fixture = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(PowerInfrastructureRepositoryTest.class);
    }

    /**
     * Constructs a new Power Infrastructure Repository test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PowerInfrastructureRepositoryTest(final String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Power Infrastructure Repository test case. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void setFixture(final PowerInfrastructureRepository fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Power Infrastructure Repository test case. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PowerInfrastructureRepository getFixture() {
        return this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(InfrastructureFactory.eINSTANCE.createPowerInfrastructureRepository());
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

} // PowerInfrastructureRepositoryTest
