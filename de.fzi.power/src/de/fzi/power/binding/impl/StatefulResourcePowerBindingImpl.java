/**
 */
package de.fzi.power.binding.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.binding.AbstractPowerState;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.StatefulResourcePowerBinding;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Stateful Resource Power Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.StatefulResourcePowerBindingImpl#getPowerStates
 * <em>Power States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatefulResourcePowerBindingImpl extends PowerBindingImpl implements StatefulResourcePowerBinding {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected StatefulResourcePowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<AbstractPowerState> getPowerStates() {
        return (EList<AbstractPowerState>) this.eDynamicGet(
                BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES,
                BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES, true, true);
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
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getPowerStates()).basicAdd(otherEnd, msgs);
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
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
            return ((InternalEList<?>) this.getPowerStates()).basicRemove(otherEnd, msgs);
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
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
            return this.getPowerStates();
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
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
            this.getPowerStates().clear();
            this.getPowerStates().addAll((Collection<? extends AbstractPowerState>) newValue);
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
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
            this.getPowerStates().clear();
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
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES:
            return !this.getPowerStates().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // StatefulResourcePowerBindingImpl
