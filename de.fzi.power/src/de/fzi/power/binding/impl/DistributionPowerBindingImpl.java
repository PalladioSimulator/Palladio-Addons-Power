/**
 */
package de.fzi.power.binding.impl;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.DistributionPowerBinding;

import de.fzi.power.specification.DistributionPowerModelSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distribution Power Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.DistributionPowerBindingImpl#getDistributionPowerModel <em>Distribution Power Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistributionPowerBindingImpl extends PowerBindingImpl implements DistributionPowerBinding {
    /**
     * The cached value of the '{@link #getDistributionPowerModel() <em>Distribution Power Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDistributionPowerModel()
     * @generated
     * @ordered
     */
    protected DistributionPowerModelSpecification distributionPowerModel;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DistributionPowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.DISTRIBUTION_POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DistributionPowerModelSpecification getDistributionPowerModel() {
        if (distributionPowerModel != null && distributionPowerModel.eIsProxy()) {
            InternalEObject oldDistributionPowerModel = (InternalEObject) distributionPowerModel;
            distributionPowerModel = (DistributionPowerModelSpecification) eResolveProxy(oldDistributionPowerModel);
            if (distributionPowerModel != oldDistributionPowerModel) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
                            oldDistributionPowerModel, distributionPowerModel));
            }
        }
        return distributionPowerModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DistributionPowerModelSpecification basicGetDistributionPowerModel() {
        return distributionPowerModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDistributionPowerModel(DistributionPowerModelSpecification newDistributionPowerModel) {
        DistributionPowerModelSpecification oldDistributionPowerModel = distributionPowerModel;
        distributionPowerModel = newDistributionPowerModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL, oldDistributionPowerModel,
                    distributionPowerModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
            if (resolve)
                return getDistributionPowerModel();
            return basicGetDistributionPowerModel();
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
        case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
            setDistributionPowerModel((DistributionPowerModelSpecification) newValue);
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
        case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
            setDistributionPowerModel((DistributionPowerModelSpecification) null);
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
        case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
            return distributionPowerModel != null;
        }
        return super.eIsSet(featureID);
    }

} //DistributionPowerBindingImpl
