/**
 */
package de.fzi.power.binding.util;

import javax.measure.quantity.Quantity;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.AbstractPowerState;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ConsumptionBehavior;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValueDimensionless;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.PowerBinding;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.PowerFactorBinding;
import de.fzi.power.binding.PowerState;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.binding.TransitionState;
import de.fzi.power.util.Entity;
import de.fzi.power.util.NamedElement;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see de.fzi.power.binding.BindingPackage
 * @generated
 */
public class BindingSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static BindingPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public BindingSwitch() {
        if (modelPackage == null) {
            modelPackage = BindingPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case BindingPackage.FIXED_FACTOR_VALUE_POWER: {
            final FixedFactorValuePower fixedFactorValuePower = (FixedFactorValuePower) theEObject;
            T result = this.caseFixedFactorValuePower(fixedFactorValuePower);
            if (result == null) {
                result = this.caseAbstractFixedFactorValue(fixedFactorValuePower);
            }
            if (result == null) {
                result = this.caseIdentifier(fixedFactorValuePower);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.POWER_BINDING_REPOSITORY: {
            final PowerBindingRepository powerBindingRepository = (PowerBindingRepository) theEObject;
            T result = this.casePowerBindingRepository(powerBindingRepository);
            if (result == null) {
                result = this.caseIdentifier(powerBindingRepository);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.POWER_BINDING: {
            final PowerBinding powerBinding = (PowerBinding) theEObject;
            T result = this.casePowerBinding(powerBinding);
            if (result == null) {
                result = this.caseEntity(powerBinding);
            }
            if (result == null) {
                result = this.caseIdentifier(powerBinding);
            }
            if (result == null) {
                result = this.caseNamedElement(powerBinding);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.RESOURCE_POWER_BINDING: {
            final ResourcePowerBinding resourcePowerBinding = (ResourcePowerBinding) theEObject;
            T result = this.caseResourcePowerBinding(resourcePowerBinding);
            if (result == null) {
                result = this.casePowerFactorBinding(resourcePowerBinding);
            }
            if (result == null) {
                result = this.casePowerBinding(resourcePowerBinding);
            }
            if (result == null) {
                result = this.caseEntity(resourcePowerBinding);
            }
            if (result == null) {
                result = this.caseIdentifier(resourcePowerBinding);
            }
            if (result == null) {
                result = this.caseNamedElement(resourcePowerBinding);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.DISTRIBUTION_POWER_BINDING: {
            final DistributionPowerBinding distributionPowerBinding = (DistributionPowerBinding) theEObject;
            T result = this.caseDistributionPowerBinding(distributionPowerBinding);
            if (result == null) {
                result = this.casePowerFactorBinding(distributionPowerBinding);
            }
            if (result == null) {
                result = this.casePowerBinding(distributionPowerBinding);
            }
            if (result == null) {
                result = this.caseEntity(distributionPowerBinding);
            }
            if (result == null) {
                result = this.caseIdentifier(distributionPowerBinding);
            }
            if (result == null) {
                result = this.caseNamedElement(distributionPowerBinding);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.ABSTRACT_POWER_STATE: {
            final AbstractPowerState abstractPowerState = (AbstractPowerState) theEObject;
            T result = this.caseAbstractPowerState(abstractPowerState);
            if (result == null) {
                result = this.caseEntity(abstractPowerState);
            }
            if (result == null) {
                result = this.caseIdentifier(abstractPowerState);
            }
            if (result == null) {
                result = this.caseNamedElement(abstractPowerState);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING: {
            final StatefulResourcePowerBinding statefulResourcePowerBinding = (StatefulResourcePowerBinding) theEObject;
            T result = this.caseStatefulResourcePowerBinding(statefulResourcePowerBinding);
            if (result == null) {
                result = this.casePowerBinding(statefulResourcePowerBinding);
            }
            if (result == null) {
                result = this.caseEntity(statefulResourcePowerBinding);
            }
            if (result == null) {
                result = this.caseIdentifier(statefulResourcePowerBinding);
            }
            if (result == null) {
                result = this.caseNamedElement(statefulResourcePowerBinding);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.POWER_FACTOR_BINDING: {
            final PowerFactorBinding powerFactorBinding = (PowerFactorBinding) theEObject;
            T result = this.casePowerFactorBinding(powerFactorBinding);
            if (result == null) {
                result = this.casePowerBinding(powerFactorBinding);
            }
            if (result == null) {
                result = this.caseEntity(powerFactorBinding);
            }
            if (result == null) {
                result = this.caseIdentifier(powerFactorBinding);
            }
            if (result == null) {
                result = this.caseNamedElement(powerFactorBinding);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE: {
            final AbstractFixedFactorValue<?> abstractFixedFactorValue = (AbstractFixedFactorValue<?>) theEObject;
            T result = this.caseAbstractFixedFactorValue(abstractFixedFactorValue);
            if (result == null) {
                result = this.caseIdentifier(abstractFixedFactorValue);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.FIXED_FACTOR_VALUE_DIMENSIONLESS: {
            final FixedFactorValueDimensionless fixedFactorValueDimensionless = (FixedFactorValueDimensionless) theEObject;
            T result = this.caseFixedFactorValueDimensionless(fixedFactorValueDimensionless);
            if (result == null) {
                result = this.caseAbstractFixedFactorValue(fixedFactorValueDimensionless);
            }
            if (result == null) {
                result = this.caseIdentifier(fixedFactorValueDimensionless);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.TRANSITION_STATE: {
            final TransitionState transitionState = (TransitionState) theEObject;
            T result = this.caseTransitionState(transitionState);
            if (result == null) {
                result = this.caseAbstractPowerState(transitionState);
            }
            if (result == null) {
                result = this.caseEntity(transitionState);
            }
            if (result == null) {
                result = this.caseIdentifier(transitionState);
            }
            if (result == null) {
                result = this.caseNamedElement(transitionState);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.CONSUMPTION_BEHAVIOR: {
            final ConsumptionBehavior consumptionBehavior = (ConsumptionBehavior) theEObject;
            T result = this.caseConsumptionBehavior(consumptionBehavior);
            if (result == null) {
                result = this.caseEntity(consumptionBehavior);
            }
            if (result == null) {
                result = this.caseIdentifier(consumptionBehavior);
            }
            if (result == null) {
                result = this.caseNamedElement(consumptionBehavior);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case BindingPackage.POWER_STATE: {
            final PowerState powerState = (PowerState) theEObject;
            T result = this.casePowerState(powerState);
            if (result == null) {
                result = this.caseAbstractPowerState(powerState);
            }
            if (result == null) {
                result = this.caseEntity(powerState);
            }
            if (result == null) {
                result = this.caseIdentifier(powerState);
            }
            if (result == null) {
                result = this.caseNamedElement(powerState);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fixed Factor Value Power</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fixed Factor Value Power</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFixedFactorValuePower(final FixedFactorValuePower object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Power Binding Repository</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Binding Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerBindingRepository(final PowerBindingRepository object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Binding</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerBinding(final PowerBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Resource Power Binding</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Resource Power Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourcePowerBinding(final ResourcePowerBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Distribution Power Binding</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Distribution Power Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDistributionPowerBinding(final DistributionPowerBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Power State</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Power State</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractPowerState(final AbstractPowerState object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power State</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power State</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerState(final PowerState object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Stateful Resource Power Binding</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Stateful Resource Power Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStatefulResourcePowerBinding(final StatefulResourcePowerBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Power Factor Binding</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Factor Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerFactorBinding(final PowerFactorBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Fixed Factor Value</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Fixed Factor Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <Q extends Quantity> T caseAbstractFixedFactorValue(final AbstractFixedFactorValue<Q> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fixed Factor Value Dimensionless</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fixed Factor Value Dimensionless</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFixedFactorValueDimensionless(final FixedFactorValueDimensionless object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Transition State</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transition State</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTransitionState(final TransitionState object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Consumption Behavior</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Consumption Behavior</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConsumptionBehavior(final ConsumptionBehavior object) {
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
    public T caseIdentifier(final Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(final NamedElement object) {
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
    public T caseEntity(final Entity object) {
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
    public T defaultCase(final EObject object) {
        return null;
    }

} // BindingSwitch
