/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.SpecificationFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Power Model Repository</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PowerModelRepositoryTest extends TestCase {

    /**
     * The fixture for this Power Model Repository test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PowerModelRepository fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(PowerModelRepositoryTest.class);
    }

    /**
     * Constructs a new Power Model Repository test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PowerModelRepositoryTest(String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Power Model Repository test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture(PowerModelRepository fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Power Model Repository test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PowerModelRepository getFixture() {
        return fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(SpecificationFactory.eINSTANCE.createPowerModelRepository());
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

} //PowerModelRepositoryTest
