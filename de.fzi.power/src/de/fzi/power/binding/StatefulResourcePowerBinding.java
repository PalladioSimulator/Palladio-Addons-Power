/**
 */
package de.fzi.power.binding;

import org.eclipse.emf.common.util.EList;

import de.fzi.power.state.PowerStateMachine;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Stateful Resource Power Binding</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStateMachine <em>Power State Machine</em>}</li>
 *   <li>{@link de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStateBindings <em>Power State Bindings</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getStatefulResourcePowerBinding()
 * @model
 * @generated
 */
public interface StatefulResourcePowerBinding extends PowerBinding {
    /**
     * Returns the value of the '<em><b>Power State Machine</b></em>' reference.
     * <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Power State Machine</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Power State Machine</em>' reference.
     * @see #setPowerStateMachine(PowerStateMachine)
     * @see de.fzi.power.binding.BindingPackage#getStatefulResourcePowerBinding_PowerStateMachine()
     * @model required="true"
     * @generated
     */
    PowerStateMachine getPowerStateMachine();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStateMachine <em>Power State Machine</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Power State Machine</em>' reference.
     * @see #getPowerStateMachine()
     * @generated
     */
    void setPowerStateMachine(PowerStateMachine value);

    /**
     * Returns the value of the '<em><b>Power State Bindings</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.binding.AbstractPowerStateBinding}.
     * It is bidirectional and its opposite is '{@link de.fzi.power.binding.AbstractPowerStateBinding#getStatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power State Bindings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Power State Bindings</em>' containment reference list.
     * @see de.fzi.power.binding.BindingPackage#getStatefulResourcePowerBinding_PowerStateBindings()
     * @see de.fzi.power.binding.AbstractPowerStateBinding#getStatefulResourcePowerBinding
     * @model opposite="statefulResourcePowerBinding" containment="true" required="true"
     * @generated
     */
    EList<AbstractPowerStateBinding> getPowerStateBindings();

} // StatefulResourcePowerBinding
