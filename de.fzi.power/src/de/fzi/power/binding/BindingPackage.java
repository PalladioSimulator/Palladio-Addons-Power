/**
 */
package de.fzi.power.binding;

import org.eclipse.emf.ecore.EAttribute;
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
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see de.fzi.power.binding.BindingFactory
 * @model kind="package"
 * @generated
 */
public interface BindingPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "binding";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://www.fzi.de/Power/Binding/1.0";

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
    BindingPackage eINSTANCE = de.fzi.power.binding.impl.BindingPackageImpl.init();

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.AbstractFixedFactorValueImpl
     * <em>Abstract Fixed Factor Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.AbstractFixedFactorValueImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getAbstractFixedFactorValue()
     * @generated
     */
    int ABSTRACT_FIXED_FACTOR_VALUE = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_FIXED_FACTOR_VALUE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Bound Factor</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_FIXED_FACTOR_VALUE__VALUE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Power Binding</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Abstract Fixed Factor Value</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_FIXED_FACTOR_VALUE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.FixedFactorValuePowerImpl
     * <em>Fixed Factor Value Power</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.FixedFactorValuePowerImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getFixedFactorValuePower()
     * @generated
     */
    int FIXED_FACTOR_VALUE_POWER = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_POWER__ID = ABSTRACT_FIXED_FACTOR_VALUE__ID;

    /**
     * The feature id for the '<em><b>Bound Factor</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_POWER__BOUND_FACTOR = ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_POWER__VALUE = ABSTRACT_FIXED_FACTOR_VALUE__VALUE;

    /**
     * The feature id for the '<em><b>Power Binding</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_POWER__POWER_BINDING = ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING;

    /**
     * The number of structural features of the '<em>Fixed Factor Value Power</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_POWER_FEATURE_COUNT = ABSTRACT_FIXED_FACTOR_VALUE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.PowerBindingRepositoryImpl
     * <em>Power Binding Repository</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.PowerBindingRepositoryImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerBindingRepository()
     * @generated
     */
    int POWER_BINDING_REPOSITORY = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_BINDING_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Power Bindings</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_BINDING_REPOSITORY__POWER_BINDINGS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Power Binding Repository</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_BINDING_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.PowerBindingImpl
     * <em>Power Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.PowerBindingImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerBinding()
     * @generated
     */
    int POWER_BINDING = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_BINDING__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_BINDING__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power Binding Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_BINDING__POWER_BINDING_REPOSITORY = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Power Binding</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_BINDING_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.PowerFactorBindingImpl
     * <em>Power Factor Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.PowerFactorBindingImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerFactorBinding()
     * @generated
     */
    int POWER_FACTOR_BINDING = 7;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_FACTOR_BINDING__ID = POWER_BINDING__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_FACTOR_BINDING__NAME = POWER_BINDING__NAME;

    /**
     * The feature id for the '<em><b>Power Binding Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_FACTOR_BINDING__POWER_BINDING_REPOSITORY = POWER_BINDING__POWER_BINDING_REPOSITORY;

    /**
     * The feature id for the '<em><b>Fixed Factor Values</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES = POWER_BINDING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Power Factor Binding</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_FACTOR_BINDING_FEATURE_COUNT = POWER_BINDING_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.ResourcePowerBindingImpl
     * <em>Resource Power Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.ResourcePowerBindingImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getResourcePowerBinding()
     * @generated
     */
    int RESOURCE_POWER_BINDING = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__ID = POWER_FACTOR_BINDING__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__NAME = POWER_FACTOR_BINDING__NAME;

    /**
     * The feature id for the '<em><b>Power Binding Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__POWER_BINDING_REPOSITORY = POWER_FACTOR_BINDING__POWER_BINDING_REPOSITORY;

    /**
     * The feature id for the '<em><b>Fixed Factor Values</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__FIXED_FACTOR_VALUES = POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES;

    /**
     * The feature id for the '<em><b>Resource Power Model Specification</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION = POWER_FACTOR_BINDING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Resource Power Binding</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING_FEATURE_COUNT = POWER_FACTOR_BINDING_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.DistributionPowerBindingImpl
     * <em>Distribution Power Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.DistributionPowerBindingImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getDistributionPowerBinding()
     * @generated
     */
    int DISTRIBUTION_POWER_BINDING = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__ID = POWER_FACTOR_BINDING__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__NAME = POWER_FACTOR_BINDING__NAME;

    /**
     * The feature id for the '<em><b>Power Binding Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__POWER_BINDING_REPOSITORY = POWER_FACTOR_BINDING__POWER_BINDING_REPOSITORY;

    /**
     * The feature id for the '<em><b>Fixed Factor Values</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__FIXED_FACTOR_VALUES = POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES;

    /**
     * The feature id for the '<em><b>Distribution Power Model</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL = POWER_FACTOR_BINDING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Distribution Power Binding</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING_FEATURE_COUNT = POWER_FACTOR_BINDING_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.AbstractPowerStateImpl
     * <em>Abstract Power State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.AbstractPowerStateImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getAbstractPowerState()
     * @generated
     */
    int ABSTRACT_POWER_STATE = 5;

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
     * The feature id for the '<em><b>Stateful Resource Power Binding</b></em>' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Abstract Power State</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ABSTRACT_POWER_STATE_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.PowerStateImpl
     * <em>Power State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.PowerStateImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerState()
     * @generated
     */
    int POWER_STATE = 12;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.StatefulResourcePowerBindingImpl
     * <em>Stateful Resource Power Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see de.fzi.power.binding.impl.StatefulResourcePowerBindingImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getStatefulResourcePowerBinding()
     * @generated
     */
    int STATEFUL_RESOURCE_POWER_BINDING = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int STATEFUL_RESOURCE_POWER_BINDING__ID = POWER_BINDING__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int STATEFUL_RESOURCE_POWER_BINDING__NAME = POWER_BINDING__NAME;

    /**
     * The feature id for the '<em><b>Power Binding Repository</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int STATEFUL_RESOURCE_POWER_BINDING__POWER_BINDING_REPOSITORY = POWER_BINDING__POWER_BINDING_REPOSITORY;

    /**
     * The feature id for the '<em><b>Power States</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES = POWER_BINDING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Stateful Resource Power Binding</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int STATEFUL_RESOURCE_POWER_BINDING_FEATURE_COUNT = POWER_BINDING_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link de.fzi.power.binding.impl.FixedFactorValueDimensionlessImpl
     * <em>Fixed Factor Value Dimensionless</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see de.fzi.power.binding.impl.FixedFactorValueDimensionlessImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getFixedFactorValueDimensionless()
     * @generated
     */
    int FIXED_FACTOR_VALUE_DIMENSIONLESS = 9;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_DIMENSIONLESS__ID = ABSTRACT_FIXED_FACTOR_VALUE__ID;

    /**
     * The feature id for the '<em><b>Bound Factor</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_DIMENSIONLESS__BOUND_FACTOR = ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_DIMENSIONLESS__VALUE = ABSTRACT_FIXED_FACTOR_VALUE__VALUE;

    /**
     * The feature id for the '<em><b>Power Binding</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_DIMENSIONLESS__POWER_BINDING = ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING;

    /**
     * The number of structural features of the '<em>Fixed Factor Value Dimensionless</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_DIMENSIONLESS_FEATURE_COUNT = ABSTRACT_FIXED_FACTOR_VALUE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.TransitionStateImpl
     * <em>Transition State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.TransitionStateImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getTransitionState()
     * @generated
     */
    int TRANSITION_STATE = 10;

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
     * The feature id for the '<em><b>Stateful Resource Power Binding</b></em>' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__STATEFUL_RESOURCE_POWER_BINDING = ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING;

    /**
     * The feature id for the '<em><b>Transition Consumption</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__TRANSITION_CONSUMPTION = ABSTRACT_POWER_STATE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Initial State</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__INITIAL_STATE = ABSTRACT_POWER_STATE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Target State</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE__TARGET_STATE = ABSTRACT_POWER_STATE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Transition State</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TRANSITION_STATE_FEATURE_COUNT = ABSTRACT_POWER_STATE_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.ConsumptionBehaviorImpl
     * <em>Consumption Behavior</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.fzi.power.binding.impl.ConsumptionBehaviorImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getConsumptionBehavior()
     * @generated
     */
    int CONSUMPTION_BEHAVIOR = 11;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_BEHAVIOR__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_BEHAVIOR__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power Curve</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_BEHAVIOR__POWER_CURVE = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Unit</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_BEHAVIOR__UNIT = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Consumption Behavior</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMPTION_BEHAVIOR_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 2;

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
     * The feature id for the '<em><b>Stateful Resource Power Binding</b></em>' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING = ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING;

    /**
     * The feature id for the '<em><b>Binding</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE__BINDING = ABSTRACT_POWER_STATE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Power State</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int POWER_STATE_FEATURE_COUNT = ABSTRACT_POWER_STATE_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.FixedFactorValuePower
     * <em>Fixed Factor Value Power</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Fixed Factor Value Power</em>'.
     * @see de.fzi.power.binding.FixedFactorValuePower
     * @generated
     */
    EClass getFixedFactorValuePower();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.PowerBindingRepository
     * <em>Power Binding Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power Binding Repository</em>'.
     * @see de.fzi.power.binding.PowerBindingRepository
     * @generated
     */
    EClass getPowerBindingRepository();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.power.binding.PowerBindingRepository#getPowerBindings <em>Power Bindings</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Power Bindings</em>'.
     * @see de.fzi.power.binding.PowerBindingRepository#getPowerBindings()
     * @see #getPowerBindingRepository()
     * @generated
     */
    EReference getPowerBindingRepository_PowerBindings();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.PowerBinding
     * <em>Power Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power Binding</em>'.
     * @see de.fzi.power.binding.PowerBinding
     * @generated
     */
    EClass getPowerBinding();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.power.binding.PowerBinding#getPowerBindingRepository
     * <em>Power Binding Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Power Binding Repository</em>'.
     * @see de.fzi.power.binding.PowerBinding#getPowerBindingRepository()
     * @see #getPowerBinding()
     * @generated
     */
    EReference getPowerBinding_PowerBindingRepository();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.ResourcePowerBinding
     * <em>Resource Power Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Resource Power Binding</em>'.
     * @see de.fzi.power.binding.ResourcePowerBinding
     * @generated
     */
    EClass getResourcePowerBinding();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.binding.ResourcePowerBinding#getResourcePowerModelSpecification
     * <em>Resource Power Model Specification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Resource Power Model Specification</em>'.
     * @see de.fzi.power.binding.ResourcePowerBinding#getResourcePowerModelSpecification()
     * @see #getResourcePowerBinding()
     * @generated
     */
    EReference getResourcePowerBinding_ResourcePowerModelSpecification();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.DistributionPowerBinding
     * <em>Distribution Power Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Distribution Power Binding</em>'.
     * @see de.fzi.power.binding.DistributionPowerBinding
     * @generated
     */
    EClass getDistributionPowerBinding();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.binding.DistributionPowerBinding#getDistributionPowerModel
     * <em>Distribution Power Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Distribution Power Model</em>'.
     * @see de.fzi.power.binding.DistributionPowerBinding#getDistributionPowerModel()
     * @see #getDistributionPowerBinding()
     * @generated
     */
    EReference getDistributionPowerBinding_DistributionPowerModel();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.AbstractPowerState
     * <em>Abstract Power State</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Abstract Power State</em>'.
     * @see de.fzi.power.binding.AbstractPowerState
     * @generated
     */
    EClass getAbstractPowerState();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.power.binding.AbstractPowerState#getStatefulResourcePowerBinding
     * <em>Stateful Resource Power Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Stateful Resource Power Binding</em>
     *         '.
     * @see de.fzi.power.binding.AbstractPowerState#getStatefulResourcePowerBinding()
     * @see #getAbstractPowerState()
     * @generated
     */
    EReference getAbstractPowerState_StatefulResourcePowerBinding();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.PowerState
     * <em>Power State</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power State</em>'.
     * @see de.fzi.power.binding.PowerState
     * @generated
     */
    EClass getPowerState();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.binding.PowerState#getBinding
     * <em>Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Binding</em>'.
     * @see de.fzi.power.binding.PowerState#getBinding()
     * @see #getPowerState()
     * @generated
     */
    EReference getPowerState_Binding();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.StatefulResourcePowerBinding
     * <em>Stateful Resource Power Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Stateful Resource Power Binding</em>'.
     * @see de.fzi.power.binding.StatefulResourcePowerBinding
     * @generated
     */
    EClass getStatefulResourcePowerBinding();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStates <em>Power States</em>
     * }'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Power States</em>'.
     * @see de.fzi.power.binding.StatefulResourcePowerBinding#getPowerStates()
     * @see #getStatefulResourcePowerBinding()
     * @generated
     */
    EReference getStatefulResourcePowerBinding_PowerStates();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.PowerFactorBinding
     * <em>Power Factor Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Power Factor Binding</em>'.
     * @see de.fzi.power.binding.PowerFactorBinding
     * @generated
     */
    EClass getPowerFactorBinding();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.fzi.power.binding.PowerFactorBinding#getFixedFactorValues
     * <em>Fixed Factor Values</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Fixed Factor Values</em>'.
     * @see de.fzi.power.binding.PowerFactorBinding#getFixedFactorValues()
     * @see #getPowerFactorBinding()
     * @generated
     */
    EReference getPowerFactorBinding_FixedFactorValues();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.AbstractFixedFactorValue
     * <em>Abstract Fixed Factor Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Abstract Fixed Factor Value</em>'.
     * @see de.fzi.power.binding.AbstractFixedFactorValue
     * @generated
     */
    EClass getAbstractFixedFactorValue();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.binding.AbstractFixedFactorValue#getBoundFactor <em>Bound Factor</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Bound Factor</em>'.
     * @see de.fzi.power.binding.AbstractFixedFactorValue#getBoundFactor()
     * @see #getAbstractFixedFactorValue()
     * @generated
     */
    EReference getAbstractFixedFactorValue_BoundFactor();

    /**
     * Returns the meta object for the attribute '
     * {@link de.fzi.power.binding.AbstractFixedFactorValue#getValue <em>Value</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.fzi.power.binding.AbstractFixedFactorValue#getValue()
     * @see #getAbstractFixedFactorValue()
     * @generated
     */
    EAttribute getAbstractFixedFactorValue_Value();

    /**
     * Returns the meta object for the container reference '
     * {@link de.fzi.power.binding.AbstractFixedFactorValue#getPowerBinding <em>Power Binding</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Power Binding</em>'.
     * @see de.fzi.power.binding.AbstractFixedFactorValue#getPowerBinding()
     * @see #getAbstractFixedFactorValue()
     * @generated
     */
    EReference getAbstractFixedFactorValue_PowerBinding();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.FixedFactorValueDimensionless
     * <em>Fixed Factor Value Dimensionless</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Fixed Factor Value Dimensionless</em>'.
     * @see de.fzi.power.binding.FixedFactorValueDimensionless
     * @generated
     */
    EClass getFixedFactorValueDimensionless();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.TransitionState
     * <em>Transition State</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Transition State</em>'.
     * @see de.fzi.power.binding.TransitionState
     * @generated
     */
    EClass getTransitionState();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.fzi.power.binding.TransitionState#getTransitionConsumption
     * <em>Transition Consumption</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Transition Consumption</em>'.
     * @see de.fzi.power.binding.TransitionState#getTransitionConsumption()
     * @see #getTransitionState()
     * @generated
     */
    EReference getTransitionState_TransitionConsumption();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.binding.TransitionState#getInitialState <em>Initial State</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Initial State</em>'.
     * @see de.fzi.power.binding.TransitionState#getInitialState()
     * @see #getTransitionState()
     * @generated
     */
    EReference getTransitionState_InitialState();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.binding.TransitionState#getTargetState <em>Target State</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Target State</em>'.
     * @see de.fzi.power.binding.TransitionState#getTargetState()
     * @see #getTransitionState()
     * @generated
     */
    EReference getTransitionState_TargetState();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.ConsumptionBehavior
     * <em>Consumption Behavior</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Consumption Behavior</em>'.
     * @see de.fzi.power.binding.ConsumptionBehavior
     * @generated
     */
    EClass getConsumptionBehavior();

    /**
     * Returns the meta object for the reference '
     * {@link de.fzi.power.binding.ConsumptionBehavior#getPowerCurve <em>Power Curve</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Power Curve</em>'.
     * @see de.fzi.power.binding.ConsumptionBehavior#getPowerCurve()
     * @see #getConsumptionBehavior()
     * @generated
     */
    EReference getConsumptionBehavior_PowerCurve();

    /**
     * Returns the meta object for the attribute '
     * {@link de.fzi.power.binding.ConsumptionBehavior#getUnit <em>Unit</em>}'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Unit</em>'.
     * @see de.fzi.power.binding.ConsumptionBehavior#getUnit()
     * @see #getConsumptionBehavior()
     * @generated
     */
    EAttribute getConsumptionBehavior_Unit();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BindingFactory getBindingFactory();

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
         * The meta object literal for the '
         * {@link de.fzi.power.binding.impl.FixedFactorValuePowerImpl
         * <em>Fixed Factor Value Power</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.FixedFactorValuePowerImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getFixedFactorValuePower()
         * @generated
         */
        EClass FIXED_FACTOR_VALUE_POWER = eINSTANCE.getFixedFactorValuePower();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.binding.impl.PowerBindingRepositoryImpl
         * <em>Power Binding Repository</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.PowerBindingRepositoryImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerBindingRepository()
         * @generated
         */
        EClass POWER_BINDING_REPOSITORY = eINSTANCE.getPowerBindingRepository();

        /**
         * The meta object literal for the '<em><b>Power Bindings</b></em>' containment reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_BINDING_REPOSITORY__POWER_BINDINGS = eINSTANCE.getPowerBindingRepository_PowerBindings();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.PowerBindingImpl
         * <em>Power Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.PowerBindingImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerBinding()
         * @generated
         */
        EClass POWER_BINDING = eINSTANCE.getPowerBinding();

        /**
         * The meta object literal for the '<em><b>Power Binding Repository</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_BINDING__POWER_BINDING_REPOSITORY = eINSTANCE.getPowerBinding_PowerBindingRepository();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.binding.impl.ResourcePowerBindingImpl <em>Resource Power Binding</em>
         * }' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.ResourcePowerBindingImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getResourcePowerBinding()
         * @generated
         */
        EClass RESOURCE_POWER_BINDING = eINSTANCE.getResourcePowerBinding();

        /**
         * The meta object literal for the '<em><b>Resource Power Model Specification</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION = eINSTANCE
                .getResourcePowerBinding_ResourcePowerModelSpecification();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.binding.impl.DistributionPowerBindingImpl
         * <em>Distribution Power Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.fzi.power.binding.impl.DistributionPowerBindingImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getDistributionPowerBinding()
         * @generated
         */
        EClass DISTRIBUTION_POWER_BINDING = eINSTANCE.getDistributionPowerBinding();

        /**
         * The meta object literal for the '<em><b>Distribution Power Model</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL = eINSTANCE
                .getDistributionPowerBinding_DistributionPowerModel();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.AbstractPowerStateImpl
         * <em>Abstract Power State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.AbstractPowerStateImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getAbstractPowerState()
         * @generated
         */
        EClass ABSTRACT_POWER_STATE = eINSTANCE.getAbstractPowerState();

        /**
         * The meta object literal for the '<em><b>Stateful Resource Power Binding</b></em>'
         * container reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING = eINSTANCE
                .getAbstractPowerState_StatefulResourcePowerBinding();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.PowerStateImpl
         * <em>Power State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.PowerStateImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerState()
         * @generated
         */
        EClass POWER_STATE = eINSTANCE.getPowerState();

        /**
         * The meta object literal for the '<em><b>Binding</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_STATE__BINDING = eINSTANCE.getPowerState_Binding();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.binding.impl.StatefulResourcePowerBindingImpl
         * <em>Stateful Resource Power Binding</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.StatefulResourcePowerBindingImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getStatefulResourcePowerBinding()
         * @generated
         */
        EClass STATEFUL_RESOURCE_POWER_BINDING = eINSTANCE.getStatefulResourcePowerBinding();

        /**
         * The meta object literal for the '<em><b>Power States</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES = eINSTANCE
                .getStatefulResourcePowerBinding_PowerStates();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.PowerFactorBindingImpl
         * <em>Power Factor Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.PowerFactorBindingImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerFactorBinding()
         * @generated
         */
        EClass POWER_FACTOR_BINDING = eINSTANCE.getPowerFactorBinding();

        /**
         * The meta object literal for the '<em><b>Fixed Factor Values</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES = eINSTANCE.getPowerFactorBinding_FixedFactorValues();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.binding.impl.AbstractFixedFactorValueImpl
         * <em>Abstract Fixed Factor Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.fzi.power.binding.impl.AbstractFixedFactorValueImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getAbstractFixedFactorValue()
         * @generated
         */
        EClass ABSTRACT_FIXED_FACTOR_VALUE = eINSTANCE.getAbstractFixedFactorValue();

        /**
         * The meta object literal for the '<em><b>Bound Factor</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR = eINSTANCE.getAbstractFixedFactorValue_BoundFactor();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ABSTRACT_FIXED_FACTOR_VALUE__VALUE = eINSTANCE.getAbstractFixedFactorValue_Value();

        /**
         * The meta object literal for the '<em><b>Power Binding</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING = eINSTANCE.getAbstractFixedFactorValue_PowerBinding();

        /**
         * The meta object literal for the '
         * {@link de.fzi.power.binding.impl.FixedFactorValueDimensionlessImpl
         * <em>Fixed Factor Value Dimensionless</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.FixedFactorValueDimensionlessImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getFixedFactorValueDimensionless()
         * @generated
         */
        EClass FIXED_FACTOR_VALUE_DIMENSIONLESS = eINSTANCE.getFixedFactorValueDimensionless();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.TransitionStateImpl
         * <em>Transition State</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.TransitionStateImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getTransitionState()
         * @generated
         */
        EClass TRANSITION_STATE = eINSTANCE.getTransitionState();

        /**
         * The meta object literal for the '<em><b>Transition Consumption</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference TRANSITION_STATE__TRANSITION_CONSUMPTION = eINSTANCE.getTransitionState_TransitionConsumption();

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
         * The meta object literal for the '{@link de.fzi.power.binding.impl.ConsumptionBehaviorImpl
         * <em>Consumption Behavior</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.fzi.power.binding.impl.ConsumptionBehaviorImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getConsumptionBehavior()
         * @generated
         */
        EClass CONSUMPTION_BEHAVIOR = eINSTANCE.getConsumptionBehavior();

        /**
         * The meta object literal for the '<em><b>Power Curve</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CONSUMPTION_BEHAVIOR__POWER_CURVE = eINSTANCE.getConsumptionBehavior_PowerCurve();

        /**
         * The meta object literal for the '<em><b>Unit</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute CONSUMPTION_BEHAVIOR__UNIT = eINSTANCE.getConsumptionBehavior_Unit();

    }

} // BindingPackage
