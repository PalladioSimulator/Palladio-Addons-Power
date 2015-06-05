/**
 */
package de.fzi.power.specification.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Consumption Factor</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.power.specification.impl.ConsumptionFactorImpl#getPowerModel <em>Power Model
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConsumptionFactorImpl extends EntityImpl implements ConsumptionFactor {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConsumptionFactorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpecificationPackage.Literals.CONSUMPTION_FACTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PowerModelSpecification getPowerModel() {
        if (this.eContainerFeatureID() != SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL) {
            return null;
        }
        return (PowerModelSpecification) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPowerModel(final PowerModelSpecification newPowerModel, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPowerModel,
                SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPowerModel(final PowerModelSpecification newPowerModel) {
        if (newPowerModel != this.eInternalContainer()
                || (this.eContainerFeatureID() != SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL && newPowerModel != null))
        {
            if (EcoreUtil.isAncestor(this, newPowerModel)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newPowerModel != null) {
                msgs = ((InternalEObject) newPowerModel).eInverseAdd(this,
                        SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS,
                        PowerModelSpecification.class, msgs);
            }
            msgs = this.basicSetPowerModel(newPowerModel, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        }
        else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL,
                    newPowerModel, newPowerModel));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID)
        {
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetPowerModel((PowerModelSpecification) otherEnd, msgs);
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            return this.basicSetPowerModel(null, msgs);
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
        switch (this.eContainerFeatureID())
        {
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            return this.eInternalContainer().eInverseRemove(this,
                    SpecificationPackage.POWER_MODEL_SPECIFICATION__CONSUMPTION_FACTORS, PowerModelSpecification.class,
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
        switch (featureID)
        {
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            return this.getPowerModel();
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
        switch (featureID)
        {
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            this.setPowerModel((PowerModelSpecification) newValue);
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            this.setPowerModel((PowerModelSpecification) null);
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
        case SpecificationPackage.CONSUMPTION_FACTOR__POWER_MODEL:
            return this.getPowerModel() != null;
        }
        return super.eIsSet(featureID);
    }

} // ConsumptionFactorImpl
