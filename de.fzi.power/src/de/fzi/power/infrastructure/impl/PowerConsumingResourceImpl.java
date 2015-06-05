/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl#getProcessingResourceSpecification
 * <em>Processing Resource Specification</em>}</li>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl#getResourcePowerAssemblyContext
 * <em>Resource Power Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerConsumingResourceImpl extends PowerConsumingEntityImpl implements PowerConsumingResource {
    /**
     * The cached value of the '{@link #getProcessingResourceSpecification()
     * <em>Processing Resource Specification</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProcessingResourceSpecification()
     * @generated
     * @ordered
     */
    protected ProcessingResourceSpecification processingResourceSpecification;

    /**
     * The cached value of the '{@link #getResourcePowerAssemblyContext()
     * <em>Resource Power Assembly Context</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResourcePowerAssemblyContext()
     * @generated
     * @ordered
     */
    protected ResourcePowerBinding resourcePowerAssemblyContext;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PowerConsumingResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ProcessingResourceSpecification getProcessingResourceSpecification() {
        if (this.processingResourceSpecification != null && this.processingResourceSpecification.eIsProxy())
        {
            final InternalEObject oldProcessingResourceSpecification = (InternalEObject) this.processingResourceSpecification;
            this.processingResourceSpecification = (ProcessingResourceSpecification) this
                    .eResolveProxy(oldProcessingResourceSpecification);
            if (this.processingResourceSpecification != oldProcessingResourceSpecification)
            {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                            oldProcessingResourceSpecification, this.processingResourceSpecification));
                }
            }
        }
        return this.processingResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProcessingResourceSpecification basicGetProcessingResourceSpecification() {
        return this.processingResourceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setProcessingResourceSpecification(
            final ProcessingResourceSpecification newProcessingResourceSpecification) {
        final ProcessingResourceSpecification oldProcessingResourceSpecification = this.processingResourceSpecification;
        this.processingResourceSpecification = newProcessingResourceSpecification;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION,
                    oldProcessingResourceSpecification, this.processingResourceSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourcePowerBinding getResourcePowerAssemblyContext() {
        if (this.resourcePowerAssemblyContext != null && this.resourcePowerAssemblyContext.eIsProxy())
        {
            final InternalEObject oldResourcePowerAssemblyContext = (InternalEObject) this.resourcePowerAssemblyContext;
            this.resourcePowerAssemblyContext = (ResourcePowerBinding) this
                    .eResolveProxy(oldResourcePowerAssemblyContext);
            if (this.resourcePowerAssemblyContext != oldResourcePowerAssemblyContext)
            {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                            oldResourcePowerAssemblyContext, this.resourcePowerAssemblyContext));
                }
            }
        }
        return this.resourcePowerAssemblyContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourcePowerBinding basicGetResourcePowerAssemblyContext() {
        return this.resourcePowerAssemblyContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourcePowerAssemblyContext(final ResourcePowerBinding newResourcePowerAssemblyContext) {
        final ResourcePowerBinding oldResourcePowerAssemblyContext = this.resourcePowerAssemblyContext;
        this.resourcePowerAssemblyContext = newResourcePowerAssemblyContext;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                    oldResourcePowerAssemblyContext, this.resourcePowerAssemblyContext));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID)
        {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            if (resolve) {
                return this.getProcessingResourceSpecification();
            }
            return this.basicGetProcessingResourceSpecification();
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            if (resolve) {
                return this.getResourcePowerAssemblyContext();
            }
            return this.basicGetResourcePowerAssemblyContext();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID)
        {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            this.setProcessingResourceSpecification((ProcessingResourceSpecification) newValue);
            return;
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            this.setResourcePowerAssemblyContext((ResourcePowerBinding) newValue);
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
        switch (featureID)
        {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            this.setProcessingResourceSpecification((ProcessingResourceSpecification) null);
            return;
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            this.setResourcePowerAssemblyContext((ResourcePowerBinding) null);
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
        switch (featureID)
        {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__PROCESSING_RESOURCE_SPECIFICATION:
            return this.processingResourceSpecification != null;
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            return this.resourcePowerAssemblyContext != null;
        }
        return super.eIsSet(featureID);
    }

} // PowerConsumingResourceImpl
