/**
 */
package de.fzi.power.state;

import org.eclipse.emf.common.util.EList;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Power State Repository</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.state.PowerStateRepository#getPowerStateMachines <em>Power State Machines</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.state.StatePackage#getPowerStateRepository()
 * @model
 * @generated
 */
public interface PowerStateRepository extends Entity {
    /**
     * Returns the value of the '<em><b>Power State Machines</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.state.PowerStateMachine}.
     * It is bidirectional and its opposite is '{@link de.fzi.power.state.PowerStateMachine#getPowerStateRepository <em>Power State Repository</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power State Machines</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Power State Machines</em>' containment reference list.
     * @see de.fzi.power.state.StatePackage#getPowerStateRepository_PowerStateMachines()
     * @see de.fzi.power.state.PowerStateMachine#getPowerStateRepository
     * @model opposite="powerStateRepository" containment="true"
     * @generated
     */
    EList<PowerStateMachine> getPowerStateMachines();

} // PowerStateRepository
