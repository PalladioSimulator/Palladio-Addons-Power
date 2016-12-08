/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;
import org.palladiosimulator.pcm.PcmPackage;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.impl.BindingPackageImpl;
import de.fzi.power.infrastructure.AbstractPowerConsumingResource;
import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.impl.SpecificationPackageImpl;
import de.fzi.power.util.UtilPackage;
import de.fzi.power.util.impl.UtilPackageImpl;
import tools.descartes.dlim.DlimPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class InfrastructurePackageImpl extends EPackageImpl implements InfrastructurePackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass powerDistributionUnitEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass powerConsumingProvidingEntityEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass powerProvidingEntityEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass powerConsumingEntityEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass mountedPowerDistributionUnitEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass abstractPowerConsumingResourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass powerConsumingResourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass powerInfrastructureRepositoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass statefulPowerConsumingResourceEClass = null;

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
     * @see de.fzi.power.infrastructure.InfrastructurePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private InfrastructurePackageImpl() {
        super(eNS_URI, InfrastructureFactory.eINSTANCE);
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
     * This method is used to initialize {@link InfrastructurePackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static InfrastructurePackage init() {
        if (isInited) {
            return (InfrastructurePackage) EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);
        }

        // Obtain or create and register package
        final InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new InfrastructurePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        DlimPackage.eINSTANCE.eClass();
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final UtilPackageImpl theUtilPackage = (UtilPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) : UtilPackage.eINSTANCE);
        final SpecificationPackageImpl theSpecificationPackage = (SpecificationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SpecificationPackage.eNS_URI) instanceof SpecificationPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(SpecificationPackage.eNS_URI)
                        : SpecificationPackage.eINSTANCE);
        final BindingPackageImpl theBindingPackage = (BindingPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);

        // Create package meta-data objects
        theInfrastructurePackage.createPackageContents();
        theUtilPackage.createPackageContents();
        theSpecificationPackage.createPackageContents();
        theBindingPackage.createPackageContents();

        // Initialize created meta-data
        theInfrastructurePackage.initializePackageContents();
        theUtilPackage.initializePackageContents();
        theSpecificationPackage.initializePackageContents();
        theBindingPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theInfrastructurePackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(InfrastructurePackage.eNS_URI, theInfrastructurePackage);
        return theInfrastructurePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPowerDistributionUnit() {
        return this.powerDistributionUnitEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPowerConsumingProvidingEntity() {
        return this.powerConsumingProvidingEntityEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPowerProvidingEntity() {
        return this.powerProvidingEntityEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPowerProvidingEntity_NestedPowerConsumingEntities() {
        return (EReference) this.powerProvidingEntityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getPowerProvidingEntity_SuppliablePeakPower() {
        return (EAttribute) this.powerProvidingEntityEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPowerProvidingEntity_PowerInfrastructureModel() {
        return (EReference) this.powerProvidingEntityEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPowerProvidingEntity_DistributionPowerAssemblyContext() {
        return (EReference) this.powerProvidingEntityEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPowerConsumingEntity() {
        return this.powerConsumingEntityEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPowerConsumingEntity_PowerProvidingEntity() {
        return (EReference) this.powerConsumingEntityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMountedPowerDistributionUnit() {
        return this.mountedPowerDistributionUnitEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getMountedPowerDistributionUnit_ResourceContainer() {
        return (EReference) this.mountedPowerDistributionUnitEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAbstractPowerConsumingResource() {
        return this.abstractPowerConsumingResourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAbstractPowerConsumingResource_ProcessingResourceSpecification() {
        return (EReference) this.abstractPowerConsumingResourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPowerConsumingResource() {
        return this.powerConsumingResourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPowerConsumingResource_ResourcePowerAssemblyContext() {
        return (EReference) this.powerConsumingResourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPowerInfrastructureRepository() {
        return this.powerInfrastructureRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPowerInfrastructureRepository_ContainedPowerProvidingEntities() {
        return (EReference) this.powerInfrastructureRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getStatefulPowerConsumingResource() {
        return this.statefulPowerConsumingResourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getStatefulPowerConsumingResource_PowerState() {
        return (EReference) this.statefulPowerConsumingResourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getStatefulPowerConsumingResource_StatefulResourcePowerBinding() {
        return (EReference) this.statefulPowerConsumingResourceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureFactory getInfrastructureFactory() {
        return (InfrastructureFactory) this.getEFactoryInstance();
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
        this.powerDistributionUnitEClass = this.createEClass(POWER_DISTRIBUTION_UNIT);

        this.powerConsumingProvidingEntityEClass = this.createEClass(POWER_CONSUMING_PROVIDING_ENTITY);

        this.powerProvidingEntityEClass = this.createEClass(POWER_PROVIDING_ENTITY);
        this.createEReference(this.powerProvidingEntityEClass, POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES);
        this.createEAttribute(this.powerProvidingEntityEClass, POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER);
        this.createEReference(this.powerProvidingEntityEClass, POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL);
        this.createEReference(this.powerProvidingEntityEClass,
                POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT);

        this.powerConsumingEntityEClass = this.createEClass(POWER_CONSUMING_ENTITY);
        this.createEReference(this.powerConsumingEntityEClass, POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY);

        this.mountedPowerDistributionUnitEClass = this.createEClass(MOUNTED_POWER_DISTRIBUTION_UNIT);
        this.createEReference(this.mountedPowerDistributionUnitEClass,
                MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER);

        this.abstractPowerConsumingResourceEClass = this.createEClass(ABSTRACT_POWER_CONSUMING_RESOURCE);
        this.createEReference(this.abstractPowerConsumingResourceEClass,
                ABSTRACT_POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION);

        this.powerInfrastructureRepositoryEClass = this.createEClass(POWER_INFRASTRUCTURE_REPOSITORY);
        this.createEReference(this.powerInfrastructureRepositoryEClass,
                POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES);

        this.statefulPowerConsumingResourceEClass = this.createEClass(STATEFUL_POWER_CONSUMING_RESOURCE);
        this.createEReference(this.statefulPowerConsumingResourceEClass,
                STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE);
        this.createEReference(this.statefulPowerConsumingResourceEClass,
                STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING);

        this.powerConsumingResourceEClass = this.createEClass(POWER_CONSUMING_RESOURCE);
        this.createEReference(this.powerConsumingResourceEClass,
                POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT);
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
        final UtilPackage theUtilPackage = (UtilPackage) EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);
        final ExperimentDataPackage theExperimentDataPackage = (ExperimentDataPackage) EPackage.Registry.INSTANCE
                .getEPackage(ExperimentDataPackage.eNS_URI);
        final BindingPackage theBindingPackage = (BindingPackage) EPackage.Registry.INSTANCE
                .getEPackage(BindingPackage.eNS_URI);
        final ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage) EPackage.Registry.INSTANCE
                .getEPackage(ResourceenvironmentPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.powerDistributionUnitEClass.getESuperTypes().add(this.getPowerConsumingProvidingEntity());
        this.powerConsumingProvidingEntityEClass.getESuperTypes().add(this.getPowerConsumingEntity());
        this.powerConsumingProvidingEntityEClass.getESuperTypes().add(this.getPowerProvidingEntity());
        this.powerProvidingEntityEClass.getESuperTypes().add(theUtilPackage.getEntity());
        this.powerConsumingEntityEClass.getESuperTypes().add(theUtilPackage.getEntity());
        this.mountedPowerDistributionUnitEClass.getESuperTypes().add(this.getPowerDistributionUnit());
        this.abstractPowerConsumingResourceEClass.getESuperTypes().add(this.getPowerConsumingEntity());
        this.statefulPowerConsumingResourceEClass.getESuperTypes().add(this.getAbstractPowerConsumingResource());
        this.powerConsumingResourceEClass.getESuperTypes().add(this.getAbstractPowerConsumingResource());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.powerDistributionUnitEClass, PowerDistributionUnit.class, "PowerDistributionUnit",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.powerConsumingProvidingEntityEClass, PowerConsumingProvidingEntity.class,
                "PowerConsumingProvidingEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.powerProvidingEntityEClass, PowerProvidingEntity.class, "PowerProvidingEntity",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPowerProvidingEntity_NestedPowerConsumingEntities(), this.getPowerConsumingEntity(),
                this.getPowerConsumingEntity_PowerProvidingEntity(), "nestedPowerConsumingEntities", null, 0, -1,
                PowerProvidingEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        final EGenericType g1 = this.createEGenericType(theExperimentDataPackage.getEJSMeasure());
        EGenericType g2 = this.createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(theUtilPackage.getPower());
        g1.getETypeArguments().add(g2);
        this.initEAttribute(this.getPowerProvidingEntity_SuppliablePeakPower(), g1, "suppliablePeakPower", "", 0, 1,
                PowerProvidingEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getPowerProvidingEntity_PowerInfrastructureModel(),
                this.getPowerInfrastructureRepository(),
                this.getPowerInfrastructureRepository_ContainedPowerProvidingEntities(), "powerInfrastructureModel",
                null, 0, 1, PowerProvidingEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getPowerProvidingEntity_DistributionPowerAssemblyContext(),
                theBindingPackage.getDistributionPowerBinding(), null, "distributionPowerAssemblyContext", null, 0, 1,
                PowerProvidingEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.powerConsumingEntityEClass, PowerConsumingEntity.class, "PowerConsumingEntity",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPowerConsumingEntity_PowerProvidingEntity(), this.getPowerProvidingEntity(),
                this.getPowerProvidingEntity_NestedPowerConsumingEntities(), "powerProvidingEntity", null, 0, 1,
                PowerConsumingEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.mountedPowerDistributionUnitEClass, MountedPowerDistributionUnit.class,
                "MountedPowerDistributionUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getMountedPowerDistributionUnit_ResourceContainer(),
                theResourceenvironmentPackage.getResourceContainer(), null, "resourceContainer", null, 1, 1,
                MountedPowerDistributionUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.abstractPowerConsumingResourceEClass, AbstractPowerConsumingResource.class,
                "AbstractPowerConsumingResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAbstractPowerConsumingResource_ProcessingResourceSpecification(),
                theResourceenvironmentPackage.getProcessingResourceSpecification(), null,
                "processingResourceSpecification", null, 1, 1, AbstractPowerConsumingResource.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);

        this.initEClass(this.powerInfrastructureRepositoryEClass, PowerInfrastructureRepository.class,
                "PowerInfrastructureRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPowerInfrastructureRepository_ContainedPowerProvidingEntities(),
                this.getPowerProvidingEntity(), this.getPowerProvidingEntity_PowerInfrastructureModel(),
                "containedPowerProvidingEntities", null, 0, -1, PowerInfrastructureRepository.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        this.initEClass(this.statefulPowerConsumingResourceEClass, StatefulPowerConsumingResource.class,
                "StatefulPowerConsumingResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getStatefulPowerConsumingResource_PowerState(),
                theBindingPackage.getAbstractPowerState(), null, "powerState", null, 1, 1,
                StatefulPowerConsumingResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getStatefulPowerConsumingResource_StatefulResourcePowerBinding(),
                theBindingPackage.getStatefulResourcePowerBinding(), null, "statefulResourcePowerBinding", null, 1, 1,
                StatefulPowerConsumingResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.powerConsumingResourceEClass, PowerConsumingResource.class, "PowerConsumingResource",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPowerConsumingResource_ResourcePowerAssemblyContext(),
                theBindingPackage.getResourcePowerBinding(), null, "resourcePowerAssemblyContext", null, 0, 1,
                PowerConsumingResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // InfrastructurePackageImpl
