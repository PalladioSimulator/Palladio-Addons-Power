/**
 */
package de.fzi.power.infrastructure;

import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link de.fzi.power.infrastructure.AbstractPowerConsumingResource#getProcessingResourceSpecification
 * <em>Processing Resource Specification</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.infrastructure.InfrastructurePackage#getAbstractPowerConsumingResource()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPowerConsumingResource extends PowerConsumingEntity {
    /**
     * Returns the value of the '<em><b>Processing Resource Specification</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Processing Resource Specification</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Processing Resource Specification</em>' reference.
     * @see #setProcessingResourceSpecification(ProcessingResourceSpecification)
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getAbstractPowerConsumingResource_ProcessingResourceSpecification()
     * @model required="true" ordered="false"
     * @generated
     */
    ProcessingResourceSpecification getProcessingResourceSpecification();

    /**
     * Sets the value of the '
     * {@link de.fzi.power.infrastructure.AbstractPowerConsumingResource#getProcessingResourceSpecification
     * <em>Processing Resource Specification</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Processing Resource Specification</em>' reference.
     * @see #getProcessingResourceSpecification()
     * @generated
     */
    void setProcessingResourceSpecification(ProcessingResourceSpecification value);

} // AbstractPowerConsumingResource
