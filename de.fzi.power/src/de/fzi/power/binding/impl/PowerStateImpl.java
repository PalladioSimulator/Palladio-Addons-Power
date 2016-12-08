/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerState;
import de.fzi.power.binding.ResourcePowerBinding;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Power State</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.PowerStateImpl#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerStateImpl extends AbstractPowerStateImpl implements PowerState {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PowerStateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.POWER_STATE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourcePowerBinding getBinding() {
        return (ResourcePowerBinding) this.eDynamicGet(BindingPackage.POWER_STATE__BINDING,
                BindingPackage.Literals.POWER_STATE__BINDING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourcePowerBinding basicGetBinding() {
        return (ResourcePowerBinding) this.eDynamicGet(BindingPackage.POWER_STATE__BINDING,
                BindingPackage.Literals.POWER_STATE__BINDING, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBinding(final ResourcePowerBinding newBinding) {
        this.eDynamicSet(BindingPackage.POWER_STATE__BINDING, BindingPackage.Literals.POWER_STATE__BINDING, newBinding);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case BindingPackage.POWER_STATE__BINDING:
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
        case BindingPackage.POWER_STATE__BINDING:
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
        case BindingPackage.POWER_STATE__BINDING:
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
        case BindingPackage.POWER_STATE__BINDING:
            return this.basicGetBinding() != null;
        }
        return super.eIsSet(featureID);
    }

} // PowerStateImpl
