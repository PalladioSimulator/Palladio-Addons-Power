/**
 */
package de.fzi.power.binding;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Power State</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.AbstractPowerState#getStatefulResourcePowerBinding
 * <em>Stateful Resource Power Binding</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getAbstractPowerState()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPowerState extends Entity {
    /**
     * Returns the value of the '<em><b>Stateful Resource Power Binding</b></em>' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStates <em>Power States</em>
     * }'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stateful Resource Power Binding</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Stateful Resource Power Binding</em>' container reference.
     * @see #setStatefulResourcePowerBinding(StatefulResourcePowerBinding)
     * @see de.fzi.power.binding.BindingPackage#getAbstractPowerState_StatefulResourcePowerBinding()
     * @see de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStates
     * @model opposite="powerStates" transient="false"
     * @generated
     */
    StatefulResourcePowerBinding getStatefulResourcePowerBinding();

    /**
     * Sets the value of the '
     * {@link de.fzi.power.binding.AbstractPowerState#getStatefulResourcePowerBinding
     * <em>Stateful Resource Power Binding</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Stateful Resource Power Binding</em>' container
     *            reference.
     * @see #getStatefulResourcePowerBinding()
     * @generated
     */
    void setStatefulResourcePowerBinding(StatefulResourcePowerBinding value);

} // AbstractPowerState
