/**
 */
package de.fzi.power.infrastructure.impl;

import java.util.Collection;

import javax.measure.Measure;
import javax.measure.quantity.Power;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Providing Entity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.PowerProvidingEntityImpl#getNestedPowerConsumingEntities
 * <em>Nested Power Consuming Entities</em>}</li>
 * <li>{@link de.fzi.power.infrastructure.impl.PowerProvidingEntityImpl#getSuppliablePeakPower
 * <em>Suppliable Peak Power</em>}</li>
 * <li>{@link de.fzi.power.infrastructure.impl.PowerProvidingEntityImpl#getPowerInfrastructureModel
 * <em>Power Infrastructure Model</em>}</li>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.PowerProvidingEntityImpl#getDistributionPowerAssemblyContext
 * <em>Distribution Power Assembly Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PowerProvidingEntityImpl extends EntityImpl implements PowerProvidingEntity {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PowerProvidingEntityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<PowerConsumingEntity> getNestedPowerConsumingEntities() {
        return (EList<PowerConsumingEntity>) this.eDynamicGet(
                InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Measure<?, Power> getSuppliablePeakPower() {
        return (Measure<?, Power>) this.eDynamicGet(InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER,
                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSuppliablePeakPower(final Measure<?, Power> newSuppliablePeakPower) {
        this.eDynamicSet(InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER,
                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER, newSuppliablePeakPower);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PowerInfrastructureRepository getPowerInfrastructureModel() {
        return (PowerInfrastructureRepository) this.eDynamicGet(
                InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPowerInfrastructureModel(
            final PowerInfrastructureRepository newPowerInfrastructureModel, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPowerInfrastructureModel,
                InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPowerInfrastructureModel(final PowerInfrastructureRepository newPowerInfrastructureModel) {
        this.eDynamicSet(InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
                newPowerInfrastructureModel);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DistributionPowerBinding getDistributionPowerAssemblyContext() {
        return (DistributionPowerBinding) this.eDynamicGet(
                InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DistributionPowerBinding basicGetDistributionPowerAssemblyContext() {
        return (DistributionPowerBinding) this.eDynamicGet(
                InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT, false,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDistributionPowerAssemblyContext(
            final DistributionPowerBinding newDistributionPowerAssemblyContext) {
        this.eDynamicSet(InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
                newDistributionPowerAssemblyContext);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getNestedPowerConsumingEntities())
                    .basicAdd(otherEnd, msgs);
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetPowerInfrastructureModel((PowerInfrastructureRepository) otherEnd, msgs);
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
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            return ((InternalEList<?>) this.getNestedPowerConsumingEntities()).basicRemove(otherEnd, msgs);
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            return this.basicSetPowerInfrastructureModel(null, msgs);
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
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            return this.eInternalContainer().eInverseRemove(this,
                    InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES,
                    PowerInfrastructureRepository.class, msgs);
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
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            return this.getNestedPowerConsumingEntities();
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            return this.getSuppliablePeakPower();
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            return this.getPowerInfrastructureModel();
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
            if (resolve) {
                return this.getDistributionPowerAssemblyContext();
            }
            return this.basicGetDistributionPowerAssemblyContext();
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
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            this.getNestedPowerConsumingEntities().clear();
            this.getNestedPowerConsumingEntities().addAll((Collection<? extends PowerConsumingEntity>) newValue);
            return;
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            this.setSuppliablePeakPower((Measure<?, Power>) newValue);
            return;
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            this.setPowerInfrastructureModel((PowerInfrastructureRepository) newValue);
            return;
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
            this.setDistributionPowerAssemblyContext((DistributionPowerBinding) newValue);
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
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            this.getNestedPowerConsumingEntities().clear();
            return;
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            this.setSuppliablePeakPower((Measure<?, Power>) null);
            return;
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            this.setPowerInfrastructureModel((PowerInfrastructureRepository) null);
            return;
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
            this.setDistributionPowerAssemblyContext((DistributionPowerBinding) null);
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
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            return !this.getNestedPowerConsumingEntities().isEmpty();
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            return this.getSuppliablePeakPower() != null;
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            return this.getPowerInfrastructureModel() != null;
        case InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
            return this.basicGetDistributionPowerAssemblyContext() != null;
        }
        return super.eIsSet(featureID);
    }

} // PowerProvidingEntityImpl
