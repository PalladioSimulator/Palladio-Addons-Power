/**
 */
package de.fzi.power.binding;

import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import de.fzi.power.util.Entity;
import tools.descartes.dlim.Sequence;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Consumption Behavior</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.ConsumptionBehavior#getPowerCurve <em>Power Curve</em>}</li>
 * <li>{@link de.fzi.power.binding.ConsumptionBehavior#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getConsumptionBehavior()
 * @model
 * @generated
 */
public interface ConsumptionBehavior extends Entity {
    /**
     * Returns the value of the '<em><b>Power Curve</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power Curve</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power Curve</em>' containment reference.
     * @see #setPowerCurve(Sequence)
     * @see de.fzi.power.binding.BindingPackage#getConsumptionBehavior_PowerCurve()
     * @model containment="true" required="true"
     * @generated
     */
    Sequence getPowerCurve();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.ConsumptionBehavior#getPowerCurve
     * <em>Power Curve</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Power Curve</em>' containment reference.
     * @see #getPowerCurve()
     * @generated
     */
    void setPowerCurve(Sequence value);

    /**
     * Returns the value of the '<em><b>Unit</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unit</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Unit</em>' attribute.
     * @see #setUnit(Unit)
     * @see de.fzi.power.binding.BindingPackage#getConsumptionBehavior_Unit()
     * @model dataType="org.palladiosimulator.metricspec.EJSUnit<de.fzi.power.util.Power>"
     *        required="true"
     * @generated
     */
    Unit<Power> getUnit();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.ConsumptionBehavior#getUnit <em>Unit</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Unit</em>' attribute.
     * @see #getUnit()
     * @generated
     */
    void setUnit(Unit<Power> value);

} // ConsumptionBehavior
