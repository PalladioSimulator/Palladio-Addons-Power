/**
 */
package de.fzi.power.binding;

import org.eclipse.emf.common.util.EList;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Power Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.PowerBinding#getPowerBindingRepository
 * <em>Power Binding Repository</em>}</li>
 * <li>{@link de.fzi.power.binding.PowerBinding#getFixedFactorValues <em>Fixed Factor Values</em>}
 * </li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getPowerBinding()
 * @model abstract="true"
 * @generated
 */
public interface PowerBinding extends Entity {
    /**
     * Returns the value of the '<em><b>Power Binding Repository</b></em>' container reference. It
     * is bidirectional and its opposite is '
     * {@link de.fzi.power.binding.PowerBindingRepository#getPowerBindings <em>Power Bindings</em>}
     * '. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power Binding Repository</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power Binding Repository</em>' container reference.
     * @see #setPowerBindingRepository(PowerBindingRepository)
     * @see de.fzi.power.binding.BindingPackage#getPowerBinding_PowerBindingRepository()
     * @see de.fzi.power.binding.PowerBindingRepository#getPowerBindings
     * @model opposite="powerBindings" transient="false"
     * @generated
     */
    PowerBindingRepository getPowerBindingRepository();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.PowerBinding#getPowerBindingRepository
     * <em>Power Binding Repository</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Power Binding Repository</em>' container reference.
     * @see #getPowerBindingRepository()
     * @generated
     */
    void setPowerBindingRepository(PowerBindingRepository value);

    /**
     * Returns the value of the '<em><b>Fixed Factor Values</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.binding.FixedFactorValue}. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.power.binding.FixedFactorValue#getPowerBinding <em>Power Binding</em>}'. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fixed Factor Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Fixed Factor Values</em>' containment reference list.
     * @see de.fzi.power.binding.BindingPackage#getPowerBinding_FixedFactorValues()
     * @see de.fzi.power.binding.FixedFactorValue#getPowerBinding
     * @model opposite="powerBinding" containment="true"
     * @generated
     */
    EList<FixedFactorValue> getFixedFactorValues();

} // PowerBinding
