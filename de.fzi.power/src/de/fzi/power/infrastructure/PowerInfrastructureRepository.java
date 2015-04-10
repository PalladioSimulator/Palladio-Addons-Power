/**
 */
package de.fzi.power.infrastructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Infrastructure Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.PowerInfrastructureRepository#getContainedPowerProvidingEntities <em>Contained Power Providing Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerInfrastructureRepository()
 * @model
 * @generated
 */
public interface PowerInfrastructureRepository extends EObject {
    /**
     * Returns the value of the '<em><b>Contained Power Providing Entities</b></em>' containment reference list.
     * The list contents are of type {@link de.fzi.power.infrastructure.PowerProvidingEntity}.
     * It is bidirectional and its opposite is '{@link de.fzi.power.infrastructure.PowerProvidingEntity#getPowerInfrastructureModel <em>Power Infrastructure Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Contained Power Providing Entities</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Contained Power Providing Entities</em>' containment reference list.
     * @see de.fzi.power.infrastructure.InfrastructurePackage#getPowerInfrastructureRepository_ContainedPowerProvidingEntities()
     * @see de.fzi.power.infrastructure.PowerProvidingEntity#getPowerInfrastructureModel
     * @model opposite="powerInfrastructureModel" containment="true"
     * @generated
     */
    EList<PowerProvidingEntity> getContainedPowerProvidingEntities();

} // PowerInfrastructureRepository
