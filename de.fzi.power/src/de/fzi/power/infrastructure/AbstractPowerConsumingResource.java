/**
 */
package de.fzi.power.infrastructure;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.AbstractPowerConsumingResource#getProcessingResourceSpecifications <em>Processing Resource Specifications</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.infrastructure.InfrastructurePackage#getAbstractPowerConsumingResource()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPowerConsumingResource extends PowerConsumingEntity {
    /**
     * Returns the value of the '<em><b>Processing Resource Specifications</b></em>' reference list.
     * The list contents are of type {@link org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Processing Resource Specifications</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Processing Resource Specifications</em>' reference list.
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getAbstractPowerConsumingResource_ProcessingResourceSpecifications()
     * @model required="true" ordered="false"
     * @generated
     */
    EList<ProcessingResourceSpecification> getProcessingResourceSpecifications();

} // AbstractPowerConsumingResource
