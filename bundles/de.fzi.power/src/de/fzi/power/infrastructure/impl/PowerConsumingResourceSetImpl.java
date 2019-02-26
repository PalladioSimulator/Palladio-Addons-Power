/**
 */
package de.fzi.power.infrastructure.impl;

import de.fzi.power.binding.ResourcePowerBinding;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingResourceSet;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Consuming Resource Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.infrastructure.impl.PowerConsumingResourceSetImpl#getResourcePowerAssemblyContext <em>Resource Power Assembly Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerConsumingResourceSetImpl extends AbstractPowerConsumingResourceImpl
        implements PowerConsumingResourceSet {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PowerConsumingResourceSetImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE_SET;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourcePowerBinding getResourcePowerAssemblyContext() {
        return (ResourcePowerBinding) eDynamicGet(
                InfrastructurePackage.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourcePowerBinding basicGetResourcePowerAssemblyContext() {
        return (ResourcePowerBinding) eDynamicGet(
                InfrastructurePackage.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT, false,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourcePowerAssemblyContext(ResourcePowerBinding newResourcePowerAssemblyContext) {
        eDynamicSet(InfrastructurePackage.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                InfrastructurePackage.Literals.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT,
                newResourcePowerAssemblyContext);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT:
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
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT:
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
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT:
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
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE_SET__RESOURCE_POWER_ASSEMBLY_CONTEXT:
            return basicGetResourcePowerAssemblyContext() != null;
        }
        return super.eIsSet(featureID);
    }

} //PowerConsumingResourceSetImpl
