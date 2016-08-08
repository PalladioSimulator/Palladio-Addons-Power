/**
 */
package de.fzi.power.profilingimport.mapping;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Marker Log</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MarkerLog#getCsvFileUri <em>Csv File Uri</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MarkerLog#getRepository <em>Repository</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MarkerLog#getStartSuffix <em>Start Suffix</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MarkerLog#getMeasurementSuffix <em>Measurement Suffix</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMarkerLog()
 * @model
 * @generated
 */
public interface MarkerLog extends Identifier {
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
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMarkerLog_CsvFileUri()
     * @model required="true"
     * @generated
     */
    String getCsvFileUri();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MarkerLog#getCsvFileUri <em>Csv File Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Csv File Uri</em>' attribute.
     * @see #getCsvFileUri()
     * @generated
     */
    void setCsvFileUri(String value);

    /**
     * Returns the value of the '<em><b>Repository</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fzi.power.profilingimport.mapping.MappingRepository#getMarkerLog <em>Marker Log</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Repository</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Repository</em>' container reference.
     * @see #setRepository(MappingRepository)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMarkerLog_Repository()
     * @see de.fzi.power.profilingimport.mapping.MappingRepository#getMarkerLog
     * @model opposite="markerLog" transient="false"
     * @generated
     */
    MappingRepository getRepository();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MarkerLog#getRepository <em>Repository</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Repository</em>' container reference.
     * @see #getRepository()
     * @generated
     */
    void setRepository(MappingRepository value);

    /**
     * Returns the value of the '<em><b>Start Suffix</b></em>' attribute.
     * The default value is <code>"started"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Suffix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start Suffix</em>' attribute.
     * @see #setStartSuffix(String)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMarkerLog_StartSuffix()
     * @model default="started" required="true"
     * @generated
     */
    String getStartSuffix();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MarkerLog#getStartSuffix <em>Start Suffix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Suffix</em>' attribute.
     * @see #getStartSuffix()
     * @generated
     */
    void setStartSuffix(String value);

    /**
     * Returns the value of the '<em><b>Measurement Suffix</b></em>' attribute.
     * The default value is <code>"measurement"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Measurement Suffix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Measurement Suffix</em>' attribute.
     * @see #setMeasurementSuffix(String)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMarkerLog_MeasurementSuffix()
     * @model default="measurement" required="true"
     * @generated
     */
    String getMeasurementSuffix();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MarkerLog#getMeasurementSuffix <em>Measurement Suffix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Measurement Suffix</em>' attribute.
     * @see #getMeasurementSuffix()
     * @generated
     */
    void setMeasurementSuffix(String value);

} // MarkerLog
