/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.DeclarativeResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Declarative Resource Power Model Specification</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DeclarativeResourcePowerModelSpecificationTest extends DeclarativePowerModelSpecificationTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(DeclarativeResourcePowerModelSpecificationTest.class);
    }

    /**
     * Constructs a new Declarative Resource Power Model Specification test case with the given
     * name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DeclarativeResourcePowerModelSpecificationTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Declarative Resource Power Model Specification test case. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected DeclarativeResourcePowerModelSpecification getFixture() {
        return (DeclarativeResourcePowerModelSpecification) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(SpecificationFactory.eINSTANCE.createDeclarativeResourcePowerModelSpecification());
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

} // DeclarativeResourcePowerModelSpecificationTest
