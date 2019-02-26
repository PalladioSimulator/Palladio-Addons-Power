/**
 */
package de.fzi.power.state.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;
import org.palladiosimulator.pcm.PcmPackage;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.impl.BindingPackageImpl;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.impl.InfrastructurePackageImpl;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.impl.SpecificationPackageImpl;
import de.fzi.power.state.AbstractPowerState;
import de.fzi.power.state.PowerState;
import de.fzi.power.state.PowerStateMachine;
import de.fzi.power.state.PowerStateRepository;
import de.fzi.power.state.StateFactory;
import de.fzi.power.state.StatePackage;
import de.fzi.power.state.TransitionState;
import de.fzi.power.util.UtilPackage;
import de.fzi.power.util.impl.UtilPackageImpl;
import tools.descartes.dlim.DlimPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class StatePackageImpl extends EPackageImpl implements StatePackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass powerStateRepositoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractPowerStateEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass transitionStateEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass powerStateEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass powerStateMachineEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.fzi.power.state.StatePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private StatePackageImpl() {
        super(eNS_URI, StateFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link StatePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static StatePackage init() {
        if (isInited)
            return (StatePackage) EPackage.Registry.INSTANCE.getEPackage(StatePackage.eNS_URI);

        // Obtain or create and register package
        StatePackageImpl theStatePackage = (StatePackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof StatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new StatePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        DlimPackage.eINSTANCE.eClass();
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        UtilPackageImpl theUtilPackage = (UtilPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) : UtilPackage.eINSTANCE);
        SpecificationPackageImpl theSpecificationPackage = (SpecificationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SpecificationPackage.eNS_URI) instanceof SpecificationPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(SpecificationPackage.eNS_URI)
                        : SpecificationPackage.eINSTANCE);
        BindingPackageImpl theBindingPackage = (BindingPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
        InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(InfrastructurePackage.eNS_URI) instanceof InfrastructurePackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI)
                        : InfrastructurePackage.eINSTANCE);

        // Create package meta-data objects
        theStatePackage.createPackageContents();
        theUtilPackage.createPackageContents();
        theSpecificationPackage.createPackageContents();
        theBindingPackage.createPackageContents();
        theInfrastructurePackage.createPackageContents();

        // Initialize created meta-data
        theStatePackage.initializePackageContents();
        theUtilPackage.initializePackageContents();
        theSpecificationPackage.initializePackageContents();
        theBindingPackage.initializePackageContents();
        theInfrastructurePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theStatePackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(StatePackage.eNS_URI, theStatePackage);
        return theStatePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPowerStateRepository() {
        return powerStateRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPowerStateRepository_PowerStateMachines() {
        return (EReference) powerStateRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAbstractPowerState() {
        return abstractPowerStateEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAbstractPowerState_PowerStateMachine() {
        return (EReference) abstractPowerStateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getTransitionState() {
        return transitionStateEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getTransitionState_InitialState() {
        return (EReference) transitionStateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getTransitionState_TargetState() {
        return (EReference) transitionStateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPowerState() {
        return powerStateEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPowerStateMachine() {
        return powerStateMachineEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPowerStateMachine_PowerStateRepository() {
        return (EReference) powerStateMachineEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPowerStateMachine_PowerStates() {
        return (EReference) powerStateMachineEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public StateFactory getStateFactory() {
        return (StateFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        powerStateRepositoryEClass = createEClass(POWER_STATE_REPOSITORY);
        createEReference(powerStateRepositoryEClass, POWER_STATE_REPOSITORY__POWER_STATE_MACHINES);

        abstractPowerStateEClass = createEClass(ABSTRACT_POWER_STATE);
        createEReference(abstractPowerStateEClass, ABSTRACT_POWER_STATE__POWER_STATE_MACHINE);

        transitionStateEClass = createEClass(TRANSITION_STATE);
        createEReference(transitionStateEClass, TRANSITION_STATE__INITIAL_STATE);
        createEReference(transitionStateEClass, TRANSITION_STATE__TARGET_STATE);

        powerStateEClass = createEClass(POWER_STATE);

        powerStateMachineEClass = createEClass(POWER_STATE_MACHINE);
        createEReference(powerStateMachineEClass, POWER_STATE_MACHINE__POWER_STATE_REPOSITORY);
        createEReference(powerStateMachineEClass, POWER_STATE_MACHINE__POWER_STATES);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        UtilPackage theUtilPackage = (UtilPackage) EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        powerStateRepositoryEClass.getESuperTypes().add(theUtilPackage.getEntity());
        abstractPowerStateEClass.getESuperTypes().add(theUtilPackage.getEntity());
        transitionStateEClass.getESuperTypes().add(this.getAbstractPowerState());
        powerStateEClass.getESuperTypes().add(this.getAbstractPowerState());
        powerStateMachineEClass.getESuperTypes().add(theUtilPackage.getEntity());

        // Initialize classes and features; add operations and parameters
        initEClass(powerStateRepositoryEClass, PowerStateRepository.class, "PowerStateRepository", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPowerStateRepository_PowerStateMachines(), this.getPowerStateMachine(),
                this.getPowerStateMachine_PowerStateRepository(), "powerStateMachines", null, 0, -1,
                PowerStateRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abstractPowerStateEClass, AbstractPowerState.class, "AbstractPowerState", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAbstractPowerState_PowerStateMachine(), this.getPowerStateMachine(),
                this.getPowerStateMachine_PowerStates(), "powerStateMachine", null, 0, 1, AbstractPowerState.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(transitionStateEClass, TransitionState.class, "TransitionState", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTransitionState_InitialState(), this.getPowerState(), null, "initialState", null, 1, 1,
                TransitionState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTransitionState_TargetState(), this.getPowerState(), null, "targetState", null, 1, 1,
                TransitionState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(powerStateEClass, PowerState.class, "PowerState", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(powerStateMachineEClass, PowerStateMachine.class, "PowerStateMachine", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPowerStateMachine_PowerStateRepository(), this.getPowerStateRepository(),
                this.getPowerStateRepository_PowerStateMachines(), "powerStateRepository", null, 0, 1,
                PowerStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPowerStateMachine_PowerStates(), this.getAbstractPowerState(),
                this.getAbstractPowerState_PowerStateMachine(), "powerStates", null, 1, -1, PowerStateMachine.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // StatePackageImpl
