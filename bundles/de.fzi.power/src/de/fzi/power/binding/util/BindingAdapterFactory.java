/**
 */
package de.fzi.power.binding.util;

import javax.measure.quantity.Quantity;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.AbstractPowerStateBinding;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ConsumptionBehavior;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValueDimensionless;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.PowerFactorBinding;
import de.fzi.power.binding.PowerStateBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.binding.TransitionStateBinding;
import de.fzi.power.util.Entity;
import de.fzi.power.util.NamedElement;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see de.fzi.power.binding.BindingPackage
 * @generated
 */
public class BindingAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static BindingPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public BindingAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = BindingPackage.eINSTANCE;
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
    protected BindingSwitch<Adapter> modelSwitch = new BindingSwitch<Adapter>() {
        @Override
        public Adapter caseFixedFactorValuePower(FixedFactorValuePower object) {
            return createFixedFactorValuePowerAdapter();
        }

        @Override
        public Adapter casePowerBindingRepository(PowerBindingRepository object) {
            return createPowerBindingRepositoryAdapter();
        }

        @Override
        public Adapter casePowerBinding(PowerBinding object) {
            return createPowerBindingAdapter();
        }

        @Override
        public Adapter caseResourcePowerBinding(ResourcePowerBinding object) {
            return createResourcePowerBindingAdapter();
        }

        @Override
        public Adapter caseDistributionPowerBinding(DistributionPowerBinding object) {
            return createDistributionPowerBindingAdapter();
        }

        @Override
        public Adapter casePowerFactorBinding(PowerFactorBinding object) {
            return createPowerFactorBindingAdapter();
        }

        @Override
        public <Q extends Quantity> Adapter caseAbstractFixedFactorValue(AbstractFixedFactorValue<Q> object) {
            return createAbstractFixedFactorValueAdapter();
        }

        @Override
        public Adapter caseFixedFactorValueDimensionless(FixedFactorValueDimensionless object) {
            return createFixedFactorValueDimensionlessAdapter();
        }

        @Override
        public Adapter caseConsumptionBehavior(ConsumptionBehavior object) {
            return createConsumptionBehaviorAdapter();
        }

        @Override
        public Adapter caseStatefulResourcePowerBinding(StatefulResourcePowerBinding object) {
            return createStatefulResourcePowerBindingAdapter();
        }

        @Override
        public Adapter caseAbstractPowerStateBinding(AbstractPowerStateBinding object) {
            return createAbstractPowerStateBindingAdapter();
        }

        @Override
        public Adapter casePowerStateBinding(PowerStateBinding object) {
            return createPowerStateBindingAdapter();
        }

        @Override
        public Adapter caseTransitionStateBinding(TransitionStateBinding object) {
            return createTransitionStateBindingAdapter();
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
     * Creates a new adapter for an object of class '
     * {@link de.fzi.power.binding.FixedFactorValuePower <em>Fixed Factor Value Power</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.binding.FixedFactorValuePower
     * @generated
     */
    public Adapter createFixedFactorValuePowerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.power.binding.PowerBindingRepository <em>Power Binding Repository</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.binding.PowerBindingRepository
     * @generated
     */
    public Adapter createPowerBindingRepositoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.PowerBinding <em>Power Binding</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.PowerBinding
     * @generated
     */
    public Adapter createPowerBindingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.power.binding.ResourcePowerBinding <em>Resource Power Binding</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.binding.ResourcePowerBinding
     * @generated
     */
    public Adapter createResourcePowerBindingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.DistributionPowerBinding <em>Distribution Power Binding</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.DistributionPowerBinding
     * @generated
     */
    public Adapter createDistributionPowerBindingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.StatefulResourcePowerBinding <em>Stateful Resource Power Binding</em>}'.
     * <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.StatefulResourcePowerBinding
     * @generated
     */
    public Adapter createStatefulResourcePowerBindingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.AbstractPowerStateBinding <em>Abstract Power State Binding</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.AbstractPowerStateBinding
     * @generated
     */
    public Adapter createAbstractPowerStateBindingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.PowerStateBinding <em>Power State Binding</em>}'.
     * <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.PowerStateBinding
     * @generated
     */
    public Adapter createPowerStateBindingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.power.binding.TransitionStateBinding <em>Transition State Binding</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.binding.TransitionStateBinding
     * @generated
     */
    public Adapter createTransitionStateBindingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.PowerFactorBinding <em>Power Factor Binding</em>}'.
     * <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.PowerFactorBinding
     * @generated
     */
    public Adapter createPowerFactorBindingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.AbstractFixedFactorValue <em>Abstract Fixed Factor Value</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.AbstractFixedFactorValue
     * @generated
     */
    public Adapter createAbstractFixedFactorValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.FixedFactorValueDimensionless <em>Fixed Factor Value Dimensionless</em>}'.
     * <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.FixedFactorValueDimensionless
     * @generated
     */
    public Adapter createFixedFactorValueDimensionlessAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.binding.ConsumptionBehavior <em>Consumption Behavior</em>}'.
     * <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fzi.power.binding.ConsumptionBehavior
     * @generated
     */
    public Adapter createConsumptionBehaviorAdapter() {
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

} // BindingAdapterFactory
