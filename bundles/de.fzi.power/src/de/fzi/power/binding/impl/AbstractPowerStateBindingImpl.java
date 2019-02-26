/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.binding.AbstractPowerStateBinding;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Power State Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.AbstractPowerStateBindingImpl#getStatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractPowerStateBindingImpl extends EntityImpl implements AbstractPowerStateBinding {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AbstractPowerStateBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.ABSTRACT_POWER_STATE_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public StatefulResourcePowerBinding getStatefulResourcePowerBinding() {
        return (StatefulResourcePowerBinding) eDynamicGet(
                BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING,
                BindingPackage.Literals.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStatefulResourcePowerBinding(
            StatefulResourcePowerBinding newStatefulResourcePowerBinding, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newStatefulResourcePowerBinding,
                BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setStatefulResourcePowerBinding(StatefulResourcePowerBinding newStatefulResourcePowerBinding) {
        eDynamicSet(BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING,
                BindingPackage.Literals.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING,
                newStatefulResourcePowerBinding);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetStatefulResourcePowerBinding((StatefulResourcePowerBinding) otherEnd, msgs);
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
        case BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING:
            return basicSetStatefulResourcePowerBinding(null, msgs);
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
        case BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING:
            return eInternalContainer().eInverseRemove(this,
                    BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATE_BINDINGS,
                    StatefulResourcePowerBinding.class, msgs);
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
        case BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING:
            return getStatefulResourcePowerBinding();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING:
            setStatefulResourcePowerBinding((StatefulResourcePowerBinding) newValue);
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
        case BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING:
            setStatefulResourcePowerBinding((StatefulResourcePowerBinding) null);
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
        case BindingPackage.ABSTRACT_POWER_STATE_BINDING__STATEFUL_RESOURCE_POWER_BINDING:
            return getStatefulResourcePowerBinding() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractPowerStateBindingImpl
