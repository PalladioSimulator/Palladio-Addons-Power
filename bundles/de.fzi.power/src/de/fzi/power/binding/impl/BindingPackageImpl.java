/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;
import org.palladiosimulator.metricspec.MetricSpecPackage;
import org.palladiosimulator.pcm.PcmPackage;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.AbstractPowerStateBinding;
import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ConsumptionBehavior;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValueDimensionless;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.PowerFactorBinding;
import de.fzi.power.binding.PowerStateBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.binding.TransitionStateBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.impl.InfrastructurePackageImpl;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.impl.SpecificationPackageImpl;
import de.fzi.power.state.StatePackage;
import de.fzi.power.state.impl.StatePackageImpl;
import de.fzi.power.util.UtilPackage;
import de.fzi.power.util.impl.UtilPackageImpl;
import de.uka.ipd.sdq.identifier.IdentifierPackage;
import tools.descartes.dlim.DlimPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class BindingPackageImpl extends EPackageImpl implements BindingPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass fixedFactorValuePowerEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass powerBindingRepositoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass powerBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass resourcePowerBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass distributionPowerBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass statefulResourcePowerBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractPowerStateBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass powerStateBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass transitionStateBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass powerFactorBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractFixedFactorValueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass fixedFactorValueDimensionlessEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass consumptionBehaviorEClass = null;

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
     * @see de.fzi.power.binding.BindingPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private BindingPackageImpl() {
        super(eNS_URI, BindingFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link BindingPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BindingPackage init() {
        if (isInited)
            return (BindingPackage) EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI);

        // Obtain or create and register package
        BindingPackageImpl theBindingPackage = (BindingPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new BindingPackageImpl());

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
        StatePackageImpl theStatePackage = (StatePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(StatePackage.eNS_URI) instanceof StatePackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(StatePackage.eNS_URI) : StatePackage.eINSTANCE);
        SpecificationPackageImpl theSpecificationPackage = (SpecificationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SpecificationPackage.eNS_URI) instanceof SpecificationPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(SpecificationPackage.eNS_URI)
                        : SpecificationPackage.eINSTANCE);
        InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(InfrastructurePackage.eNS_URI) instanceof InfrastructurePackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI)
                        : InfrastructurePackage.eINSTANCE);

        // Create package meta-data objects
        theBindingPackage.createPackageContents();
        theUtilPackage.createPackageContents();
        theStatePackage.createPackageContents();
        theSpecificationPackage.createPackageContents();
        theInfrastructurePackage.createPackageContents();

        // Initialize created meta-data
        theBindingPackage.initializePackageContents();
        theUtilPackage.initializePackageContents();
        theStatePackage.initializePackageContents();
        theSpecificationPackage.initializePackageContents();
        theInfrastructurePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theBindingPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(BindingPackage.eNS_URI, theBindingPackage);
        return theBindingPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getFixedFactorValuePower() {
        return fixedFactorValuePowerEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPowerBindingRepository() {
        return powerBindingRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPowerBindingRepository_PowerBindings() {
        return (EReference) powerBindingRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPowerBinding() {
        return powerBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPowerBinding_PowerBindingRepository() {
        return (EReference) powerBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getResourcePowerBinding() {
        return resourcePowerBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getResourcePowerBinding_ResourcePowerModelSpecification() {
        return (EReference) resourcePowerBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDistributionPowerBinding() {
        return distributionPowerBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDistributionPowerBinding_DistributionPowerModel() {
        return (EReference) distributionPowerBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getStatefulResourcePowerBinding() {
        return statefulResourcePowerBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatefulResourcePowerBinding_PowerStateMachine() {
        return (EReference) statefulResourcePowerBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatefulResourcePowerBinding_PowerStateBindings() {
        return (EReference) statefulResourcePowerBindingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAbstractPowerStateBinding() {
        return abstractPowerStateBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAbstractPowerStateBinding_StatefulResourcePowerBinding() {
        return (EReference) abstractPowerStateBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPowerStateBinding() {
        return powerStateBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPowerStateBinding_PowerState() {
        return (EReference) powerStateBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPowerStateBinding_Binding() {
        return (EReference) powerStateBindingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getTransitionStateBinding() {
        return transitionStateBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getTransitionStateBinding_TransitionState() {
        return (EReference) transitionStateBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getTransitionStateBinding_TransitionConsumption() {
        return (EReference) transitionStateBindingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPowerFactorBinding() {
        return powerFactorBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPowerFactorBinding_FixedFactorValues() {
        return (EReference) powerFactorBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAbstractFixedFactorValue() {
        return abstractFixedFactorValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAbstractFixedFactorValue_BoundFactor() {
        return (EReference) abstractFixedFactorValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractFixedFactorValue_Value() {
        return (EAttribute) abstractFixedFactorValueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAbstractFixedFactorValue_PowerBinding() {
        return (EReference) abstractFixedFactorValueEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getFixedFactorValueDimensionless() {
        return fixedFactorValueDimensionlessEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getConsumptionBehavior() {
        return consumptionBehaviorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getConsumptionBehavior_PowerCurve() {
        return (EReference) consumptionBehaviorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getConsumptionBehavior_Unit() {
        return (EAttribute) consumptionBehaviorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public BindingFactory getBindingFactory() {
        return (BindingFactory) getEFactoryInstance();
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
        fixedFactorValuePowerEClass = createEClass(FIXED_FACTOR_VALUE_POWER);

        powerBindingRepositoryEClass = createEClass(POWER_BINDING_REPOSITORY);
        createEReference(powerBindingRepositoryEClass, POWER_BINDING_REPOSITORY__POWER_BINDINGS);

        powerBindingEClass = createEClass(POWER_BINDING);
        createEReference(powerBindingEClass, POWER_BINDING__POWER_BINDING_REPOSITORY);

        resourcePowerBindingEClass = createEClass(RESOURCE_POWER_BINDING);
        createEReference(resourcePowerBindingEClass, RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION);

        distributionPowerBindingEClass = createEClass(DISTRIBUTION_POWER_BINDING);
        createEReference(distributionPowerBindingEClass, DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL);

        powerFactorBindingEClass = createEClass(POWER_FACTOR_BINDING);
        createEReference(powerFactorBindingEClass, POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES);

        abstractFixedFactorValueEClass = createEClass(ABSTRACT_FIXED_FACTOR_VALUE);
        createEReference(abstractFixedFactorValueEClass, ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR);
        createEAttribute(abstractFixedFactorValueEClass, ABSTRACT_FIXED_FACTOR_VALUE__VALUE);
        createEReference(abstractFixedFactorValueEClass, ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING);

        fixedFactorValueDimensionlessEClass = createEClass(FIXED_FACTOR_VALUE_DIMENSIONLESS);

        consumptionBehaviorEClass = createEClass(CONSUMPTION_BEHAVIOR);
        createEReference(consumptionBehaviorEClass, CONSUMPTION_BEHAVIOR__POWER_CURVE);
        createEAttribute(consumptionBehaviorEClass, CONSUMPTION_BEHAVIOR__UNIT);

        statefulResourcePowerBindingEClass = createEClass(STATEFUL_RESOURCE_POWER_BINDING);
        createEReference(statefulResourcePowerBindingEClass, STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_MACHINE);
        createEReference(statefulResourcePowerBindingEClass, STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS);

        abstractPowerStateBindingEClass = createEClass(ABSTRACT_POWER_STATE_BINDING);
        createEReference(abstractPowerStateBindingEClass,
                ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING);

        powerStateBindingEClass = createEClass(POWER_STATE_BINDING);
        createEReference(powerStateBindingEClass, POWER_STATE_BINDING__POWER_STATE);
        createEReference(powerStateBindingEClass, POWER_STATE_BINDING__BINDING);

        transitionStateBindingEClass = createEClass(TRANSITION_STATE_BINDING);
        createEReference(transitionStateBindingEClass, TRANSITION_STATE_BINDING__TRANSITION_STATE);
        createEReference(transitionStateBindingEClass, TRANSITION_STATE_BINDING__TRANSITION_CONSUMPTION);
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
        IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
                .getEPackage(IdentifierPackage.eNS_URI);
        SpecificationPackage theSpecificationPackage = (SpecificationPackage) EPackage.Registry.INSTANCE
                .getEPackage(SpecificationPackage.eNS_URI);
        MetricSpecPackage theMetricSpecPackage = (MetricSpecPackage) EPackage.Registry.INSTANCE
                .getEPackage(MetricSpecPackage.eNS_URI);
        ExperimentDataPackage theExperimentDataPackage = (ExperimentDataPackage) EPackage.Registry.INSTANCE
                .getEPackage(ExperimentDataPackage.eNS_URI);
        DlimPackage theDlimPackage = (DlimPackage) EPackage.Registry.INSTANCE.getEPackage(DlimPackage.eNS_URI);
        StatePackage theStatePackage = (StatePackage) EPackage.Registry.INSTANCE.getEPackage(StatePackage.eNS_URI);

        // Create type parameters
        ETypeParameter abstractFixedFactorValueEClass_Q = addETypeParameter(abstractFixedFactorValueEClass, "Q");

        // Set bounds for type parameters
        EGenericType g1 = createEGenericType(theMetricSpecPackage.getIJSQuantity());
        abstractFixedFactorValueEClass_Q.getEBounds().add(g1);

        // Add supertypes to classes
        g1 = createEGenericType(this.getAbstractFixedFactorValue());
        EGenericType g2 = createEGenericType(theUtilPackage.getPower());
        g1.getETypeArguments().add(g2);
        fixedFactorValuePowerEClass.getEGenericSuperTypes().add(g1);
        powerBindingRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        powerBindingEClass.getESuperTypes().add(theUtilPackage.getEntity());
        resourcePowerBindingEClass.getESuperTypes().add(this.getPowerFactorBinding());
        distributionPowerBindingEClass.getESuperTypes().add(this.getPowerFactorBinding());
        powerFactorBindingEClass.getESuperTypes().add(this.getPowerBinding());
        abstractFixedFactorValueEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        g1 = createEGenericType(this.getAbstractFixedFactorValue());
        g2 = createEGenericType(theUtilPackage.getDimensionless());
        g1.getETypeArguments().add(g2);
        fixedFactorValueDimensionlessEClass.getEGenericSuperTypes().add(g1);
        consumptionBehaviorEClass.getESuperTypes().add(theUtilPackage.getEntity());
        statefulResourcePowerBindingEClass.getESuperTypes().add(this.getPowerBinding());
        abstractPowerStateBindingEClass.getESuperTypes().add(theUtilPackage.getEntity());
        powerStateBindingEClass.getESuperTypes().add(this.getAbstractPowerStateBinding());
        transitionStateBindingEClass.getESuperTypes().add(this.getAbstractPowerStateBinding());

        // Initialize classes and features; add operations and parameters
        initEClass(fixedFactorValuePowerEClass, FixedFactorValuePower.class, "FixedFactorValuePower", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(powerBindingRepositoryEClass, PowerBindingRepository.class, "PowerBindingRepository", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPowerBindingRepository_PowerBindings(), this.getPowerBinding(),
                this.getPowerBinding_PowerBindingRepository(), "powerBindings", null, 0, -1,
                PowerBindingRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(powerBindingEClass, PowerBinding.class, "PowerBinding", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPowerBinding_PowerBindingRepository(), this.getPowerBindingRepository(),
                this.getPowerBindingRepository_PowerBindings(), "powerBindingRepository", null, 0, 1,
                PowerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resourcePowerBindingEClass, ResourcePowerBinding.class, "ResourcePowerBinding", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResourcePowerBinding_ResourcePowerModelSpecification(),
                theSpecificationPackage.getResourcePowerModelSpecification(), null, "resourcePowerModelSpecification",
                null, 1, 1, ResourcePowerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(distributionPowerBindingEClass, DistributionPowerBinding.class, "DistributionPowerBinding",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDistributionPowerBinding_DistributionPowerModel(),
                theSpecificationPackage.getDistributionPowerModelSpecification(), null, "distributionPowerModel", null,
                1, 1, DistributionPowerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(powerFactorBindingEClass, PowerFactorBinding.class, "PowerFactorBinding", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        g1 = createEGenericType(this.getAbstractFixedFactorValue());
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        initEReference(getPowerFactorBinding_FixedFactorValues(), g1, this.getAbstractFixedFactorValue_PowerBinding(),
                "fixedFactorValues", null, 0, -1, PowerFactorBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abstractFixedFactorValueEClass, AbstractFixedFactorValue.class, "AbstractFixedFactorValue",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAbstractFixedFactorValue_BoundFactor(), theSpecificationPackage.getFixedFactor(), null,
                "boundFactor", null, 1, 1, AbstractFixedFactorValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(theExperimentDataPackage.getEJSMeasure());
        g2 = createEGenericType(ecorePackage.getEDoubleObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(abstractFixedFactorValueEClass_Q);
        g1.getETypeArguments().add(g2);
        initEAttribute(getAbstractFixedFactorValue_Value(), g1, "value", null, 0, 1, AbstractFixedFactorValue.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractFixedFactorValue_PowerBinding(), this.getPowerFactorBinding(),
                this.getPowerFactorBinding_FixedFactorValues(), "powerBinding", null, 0, 1,
                AbstractFixedFactorValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(fixedFactorValueDimensionlessEClass, FixedFactorValueDimensionless.class,
                "FixedFactorValueDimensionless", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(consumptionBehaviorEClass, ConsumptionBehavior.class, "ConsumptionBehavior", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConsumptionBehavior_PowerCurve(), theDlimPackage.getSequence(), null, "powerCurve", null, 1,
                1, ConsumptionBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(theMetricSpecPackage.getEJSUnit());
        g2 = createEGenericType(theUtilPackage.getPower());
        g1.getETypeArguments().add(g2);
        initEAttribute(getConsumptionBehavior_Unit(), g1, "unit", null, 1, 1, ConsumptionBehavior.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(statefulResourcePowerBindingEClass, StatefulResourcePowerBinding.class,
                "StatefulResourcePowerBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getStatefulResourcePowerBinding_PowerStateMachine(), theStatePackage.getPowerStateMachine(),
                null, "powerStateMachine", null, 1, 1, StatefulResourcePowerBinding.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatefulResourcePowerBinding_PowerStateBindings(), this.getAbstractPowerStateBinding(),
                this.getAbstractPowerStateBinding_StatefulResourcePowerBinding(), "powerStateBindings", null, 1, -1,
                StatefulResourcePowerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abstractPowerStateBindingEClass, AbstractPowerStateBinding.class, "AbstractPowerStateBinding",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAbstractPowerStateBinding_StatefulResourcePowerBinding(),
                this.getStatefulResourcePowerBinding(), this.getStatefulResourcePowerBinding_PowerStateBindings(),
                "statefulResourcePowerBinding", null, 0, 1, AbstractPowerStateBinding.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        initEClass(powerStateBindingEClass, PowerStateBinding.class, "PowerStateBinding", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPowerStateBinding_PowerState(), theStatePackage.getPowerState(), null, "powerState", null, 1,
                1, PowerStateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPowerStateBinding_Binding(), this.getResourcePowerBinding(), null, "binding", null, 1, 1,
                PowerStateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(transitionStateBindingEClass, TransitionStateBinding.class, "TransitionStateBinding", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTransitionStateBinding_TransitionState(), theStatePackage.getTransitionState(), null,
                "transitionState", null, 1, 1, TransitionStateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTransitionStateBinding_TransitionConsumption(), this.getConsumptionBehavior(), null,
                "transitionConsumption", null, 1, 1, TransitionStateBinding.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // BindingPackageImpl
