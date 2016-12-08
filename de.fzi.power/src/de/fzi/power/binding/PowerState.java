/**
 */
package de.fzi.power.binding;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Power State</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.PowerState#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getPowerState()
 * @model
 * @generated
 */
public interface PowerState extends AbstractPowerState {
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

} // PowerState
