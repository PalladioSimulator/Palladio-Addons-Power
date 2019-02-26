/**
 */
package de.fzi.power.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
 * @see de.fzi.power.util.UtilFactory
 * @model kind="package"
 * @generated
 */
public interface UtilPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "util";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.fzi.de/Power/Util/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "de.fzi.power";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    UtilPackage eINSTANCE = de.fzi.power.util.impl.UtilPackageImpl.init();

    /**
     * The meta object id for the '{@link de.fzi.power.util.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see de.fzi.power.util.impl.EntityImpl
     * @see de.fzi.power.util.impl.UtilPackageImpl#getEntity()
     * @generated
     */
    int ENTITY = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Entity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.fzi.power.util.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see de.fzi.power.util.impl.NamedElementImpl
     * @see de.fzi.power.util.impl.UtilPackageImpl#getNamedElement()
     * @generated
     */
    int NAMED_ELEMENT = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT__NAME = 0;

    /**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '<em>Power</em>' data type.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see javax.measure.quantity.Power
     * @see de.fzi.power.util.impl.UtilPackageImpl#getPower()
     * @generated
     */
    int POWER = 2;

    /**
     * The meta object id for the '<em>Dimensionless</em>' data type.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see javax.measure.quantity.Dimensionless
     * @see de.fzi.power.util.impl.UtilPackageImpl#getDimensionless()
     * @generated
     */
    int DIMENSIONLESS = 3;

    /**
     * Returns the meta object for class '{@link de.fzi.power.util.Entity <em>Entity</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Entity</em>'.
     * @see de.fzi.power.util.Entity
     * @generated
     */
    EClass getEntity();

    /**
     * Returns the meta object for class '{@link de.fzi.power.util.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see de.fzi.power.util.NamedElement
     * @generated
     */
    EClass getNamedElement();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.util.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fzi.power.util.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
    EAttribute getNamedElement_Name();

    /**
     * Returns the meta object for data type '{@link javax.measure.quantity.Power <em>Power</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for data type '<em>Power</em>'.
     * @see javax.measure.quantity.Power
     * @model instanceClass="javax.measure.quantity.Power"
     * @generated
     */
    EDataType getPower();

    /**
     * Returns the meta object for data type '{@link javax.measure.quantity.Dimensionless <em>Dimensionless</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for data type '<em>Dimensionless</em>'.
     * @see javax.measure.quantity.Dimensionless
     * @model instanceClass="javax.measure.quantity.Dimensionless"
     * @generated
     */
    EDataType getDimensionless();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    UtilFactory getUtilFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link de.fzi.power.util.impl.EntityImpl <em>Entity</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see de.fzi.power.util.impl.EntityImpl
         * @see de.fzi.power.util.impl.UtilPackageImpl#getEntity()
         * @generated
         */
        EClass ENTITY = eINSTANCE.getEntity();

        /**
         * The meta object literal for the '{@link de.fzi.power.util.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see de.fzi.power.util.impl.NamedElementImpl
         * @see de.fzi.power.util.impl.UtilPackageImpl#getNamedElement()
         * @generated
         */
        EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

        /**
         * The meta object literal for the '<em>Power</em>' data type.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @see javax.measure.quantity.Power
         * @see de.fzi.power.util.impl.UtilPackageImpl#getPower()
         * @generated
         */
        EDataType POWER = eINSTANCE.getPower();

        /**
         * The meta object literal for the '<em>Dimensionless</em>' data type.
         * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * @see javax.measure.quantity.Dimensionless
         * @see de.fzi.power.util.impl.UtilPackageImpl#getDimensionless()
         * @generated
         */
        EDataType DIMENSIONLESS = eINSTANCE.getDimensionless();

    }

} // UtilPackage
