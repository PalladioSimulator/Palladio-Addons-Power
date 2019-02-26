/**
 */
package de.fzi.power.binding.tests;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.PowerBindingRepository;
import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Power Binding Repository</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PowerBindingRepositoryTest extends TestCase {

    /**
     * The fixture for this Power Binding Repository test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected PowerBindingRepository fixture = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(PowerBindingRepositoryTest.class);
    }

    /**
     * Constructs a new Power Binding Repository test case with the given name. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PowerBindingRepositoryTest(final String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Power Binding Repository test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void setFixture(final PowerBindingRepository fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Power Binding Repository test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected PowerBindingRepository getFixture() {
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
        this.setFixture(BindingFactory.eINSTANCE.createPowerBindingRepository());
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

} // PowerBindingRepositoryTest
