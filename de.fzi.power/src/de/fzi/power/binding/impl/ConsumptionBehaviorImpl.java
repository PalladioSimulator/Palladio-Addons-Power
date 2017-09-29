/**
 */
package de.fzi.power.binding.impl;

import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ConsumptionBehavior;
import de.fzi.power.util.impl.EntityImpl;
import tools.descartes.dlim.Sequence;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Consumption Behavior</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.ConsumptionBehaviorImpl#getPowerCurve <em>Power Curve</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.ConsumptionBehaviorImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsumptionBehaviorImpl extends EntityImpl implements ConsumptionBehavior {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ConsumptionBehaviorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.CONSUMPTION_BEHAVIOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Sequence getPowerCurve() {
        return (Sequence) eDynamicGet(BindingPackage.CONSUMPTION_BEHAVIOR__POWER_CURVE,
                BindingPackage.Literals.CONSUMPTION_BEHAVIOR__POWER_CURVE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerCurve(Sequence newPowerCurve, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newPowerCurve, BindingPackage.CONSUMPTION_BEHAVIOR__POWER_CURVE,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerCurve(Sequence newPowerCurve) {
        eDynamicSet(BindingPackage.CONSUMPTION_BEHAVIOR__POWER_CURVE,
                BindingPackage.Literals.CONSUMPTION_BEHAVIOR__POWER_CURVE, newPowerCurve);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Unit<Power> getUnit() {
        return (Unit<Power>) eDynamicGet(BindingPackage.CONSUMPTION_BEHAVIOR__UNIT,
                BindingPackage.Literals.CONSUMPTION_BEHAVIOR__UNIT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setUnit(Unit<Power> newUnit) {
        eDynamicSet(BindingPackage.CONSUMPTION_BEHAVIOR__UNIT, BindingPackage.Literals.CONSUMPTION_BEHAVIOR__UNIT,
                newUnit);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.CONSUMPTION_BEHAVIOR__POWER_CURVE:
            return basicSetPowerCurve(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case BindingPackage.CONSUMPTION_BEHAVIOR__POWER_CURVE:
            return getPowerCurve();
        case BindingPackage.CONSUMPTION_BEHAVIOR__UNIT:
            return getUnit();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case BindingPackage.CONSUMPTION_BEHAVIOR__POWER_CURVE:
            setPowerCurve((Sequence) newValue);
            return;
        case BindingPackage.CONSUMPTION_BEHAVIOR__UNIT:
            setUnit((Unit<Power>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case BindingPackage.CONSUMPTION_BEHAVIOR__POWER_CURVE:
            setPowerCurve((Sequence) null);
            return;
        case BindingPackage.CONSUMPTION_BEHAVIOR__UNIT:
            setUnit((Unit<Power>) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case BindingPackage.CONSUMPTION_BEHAVIOR__POWER_CURVE:
            return getPowerCurve() != null;
        case BindingPackage.CONSUMPTION_BEHAVIOR__UNIT:
            return getUnit() != null;
        }
        return super.eIsSet(featureID);
    }

} // ConsumptionBehaviorImpl
