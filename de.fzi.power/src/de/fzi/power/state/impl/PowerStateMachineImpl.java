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
 * <li>{@link de.fzi.power.state.impl.PowerStateMachineImpl#getPowerStateRepository
 * <em>Power State Repository</em>}</li>
 * <li>{@link de.fzi.power.state.impl.PowerStateMachineImpl#getPowerStates <em>Power States</em>}
 * </li>
 * </ul>
 *
 * @generated
 */
public class PowerStateMachineImpl extends EntityImpl implements PowerStateMachine {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PowerStateMachineImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StatePackage.Literals.POWER_STATE_MACHINE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerStateRepository getPowerStateRepository() {
        return (PowerStateRepository) this.eDynamicGet(StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY,
                StatePackage.Literals.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetPowerStateRepository(final PowerStateRepository newPowerStateRepository,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPowerStateRepository,
                StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPowerStateRepository(final PowerStateRepository newPowerStateRepository) {
        this.eDynamicSet(StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY,
                StatePackage.Literals.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY, newPowerStateRepository);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<AbstractPowerState> getPowerStates() {
        return (EList<AbstractPowerState>) this.eDynamicGet(StatePackage.POWER_STATE_MACHINE__POWER_STATES,
                StatePackage.Literals.POWER_STATE_MACHINE__POWER_STATES, true, true);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetPowerStateRepository((PowerStateRepository) otherEnd, msgs);
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getPowerStates()).basicAdd(otherEnd, msgs);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            return this.basicSetPowerStateRepository(null, msgs);
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            return ((InternalEList<?>) this.getPowerStates()).basicRemove(otherEnd, msgs);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            return this.eInternalContainer().eInverseRemove(this,
                    StatePackage.POWER_STATE_REPOSITORY__POWER_STATE_MACHINES, PowerStateRepository.class, msgs);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            return this.getPowerStateRepository();
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            return this.getPowerStates();
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            this.setPowerStateRepository((PowerStateRepository) newValue);
            return;
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            this.getPowerStates().clear();
            this.getPowerStates().addAll((Collection<? extends AbstractPowerState>) newValue);
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            this.setPowerStateRepository((PowerStateRepository) null);
            return;
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            this.getPowerStates().clear();
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
        case StatePackage.POWER_STATE_MACHINE__POWER_STATE_REPOSITORY:
            return this.getPowerStateRepository() != null;
        case StatePackage.POWER_STATE_MACHINE__POWER_STATES:
            return !this.getPowerStates().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // PowerStateMachineImpl
