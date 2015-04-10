/**
 */
package de.fzi.power.binding.impl;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.binding.PowerBindingRepository;

import de.fzi.power.util.impl.EntityImpl;

import java.util.Collection;

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
 * An implementation of the model object '<em><b>Power Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.binding.impl.PowerBindingImpl#getPowerBindingRepository <em>Power Binding Repository</em>}</li>
 *   <li>{@link de.fzi.power.binding.impl.PowerBindingImpl#getFixedFactorValues <em>Fixed Factor Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PowerBindingImpl extends EntityImpl implements PowerBinding {
    /**
     * The cached value of the '{@link #getFixedFactorValues() <em>Fixed Factor Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFixedFactorValues()
     * @generated
     * @ordered
     */
    protected EList<FixedFactorValue> fixedFactorValues;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerBindingRepository getPowerBindingRepository() {
        if (eContainerFeatureID() != BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY)
            return null;
        return (PowerBindingRepository) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerBindingRepository(PowerBindingRepository newPowerBindingRepository,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerBindingRepository,
                BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerBindingRepository(PowerBindingRepository newPowerBindingRepository) {
        if (newPowerBindingRepository != eInternalContainer()
                || (eContainerFeatureID() != BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY && newPowerBindingRepository != null)) {
            if (EcoreUtil.isAncestor(this, newPowerBindingRepository))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPowerBindingRepository != null)
                msgs = ((InternalEObject) newPowerBindingRepository).eInverseAdd(this,
                        BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS, PowerBindingRepository.class, msgs);
            msgs = basicSetPowerBindingRepository(newPowerBindingRepository, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY, newPowerBindingRepository,
                    newPowerBindingRepository));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<FixedFactorValue> getFixedFactorValues() {
        if (fixedFactorValues == null) {
            fixedFactorValues = new EObjectContainmentWithInverseEList<FixedFactorValue>(FixedFactorValue.class, this,
                    BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES, BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING);
        }
        return fixedFactorValues;
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerBindingRepository((PowerBindingRepository) otherEnd, msgs);
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getFixedFactorValues())
                    .basicAdd(otherEnd, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return basicSetPowerBindingRepository(null, msgs);
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            return ((InternalEList<?>) getFixedFactorValues()).basicRemove(otherEnd, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return eInternalContainer().eInverseRemove(this, BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS,
                    PowerBindingRepository.class, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return getPowerBindingRepository();
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            return getFixedFactorValues();
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            setPowerBindingRepository((PowerBindingRepository) newValue);
            return;
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            getFixedFactorValues().clear();
            getFixedFactorValues().addAll((Collection<? extends FixedFactorValue>) newValue);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            setPowerBindingRepository((PowerBindingRepository) null);
            return;
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            getFixedFactorValues().clear();
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return getPowerBindingRepository() != null;
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            return fixedFactorValues != null && !fixedFactorValues.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //PowerBindingImpl
