/**
 */
package de.fzi.power.infrastructure;

import de.fzi.power.util.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Power Consuming Entity</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.infrastructure.PowerConsumingEntity#getPowerProvidingEntity
 * <em>Power Providing Entity</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerConsumingEntity()
 * @model abstract="true"
 * @generated
 */
public interface PowerConsumingEntity extends Entity {
    /**
     * Returns the value of the '<em><b>Power Providing Entity</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.power.infrastructure.PowerProvidingEntity#getNestedPowerConsumingEntities
     * <em>Nested Power Consuming Entities</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power Providing Entity</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Power Providing Entity</em>' container reference.
     * @see #setPowerProvidingEntity(PowerProvidingEntity)
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerConsumingEntity_PowerProvidingEntity()
     * @see de.fzi.power.infrastructure.PowerProvidingEntity#getNestedPowerConsumingEntities
     * @model opposite="nestedPowerConsumingEntities" transient="false" ordered="false"
     * @generated
     */
    PowerProvidingEntity getPowerProvidingEntity();

    /**
     * Sets the value of the '
     * {@link de.fzi.power.infrastructure.PowerConsumingEntity#getPowerProvidingEntity
     * <em>Power Providing Entity</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Power Providing Entity</em>' container reference.
     * @see #getPowerProvidingEntity()
     * @generated
     */
    void setPowerProvidingEntity(PowerProvidingEntity value);

} // PowerConsumingEntity
