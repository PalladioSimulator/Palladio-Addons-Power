/**
 */
package de.fzi.power.profilingimport.mapping.impl;

import de.fzi.power.profilingimport.mapping.ConversionDivisor;
import de.fzi.power.profilingimport.mapping.MappingFactory;
import de.fzi.power.profilingimport.mapping.MappingPackage;
import de.fzi.power.profilingimport.mapping.MappingRepository;
import de.fzi.power.profilingimport.mapping.MarkerLog;
import de.fzi.power.profilingimport.mapping.MetricToCsvMapping;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;

import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;

import org.palladiosimulator.metricspec.MetricSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingPackageImpl extends EPackageImpl implements MappingPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingRepositoryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass metricToCsvMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass markerLogEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass conversionDivisorEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private MappingPackageImpl() {
        super(eNS_URI, MappingFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link MappingPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static MappingPackage init() {
        if (isInited) return (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

        // Obtain or create and register package
        MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MappingPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theMappingPackage.createPackageContents();

        // Initialize created meta-data
        theMappingPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMappingPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(MappingPackage.eNS_URI, theMappingPackage);
        return theMappingPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingRepository() {
        return mappingRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingRepository_Mappings() {
        return (EReference)mappingRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingRepository_MarkerLog() {
        return (EReference)mappingRepositoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMetricToCsvMapping() {
        return metricToCsvMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMetricToCsvMapping_CsvFileUri() {
        return (EAttribute)metricToCsvMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMetricToCsvMapping_Metric() {
        return (EReference)metricToCsvMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMetricToCsvMapping_Repository() {
        return (EReference)metricToCsvMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMetricToCsvMapping_ConversionDivisor() {
        return (EReference)metricToCsvMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMetricToCsvMapping_UnitString() {
        return (EAttribute)metricToCsvMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMetricToCsvMapping_Unit() {
        return (EAttribute)metricToCsvMappingEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMarkerLog() {
        return markerLogEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMarkerLog_CsvFileUri() {
        return (EAttribute)markerLogEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMarkerLog_Repository() {
        return (EReference)markerLogEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConversionDivisor() {
        return conversionDivisorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConversionDivisor_Value() {
        return (EAttribute)conversionDivisorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConversionDivisor_ValueString() {
        return (EAttribute)conversionDivisorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConversionDivisor_ResultingMetric() {
        return (EReference)conversionDivisorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappingFactory getMappingFactory() {
        return (MappingFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        mappingRepositoryEClass = createEClass(MAPPING_REPOSITORY);
        createEReference(mappingRepositoryEClass, MAPPING_REPOSITORY__MAPPINGS);
        createEReference(mappingRepositoryEClass, MAPPING_REPOSITORY__MARKER_LOG);

        metricToCsvMappingEClass = createEClass(METRIC_TO_CSV_MAPPING);
        createEAttribute(metricToCsvMappingEClass, METRIC_TO_CSV_MAPPING__CSV_FILE_URI);
        createEReference(metricToCsvMappingEClass, METRIC_TO_CSV_MAPPING__METRIC);
        createEReference(metricToCsvMappingEClass, METRIC_TO_CSV_MAPPING__REPOSITORY);
        createEReference(metricToCsvMappingEClass, METRIC_TO_CSV_MAPPING__CONVERSION_DIVISOR);
        createEAttribute(metricToCsvMappingEClass, METRIC_TO_CSV_MAPPING__UNIT_STRING);
        createEAttribute(metricToCsvMappingEClass, METRIC_TO_CSV_MAPPING__UNIT);

        markerLogEClass = createEClass(MARKER_LOG);
        createEAttribute(markerLogEClass, MARKER_LOG__CSV_FILE_URI);
        createEReference(markerLogEClass, MARKER_LOG__REPOSITORY);

        conversionDivisorEClass = createEClass(CONVERSION_DIVISOR);
        createEAttribute(conversionDivisorEClass, CONVERSION_DIVISOR__VALUE);
        createEAttribute(conversionDivisorEClass, CONVERSION_DIVISOR__VALUE_STRING);
        createEReference(conversionDivisorEClass, CONVERSION_DIVISOR__RESULTING_METRIC);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
        MetricSpecPackage theMetricSpecPackage = (MetricSpecPackage)EPackage.Registry.INSTANCE.getEPackage(MetricSpecPackage.eNS_URI);
        ExperimentDataPackage theExperimentDataPackage = (ExperimentDataPackage)EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        mappingRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        metricToCsvMappingEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        markerLogEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        conversionDivisorEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

        // Initialize classes and features; add operations and parameters
        initEClass(mappingRepositoryEClass, MappingRepository.class, "MappingRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMappingRepository_Mappings(), this.getMetricToCsvMapping(), this.getMetricToCsvMapping_Repository(), "mappings", null, 0, -1, MappingRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMappingRepository_MarkerLog(), this.getMarkerLog(), this.getMarkerLog_Repository(), "markerLog", null, 1, 1, MappingRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(metricToCsvMappingEClass, MetricToCsvMapping.class, "MetricToCsvMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMetricToCsvMapping_CsvFileUri(), ecorePackage.getEString(), "csvFileUri", null, 1, 1, MetricToCsvMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMetricToCsvMapping_Metric(), theMetricSpecPackage.getMetricSetDescription(), null, "metric", null, 1, 1, MetricToCsvMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMetricToCsvMapping_Repository(), this.getMappingRepository(), this.getMappingRepository_Mappings(), "repository", null, 0, 1, MetricToCsvMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMetricToCsvMapping_ConversionDivisor(), this.getConversionDivisor(), null, "conversionDivisor", null, 0, 1, MetricToCsvMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetricToCsvMapping_UnitString(), ecorePackage.getEString(), "unitString", null, 1, 1, MetricToCsvMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        EGenericType g1 = createEGenericType(theMetricSpecPackage.getEJSUnit());
        EGenericType g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        EGenericType g3 = createEGenericType(theMetricSpecPackage.getIJSQuantity());
        g2.setEUpperBound(g3);
        initEAttribute(getMetricToCsvMapping_Unit(), g1, "unit", null, 0, 1, MetricToCsvMapping.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(markerLogEClass, MarkerLog.class, "MarkerLog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMarkerLog_CsvFileUri(), ecorePackage.getEString(), "csvFileUri", null, 1, 1, MarkerLog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMarkerLog_Repository(), this.getMappingRepository(), this.getMappingRepository_MarkerLog(), "repository", null, 0, 1, MarkerLog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(conversionDivisorEClass, ConversionDivisor.class, "ConversionDivisor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        g1 = createEGenericType(theExperimentDataPackage.getEJSMeasure());
        g2 = createEGenericType(ecorePackage.getEDoubleObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMetricSpecPackage.getIJSQuantity());
        g1.getETypeArguments().add(g2);
        initEAttribute(getConversionDivisor_Value(), g1, "value", null, 1, 1, ConversionDivisor.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getConversionDivisor_ValueString(), ecorePackage.getEString(), "valueString", null, 1, 1, ConversionDivisor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConversionDivisor_ResultingMetric(), theMetricSpecPackage.getMetricSetDescription(), null, "resultingMetric", null, 1, 1, ConversionDivisor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //MappingPackageImpl
