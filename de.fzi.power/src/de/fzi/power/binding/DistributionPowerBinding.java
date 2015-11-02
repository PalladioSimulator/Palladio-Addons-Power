/**
 */
package de.fzi.power.binding;

import de.fzi.power.specification.DistributionPowerModelSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Distribution Power Binding</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.power.binding.DistributionPowerBinding#getDistributionPowerModel <em>Distribution Power Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.power.binding.BindingPackage#getDistributionPowerBinding()
 * @model
 * @generated
 */
public interface DistributionPowerBinding extends PowerFactorBinding {
	/**
	 * Returns the value of the '<em><b>Distribution Power Model</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distribution Power Model</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Distribution Power Model</em>' reference.
	 * @see #setDistributionPowerModel(DistributionPowerModelSpecification)
	 * @see de.fzi.power.binding.BindingPackage#getDistributionPowerBinding_DistributionPowerModel()
	 * @model required="true"
	 * @generated
	 */
	DistributionPowerModelSpecification getDistributionPowerModel();

	/**
	 * Sets the value of the '{@link de.fzi.power.binding.DistributionPowerBinding#getDistributionPowerModel <em>Distribution Power Model</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distribution Power Model</em>' reference.
	 * @see #getDistributionPowerModel()
	 * @generated
	 */
	void setDistributionPowerModel(DistributionPowerModelSpecification value);

} // DistributionPowerBinding
