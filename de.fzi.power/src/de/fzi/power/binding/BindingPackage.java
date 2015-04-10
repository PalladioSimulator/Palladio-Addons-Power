/**
 */
package de.fzi.power.binding;

import de.fzi.power.util.UtilPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

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
 * @see de.fzi.power.binding.BindingFactory
 * @model kind="package"
 * @generated
 */
public interface BindingPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "binding";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.fzi.de/Power/Binding/1.0";

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
    BindingPackage eINSTANCE = de.fzi.power.binding.impl.BindingPackageImpl.init();

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.FixedFactorValueImpl <em>Fixed Factor Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.binding.impl.FixedFactorValueImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getFixedFactorValue()
     * @generated
     */
    int FIXED_FACTOR_VALUE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Bound Factor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE__BOUND_FACTOR = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE__VALUE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Power Binding</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE__POWER_BINDING = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Fixed Factor Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Fixed Factor Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIXED_FACTOR_VALUE_OPERATION_COUNT = IdentifierPackage.IDENTIFIER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.PowerBindingRepositoryImpl <em>Power Binding Repository</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.binding.impl.PowerBindingRepositoryImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerBindingRepository()
     * @generated
     */
    int POWER_BINDING_REPOSITORY = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Power Bindings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING_REPOSITORY__POWER_BINDINGS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Power Binding Repository</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Power Binding Repository</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING_REPOSITORY_OPERATION_COUNT = IdentifierPackage.IDENTIFIER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.PowerBindingImpl <em>Power Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.binding.impl.PowerBindingImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerBinding()
     * @generated
     */
    int POWER_BINDING = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING__ID = UtilPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING__NAME = UtilPackage.ENTITY__NAME;

    /**
     * The feature id for the '<em><b>Power Binding Repository</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING__POWER_BINDING_REPOSITORY = UtilPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Fixed Factor Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING__FIXED_FACTOR_VALUES = UtilPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Power Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING_FEATURE_COUNT = UtilPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Power Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POWER_BINDING_OPERATION_COUNT = UtilPackage.ENTITY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.ResourcePowerBindingImpl <em>Resource Power Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.binding.impl.ResourcePowerBindingImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getResourcePowerBinding()
     * @generated
     */
    int RESOURCE_POWER_BINDING = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__ID = POWER_BINDING__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__NAME = POWER_BINDING__NAME;

    /**
     * The feature id for the '<em><b>Power Binding Repository</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__POWER_BINDING_REPOSITORY = POWER_BINDING__POWER_BINDING_REPOSITORY;

    /**
     * The feature id for the '<em><b>Fixed Factor Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__FIXED_FACTOR_VALUES = POWER_BINDING__FIXED_FACTOR_VALUES;

    /**
     * The feature id for the '<em><b>Resource Power Model Specification</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION = POWER_BINDING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Resource Power Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING_FEATURE_COUNT = POWER_BINDING_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Resource Power Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_POWER_BINDING_OPERATION_COUNT = POWER_BINDING_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fzi.power.binding.impl.DistributionPowerBindingImpl <em>Distribution Power Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.binding.impl.DistributionPowerBindingImpl
     * @see de.fzi.power.binding.impl.BindingPackageImpl#getDistributionPowerBinding()
     * @generated
     */
    int DISTRIBUTION_POWER_BINDING = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__ID = POWER_BINDING__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__NAME = POWER_BINDING__NAME;

    /**
     * The feature id for the '<em><b>Power Binding Repository</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__POWER_BINDING_REPOSITORY = POWER_BINDING__POWER_BINDING_REPOSITORY;

    /**
     * The feature id for the '<em><b>Fixed Factor Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__FIXED_FACTOR_VALUES = POWER_BINDING__FIXED_FACTOR_VALUES;

    /**
     * The feature id for the '<em><b>Distribution Power Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL = POWER_BINDING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Distribution Power Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING_FEATURE_COUNT = POWER_BINDING_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Distribution Power Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISTRIBUTION_POWER_BINDING_OPERATION_COUNT = POWER_BINDING_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.FixedFactorValue <em>Fixed Factor Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Fixed Factor Value</em>'.
     * @see de.fzi.power.binding.FixedFactorValue
     * @generated
     */
    EClass getFixedFactorValue();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.binding.FixedFactorValue#getBoundFactor <em>Bound Factor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Bound Factor</em>'.
     * @see de.fzi.power.binding.FixedFactorValue#getBoundFactor()
     * @see #getFixedFactorValue()
     * @generated
     */
    EReference getFixedFactorValue_BoundFactor();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.binding.FixedFactorValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.fzi.power.binding.FixedFactorValue#getValue()
     * @see #getFixedFactorValue()
     * @generated
     */
    EAttribute getFixedFactorValue_Value();

    /**
     * Returns the meta object for the container reference '{@link de.fzi.power.binding.FixedFactorValue#getPowerBinding <em>Power Binding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Power Binding</em>'.
     * @see de.fzi.power.binding.FixedFactorValue#getPowerBinding()
     * @see #getFixedFactorValue()
     * @generated
     */
    EReference getFixedFactorValue_PowerBinding();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.PowerBindingRepository <em>Power Binding Repository</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Power Binding Repository</em>'.
     * @see de.fzi.power.binding.PowerBindingRepository
     * @generated
     */
    EClass getPowerBindingRepository();

    /**
     * Returns the meta object for the containment reference list '{@link de.fzi.power.binding.PowerBindingRepository#getPowerBindings <em>Power Bindings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Power Bindings</em>'.
     * @see de.fzi.power.binding.PowerBindingRepository#getPowerBindings()
     * @see #getPowerBindingRepository()
     * @generated
     */
    EReference getPowerBindingRepository_PowerBindings();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.PowerBinding <em>Power Binding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Power Binding</em>'.
     * @see de.fzi.power.binding.PowerBinding
     * @generated
     */
    EClass getPowerBinding();

    /**
     * Returns the meta object for the container reference '{@link de.fzi.power.binding.PowerBinding#getPowerBindingRepository <em>Power Binding Repository</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Power Binding Repository</em>'.
     * @see de.fzi.power.binding.PowerBinding#getPowerBindingRepository()
     * @see #getPowerBinding()
     * @generated
     */
    EReference getPowerBinding_PowerBindingRepository();

    /**
     * Returns the meta object for the containment reference list '{@link de.fzi.power.binding.PowerBinding#getFixedFactorValues <em>Fixed Factor Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Fixed Factor Values</em>'.
     * @see de.fzi.power.binding.PowerBinding#getFixedFactorValues()
     * @see #getPowerBinding()
     * @generated
     */
    EReference getPowerBinding_FixedFactorValues();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.ResourcePowerBinding <em>Resource Power Binding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource Power Binding</em>'.
     * @see de.fzi.power.binding.ResourcePowerBinding
     * @generated
     */
    EClass getResourcePowerBinding();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.binding.ResourcePowerBinding#getResourcePowerModelSpecification <em>Resource Power Model Specification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Resource Power Model Specification</em>'.
     * @see de.fzi.power.binding.ResourcePowerBinding#getResourcePowerModelSpecification()
     * @see #getResourcePowerBinding()
     * @generated
     */
    EReference getResourcePowerBinding_ResourcePowerModelSpecification();

    /**
     * Returns the meta object for class '{@link de.fzi.power.binding.DistributionPowerBinding <em>Distribution Power Binding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Distribution Power Binding</em>'.
     * @see de.fzi.power.binding.DistributionPowerBinding
     * @generated
     */
    EClass getDistributionPowerBinding();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.binding.DistributionPowerBinding#getDistributionPowerModel <em>Distribution Power Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Distribution Power Model</em>'.
     * @see de.fzi.power.binding.DistributionPowerBinding#getDistributionPowerModel()
     * @see #getDistributionPowerBinding()
     * @generated
     */
    EReference getDistributionPowerBinding_DistributionPowerModel();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BindingFactory getBindingFactory();

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
         * The meta object literal for the '{@link de.fzi.power.binding.impl.FixedFactorValueImpl <em>Fixed Factor Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.binding.impl.FixedFactorValueImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getFixedFactorValue()
         * @generated
         */
        EClass FIXED_FACTOR_VALUE = eINSTANCE.getFixedFactorValue();

        /**
         * The meta object literal for the '<em><b>Bound Factor</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIXED_FACTOR_VALUE__BOUND_FACTOR = eINSTANCE.getFixedFactorValue_BoundFactor();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIXED_FACTOR_VALUE__VALUE = eINSTANCE.getFixedFactorValue_Value();

        /**
         * The meta object literal for the '<em><b>Power Binding</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIXED_FACTOR_VALUE__POWER_BINDING = eINSTANCE.getFixedFactorValue_PowerBinding();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.PowerBindingRepositoryImpl <em>Power Binding Repository</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.binding.impl.PowerBindingRepositoryImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerBindingRepository()
         * @generated
         */
        EClass POWER_BINDING_REPOSITORY = eINSTANCE.getPowerBindingRepository();

        /**
         * The meta object literal for the '<em><b>Power Bindings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_BINDING_REPOSITORY__POWER_BINDINGS = eINSTANCE.getPowerBindingRepository_PowerBindings();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.PowerBindingImpl <em>Power Binding</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.binding.impl.PowerBindingImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getPowerBinding()
         * @generated
         */
        EClass POWER_BINDING = eINSTANCE.getPowerBinding();

        /**
         * The meta object literal for the '<em><b>Power Binding Repository</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_BINDING__POWER_BINDING_REPOSITORY = eINSTANCE.getPowerBinding_PowerBindingRepository();

        /**
         * The meta object literal for the '<em><b>Fixed Factor Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POWER_BINDING__FIXED_FACTOR_VALUES = eINSTANCE.getPowerBinding_FixedFactorValues();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.ResourcePowerBindingImpl <em>Resource Power Binding</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.binding.impl.ResourcePowerBindingImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getResourcePowerBinding()
         * @generated
         */
        EClass RESOURCE_POWER_BINDING = eINSTANCE.getResourcePowerBinding();

        /**
         * The meta object literal for the '<em><b>Resource Power Model Specification</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_POWER_BINDING__RESOURCE_POWER_MODEL_SPECIFICATION = eINSTANCE
                .getResourcePowerBinding_ResourcePowerModelSpecification();

        /**
         * The meta object literal for the '{@link de.fzi.power.binding.impl.DistributionPowerBindingImpl <em>Distribution Power Binding</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.binding.impl.DistributionPowerBindingImpl
         * @see de.fzi.power.binding.impl.BindingPackageImpl#getDistributionPowerBinding()
         * @generated
         */
        EClass DISTRIBUTION_POWER_BINDING = eINSTANCE.getDistributionPowerBinding();

        /**
         * The meta object literal for the '<em><b>Distribution Power Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL = eINSTANCE
                .getDistributionPowerBinding_DistributionPowerModel();

    }

} //BindingPackage
