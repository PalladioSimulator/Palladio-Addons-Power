/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.specification.ResourcePowerModelSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Power Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.ResourcePowerBindingImpl#getResourcePowerModelSpecification
 * <em>Resource Power Model Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourcePowerBindingImpl extends PowerBindingImpl implements ResourcePowerBinding {
    /**
     * The cached value of the '{@link #getResourcePowerModelSpecification()
     * <em>Resource Power Model Specification</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResourcePowerModelSpecification()
     * @generated
     * @ordered
     */
    protected ResourcePowerModelSpecification resourcePowerModelSpecification;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ResourcePowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.RESOURCE_POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourcePowerModelSpecification getResourcePowerModelSpecification() {
        if (this.resourcePowerModelSpecification != null && this.resourcePowerModelSpecification.eIsProxy())
        {
            final InternalEObject oldResourcePowerModelSpecification = (InternalEObject) this.resourcePowerModelSpecification;
            this.resourcePowerModelSpecification = (ResourcePowerModelSpecification) this
                    .eResolveProxy(oldResourcePowerModelSpecification);
            if (this.resourcePowerModelSpecification != oldResourcePowerModelSpecification)
            {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
                            oldResourcePowerModelSpecification, this.resourcePowerModelSpecification));
                }
            }
        }
        return this.resourcePowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourcePowerModelSpecification basicGetResourcePowerModelSpecification() {
        return this.resourcePowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourcePowerModelSpecification(
            final ResourcePowerModelSpecification newResourcePowerModelSpecification) {
        final ResourcePowerModelSpecification oldResourcePowerModelSpecification = this.resourcePowerModelSpecification;
        this.resourcePowerModelSpecification = newResourcePowerModelSpecification;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
                    oldResourcePowerModelSpecification, this.resourcePowerModelSpecification));
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
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            if (resolve) {
                return this.getResourcePowerModelSpecification();
            }
            return this.basicGetResourcePowerModelSpecification();
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
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            this.setResourcePowerModelSpecification((ResourcePowerModelSpecification) newValue);
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
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            this.setResourcePowerModelSpecification((ResourcePowerModelSpecification) null);
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
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            return this.resourcePowerModelSpecification != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourcePowerBindingImpl
