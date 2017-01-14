/**
 */
package de.fzi.power.state.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.state.PowerState;
import de.fzi.power.state.StatePackage;
import de.fzi.power.state.TransitionState;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Transition State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.state.impl.TransitionStateImpl#getInitialState <em>Initial State</em>}
 * </li>
 * <li>{@link de.fzi.power.state.impl.TransitionStateImpl#getTargetState <em>Target State</em>}</li>
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
        return StatePackage.Literals.TRANSITION_STATE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerState getInitialState() {
        return (PowerState) this.eDynamicGet(StatePackage.TRANSITION_STATE__INITIAL_STATE,
                StatePackage.Literals.TRANSITION_STATE__INITIAL_STATE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PowerState basicGetInitialState() {
        return (PowerState) this.eDynamicGet(StatePackage.TRANSITION_STATE__INITIAL_STATE,
                StatePackage.Literals.TRANSITION_STATE__INITIAL_STATE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInitialState(final PowerState newInitialState) {
        this.eDynamicSet(StatePackage.TRANSITION_STATE__INITIAL_STATE,
                StatePackage.Literals.TRANSITION_STATE__INITIAL_STATE, newInitialState);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerState getTargetState() {
        return (PowerState) this.eDynamicGet(StatePackage.TRANSITION_STATE__TARGET_STATE,
                StatePackage.Literals.TRANSITION_STATE__TARGET_STATE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PowerState basicGetTargetState() {
        return (PowerState) this.eDynamicGet(StatePackage.TRANSITION_STATE__TARGET_STATE,
                StatePackage.Literals.TRANSITION_STATE__TARGET_STATE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTargetState(final PowerState newTargetState) {
        this.eDynamicSet(StatePackage.TRANSITION_STATE__TARGET_STATE,
                StatePackage.Literals.TRANSITION_STATE__TARGET_STATE, newTargetState);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case StatePackage.TRANSITION_STATE__INITIAL_STATE:
            if (resolve) {
                return this.getInitialState();
            }
            return this.basicGetInitialState();
        case StatePackage.TRANSITION_STATE__TARGET_STATE:
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
        case StatePackage.TRANSITION_STATE__INITIAL_STATE:
            this.setInitialState((PowerState) newValue);
            return;
        case StatePackage.TRANSITION_STATE__TARGET_STATE:
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
        case StatePackage.TRANSITION_STATE__INITIAL_STATE:
            this.setInitialState((PowerState) null);
            return;
        case StatePackage.TRANSITION_STATE__TARGET_STATE:
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
        case StatePackage.TRANSITION_STATE__INITIAL_STATE:
            return this.basicGetInitialState() != null;
        case StatePackage.TRANSITION_STATE__TARGET_STATE:
            return this.basicGetTargetState() != null;
        }
        return super.eIsSet(featureID);
    }

} // TransitionStateImpl
