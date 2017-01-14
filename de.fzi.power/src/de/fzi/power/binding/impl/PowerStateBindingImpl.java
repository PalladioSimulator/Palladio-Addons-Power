/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerStateBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.state.PowerState;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power State Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.PowerStateBindingImpl#getPowerState <em>Power State</em>}
 * </li>
 * <li>{@link de.fzi.power.binding.impl.PowerStateBindingImpl#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerStateBindingImpl extends AbstractPowerStateBindingImpl implements PowerStateBinding {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PowerStateBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.POWER_STATE_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerState getPowerState() {
        return (PowerState) this.eDynamicGet(BindingPackage.POWER_STATE_BINDING__POWER_STATE,
                BindingPackage.Literals.POWER_STATE_BINDING__POWER_STATE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PowerState basicGetPowerState() {
        return (PowerState) this.eDynamicGet(BindingPackage.POWER_STATE_BINDING__POWER_STATE,
                BindingPackage.Literals.POWER_STATE_BINDING__POWER_STATE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPowerState(final PowerState newPowerState) {
        this.eDynamicSet(BindingPackage.POWER_STATE_BINDING__POWER_STATE,
                BindingPackage.Literals.POWER_STATE_BINDING__POWER_STATE, newPowerState);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourcePowerBinding getBinding() {
        return (ResourcePowerBinding) this.eDynamicGet(BindingPackage.POWER_STATE_BINDING__BINDING,
                BindingPackage.Literals.POWER_STATE_BINDING__BINDING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourcePowerBinding basicGetBinding() {
        return (ResourcePowerBinding) this.eDynamicGet(BindingPackage.POWER_STATE_BINDING__BINDING,
                BindingPackage.Literals.POWER_STATE_BINDING__BINDING, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBinding(final ResourcePowerBinding newBinding) {
        this.eDynamicSet(BindingPackage.POWER_STATE_BINDING__BINDING,
                BindingPackage.Literals.POWER_STATE_BINDING__BINDING, newBinding);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case BindingPackage.POWER_STATE_BINDING__POWER_STATE:
            if (resolve) {
                return this.getPowerState();
            }
            return this.basicGetPowerState();
        case BindingPackage.POWER_STATE_BINDING__BINDING:
            if (resolve) {
                return this.getBinding();
            }
            return this.basicGetBinding();
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
        case BindingPackage.POWER_STATE_BINDING__POWER_STATE:
            this.setPowerState((PowerState) newValue);
            return;
        case BindingPackage.POWER_STATE_BINDING__BINDING:
            this.setBinding((ResourcePowerBinding) newValue);
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
        case BindingPackage.POWER_STATE_BINDING__POWER_STATE:
            this.setPowerState((PowerState) null);
            return;
        case BindingPackage.POWER_STATE_BINDING__BINDING:
            this.setBinding((ResourcePowerBinding) null);
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
        case BindingPackage.POWER_STATE_BINDING__POWER_STATE:
            return this.basicGetPowerState() != null;
        case BindingPackage.POWER_STATE_BINDING__BINDING:
            return this.basicGetBinding() != null;
        }
        return super.eIsSet(featureID);
    }

} // PowerStateBindingImpl
