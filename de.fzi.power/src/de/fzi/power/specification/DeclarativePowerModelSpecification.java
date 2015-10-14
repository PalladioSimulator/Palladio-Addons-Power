/**
 */
package de.fzi.power.specification;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Declarative Power Model Specification</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.power.specification.DeclarativePowerModelSpecification#getFunctionalExpression <em>Functional Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.power.specification.SpecificationPackage#getDeclarativePowerModelSpecification()
 * @model
 * @generated
 */
public interface DeclarativePowerModelSpecification extends
		ResourcePowerModelSpecification, DistributionPowerModelSpecification {
	/**
	 * Returns the value of the '<em><b>Functional Expression</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional Expression</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Functional Expression</em>' attribute.
	 * @see #setFunctionalExpression(String)
	 * @see de.fzi.power.specification.SpecificationPackage#getDeclarativePowerModelSpecification_FunctionalExpression()
	 * @model required="true"
	 * @generated
	 */
	String getFunctionalExpression();

	/**
	 * Sets the value of the '{@link de.fzi.power.specification.DeclarativePowerModelSpecification#getFunctionalExpression <em>Functional Expression</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functional Expression</em>' attribute.
	 * @see #getFunctionalExpression()
	 * @generated
	 */
	void setFunctionalExpression(String value);

} // DeclarativePowerModelSpecification
