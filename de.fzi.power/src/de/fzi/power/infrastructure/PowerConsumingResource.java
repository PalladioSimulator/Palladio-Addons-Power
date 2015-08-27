/**
 */
package de.fzi.power.infrastructure;

import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

import de.fzi.power.binding.ResourcePowerBinding;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.PowerConsumingResource#getProcessingResourceSpecification <em>Processing Resource Specification</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.PowerConsumingResource#getResourcePowerAssemblyContext <em>Resource Power Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerConsumingResource()
 * @model
 * @generated
 */
public interface PowerConsumingResource extends PowerConsumingEntity {
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
	 * @see #setProcessingResourceSpecification(org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification)
	 * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerConsumingResource_ProcessingResourceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceSpecification getProcessingResourceSpecification();

	/**
	 * Sets the value of the '{@link de.fzi.power.infrastructure.PowerConsumingResource#getProcessingResourceSpecification <em>Processing Resource Specification</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Processing Resource Specification</em>' reference.
	 * @see #getProcessingResourceSpecification()
	 * @generated
	 */
	void setProcessingResourceSpecification(
			ProcessingResourceSpecification value);

	/**
	 * Returns the value of the '<em><b>Resource Power Assembly Context</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Power Assembly Context</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Resource Power Assembly Context</em>' reference.
	 * @see #setResourcePowerAssemblyContext(ResourcePowerBinding)
	 * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerConsumingResource_ResourcePowerAssemblyContext()
	 * @model
	 * @generated
	 */
	ResourcePowerBinding getResourcePowerAssemblyContext();

	/**
	 * Sets the value of the '{@link de.fzi.power.infrastructure.PowerConsumingResource#getResourcePowerAssemblyContext <em>Resource Power Assembly Context</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Resource Power Assembly Context</em>' reference.
	 * @see #getResourcePowerAssemblyContext()
	 * @generated
	 */
	void setResourcePowerAssemblyContext(ResourcePowerBinding value);

} // PowerConsumingResource
