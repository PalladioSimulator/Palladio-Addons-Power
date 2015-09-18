/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Declarative Power Model Specification</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DeclarativePowerModelSpecificationTest extends ResourcePowerModelSpecificationTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(DeclarativePowerModelSpecificationTest.class);
    }

    /**
     * Constructs a new Declarative Power Model Specification test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DeclarativePowerModelSpecificationTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Declarative Power Model Specification test case. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected DeclarativePowerModelSpecification getFixture() {
        return (DeclarativePowerModelSpecification) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(SpecificationFactory.eINSTANCE.createDeclarativePowerModelSpecification());
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

} // DeclarativePowerModelSpecificationTest
