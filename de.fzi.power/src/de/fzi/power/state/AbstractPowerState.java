/**
 */
package de.fzi.power.state;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Power State</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.state.AbstractPowerState#getPowerStateMachine
 * <em>Power State Machine</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.state.StatePackage#getAbstractPowerState()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPowerState extends Entity {
    /**
     * Returns the value of the '<em><b>Power State Machine</b></em>' container reference. It is
     * bidirectional and its opposite is '{@link de.fzi.power.state.PowerStateMachine#getPowerStates
     * <em>Power States</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power State Machine</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power State Machine</em>' container reference.
     * @see #setPowerStateMachine(PowerStateMachine)
     * @see de.fzi.power.state.StatePackage#getAbstractPowerState_PowerStateMachine()
     * @see de.fzi.power.state.PowerStateMachine#getPowerStates
     * @model opposite="powerStates" transient="false"
     * @generated
     */
    PowerStateMachine getPowerStateMachine();

    /**
     * Sets the value of the '{@link de.fzi.power.state.AbstractPowerState#getPowerStateMachine
     * <em>Power State Machine</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Power State Machine</em>' container reference.
     * @see #getPowerStateMachine()
     * @generated
     */
    void setPowerStateMachine(PowerStateMachine value);

} // AbstractPowerState
