/**
 */
package de.fzi.power.specification;

import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Measured Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.specification.MeasuredFactor#getMetricType <em>Metric Type</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.specification.SpecificationPackage#getMeasuredFactor()
 * @model
 * @generated
 */
public interface MeasuredFactor extends ConsumptionFactor {
    /**
     * Returns the value of the '<em><b>Metric Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Metric Type</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Metric Type</em>' reference.
     * @see #setMetricType(NumericalBaseMetricDescription)
     * @see de.fzi.power.specification.SpecificationPackage#getMeasuredFactor_MetricType()
     * @model required="true"
     * @generated
     */
    NumericalBaseMetricDescription getMetricType();

    /**
     * Sets the value of the '{@link de.fzi.power.specification.MeasuredFactor#getMetricType <em>Metric Type</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Metric Type</em>' reference.
     * @see #getMetricType()
     * @generated
     */
    void setMetricType(NumericalBaseMetricDescription value);

} // MeasuredFactor
