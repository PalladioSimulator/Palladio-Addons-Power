/**
 */
package de.fzi.power.infrastructure.impl;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mounted Power Distribution Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.MountedPowerDistributionUnitImpl#getResourceContainer <em>Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MountedPowerDistributionUnitImpl extends PowerDistributionUnitImpl implements MountedPowerDistributionUnit {
    /**
     * The cached value of the '{@link #getResourceContainer() <em>Resource Container</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourceContainer()
     * @generated
     * @ordered
     */
    protected ResourceContainer resourceContainer;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MountedPowerDistributionUnitImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.MOUNTED_POWER_DISTRIBUTION_UNIT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceContainer getResourceContainer() {
        if (resourceContainer != null && ((EObject) resourceContainer).eIsProxy()) {
            InternalEObject oldResourceContainer = (InternalEObject) resourceContainer;
            resourceContainer = (ResourceContainer) eResolveProxy(oldResourceContainer);
            if (resourceContainer != oldResourceContainer) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER,
                            oldResourceContainer, resourceContainer));
            }
        }
        return resourceContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceContainer basicGetResourceContainer() {
        return resourceContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setResourceContainer(ResourceContainer newResourceContainer) {
        ResourceContainer oldResourceContainer = resourceContainer;
        resourceContainer = newResourceContainer;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER, oldResourceContainer,
                    resourceContainer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER:
            return resourceContainer != null;
        }
        return super.eIsSet(featureID);
    }

} //MountedPowerDistributionUnitImpl
