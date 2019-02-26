/**
 */
package de.fzi.power.specification;

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
 * <li>{@link de.fzi.power.specification.PowerStateMachine#getPowerStates <em>Power States</em>}
 * </li>
 * </ul>
 *
 * @see de.fzi.power.specification.SpecificationPackage#getPowerStateMachine()
 * @model
 * @generated
 */
public interface PowerStateMachine extends Entity {
    /**
     * Returns the value of the '<em><b>Power States</b></em>' reference list. The list contents are
     * of type {@link de.fzi.power.specification.AbstractPowerState}. It is bidirectional and its
     * opposite is '{@link de.fzi.power.specification.AbstractPowerState#getPowerStateMachine
     * <em>Power State Machine</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power States</em>' reference list isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power States</em>' reference list.
     * @see de.fzi.power.specification.SpecificationPackage#getPowerStateMachine_PowerStates()
     * @see de.fzi.power.specification.AbstractPowerState#getPowerStateMachine
     * @model opposite="powerStateMachine" required="true"
     * @generated
     */
    EList<AbstractPowerState> getPowerStates();

} // PowerStateMachine
