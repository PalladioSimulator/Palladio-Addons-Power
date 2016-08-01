/**
 */
package de.fzi.power.binding.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerFactorBinding;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Factor Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.PowerFactorBindingImpl#getFixedFactorValues
 * <em>Fixed Factor Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PowerFactorBindingImpl extends PowerBindingImpl implements PowerFactorBinding {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PowerFactorBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.POWER_FACTOR_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<AbstractFixedFactorValue<?>> getFixedFactorValues() {
        return (EList<AbstractFixedFactorValue<?>>) this.eDynamicGet(
                BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES,
                BindingPackage.Literals.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getFixedFactorValues()).basicAdd(otherEnd,
                    msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES:
            return ((InternalEList<?>) this.getFixedFactorValues()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES:
            return this.getFixedFactorValues();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES:
            this.getFixedFactorValues().clear();
            this.getFixedFactorValues().addAll((Collection<? extends AbstractFixedFactorValue<?>>) newValue);
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
        case BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES:
            this.getFixedFactorValues().clear();
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
        case BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES:
            return !this.getFixedFactorValues().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PowerFactorBindingImpl
