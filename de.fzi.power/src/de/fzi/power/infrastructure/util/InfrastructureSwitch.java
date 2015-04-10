/**
 */
package de.fzi.power.infrastructure.util;

import de.fzi.power.infrastructure.*;

import de.fzi.power.util.Entity;
import de.fzi.power.util.NamedElement;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fzi.power.infrastructure.InfrastructurePackage
 * @generated
 */
public class InfrastructureSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static InfrastructurePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureSwitch() {
        if (modelPackage == null) {
            modelPackage = InfrastructurePackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case InfrastructurePackage.POWER_DISTRIBUTION_UNIT: {
            PowerDistributionUnit powerDistributionUnit = (PowerDistributionUnit) theEObject;
            T result = casePowerDistributionUnit(powerDistributionUnit);
            if (result == null)
                result = casePowerConsumingProvidingEntity(powerDistributionUnit);
            if (result == null)
                result = casePowerConsumingEntity(powerDistributionUnit);
            if (result == null)
                result = casePowerProvidingEntity(powerDistributionUnit);
            if (result == null)
                result = caseEntity(powerDistributionUnit);
            if (result == null)
                result = caseIdentifier(powerDistributionUnit);
            if (result == null)
                result = caseNamedElement(powerDistributionUnit);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY: {
            PowerConsumingProvidingEntity powerConsumingProvidingEntity = (PowerConsumingProvidingEntity) theEObject;
            T result = casePowerConsumingProvidingEntity(powerConsumingProvidingEntity);
            if (result == null)
                result = casePowerConsumingEntity(powerConsumingProvidingEntity);
            if (result == null)
                result = casePowerProvidingEntity(powerConsumingProvidingEntity);
            if (result == null)
                result = caseEntity(powerConsumingProvidingEntity);
            if (result == null)
                result = caseIdentifier(powerConsumingProvidingEntity);
            if (result == null)
                result = caseNamedElement(powerConsumingProvidingEntity);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case InfrastructurePackage.POWER_PROVIDING_ENTITY: {
            PowerProvidingEntity powerProvidingEntity = (PowerProvidingEntity) theEObject;
            T result = casePowerProvidingEntity(powerProvidingEntity);
            if (result == null)
                result = caseEntity(powerProvidingEntity);
            if (result == null)
                result = caseIdentifier(powerProvidingEntity);
            if (result == null)
                result = caseNamedElement(powerProvidingEntity);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case InfrastructurePackage.POWER_CONSUMING_ENTITY: {
            PowerConsumingEntity powerConsumingEntity = (PowerConsumingEntity) theEObject;
            T result = casePowerConsumingEntity(powerConsumingEntity);
            if (result == null)
                result = caseEntity(powerConsumingEntity);
            if (result == null)
                result = caseIdentifier(powerConsumingEntity);
            if (result == null)
                result = caseNamedElement(powerConsumingEntity);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT: {
            MountedPowerDistributionUnit mountedPowerDistributionUnit = (MountedPowerDistributionUnit) theEObject;
            T result = caseMountedPowerDistributionUnit(mountedPowerDistributionUnit);
            if (result == null)
                result = casePowerDistributionUnit(mountedPowerDistributionUnit);
            if (result == null)
                result = casePowerConsumingProvidingEntity(mountedPowerDistributionUnit);
            if (result == null)
                result = casePowerConsumingEntity(mountedPowerDistributionUnit);
            if (result == null)
                result = casePowerProvidingEntity(mountedPowerDistributionUnit);
            if (result == null)
                result = caseEntity(mountedPowerDistributionUnit);
            if (result == null)
                result = caseIdentifier(mountedPowerDistributionUnit);
            if (result == null)
                result = caseNamedElement(mountedPowerDistributionUnit);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE: {
            PowerConsumingResource powerConsumingResource = (PowerConsumingResource) theEObject;
            T result = casePowerConsumingResource(powerConsumingResource);
            if (result == null)
                result = casePowerConsumingEntity(powerConsumingResource);
            if (result == null)
                result = caseEntity(powerConsumingResource);
            if (result == null)
                result = caseIdentifier(powerConsumingResource);
            if (result == null)
                result = caseNamedElement(powerConsumingResource);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY: {
            PowerInfrastructureRepository powerInfrastructureRepository = (PowerInfrastructureRepository) theEObject;
            T result = casePowerInfrastructureRepository(powerInfrastructureRepository);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Distribution Unit</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Distribution Unit</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerDistributionUnit(PowerDistributionUnit object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Consuming Providing Entity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Consuming Providing Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerConsumingProvidingEntity(PowerConsumingProvidingEntity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Providing Entity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Providing Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerProvidingEntity(PowerProvidingEntity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Consuming Entity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Consuming Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerConsumingEntity(PowerConsumingEntity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Mounted Power Distribution Unit</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Mounted Power Distribution Unit</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMountedPowerDistributionUnit(MountedPowerDistributionUnit object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Consuming Resource</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Consuming Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerConsumingResource(PowerConsumingResource object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Power Infrastructure Repository</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Power Infrastructure Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerInfrastructureRepository(PowerInfrastructureRepository object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //InfrastructureSwitch
