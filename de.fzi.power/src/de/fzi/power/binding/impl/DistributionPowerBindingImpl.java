/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.specification.DistributionPowerModelSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Distribution Power Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.DistributionPowerBindingImpl#getDistributionPowerModel <em>Distribution Power Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistributionPowerBindingImpl extends PowerFactorBindingImpl
		implements DistributionPowerBinding {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributionPowerBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindingPackage.Literals.DISTRIBUTION_POWER_BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DistributionPowerModelSpecification getDistributionPowerModel() {
		return (DistributionPowerModelSpecification) eDynamicGet(
				BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
				BindingPackage.Literals.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionPowerModelSpecification basicGetDistributionPowerModel() {
		return (DistributionPowerModelSpecification) eDynamicGet(
				BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
				BindingPackage.Literals.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
				false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistributionPowerModel(
			DistributionPowerModelSpecification newDistributionPowerModel) {
		eDynamicSet(
				BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
				BindingPackage.Literals.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
				newDistributionPowerModel);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
			if (resolve)
				return getDistributionPowerModel();
			return basicGetDistributionPowerModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
			setDistributionPowerModel((DistributionPowerModelSpecification) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
			setDistributionPowerModel((DistributionPowerModelSpecification) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
			return basicGetDistributionPowerModel() != null;
		}
		return super.eIsSet(featureID);
	}

} // DistributionPowerBindingImpl
