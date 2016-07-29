/**
 */
package de.fzi.power.profilingimport.mapping;

import de.uka.ipd.sdq.identifier.Identifier;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;
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
 *   <li>{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getConversionDivisor <em>Conversion Divisor</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getUnitString <em>Unit String</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getUnit <em>Unit</em>}</li>
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

    /**
     * Returns the value of the '<em><b>Conversion Divisor</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Conversion Divisor</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Conversion Divisor</em>' containment reference.
     * @see #setConversionDivisor(ConversionDivisor)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMetricToCsvMapping_ConversionDivisor()
     * @model containment="true"
     * @generated
     */
    ConversionDivisor getConversionDivisor();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getConversionDivisor <em>Conversion Divisor</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Conversion Divisor</em>' containment reference.
     * @see #getConversionDivisor()
     * @generated
     */
    void setConversionDivisor(ConversionDivisor value);

    /**
     * Returns the value of the '<em><b>Unit String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unit String</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unit String</em>' attribute.
     * @see #setUnitString(String)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMetricToCsvMapping_UnitString()
     * @model required="true"
     * @generated
     */
    String getUnitString();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getUnitString <em>Unit String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Unit String</em>' attribute.
     * @see #getUnitString()
     * @generated
     */
    void setUnitString(String value);

    /**
     * Returns the value of the '<em><b>Unit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unit</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unit</em>' attribute.
     * @see #isSetUnit()
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getMetricToCsvMapping_Unit()
     * @model unsettable="true" dataType="org.palladiosimulator.metricspec.EJSUnit<? extends org.palladiosimulator.metricspec.IJSQuantity>" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return javax.measure.unit.Unit.valueOf(this.getUnitString());'"
     * @generated
     */
    Unit<? extends Quantity> getUnit();

    /**
     * Returns whether the value of the '{@link de.fzi.power.profilingimport.mapping.MetricToCsvMapping#getUnit <em>Unit</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Unit</em>' attribute is set.
     * @see #getUnit()
     * @generated
     */
    boolean isSetUnit();

} // MetricToCsvMapping
