/**
 */
package de.fzi.power.specification;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see de.fzi.power.specification.SpecificationPackage
 * @generated
 */
public interface SpecificationFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    SpecificationFactory eINSTANCE = de.fzi.power.specification.impl.SpecificationFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Power Model Repository</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Power Model Repository</em>'.
     * @generated
     */
    PowerModelRepository createPowerModelRepository();

    /**
     * Returns a new object of class '<em>Fixed Factor</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Fixed Factor</em>'.
     * @generated
     */
    FixedFactor createFixedFactor();

    /**
     * Returns a new object of class '<em>Measured Factor</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Measured Factor</em>'.
     * @generated
     */
    MeasuredFactor createMeasuredFactor();

    /**
     * Returns a new object of class '<em>Declarative Power Model Specification</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Declarative Power Model Specification</em>'.
     * @generated
     */
    DeclarativePowerModelSpecification createDeclarativePowerModelSpecification();

    /**
     * Returns a new object of class '<em>Declarative Resource Power Model Specification</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Declarative Resource Power Model Specification</em>'.
     * @generated
     */
    DeclarativeResourcePowerModelSpecification createDeclarativeResourcePowerModelSpecification();

    /**
     * Returns a new object of class '<em>Declarative Distribution Power Model Specification</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Declarative Distribution Power Model Specification</em>'.
     * @generated
     */
    DeclarativeDistributionPowerModelSpecification createDeclarativeDistributionPowerModelSpecification();

    /**
     * Returns a new object of class '<em>Black Box Distribution Power Model Specification</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Black Box Distribution Power Model Specification</em>'.
     * @generated
     */
    BlackBoxDistributionPowerModelSpecification createBlackBoxDistributionPowerModelSpecification();

    /**
     * Returns a new object of class '<em>Black Box Resource Power Model Specification</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Black Box Resource Power Model Specification</em>'.
     * @generated
     */
    BlackBoxResourcePowerModelSpecification createBlackBoxResourcePowerModelSpecification();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    SpecificationPackage getSpecificationPackage();

} // SpecificationFactory
