/**
 */
package de.fzi.power.binding.tests;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.FixedFactorValueDimensionless;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Fixed Factor Value Dimensionless</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class FixedFactorValueDimensionlessTest extends AbstractFixedFactorValueTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(FixedFactorValueDimensionlessTest.class);
    }

    /**
     * Constructs a new Fixed Factor Value Dimensionless test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public FixedFactorValueDimensionlessTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Fixed Factor Value Dimensionless test case. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected FixedFactorValueDimensionless getFixture() {
        return (FixedFactorValueDimensionless) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(BindingFactory.eINSTANCE.createFixedFactorValueDimensionless());
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

} // FixedFactorValueDimensionlessTest
