/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingResource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Power Consuming Resource</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link de.fzi.power.infrastructure.impl.PowerConsumingResourceImpl#getResourcePowerAssemblyContext
 * <em>Resource Power Assembly Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerConsumingResourceImpl extends AbstractPowerConsumingResourceImpl implements PowerConsumingResource {
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
    public ResourcePowerBinding getResourcePowerAssemblyContext() {
        return (ResourcePowerBinding) this.eDynamicGet(
                InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourcePowerBinding basicGetResourcePowerAssemblyContext() {
        return (ResourcePowerBinding) this.eDynamicGet(
                InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourcePowerAssemblyContext(final ResourcePowerBinding newResourcePowerAssemblyContext) {
        this.eDynamicSet(InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                newResourcePowerAssemblyContext);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
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
        switch (featureID) {
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
        switch (featureID) {
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
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            return this.basicGetResourcePowerAssemblyContext() != null;
        }
        return super.eIsSet(featureID);
    }

} // PowerConsumingResourceImpl
