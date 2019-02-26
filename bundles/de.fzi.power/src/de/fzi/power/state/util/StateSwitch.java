/**
 */
package de.fzi.power.state.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.fzi.power.state.AbstractPowerState;
import de.fzi.power.state.PowerState;
import de.fzi.power.state.PowerStateMachine;
import de.fzi.power.state.PowerStateRepository;
import de.fzi.power.state.StatePackage;
import de.fzi.power.state.TransitionState;
import de.fzi.power.util.Entity;
import de.fzi.power.util.NamedElement;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fzi.power.state.StatePackage
 * @generated
 */
public class StateSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static StatePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public StateSwitch() {
        if (modelPackage == null) {
            modelPackage = StatePackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case StatePackage.POWER_STATE_REPOSITORY: {
            PowerStateRepository powerStateRepository = (PowerStateRepository) theEObject;
            T result = casePowerStateRepository(powerStateRepository);
            if (result == null)
                result = caseEntity(powerStateRepository);
            if (result == null)
                result = caseIdentifier(powerStateRepository);
            if (result == null)
                result = caseNamedElement(powerStateRepository);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case StatePackage.ABSTRACT_POWER_STATE: {
            AbstractPowerState abstractPowerState = (AbstractPowerState) theEObject;
            T result = caseAbstractPowerState(abstractPowerState);
            if (result == null)
                result = caseEntity(abstractPowerState);
            if (result == null)
                result = caseIdentifier(abstractPowerState);
            if (result == null)
                result = caseNamedElement(abstractPowerState);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case StatePackage.TRANSITION_STATE: {
            TransitionState transitionState = (TransitionState) theEObject;
            T result = caseTransitionState(transitionState);
            if (result == null)
                result = caseAbstractPowerState(transitionState);
            if (result == null)
                result = caseEntity(transitionState);
            if (result == null)
                result = caseIdentifier(transitionState);
            if (result == null)
                result = caseNamedElement(transitionState);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case StatePackage.POWER_STATE: {
            PowerState powerState = (PowerState) theEObject;
            T result = casePowerState(powerState);
            if (result == null)
                result = caseAbstractPowerState(powerState);
            if (result == null)
                result = caseEntity(powerState);
            if (result == null)
                result = caseIdentifier(powerState);
            if (result == null)
                result = caseNamedElement(powerState);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case StatePackage.POWER_STATE_MACHINE: {
            PowerStateMachine powerStateMachine = (PowerStateMachine) theEObject;
            T result = casePowerStateMachine(powerStateMachine);
            if (result == null)
                result = caseEntity(powerStateMachine);
            if (result == null)
                result = caseIdentifier(powerStateMachine);
            if (result == null)
                result = caseNamedElement(powerStateMachine);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power State Repository</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power State Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerStateRepository(PowerStateRepository object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Power State</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Power State</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractPowerState(AbstractPowerState object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Transition State</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transition State</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTransitionState(TransitionState object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power State</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power State</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerState(PowerState object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power State Machine</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power State Machine</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerStateMachine(PowerStateMachine object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // StateSwitch
