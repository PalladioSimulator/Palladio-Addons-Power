/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.SpecificationFactory;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Fixed Factor</b></em>'. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class FixedFactorTest extends ConsumptionFactorTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(FixedFactorTest.class);
    }

    /**
     * Constructs a new Fixed Factor test case with the given name. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public FixedFactorTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Fixed Factor test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected FixedFactor getFixture() {
        return (FixedFactor) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(SpecificationFactory.eINSTANCE.createFixedFactor());
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

} // FixedFactorTest
