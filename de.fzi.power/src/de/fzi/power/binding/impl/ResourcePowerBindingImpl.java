/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.specification.ResourcePowerModelSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Power Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.ResourcePowerBindingImpl#getResourcePowerModelSpecification <em>Resource Power Model Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourcePowerBindingImpl extends PowerBindingImpl implements
		ResourcePowerBinding {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourcePowerBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindingPackage.Literals.RESOURCE_POWER_BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePowerModelSpecification getResourcePowerModelSpecification() {
		return (ResourcePowerModelSpecification) eDynamicGet(
				BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
				BindingPackage.Literals.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcePowerModelSpecification basicGetResourcePowerModelSpecification() {
		return (ResourcePowerModelSpecification) eDynamicGet(
				BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
				BindingPackage.Literals.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
				false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourcePowerModelSpecification(
			ResourcePowerModelSpecification newResourcePowerModelSpecification) {
		eDynamicSet(
				BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
				BindingPackage.Literals.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
				newResourcePowerModelSpecification);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
			if (resolve)
				return getResourcePowerModelSpecification();
			return basicGetResourcePowerModelSpecification();
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
		case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
			setResourcePowerModelSpecification((ResourcePowerModelSpecification) newValue);
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
		case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
			setResourcePowerModelSpecification((ResourcePowerModelSpecification) null);
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
		case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
			return basicGetResourcePowerModelSpecification() != null;
		}
		return super.eIsSet(featureID);
	}

} // ResourcePowerBindingImpl
