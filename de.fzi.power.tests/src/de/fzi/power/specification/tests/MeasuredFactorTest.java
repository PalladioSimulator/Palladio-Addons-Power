/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Measured Factor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeasuredFactorTest extends ConsumptionFactorTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(MeasuredFactorTest.class);
    }

    /**
     * Constructs a new Measured Factor test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MeasuredFactorTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Measured Factor test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected MeasuredFactor getFixture() {
        return (MeasuredFactor) fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(SpecificationFactory.eINSTANCE.createMeasuredFactor());
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

} //MeasuredFactorTest
