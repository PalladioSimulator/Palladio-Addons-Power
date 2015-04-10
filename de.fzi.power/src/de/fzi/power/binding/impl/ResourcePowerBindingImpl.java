/**
 */
package de.fzi.power.binding.impl;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ResourcePowerBinding;

import de.fzi.power.specification.ResourcePowerModelSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Power Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.ResourcePowerBindingImpl#getResourcePowerModelSpecification <em>Resource Power Model Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourcePowerBindingImpl extends PowerBindingImpl implements ResourcePowerBinding {
    /**
     * The cached value of the '{@link #getResourcePowerModelSpecification() <em>Resource Power Model Specification</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourcePowerModelSpecification()
     * @generated
     * @ordered
     */
    protected ResourcePowerModelSpecification resourcePowerModelSpecification;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResourcePowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.RESOURCE_POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourcePowerModelSpecification getResourcePowerModelSpecification() {
        if (resourcePowerModelSpecification != null && resourcePowerModelSpecification.eIsProxy()) {
            InternalEObject oldResourcePowerModelSpecification = (InternalEObject) resourcePowerModelSpecification;
            resourcePowerModelSpecification = (ResourcePowerModelSpecification) eResolveProxy(oldResourcePowerModelSpecification);
            if (resourcePowerModelSpecification != oldResourcePowerModelSpecification) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
                            oldResourcePowerModelSpecification, resourcePowerModelSpecification));
            }
        }
        return resourcePowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourcePowerModelSpecification basicGetResourcePowerModelSpecification() {
        return resourcePowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setResourcePowerModelSpecification(ResourcePowerModelSpecification newResourcePowerModelSpecification) {
        ResourcePowerModelSpecification oldResourcePowerModelSpecification = resourcePowerModelSpecification;
        resourcePowerModelSpecification = newResourcePowerModelSpecification;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
                    oldResourcePowerModelSpecification, resourcePowerModelSpecification));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            if (resolve)
                return getResourcePowerModelSpecification();
            return basicGetResourcePowerModelSpecification();
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
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            setResourcePowerModelSpecification((ResourcePowerModelSpecification) newValue);
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
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            setResourcePowerModelSpecification((ResourcePowerModelSpecification) null);
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
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            return resourcePowerModelSpecification != null;
        }
        return super.eIsSet(featureID);
    }

} //ResourcePowerBindingImpl
