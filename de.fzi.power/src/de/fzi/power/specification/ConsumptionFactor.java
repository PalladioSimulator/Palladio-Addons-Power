/**
 */
package de.fzi.power.specification;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Consumption Factor</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.specification.ConsumptionFactor#getPowerModel <em>Power Model</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.specification.SpecificationPackage#getConsumptionFactor()
 * @model abstract="true"
 * @generated
 */
public interface ConsumptionFactor extends Entity {
    /**
     * Returns the value of the '<em><b>Power Model</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.power.specification.PowerModelSpecification#getConsumptionFactors
     * <em>Consumption Factors</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power Model</em>' container reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Power Model</em>' container reference.
     * @see #setPowerModel(PowerModelSpecification)
     * @see de.fzi.power.specification.SpecificationPackage#getConsumptionFactor_PowerModel()
     * @see de.fzi.power.specification.PowerModelSpecification#getConsumptionFactors
     * @model opposite="consumptionFactors" transient="false"
     * @generated
     */
    PowerModelSpecification getPowerModel();

    /**
     * Sets the value of the '{@link de.fzi.power.specification.ConsumptionFactor#getPowerModel
     * <em>Power Model</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Power Model</em>' container reference.
     * @see #getPowerModel()
     * @generated
     */
    void setPowerModel(PowerModelSpecification value);

} // ConsumptionFactor
