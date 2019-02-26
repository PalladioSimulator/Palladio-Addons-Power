/**
 */
package de.fzi.power.binding.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.binding.AbstractPowerStateBinding;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.state.PowerStateMachine;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Stateful Resource Power Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.StatefulResourcePowerBindingImpl#getPowerStateMachine <em>Power State Machine</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.StatefulResourcePowerBindingImpl#getPowerStateBindings <em>Power State Bindings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatefulResourcePowerBindingImpl extends PowerBindingImpl implements StatefulResourcePowerBinding {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected StatefulResourcePowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerStateMachine getPowerStateMachine() {
        return (PowerStateMachine) eDynamicGet(BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE,
                BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public PowerStateMachine basicGetPowerStateMachine() {
        return (PowerStateMachine) eDynamicGet(BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE,
                BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerStateMachine(PowerStateMachine newPowerStateMachine) {
        eDynamicSet(BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE,
                BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE, newPowerStateMachine);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<AbstractPowerStateBinding> getPowerStateBindings() {
        return (EList<AbstractPowerStateBinding>) eDynamicGet(
                BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS,
                BindingPackage.Literals.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getPowerStateBindings()).basicAdd(otherEnd,
                    msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS:
            return ((InternalEList<?>) getPowerStateBindings()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE:
            if (resolve)
                return getPowerStateMachine();
            return basicGetPowerStateMachine();
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS:
            return getPowerStateBindings();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE:
            setPowerStateMachine((PowerStateMachine) newValue);
            return;
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS:
            getPowerStateBindings().clear();
            getPowerStateBindings().addAll((Collection<? extends AbstractPowerStateBinding>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE:
            setPowerStateMachine((PowerStateMachine) null);
            return;
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS:
            getPowerStateBindings().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE:
            return basicGetPowerStateMachine() != null;
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS:
            return !getPowerStateBindings().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // StatefulResourcePowerBindingImpl
