/**
 */
package de.fzi.power.specification.impl;

import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.SpecificationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measured Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.specification.impl.MeasuredFactorImpl#getMetricType <em>Metric Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasuredFactorImpl extends ConsumptionFactorImpl implements MeasuredFactor {
    /**
     * The cached value of the '{@link #getMetricType() <em>Metric Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMetricType()
     * @generated
     * @ordered
     */
    protected NumericalBaseMetricDescription metricType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MeasuredFactorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpecificationPackage.Literals.MEASURED_FACTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NumericalBaseMetricDescription getMetricType() {
        if (metricType != null && metricType.eIsProxy()) {
            InternalEObject oldMetricType = (InternalEObject) metricType;
            metricType = (NumericalBaseMetricDescription) eResolveProxy(oldMetricType);
            if (metricType != oldMetricType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE, oldMetricType, metricType));
            }
        }
        return metricType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NumericalBaseMetricDescription basicGetMetricType() {
        return metricType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMetricType(NumericalBaseMetricDescription newMetricType) {
        NumericalBaseMetricDescription oldMetricType = metricType;
        metricType = newMetricType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE,
                    oldMetricType, metricType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE:
            if (resolve)
                return getMetricType();
            return basicGetMetricType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE:
            setMetricType((NumericalBaseMetricDescription) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE:
            setMetricType((NumericalBaseMetricDescription) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case SpecificationPackage.MEASURED_FACTOR__METRIC_TYPE:
            return metricType != null;
        }
        return super.eIsSet(featureID);
    }

} //MeasuredFactorImpl
