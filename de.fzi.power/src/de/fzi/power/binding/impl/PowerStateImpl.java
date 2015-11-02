/**
 */
package de.fzi.power.binding.impl;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerState;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.StatefulResourcePowerBinding;

import de.fzi.power.util.impl.EntityImpl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.PowerStateImpl#getStatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.PowerStateImpl#getBinding <em>Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerStateImpl extends EntityImpl implements PowerState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindingPackage.Literals.POWER_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePowerBinding getBinding() {
		return (ResourcePowerBinding) eDynamicGet(
				BindingPackage.POWER_STATE__BINDING,
				BindingPackage.Literals.POWER_STATE__BINDING, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcePowerBinding basicGetBinding() {
		return (ResourcePowerBinding) eDynamicGet(
				BindingPackage.POWER_STATE__BINDING,
				BindingPackage.Literals.POWER_STATE__BINDING, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBinding(ResourcePowerBinding newBinding) {
		eDynamicSet(BindingPackage.POWER_STATE__BINDING,
				BindingPackage.Literals.POWER_STATE__BINDING, newBinding);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatefulResourcePowerBinding getStatefulResourcePowerBinding() {
		return (StatefulResourcePowerBinding) eDynamicGet(
				BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING,
				BindingPackage.Literals.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatefulResourcePowerBinding(
			StatefulResourcePowerBinding newStatefulResourcePowerBinding,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newStatefulResourcePowerBinding,
				BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING,
				msgs);
		return msgs;
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
				BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING,
				BindingPackage.Literals.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING,
				newStatefulResourcePowerBinding);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetStatefulResourcePowerBinding(
					(StatefulResourcePowerBinding) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
			return basicSetStatefulResourcePowerBinding(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
			return eInternalContainer()
					.eInverseRemove(
							this,
							BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES,
							StatefulResourcePowerBinding.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
			return getStatefulResourcePowerBinding();
		case BindingPackage.POWER_STATE__BINDING:
			if (resolve)
				return getBinding();
			return basicGetBinding();
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
		case BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
			setStatefulResourcePowerBinding((StatefulResourcePowerBinding) newValue);
			return;
		case BindingPackage.POWER_STATE__BINDING:
			setBinding((ResourcePowerBinding) newValue);
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
		case BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
			setStatefulResourcePowerBinding((StatefulResourcePowerBinding) null);
			return;
		case BindingPackage.POWER_STATE__BINDING:
			setBinding((ResourcePowerBinding) null);
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
		case BindingPackage.POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
			return getStatefulResourcePowerBinding() != null;
		case BindingPackage.POWER_STATE__BINDING:
			return basicGetBinding() != null;
		}
		return super.eIsSet(featureID);
	}

} //PowerStateImpl
