/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Consuming Entity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingEntityImpl#getPowerProvidingEntity
 * <em>Power Providing Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PowerConsumingEntityImpl extends EntityImpl implements PowerConsumingEntity {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PowerConsumingEntityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.POWER_CONSUMING_ENTITY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerProvidingEntity getPowerProvidingEntity() {
        return (PowerProvidingEntity) this.eDynamicGet(
                InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY,
                InfrastructurePackage.Literals.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetPowerProvidingEntity(final PowerProvidingEntity newPowerProvidingEntity,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPowerProvidingEntity,
                InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPowerProvidingEntity(final PowerProvidingEntity newPowerProvidingEntity) {
        this.eDynamicSet(InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY,
                InfrastructurePackage.Literals.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY, newPowerProvidingEntity);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetPowerProvidingEntity((PowerProvidingEntity) otherEnd, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            return this.basicSetPowerProvidingEntity(null, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            return this.eInternalContainer().eInverseRemove(this,
                    InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
                    PowerProvidingEntity.class, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            return this.getPowerProvidingEntity();
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            this.setPowerProvidingEntity((PowerProvidingEntity) newValue);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            this.setPowerProvidingEntity((PowerProvidingEntity) null);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            return this.getPowerProvidingEntity() != null;
        }
        return super.eIsSet(featureID);
    }

} // PowerConsumingEntityImpl
