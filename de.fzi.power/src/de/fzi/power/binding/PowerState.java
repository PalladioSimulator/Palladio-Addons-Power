/**
 */
package de.fzi.power.binding;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Power State</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.PowerState#getStatefulResourcePowerBinding
 * <em>Stateful Resource Power Binding</em>}</li>
 * <li>{@link de.fzi.power.binding.PowerState#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getPowerState()
 * @model
 * @generated
 */
public interface PowerState extends Entity {
    /**
     * Returns the value of the '<em><b>Binding</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Binding</em>' reference isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Binding</em>' reference.
     * @see #setBinding(ResourcePowerBinding)
     * @see de.fzi.power.binding.BindingPackage#getPowerState_Binding()
     * @model required="true"
     * @generated
     */
    ResourcePowerBinding getBinding();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.PowerState#getBinding <em>Binding</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Binding</em>' reference.
     * @see #getBinding()
     * @generated
     */
    void setBinding(ResourcePowerBinding value);

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
     * @see de.fzi.power.binding.BindingPackage#getPowerState_StatefulResourcePowerBinding()
     * @see de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStates
     * @model opposite="powerStates" transient="false"
     * @generated
     */
    StatefulResourcePowerBinding getStatefulResourcePowerBinding();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.PowerState#getStatefulResourcePowerBinding
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

} // PowerState
