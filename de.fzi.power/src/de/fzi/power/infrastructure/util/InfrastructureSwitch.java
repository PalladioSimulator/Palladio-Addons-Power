/**
 */
package de.fzi.power.infrastructure.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;
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
 * @see de.fzi.power.infrastructure.InfrastructurePackage
 * @generated
 */
public class InfrastructureSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static InfrastructurePackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureSwitch() {
        if (modelPackage == null)
        {
            modelPackage = InfrastructurePackage.eINSTANCE;
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
        case InfrastructurePackage.POWER_DISTRIBUTION_UNIT: {
            final PowerDistributionUnit powerDistributionUnit = (PowerDistributionUnit) theEObject;
            T result = this.casePowerDistributionUnit(powerDistributionUnit);
            if (result == null) {
                result = this.casePowerConsumingProvidingEntity(powerDistributionUnit);
            }
            if (result == null) {
                result = this.casePowerConsumingEntity(powerDistributionUnit);
            }
            if (result == null) {
                result = this.casePowerProvidingEntity(powerDistributionUnit);
            }
            if (result == null) {
                result = this.caseEntity(powerDistributionUnit);
            }
            if (result == null) {
                result = this.caseIdentifier(powerDistributionUnit);
            }
            if (result == null) {
                result = this.caseNamedElement(powerDistributionUnit);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY: {
            final PowerConsumingProvidingEntity powerConsumingProvidingEntity = (PowerConsumingProvidingEntity) theEObject;
            T result = this.casePowerConsumingProvidingEntity(powerConsumingProvidingEntity);
            if (result == null) {
                result = this.casePowerConsumingEntity(powerConsumingProvidingEntity);
            }
            if (result == null) {
                result = this.casePowerProvidingEntity(powerConsumingProvidingEntity);
            }
            if (result == null) {
                result = this.caseEntity(powerConsumingProvidingEntity);
            }
            if (result == null) {
                result = this.caseIdentifier(powerConsumingProvidingEntity);
            }
            if (result == null) {
                result = this.caseNamedElement(powerConsumingProvidingEntity);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case InfrastructurePackage.POWER_PROVIDING_ENTITY: {
            final PowerProvidingEntity powerProvidingEntity = (PowerProvidingEntity) theEObject;
            T result = this.casePowerProvidingEntity(powerProvidingEntity);
            if (result == null) {
                result = this.caseEntity(powerProvidingEntity);
            }
            if (result == null) {
                result = this.caseIdentifier(powerProvidingEntity);
            }
            if (result == null) {
                result = this.caseNamedElement(powerProvidingEntity);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case InfrastructurePackage.POWER_CONSUMING_ENTITY: {
            final PowerConsumingEntity powerConsumingEntity = (PowerConsumingEntity) theEObject;
            T result = this.casePowerConsumingEntity(powerConsumingEntity);
            if (result == null) {
                result = this.caseEntity(powerConsumingEntity);
            }
            if (result == null) {
                result = this.caseIdentifier(powerConsumingEntity);
            }
            if (result == null) {
                result = this.caseNamedElement(powerConsumingEntity);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT: {
            final MountedPowerDistributionUnit mountedPowerDistributionUnit = (MountedPowerDistributionUnit) theEObject;
            T result = this.caseMountedPowerDistributionUnit(mountedPowerDistributionUnit);
            if (result == null) {
                result = this.casePowerDistributionUnit(mountedPowerDistributionUnit);
            }
            if (result == null) {
                result = this.casePowerConsumingProvidingEntity(mountedPowerDistributionUnit);
            }
            if (result == null) {
                result = this.casePowerConsumingEntity(mountedPowerDistributionUnit);
            }
            if (result == null) {
                result = this.casePowerProvidingEntity(mountedPowerDistributionUnit);
            }
            if (result == null) {
                result = this.caseEntity(mountedPowerDistributionUnit);
            }
            if (result == null) {
                result = this.caseIdentifier(mountedPowerDistributionUnit);
            }
            if (result == null) {
                result = this.caseNamedElement(mountedPowerDistributionUnit);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE: {
            final PowerConsumingResource powerConsumingResource = (PowerConsumingResource) theEObject;
            T result = this.casePowerConsumingResource(powerConsumingResource);
            if (result == null) {
                result = this.casePowerConsumingEntity(powerConsumingResource);
            }
            if (result == null) {
                result = this.caseEntity(powerConsumingResource);
            }
            if (result == null) {
                result = this.caseIdentifier(powerConsumingResource);
            }
            if (result == null) {
                result = this.caseNamedElement(powerConsumingResource);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY: {
            final PowerInfrastructureRepository powerInfrastructureRepository = (PowerInfrastructureRepository) theEObject;
            T result = this.casePowerInfrastructureRepository(powerInfrastructureRepository);
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
     * <em>Power Distribution Unit</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Distribution Unit</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerDistributionUnit(final PowerDistributionUnit object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Power Consuming Providing Entity</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Consuming Providing Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerConsumingProvidingEntity(final PowerConsumingProvidingEntity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Power Providing Entity</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Providing Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerProvidingEntity(final PowerProvidingEntity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Power Consuming Entity</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Consuming Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerConsumingEntity(final PowerConsumingEntity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Mounted Power Distribution Unit</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Mounted Power Distribution Unit</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMountedPowerDistributionUnit(final MountedPowerDistributionUnit object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Power Consuming Resource</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Consuming Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerConsumingResource(final PowerConsumingResource object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Power Infrastructure Repository</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Power Infrastructure Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePowerInfrastructureRepository(final PowerInfrastructureRepository object) {
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

} // InfrastructureSwitch
