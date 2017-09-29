/**
 */
package de.fzi.power.infrastructure;

import de.fzi.power.binding.AbstractPowerStateBinding;
import de.fzi.power.binding.StatefulResourcePowerBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stateful Power Consuming Resource Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.StatefulPowerConsumingResourceSet#getPowerState <em>Power State</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.StatefulPowerConsumingResourceSet#getStatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.infrastructure.InfrastructurePackage#getStatefulPowerConsumingResourceSet()
 * @model
 * @generated
 */
public interface StatefulPowerConsumingResourceSet extends AbstractPowerConsumingResource {
    /**
     * Returns the value of the '<em><b>Power State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power State</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Power State</em>' reference.
     * @see #setPowerState(AbstractPowerStateBinding)
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getStatefulPowerConsumingResourceSet_PowerState()
     * @model required="true"
     * @generated
     */
    AbstractPowerStateBinding getPowerState();

    /**
     * Sets the value of the '{@link de.fzi.power.infrastructure.StatefulPowerConsumingResourceSet#getPowerState <em>Power State</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Power State</em>' reference.
     * @see #getPowerState()
     * @generated
     */
    void setPowerState(AbstractPowerStateBinding value);

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
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getStatefulPowerConsumingResourceSet_StatefulResourcePowerBinding()
     * @model required="true"
     * @generated
     */
    StatefulResourcePowerBinding getStatefulResourcePowerBinding();

    /**
     * Sets the value of the '{@link de.fzi.power.infrastructure.StatefulPowerConsumingResourceSet#getStatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stateful Resource Power Binding</em>' reference.
     * @see #getStatefulResourcePowerBinding()
     * @generated
     */
    void setStatefulResourcePowerBinding(StatefulResourcePowerBinding value);

} // StatefulPowerConsumingResourceSet
