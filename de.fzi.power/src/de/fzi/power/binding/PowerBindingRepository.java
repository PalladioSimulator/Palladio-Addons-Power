/**
 */
package de.fzi.power.binding;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Power Binding Repository</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.binding.PowerBindingRepository#getPowerBindings <em>Power Bindings</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getPowerBindingRepository()
 * @model
 * @generated
 */
public interface PowerBindingRepository extends Identifier {
    /**
     * Returns the value of the '<em><b>Power Bindings</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.binding.PowerBinding}.
     * It is bidirectional and its opposite is '{@link de.fzi.power.binding.PowerBinding#getPowerBindingRepository <em>Power Binding Repository</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power Bindings</em>' containment reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Power Bindings</em>' containment reference list.
     * @see de.fzi.power.binding.BindingPackage#getPowerBindingRepository_PowerBindings()
     * @see de.fzi.power.binding.PowerBinding#getPowerBindingRepository
     * @model opposite="powerBindingRepository" containment="true"
     * @generated
     */
    EList<PowerBinding> getPowerBindings();

} // PowerBindingRepository
