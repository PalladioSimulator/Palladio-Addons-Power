/**
 */
package de.fzi.power.specification;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Power State</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.specification.AbstractPowerState#getPowerStateMachine
 * <em>Power State Machine</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.specification.SpecificationPackage#getAbstractPowerState()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPowerState extends Entity {
    /**
     * Returns the value of the '<em><b>Power State Machine</b></em>' reference. It is bidirectional
     * and its opposite is '{@link de.fzi.power.specification.PowerStateMachine#getPowerStates
     * <em>Power States</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power State Machine</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power State Machine</em>' reference.
     * @see #setPowerStateMachine(PowerStateMachine)
     * @see de.fzi.power.specification.SpecificationPackage#getAbstractPowerState_PowerStateMachine()
     * @see de.fzi.power.specification.PowerStateMachine#getPowerStates
     * @model opposite="powerStates"
     * @generated
     */
    PowerStateMachine getPowerStateMachine();

    /**
     * Sets the value of the '
     * {@link de.fzi.power.specification.AbstractPowerState#getPowerStateMachine
     * <em>Power State Machine</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Power State Machine</em>' reference.
     * @see #getPowerStateMachine()
     * @generated
     */
    void setPowerStateMachine(PowerStateMachine value);

} // AbstractPowerState
