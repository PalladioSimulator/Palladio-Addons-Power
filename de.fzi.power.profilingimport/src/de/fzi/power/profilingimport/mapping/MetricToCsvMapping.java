/**
 */
package de.fzi.power.profilingimport.mapping;

import de.uka.ipd.sdq.identifier.Identifier;

import org.palladiosimulator.metricspec.MetricSetDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric To Csv Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getCsvFileUri <em>Csv File Uri</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getMetric <em>Metric</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getRepository <em>Repository</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMetricToCsvMapping()
 * @model
 * @generated
 */
public interface MetricToCsvMapping extends Identifier {
    /**
     * Returns the value of the '<em><b>Csv File Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Csv File Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Csv File Uri</em>' attribute.
     * @see #setCsvFileUri(String)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMetricToCsvMapping_CsvFileUri()
     * @model required="true"
     * @generated
     */
    String getCsvFileUri();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getCsvFileUri <em>Csv File Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Csv File Uri</em>' attribute.
     * @see #getCsvFileUri()
     * @generated
     */
    void setCsvFileUri(String value);

    /**
     * Returns the value of the '<em><b>Metric</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Metric</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Metric</em>' reference.
     * @see #setMetric(MetricSetDescription)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMetricToCsvMapping_Metric()
     * @model required="true"
     * @generated
     */
    MetricSetDescription getMetric();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getMetric <em>Metric</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Metric</em>' reference.
     * @see #getMetric()
     * @generated
     */
    void setMetric(MetricSetDescription value);

    /**
     * Returns the value of the '<em><b>Repository</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fzi.power.profilingimport.mapping.MappingRepository#getMappings <em>Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Repository</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Repository</em>' container reference.
     * @see #setRepository(MappingRepository)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMetricToCsvMapping_Repository()
     * @see de.fzi.power.profilingimport.mapping.MappingRepository#getMappings
     * @model opposite="mappings" transient="false"
     * @generated
     */
    MappingRepository getRepository();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getRepository <em>Repository</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Repository</em>' container reference.
     * @see #getRepository()
     * @generated
     */
    void setRepository(MappingRepository value);

} // MetricToCsvMapping
