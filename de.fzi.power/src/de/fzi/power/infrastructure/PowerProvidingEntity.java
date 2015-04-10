/**
 */
package de.fzi.power.infrastructure;

import de.fzi.power.binding.DistributionPowerBinding;

import de.fzi.power.util.Entity;

import javax.measure.Measure;

import javax.measure.quantity.Power;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Providing Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.PowerProvidingEntity#getNestedPowerConsumingEntities <em>Nested Power Consuming Entities</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.PowerProvidingEntity#getSuppliablePeakPower <em>Suppliable Peak Power</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.PowerProvidingEntity#getPowerInfrastructureModel <em>Power Infrastructure Model</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.PowerProvidingEntity#getDistributionPowerAssemblyContext <em>Distribution Power Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerProvidingEntity()
 * @model abstract="true"
 * @generated
 */
public interface PowerProvidingEntity extends Entity {
    /**
     * Returns the value of the '<em><b>Nested Power Consuming Entities</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.infrastructure.PowerConsumingEntity}.
     * It is bidirectional and its opposite is '{@link de.fzi.power.infrastructure.PowerConsumingEntity#getPowerProvidingEntity <em>Power Providing Entity</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nested Power Consuming Entities</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nested Power Consuming Entities</em>' containment reference list.
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerProvidingEntity_NestedPowerConsumingEntities()
     * @see de.fzi.power.infrastructure.PowerConsumingEntity#getPowerProvidingEntity
     * @model opposite="powerProvidingEntity" containment="true" ordered="false"
     * @generated
     */
    EList<PowerConsumingEntity> getNestedPowerConsumingEntities();

    /**
     * Returns the value of the '<em><b>Suppliable Peak Power</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Suppliable Peak Power</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Suppliable Peak Power</em>' attribute.
     * @see #setSuppliablePeakPower(Measure)
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerProvidingEntity_SuppliablePeakPower()
     * @model default="" dataType="org.palladiosimulator.edp2.models.ExperimentData.EJSMeasure<?, de.fzi.power.util.Power>" required="true" ordered="false"
     * @generated
     */
    Measure<?, Power> getSuppliablePeakPower();

    /**
     * Sets the value of the '{@link de.fzi.power.infrastructure.PowerProvidingEntity#getSuppliablePeakPower <em>Suppliable Peak Power</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Suppliable Peak Power</em>' attribute.
     * @see #getSuppliablePeakPower()
     * @generated
     */
    void setSuppliablePeakPower(Measure<?, Power> value);

    /**
     * Returns the value of the '<em><b>Power Infrastructure Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fzi.power.infrastructure.PowerInfrastructureRepository#getContainedPowerProvidingEntities <em>Contained Power Providing Entities</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Power Infrastructure Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Power Infrastructure Model</em>' container reference.
     * @see #setPowerInfrastructureModel(PowerInfrastructureRepository)
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerProvidingEntity_PowerInfrastructureModel()
     * @see de.fzi.power.infrastructure.PowerInfrastructureRepository#getContainedPowerProvidingEntities
     * @model opposite="containedPowerProvidingEntities" transient="false"
     * @generated
     */
    PowerInfrastructureRepository getPowerInfrastructureModel();

    /**
     * Sets the value of the '{@link de.fzi.power.infrastructure.PowerProvidingEntity#getPowerInfrastructureModel <em>Power Infrastructure Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Power Infrastructure Model</em>' container reference.
     * @see #getPowerInfrastructureModel()
     * @generated
     */
    void setPowerInfrastructureModel(PowerInfrastructureRepository value);

    /**
     * Returns the value of the '<em><b>Distribution Power Assembly Context</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Distribution Power Assembly Context</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Distribution Power Assembly Context</em>' reference.
     * @see #setDistributionPowerAssemblyContext(DistributionPowerBinding)
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerProvidingEntity_DistributionPowerAssemblyContext()
     * @model
     * @generated
     */
    DistributionPowerBinding getDistributionPowerAssemblyContext();

    /**
     * Sets the value of the '{@link de.fzi.power.infrastructure.PowerProvidingEntity#getDistributionPowerAssemblyContext <em>Distribution Power Assembly Context</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Distribution Power Assembly Context</em>' reference.
     * @see #getDistributionPowerAssemblyContext()
     * @generated
     */
    void setDistributionPowerAssemblyContext(DistributionPowerBinding value);

} // PowerProvidingEntity
