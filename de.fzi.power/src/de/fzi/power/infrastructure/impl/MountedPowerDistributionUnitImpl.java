/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Mounted Power Distribution Unit</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.MountedPowerDistributionUnitImpl#getResourceContainer <em>Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MountedPowerDistributionUnitImpl extends PowerDistributionUnitImpl
		implements MountedPowerDistributionUnit {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MountedPowerDistributionUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.MOUNTED_POWER_DISTRIBUTION_UNIT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceContainer getResourceContainer() {
		return (ResourceContainer) eDynamicGet(
				InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER,
				InfrastructurePackage.Literals.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER,
				true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetResourceContainer() {
		return (ResourceContainer) eDynamicGet(
				InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER,
				InfrastructurePackage.Literals.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER,
				false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceContainer(ResourceContainer newResourceContainer) {
		eDynamicSet(
				InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER,
				InfrastructurePackage.Literals.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER,
				newResourceContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
			if (resolve)
				return getResourceContainer();
			return basicGetResourceContainer();
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
		case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
			setResourceContainer((ResourceContainer) newValue);
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
		case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
			setResourceContainer((ResourceContainer) null);
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
		case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
			return basicGetResourceContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} // MountedPowerDistributionUnitImpl
