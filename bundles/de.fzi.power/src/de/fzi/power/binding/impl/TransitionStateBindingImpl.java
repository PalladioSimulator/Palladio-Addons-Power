/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ConsumptionBehavior;
import de.fzi.power.binding.TransitionStateBinding;
import de.fzi.power.state.TransitionState;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Transition State Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.TransitionStateBindingImpl#getTransitionState <em>Transition State</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.TransitionStateBindingImpl#getTransitionConsumption <em>Transition Consumption</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionStateBindingImpl extends AbstractPowerStateBindingImpl implements TransitionStateBinding {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected TransitionStateBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.TRANSITION_STATE_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TransitionState getTransitionState() {
        return (TransitionState) eDynamicGet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_STATE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public TransitionState basicGetTransitionState() {
        return (TransitionState) eDynamicGet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_STATE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTransitionState(TransitionState newTransitionState) {
        eDynamicSet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_STATE, newTransitionState);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ConsumptionBehavior getTransitionConsumption() {
        return (ConsumptionBehavior) eDynamicGet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTransitionConsumption(ConsumptionBehavior newTransitionConsumption,
            NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newTransitionConsumption,
                BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTransitionConsumption(ConsumptionBehavior newTransitionConsumption) {
        eDynamicSet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION, newTransitionConsumption);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            return basicSetTransitionConsumption(null, msgs);
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE:
            if (resolve)
                return getTransitionState();
            return basicGetTransitionState();
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            return getTransitionConsumption();
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE:
            setTransitionState((TransitionState) newValue);
            return;
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            setTransitionConsumption((ConsumptionBehavior) newValue);
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE:
            setTransitionState((TransitionState) null);
            return;
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            setTransitionConsumption((ConsumptionBehavior) null);
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE:
            return basicGetTransitionState() != null;
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            return getTransitionConsumption() != null;
        }
        return super.eIsSet(featureID);
    }

} // TransitionStateBindingImpl
