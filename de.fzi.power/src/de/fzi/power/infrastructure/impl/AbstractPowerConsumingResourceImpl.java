/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

import de.fzi.power.infrastructure.AbstractPowerConsumingResource;
import de.fzi.power.infrastructure.InfrastructurePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.AbstractPowerConsumingResourceImpl#getProcessingResourceSpecification
 * <em>Processing Resource Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractPowerConsumingResourceImpl extends PowerConsumingEntityImpl
        implements AbstractPowerConsumingResource {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AbstractPowerConsumingResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.ABSTRACT_POWER_CONSUMING_RESOURCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProcessingResourceSpecification getProcessingResourceSpecification() {
        return (ProcessingResourceSpecification) this.eDynamicGet(
                InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                InfrastructurePackage.Literals.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ProcessingResourceSpecification basicGetProcessingResourceSpecification() {
        return (ProcessingResourceSpecification) this.eDynamicGet(
                InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                InfrastructurePackage.Literals.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProcessingResourceSpecification(
            final ProcessingResourceSpecification newProcessingResourceSpecification) {
        this.eDynamicSet(InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                InfrastructurePackage.Literals.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                newProcessingResourceSpecification);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            if (resolve) {
                return this.getProcessingResourceSpecification();
            }
            return this.basicGetProcessingResourceSpecification();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            this.setProcessingResourceSpecification((ProcessingResourceSpecification) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            this.setProcessingResourceSpecification((ProcessingResourceSpecification) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case InfrastructurePackage.ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            return this.basicGetProcessingResourceSpecification() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractPowerConsumingResourceImpl
