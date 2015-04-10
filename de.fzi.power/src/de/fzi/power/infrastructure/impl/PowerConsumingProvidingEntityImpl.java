/**
 */
package de.fzi.power.infrastructure.impl;

import de.fzi.power.binding.DistributionPowerBinding;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;

import java.util.Collection;

import javax.measure.Measure;

import javax.measure.quantity.Power;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Consuming Providing Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl#getNestedPowerConsumingEntities <em>Nested Power Consuming Entities</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl#getSuppliablePeakPower <em>Suppliable Peak Power</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl#getPowerInfrastructureModel <em>Power Infrastructure Model</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingProvidingEntityImpl#getDistributionPowerAssemblyContext <em>Distribution Power Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PowerConsumingProvidingEntityImpl extends PowerConsumingEntityImpl implements
        PowerConsumingProvidingEntity {
    /**
     * The cached value of the '{@link #getNestedPowerConsumingEntities() <em>Nested Power Consuming Entities</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNestedPowerConsumingEntities()
     * @generated
     * @ordered
     */
    protected EList<PowerConsumingEntity> nestedPowerConsumingEntities;

    /**
     * The cached value of the '{@link #getSuppliablePeakPower() <em>Suppliable Peak Power</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSuppliablePeakPower()
     * @generated
     * @ordered
     */
    protected Measure<?, Power> suppliablePeakPower;

    /**
     * The cached value of the '{@link #getDistributionPowerAssemblyContext() <em>Distribution Power Assembly Context</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDistributionPowerAssemblyContext()
     * @generated
     * @ordered
     */
    protected DistributionPowerBinding distributionPowerAssemblyContext;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PowerConsumingProvidingEntityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.POWER_CONSUMING_PROVIDING_ENTITY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<PowerConsumingEntity> getNestedPowerConsumingEntities() {
        if (nestedPowerConsumingEntities == null) {
            nestedPowerConsumingEntities = new EObjectContainmentWithInverseEList<PowerConsumingEntity>(
                    PowerConsumingEntity.class, this,
                    InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
                    InfrastructurePackage.POWER_CONSUMING_ENTITY__POWER_PROVIDING_ENTITY);
        }
        return nestedPowerConsumingEntities;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Measure<?, Power> getSuppliablePeakPower() {
        return suppliablePeakPower;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSuppliablePeakPower(Measure<?, Power> newSuppliablePeakPower) {
        Measure<?, Power> oldSuppliablePeakPower = suppliablePeakPower;
        suppliablePeakPower = newSuppliablePeakPower;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER,
                    oldSuppliablePeakPower, suppliablePeakPower));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerInfrastructureRepository getPowerInfrastructureModel() {
        if (eContainerFeatureID() != InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL)
            return null;
        return (PowerInfrastructureRepository) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerInfrastructureModel(
            PowerInfrastructureRepository newPowerInfrastructureModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerInfrastructureModel,
                InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerInfrastructureModel(PowerInfrastructureRepository newPowerInfrastructureModel) {
        if (newPowerInfrastructureModel != eInternalContainer()
                || (eContainerFeatureID() != InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL && newPowerInfrastructureModel != null)) {
            if (EcoreUtil.isAncestor(this, newPowerInfrastructureModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPowerInfrastructureModel != null)
                msgs = ((InternalEObject) newPowerInfrastructureModel).eInverseAdd(this,
                        InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES,
                        PowerInfrastructureRepository.class, msgs);
            msgs = basicSetPowerInfrastructureModel(newPowerInfrastructureModel, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL,
                    newPowerInfrastructureModel, newPowerInfrastructureModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DistributionPowerBinding getDistributionPowerAssemblyContext() {
        if (distributionPowerAssemblyContext != null && distributionPowerAssemblyContext.eIsProxy()) {
            InternalEObject oldDistributionPowerAssemblyContext = (InternalEObject) distributionPowerAssemblyContext;
            distributionPowerAssemblyContext = (DistributionPowerBinding) eResolveProxy(oldDistributionPowerAssemblyContext);
            if (distributionPowerAssemblyContext != oldDistributionPowerAssemblyContext) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
                            oldDistributionPowerAssemblyContext, distributionPowerAssemblyContext));
            }
        }
        return distributionPowerAssemblyContext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DistributionPowerBinding basicGetDistributionPowerAssemblyContext() {
        return distributionPowerAssemblyContext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDistributionPowerAssemblyContext(DistributionPowerBinding newDistributionPowerAssemblyContext) {
        DistributionPowerBinding oldDistributionPowerAssemblyContext = distributionPowerAssemblyContext;
        distributionPowerAssemblyContext = newDistributionPowerAssemblyContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
                    oldDistributionPowerAssemblyContext, distributionPowerAssemblyContext));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getNestedPowerConsumingEntities()).basicAdd(
                    otherEnd, msgs);
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerInfrastructureModel((PowerInfrastructureRepository) otherEnd, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            return ((InternalEList<?>) getNestedPowerConsumingEntities()).basicRemove(otherEnd, msgs);
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            return basicSetPowerInfrastructureModel(null, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            return eInternalContainer().eInverseRemove(this,
                    InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY__CONTAINED_POWER_PROVIDING_ENTITIES,
                    PowerInfrastructureRepository.class, msgs);
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
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            return getNestedPowerConsumingEntities();
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            return getSuppliablePeakPower();
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            return getPowerInfrastructureModel();
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
            if (resolve)
                return getDistributionPowerAssemblyContext();
            return basicGetDistributionPowerAssemblyContext();
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
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            getNestedPowerConsumingEntities().clear();
            getNestedPowerConsumingEntities().addAll((Collection<? extends PowerConsumingEntity>) newValue);
            return;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            setSuppliablePeakPower((Measure<?, Power>) newValue);
            return;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            setPowerInfrastructureModel((PowerInfrastructureRepository) newValue);
            return;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
            setDistributionPowerAssemblyContext((DistributionPowerBinding) newValue);
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
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            getNestedPowerConsumingEntities().clear();
            return;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            setSuppliablePeakPower((Measure<?, Power>) null);
            return;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            setPowerInfrastructureModel((PowerInfrastructureRepository) null);
            return;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
            setDistributionPowerAssemblyContext((DistributionPowerBinding) null);
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
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            return nestedPowerConsumingEntities != null && !nestedPowerConsumingEntities.isEmpty();
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            return suppliablePeakPower != null;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
            return getPowerInfrastructureModel() != null;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
            return distributionPowerAssemblyContext != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == PowerProvidingEntity.class) {
            switch (derivedFeatureID) {
            case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
                return InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES;
            case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
                return InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER;
            case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
                return InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL;
            case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
                return InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == PowerProvidingEntity.class) {
            switch (baseFeatureID) {
            case InfrastructurePackage.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
                return InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES;
            case InfrastructurePackage.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
                return InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER;
            case InfrastructurePackage.POWER_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL:
                return InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__POWER_INFRASTRUCTURE_MODEL;
            case InfrastructurePackage.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT:
                return InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (suppliablePeakPower: ");
        result.append(suppliablePeakPower);
        result.append(')');
        return result.toString();
    }

} //PowerConsumingProvidingEntityImpl
