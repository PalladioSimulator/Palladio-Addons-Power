/**
 */
package de.fzi.power.infrastructure.impl;

import de.fzi.power.infrastructure.AbstractPowerConsumingResource;
import de.fzi.power.infrastructure.InfrastructurePackage;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Power Consuming Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.AbstractPowerConsumingResourceImpl#getProcessingResourceSpecification <em>Processing Resource Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractPowerConsumingResourceImpl extends
		PowerConsumingEntityImpl implements AbstractPowerConsumingResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractPowerConsumingResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.ABSTRACT_POWER_CONSUMING_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessingResourceSpecification getProcessingResourceSpecification() {
		return (ProcessingResourceSpecification) eDynamicGet(
				InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
				InfrastructurePackage.Literals.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification basicGetProcessingResourceSpecification() {
		return (ProcessingResourceSpecification) eDynamicGet(
				InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
				InfrastructurePackage.Literals.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
				false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProcessingResourceSpecification(
			ProcessingResourceSpecification newProcessingResourceSpecification) {
		eDynamicSet(
				InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
				InfrastructurePackage.Literals.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
				newProcessingResourceSpecification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
			if (resolve)
				return getProcessingResourceSpecification();
			return basicGetProcessingResourceSpecification();
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
		case InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
			setProcessingResourceSpecification((ProcessingResourceSpecification) newValue);
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
		case InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
			setProcessingResourceSpecification((ProcessingResourceSpecification) null);
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
		case InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
			return basicGetProcessingResourceSpecification() != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractPowerConsumingResourceImpl
