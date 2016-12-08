/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ConsumptionBehavior;
import de.fzi.power.binding.PowerState;
import de.fzi.power.binding.TransitionState;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Transition State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.TransitionStateImpl#getTransitionConsumption
 * <em>Transition Consumption</em>}</li>
 * <li>{@link de.fzi.power.binding.impl.TransitionStateImpl#getInitialState <em>Initial State</em>}
 * </li>
 * <li>{@link de.fzi.power.binding.impl.TransitionStateImpl#getTargetState <em>Target State</em>}
 * </li>
 * </ul>
 *
 * @generated
 */
public class TransitionStateImpl extends AbstractPowerStateImpl implements TransitionState {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected TransitionStateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.TRANSITION_STATE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ConsumptionBehavior getTransitionConsumption() {
        return (ConsumptionBehavior) this.eDynamicGet(BindingPackage.TRANSITION_STATE__TRANSITION_CONSUMPTION,
                BindingPackage.Literals.TRANSITION_STATE__TRANSITION_CONSUMPTION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetTransitionConsumption(final ConsumptionBehavior newTransitionConsumption,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newTransitionConsumption,
                BindingPackage.TRANSITION_STATE__TRANSITION_CONSUMPTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTransitionConsumption(final ConsumptionBehavior newTransitionConsumption) {
        this.eDynamicSet(BindingPackage.TRANSITION_STATE__TRANSITION_CONSUMPTION,
                BindingPackage.Literals.TRANSITION_STATE__TRANSITION_CONSUMPTION, newTransitionConsumption);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerState getInitialState() {
        return (PowerState) this.eDynamicGet(BindingPackage.TRANSITION_STATE__INITIAL_STATE,
                BindingPackage.Literals.TRANSITION_STATE__INITIAL_STATE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PowerState basicGetInitialState() {
        return (PowerState) this.eDynamicGet(BindingPackage.TRANSITION_STATE__INITIAL_STATE,
                BindingPackage.Literals.TRANSITION_STATE__INITIAL_STATE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInitialState(final PowerState newInitialState) {
        this.eDynamicSet(BindingPackage.TRANSITION_STATE__INITIAL_STATE,
                BindingPackage.Literals.TRANSITION_STATE__INITIAL_STATE, newInitialState);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerState getTargetState() {
        return (PowerState) this.eDynamicGet(BindingPackage.TRANSITION_STATE__TARGET_STATE,
                BindingPackage.Literals.TRANSITION_STATE__TARGET_STATE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PowerState basicGetTargetState() {
        return (PowerState) this.eDynamicGet(BindingPackage.TRANSITION_STATE__TARGET_STATE,
                BindingPackage.Literals.TRANSITION_STATE__TARGET_STATE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTargetState(final PowerState newTargetState) {
        this.eDynamicSet(BindingPackage.TRANSITION_STATE__TARGET_STATE,
                BindingPackage.Literals.TRANSITION_STATE__TARGET_STATE, newTargetState);
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
        case BindingPackage.TRANSITION_STATE__TRANSITION_CONSUMPTION:
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
        case BindingPackage.TRANSITION_STATE__TRANSITION_CONSUMPTION:
            return this.getTransitionConsumption();
        case BindingPackage.TRANSITION_STATE__INITIAL_STATE:
            if (resolve) {
                return this.getInitialState();
            }
            return this.basicGetInitialState();
        case BindingPackage.TRANSITION_STATE__TARGET_STATE:
            if (resolve) {
                return this.getTargetState();
            }
            return this.basicGetTargetState();
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
        case BindingPackage.TRANSITION_STATE__TRANSITION_CONSUMPTION:
            this.setTransitionConsumption((ConsumptionBehavior) newValue);
            return;
        case BindingPackage.TRANSITION_STATE__INITIAL_STATE:
            this.setInitialState((PowerState) newValue);
            return;
        case BindingPackage.TRANSITION_STATE__TARGET_STATE:
            this.setTargetState((PowerState) newValue);
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
        case BindingPackage.TRANSITION_STATE__TRANSITION_CONSUMPTION:
            this.setTransitionConsumption((ConsumptionBehavior) null);
            return;
        case BindingPackage.TRANSITION_STATE__INITIAL_STATE:
            this.setInitialState((PowerState) null);
            return;
        case BindingPackage.TRANSITION_STATE__TARGET_STATE:
            this.setTargetState((PowerState) null);
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
        case BindingPackage.TRANSITION_STATE__TRANSITION_CONSUMPTION:
            return this.getTransitionConsumption() != null;
        case BindingPackage.TRANSITION_STATE__INITIAL_STATE:
            return this.basicGetInitialState() != null;
        case BindingPackage.TRANSITION_STATE__TARGET_STATE:
            return this.basicGetTargetState() != null;
        }
        return super.eIsSet(featureID);
    }

} // TransitionStateImpl
