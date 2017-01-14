/**
 */
package de.fzi.power.state;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.fzi.power.util.UtilPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see de.fzi.power.state.StateFactory
 * @model kind="package"
 * @generated
 */
public interface StatePackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "state";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://www.fzi.de/Power/State/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "de.fzi.power";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    StatePackage eINSTANCE = de.fzi.power.state.impl.StatePackageImpl.init();

    /**
     * The meta object id for the '{@link de.fzi.power.state.impl.PowerStateRepositoryImpl
     * <em>Power State Repository</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.state.impl.PowerStateRepositoryImpl
     * @see de.fzi.power.state.impl.StatePackageImpl#getPowerStateRepository()
     * @generated
     */
    int POWER_STATE_REPOSITORY = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_REPOSITORY__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_REPOSITORY__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power State Machines</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_REPOSITORY__POWER_STATE_MACHINES = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Power State Repository</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_REPOSITORY_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.state.impl.AbstractPowerStateImpl
     * <em>Abstract Power State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.state.impl.AbstractPowerStateImpl
     * @see de.fzi.power.state.impl.StatePackageImpl#getAbstractPowerState()
     * @generated
     */
    int ABSTRACT_POWER_STATE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_POWER_STATE__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_POWER_STATE__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power State Machine</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_POWER_STATE__POWER_STATE_MACHINE = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Abstract Power State</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_POWER_STATE_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.state.impl.TransitionStateImpl
     * <em>Transition State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.state.impl.TransitionStateImpl
     * @see de.fzi.power.state.impl.StatePackageImpl#getTransitionState()
     * @generated
     */
    int TRANSITION_STATE = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__ID = ABSTRACT_POWER_STATE__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__NAME = ABSTRACT_POWER_STATE__NAME;

    /**
     * The feature id for the '<em><b>Power State Machine</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__POWER_STATE_MACHINE = ABSTRACT_POWER_STATE__POWER_STATE_MACHINE;

    /**
     * The feature id for the '<em><b>Initial State</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__INITIAL_STATE = ABSTRACT_POWER_STATE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target State</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__TARGET_STATE = ABSTRACT_POWER_STATE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Transition State</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE_FEATURE_COUNT = ABSTRACT_POWER_STATE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.fzi.power.state.impl.PowerStateImpl
     * <em>Power State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.state.impl.PowerStateImpl
     * @see de.fzi.power.state.impl.StatePackageImpl#getPowerState()
     * @generated
     */
    int POWER_STATE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE__ID = ABSTRACT_POWER_STATE__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE__NAME = ABSTRACT_POWER_STATE__NAME;

    /**
     * The feature id for the '<em><b>Power State Machine</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE__POWER_STATE_MACHINE = ABSTRACT_POWER_STATE__POWER_STATE_MACHINE;

    /**
     * The number of structural features of the '<em>Power State</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_FEATURE_COUNT = ABSTRACT_POWER_STATE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.state.impl.PowerStateMachineImpl
     * <em>Power State Machine</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.state.impl.PowerStateMachineImpl
     * @see de.fzi.power.state.impl.StatePackageImpl#getPowerStateMachine()
     * @generated
     */
    int POWER_STATE_MACHINE = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_MACHINE__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_MACHINE__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power State Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_MACHINE__POWER_STATE_REPOSITORY = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Power States</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_MACHINE__POWER_STATES = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Power State Machine</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_MACHINE_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * Returns the meta object for class '{@link de.fzi.power.state.PowerStateRepository
     * <em>Power State Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power State Repository</em>'.
     * @see de.fzi.power.state.PowerStateRepository
     * @generated
     */
    EClass getPowerStateRepository();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.power.state.PowerStateRepository#getPowerStateMachines
     * <em>Power State Machines</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Power State Machines</em>'.
     * @see de.fzi.power.state.PowerStateRepository#getPowerStateMachines()
     * @see #getPowerStateRepository()
     * @generated
     */
    EReference getPowerStateRepository_PowerStateMachines();

    /**
     * Returns the meta object for class '{@link de.fzi.power.state.AbstractPowerState
     * <em>Abstract Power State</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Abstract Power State</em>'.
     * @see de.fzi.power.state.AbstractPowerState
     * @generated
     */
    EClass getAbstractPowerState();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.power.state.AbstractPowerState#getPowerStateMachine
     * <em>Power State Machine</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Power State Machine</em>'.
     * @see de.fzi.power.state.AbstractPowerState#getPowerStateMachine()
     * @see #getAbstractPowerState()
     * @generated
     */
    EReference getAbstractPowerState_PowerStateMachine();

    /**
     * Returns the meta object for class '{@link de.fzi.power.state.TransitionState
     * <em>Transition State</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Transition State</em>'.
     * @see de.fzi.power.state.TransitionState
     * @generated
     */
    EClass getTransitionState();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.state.TransitionState#getInitialState <em>Initial State</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Initial State</em>'.
     * @see de.fzi.power.state.TransitionState#getInitialState()
     * @see #getTransitionState()
     * @generated
     */
    EReference getTransitionState_InitialState();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.state.TransitionState#getTargetState <em>Target State</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Target State</em>'.
     * @see de.fzi.power.state.TransitionState#getTargetState()
     * @see #getTransitionState()
     * @generated
     */
    EReference getTransitionState_TargetState();

    /**
     * Returns the meta object for class '{@link de.fzi.power.state.PowerState <em>Power State</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power State</em>'.
     * @see de.fzi.power.state.PowerState
     * @generated
     */
    EClass getPowerState();

    /**
     * Returns the meta object for class '{@link de.fzi.power.state.PowerStateMachine
     * <em>Power State Machine</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power State Machine</em>'.
     * @see de.fzi.power.state.PowerStateMachine
     * @generated
     */
    EClass getPowerStateMachine();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.power.state.PowerStateMachine#getPowerStateRepository
     * <em>Power State Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Power State Repository</em>'.
     * @see de.fzi.power.state.PowerStateMachine#getPowerStateRepository()
     * @see #getPowerStateMachine()
     * @generated
     */
    EReference getPowerStateMachine_PowerStateRepository();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.power.state.PowerStateMachine#getPowerStates <em>Power States</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Power States</em>'.
     * @see de.fzi.power.state.PowerStateMachine#getPowerStates()
     * @see #getPowerStateMachine()
     * @generated
     */
    EReference getPowerStateMachine_PowerStates();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    StateFactory getStateFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     *
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link de.fzi.power.state.impl.PowerStateRepositoryImpl
         * <em>Power State Repository</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.state.impl.PowerStateRepositoryImpl
         * @see de.fzi.power.state.impl.StatePackageImpl#getPowerStateRepository()
         * @generated
         */
        EClass POWER_STATE_REPOSITORY = eINSTANCE.getPowerStateRepository();

        /**
         * The meta object literal for the '<em><b>Power State Machines</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_STATE_REPOSITORY__POWER_STATE_MACHINES = eINSTANCE
                .getPowerStateRepository_PowerStateMachines();

        /**
         * The meta object literal for the '{@link de.fzi.power.state.impl.AbstractPowerStateImpl
         * <em>Abstract Power State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.state.impl.AbstractPowerStateImpl
         * @see de.fzi.power.state.impl.StatePackageImpl#getAbstractPowerState()
         * @generated
         */
        EClass ABSTRACT_POWER_STATE = eINSTANCE.getAbstractPowerState();

        /**
         * The meta object literal for the '<em><b>Power State Machine</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ABSTRACT_POWER_STATE__POWER_STATE_MACHINE = eINSTANCE.getAbstractPowerState_PowerStateMachine();

        /**
         * The meta object literal for the '{@link de.fzi.power.state.impl.TransitionStateImpl
         * <em>Transition State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.state.impl.TransitionStateImpl
         * @see de.fzi.power.state.impl.StatePackageImpl#getTransitionState()
         * @generated
         */
        EClass TRANSITION_STATE = eINSTANCE.getTransitionState();

        /**
         * The meta object literal for the '<em><b>Initial State</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference TRANSITION_STATE__INITIAL_STATE = eINSTANCE.getTransitionState_InitialState();

        /**
         * The meta object literal for the '<em><b>Target State</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference TRANSITION_STATE__TARGET_STATE = eINSTANCE.getTransitionState_TargetState();

        /**
         * The meta object literal for the '{@link de.fzi.power.state.impl.PowerStateImpl
         * <em>Power State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.state.impl.PowerStateImpl
         * @see de.fzi.power.state.impl.StatePackageImpl#getPowerState()
         * @generated
         */
        EClass POWER_STATE = eINSTANCE.getPowerState();

        /**
         * The meta object literal for the '{@link de.fzi.power.state.impl.PowerStateMachineImpl
         * <em>Power State Machine</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.state.impl.PowerStateMachineImpl
         * @see de.fzi.power.state.impl.StatePackageImpl#getPowerStateMachine()
         * @generated
         */
        EClass POWER_STATE_MACHINE = eINSTANCE.getPowerStateMachine();

        /**
         * The meta object literal for the '<em><b>Power State Repository</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_STATE_MACHINE__POWER_STATE_REPOSITORY = eINSTANCE.getPowerStateMachine_PowerStateRepository();

        /**
         * The meta object literal for the '<em><b>Power States</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_STATE_MACHINE__POWER_STATES = eINSTANCE.getPowerStateMachine_PowerStates();

    }

} // StatePackage
