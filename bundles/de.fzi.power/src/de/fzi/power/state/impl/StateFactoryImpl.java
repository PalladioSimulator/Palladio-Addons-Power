/**
 */
package de.fzi.power.state.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fzi.power.state.PowerState;
import de.fzi.power.state.PowerStateMachine;
import de.fzi.power.state.PowerStateRepository;
import de.fzi.power.state.StateFactory;
import de.fzi.power.state.StatePackage;
import de.fzi.power.state.TransitionState;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class StateFactoryImpl extends EFactoryImpl implements StateFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static StateFactory init() {
        try {
            StateFactory theStateFactory = (StateFactory) EPackage.Registry.INSTANCE.getEFactory(StatePackage.eNS_URI);
            if (theStateFactory != null) {
                return theStateFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new StateFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public StateFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case StatePackage.POWER_STATE_REPOSITORY:
            return (EObject) createPowerStateRepository();
        case StatePackage.TRANSITION_STATE:
            return (EObject) createTransitionState();
        case StatePackage.POWER_STATE:
            return (EObject) createPowerState();
        case StatePackage.POWER_STATE_MACHINE:
            return (EObject) createPowerStateMachine();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerStateRepository createPowerStateRepository() {
        PowerStateRepositoryImpl powerStateRepository = new PowerStateRepositoryImpl();
        return powerStateRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TransitionState createTransitionState() {
        TransitionStateImpl transitionState = new TransitionStateImpl();
        return transitionState;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerState createPowerState() {
        PowerStateImpl powerState = new PowerStateImpl();
        return powerState;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerStateMachine createPowerStateMachine() {
        PowerStateMachineImpl powerStateMachine = new PowerStateMachineImpl();
        return powerStateMachine;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public StatePackage getStatePackage() {
        return (StatePackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static StatePackage getPackage() {
        return StatePackage.eINSTANCE;
    }

} // StateFactoryImpl
