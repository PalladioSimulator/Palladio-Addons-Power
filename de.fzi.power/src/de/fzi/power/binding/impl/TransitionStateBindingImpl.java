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
 * <li>{@link de.fzi.power.binding.impl.TransitionStateBindingImpl#getTransitionState
 * <em>Transition State</em>}</li>
 * <li>{@link de.fzi.power.binding.impl.TransitionStateBindingImpl#getTransitionConsumption
 * <em>Transition Consumption</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionStateBindingImpl extends AbstractPowerStateBindingImpl implements TransitionStateBinding {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected TransitionStateBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.TRANSITION_STATE_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public TransitionState getTransitionState() {
        return (TransitionState) this.eDynamicGet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_STATE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public TransitionState basicGetTransitionState() {
        return (TransitionState) this.eDynamicGet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_STATE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTransitionState(final TransitionState newTransitionState) {
        this.eDynamicSet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_STATE, newTransitionState);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ConsumptionBehavior getTransitionConsumption() {
        return (ConsumptionBehavior) this.eDynamicGet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetTransitionConsumption(final ConsumptionBehavior newTransitionConsumption,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newTransitionConsumption,
                BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTransitionConsumption(final ConsumptionBehavior newTransitionConsumption) {
        this.eDynamicSet(BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION,
                BindingPackage.Literals.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION, newTransitionConsumption);
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            return this.basicSetTransitionConsumption(null, msgs);
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE:
            if (resolve) {
                return this.getTransitionState();
            }
            return this.basicGetTransitionState();
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            return this.getTransitionConsumption();
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE:
            this.setTransitionState((TransitionState) newValue);
            return;
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            this.setTransitionConsumption((ConsumptionBehavior) newValue);
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE:
            this.setTransitionState((TransitionState) null);
            return;
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            this.setTransitionConsumption((ConsumptionBehavior) null);
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
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_STATE:
            return this.basicGetTransitionState() != null;
        case BindingPackage.TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION:
            return this.getTransitionConsumption() != null;
        }
        return super.eIsSet(featureID);
    }

} // TransitionStateBindingImpl
