/**
 */
package de.fzi.power.binding.impl;

import javax.measure.Measure;
import javax.measure.quantity.Power;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.specification.FixedFactor;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Fixed Factor Value</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getBoundFactor <em>Bound Factor</em>}
 * </li>
 * <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getValue <em>Value</em>}</li>
 * <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getPowerBinding <em>Power Binding</em>}
 * </li>
 * </ul>
 *
 * @generated
 */
public class FixedFactorValueImpl extends IdentifierImpl implements FixedFactorValue {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FixedFactorValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.FIXED_FACTOR_VALUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FixedFactor getBoundFactor() {
        return (FixedFactor) this.eDynamicGet(BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.FIXED_FACTOR_VALUE__BOUND_FACTOR, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public FixedFactor basicGetBoundFactor() {
        return (FixedFactor) this.eDynamicGet(BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.FIXED_FACTOR_VALUE__BOUND_FACTOR, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBoundFactor(final FixedFactor newBoundFactor) {
        this.eDynamicSet(BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.FIXED_FACTOR_VALUE__BOUND_FACTOR, newBoundFactor);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Measure<Double, Power> getValue() {
        return (Measure<Double, Power>) this.eDynamicGet(BindingPackage.FIXED_FACTOR_VALUE__VALUE,
                BindingPackage.Literals.FIXED_FACTOR_VALUE__VALUE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setValue(final Measure<Double, Power> newValue) {
        this.eDynamicSet(BindingPackage.FIXED_FACTOR_VALUE__VALUE, BindingPackage.Literals.FIXED_FACTOR_VALUE__VALUE,
                newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PowerBinding getPowerBinding() {
        return (PowerBinding) this.eDynamicGet(BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING,
                BindingPackage.Literals.FIXED_FACTOR_VALUE__POWER_BINDING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPowerBinding(final PowerBinding newPowerBinding, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPowerBinding,
                BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPowerBinding(final PowerBinding newPowerBinding) {
        this.eDynamicSet(BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING,
                BindingPackage.Literals.FIXED_FACTOR_VALUE__POWER_BINDING, newPowerBinding);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetPowerBinding((PowerBinding) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return this.basicSetPowerBinding(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return this.eInternalContainer().eInverseRemove(this, BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES,
                    PowerBinding.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            if (resolve) {
                return this.getBoundFactor();
            }
            return this.basicGetBoundFactor();
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            return this.getValue();
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return this.getPowerBinding();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            this.setBoundFactor((FixedFactor) newValue);
            return;
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            this.setValue((Measure<Double, Power>) newValue);
            return;
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            this.setPowerBinding((PowerBinding) newValue);
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
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            this.setBoundFactor((FixedFactor) null);
            return;
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            this.setValue((Measure<Double, Power>) null);
            return;
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            this.setPowerBinding((PowerBinding) null);
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
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            return this.basicGetBoundFactor() != null;
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            return this.getValue() != null;
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return this.getPowerBinding() != null;
        }
        return super.eIsSet(featureID);
    }

} // FixedFactorValueImpl
