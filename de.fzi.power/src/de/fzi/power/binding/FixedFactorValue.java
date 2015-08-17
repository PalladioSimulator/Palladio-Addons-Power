/**
 */
package de.fzi.power.binding;

import javax.measure.Measure;
import javax.measure.quantity.Power;

import de.fzi.power.specification.FixedFactor;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Fixed Factor Value</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.FixedFactorValue#getBoundFactor <em>Bound Factor</em>}</li>
 * <li>{@link de.fzi.power.binding.FixedFactorValue#getValue <em>Value</em>}</li>
 * <li>{@link de.fzi.power.binding.FixedFactorValue#getPowerBinding <em>Power Binding</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getFixedFactorValue()
 * @model
 * @generated
 */
public interface FixedFactorValue extends Identifier {
    /**
     * Returns the value of the '<em><b>Bound Factor</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Bound Factor</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Bound Factor</em>' reference.
     * @see #setBoundFactor(FixedFactor)
     * @see de.fzi.power.binding.BindingPackage#getFixedFactorValue_BoundFactor()
     * @model required="true"
     * @generated
     */
    FixedFactor getBoundFactor();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.FixedFactorValue#getBoundFactor
     * <em>Bound Factor</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Bound Factor</em>' reference.
     * @see #getBoundFactor()
     * @generated
     */
    void setBoundFactor(FixedFactor value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(Measure)
     * @see de.fzi.power.binding.BindingPackage#getFixedFactorValue_Value()
     * @model dataType=
     *        "org.palladiosimulator.edp2.models.ExperimentData.EJSMeasure<org.eclipse.emf.ecore.EDoubleObject, de.fzi.power.util.Power>"
     * @generated
     */
    Measure<Double, Power> getValue();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.FixedFactorValue#getValue <em>Value</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(Measure<Double, Power> value);

    /**
     * Returns the value of the '<em><b>Power Binding</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.power.binding.PowerBinding#getFixedFactorValues <em>Fixed Factor Values</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power Binding</em>' container reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power Binding</em>' container reference.
     * @see #setPowerBinding(PowerBinding)
     * @see de.fzi.power.binding.BindingPackage#getFixedFactorValue_PowerBinding()
     * @see de.fzi.power.binding.PowerBinding#getFixedFactorValues
     * @model opposite="fixedFactorValues" transient="false"
     * @generated
     */
    PowerBinding getPowerBinding();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.FixedFactorValue#getPowerBinding
     * <em>Power Binding</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Power Binding</em>' container reference.
     * @see #getPowerBinding()
     * @generated
     */
    void setPowerBinding(PowerBinding value);

} // FixedFactorValue
