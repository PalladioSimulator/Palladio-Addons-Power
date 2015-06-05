/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.impl.InfrastructurePackageImpl;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.impl.SpecificationPackageImpl;
import de.fzi.power.util.UtilPackage;
import de.fzi.power.util.impl.UtilPackageImpl;
import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.PcmPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class BindingPackageImpl extends EPackageImpl implements BindingPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass fixedFactorValueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass powerBindingRepositoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass powerBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass resourcePowerBindingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass distributionPowerBindingEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link BindingPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BindingPackage init() {
        if (isInited) {
            return (BindingPackage) EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI);
        }

        // Obtain or create and register package
        final BindingPackageImpl theBindingPackage = (BindingPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI)
                : new BindingPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final UtilPackageImpl theUtilPackage = (UtilPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(UtilPackage.eNS_URI) : UtilPackage.eINSTANCE);
        final SpecificationPackageImpl theSpecificationPackage = (SpecificationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SpecificationPackage.eNS_URI) instanceof SpecificationPackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(SpecificationPackage.eNS_URI)
                : SpecificationPackage.eINSTANCE);
        final InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(InfrastructurePackage.eNS_URI) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(InfrastructurePackage.eNS_URI)
                : InfrastructurePackage.eINSTANCE);

        // Create package meta-data objects
        theBindingPackage.createPackageContents();
        theUtilPackage.createPackageContents();
        theSpecificationPackage.createPackageContents();
        theInfrastructurePackage.createPackageContents();

        // Initialize created meta-data
        theBindingPackage.initializePackageContents();
        theUtilPackage.initializePackageContents();
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
     * 
     * @generated
     */
    @Override
    public EClass getFixedFactorValue() {
        return this.fixedFactorValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFixedFactorValue_BoundFactor() {
        return (EReference) this.fixedFactorValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFixedFactorValue_Value() {
        return (EAttribute) this.fixedFactorValueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFixedFactorValue_PowerBinding() {
        return (EReference) this.fixedFactorValueEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPowerBindingRepository() {
        return this.powerBindingRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getPowerBindingRepository_PowerBindings() {
        return (EReference) this.powerBindingRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPowerBinding() {
        return this.powerBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getPowerBinding_PowerBindingRepository() {
        return (EReference) this.powerBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getPowerBinding_FixedFactorValues() {
        return (EReference) this.powerBindingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getResourcePowerBinding() {
        return this.resourcePowerBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourcePowerBinding_ResourcePowerModelSpecification() {
        return (EReference) this.resourcePowerBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDistributionPowerBinding() {
        return this.distributionPowerBindingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDistributionPowerBinding_DistributionPowerModel() {
        return (EReference) this.distributionPowerBindingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BindingFactory getBindingFactory() {
        return (BindingFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.fixedFactorValueEClass = this.createEClass(FIXED_FACTOR_VALUE);
        this.createEReference(this.fixedFactorValueEClass, FIXED_FACTOR_VALUE__BOUND_FACTOR);
        this.createEAttribute(this.fixedFactorValueEClass, FIXED_FACTOR_VALUE__VALUE);
        this.createEReference(this.fixedFactorValueEClass, FIXED_FACTOR_VALUE__POWER_BINDING);

        this.powerBindingRepositoryEClass = this.createEClass(POWER_BINDING_REPOSITORY);
        this.createEReference(this.powerBindingRepositoryEClass, POWER_BINDING_REPOSITORY__POWER_BINDINGS);

        this.powerBindingEClass = this.createEClass(POWER_BINDING);
        this.createEReference(this.powerBindingEClass, POWER_BINDING__POWER_BINDING_REPOSITORY);
        this.createEReference(this.powerBindingEClass, POWER_BINDING__FIXED_FACTOR_VALUES);

        this.resourcePowerBindingEClass = this.createEClass(RESOURCE_POWER_BINDING);
        this.createEReference(this.resourcePowerBindingEClass,
                RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION);

        this.distributionPowerBindingEClass = this.createEClass(DISTRIBUTION_POWER_BINDING);
        this.createEReference(this.distributionPowerBindingEClass, DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
                .getEPackage(IdentifierPackage.eNS_URI);
        final SpecificationPackage theSpecificationPackage = (SpecificationPackage) EPackage.Registry.INSTANCE
                .getEPackage(SpecificationPackage.eNS_URI);
        final ExperimentDataPackage theExperimentDataPackage = (ExperimentDataPackage) EPackage.Registry.INSTANCE
                .getEPackage(ExperimentDataPackage.eNS_URI);
        final UtilPackage theUtilPackage = (UtilPackage) EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.fixedFactorValueEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.powerBindingRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.powerBindingEClass.getESuperTypes().add(theUtilPackage.getEntity());
        this.resourcePowerBindingEClass.getESuperTypes().add(this.getPowerBinding());
        this.distributionPowerBindingEClass.getESuperTypes().add(this.getPowerBinding());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.fixedFactorValueEClass, FixedFactorValue.class, "FixedFactorValue", !IS_ABSTRACT,
                !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getFixedFactorValue_BoundFactor(), theSpecificationPackage.getFixedFactor(), null,
                "boundFactor", null, 1, 1, FixedFactorValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        final EGenericType g1 = this.createEGenericType(theExperimentDataPackage.getEJSMeasure());
        EGenericType g2 = this.createEGenericType(this.ecorePackage.getEDoubleObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(theUtilPackage.getPower());
        g1.getETypeArguments().add(g2);
        this.initEAttribute(this.getFixedFactorValue_Value(), g1, "value", null, 0, 1, FixedFactorValue.class,
                !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getFixedFactorValue_PowerBinding(), this.getPowerBinding(),
                this.getPowerBinding_FixedFactorValues(), "powerBinding", null, 0, 1, FixedFactorValue.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.powerBindingRepositoryEClass, PowerBindingRepository.class, "PowerBindingRepository",
                !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPowerBindingRepository_PowerBindings(), this.getPowerBinding(),
                this.getPowerBinding_PowerBindingRepository(), "powerBindings", null, 0, -1,
                PowerBindingRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.powerBindingEClass, PowerBinding.class, "PowerBinding", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPowerBinding_PowerBindingRepository(), this.getPowerBindingRepository(),
                this.getPowerBindingRepository_PowerBindings(), "powerBindingRepository", null, 0, 1,
                PowerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getPowerBinding_FixedFactorValues(), this.getFixedFactorValue(),
                this.getFixedFactorValue_PowerBinding(), "fixedFactorValues", null, 0, -1, PowerBinding.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.resourcePowerBindingEClass, ResourcePowerBinding.class, "ResourcePowerBinding",
                !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getResourcePowerBinding_ResourcePowerModelSpecification(),
                theSpecificationPackage.getResourcePowerModelSpecification(), null, "resourcePowerModelSpecification",
                null, 1, 1, ResourcePowerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.distributionPowerBindingEClass, DistributionPowerBinding.class,
                "DistributionPowerBinding",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getDistributionPowerBinding_DistributionPowerModel(),
                theSpecificationPackage.getDistributionPowerModelSpecification(), null, "distributionPowerModel", null,
                1, 1, DistributionPowerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // BindingPackageImpl
