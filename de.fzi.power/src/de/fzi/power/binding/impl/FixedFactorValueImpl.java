/**
 */
package de.fzi.power.binding.impl;

import javax.measure.Measure;
import javax.measure.quantity.Power;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getBoundFactor <em>Bound Factor</em>}</li>
 * <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getValue <em>Value</em>}</li>
 * <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getPowerBinding <em>Power Binding</em>}
 * </li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedFactorValueImpl extends IdentifierImpl implements FixedFactorValue {
    /**
     * The cached value of the '{@link #getBoundFactor() <em>Bound Factor</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getBoundFactor()
     * @generated
     * @ordered
     */
    protected FixedFactor boundFactor;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected Measure<Double, Power> value;

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
        if (this.boundFactor != null && this.boundFactor.eIsProxy())
        {
            final InternalEObject oldBoundFactor = (InternalEObject) this.boundFactor;
            this.boundFactor = (FixedFactor) this.eResolveProxy(oldBoundFactor);
            if (this.boundFactor != oldBoundFactor)
            {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR, oldBoundFactor, this.boundFactor));
                }
            }
        }
        return this.boundFactor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public FixedFactor basicGetBoundFactor() {
        return this.boundFactor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBoundFactor(final FixedFactor newBoundFactor) {
        final FixedFactor oldBoundFactor = this.boundFactor;
        this.boundFactor = newBoundFactor;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR,
                    oldBoundFactor, this.boundFactor));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Measure<Double, Power> getValue() {
        return this.value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setValue(final Measure<Double, Power> newValue) {
        final Measure<Double, Power> oldValue = this.value;
        this.value = newValue;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.FIXED_FACTOR_VALUE__VALUE,
                    oldValue,
                    this.value));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PowerBinding getPowerBinding() {
        if (this.eContainerFeatureID() != BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING) {
            return null;
        }
        return (PowerBinding) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPowerBinding(final PowerBinding newPowerBinding, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPowerBinding,
                BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPowerBinding(final PowerBinding newPowerBinding) {
        if (newPowerBinding != this.eInternalContainer()
                || (this.eContainerFeatureID() != BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING && newPowerBinding != null))
        {
            if (EcoreUtil.isAncestor(this, newPowerBinding)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newPowerBinding != null) {
                msgs = ((InternalEObject) newPowerBinding).eInverseAdd(this,
                        BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES, PowerBinding.class, msgs);
            }
            msgs = this.basicSetPowerBinding(newPowerBinding, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        }
        else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING,
                    newPowerBinding, newPowerBinding));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID)
        {
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
        switch (featureID)
        {
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
        switch (this.eContainerFeatureID())
        {
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
        switch (featureID)
        {
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
        switch (featureID)
        {
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
        switch (featureID)
        {
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
        switch (featureID)
        {
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            return this.boundFactor != null;
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            return this.value != null;
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return this.getPowerBinding() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (value: ");
        result.append(this.value);
        result.append(')');
        return result.toString();
    }

} // FixedFactorValueImpl
