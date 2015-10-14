/**
 */
package de.fzi.power.infrastructure.impl;

import java.util.Collection;

import javax.measure.Measure;
import javax.measure.quantity.Power;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Consuming Providing Entity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl#getNestedPowerConsumingEntities <em>Nested Power Consuming Entities</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl#getSuppliablePeakPower <em>Suppliable Peak Power</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl#getPowerInfrastructureModel <em>Power Infrastructure Model</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl#getDistributionPowerAssemblyContext <em>Distribution Power Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PowerConsumingProvidingEntityImpl extends
		PowerConsumingEntityImpl implements PowerConsumingProvidingEntity {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerConsumingProvidingEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.POWER_CONSUMING_PROVIDING_ENTITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<PowerConsumingEntity> getNestedPowerConsumingEntities() {
		return (EList<PowerConsumingEntity>) eDynamicGet(
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
				InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Measure<?, Power> getSuppliablePeakPower() {
		return (Measure<?, Power>) eDynamicGet(
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER,
				InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuppliablePeakPower(Measure<?, Power> newSuppliablePeakPower) {
		eDynamicSet(
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER,
				InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER,
				newSuppliablePeakPower);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerInfrastructureRepository getPowerInfrastructureModel() {
		return (PowerInfrastructureRepository) eDynamicGet(
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
				InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPowerInfrastructureModel(
			PowerInfrastructureRepository newPowerInfrastructureModel,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newPowerInfrastructureModel,
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPowerInfrastructureModel(
			PowerInfrastructureRepository newPowerInfrastructureModel) {
		eDynamicSet(
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
				InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
				newPowerInfrastructureModel);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DistributionPowerBinding getDistributionPowerAssemblyContext() {
		return (DistributionPowerBinding) eDynamicGet(
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
				InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionPowerBinding basicGetDistributionPowerAssemblyContext() {
		return (DistributionPowerBinding) eDynamicGet(
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
				InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
				false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistributionPowerAssemblyContext(
			DistributionPowerBinding newDistributionPowerAssemblyContext) {
		eDynamicSet(
				InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
				InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
				newDistributionPowerAssemblyContext);
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
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getNestedPowerConsumingEntities())
					.basicAdd(otherEnd, msgs);
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetPowerInfrastructureModel(
					(PowerInfrastructureRepository) otherEnd, msgs);
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
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
			return ((InternalEList<?>) getNestedPowerConsumingEntities())
					.basicRemove(otherEnd, msgs);
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
			return basicSetPowerInfrastructureModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
			return eInternalContainer()
					.eInverseRemove(
							this,
							InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES,
							PowerInfrastructureRepository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
			return getNestedPowerConsumingEntities();
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
			return getSuppliablePeakPower();
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
			return getPowerInfrastructureModel();
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
			if (resolve)
				return getDistributionPowerAssemblyContext();
			return basicGetDistributionPowerAssemblyContext();
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
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
			getNestedPowerConsumingEntities().clear();
			getNestedPowerConsumingEntities().addAll(
					(Collection<? extends PowerConsumingEntity>) newValue);
			return;
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
			setSuppliablePeakPower((Measure<?, Power>) newValue);
			return;
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
			setPowerInfrastructureModel((PowerInfrastructureRepository) newValue);
			return;
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
			setDistributionPowerAssemblyContext((DistributionPowerBinding) newValue);
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
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
			getNestedPowerConsumingEntities().clear();
			return;
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
			setSuppliablePeakPower((Measure<?, Power>) null);
			return;
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
			setPowerInfrastructureModel((PowerInfrastructureRepository) null);
			return;
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
			setDistributionPowerAssemblyContext((DistributionPowerBinding) null);
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
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
			return !getNestedPowerConsumingEntities().isEmpty();
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
			return getSuppliablePeakPower() != null;
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
			return getPowerInfrastructureModel() != null;
		case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
			return basicGetDistributionPowerAssemblyContext() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == PowerProvidingEntity.class) {
			switch (derivedFeatureID) {
			case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
				return InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES;
			case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
				return InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER;
			case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
				return InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL;
			case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
				return InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == PowerProvidingEntity.class) {
			switch (baseFeatureID) {
			case InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
				return InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES;
			case InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
				return InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER;
			case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
				return InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL;
			case InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
				return InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // PowerConsumingProvidingEntityImpl
