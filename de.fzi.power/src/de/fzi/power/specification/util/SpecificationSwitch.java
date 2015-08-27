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
 * @see de.fzi.power.specification.SpecificationPackage
 * @generated
 */
public class SpecificationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpecificationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificationSwitch() {
		if (modelPackage == null) {
			modelPackage = SpecificationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @parameter ePackage the package in question.
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
		case SpecificationPackage.POWER_MODEL_REPOSITORY: {
			PowerModelRepository powerModelRepository = (PowerModelRepository) theEObject;
			T result = casePowerModelRepository(powerModelRepository);
			if (result == null)
				result = caseIdentifier(powerModelRepository);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SpecificationPackage.POWER_MODEL_SPECIFICATION: {
			PowerModelSpecification powerModelSpecification = (PowerModelSpecification) theEObject;
			T result = casePowerModelSpecification(powerModelSpecification);
			if (result == null)
				result = caseEntity(powerModelSpecification);
			if (result == null)
				result = caseIdentifier(powerModelSpecification);
			if (result == null)
				result = caseNamedElement(powerModelSpecification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SpecificationPackage.RESOURCE_POWER_MODEL_SPECIFICATION: {
			ResourcePowerModelSpecification resourcePowerModelSpecification = (ResourcePowerModelSpecification) theEObject;
			T result = caseResourcePowerModelSpecification(resourcePowerModelSpecification);
			if (result == null)
				result = casePowerModelSpecification(resourcePowerModelSpecification);
			if (result == null)
				result = caseEntity(resourcePowerModelSpecification);
			if (result == null)
				result = caseIdentifier(resourcePowerModelSpecification);
			if (result == null)
				result = caseNamedElement(resourcePowerModelSpecification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SpecificationPackage.DISTRIBUTION_POWER_MODEL_SPECIFICATION: {
			DistributionPowerModelSpecification distributionPowerModelSpecification = (DistributionPowerModelSpecification) theEObject;
			T result = caseDistributionPowerModelSpecification(distributionPowerModelSpecification);
			if (result == null)
				result = casePowerModelSpecification(distributionPowerModelSpecification);
			if (result == null)
				result = caseEntity(distributionPowerModelSpecification);
			if (result == null)
				result = caseIdentifier(distributionPowerModelSpecification);
			if (result == null)
				result = caseNamedElement(distributionPowerModelSpecification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SpecificationPackage.FIXED_FACTOR: {
			FixedFactor fixedFactor = (FixedFactor) theEObject;
			T result = caseFixedFactor(fixedFactor);
			if (result == null)
				result = caseConsumptionFactor(fixedFactor);
			if (result == null)
				result = caseEntity(fixedFactor);
			if (result == null)
				result = caseIdentifier(fixedFactor);
			if (result == null)
				result = caseNamedElement(fixedFactor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SpecificationPackage.CONSUMPTION_FACTOR: {
			ConsumptionFactor consumptionFactor = (ConsumptionFactor) theEObject;
			T result = caseConsumptionFactor(consumptionFactor);
			if (result == null)
				result = caseEntity(consumptionFactor);
			if (result == null)
				result = caseIdentifier(consumptionFactor);
			if (result == null)
				result = caseNamedElement(consumptionFactor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SpecificationPackage.MEASURED_FACTOR: {
			MeasuredFactor measuredFactor = (MeasuredFactor) theEObject;
			T result = caseMeasuredFactor(measuredFactor);
			if (result == null)
				result = caseConsumptionFactor(measuredFactor);
			if (result == null)
				result = caseEntity(measuredFactor);
			if (result == null)
				result = caseIdentifier(measuredFactor);
			if (result == null)
				result = caseNamedElement(measuredFactor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Model Repository</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Model Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerModelRepository(PowerModelRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Model Specification</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Model Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerModelSpecification(PowerModelSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Power Model Specification</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Power Model Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourcePowerModelSpecification(
			ResourcePowerModelSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distribution Power Model Specification</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distribution Power Model Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistributionPowerModelSpecification(
			DistributionPowerModelSpecification object) {
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
	public T caseFixedFactor(FixedFactor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consumption Factor</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consumption Factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsumptionFactor(ConsumptionFactor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measured Factor</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measured Factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasuredFactor(MeasuredFactor object) {
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

} // SpecificationSwitch
