/**
 */
package de.fzi.power.specification.tests;

import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Resource Power Model Specification</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ResourcePowerModelSpecificationTest extends PowerModelSpecificationTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(final String[] args) {
        TestRunner.run(ResourcePowerModelSpecificationTest.class);
    }

    /**
     * Constructs a new Resource Power Model Specification test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourcePowerModelSpecificationTest(final String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Resource Power Model Specification test case. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected ResourcePowerModelSpecification getFixture() {
        return (ResourcePowerModelSpecification) this.fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        this.setFixture(SpecificationFactory.eINSTANCE.createResourcePowerModelSpecification());
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

} // ResourcePowerModelSpecificationTest
