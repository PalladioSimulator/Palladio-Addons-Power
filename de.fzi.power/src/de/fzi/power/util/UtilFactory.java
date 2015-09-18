/**
 */
package de.fzi.power.util;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.fzi.power.util.UtilPackage
 * @generated
 */
public interface UtilFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    UtilFactory eINSTANCE = de.fzi.power.util.impl.UtilFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Named Element</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Named Element</em>'.
     * @generated
     */
    NamedElement createNamedElement();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    UtilPackage getUtilPackage();

} // UtilFactory
