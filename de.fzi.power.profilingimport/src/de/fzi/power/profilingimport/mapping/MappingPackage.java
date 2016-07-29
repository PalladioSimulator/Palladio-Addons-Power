/**
 */
package de.fzi.power.profilingimport.mapping;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fzi.power.profilingimport.mapping.MappingFactory
 * @model kind="package"
 * @generated
 */
public interface MappingPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "mapping";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.fzi.de/ProfilingImport/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "de.fzi.power.profilingimport";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MappingPackage eINSTANCE = de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl.init();

    /**
     * The meta object id for the '{@link de.fzi.power.profilingimport.mapping.impl.MappingRepositoryImpl <em>Repository</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.profilingimport.mapping.impl.MappingRepositoryImpl
     * @see de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl#getMappingRepository()
     * @generated
     */
    int MAPPING_REPOSITORY = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_REPOSITORY__MAPPINGS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Marker Log</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_REPOSITORY__MARKER_LOG = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Repository</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.fzi.power.profilingimport.mapping.impl.MetricToCsvMappingImpl <em>Metric To Csv Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.profilingimport.mapping.impl.MetricToCsvMappingImpl
     * @see de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl#getMetricToCsvMapping()
     * @generated
     */
    int METRIC_TO_CSV_MAPPING = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METRIC_TO_CSV_MAPPING__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Csv File Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METRIC_TO_CSV_MAPPING__CSV_FILE_URI = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Metric</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METRIC_TO_CSV_MAPPING__METRIC = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Repository</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METRIC_TO_CSV_MAPPING__REPOSITORY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Conversion Divisor</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METRIC_TO_CSV_MAPPING__CONVERSION_DIVISOR = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Unit String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METRIC_TO_CSV_MAPPING__UNIT_STRING = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Unit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METRIC_TO_CSV_MAPPING__UNIT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Metric To Csv Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METRIC_TO_CSV_MAPPING_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link de.fzi.power.profilingimport.mapping.impl.MarkerLogImpl <em>Marker Log</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.profilingimport.mapping.impl.MarkerLogImpl
     * @see de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl#getMarkerLog()
     * @generated
     */
    int MARKER_LOG = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_LOG__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Csv File Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_LOG__CSV_FILE_URI = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Repository</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_LOG__REPOSITORY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Marker Log</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_LOG_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.fzi.power.profilingimport.mapping.impl.ConversionDivisorImpl <em>Conversion Divisor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fzi.power.profilingimport.mapping.impl.ConversionDivisorImpl
     * @see de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl#getConversionDivisor()
     * @generated
     */
    int CONVERSION_DIVISOR = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONVERSION_DIVISOR__ID = IdentifierPackage.IDENTIFIER__ID;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONVERSION_DIVISOR__VALUE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONVERSION_DIVISOR__VALUE_STRING = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Resulting Metric</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONVERSION_DIVISOR__RESULTING_METRIC = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Conversion Divisor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONVERSION_DIVISOR_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;


    /**
     * Returns the meta object for class '{@link de.fzi.power.profilingimport.mapping.MappingRepository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Repository</em>'.
     * @see de.fzi.power.profilingimport.mapping.MappingRepository
     * @generated
     */
    EClass getMappingRepository();

    /**
     * Returns the meta object for the containment reference list '{@link de.fzi.power.profilingimport.mapping.MappingRepository#getMappings <em>Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Mappings</em>'.
     * @see de.fzi.power.profilingimport.mapping.MappingRepository#getMappings()
     * @see #getMappingRepository()
     * @generated
     */
    EReference getMappingRepository_Mappings();

    /**
     * Returns the meta object for the containment reference '{@link de.fzi.power.profilingimport.mapping.MappingRepository#getMarkerLog <em>Marker Log</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Marker Log</em>'.
     * @see de.fzi.power.profilingimport.mapping.MappingRepository#getMarkerLog()
     * @see #getMappingRepository()
     * @generated
     */
    EReference getMappingRepository_MarkerLog();

    /**
     * Returns the meta object for class '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping <em>Metric To Csv Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Metric To Csv Mapping</em>'.
     * @see de.fzi.power.profilingimport.mapping.MetricToCsvMapping
     * @generated
     */
    EClass getMetricToCsvMapping();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getCsvFileUri <em>Csv File Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Csv File Uri</em>'.
     * @see de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getCsvFileUri()
     * @see #getMetricToCsvMapping()
     * @generated
     */
    EAttribute getMetricToCsvMapping_CsvFileUri();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getMetric <em>Metric</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Metric</em>'.
     * @see de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getMetric()
     * @see #getMetricToCsvMapping()
     * @generated
     */
    EReference getMetricToCsvMapping_Metric();

    /**
     * Returns the meta object for the container reference '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getRepository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Repository</em>'.
     * @see de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getRepository()
     * @see #getMetricToCsvMapping()
     * @generated
     */
    EReference getMetricToCsvMapping_Repository();

    /**
     * Returns the meta object for the containment reference '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getConversionDivisor <em>Conversion Divisor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Conversion Divisor</em>'.
     * @see de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getConversionDivisor()
     * @see #getMetricToCsvMapping()
     * @generated
     */
    EReference getMetricToCsvMapping_ConversionDivisor();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getUnitString <em>Unit String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unit String</em>'.
     * @see de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getUnitString()
     * @see #getMetricToCsvMapping()
     * @generated
     */
    EAttribute getMetricToCsvMapping_UnitString();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getUnit <em>Unit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unit</em>'.
     * @see de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getUnit()
     * @see #getMetricToCsvMapping()
     * @generated
     */
    EAttribute getMetricToCsvMapping_Unit();

    /**
     * Returns the meta object for class '{@link de.fzi.power.profilingimport.mapping.MarkerLog <em>Marker Log</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Marker Log</em>'.
     * @see de.fzi.power.profilingimport.mapping.MarkerLog
     * @generated
     */
    EClass getMarkerLog();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.profilingimport.mapping.MarkerLog#getCsvFileUri <em>Csv File Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Csv File Uri</em>'.
     * @see de.fzi.power.profilingimport.mapping.MarkerLog#getCsvFileUri()
     * @see #getMarkerLog()
     * @generated
     */
    EAttribute getMarkerLog_CsvFileUri();

    /**
     * Returns the meta object for the container reference '{@link de.fzi.power.profilingimport.mapping.MarkerLog#getRepository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Repository</em>'.
     * @see de.fzi.power.profilingimport.mapping.MarkerLog#getRepository()
     * @see #getMarkerLog()
     * @generated
     */
    EReference getMarkerLog_Repository();

    /**
     * Returns the meta object for class '{@link de.fzi.power.profilingimport.mapping.ConversionDivisor <em>Conversion Divisor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conversion Divisor</em>'.
     * @see de.fzi.power.profilingimport.mapping.ConversionDivisor
     * @generated
     */
    EClass getConversionDivisor();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.fzi.power.profilingimport.mapping.ConversionDivisor#getValue()
     * @see #getConversionDivisor()
     * @generated
     */
    EAttribute getConversionDivisor_Value();

    /**
     * Returns the meta object for the attribute '{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getValueString <em>Value String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value String</em>'.
     * @see de.fzi.power.profilingimport.mapping.ConversionDivisor#getValueString()
     * @see #getConversionDivisor()
     * @generated
     */
    EAttribute getConversionDivisor_ValueString();

    /**
     * Returns the meta object for the reference '{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getResultingMetric <em>Resulting Metric</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Resulting Metric</em>'.
     * @see de.fzi.power.profilingimport.mapping.ConversionDivisor#getResultingMetric()
     * @see #getConversionDivisor()
     * @generated
     */
    EReference getConversionDivisor_ResultingMetric();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    MappingFactory getMappingFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link de.fzi.power.profilingimport.mapping.impl.MappingRepositoryImpl <em>Repository</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.profilingimport.mapping.impl.MappingRepositoryImpl
         * @see de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl#getMappingRepository()
         * @generated
         */
        EClass MAPPING_REPOSITORY = eINSTANCE.getMappingRepository();

        /**
         * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_REPOSITORY__MAPPINGS = eINSTANCE.getMappingRepository_Mappings();

        /**
         * The meta object literal for the '<em><b>Marker Log</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_REPOSITORY__MARKER_LOG = eINSTANCE.getMappingRepository_MarkerLog();

        /**
         * The meta object literal for the '{@link de.fzi.power.profilingimport.mapping.impl.MetricToCsvMappingImpl <em>Metric To Csv Mapping</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.profilingimport.mapping.impl.MetricToCsvMappingImpl
         * @see de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl#getMetricToCsvMapping()
         * @generated
         */
        EClass METRIC_TO_CSV_MAPPING = eINSTANCE.getMetricToCsvMapping();

        /**
         * The meta object literal for the '<em><b>Csv File Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute METRIC_TO_CSV_MAPPING__CSV_FILE_URI = eINSTANCE.getMetricToCsvMapping_CsvFileUri();

        /**
         * The meta object literal for the '<em><b>Metric</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference METRIC_TO_CSV_MAPPING__METRIC = eINSTANCE.getMetricToCsvMapping_Metric();

        /**
         * The meta object literal for the '<em><b>Repository</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference METRIC_TO_CSV_MAPPING__REPOSITORY = eINSTANCE.getMetricToCsvMapping_Repository();

        /**
         * The meta object literal for the '<em><b>Conversion Divisor</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference METRIC_TO_CSV_MAPPING__CONVERSION_DIVISOR = eINSTANCE.getMetricToCsvMapping_ConversionDivisor();

        /**
         * The meta object literal for the '<em><b>Unit String</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute METRIC_TO_CSV_MAPPING__UNIT_STRING = eINSTANCE.getMetricToCsvMapping_UnitString();

        /**
         * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute METRIC_TO_CSV_MAPPING__UNIT = eINSTANCE.getMetricToCsvMapping_Unit();

        /**
         * The meta object literal for the '{@link de.fzi.power.profilingimport.mapping.impl.MarkerLogImpl <em>Marker Log</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.profilingimport.mapping.impl.MarkerLogImpl
         * @see de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl#getMarkerLog()
         * @generated
         */
        EClass MARKER_LOG = eINSTANCE.getMarkerLog();

        /**
         * The meta object literal for the '<em><b>Csv File Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MARKER_LOG__CSV_FILE_URI = eINSTANCE.getMarkerLog_CsvFileUri();

        /**
         * The meta object literal for the '<em><b>Repository</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MARKER_LOG__REPOSITORY = eINSTANCE.getMarkerLog_Repository();

        /**
         * The meta object literal for the '{@link de.fzi.power.profilingimport.mapping.impl.ConversionDivisorImpl <em>Conversion Divisor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fzi.power.profilingimport.mapping.impl.ConversionDivisorImpl
         * @see de.fzi.power.profilingimport.mapping.impl.MappingPackageImpl#getConversionDivisor()
         * @generated
         */
        EClass CONVERSION_DIVISOR = eINSTANCE.getConversionDivisor();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONVERSION_DIVISOR__VALUE = eINSTANCE.getConversionDivisor_Value();

        /**
         * The meta object literal for the '<em><b>Value String</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONVERSION_DIVISOR__VALUE_STRING = eINSTANCE.getConversionDivisor_ValueString();

        /**
         * The meta object literal for the '<em><b>Resulting Metric</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONVERSION_DIVISOR__RESULTING_METRIC = eINSTANCE.getConversionDivisor_ResultingMetric();

    }

} //MappingPackage
