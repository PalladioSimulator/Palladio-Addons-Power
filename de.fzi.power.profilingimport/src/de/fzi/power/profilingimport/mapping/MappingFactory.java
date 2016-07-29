/**
 */
package de.fzi.power.profilingimport.mapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.power.profilingimport.mapping.MappingPackage
 * @generated
 */
public interface MappingFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MappingFactory eINSTANCE = de.fzi.power.profilingimport.mapping.impl.MappingFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Repository</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Repository</em>'.
     * @generated
     */
    MappingRepository createMappingRepository();

    /**
     * Returns a new object of class '<em>Metric To Csv Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Metric To Csv Mapping</em>'.
     * @generated
     */
    MetricToCsvMapping createMetricToCsvMapping();

    /**
     * Returns a new object of class '<em>Marker Log</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Marker Log</em>'.
     * @generated
     */
    MarkerLog createMarkerLog();

    /**
     * Returns a new object of class '<em>Conversion Divisor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Conversion Divisor</em>'.
     * @generated
     */
    ConversionDivisor createConversionDivisor();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    MappingPackage getMappingPackage();

} //MappingFactory
