/**
 */
package de.fzi.power.specification.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Model Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.specification.impl.PowerModelSpecificationImpl#getPowermodelrepository <em>Powermodelrepository</em>}</li>
 *   <li>{@link de.fzi.power.specification.impl.PowerModelSpecificationImpl#getConsumptionFactors <em>Consumption Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PowerModelSpecificationImpl extends EntityImpl implements
		PowerModelSpecification {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerModelSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecificationPackage.Literals.POWER_MODEL_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerModelRepository getPowermodelrepository() {
		return (PowerModelRepository) eDynamicGet(
				SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY,
				SpecificationPackage.Literals.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPowermodelrepository(
			PowerModelRepository newPowermodelrepository, NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newPowermodelrepository,
				SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPowermodelrepository(
			PowerModelRepository newPowermodelrepository) {
		eDynamicSet(
				SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY,
				SpecificationPackage.Literals.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY,
				newPowermodelrepository);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ConsumptionFactor> getConsumptionFactors() {
		return (EList<ConsumptionFactor>) eDynamicGet(
				SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS,
				SpecificationPackage.Literals.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS,
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
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetPowermodelrepository(
					(PowerModelRepository) otherEnd, msgs);
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConsumptionFactors())
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
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY:
			return basicSetPowermodelrepository(null, msgs);
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS:
			return ((InternalEList<?>) getConsumptionFactors()).basicRemove(
					otherEnd, msgs);
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
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY:
			return eInternalContainer()
					.eInverseRemove(
							this,
							SpecificationPackage.POWER_MODEL_REPOSITORY__POWER_MODEL_SPECIFICATIONS,
							PowerModelRepository.class, msgs);
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
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY:
			return getPowermodelrepository();
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS:
			return getConsumptionFactors();
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
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY:
			setPowermodelrepository((PowerModelRepository) newValue);
			return;
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS:
			getConsumptionFactors().clear();
			getConsumptionFactors().addAll(
					(Collection<? extends ConsumptionFactor>) newValue);
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
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY:
			setPowermodelrepository((PowerModelRepository) null);
			return;
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS:
			getConsumptionFactors().clear();
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
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY:
			return getPowermodelrepository() != null;
		case SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS:
			return !getConsumptionFactors().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // PowerModelSpecificationImpl
