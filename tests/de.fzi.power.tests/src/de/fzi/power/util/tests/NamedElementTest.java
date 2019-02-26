/**
 */
package de.fzi.power.util.tests;

import de.fzi.power.util.NamedElement;
import de.fzi.power.util.UtilFactory;
import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Named Element</b></em>'. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class NamedElementTest extends TestCase {

    /**
     * The fixture for this Named Element test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NamedElement fixture = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(NamedElementTest.class);
    }

    /**
     * Constructs a new Named Element test case with the given name. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public NamedElementTest(final String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Named Element test case. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    protected void setFixture(final NamedElement fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Named Element test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected NamedElement getFixture() {
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
        this.setFixture(UtilFactory.eINSTANCE.createNamedElement());
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

} // NamedElementTest
