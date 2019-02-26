/**
 */
package de.fzi.power.binding.impl;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerFactorBinding;
import de.fzi.power.specification.FixedFactor;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Fixed Factor Value</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.AbstractFixedFactorValueImpl#getBoundFactor <em>Bound Factor</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.AbstractFixedFactorValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.AbstractFixedFactorValueImpl#getPowerBinding <em>Power Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractFixedFactorValueImpl<Q extends Quantity> extends IdentifierImpl
        implements AbstractFixedFactorValue<Q> {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AbstractFixedFactorValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public FixedFactor getBoundFactor() {
        return (FixedFactor) eDynamicGet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public FixedFactor basicGetBoundFactor() {
        return (FixedFactor) eDynamicGet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setBoundFactor(FixedFactor newBoundFactor) {
        eDynamicSet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR, newBoundFactor);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Measure<Double, Q> getValue() {
        return (Measure<Double, Q>) eDynamicGet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__VALUE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setValue(Measure<Double, Q> newValue) {
        eDynamicSet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__VALUE, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerFactorBinding getPowerBinding() {
        return (PowerFactorBinding) eDynamicGet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerBinding(PowerFactorBinding newPowerBinding, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerBinding,
                BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerBinding(PowerFactorBinding newPowerBinding) {
        eDynamicSet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING, newPowerBinding);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerBinding((PowerFactorBinding) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            return basicSetPowerBinding(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            return eInternalContainer().eInverseRemove(this, BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES,
                    PowerFactorBinding.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR:
            if (resolve)
                return getBoundFactor();
            return basicGetBoundFactor();
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            return getValue();
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            return getPowerBinding();
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR:
            setBoundFactor((FixedFactor) newValue);
            return;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            setValue((Measure<Double, Q>) newValue);
            return;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            setPowerBinding((PowerFactorBinding) newValue);
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR:
            setBoundFactor((FixedFactor) null);
            return;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            setValue((Measure<Double, Q>) null);
            return;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            setPowerBinding((PowerFactorBinding) null);
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR:
            return basicGetBoundFactor() != null;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            return getValue() != null;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            return getPowerBinding() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractFixedFactorValueImpl
