/**
 */
package de.fzi.power.binding.impl;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerState;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stateful Resource Power Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.StatefulResourcePowerBindingImpl#getPowerStates <em>Power States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatefulResourcePowerBindingImpl extends PowerBindingImpl
		implements StatefulResourcePowerBinding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatefulResourcePowerBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<PowerState> getPowerStates() {
		return (EList<PowerState>) eDynamicGet(
				BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES,
				BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPowerStates())
					.basicAdd(otherEnd, msgs);
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
		case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
			return ((InternalEList<?>) getPowerStates()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
			return getPowerStates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
			getPowerStates().clear();
			getPowerStates()
					.addAll((Collection<? extends PowerState>) newValue);
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
		case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
			getPowerStates().clear();
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
		case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
			return !getPowerStates().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StatefulResourcePowerBindingImpl
