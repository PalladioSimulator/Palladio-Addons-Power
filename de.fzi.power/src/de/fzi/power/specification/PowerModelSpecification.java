/**
 */
package de.fzi.power.specification;

import org.eclipse.emf.common.util.EList;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Power Model Specification</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.specification.PowerModelSpecification#getPowermodelrepository
 * <em>Powermodelrepository</em>}</li>
 * <li>{@link de.fzi.power.specification.PowerModelSpecification#getConsumptionFactors
 * <em>Consumption Factors</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.specification.SpecificationPackage#getPowerModelSpecification()
 * @model abstract="true"
 * @generated
 */
public interface PowerModelSpecification extends Entity {
    /**
     * Returns the value of the '<em><b>Powermodelrepository</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.power.specification.PowerModelRepository#getPowerModelSpecifications
     * <em>Power Model Specifications</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Powermodelrepository</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Powermodelrepository</em>' container reference.
     * @see #setPowermodelrepository(PowerModelRepository)
     * @see de.fzi.power.specification.SpecificationPackage#getPowerModelSpecification_Powermodelrepository()
     * @see de.fzi.power.specification.PowerModelRepository#getPowerModelSpecifications
     * @model opposite="powerModelSpecifications" transient="false"
     * @generated
     */
    PowerModelRepository getPowermodelrepository();

    /**
     * Sets the value of the '
     * {@link de.fzi.power.specification.PowerModelSpecification#getPowermodelrepository
     * <em>Powermodelrepository</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Powermodelrepository</em>' container reference.
     * @see #getPowermodelrepository()
     * @generated
     */
    void setPowermodelrepository(PowerModelRepository value);

    /**
     * Returns the value of the '<em><b>Consumption Factors</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.specification.ConsumptionFactor}. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.power.specification.ConsumptionFactor#getPowerModel <em>Power Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Consumption Factors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Consumption Factors</em>' containment reference list.
     * @see de.fzi.power.specification.SpecificationPackage#getPowerModelSpecification_ConsumptionFactors()
     * @see de.fzi.power.specification.ConsumptionFactor#getPowerModel
     * @model opposite="powerModel" containment="true"
     * @generated
     */
    EList<ConsumptionFactor> getConsumptionFactors();

} // PowerModelSpecification
