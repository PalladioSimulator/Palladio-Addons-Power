/**
 */
package de.fzi.power.binding;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Stateful Resource Power Binding</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStateBindings
 * <em>Power State Bindings</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getStatefulResourcePowerBinding()
 * @model
 * @generated
 */
public interface StatefulResourcePowerBinding extends PowerBinding {
    /**
     * Returns the value of the '<em><b>Power State Bindings</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.binding.AbstractPowerStateBinding}. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.power.binding.AbstractPowerStateBinding#getStatefulResourcePowerBinding
     * <em>Stateful Resource Power Binding</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power State Bindings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power State Bindings</em>' containment reference list.
     * @see de.fzi.power.binding.BindingPackage#getStatefulResourcePowerBinding_PowerStateBindings()
     * @see de.fzi.power.binding.AbstractPowerStateBinding#getStatefulResourcePowerBinding
     * @model opposite="statefulResourcePowerBinding" containment="true" required="true"
     * @generated
     */
    EList<AbstractPowerStateBinding> getPowerStateBindings();

} // StatefulResourcePowerBinding
