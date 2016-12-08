/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.binding.AbstractPowerState;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Power State</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.AbstractPowerStateImpl#getStatefulResourcePowerBinding
 * <em>Stateful Resource Power Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractPowerStateImpl extends EntityImpl implements AbstractPowerState {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AbstractPowerStateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.ABSTRACT_POWER_STATE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public StatefulResourcePowerBinding getStatefulResourcePowerBinding() {
        return (StatefulResourcePowerBinding) this.eDynamicGet(
                BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING,
                BindingPackage.Literals.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetStatefulResourcePowerBinding(
            final StatefulResourcePowerBinding newStatefulResourcePowerBinding, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newStatefulResourcePowerBinding,
                BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStatefulResourcePowerBinding(final StatefulResourcePowerBinding newStatefulResourcePowerBinding) {
        this.eDynamicSet(BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING,
                BindingPackage.Literals.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING,
                newStatefulResourcePowerBinding);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetStatefulResourcePowerBinding((StatefulResourcePowerBinding) otherEnd, msgs);
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
        case BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
            return this.basicSetStatefulResourcePowerBinding(null, msgs);
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
        case BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
            return this.eInternalContainer().eInverseRemove(this,
                    BindingPackage.STATEFUL_RESOURCE_POWER_BINDING__POWER_STATES, StatefulResourcePowerBinding.class,
                    msgs);
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
        case BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
            return this.getStatefulResourcePowerBinding();
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
        case BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
            this.setStatefulResourcePowerBinding((StatefulResourcePowerBinding) newValue);
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
        case BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
            this.setStatefulResourcePowerBinding((StatefulResourcePowerBinding) null);
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
        case BindingPackage.ABSTRACT_POWER_STATE__STATEFUL_RESOURCE_POWER_BINDING:
            return this.getStatefulResourcePowerBinding() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractPowerStateImpl
