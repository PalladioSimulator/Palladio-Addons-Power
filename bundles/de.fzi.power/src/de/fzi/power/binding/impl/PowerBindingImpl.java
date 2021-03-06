/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Power Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.PowerBindingImpl#getPowerBindingRepository <em>Power Binding Repository</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PowerBindingImpl extends EntityImpl implements PowerBinding {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected PowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerBindingRepository getPowerBindingRepository() {
        return (PowerBindingRepository) eDynamicGet(BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY,
                BindingPackage.Literals.POWER_BINDING__POWER_BINDING_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerBindingRepository(PowerBindingRepository newPowerBindingRepository,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerBindingRepository,
                BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerBindingRepository(PowerBindingRepository newPowerBindingRepository) {
        eDynamicSet(BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY,
                BindingPackage.Literals.POWER_BINDING__POWER_BINDING_REPOSITORY, newPowerBindingRepository);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerBindingRepository((PowerBindingRepository) otherEnd, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return basicSetPowerBindingRepository(null, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return eInternalContainer().eInverseRemove(this, BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS,
                    PowerBindingRepository.class, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return getPowerBindingRepository();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            setPowerBindingRepository((PowerBindingRepository) newValue);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            setPowerBindingRepository((PowerBindingRepository) null);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return getPowerBindingRepository() != null;
        }
        return super.eIsSet(featureID);
    }

} // PowerBindingImpl
