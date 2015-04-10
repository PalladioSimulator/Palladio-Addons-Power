/**
 */
package de.fzi.power.binding.impl;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.PowerBinding;

import de.fzi.power.specification.FixedFactor;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import javax.measure.Measure;

import javax.measure.quantity.Power;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Factor Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getBoundFactor <em>Bound Factor</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.FixedFactorValueImpl#getPowerBinding <em>Power Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedFactorValueImpl extends IdentifierImpl implements FixedFactorValue {
    /**
     * The cached value of the '{@link #getBoundFactor() <em>Bound Factor</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBoundFactor()
     * @generated
     * @ordered
     */
    protected FixedFactor boundFactor;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected Measure<Double, Power> value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FixedFactorValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.FIXED_FACTOR_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public FixedFactor getBoundFactor() {
        if (boundFactor != null && boundFactor.eIsProxy()) {
            InternalEObject oldBoundFactor = (InternalEObject) boundFactor;
            boundFactor = (FixedFactor) eResolveProxy(oldBoundFactor);
            if (boundFactor != oldBoundFactor) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR, oldBoundFactor, boundFactor));
            }
        }
        return boundFactor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FixedFactor basicGetBoundFactor() {
        return boundFactor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setBoundFactor(FixedFactor newBoundFactor) {
        FixedFactor oldBoundFactor = boundFactor;
        boundFactor = newBoundFactor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR,
                    oldBoundFactor, boundFactor));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Measure<Double, Power> getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setValue(Measure<Double, Power> newValue) {
        Measure<Double, Power> oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.FIXED_FACTOR_VALUE__VALUE, oldValue,
                    value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerBinding getPowerBinding() {
        if (eContainerFeatureID() != BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING)
            return null;
        return (PowerBinding) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerBinding(PowerBinding newPowerBinding, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerBinding, BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerBinding(PowerBinding newPowerBinding) {
        if (newPowerBinding != eInternalContainer()
                || (eContainerFeatureID() != BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING && newPowerBinding != null)) {
            if (EcoreUtil.isAncestor(this, newPowerBinding))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPowerBinding != null)
                msgs = ((InternalEObject) newPowerBinding).eInverseAdd(this,
                        BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES, PowerBinding.class, msgs);
            msgs = basicSetPowerBinding(newPowerBinding, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING,
                    newPowerBinding, newPowerBinding));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerBinding((PowerBinding) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return basicSetPowerBinding(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return eInternalContainer().eInverseRemove(this, BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES,
                    PowerBinding.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            if (resolve)
                return getBoundFactor();
            return basicGetBoundFactor();
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            return getValue();
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return getPowerBinding();
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
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            setBoundFactor((FixedFactor) newValue);
            return;
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            setValue((Measure<Double, Power>) newValue);
            return;
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            setPowerBinding((PowerBinding) newValue);
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
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            setBoundFactor((FixedFactor) null);
            return;
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            setValue((Measure<Double, Power>) null);
            return;
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            setPowerBinding((PowerBinding) null);
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
        case BindingPackage.FIXED_FACTOR_VALUE__BOUND_FACTOR:
            return boundFactor != null;
        case BindingPackage.FIXED_FACTOR_VALUE__VALUE:
            return value != null;
        case BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING:
            return getPowerBinding() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} //FixedFactorValueImpl
