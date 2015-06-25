/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.specification.DistributionPowerModelSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Distribution Power Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.DistributionPowerBindingImpl#getDistributionPowerModel <em>
 * Distribution Power Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistributionPowerBindingImpl extends PowerBindingImpl implements DistributionPowerBinding {
    /**
     * The cached value of the '{@link #getDistributionPowerModel()
     * <em>Distribution Power Model</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDistributionPowerModel()
     * @generated
     * @ordered
     */
    protected DistributionPowerModelSpecification distributionPowerModel;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DistributionPowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.DISTRIBUTION_POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DistributionPowerModelSpecification getDistributionPowerModel() {
        if (this.distributionPowerModel != null && this.distributionPowerModel.eIsProxy())
        {
            final InternalEObject oldDistributionPowerModel = (InternalEObject) this.distributionPowerModel;
            this.distributionPowerModel = (DistributionPowerModelSpecification) this
                    .eResolveProxy(oldDistributionPowerModel);
            if (this.distributionPowerModel != oldDistributionPowerModel)
            {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
                            oldDistributionPowerModel, this.distributionPowerModel));
                }
            }
        }
        return this.distributionPowerModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DistributionPowerModelSpecification basicGetDistributionPowerModel() {
        return this.distributionPowerModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDistributionPowerModel(final DistributionPowerModelSpecification newDistributionPowerModel) {
        final DistributionPowerModelSpecification oldDistributionPowerModel = this.distributionPowerModel;
        this.distributionPowerModel = newDistributionPowerModel;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL, oldDistributionPowerModel,
                    this.distributionPowerModel));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID)
        {
        case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
            if (resolve) {
                return this.getDistributionPowerModel();
            }
            return this.basicGetDistributionPowerModel();
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
        switch (featureID)
        {
        case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
            this.setDistributionPowerModel((DistributionPowerModelSpecification) newValue);
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
        switch (featureID)
        {
        case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
            this.setDistributionPowerModel((DistributionPowerModelSpecification) null);
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
        switch (featureID)
        {
        case BindingPackage.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL:
            return this.distributionPowerModel != null;
        }
        return super.eIsSet(featureID);
    }

} // DistributionPowerBindingImpl
