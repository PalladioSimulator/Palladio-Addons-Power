/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.binding.AbstractPowerState;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Stateful Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.infrastructure.impl.StatefulPowerConsumingResourceImpl#getPowerState
 * <em>Power State</em>}</li>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.StatefulPowerConsumingResourceImpl#getStatefulResourcePowerBinding
 * <em>Stateful Resource Power Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatefulPowerConsumingResourceImpl extends AbstractPowerConsumingResourceImpl
        implements StatefulPowerConsumingResource {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected StatefulPowerConsumingResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractPowerState getPowerState() {
        return (AbstractPowerState) this.eDynamicGet(
                InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
                InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AbstractPowerState basicGetPowerState() {
        return (AbstractPowerState) this.eDynamicGet(
                InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
                InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPowerState(final AbstractPowerState newPowerState) {
        this.eDynamicSet(InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
                InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE, newPowerState);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public StatefulResourcePowerBinding getStatefulResourcePowerBinding() {
        return (StatefulResourcePowerBinding) this.eDynamicGet(
                InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
                InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public StatefulResourcePowerBinding basicGetStatefulResourcePowerBinding() {
        return (StatefulResourcePowerBinding) this.eDynamicGet(
                InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
                InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
                false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStatefulResourcePowerBinding(final StatefulResourcePowerBinding newStatefulResourcePowerBinding) {
        this.eDynamicSet(InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
                InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
                newStatefulResourcePowerBinding);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE:
            if (resolve) {
                return this.getPowerState();
            }
            return this.basicGetPowerState();
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING:
            if (resolve) {
                return this.getStatefulResourcePowerBinding();
            }
            return this.basicGetStatefulResourcePowerBinding();
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
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE:
            this.setPowerState((AbstractPowerState) newValue);
            return;
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING:
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
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE:
            this.setPowerState((AbstractPowerState) null);
            return;
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING:
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
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE:
            return this.basicGetPowerState() != null;
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING:
            return this.basicGetStatefulResourcePowerBinding() != null;
        }
        return super.eIsSet(featureID);
    }

} // StatefulPowerConsumingResourceImpl
