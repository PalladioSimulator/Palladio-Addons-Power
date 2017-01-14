/**
 */
package de.fzi.power.state.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.state.PowerStateMachine;
import de.fzi.power.state.PowerStateRepository;
import de.fzi.power.state.StatePackage;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power State Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.state.impl.PowerStateRepositoryImpl#getPowerStateMachines
 * <em>Power State Machines</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerStateRepositoryImpl extends EntityImpl implements PowerStateRepository {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PowerStateRepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StatePackage.Literals.POWER_STATE_REPOSITORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<PowerStateMachine> getPowerStateMachines() {
        return (EList<PowerStateMachine>) this.eDynamicGet(StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES,
                StatePackage.Literals.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES, true, true);
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
        switch (featureID) {
        case StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getPowerStateMachines()).basicAdd(otherEnd,
                    msgs);
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
        case StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES:
            return ((InternalEList<?>) this.getPowerStateMachines()).basicRemove(otherEnd, msgs);
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
        switch (featureID) {
        case StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES:
            return this.getPowerStateMachines();
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
        case StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES:
            this.getPowerStateMachines().clear();
            this.getPowerStateMachines().addAll((Collection<? extends PowerStateMachine>) newValue);
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
        case StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES:
            this.getPowerStateMachines().clear();
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
        case StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES:
            return !this.getPowerStateMachines().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PowerStateRepositoryImpl
