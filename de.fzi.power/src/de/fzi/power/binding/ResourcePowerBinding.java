/**
 */
package de.fzi.power.binding;

import de.fzi.power.specification.ResourcePowerModelSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Power Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.power.binding.ResourcePowerBinding#getResourcePowerModelSpecification <em>Resource Power Model Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.power.binding.BindingPackage#getResourcePowerBinding()
 * @model
 * @generated
 */
public interface ResourcePowerBinding extends PowerBinding {
    /**
     * Returns the value of the '<em><b>Resource Power Model Specification</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Power Model Specification</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resource Power Model Specification</em>' reference.
     * @see #setResourcePowerModelSpecification(ResourcePowerModelSpecification)
     * @see de.fzi.power.binding.BindingPackage#getResourcePowerBinding_ResourcePowerModelSpecification()
     * @model required="true"
     * @generated
     */
    ResourcePowerModelSpecification getResourcePowerModelSpecification();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.ResourcePowerBinding#getResourcePowerModelSpecification <em>Resource Power Model Specification</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resource Power Model Specification</em>' reference.
     * @see #getResourcePowerModelSpecification()
     * @generated
     */
    void setResourcePowerModelSpecification(ResourcePowerModelSpecification value);

} // ResourcePowerBinding
