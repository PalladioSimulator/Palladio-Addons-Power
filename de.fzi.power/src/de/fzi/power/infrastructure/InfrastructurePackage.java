/**
 */
package de.fzi.power.infrastructure;

import de.fzi.power.util.UtilPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fzi.power.infrastructure.InfrastructureFactory
 * @model kind="package"
 * @generated
 */
public interface InfrastructurePackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "infrastructure";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.fzi.de/Power/Infrastructure/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "de.fzi.power";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    InfrastructurePackage eINSTANCE = de.fzi.power.infrastructure.impl.InfrastructurePackageImpl.init();

    /**
     * The meta object id for the '{@link de.fzi.power.infrastructure.impl.PowerConsumingEntityImpl <em>Power Consuming Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.infrastructure.impl.PowerConsumingEntityImpl
     * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerConsumingEntity()
     * @generated
     */
    int POWER_CONSUMING_ENTITY = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_ENTITY__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_ENTITY__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power Providing Entity</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Power Consuming Entity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_ENTITY_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Power Consuming Entity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_ENTITY_OPERATION_COUNT = UtilPackage.ENTITY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl <em>Power Consuming Providing Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl
     * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerConsumingProvidingEntity()
     * @generated
     */
    int POWER_CONSUMING_PROVIDING_ENTITY = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY__ID = POWER_CONSUMING_ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY__NAME = POWER_CONSUMING_ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power Providing Entity</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY__POWER_PROVIDING_ENTITY = POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY;

    /**
     * The feature id for the '<em><b>Nested Power Consuming Entities</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES = POWER_CONSUMING_ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Suppliable Peak Power</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER = POWER_CONSUMING_ENTITY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Power Infrastructure Model</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL = POWER_CONSUMING_ENTITY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Distribution Power Assembly Context</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT = POWER_CONSUMING_ENTITY_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Power Consuming Providing Entity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY_FEATURE_COUNT = POWER_CONSUMING_ENTITY_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Power Consuming Providing Entity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_PROVIDING_ENTITY_OPERATION_COUNT = POWER_CONSUMING_ENTITY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.infrastructure.impl.PowerDistributionUnitImpl <em>Power Distribution Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.infrastructure.impl.PowerDistributionUnitImpl
     * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerDistributionUnit()
     * @generated
     */
    int POWER_DISTRIBUTION_UNIT = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT__ID = POWER_CONSUMING_PROVIDING_ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT__NAME = POWER_CONSUMING_PROVIDING_ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power Providing Entity</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT__POWER_PROVIDING_ENTITY = POWER_CONSUMING_PROVIDING_ENTITY__POWER_PROVIDING_ENTITY;

    /**
     * The feature id for the '<em><b>Nested Power Consuming Entities</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT__NESTED_POWER_CONSUMING_ENTITIES = POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES;

    /**
     * The feature id for the '<em><b>Suppliable Peak Power</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT__SUPPLIABLE_PEAK_POWER = POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER;

    /**
     * The feature id for the '<em><b>Power Infrastructure Model</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT__POWER_INFRASTRUCTURE_MODEL = POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL;

    /**
     * The feature id for the '<em><b>Distribution Power Assembly Context</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT = POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT;

    /**
     * The number of structural features of the '<em>Power Distribution Unit</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT_FEATURE_COUNT = POWER_CONSUMING_PROVIDING_ENTITY_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Power Distribution Unit</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_DISTRIBUTION_UNIT_OPERATION_COUNT = POWER_CONSUMING_PROVIDING_ENTITY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.infrastructure.impl.PowerProvidingEntityImpl <em>Power Providing Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.infrastructure.impl.PowerProvidingEntityImpl
     * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerProvidingEntity()
     * @generated
     */
    int POWER_PROVIDING_ENTITY = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_PROVIDING_ENTITY__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_PROVIDING_ENTITY__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Nested Power Consuming Entities</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Suppliable Peak Power</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Power Infrastructure Model</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL = UtilPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Distribution Power Assembly Context</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT = UtilPackage.ENTITY_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Power Providing Entity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_PROVIDING_ENTITY_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Power Providing Entity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_PROVIDING_ENTITY_OPERATION_COUNT = UtilPackage.ENTITY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.infrastructure.impl.MountedPowerDistributionUnitImpl <em>Mounted Power Distribution Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.infrastructure.impl.MountedPowerDistributionUnitImpl
     * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getMountedPowerDistributionUnit()
     * @generated
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT__ID = POWER_DISTRIBUTION_UNIT__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT__NAME = POWER_DISTRIBUTION_UNIT__NAME;

    /**
     * The feature id for the '<em><b>Power Providing Entity</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT__POWER_PROVIDING_ENTITY = POWER_DISTRIBUTION_UNIT__POWER_PROVIDING_ENTITY;

    /**
     * The feature id for the '<em><b>Nested Power Consuming Entities</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT__NESTED_POWER_CONSUMING_ENTITIES = POWER_DISTRIBUTION_UNIT__NESTED_POWER_CONSUMING_ENTITIES;

    /**
     * The feature id for the '<em><b>Suppliable Peak Power</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT__SUPPLIABLE_PEAK_POWER = POWER_DISTRIBUTION_UNIT__SUPPLIABLE_PEAK_POWER;

    /**
     * The feature id for the '<em><b>Power Infrastructure Model</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT__POWER_INFRASTRUCTURE_MODEL = POWER_DISTRIBUTION_UNIT__POWER_INFRASTRUCTURE_MODEL;

    /**
     * The feature id for the '<em><b>Distribution Power Assembly Context</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT = POWER_DISTRIBUTION_UNIT__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT;

    /**
     * The feature id for the '<em><b>Resource Container</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER = POWER_DISTRIBUTION_UNIT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Mounted Power Distribution Unit</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT_FEATURE_COUNT = POWER_DISTRIBUTION_UNIT_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Mounted Power Distribution Unit</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUNTED_POWER_DISTRIBUTION_UNIT_OPERATION_COUNT = POWER_DISTRIBUTION_UNIT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl <em>Power Consuming Resource</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl
     * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerConsumingResource()
     * @generated
     */
    int POWER_CONSUMING_RESOURCE = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_RESOURCE__ID = POWER_CONSUMING_ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_RESOURCE__NAME = POWER_CONSUMING_ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power Providing Entity</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_RESOURCE__POWER_PROVIDING_ENTITY = POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY;

    /**
     * The feature id for the '<em><b>Processing Resource Specification</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION = POWER_CONSUMING_ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Resource Power Assembly Context</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT = POWER_CONSUMING_ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Power Consuming Resource</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_RESOURCE_FEATURE_COUNT = POWER_CONSUMING_ENTITY_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Power Consuming Resource</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_CONSUMING_RESOURCE_OPERATION_COUNT = POWER_CONSUMING_ENTITY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.infrastructure.impl.PowerInfrastructureRepositoryImpl <em>Power Infrastructure Repository</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.infrastructure.impl.PowerInfrastructureRepositoryImpl
     * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerInfrastructureRepository()
     * @generated
     */
    int POWER_INFRASTRUCTURE_REPOSITORY = 6;

    /**
     * The feature id for the '<em><b>Contained Power Providing Entities</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES = 0;

    /**
     * The number of structural features of the '<em>Power Infrastructure Repository</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_INFRASTRUCTURE_REPOSITORY_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Power Infrastructure Repository</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_INFRASTRUCTURE_REPOSITORY_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link de.fzi.power.infrastructure.PowerDistributionUnit <em>Power Distribution Unit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Power Distribution Unit</em>'.
     * @see de.fzi.power.infrastructure.PowerDistributionUnit
     * @generated
     */
    EClass getPowerDistributionUnit();

    /**
     * Returns the meta object for class '{@link de.fzi.power.infrastructure.PowerConsumingProvidingEntity <em>Power Consuming Providing Entity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Power Consuming Providing Entity</em>'.
     * @see de.fzi.power.infrastructure.PowerConsumingProvidingEntity
     * @generated
     */
    EClass getPowerConsumingProvidingEntity();

    /**
     * Returns the meta object for class '{@link de.fzi.power.infrastructure.PowerProvidingEntity <em>Power Providing Entity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Power Providing Entity</em>'.
     * @see de.fzi.power.infrastructure.PowerProvidingEntity
     * @generated
     */
    EClass getPowerProvidingEntity();

    /**
     * Returns the meta object for the containment reference list '{@link de.fzi.power.infrastructure.PowerProvidingEntity#getNestedPowerConsumingEntities <em>Nested Power Consuming Entities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Nested Power Consuming Entities</em>'.
     * @see de.fzi.power.infrastructure.PowerProvidingEntity#getNestedPowerConsumingEntities()
     * @see #getPowerProvidingEntity()
     * @generated
     */
    EReference getPowerProvidingEntity_NestedPowerConsumingEntities();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.infrastructure.PowerProvidingEntity#getSuppliablePeakPower <em>Suppliable Peak Power</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Suppliable Peak Power</em>'.
     * @see de.fzi.power.infrastructure.PowerProvidingEntity#getSuppliablePeakPower()
     * @see #getPowerProvidingEntity()
     * @generated
     */
    EAttribute getPowerProvidingEntity_SuppliablePeakPower();

    /**
     * Returns the meta object for the container reference '{@link de.fzi.power.infrastructure.PowerProvidingEntity#getPowerInfrastructureModel <em>Power Infrastructure Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Power Infrastructure Model</em>'.
     * @see de.fzi.power.infrastructure.PowerProvidingEntity#getPowerInfrastructureModel()
     * @see #getPowerProvidingEntity()
     * @generated
     */
    EReference getPowerProvidingEntity_PowerInfrastructureModel();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.infrastructure.PowerProvidingEntity#getDistributionPowerAssemblyContext <em>Distribution Power Assembly Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Distribution Power Assembly Context</em>'.
     * @see de.fzi.power.infrastructure.PowerProvidingEntity#getDistributionPowerAssemblyContext()
     * @see #getPowerProvidingEntity()
     * @generated
     */
    EReference getPowerProvidingEntity_DistributionPowerAssemblyContext();

    /**
     * Returns the meta object for class '{@link de.fzi.power.infrastructure.PowerConsumingEntity <em>Power Consuming Entity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Power Consuming Entity</em>'.
     * @see de.fzi.power.infrastructure.PowerConsumingEntity
     * @generated
     */
    EClass getPowerConsumingEntity();

    /**
     * Returns the meta object for the container reference '{@link de.fzi.power.infrastructure.PowerConsumingEntity#getPowerProvidingEntity <em>Power Providing Entity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Power Providing Entity</em>'.
     * @see de.fzi.power.infrastructure.PowerConsumingEntity#getPowerProvidingEntity()
     * @see #getPowerConsumingEntity()
     * @generated
     */
    EReference getPowerConsumingEntity_PowerProvidingEntity();

    /**
     * Returns the meta object for class '{@link de.fzi.power.infrastructure.MountedPowerDistributionUnit <em>Mounted Power Distribution Unit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mounted Power Distribution Unit</em>'.
     * @see de.fzi.power.infrastructure.MountedPowerDistributionUnit
     * @generated
     */
    EClass getMountedPowerDistributionUnit();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.infrastructure.MountedPowerDistributionUnit#getResourceContainer <em>Resource Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Resource Container</em>'.
     * @see de.fzi.power.infrastructure.MountedPowerDistributionUnit#getResourceContainer()
     * @see #getMountedPowerDistributionUnit()
     * @generated
     */
    EReference getMountedPowerDistributionUnit_ResourceContainer();

    /**
     * Returns the meta object for class '{@link de.fzi.power.infrastructure.PowerConsumingResource <em>Power Consuming Resource</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Power Consuming Resource</em>'.
     * @see de.fzi.power.infrastructure.PowerConsumingResource
     * @generated
     */
    EClass getPowerConsumingResource();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.infrastructure.PowerConsumingResource#getProcessingResourceSpecification <em>Processing Resource Specification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Processing Resource Specification</em>'.
     * @see de.fzi.power.infrastructure.PowerConsumingResource#getProcessingResourceSpecification()
     * @see #getPowerConsumingResource()
     * @generated
     */
    EReference getPowerConsumingResource_ProcessingResourceSpecification();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.infrastructure.PowerConsumingResource#getResourcePowerAssemblyContext <em>Resource Power Assembly Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Resource Power Assembly Context</em>'.
     * @see de.fzi.power.infrastructure.PowerConsumingResource#getResourcePowerAssemblyContext()
     * @see #getPowerConsumingResource()
     * @generated
     */
    EReference getPowerConsumingResource_ResourcePowerAssemblyContext();

    /**
     * Returns the meta object for class '{@link de.fzi.power.infrastructure.PowerInfrastructureRepository <em>Power Infrastructure Repository</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Power Infrastructure Repository</em>'.
     * @see de.fzi.power.infrastructure.PowerInfrastructureRepository
     * @generated
     */
    EClass getPowerInfrastructureRepository();

    /**
     * Returns the meta object for the containment reference list '{@link de.fzi.power.infrastructure.PowerInfrastructureRepository#getContainedPowerProvidingEntities <em>Contained Power Providing Entities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Contained Power Providing Entities</em>'.
     * @see de.fzi.power.infrastructure.PowerInfrastructureRepository#getContainedPowerProvidingEntities()
     * @see #getPowerInfrastructureRepository()
     * @generated
     */
    EReference getPowerInfrastructureRepository_ContainedPowerProvidingEntities();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    InfrastructureFactory getInfrastructureFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link de.fzi.power.infrastructure.impl.PowerDistributionUnitImpl <em>Power Distribution Unit</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.infrastructure.impl.PowerDistributionUnitImpl
         * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerDistributionUnit()
         * @generated
         */
        EClass POWER_DISTRIBUTION_UNIT = eINSTANCE.getPowerDistributionUnit();

        /**
         * The meta object literal for the '{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl <em>Power Consuming Providing Entity</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl
         * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerConsumingProvidingEntity()
         * @generated
         */
        EClass POWER_CONSUMING_PROVIDING_ENTITY = eINSTANCE.getPowerConsumingProvidingEntity();

        /**
         * The meta object literal for the '{@link de.fzi.power.infrastructure.impl.PowerProvidingEntityImpl <em>Power Providing Entity</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.infrastructure.impl.PowerProvidingEntityImpl
         * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerProvidingEntity()
         * @generated
         */
        EClass POWER_PROVIDING_ENTITY = eINSTANCE.getPowerProvidingEntity();

        /**
         * The meta object literal for the '<em><b>Nested Power Consuming Entities</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES = eINSTANCE
                .getPowerProvidingEntity_NestedPowerConsumingEntities();

        /**
         * The meta object literal for the '<em><b>Suppliable Peak Power</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER = eINSTANCE
                .getPowerProvidingEntity_SuppliablePeakPower();

        /**
         * The meta object literal for the '<em><b>Power Infrastructure Model</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL = eINSTANCE
                .getPowerProvidingEntity_PowerInfrastructureModel();

        /**
         * The meta object literal for the '<em><b>Distribution Power Assembly Context</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT = eINSTANCE
                .getPowerProvidingEntity_DistributionPowerAssemblyContext();

        /**
         * The meta object literal for the '{@link de.fzi.power.infrastructure.impl.PowerConsumingEntityImpl <em>Power Consuming Entity</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.infrastructure.impl.PowerConsumingEntityImpl
         * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerConsumingEntity()
         * @generated
         */
        EClass POWER_CONSUMING_ENTITY = eINSTANCE.getPowerConsumingEntity();

        /**
         * The meta object literal for the '<em><b>Power Providing Entity</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY = eINSTANCE
                .getPowerConsumingEntity_PowerProvidingEntity();

        /**
         * The meta object literal for the '{@link de.fzi.power.infrastructure.impl.MountedPowerDistributionUnitImpl <em>Mounted Power Distribution Unit</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.infrastructure.impl.MountedPowerDistributionUnitImpl
         * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getMountedPowerDistributionUnit()
         * @generated
         */
        EClass MOUNTED_POWER_DISTRIBUTION_UNIT = eINSTANCE.getMountedPowerDistributionUnit();

        /**
         * The meta object literal for the '<em><b>Resource Container</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MOUNTED_POWER_DISTRIBUTION_UNIT__RESOURCE_CONTAINER = eINSTANCE
                .getMountedPowerDistributionUnit_ResourceContainer();

        /**
         * The meta object literal for the '{@link de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl <em>Power Consuming Resource</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl
         * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerConsumingResource()
         * @generated
         */
        EClass POWER_CONSUMING_RESOURCE = eINSTANCE.getPowerConsumingResource();

        /**
         * The meta object literal for the '<em><b>Processing Resource Specification</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION = eINSTANCE
                .getPowerConsumingResource_ProcessingResourceSpecification();

        /**
         * The meta object literal for the '<em><b>Resource Power Assembly Context</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT = eINSTANCE
                .getPowerConsumingResource_ResourcePowerAssemblyContext();

        /**
         * The meta object literal for the '{@link de.fzi.power.infrastructure.impl.PowerInfrastructureRepositoryImpl <em>Power Infrastructure Repository</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.infrastructure.impl.PowerInfrastructureRepositoryImpl
         * @see de.fzi.power.infrastructure.impl.InfrastructurePackageImpl#getPowerInfrastructureRepository()
         * @generated
         */
        EClass POWER_INFRASTRUCTURE_REPOSITORY = eINSTANCE.getPowerInfrastructureRepository();

        /**
         * The meta object literal for the '<em><b>Contained Power Providing Entities</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES = eINSTANCE
                .getPowerInfrastructureRepository_ContainedPowerProvidingEntities();

    }

} //InfrastructurePackage
