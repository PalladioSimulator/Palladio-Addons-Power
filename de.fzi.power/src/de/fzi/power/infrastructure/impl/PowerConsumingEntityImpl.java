/**
 */
package de.fzi.power.infrastructure.impl;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerProvidingEntity;

import de.fzi.power.util.impl.EntityImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Consuming Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingEntityImpl#getPowerProvidingEntity <em>Power Providing Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PowerConsumingEntityImpl extends EntityImpl implements PowerConsumingEntity {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PowerConsumingEntityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.POWER_CONSUMING_ENTITY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerProvidingEntity getPowerProvidingEntity() {
        if (eContainerFeatureID() != InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY)
            return null;
        return (PowerProvidingEntity) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerProvidingEntity(PowerProvidingEntity newPowerProvidingEntity,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerProvidingEntity,
                InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerProvidingEntity(PowerProvidingEntity newPowerProvidingEntity) {
        if (newPowerProvidingEntity != eInternalContainer()
                || (eContainerFeatureID() != InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY && newPowerProvidingEntity != null)) {
            if (EcoreUtil.isAncestor(this, newPowerProvidingEntity))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPowerProvidingEntity != null)
                msgs = ((InternalEObject) newPowerProvidingEntity).eInverseAdd(this,
                        InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
                        PowerProvidingEntity.class, msgs);
            msgs = basicSetPowerProvidingEntity(newPowerProvidingEntity, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY, newPowerProvidingEntity,
                    newPowerProvidingEntity));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerProvidingEntity((PowerProvidingEntity) otherEnd, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            return basicSetPowerProvidingEntity(null, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            return eInternalContainer().eInverseRemove(this,
                    InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
                    PowerProvidingEntity.class, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            return getPowerProvidingEntity();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            setPowerProvidingEntity((PowerProvidingEntity) newValue);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            setPowerProvidingEntity((PowerProvidingEntity) null);
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
        case InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY:
            return getPowerProvidingEntity() != null;
        }
        return super.eIsSet(featureID);
    }

} //PowerConsumingEntityImpl
