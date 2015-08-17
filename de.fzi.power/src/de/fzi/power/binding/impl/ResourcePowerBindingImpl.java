/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.specification.ResourcePowerModelSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Power Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.ResourcePowerBindingImpl#getResourcePowerModelSpecification
 * <em>Resource Power Model Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourcePowerBindingImpl extends PowerBindingImpl implements ResourcePowerBinding {
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
        return (ResourcePowerModelSpecification) this.eDynamicGet(
                BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
                BindingPackage.Literals.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourcePowerModelSpecification basicGetResourcePowerModelSpecification() {
        return (ResourcePowerModelSpecification) this.eDynamicGet(
                BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
                BindingPackage.Literals.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourcePowerModelSpecification(
            final ResourcePowerModelSpecification newResourcePowerModelSpecification) {
        this.eDynamicSet(BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
                BindingPackage.Literals.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION,
                newResourcePowerModelSpecification);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
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
        switch (featureID) {
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
        switch (featureID) {
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
        switch (featureID) {
        case BindingPackage.RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION:
            return this.basicGetResourcePowerModelSpecification() != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourcePowerBindingImpl
