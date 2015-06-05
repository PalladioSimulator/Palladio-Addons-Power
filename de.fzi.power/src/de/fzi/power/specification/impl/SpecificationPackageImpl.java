/**
 */
package de.fzi.power.specification.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;
import org.palladiosimulator.metricspec.MetricSpecPackage;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.impl.BindingPackageImpl;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.impl.InfrastructurePackageImpl;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.DistributionPowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.util.UtilPackage;
import de.fzi.power.util.impl.UtilPackageImpl;
import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.PcmPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SpecificationPackageImpl extends EPackageImpl implements SpecificationPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass powerModelRepositoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass powerModelSpecificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass resourcePowerModelSpecificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass distributionPowerModelSpecificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass fixedFactorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass consumptionFactorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass measuredFactorEClass = null;

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
     * @see de.fzi.power.specification.SpecificationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SpecificationPackageImpl() {
        super(eNS_URI, SpecificationFactory.eINSTANCE);
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
     * This method is used to initialize {@link SpecificationPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SpecificationPackage init() {
        if (isInited) {
            return (SpecificationPackage) EPackage.Registry.INSTANCE.getEPackage(SpecificationPackage.eNS_URI);
        }

        // Obtain or create and register package
        final SpecificationPackageImpl theSpecificationPackage = (SpecificationPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof SpecificationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new SpecificationPackageImpl());

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
        final BindingPackageImpl theBindingPackage = (BindingPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
        final InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(InfrastructurePackage.eNS_URI) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(InfrastructurePackage.eNS_URI)
                : InfrastructurePackage.eINSTANCE);

        // Create package meta-data objects
        theSpecificationPackage.createPackageContents();
        theUtilPackage.createPackageContents();
        theBindingPackage.createPackageContents();
        theInfrastructurePackage.createPackageContents();

        // Initialize created meta-data
        theSpecificationPackage.initializePackageContents();
        theUtilPackage.initializePackageContents();
        theBindingPackage.initializePackageContents();
        theInfrastructurePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSpecificationPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SpecificationPackage.eNS_URI, theSpecificationPackage);
        return theSpecificationPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPowerModelRepository() {
        return this.powerModelRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getPowerModelRepository_PowerModelSpecifications() {
        return (EReference) this.powerModelRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPowerModelSpecification() {
        return this.powerModelSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getPowerModelSpecification_Powermodelrepository() {
        return (EReference) this.powerModelSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getPowerModelSpecification_ConsumptionFactors() {
        return (EReference) this.powerModelSpecificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getResourcePowerModelSpecification() {
        return this.resourcePowerModelSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDistributionPowerModelSpecification() {
        return this.distributionPowerModelSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFixedFactor() {
        return this.fixedFactorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConsumptionFactor() {
        return this.consumptionFactorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumptionFactor_PowerModel() {
        return (EReference) this.consumptionFactorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMeasuredFactor() {
        return this.measuredFactorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMeasuredFactor_MetricType() {
        return (EReference) this.measuredFactorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SpecificationFactory getSpecificationFactory() {
        return (SpecificationFactory) this.getEFactoryInstance();
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
        this.powerModelRepositoryEClass = this.createEClass(POWER_MODEL_REPOSITORY);
        this.createEReference(this.powerModelRepositoryEClass, POWER_MODEL_REPOSITORY__POWER_MODEL_SPECIFICATIONS);

        this.powerModelSpecificationEClass = this.createEClass(POWER_MODEL_SPECIFICATION);
        this.createEReference(this.powerModelSpecificationEClass, POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY);
        this.createEReference(this.powerModelSpecificationEClass, POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS);

        this.resourcePowerModelSpecificationEClass = this.createEClass(RESOURCE_POWER_MODEL_SPECIFICATION);

        this.distributionPowerModelSpecificationEClass = this.createEClass(DISTRIBUTION_POWER_MODEL_SPECIFICATION);

        this.fixedFactorEClass = this.createEClass(FIXED_FACTOR);

        this.consumptionFactorEClass = this.createEClass(CONSUMPTION_FACTOR);
        this.createEReference(this.consumptionFactorEClass, CONSUMPTION_FACTOR__POWER_MODEL);

        this.measuredFactorEClass = this.createEClass(MEASURED_FACTOR);
        this.createEReference(this.measuredFactorEClass, MEASURED_FACTOR__METRIC_TYPE);
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
        final UtilPackage theUtilPackage = (UtilPackage) EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);
        final MetricSpecPackage theMetricSpecPackage = (MetricSpecPackage) EPackage.Registry.INSTANCE
                .getEPackage(MetricSpecPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.powerModelRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.powerModelSpecificationEClass.getESuperTypes().add(theUtilPackage.getEntity());
        this.resourcePowerModelSpecificationEClass.getESuperTypes().add(this.getPowerModelSpecification());
        this.distributionPowerModelSpecificationEClass.getESuperTypes().add(this.getPowerModelSpecification());
        this.fixedFactorEClass.getESuperTypes().add(this.getConsumptionFactor());
        this.consumptionFactorEClass.getESuperTypes().add(theUtilPackage.getEntity());
        this.measuredFactorEClass.getESuperTypes().add(this.getConsumptionFactor());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.powerModelRepositoryEClass, PowerModelRepository.class, "PowerModelRepository",
                !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPowerModelRepository_PowerModelSpecifications(), this.getPowerModelSpecification(),
                this.getPowerModelSpecification_Powermodelrepository(), "powerModelSpecifications", null, 0, -1,
                PowerModelRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.powerModelSpecificationEClass, PowerModelSpecification.class, "PowerModelSpecification",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPowerModelSpecification_Powermodelrepository(), this.getPowerModelRepository(),
                this.getPowerModelRepository_PowerModelSpecifications(), "powermodelrepository", null, 0, 1,
                PowerModelSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getPowerModelSpecification_ConsumptionFactors(), this.getConsumptionFactor(),
                this.getConsumptionFactor_PowerModel(), "consumptionFactors", null, 0, -1,
                PowerModelSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.resourcePowerModelSpecificationEClass, ResourcePowerModelSpecification.class,
                "ResourcePowerModelSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.distributionPowerModelSpecificationEClass, DistributionPowerModelSpecification.class,
                "DistributionPowerModelSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.fixedFactorEClass, FixedFactor.class, "FixedFactor", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.consumptionFactorEClass, ConsumptionFactor.class, "ConsumptionFactor", IS_ABSTRACT,
                !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getConsumptionFactor_PowerModel(), this.getPowerModelSpecification(),
                this.getPowerModelSpecification_ConsumptionFactors(), "powerModel", null, 0, 1,
                ConsumptionFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.measuredFactorEClass, MeasuredFactor.class, "MeasuredFactor", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getMeasuredFactor_MetricType(),
                theMetricSpecPackage.getNumericalBaseMetricDescription(), null,
                "metricType", null, 1, 1, MeasuredFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // SpecificationPackageImpl
