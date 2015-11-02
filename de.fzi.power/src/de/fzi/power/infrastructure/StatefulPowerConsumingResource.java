/**
 */
package de.fzi.power.infrastructure;

import de.fzi.power.binding.PowerState;
import de.fzi.power.binding.StatefulResourcePowerBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stateful Power Consuming Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.StatefulPowerConsumingResource#getPowerState <em>Power State</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.StatefulPowerConsumingResource#getStatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.power.infrastructure.InfrastructurePackage#getStatefulPowerConsumingResource()
 * @model
 * @generated
 */
public interface StatefulPowerConsumingResource extends
		AbstractPowerConsumingResource {
	/**
	 * Returns the value of the '<em><b>Power State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Power State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Power State</em>' reference.
	 * @see #setPowerState(PowerState)
	 * @see de.fzi.power.infrastructure.InfrastructurePackage#getStatefulPowerConsumingResource_PowerState()
	 * @model required="true"
	 * @generated
	 */
	PowerState getPowerState();

	/**
	 * Sets the value of the '{@link de.fzi.power.infrastructure.StatefulPowerConsumingResource#getPowerState <em>Power State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power State</em>' reference.
	 * @see #getPowerState()
	 * @generated
	 */
	void setPowerState(PowerState value);

	/**
	 * Returns the value of the '<em><b>Stateful Resource Power Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stateful Resource Power Binding</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stateful Resource Power Binding</em>' reference.
	 * @see #setStatefulResourcePowerBinding(StatefulResourcePowerBinding)
	 * @see de.fzi.power.infrastructure.InfrastructurePackage#getStatefulPowerConsumingResource_StatefulResourcePowerBinding()
	 * @model required="true"
	 * @generated
	 */
	StatefulResourcePowerBinding getStatefulResourcePowerBinding();

	/**
	 * Sets the value of the '{@link de.fzi.power.infrastructure.StatefulPowerConsumingResource#getStatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stateful Resource Power Binding</em>' reference.
	 * @see #getStatefulResourcePowerBinding()
	 * @generated
	 */
	void setStatefulResourcePowerBinding(StatefulResourcePowerBinding value);

} // StatefulPowerConsumingResource
