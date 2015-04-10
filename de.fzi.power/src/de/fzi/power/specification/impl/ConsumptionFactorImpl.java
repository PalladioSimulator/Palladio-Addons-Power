/**
 */
package de.fzi.power.specification.impl;

import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;

import de.fzi.power.util.impl.EntityImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consumption Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.specification.impl.ConsumptionFactorImpl#getPowerModel <em>Power Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConsumptionFactorImpl extends EntityImpl implements ConsumptionFactor {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConsumptionFactorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpecificationPackage.Literals.CONSUMPTION_FACTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerModelSpecification getPowerModel() {
        if (eContainerFeatureID() != SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL)
            return null;
        return (PowerModelSpecification) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerModel(PowerModelSpecification newPowerModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerModel,
                SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerModel(PowerModelSpecification newPowerModel) {
        if (newPowerModel != eInternalContainer()
                || (eContainerFeatureID() != SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL && newPowerModel != null)) {
            if (EcoreUtil.isAncestor(this, newPowerModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPowerModel != null)
                msgs = ((InternalEObject) newPowerModel).eInverseAdd(this,
                        SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS,
                        PowerModelSpecification.class, msgs);
            msgs = basicSetPowerModel(newPowerModel, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL,
                    newPowerModel, newPowerModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerModel((PowerModelSpecification) otherEnd, msgs);
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            return basicSetPowerModel(null, msgs);
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            return eInternalContainer().eInverseRemove(this,
                    SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS, PowerModelSpecification.class,
                    msgs);
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            return getPowerModel();
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            setPowerModel((PowerModelSpecification) newValue);
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            setPowerModel((PowerModelSpecification) null);
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            return getPowerModel() != null;
        }
        return super.eIsSet(featureID);
    }

} //ConsumptionFactorImpl
