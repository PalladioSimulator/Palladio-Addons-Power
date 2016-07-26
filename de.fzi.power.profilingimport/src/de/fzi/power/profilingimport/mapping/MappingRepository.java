/**
 */
package de.fzi.power.profilingimport.mapping;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MappingRepository#getMappings <em>Mappings</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MappingRepository#getMarkerLog <em>Marker Log</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMappingRepository()
 * @model
 * @generated
 */
public interface MappingRepository extends Identifier {
    /**
     * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping}.
     * It is bidirectional and its opposite is '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getRepository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mappings</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mappings</em>' containment reference list.
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMappingRepository_Mappings()
     * @see de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getRepository
     * @model opposite="repository" containment="true"
     * @generated
     */
    EList<MetricToCsvMapping> getMappings();

    /**
     * Returns the value of the '<em><b>Marker Log</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fzi.power.profilingimport.mapping.MarkerLog#getRepository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Marker Log</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Marker Log</em>' containment reference.
     * @see #setMarkerLog(MarkerLog)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMappingRepository_MarkerLog()
     * @see de.fzi.power.profilingimport.mapping.MarkerLog#getRepository
     * @model opposite="repository" containment="true" required="true"
     * @generated
     */
    MarkerLog getMarkerLog();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MappingRepository#getMarkerLog <em>Marker Log</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Marker Log</em>' containment reference.
     * @see #getMarkerLog()
     * @generated
     */
    void setMarkerLog(MarkerLog value);

} // MappingRepository
