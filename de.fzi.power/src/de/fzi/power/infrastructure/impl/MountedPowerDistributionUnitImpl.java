/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Mounted Power Distribution Unit</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.MountedPowerDistributionUnitImpl#getResourceContainer
 * <em>Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MountedPowerDistributionUnitImpl extends PowerDistributionUnitImpl implements MountedPowerDistributionUnit {
    /**
     * The cached value of the '{@link #getResourceContainer() <em>Resource Container</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResourceContainer()
     * @generated
     * @ordered
     */
    protected ResourceContainer resourceContainer;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MountedPowerDistributionUnitImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.MOUNTED_POWER_DISTRIBUTION_UNIT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceContainer getResourceContainer() {
        if (this.resourceContainer != null && this.resourceContainer.eIsProxy())
        {
            final InternalEObject oldResourceContainer = (InternalEObject) this.resourceContainer;
            this.resourceContainer = (ResourceContainer) this.eResolveProxy(oldResourceContainer);
            if (this.resourceContainer != oldResourceContainer)
            {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER,
                            oldResourceContainer, this.resourceContainer));
                }
            }
        }
        return this.resourceContainer;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceContainer basicGetResourceContainer() {
        return this.resourceContainer;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourceContainer(final ResourceContainer newResourceContainer) {
        final ResourceContainer oldResourceContainer = this.resourceContainer;
        this.resourceContainer = newResourceContainer;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER, oldResourceContainer,
                    this.resourceContainer));
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
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
            if (resolve) {
                return this.getResourceContainer();
            }
            return this.basicGetResourceContainer();
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
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
            this.setResourceContainer((ResourceContainer) newValue);
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
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
            this.setResourceContainer((ResourceContainer) null);
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
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
            return this.resourceContainer != null;
        }
        return super.eIsSet(featureID);
    }

} // MountedPowerDistributionUnitImpl
