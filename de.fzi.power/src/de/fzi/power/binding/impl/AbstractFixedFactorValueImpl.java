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
 * <li>{@link de.fzi.power.binding.impl.AbstractFixedFactorValueImpl#getBoundFactor
 * <em>Bound Factor</em>}</li>
 * <li>{@link de.fzi.power.binding.impl.AbstractFixedFactorValueImpl#getValue <em>Value</em>}</li>
 * <li>{@link de.fzi.power.binding.impl.AbstractFixedFactorValueImpl#getPowerBinding
 * <em>Power Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractFixedFactorValueImpl<Q extends Quantity> extends IdentifierImpl
        implements AbstractFixedFactorValue<Q> {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AbstractFixedFactorValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public FixedFactor getBoundFactor() {
        return (FixedFactor) this.eDynamicGet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public FixedFactor basicGetBoundFactor() {
        return (FixedFactor) this.eDynamicGet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBoundFactor(final FixedFactor newBoundFactor) {
        this.eDynamicSet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR, newBoundFactor);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Measure<Double, Q> getValue() {
        return (Measure<Double, Q>) this.eDynamicGet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__VALUE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setValue(final Measure<Double, Q> newValue) {
        this.eDynamicSet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__VALUE, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerFactorBinding getPowerBinding() {
        return (PowerFactorBinding) this.eDynamicGet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetPowerBinding(final PowerFactorBinding newPowerBinding, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPowerBinding,
                BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPowerBinding(final PowerFactorBinding newPowerBinding) {
        this.eDynamicSet(BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING,
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING, newPowerBinding);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetPowerBinding((PowerFactorBinding) otherEnd, msgs);
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            return this.eInternalContainer().eInverseRemove(this,
                    BindingPackage.POWER_FACTOR_BINDING__FIXED_FACTOR_VALUES, PowerFactorBinding.class, msgs);
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR:
            if (resolve) {
                return this.getBoundFactor();
            }
            return this.basicGetBoundFactor();
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            return this.getValue();
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR:
            this.setBoundFactor((FixedFactor) newValue);
            return;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            this.setValue((Measure<Double, Q>) newValue);
            return;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            this.setPowerBinding((PowerFactorBinding) newValue);
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR:
            this.setBoundFactor((FixedFactor) null);
            return;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            this.setValue((Measure<Double, Q>) null);
            return;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            this.setPowerBinding((PowerFactorBinding) null);
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
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR:
            return this.basicGetBoundFactor() != null;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            return this.getValue() != null;
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__POWER_BINDING:
            return this.getPowerBinding() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractFixedFactorValueImpl
