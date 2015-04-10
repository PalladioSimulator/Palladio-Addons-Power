/**
 */
package de.fzi.power.infrastructure.impl;

import de.fzi.power.binding.ResourcePowerBinding;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingResource;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Consuming Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl#getProcessingResourceSpecification <em>Processing Resource Specification</em>}</li>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl#getResourcePowerAssemblyContext <em>Resource Power Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerConsumingResourceImpl extends PowerConsumingEntityImpl implements PowerConsumingResource {
    /**
     * The cached value of the '{@link #getProcessingResourceSpecification() <em>Processing Resource Specification</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProcessingResourceSpecification()
     * @generated
     * @ordered
     */
    protected ProcessingResourceSpecification processingResourceSpecification;

    /**
     * The cached value of the '{@link #getResourcePowerAssemblyContext() <em>Resource Power Assembly Context</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourcePowerAssemblyContext()
     * @generated
     * @ordered
     */
    protected ResourcePowerBinding resourcePowerAssemblyContext;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PowerConsumingResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ProcessingResourceSpecification getProcessingResourceSpecification() {
        if (processingResourceSpecification != null && ((EObject) processingResourceSpecification).eIsProxy()) {
            InternalEObject oldProcessingResourceSpecification = (InternalEObject) processingResourceSpecification;
            processingResourceSpecification = (ProcessingResourceSpecification) eResolveProxy(oldProcessingResourceSpecification);
            if (processingResourceSpecification != oldProcessingResourceSpecification) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                            oldProcessingResourceSpecification, processingResourceSpecification));
            }
        }
        return processingResourceSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessingResourceSpecification basicGetProcessingResourceSpecification() {
        return processingResourceSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setProcessingResourceSpecification(ProcessingResourceSpecification newProcessingResourceSpecification) {
        ProcessingResourceSpecification oldProcessingResourceSpecification = processingResourceSpecification;
        processingResourceSpecification = newProcessingResourceSpecification;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                    oldProcessingResourceSpecification, processingResourceSpecification));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourcePowerBinding getResourcePowerAssemblyContext() {
        if (resourcePowerAssemblyContext != null && resourcePowerAssemblyContext.eIsProxy()) {
            InternalEObject oldResourcePowerAssemblyContext = (InternalEObject) resourcePowerAssemblyContext;
            resourcePowerAssemblyContext = (ResourcePowerBinding) eResolveProxy(oldResourcePowerAssemblyContext);
            if (resourcePowerAssemblyContext != oldResourcePowerAssemblyContext) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                            oldResourcePowerAssemblyContext, resourcePowerAssemblyContext));
            }
        }
        return resourcePowerAssemblyContext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourcePowerBinding basicGetResourcePowerAssemblyContext() {
        return resourcePowerAssemblyContext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setResourcePowerAssemblyContext(ResourcePowerBinding newResourcePowerAssemblyContext) {
        ResourcePowerBinding oldResourcePowerAssemblyContext = resourcePowerAssemblyContext;
        resourcePowerAssemblyContext = newResourcePowerAssemblyContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                    oldResourcePowerAssemblyContext, resourcePowerAssemblyContext));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            if (resolve)
                return getProcessingResourceSpecification();
            return basicGetProcessingResourceSpecification();
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            if (resolve)
                return getResourcePowerAssemblyContext();
            return basicGetResourcePowerAssemblyContext();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            setProcessingResourceSpecification((ProcessingResourceSpecification) newValue);
            return;
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            setResourcePowerAssemblyContext((ResourcePowerBinding) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            setProcessingResourceSpecification((ProcessingResourceSpecification) null);
            return;
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            setResourcePowerAssemblyContext((ResourcePowerBinding) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            return processingResourceSpecification != null;
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            return resourcePowerAssemblyContext != null;
        }
        return super.eIsSet(featureID);
    }

} //PowerConsumingResourceImpl
