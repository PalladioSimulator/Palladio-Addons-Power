/**
 */
package de.fzi.power.specification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Replica Measured Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.specification.ResourceReplicaMeasuredFactor#getReplicaId <em>Replica Id</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.specification.SpecificationPackage#getResourceReplicaMeasuredFactor()
 * @model
 * @generated
 */
public interface ResourceReplicaMeasuredFactor extends MeasuredFactor {
    /**
     * Returns the value of the '<em><b>Replica Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Replica Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Replica Id</em>' attribute.
     * @see #setReplicaId(int)
     * @see de.fzi.power.specification.SpecificationPackage#getResourceReplicaMeasuredFactor_ReplicaId()
     * @model required="true"
     * @generated
     */
    int getReplicaId();

    /**
     * Sets the value of the '{@link de.fzi.power.specification.ResourceReplicaMeasuredFactor#getReplicaId <em>Replica Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Replica Id</em>' attribute.
     * @see #getReplicaId()
     * @generated
     */
    void setReplicaId(int value);

} // ResourceReplicaMeasuredFactor
