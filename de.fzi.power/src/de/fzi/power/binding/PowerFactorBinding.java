/**
 */
package de.fzi.power.binding;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Factor Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.power.binding.PowerFactorBinding#getFixedFactorValues <em>Fixed Factor Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.power.binding.BindingPackage#getPowerFactorBinding()
 * @model abstract="true"
 * @generated
 */
public interface PowerFactorBinding extends PowerBinding {
	/**
	 * Returns the value of the '<em><b>Fixed Factor Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.power.binding.FixedFactorValue}.
	 * It is bidirectional and its opposite is '{@link de.fzi.power.binding.FixedFactorValue#getPowerBinding <em>Power Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Factor Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Factor Values</em>' containment reference list.
	 * @see de.fzi.power.binding.BindingPackage#getPowerFactorBinding_FixedFactorValues()
	 * @see de.fzi.power.binding.FixedFactorValue#getPowerBinding
	 * @model opposite="powerBinding" containment="true"
	 * @generated
	 */
	EList<FixedFactorValue> getFixedFactorValues();

} // PowerFactorBinding
