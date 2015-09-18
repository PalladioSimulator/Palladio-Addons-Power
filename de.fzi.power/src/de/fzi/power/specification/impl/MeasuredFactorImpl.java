/**
 */
package de.fzi.power.specification.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;

import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Measured Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.specification.impl.MeasuredFactorImpl#getMetricType <em>Metric Type</em>}
 * </li>
 * </ul>
 *
 * @generated
 */
public class MeasuredFactorImpl extends ConsumptionFactorImpl implements MeasuredFactor {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MeasuredFactorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpecificationPackage.Literals.MEASURED_FACTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NumericalBaseMetricDescription getMetricType() {
        return (NumericalBaseMetricDescription) this.eDynamicGet(SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE,
                SpecificationPackage.Literals.MEASURED_FACTOR__METRIC_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NumericalBaseMetricDescription basicGetMetricType() {
        return (NumericalBaseMetricDescription) this.eDynamicGet(SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE,
                SpecificationPackage.Literals.MEASURED_FACTOR__METRIC_TYPE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMetricType(final NumericalBaseMetricDescription newMetricType) {
        this.eDynamicSet(SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE,
                SpecificationPackage.Literals.MEASURED_FACTOR__METRIC_TYPE, newMetricType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE:
            if (resolve) {
                return this.getMetricType();
            }
            return this.basicGetMetricType();
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
        case SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE:
            this.setMetricType((NumericalBaseMetricDescription) newValue);
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
        case SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE:
            this.setMetricType((NumericalBaseMetricDescription) null);
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
        case SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE:
            return this.basicGetMetricType() != null;
        }
        return super.eIsSet(featureID);
    }

} // MeasuredFactorImpl
