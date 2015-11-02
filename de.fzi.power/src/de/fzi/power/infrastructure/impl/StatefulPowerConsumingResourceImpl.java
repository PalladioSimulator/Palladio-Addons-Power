/**
 */
package de.fzi.power.infrastructure.impl;

import de.fzi.power.binding.PowerState;

import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stateful Power Consuming Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.StatefulPowerConsumingResourceImpl#getPowerState <em>Power State</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.impl.StatefulPowerConsumingResourceImpl#getStatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatefulPowerConsumingResourceImpl extends
		AbstractPowerConsumingResourceImpl implements
		StatefulPowerConsumingResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatefulPowerConsumingResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerState getPowerState() {
		return (PowerState) eDynamicGet(
				InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
				InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerState basicGetPowerState() {
		return (PowerState) eDynamicGet(
				InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
				InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
				false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPowerState(PowerState newPowerState) {
		eDynamicSet(
				InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
				InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
				newPowerState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatefulResourcePowerBinding getStatefulResourcePowerBinding() {
		return (StatefulResourcePowerBinding) eDynamicGet(
				InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
				InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatefulResourcePowerBinding basicGetStatefulResourcePowerBinding() {
		return (StatefulResourcePowerBinding) eDynamicGet(
				InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
				InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
				false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatefulResourcePowerBinding(
			StatefulResourcePowerBinding newStatefulResourcePowerBinding) {
		eDynamicSet(
				InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
				InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
				newStatefulResourcePowerBinding);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE:
			if (resolve)
				return getPowerState();
			return basicGetPowerState();
		case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING:
			if (resolve)
				return getStatefulResourcePowerBinding();
			return basicGetStatefulResourcePowerBinding();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE:
			setPowerState((PowerState) newValue);
			return;
		case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING:
			setStatefulResourcePowerBinding((StatefulResourcePowerBinding) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE:
			setPowerState((PowerState) null);
			return;
		case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING:
			setStatefulResourcePowerBinding((StatefulResourcePowerBinding) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE:
			return basicGetPowerState() != null;
		case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING:
			return basicGetStatefulResourcePowerBinding() != null;
		}
		return super.eIsSet(featureID);
	}

} //StatefulPowerConsumingResourceImpl
