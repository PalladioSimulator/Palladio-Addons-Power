/**
 */
package de.fzi.power.infrastructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Infrastructure Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.PowerInfrastructureRepositoryImpl#getContainedPowerProvidingEntities
 * <em>Contained Power Providing Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerInfrastructureRepositoryImpl extends MinimalEObjectImpl.Container implements
PowerInfrastructureRepository {
    /**
     * The cached value of the '{@link #getContainedPowerProvidingEntities()
     * <em>Contained Power Providing Entities</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getContainedPowerProvidingEntities()
     * @generated
     * @ordered
     */
    protected EList<PowerProvidingEntity> containedPowerProvidingEntities;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PowerInfrastructureRepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.POWER_INFRASTRUCTURE_REPOSITORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<PowerProvidingEntity> getContainedPowerProvidingEntities() {
        if (this.containedPowerProvidingEntities == null)
        {
            this.containedPowerProvidingEntities = new EObjectContainmentWithInverseEList<PowerProvidingEntity>(
                    PowerProvidingEntity.class, this,
                    InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES,
                    InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL);
        }
        return this.containedPowerProvidingEntities;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID)
        {
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getContainedPowerProvidingEntities())
                    .basicAdd(
                            otherEnd, msgs);
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
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES:
            return ((InternalEList<?>) this.getContainedPowerProvidingEntities()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES:
            return this.getContainedPowerProvidingEntities();
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
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES:
            this.getContainedPowerProvidingEntities().clear();
            this.getContainedPowerProvidingEntities().addAll((Collection<? extends PowerProvidingEntity>) newValue);
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
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES:
            this.getContainedPowerProvidingEntities().clear();
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
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES:
            return this.containedPowerProvidingEntities != null && !this.containedPowerProvidingEntities.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PowerInfrastructureRepositoryImpl
