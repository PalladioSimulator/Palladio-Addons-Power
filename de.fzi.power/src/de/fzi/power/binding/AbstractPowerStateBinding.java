/**
 */
package de.fzi.power.binding;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Power State Binding</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.AbstractPowerStateBinding#getStatefulResourcePowerBinding
 * <em>Stateful Resource Power Binding</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getAbstractPowerStateBinding()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPowerStateBinding extends Entity {
    /**
     * Returns the value of the '<em><b>Stateful Resource Power Binding</b></em>' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStateBindings
     * <em>Power State Bindings</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stateful Resource Power Binding</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Stateful Resource Power Binding</em>' container reference.
     * @see #setStatefulResourcePowerBinding(StatefulResourcePowerBinding)
     * @see de.fzi.power.binding.BindingPackage#getAbstractPowerStateBinding_StatefulResourcePowerBinding()
     * @see de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStateBindings
     * @model opposite="powerStateBindings" transient="false"
     * @generated
     */
    StatefulResourcePowerBinding getStatefulResourcePowerBinding();

    /**
     * Sets the value of the '
     * {@link de.fzi.power.binding.AbstractPowerStateBinding#getStatefulResourcePowerBinding
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

} // AbstractPowerStateBinding
