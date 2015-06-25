/**
 */
package de.fzi.power.specification.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.DistributionPowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;
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
 * @see de.fzi.power.specification.SpecificationPackage
 * @generated
 */
public class SpecificationSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static SpecificationPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SpecificationSwitch() {
        if (modelPackage == null)
        {
            modelPackage = SpecificationPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @parameter ePackage the package in question.
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
        switch (classifierID)
        {
        case SpecificationPackage.POWER_MODEL_REPOSITORY: {
            final PowerModelRepository powerModelRepository = (PowerModelRepository) theEObject;
            T result = this.casePowerModelRepository(powerModelRepository);
            if (result == null) {
                result = this.caseIdentifier(powerModelRepository);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SpecificationPackage.POWER_MODEL_SPECIFICATION: {
            final PowerModelSpecification powerModelSpecification = (PowerModelSpecification) theEObject;
            T result = this.casePowerModelSpecification(powerModelSpecification);
            if (result == null) {
                result = this.caseEntity(powerModelSpecification);
            }
            if (result == null) {
                result = this.caseIdentifier(powerModelSpecification);
            }
            if (result == null) {
                result = this.caseNamedElement(powerModelSpecification);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SpecificationPackage.RESOURCE_POWER_MODEL_SPECIFICATION: {
            final ResourcePowerModelSpecification resourcePowerModelSpecification = (ResourcePowerModelSpecification) theEObject;
            T result = this.caseResourcePowerModelSpecification(resourcePowerModelSpecification);
            if (result == null) {
                result = this.casePowerModelSpecification(resourcePowerModelSpecification);
            }
            if (result == null) {
                result = this.caseEntity(resourcePowerModelSpecification);
            }
            if (result == null) {
                result = this.caseIdentifier(resourcePowerModelSpecification);
            }
            if (result == null) {
                result = this.caseNamedElement(resourcePowerModelSpecification);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SpecificationPackage.DISTRIBUTION_POWER_MODEL_SPECIFICATION: {
            final DistributionPowerModelSpecification distributionPowerModelSpecification = (DistributionPowerModelSpecification) theEObject;
            T result = this.caseDistributionPowerModelSpecification(distributionPowerModelSpecification);
            if (result == null) {
                result = this.casePowerModelSpecification(distributionPowerModelSpecification);
            }
            if (result == null) {
                result = this.caseEntity(distributionPowerModelSpecification);
            }
            if (result == null) {
                result = this.caseIdentifier(distributionPowerModelSpecification);
            }
            if (result == null) {
                result = this.caseNamedElement(distributionPowerModelSpecification);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SpecificationPackage.FIXED_FACTOR: {
            final FixedFactor fixedFactor = (FixedFactor) theEObject;
            T result = this.caseFixedFactor(fixedFactor);
            if (result == null) {
                result = this.caseConsumptionFactor(fixedFactor);
            }
            if (result == null) {
                result = this.caseEntity(fixedFactor);
            }
            if (result == null) {
                result = this.caseIdentifier(fixedFactor);
            }
            if (result == null) {
                result = this.caseNamedElement(fixedFactor);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SpecificationPackage.CONSUMPTION_FACTOR: {
            final ConsumptionFactor consumptionFactor = (ConsumptionFactor) theEObject;
            T result = this.caseConsumptionFactor(consumptionFactor);
            if (result == null) {
                result = this.caseEntity(consumptionFactor);
            }
            if (result == null) {
                result = this.caseIdentifier(consumptionFactor);
            }
            if (result == null) {
                result = this.caseNamedElement(consumptionFactor);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SpecificationPackage.MEASURED_FACTOR: {
            final MeasuredFactor measuredFactor = (MeasuredFactor) theEObject;
            T result = this.caseMeasuredFactor(measuredFactor);
            if (result == null) {
                result = this.caseConsumptionFactor(measuredFactor);
            }
            if (result == null) {
                result = this.caseEntity(measuredFactor);
            }
            if (result == null) {
                result = this.caseIdentifier(measuredFactor);
            }
            if (result == null) {
                result = this.caseNamedElement(measuredFactor);
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
     * <em>Power Model Repository</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Model Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerModelRepository(final PowerModelRepository object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Power Model Specification</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Model Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerModelSpecification(final PowerModelSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Resource Power Model Specification</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Resource Power Model Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourcePowerModelSpecification(final ResourcePowerModelSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Distribution Power Model Specification</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Distribution Power Model Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDistributionPowerModelSpecification(final DistributionPowerModelSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Fixed Factor</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Fixed Factor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFixedFactor(final FixedFactor object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Consumption Factor</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Consumption Factor</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConsumptionFactor(final ConsumptionFactor object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Measured Factor</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Measured Factor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMeasuredFactor(final MeasuredFactor object) {
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

} // SpecificationSwitch
