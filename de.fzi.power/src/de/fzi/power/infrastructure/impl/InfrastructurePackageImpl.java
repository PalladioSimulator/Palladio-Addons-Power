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
import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.impl.SpecificationPackageImpl;
import de.fzi.power.util.UtilPackage;
import de.fzi.power.util.impl.UtilPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class InfrastructurePackageImpl extends EPackageImpl implements
		InfrastructurePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerDistributionUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerConsumingProvidingEntityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerProvidingEntityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerConsumingEntityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mountedPowerDistributionUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerConsumingResourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerInfrastructureRepositoryEClass = null;

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
	 * @see de.fzi.power.infrastructure.InfrastructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InfrastructurePackageImpl() {
		super(eNS_URI, InfrastructureFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link InfrastructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InfrastructurePackage init() {
		if (isInited)
			return (InfrastructurePackage) EPackage.Registry.INSTANCE
					.getEPackage(InfrastructurePackage.eNS_URI);

		// Obtain or create and register package
		InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new InfrastructurePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExperimentDataPackage.eINSTANCE.eClass();
		RepositoryPackage.eINSTANCE.eClass();
		MeasuringpointPackage.eINSTANCE.eClass();
		PcmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		UtilPackageImpl theUtilPackage = (UtilPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(UtilPackage.eNS_URI) : UtilPackage.eINSTANCE);
		SpecificationPackageImpl theSpecificationPackage = (SpecificationPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SpecificationPackage.eNS_URI) instanceof SpecificationPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SpecificationPackage.eNS_URI)
				: SpecificationPackage.eINSTANCE);
		BindingPackageImpl theBindingPackage = (BindingPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);

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
		EPackage.Registry.INSTANCE.put(InfrastructurePackage.eNS_URI,
				theInfrastructurePackage);
		return theInfrastructurePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerDistributionUnit() {
		return powerDistributionUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerConsumingProvidingEntity() {
		return powerConsumingProvidingEntityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerProvidingEntity() {
		return powerProvidingEntityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerProvidingEntity_NestedPowerConsumingEntities() {
		return (EReference) powerProvidingEntityEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPowerProvidingEntity_SuppliablePeakPower() {
		return (EAttribute) powerProvidingEntityEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerProvidingEntity_PowerInfrastructureModel() {
		return (EReference) powerProvidingEntityEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerProvidingEntity_DistributionPowerAssemblyContext() {
		return (EReference) powerProvidingEntityEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerConsumingEntity() {
		return powerConsumingEntityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerConsumingEntity_PowerProvidingEntity() {
		return (EReference) powerConsumingEntityEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMountedPowerDistributionUnit() {
		return mountedPowerDistributionUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMountedPowerDistributionUnit_ResourceContainer() {
		return (EReference) mountedPowerDistributionUnitEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerConsumingResource() {
		return powerConsumingResourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerConsumingResource_ProcessingResourceSpecification() {
		return (EReference) powerConsumingResourceEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerConsumingResource_ResourcePowerAssemblyContext() {
		return (EReference) powerConsumingResourceEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerInfrastructureRepository() {
		return powerInfrastructureRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerInfrastructureRepository_ContainedPowerProvidingEntities() {
		return (EReference) powerInfrastructureRepositoryEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InfrastructureFactory getInfrastructureFactory() {
		return (InfrastructureFactory) getEFactoryInstance();
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
		powerDistributionUnitEClass = createEClass(POWER_DISTRIBUTION_UNIT);

		powerConsumingProvidingEntityEClass = createEClass(POWER_CONSUMING_PROVIDING_ENTITY);

		powerProvidingEntityEClass = createEClass(POWER_PROVIDING_ENTITY);
		createEReference(powerProvidingEntityEClass,
				POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES);
		createEAttribute(powerProvidingEntityEClass,
				POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER);
		createEReference(powerProvidingEntityEClass,
				POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL);
		createEReference(powerProvidingEntityEClass,
				POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT);

		powerConsumingEntityEClass = createEClass(POWER_CONSUMING_ENTITY);
		createEReference(powerConsumingEntityEClass,
				POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY);

		mountedPowerDistributionUnitEClass = createEClass(MOUNTED_POWER_DISTRIBUTION_UNIT);
		createEReference(mountedPowerDistributionUnitEClass,
				MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER);

		powerConsumingResourceEClass = createEClass(POWER_CONSUMING_RESOURCE);
		createEReference(powerConsumingResourceEClass,
				POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION);
		createEReference(powerConsumingResourceEClass,
				POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT);

		powerInfrastructureRepositoryEClass = createEClass(POWER_INFRASTRUCTURE_REPOSITORY);
		createEReference(powerInfrastructureRepositoryEClass,
				POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES);
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
		UtilPackage theUtilPackage = (UtilPackage) EPackage.Registry.INSTANCE
				.getEPackage(UtilPackage.eNS_URI);
		ExperimentDataPackage theExperimentDataPackage = (ExperimentDataPackage) EPackage.Registry.INSTANCE
				.getEPackage(ExperimentDataPackage.eNS_URI);
		BindingPackage theBindingPackage = (BindingPackage) EPackage.Registry.INSTANCE
				.getEPackage(BindingPackage.eNS_URI);
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage) EPackage.Registry.INSTANCE
				.getEPackage(ResourceenvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		powerDistributionUnitEClass.getESuperTypes().add(
				this.getPowerConsumingProvidingEntity());
		powerConsumingProvidingEntityEClass.getESuperTypes().add(
				this.getPowerConsumingEntity());
		powerConsumingProvidingEntityEClass.getESuperTypes().add(
				this.getPowerProvidingEntity());
		powerProvidingEntityEClass.getESuperTypes().add(
				theUtilPackage.getEntity());
		powerConsumingEntityEClass.getESuperTypes().add(
				theUtilPackage.getEntity());
		mountedPowerDistributionUnitEClass.getESuperTypes().add(
				this.getPowerDistributionUnit());
		powerConsumingResourceEClass.getESuperTypes().add(
				this.getPowerConsumingEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(powerDistributionUnitEClass, PowerDistributionUnit.class,
				"PowerDistributionUnit", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(powerConsumingProvidingEntityEClass,
				PowerConsumingProvidingEntity.class,
				"PowerConsumingProvidingEntity", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(powerProvidingEntityEClass, PowerProvidingEntity.class,
				"PowerProvidingEntity", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerProvidingEntity_NestedPowerConsumingEntities(),
				this.getPowerConsumingEntity(),
				this.getPowerConsumingEntity_PowerProvidingEntity(),
				"nestedPowerConsumingEntities", null, 0, -1,
				PowerProvidingEntity.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		EGenericType g1 = createEGenericType(theExperimentDataPackage
				.getEJSMeasure());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUtilPackage.getPower());
		g1.getETypeArguments().add(g2);
		initEAttribute(getPowerProvidingEntity_SuppliablePeakPower(), g1,
				"suppliablePeakPower", "", 1, 1, PowerProvidingEntity.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getPowerProvidingEntity_PowerInfrastructureModel(),
				this.getPowerInfrastructureRepository(),
				this.getPowerInfrastructureRepository_ContainedPowerProvidingEntities(),
				"powerInfrastructureModel", null, 0, 1,
				PowerProvidingEntity.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(
				getPowerProvidingEntity_DistributionPowerAssemblyContext(),
				theBindingPackage.getDistributionPowerBinding(), null,
				"distributionPowerAssemblyContext", null, 0, 1,
				PowerProvidingEntity.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerConsumingEntityEClass, PowerConsumingEntity.class,
				"PowerConsumingEntity", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerConsumingEntity_PowerProvidingEntity(),
				this.getPowerProvidingEntity(),
				this.getPowerProvidingEntity_NestedPowerConsumingEntities(),
				"powerProvidingEntity", null, 0, 1, PowerConsumingEntity.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);

		initEClass(mountedPowerDistributionUnitEClass,
				MountedPowerDistributionUnit.class,
				"MountedPowerDistributionUnit", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMountedPowerDistributionUnit_ResourceContainer(),
				theResourceenvironmentPackage.getResourceContainer(), null,
				"resourceContainer", null, 1, 1,
				MountedPowerDistributionUnit.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(powerConsumingResourceEClass, PowerConsumingResource.class,
				"PowerConsumingResource", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(
				getPowerConsumingResource_ProcessingResourceSpecification(),
				theResourceenvironmentPackage
						.getProcessingResourceSpecification(), null,
				"processingResourceSpecification", null, 1, 1,
				PowerConsumingResource.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getPowerConsumingResource_ResourcePowerAssemblyContext(),
				theBindingPackage.getResourcePowerBinding(), null,
				"resourcePowerAssemblyContext", null, 0, 1,
				PowerConsumingResource.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerInfrastructureRepositoryEClass,
				PowerInfrastructureRepository.class,
				"PowerInfrastructureRepository", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(
				getPowerInfrastructureRepository_ContainedPowerProvidingEntities(),
				this.getPowerProvidingEntity(),
				this.getPowerProvidingEntity_PowerInfrastructureModel(),
				"containedPowerProvidingEntities", null, 0, -1,
				PowerInfrastructureRepository.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // InfrastructurePackageImpl
