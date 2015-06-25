/**
 */
package de.fzi.power.specification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.fzi.power.util.UtilPackage;
import de.uka.ipd.sdq.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see de.fzi.power.specification.SpecificationFactory
 * @model kind="package"
 * @generated
 */
public interface SpecificationPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "specification";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://www.fzi.de/Power/Specification/1.0";

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
    SpecificationPackage eINSTANCE = de.fzi.power.specification.impl.SpecificationPackageImpl.init();

    /**
     * The meta object id for the '{@link de.fzi.power.specification.impl.PowerModelRepositoryImpl
     * <em>Power Model Repository</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.specification.impl.PowerModelRepositoryImpl
     * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getPowerModelRepository()
     * @generated
     */
    int POWER_MODEL_REPOSITORY = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_MODEL_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Power Model Specifications</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_MODEL_REPOSITORY__POWER_MODEL_SPECIFICATIONS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Power Model Repository</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_MODEL_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link de.fzi.power.specification.impl.PowerModelSpecificationImpl
     * <em>Power Model Specification</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.specification.impl.PowerModelSpecificationImpl
     * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getPowerModelSpecification()
     * @generated
     */
    int POWER_MODEL_SPECIFICATION = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_MODEL_SPECIFICATION__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_MODEL_SPECIFICATION__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Powermodelrepository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Consumption Factors</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Power Model Specification</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_MODEL_SPECIFICATION_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link de.fzi.power.specification.impl.ResourcePowerModelSpecificationImpl
     * <em>Resource Power Model Specification</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.fzi.power.specification.impl.ResourcePowerModelSpecificationImpl
     * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getResourcePowerModelSpecification()
     * @generated
     */
    int RESOURCE_POWER_MODEL_SPECIFICATION = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_MODEL_SPECIFICATION__ID = POWER_MODEL_SPECIFICATION__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_MODEL_SPECIFICATION__NAME = POWER_MODEL_SPECIFICATION__NAME;

    /**
     * The feature id for the '<em><b>Powermodelrepository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY = POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY;

    /**
     * The feature id for the '<em><b>Consumption Factors</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS = POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS;

    /**
     * The number of structural features of the '<em>Resource Power Model Specification</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_MODEL_SPECIFICATION_FEATURE_COUNT = POWER_MODEL_SPECIFICATION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link de.fzi.power.specification.impl.DistributionPowerModelSpecificationImpl
     * <em>Distribution Power Model Specification</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.fzi.power.specification.impl.DistributionPowerModelSpecificationImpl
     * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getDistributionPowerModelSpecification()
     * @generated
     */
    int DISTRIBUTION_POWER_MODEL_SPECIFICATION = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_MODEL_SPECIFICATION__ID = POWER_MODEL_SPECIFICATION__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_MODEL_SPECIFICATION__NAME = POWER_MODEL_SPECIFICATION__NAME;

    /**
     * The feature id for the '<em><b>Powermodelrepository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY = POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY;

    /**
     * The feature id for the '<em><b>Consumption Factors</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS = POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS;

    /**
     * The number of structural features of the '<em>Distribution Power Model Specification</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_MODEL_SPECIFICATION_FEATURE_COUNT = POWER_MODEL_SPECIFICATION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.specification.impl.ConsumptionFactorImpl
     * <em>Consumption Factor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.specification.impl.ConsumptionFactorImpl
     * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getConsumptionFactor()
     * @generated
     */
    int CONSUMPTION_FACTOR = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_FACTOR__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_FACTOR__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power Model</b></em>' container reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_FACTOR__POWER_MODEL = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Consumption Factor</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_FACTOR_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.specification.impl.FixedFactorImpl
     * <em>Fixed Factor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.specification.impl.FixedFactorImpl
     * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getFixedFactor()
     * @generated
     */
    int FIXED_FACTOR = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR__ID = CONSUMPTION_FACTOR__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR__NAME = CONSUMPTION_FACTOR__NAME;

    /**
     * The feature id for the '<em><b>Power Model</b></em>' container reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR__POWER_MODEL = CONSUMPTION_FACTOR__POWER_MODEL;

    /**
     * The number of structural features of the '<em>Fixed Factor</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_FEATURE_COUNT = CONSUMPTION_FACTOR_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.specification.impl.MeasuredFactorImpl
     * <em>Measured Factor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.specification.impl.MeasuredFactorImpl
     * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getMeasuredFactor()
     * @generated
     */
    int MEASURED_FACTOR = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MEASURED_FACTOR__ID = CONSUMPTION_FACTOR__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MEASURED_FACTOR__NAME = CONSUMPTION_FACTOR__NAME;

    /**
     * The feature id for the '<em><b>Power Model</b></em>' container reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MEASURED_FACTOR__POWER_MODEL = CONSUMPTION_FACTOR__POWER_MODEL;

    /**
     * The feature id for the '<em><b>Metric Type</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MEASURED_FACTOR__METRIC_TYPE = CONSUMPTION_FACTOR_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Measured Factor</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MEASURED_FACTOR_FEATURE_COUNT = CONSUMPTION_FACTOR_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link de.fzi.power.specification.PowerModelRepository
     * <em>Power Model Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power Model Repository</em>'.
     * @see de.fzi.power.specification.PowerModelRepository
     * @generated
     */
    EClass getPowerModelRepository();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.power.specification.PowerModelRepository#getPowerModelSpecifications
     * <em>Power Model Specifications</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '
     *         <em>Power Model Specifications</em>'.
     * @see de.fzi.power.specification.PowerModelRepository#getPowerModelSpecifications()
     * @see #getPowerModelRepository()
     * @generated
     */
    EReference getPowerModelRepository_PowerModelSpecifications();

    /**
     * Returns the meta object for class '{@link de.fzi.power.specification.PowerModelSpecification
     * <em>Power Model Specification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power Model Specification</em>'.
     * @see de.fzi.power.specification.PowerModelSpecification
     * @generated
     */
    EClass getPowerModelSpecification();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.power.specification.PowerModelSpecification#getPowermodelrepository
     * <em>Powermodelrepository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Powermodelrepository</em>'.
     * @see de.fzi.power.specification.PowerModelSpecification#getPowermodelrepository()
     * @see #getPowerModelSpecification()
     * @generated
     */
    EReference getPowerModelSpecification_Powermodelrepository();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.power.specification.PowerModelSpecification#getConsumptionFactors
     * <em>Consumption Factors</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Consumption Factors</em>'.
     * @see de.fzi.power.specification.PowerModelSpecification#getConsumptionFactors()
     * @see #getPowerModelSpecification()
     * @generated
     */
    EReference getPowerModelSpecification_ConsumptionFactors();

    /**
     * Returns the meta object for class '
     * {@link de.fzi.power.specification.ResourcePowerModelSpecification
     * <em>Resource Power Model Specification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Resource Power Model Specification</em>'.
     * @see de.fzi.power.specification.ResourcePowerModelSpecification
     * @generated
     */
    EClass getResourcePowerModelSpecification();

    /**
     * Returns the meta object for class '
     * {@link de.fzi.power.specification.DistributionPowerModelSpecification
     * <em>Distribution Power Model Specification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for class '<em>Distribution Power Model Specification</em>'.
     * @see de.fzi.power.specification.DistributionPowerModelSpecification
     * @generated
     */
    EClass getDistributionPowerModelSpecification();

    /**
     * Returns the meta object for class '{@link de.fzi.power.specification.FixedFactor
     * <em>Fixed Factor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Fixed Factor</em>'.
     * @see de.fzi.power.specification.FixedFactor
     * @generated
     */
    EClass getFixedFactor();

    /**
     * Returns the meta object for class '{@link de.fzi.power.specification.ConsumptionFactor
     * <em>Consumption Factor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Consumption Factor</em>'.
     * @see de.fzi.power.specification.ConsumptionFactor
     * @generated
     */
    EClass getConsumptionFactor();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.power.specification.ConsumptionFactor#getPowerModel <em>Power Model</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Power Model</em>'.
     * @see de.fzi.power.specification.ConsumptionFactor#getPowerModel()
     * @see #getConsumptionFactor()
     * @generated
     */
    EReference getConsumptionFactor_PowerModel();

    /**
     * Returns the meta object for class '{@link de.fzi.power.specification.MeasuredFactor
     * <em>Measured Factor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Measured Factor</em>'.
     * @see de.fzi.power.specification.MeasuredFactor
     * @generated
     */
    EClass getMeasuredFactor();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.specification.MeasuredFactor#getMetricType <em>Metric Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Metric Type</em>'.
     * @see de.fzi.power.specification.MeasuredFactor#getMetricType()
     * @see #getMeasuredFactor()
     * @generated
     */
    EReference getMeasuredFactor_MetricType();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SpecificationFactory getSpecificationFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each operation of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     *
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '
         * {@link de.fzi.power.specification.impl.PowerModelRepositoryImpl
         * <em>Power Model Repository</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.specification.impl.PowerModelRepositoryImpl
         * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getPowerModelRepository()
         * @generated
         */
        EClass POWER_MODEL_REPOSITORY = eINSTANCE.getPowerModelRepository();

        /**
         * The meta object literal for the '<em><b>Power Model Specifications</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_MODEL_REPOSITORY__POWER_MODEL_SPECIFICATIONS = eINSTANCE
                .getPowerModelRepository_PowerModelSpecifications();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.specification.impl.PowerModelSpecificationImpl
         * <em>Power Model Specification</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.specification.impl.PowerModelSpecificationImpl
         * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getPowerModelSpecification()
         * @generated
         */
        EClass POWER_MODEL_SPECIFICATION = eINSTANCE.getPowerModelSpecification();

        /**
         * The meta object literal for the '<em><b>Powermodelrepository</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_MODEL_SPECIFICATION__POWERMODELREPOSITORY = eINSTANCE
                .getPowerModelSpecification_Powermodelrepository();

        /**
         * The meta object literal for the '<em><b>Consumption Factors</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS = eINSTANCE
                .getPowerModelSpecification_ConsumptionFactors();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.specification.impl.ResourcePowerModelSpecificationImpl
         * <em>Resource Power Model Specification</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.fzi.power.specification.impl.ResourcePowerModelSpecificationImpl
         * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getResourcePowerModelSpecification()
         * @generated
         */
        EClass RESOURCE_POWER_MODEL_SPECIFICATION = eINSTANCE.getResourcePowerModelSpecification();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.specification.impl.DistributionPowerModelSpecificationImpl
         * <em>Distribution Power Model Specification</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.fzi.power.specification.impl.DistributionPowerModelSpecificationImpl
         * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getDistributionPowerModelSpecification()
         * @generated
         */
        EClass DISTRIBUTION_POWER_MODEL_SPECIFICATION = eINSTANCE.getDistributionPowerModelSpecification();

        /**
         * The meta object literal for the '{@link de.fzi.power.specification.impl.FixedFactorImpl
         * <em>Fixed Factor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.specification.impl.FixedFactorImpl
         * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getFixedFactor()
         * @generated
         */
        EClass FIXED_FACTOR = eINSTANCE.getFixedFactor();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.specification.impl.ConsumptionFactorImpl <em>Consumption Factor</em>}
         * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.specification.impl.ConsumptionFactorImpl
         * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getConsumptionFactor()
         * @generated
         */
        EClass CONSUMPTION_FACTOR = eINSTANCE.getConsumptionFactor();

        /**
         * The meta object literal for the '<em><b>Power Model</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CONSUMPTION_FACTOR__POWER_MODEL = eINSTANCE.getConsumptionFactor_PowerModel();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.specification.impl.MeasuredFactorImpl <em>Measured Factor</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.specification.impl.MeasuredFactorImpl
         * @see de.fzi.power.specification.impl.SpecificationPackageImpl#getMeasuredFactor()
         * @generated
         */
        EClass MEASURED_FACTOR = eINSTANCE.getMeasuredFactor();

        /**
         * The meta object literal for the '<em><b>Metric Type</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference MEASURED_FACTOR__METRIC_TYPE = eINSTANCE.getMeasuredFactor_MetricType();

    }

} // SpecificationPackage
