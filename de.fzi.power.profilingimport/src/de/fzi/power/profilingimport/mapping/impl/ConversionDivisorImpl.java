/**
 */
package de.fzi.power.profilingimport.mapping.impl;

import de.fzi.power.profilingimport.mapping.ConversionDivisor;
import de.fzi.power.profilingimport.mapping.MappingPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import javax.measure.Measure;

import javax.measure.quantity.Quantity;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.metricspec.MetricSetDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conversion Divisor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.ConversionDivisorImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.ConversionDivisorImpl#getValueString <em>Value String</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.ConversionDivisorImpl#getResultingMetric <em>Resulting Metric</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConversionDivisorImpl extends IdentifierImpl implements ConversionDivisor {
    /**
     * The default value of the '{@link #getValueString() <em>Value String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueString()
     * @generated
     * @ordered
     */
    protected static final String VALUE_STRING_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConversionDivisorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.CONVERSION_DIVISOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Measure<Double, Quantity> getValue() {
        org.jscience.physics.amount.Amount amount = org.jscience.physics.amount.Amount.valueOf(this.getValueString());
        return javax.measure.Measure.valueOf(amount.getEstimatedValue(), amount.getUnit());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean isSetValue() {
        return this.getValueString() != null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValueString() {
        return (String)eDynamicGet(MappingPackage.CONVERSION_DIVISOR__VALUE_STRING, MappingPackage.Literals.CONVERSION_DIVISOR__VALUE_STRING, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValueString(String newValueString) {
        eDynamicSet(MappingPackage.CONVERSION_DIVISOR__VALUE_STRING, MappingPackage.Literals.CONVERSION_DIVISOR__VALUE_STRING, newValueString);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MetricSetDescription getResultingMetric() {
        return (MetricSetDescription)eDynamicGet(MappingPackage.CONVERSION_DIVISOR__RESULTING_METRIC, MappingPackage.Literals.CONVERSION_DIVISOR__RESULTING_METRIC, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MetricSetDescription basicGetResultingMetric() {
        return (MetricSetDescription)eDynamicGet(MappingPackage.CONVERSION_DIVISOR__RESULTING_METRIC, MappingPackage.Literals.CONVERSION_DIVISOR__RESULTING_METRIC, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResultingMetric(MetricSetDescription newResultingMetric) {
        eDynamicSet(MappingPackage.CONVERSION_DIVISOR__RESULTING_METRIC, MappingPackage.Literals.CONVERSION_DIVISOR__RESULTING_METRIC, newResultingMetric);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MappingPackage.CONVERSION_DIVISOR__VALUE:
                return getValue();
            case MappingPackage.CONVERSION_DIVISOR__VALUE_STRING:
                return getValueString();
            case MappingPackage.CONVERSION_DIVISOR__RESULTING_METRIC:
                if (resolve) return getResultingMetric();
                return basicGetResultingMetric();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MappingPackage.CONVERSION_DIVISOR__VALUE_STRING:
                setValueString((String)newValue);
                return;
            case MappingPackage.CONVERSION_DIVISOR__RESULTING_METRIC:
                setResultingMetric((MetricSetDescription)newValue);
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
            case MappingPackage.CONVERSION_DIVISOR__VALUE_STRING:
                setValueString(VALUE_STRING_EDEFAULT);
                return;
            case MappingPackage.CONVERSION_DIVISOR__RESULTING_METRIC:
                setResultingMetric((MetricSetDescription)null);
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
            case MappingPackage.CONVERSION_DIVISOR__VALUE:
                return isSetValue();
            case MappingPackage.CONVERSION_DIVISOR__VALUE_STRING:
                return VALUE_STRING_EDEFAULT == null ? getValueString() != null : !VALUE_STRING_EDEFAULT.equals(getValueString());
            case MappingPackage.CONVERSION_DIVISOR__RESULTING_METRIC:
                return basicGetResultingMetric() != null;
        }
        return super.eIsSet(featureID);
    }

} //ConversionDivisorImpl
