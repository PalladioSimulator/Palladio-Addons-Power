/**
 */
package de.fzi.power.state.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.fzi.power.state.AbstractPowerState;
import de.fzi.power.state.PowerState;
import de.fzi.power.state.PowerStateMachine;
import de.fzi.power.state.PowerStateRepository;
import de.fzi.power.state.StatePackage;
import de.fzi.power.state.TransitionState;
import de.fzi.power.util.Entity;
import de.fzi.power.util.NamedElement;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see de.fzi.power.state.StatePackage
 * @generated
 */
public class StateAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static StatePackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public StateAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = StatePackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected StateSwitch<Adapter> modelSwitch = new StateSwitch<Adapter>() {
        @Override
        public Adapter casePowerStateRepository(PowerStateRepository object) {
            return createPowerStateRepositoryAdapter();
        }

        @Override
        public Adapter caseAbstractPowerState(AbstractPowerState object) {
            return createAbstractPowerStateAdapter();
        }

        @Override
        public Adapter caseTransitionState(TransitionState object) {
            return createTransitionStateAdapter();
        }

        @Override
        public Adapter casePowerState(PowerState object) {
            return createPowerStateAdapter();
        }

        @Override
        public Adapter casePowerStateMachine(PowerStateMachine object) {
            return createPowerStateMachineAdapter();
        }

        @Override
        public Adapter caseIdentifier(Identifier object) {
            return createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(NamedElement object) {
            return createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(Entity object) {
            return createEntityAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.state.PowerStateRepository <em>Power State Repository</em>}'.
     * <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.state.PowerStateRepository
     * @generated
     */
    public Adapter createPowerStateRepositoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.state.AbstractPowerState <em>Abstract Power State</em>}'.
     * <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.state.AbstractPowerState
     * @generated
     */
    public Adapter createAbstractPowerStateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.state.TransitionState <em>Transition State</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.state.TransitionState
     * @generated
     */
    public Adapter createTransitionStateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.state.PowerState <em>Power State</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.state.PowerState
     * @generated
     */
    public Adapter createPowerStateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.state.PowerStateMachine <em>Power State Machine</em>}'.
     * <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.state.PowerStateMachine
     * @generated
     */
    public Adapter createPowerStateMachineAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.util.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.util.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.util.Entity <em>Entity</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.util.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // StateAdapterFactory
