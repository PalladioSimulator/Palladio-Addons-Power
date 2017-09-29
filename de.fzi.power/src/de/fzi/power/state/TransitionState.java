/**
 */
package de.fzi.power.state;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Transition State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.state.TransitionState#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link de.fzi.power.state.TransitionState#getTargetState <em>Target State</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.state.StatePackage#getTransitionState()
 * @model
 * @generated
 */
public interface TransitionState extends AbstractPowerState {
    /**
     * Returns the value of the '<em><b>Initial State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initial State</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initial State</em>' reference.
     * @see #setInitialState(PowerState)
     * @see de.fzi.power.state.StatePackage#getTransitionState_InitialState()
     * @model required="true"
     * @generated
     */
    PowerState getInitialState();

    /**
     * Sets the value of the '{@link de.fzi.power.state.TransitionState#getInitialState <em>Initial State</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Initial State</em>' reference.
     * @see #getInitialState()
     * @generated
     */
    void setInitialState(PowerState value);

    /**
     * Returns the value of the '<em><b>Target State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target State</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target State</em>' reference.
     * @see #setTargetState(PowerState)
     * @see de.fzi.power.state.StatePackage#getTransitionState_TargetState()
     * @model required="true"
     * @generated
     */
    PowerState getTargetState();

    /**
     * Sets the value of the '{@link de.fzi.power.state.TransitionState#getTargetState <em>Target State</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Target State</em>' reference.
     * @see #getTargetState()
     * @generated
     */
    void setTargetState(PowerState value);

} // TransitionState
