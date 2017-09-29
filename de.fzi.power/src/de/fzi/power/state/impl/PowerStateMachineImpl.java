/**
 */
package de.fzi.power.state.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.power.state.AbstractPowerState;
import de.fzi.power.state.PowerStateMachine;
import de.fzi.power.state.PowerStateRepository;
import de.fzi.power.state.StatePackage;
import de.fzi.power.util.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power State Machine</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.state.impl.PowerStateMachineImpl#getPowerStateRepository <em>Power State Repository</em>}</li>
 *   <li>{@link de.fzi.power.state.impl.PowerStateMachineImpl#getPowerStates <em>Power States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerStateMachineImpl extends EntityImpl implements PowerStateMachine {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected PowerStateMachineImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StatePackage.Literals.POWER_STATE_MACHINE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerStateRepository getPowerStateRepository() {
        return (PowerStateRepository) eDynamicGet(StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY,
                StatePackage.Literals.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPowerStateRepository(PowerStateRepository newPowerStateRepository,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newPowerStateRepository,
                StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPowerStateRepository(PowerStateRepository newPowerStateRepository) {
        eDynamicSet(StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY,
                StatePackage.Literals.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY, newPowerStateRepository);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<AbstractPowerState> getPowerStates() {
        return (EList<AbstractPowerState>) eDynamicGet(StatePackage.POWER_STATE_MACHINE__POWER_STATES,
                StatePackage.Literals.POWER_STATE_MACHINE__POWER_STATES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetPowerStateRepository((PowerStateRepository) otherEnd, msgs);
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getPowerStates()).basicAdd(otherEnd, msgs);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            return basicSetPowerStateRepository(null, msgs);
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            return ((InternalEList<?>) getPowerStates()).basicRemove(otherEnd, msgs);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            return eInternalContainer().eInverseRemove(this, StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES,
                    PowerStateRepository.class, msgs);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            return getPowerStateRepository();
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            return getPowerStates();
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            setPowerStateRepository((PowerStateRepository) newValue);
            return;
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            getPowerStates().clear();
            getPowerStates().addAll((Collection<? extends AbstractPowerState>) newValue);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            setPowerStateRepository((PowerStateRepository) null);
            return;
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            getPowerStates().clear();
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            return getPowerStateRepository() != null;
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            return !getPowerStates().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PowerStateMachineImpl
