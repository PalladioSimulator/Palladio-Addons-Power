/**
 */
package de.fzi.power.state.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.state.AbstractPowerState;
import de.fzi.power.state.PowerStateMachine;
import de.fzi.power.state.StatePackage;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Power State</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.state.impl.AbstractPowerStateImpl#getPowerStateMachine <em>Power State Machine</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractPowerStateImpl extends EntityImpl implements AbstractPowerState {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AbstractPowerStateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StatePackage.Literals.ABSTRACT_POWER_STATE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerStateMachine getPowerStateMachine() {
        return (PowerStateMachine) eDynamicGet(StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE,
                StatePackage.Literals.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerStateMachine(PowerStateMachine newPowerStateMachine, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerStateMachine,
                StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerStateMachine(PowerStateMachine newPowerStateMachine) {
        eDynamicSet(StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE,
                StatePackage.Literals.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE, newPowerStateMachine);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerStateMachine((PowerStateMachine) otherEnd, msgs);
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
        case StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE:
            return basicSetPowerStateMachine(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE:
            return eInternalContainer().eInverseRemove(this, StatePackage.POWER_STATE_MACHINE__POWER_STATES,
                    PowerStateMachine.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE:
            return getPowerStateMachine();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE:
            setPowerStateMachine((PowerStateMachine) newValue);
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
        case StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE:
            setPowerStateMachine((PowerStateMachine) null);
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
        case StatePackage.ABSTRACT_POWER_STATE__POWER_STATE_MACHINE:
            return getPowerStateMachine() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractPowerStateImpl
