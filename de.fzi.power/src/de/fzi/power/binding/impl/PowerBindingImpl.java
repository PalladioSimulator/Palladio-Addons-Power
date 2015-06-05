/**
 */
package de.fzi.power.binding.impl;

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

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Power Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.power.binding.impl.PowerBindingImpl#getPowerBindingRepository <em>Power Binding
 * Repository</em>}</li>
 * <li>{@link de.fzi.power.binding.impl.PowerBindingImpl#getFixedFactorValues <em>Fixed Factor
 * Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PowerBindingImpl extends EntityImpl implements PowerBinding {
    /**
     * The cached value of the '{@link #getFixedFactorValues() <em>Fixed Factor Values</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFixedFactorValues()
     * @generated
     * @ordered
     */
    protected EList<FixedFactorValue> fixedFactorValues;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PowerBindingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BindingPackage.Literals.POWER_BINDING;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PowerBindingRepository getPowerBindingRepository() {
        if (this.eContainerFeatureID() != BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY) {
            return null;
        }
        return (PowerBindingRepository) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPowerBindingRepository(final PowerBindingRepository newPowerBindingRepository,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPowerBindingRepository,
                BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPowerBindingRepository(final PowerBindingRepository newPowerBindingRepository) {
        if (newPowerBindingRepository != this.eInternalContainer()
                || (this.eContainerFeatureID() != BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY && newPowerBindingRepository != null))
        {
            if (EcoreUtil.isAncestor(this, newPowerBindingRepository)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newPowerBindingRepository != null) {
                msgs = ((InternalEObject) newPowerBindingRepository).eInverseAdd(this,
                        BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS, PowerBindingRepository.class, msgs);
            }
            msgs = this.basicSetPowerBindingRepository(newPowerBindingRepository, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        }
        else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY, newPowerBindingRepository,
                    newPowerBindingRepository));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<FixedFactorValue> getFixedFactorValues() {
        if (this.fixedFactorValues == null)
        {
            this.fixedFactorValues = new EObjectContainmentWithInverseEList<FixedFactorValue>(FixedFactorValue.class,
                    this,
                    BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES, BindingPackage.FIXED_FACTOR_VALUE__POWER_BINDING);
        }
        return this.fixedFactorValues;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID)
        {
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetPowerBindingRepository((PowerBindingRepository) otherEnd, msgs);
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getFixedFactorValues())
                    .basicAdd(otherEnd, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return this.basicSetPowerBindingRepository(null, msgs);
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            return ((InternalEList<?>) this.getFixedFactorValues()).basicRemove(otherEnd, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return this.eInternalContainer().eInverseRemove(this,
                    BindingPackage.POWER_BINDING_REPOSITORY__POWER_BINDINGS,
                    PowerBindingRepository.class, msgs);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return this.getPowerBindingRepository();
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            return this.getFixedFactorValues();
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            this.setPowerBindingRepository((PowerBindingRepository) newValue);
            return;
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            this.getFixedFactorValues().clear();
            this.getFixedFactorValues().addAll((Collection<? extends FixedFactorValue>) newValue);
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            this.setPowerBindingRepository((PowerBindingRepository) null);
            return;
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            this.getFixedFactorValues().clear();
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
        case BindingPackage.POWER_BINDING__POWER_BINDING_REPOSITORY:
            return this.getPowerBindingRepository() != null;
        case BindingPackage.POWER_BINDING__FIXED_FACTOR_VALUES:
            return this.fixedFactorValues != null && !this.fixedFactorValues.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PowerBindingImpl
