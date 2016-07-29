/**
 */
package de.fzi.power.profilingimport.mapping;

import de.uka.ipd.sdq.identifier.Identifier;

import javax.measure.Measure;

import javax.measure.quantity.Quantity;
import org.palladiosimulator.metricspec.MetricSetDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conversion Divisor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getValue <em>Value</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getValueString <em>Value String</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getResultingMetric <em>Resulting Metric</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.profilingimport.mapping.MappingPackage#getConversionDivisor()
 * @model
 * @generated
 */
public interface ConversionDivisor extends Identifier {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #isSetValue()
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getConversionDivisor_Value()
     * @model unsettable="true" dataType="org.palladiosimulator.edp2.models.ExperimentData.EJSMeasure<org.eclipse.emf.ecore.EDoubleObject, org.palladiosimulator.metricspec.IJSQuantity>" required="true" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='org.jscience.physics.amount.Amount amount = org.jscience.physics.amount.Amount.valueOf(this.getValueString());\r\nreturn javax.measure.Measure.valueOf(amount.getEstimatedValue(), amount.getUnit());'"
     * @generated
     */
    Measure<Double, Quantity> getValue();

    /**
     * Returns whether the value of the '{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getValue <em>Value</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Value</em>' attribute is set.
     * @see #getValue()
     * @generated
     */
    boolean isSetValue();

    /**
     * Returns the value of the '<em><b>Value String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value String</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value String</em>' attribute.
     * @see #setValueString(String)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getConversionDivisor_ValueString()
     * @model required="true"
     * @generated
     */
    String getValueString();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getValueString <em>Value String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value String</em>' attribute.
     * @see #getValueString()
     * @generated
     */
    void setValueString(String value);

    /**
     * Returns the value of the '<em><b>Resulting Metric</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resulting Metric</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resulting Metric</em>' reference.
     * @see #setResultingMetric(MetricSetDescription)
     * @see de.fzi.power.profilingimport.mapping.MappingPackage#getConversionDivisor_ResultingMetric()
     * @model required="true"
     * @generated
     */
    MetricSetDescription getResultingMetric();

    /**
     * Sets the value of the '{@link de.fzi.power.profilingimport.mapping.ConversionDivisor#getResultingMetric <em>Resulting Metric</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resulting Metric</em>' reference.
     * @see #getResultingMetric()
     * @generated
     */
    void setResultingMetric(MetricSetDescription value);

} // ConversionDivisor
