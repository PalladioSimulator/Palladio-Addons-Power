/**
 */
package de.fzi.power.specification.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Declarative Power Model Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link de.fzi.power.specification.impl.DeclarativePowerModelSpecificationImpl#getFunctionalExpression
 * <em>Functional Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarativePowerModelSpecificationImpl extends PowerModelSpecificationImpl
        implements DeclarativePowerModelSpecification {
    /**
     * The default value of the '{@link #getFunctionalExpression() <em>Functional Expression</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFunctionalExpression()
     * @generated
     * @ordered
     */
    protected static final String FUNCTIONAL_EXPRESSION_EDEFAULT = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DeclarativePowerModelSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpecificationPackage.Literals.DECLARATIVE_POWER_MODEL_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getFunctionalExpression() {
        return (String) this.eDynamicGet(
                SpecificationPackage.DECLARATIVE_POWER_MODEL_SPECIFICATION__FUNCTIONAL_EXPRESSION,
                SpecificationPackage.Literals.DECLARATIVE_POWER_MODEL_SPECIFICATION__FUNCTIONAL_EXPRESSION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFunctionalExpression(final String newFunctionalExpression) {
        this.eDynamicSet(SpecificationPackage.DECLARATIVE_POWER_MODEL_SPECIFICATION__FUNCTIONAL_EXPRESSION,
                SpecificationPackage.Literals.DECLARATIVE_POWER_MODEL_SPECIFICATION__FUNCTIONAL_EXPRESSION,
                newFunctionalExpression);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SpecificationPackage.DECLARATIVE_POWER_MODEL_SPECIFICATION__FUNCTIONAL_EXPRESSION:
            return this.getFunctionalExpression();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case SpecificationPackage.DECLARATIVE_POWER_MODEL_SPECIFICATION__FUNCTIONAL_EXPRESSION:
            this.setFunctionalExpression((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case SpecificationPackage.DECLARATIVE_POWER_MODEL_SPECIFICATION__FUNCTIONAL_EXPRESSION:
            this.setFunctionalExpression(FUNCTIONAL_EXPRESSION_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case SpecificationPackage.DECLARATIVE_POWER_MODEL_SPECIFICATION__FUNCTIONAL_EXPRESSION:
            return FUNCTIONAL_EXPRESSION_EDEFAULT == null ? this.getFunctionalExpression() != null
                    : !FUNCTIONAL_EXPRESSION_EDEFAULT.equals(this.getFunctionalExpression());
        }
        return super.eIsSet(featureID);
    }

} // DeclarativePowerModelSpecificationImpl
