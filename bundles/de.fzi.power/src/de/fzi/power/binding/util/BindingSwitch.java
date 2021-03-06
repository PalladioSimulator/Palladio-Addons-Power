/**
 */
package de.fzi.power.binding.util;

import javax.measure.quantity.Quantity;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fzi.power.binding.BindingPackage
 * @generated
 */
public class BindingSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static BindingPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public BindingSwitch() {
        if (modelPackage == null) {
            modelPackage = BindingPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case BindingPackage.FIXED_FACTOR_VALUE_POWER: {
            FixedFactorValuePower fixedFactorValuePower = (FixedFactorValuePower) theEObject;
            T result = caseFixedFactorValuePower(fixedFactorValuePower);
            if (result == null)
                result = caseAbstractFixedFactorValue(fixedFactorValuePower);
            if (result == null)
                result = caseIdentifier(fixedFactorValuePower);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.POWER_BINDING_REPOSITORY: {
            PowerBindingRepository powerBindingRepository = (PowerBindingRepository) theEObject;
            T result = casePowerBindingRepository(powerBindingRepository);
            if (result == null)
                result = caseIdentifier(powerBindingRepository);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.POWER_BINDING: {
            PowerBinding powerBinding = (PowerBinding) theEObject;
            T result = casePowerBinding(powerBinding);
            if (result == null)
                result = caseEntity(powerBinding);
            if (result == null)
                result = caseIdentifier(powerBinding);
            if (result == null)
                result = caseNamedElement(powerBinding);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.RESOURCE_POWER_BINDING: {
            ResourcePowerBinding resourcePowerBinding = (ResourcePowerBinding) theEObject;
            T result = caseResourcePowerBinding(resourcePowerBinding);
            if (result == null)
                result = casePowerFactorBinding(resourcePowerBinding);
            if (result == null)
                result = casePowerBinding(resourcePowerBinding);
            if (result == null)
                result = caseEntity(resourcePowerBinding);
            if (result == null)
                result = caseIdentifier(resourcePowerBinding);
            if (result == null)
                result = caseNamedElement(resourcePowerBinding);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.DISTRIBUTION_POWER_BINDING: {
            DistributionPowerBinding distributionPowerBinding = (DistributionPowerBinding) theEObject;
            T result = caseDistributionPowerBinding(distributionPowerBinding);
            if (result == null)
                result = casePowerFactorBinding(distributionPowerBinding);
            if (result == null)
                result = casePowerBinding(distributionPowerBinding);
            if (result == null)
                result = caseEntity(distributionPowerBinding);
            if (result == null)
                result = caseIdentifier(distributionPowerBinding);
            if (result == null)
                result = caseNamedElement(distributionPowerBinding);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.POWER_FACTOR_BINDING: {
            PowerFactorBinding powerFactorBinding = (PowerFactorBinding) theEObject;
            T result = casePowerFactorBinding(powerFactorBinding);
            if (result == null)
                result = casePowerBinding(powerFactorBinding);
            if (result == null)
                result = caseEntity(powerFactorBinding);
            if (result == null)
                result = caseIdentifier(powerFactorBinding);
            if (result == null)
                result = caseNamedElement(powerFactorBinding);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE: {
            AbstractFixedFactorValue<?> abstractFixedFactorValue = (AbstractFixedFactorValue<?>) theEObject;
            T result = caseAbstractFixedFactorValue(abstractFixedFactorValue);
            if (result == null)
                result = caseIdentifier(abstractFixedFactorValue);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.FIXED_FACTOR_VALUE_DIMENSIONLESS: {
            FixedFactorValueDimensionless fixedFactorValueDimensionless = (FixedFactorValueDimensionless) theEObject;
            T result = caseFixedFactorValueDimensionless(fixedFactorValueDimensionless);
            if (result == null)
                result = caseAbstractFixedFactorValue(fixedFactorValueDimensionless);
            if (result == null)
                result = caseIdentifier(fixedFactorValueDimensionless);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.CONSUMPTION_BEHAVIOR: {
            ConsumptionBehavior consumptionBehavior = (ConsumptionBehavior) theEObject;
            T result = caseConsumptionBehavior(consumptionBehavior);
            if (result == null)
                result = caseEntity(consumptionBehavior);
            if (result == null)
                result = caseIdentifier(consumptionBehavior);
            if (result == null)
                result = caseNamedElement(consumptionBehavior);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING: {
            StatefulResourcePowerBinding statefulResourcePowerBinding = (StatefulResourcePowerBinding) theEObject;
            T result = caseStatefulResourcePowerBinding(statefulResourcePowerBinding);
            if (result == null)
                result = casePowerBinding(statefulResourcePowerBinding);
            if (result == null)
                result = caseEntity(statefulResourcePowerBinding);
            if (result == null)
                result = caseIdentifier(statefulResourcePowerBinding);
            if (result == null)
                result = caseNamedElement(statefulResourcePowerBinding);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.ABSTRACT_POWER_STATE_BINDING: {
            AbstractPowerStateBinding abstractPowerStateBinding = (AbstractPowerStateBinding) theEObject;
            T result = caseAbstractPowerStateBinding(abstractPowerStateBinding);
            if (result == null)
                result = caseEntity(abstractPowerStateBinding);
            if (result == null)
                result = caseIdentifier(abstractPowerStateBinding);
            if (result == null)
                result = caseNamedElement(abstractPowerStateBinding);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.POWER_STATE_BINDING: {
            PowerStateBinding powerStateBinding = (PowerStateBinding) theEObject;
            T result = casePowerStateBinding(powerStateBinding);
            if (result == null)
                result = caseAbstractPowerStateBinding(powerStateBinding);
            if (result == null)
                result = caseEntity(powerStateBinding);
            if (result == null)
                result = caseIdentifier(powerStateBinding);
            if (result == null)
                result = caseNamedElement(powerStateBinding);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case BindingPackage.TRANSITION_STATE_BINDING: {
            TransitionStateBinding transitionStateBinding = (TransitionStateBinding) theEObject;
            T result = caseTransitionStateBinding(transitionStateBinding);
            if (result == null)
                result = caseAbstractPowerStateBinding(transitionStateBinding);
            if (result == null)
                result = caseEntity(transitionStateBinding);
            if (result == null)
                result = caseIdentifier(transitionStateBinding);
            if (result == null)
                result = caseNamedElement(transitionStateBinding);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Fixed Factor Value Power</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Fixed Factor Value Power</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFixedFactorValuePower(FixedFactorValuePower object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Binding Repository</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Binding Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerBindingRepository(PowerBindingRepository object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Binding</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerBinding(PowerBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Power Binding</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Power Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourcePowerBinding(ResourcePowerBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Distribution Power Binding</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Distribution Power Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDistributionPowerBinding(DistributionPowerBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Stateful Resource Power Binding</em>'.
     * <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Stateful Resource Power Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStatefulResourcePowerBinding(StatefulResourcePowerBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Power State Binding</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Power State Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractPowerStateBinding(AbstractPowerStateBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power State Binding</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power State Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerStateBinding(PowerStateBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Transition State Binding</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transition State Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTransitionStateBinding(TransitionStateBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Factor Binding</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Factor Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerFactorBinding(PowerFactorBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Fixed Factor Value</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Fixed Factor Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <Q extends Quantity> T caseAbstractFixedFactorValue(AbstractFixedFactorValue<Q> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Fixed Factor Value Dimensionless</em>'.
     * <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Fixed Factor Value Dimensionless</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFixedFactorValueDimensionless(FixedFactorValueDimensionless object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Consumption Behavior</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Consumption Behavior</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConsumptionBehavior(ConsumptionBehavior object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // BindingSwitch
