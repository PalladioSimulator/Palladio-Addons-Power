/**
 */
package de.fzi.power.binding;

import de.fzi.power.state.PowerState;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Power State Binding</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.PowerStateBinding#getPowerState <em>Power State</em>}</li>
 * <li>{@link de.fzi.power.binding.PowerStateBinding#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getPowerStateBinding()
 * @model
 * @generated
 */
public interface PowerStateBinding extends AbstractPowerStateBinding {
    /**
     * Returns the value of the '<em><b>Power State</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power State</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power State</em>' reference.
     * @see #setPowerState(PowerState)
     * @see de.fzi.power.binding.BindingPackage#getPowerStateBinding_PowerState()
     * @model required="true"
     * @generated
     */
    PowerState getPowerState();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.PowerStateBinding#getPowerState
     * <em>Power State</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Power State</em>' reference.
     * @see #getPowerState()
     * @generated
     */
    void setPowerState(PowerState value);

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
     * @see de.fzi.power.binding.BindingPackage#getPowerStateBinding_Binding()
     * @model required="true"
     * @generated
     */
    ResourcePowerBinding getBinding();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.PowerStateBinding#getBinding
     * <em>Binding</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Binding</em>' reference.
     * @see #getBinding()
     * @generated
     */
    void setBinding(ResourcePowerBinding value);

} // PowerStateBinding
