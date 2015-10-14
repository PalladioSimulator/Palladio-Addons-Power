/**
 */
package de.fzi.power.binding.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.binding.PowerBindingRepository;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Binding Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.PowerBindingRepositoryImpl#getPowerBindings <em>Power Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerBindingRepositoryImpl extends IdentifierImpl implements
		PowerBindingRepository {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerBindingRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindingPackage.Literals.POWER_BINDING_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<PowerBinding> getPowerBindings() {
		return (EList<PowerBinding>) eDynamicGet(
				BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS,
				BindingPackage.Literals.POWER_BINDING_REPOSITORY__POWER_BINDINGS,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPowerBindings())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS:
			return ((InternalEList<?>) getPowerBindings()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS:
			return getPowerBindings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS:
			getPowerBindings().clear();
			getPowerBindings().addAll(
					(Collection<? extends PowerBinding>) newValue);
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
		case BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS:
			getPowerBindings().clear();
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
		case BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS:
			return !getPowerBindings().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // PowerBindingRepositoryImpl
