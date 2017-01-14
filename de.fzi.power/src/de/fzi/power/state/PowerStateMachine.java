/**
 */
package de.fzi.power.state;

import org.eclipse.emf.common.util.EList;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Power State Machine</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.state.PowerStateMachine#getPowerStateRepository
 * <em>Power State Repository</em>}</li>
 * <li>{@link de.fzi.power.state.PowerStateMachine#getPowerStates <em>Power States</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.state.StatePackage#getPowerStateMachine()
 * @model
 * @generated
 */
public interface PowerStateMachine extends Entity {
    /**
     * Returns the value of the '<em><b>Power State Repository</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.power.state.PowerStateRepository#getPowerStateMachines
     * <em>Power State Machines</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power State Repository</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power State Repository</em>' container reference.
     * @see #setPowerStateRepository(PowerStateRepository)
     * @see de.fzi.power.state.StatePackage#getPowerStateMachine_PowerStateRepository()
     * @see de.fzi.power.state.PowerStateRepository#getPowerStateMachines
     * @model opposite="powerStateMachines" transient="false"
     * @generated
     */
    PowerStateRepository getPowerStateRepository();

    /**
     * Sets the value of the '{@link de.fzi.power.state.PowerStateMachine#getPowerStateRepository
     * <em>Power State Repository</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Power State Repository</em>' container reference.
     * @see #getPowerStateRepository()
     * @generated
     */
    void setPowerStateRepository(PowerStateRepository value);

    /**
     * Returns the value of the '<em><b>Power States</b></em>' containment reference list. The list
     * contents are of type {@link de.fzi.power.state.AbstractPowerState}. It is bidirectional and
     * its opposite is '{@link de.fzi.power.state.AbstractPowerState#getPowerStateMachine
     * <em>Power State Machine</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power States</em>' containment reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power States</em>' containment reference list.
     * @see de.fzi.power.state.StatePackage#getPowerStateMachine_PowerStates()
     * @see de.fzi.power.state.AbstractPowerState#getPowerStateMachine
     * @model opposite="powerStateMachine" containment="true" required="true"
     * @generated
     */
    EList<AbstractPowerState> getPowerStates();

} // PowerStateMachine
