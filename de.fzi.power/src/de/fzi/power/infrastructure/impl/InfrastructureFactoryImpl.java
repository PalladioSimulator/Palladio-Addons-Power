/**
 */
package de.fzi.power.infrastructure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class InfrastructureFactoryImpl extends EFactoryImpl implements InfrastructureFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static InfrastructureFactory init() {
        try
        {
            final InfrastructureFactory theInfrastructureFactory = (InfrastructureFactory) EPackage.Registry.INSTANCE
                    .getEFactory(InfrastructurePackage.eNS_URI);
            if (theInfrastructureFactory != null)
            {
                return theInfrastructureFactory;
            }
        } catch (final Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new InfrastructureFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID())
        {
        case InfrastructurePackage.POWER_DISTRIBUTION_UNIT:
            return this.createPowerDistributionUnit();
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT:
            return this.createMountedPowerDistributionUnit();
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE:
            return this.createPowerConsumingResource();
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY:
            return this.createPowerInfrastructureRepository();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PowerDistributionUnit createPowerDistributionUnit() {
        final PowerDistributionUnitImpl powerDistributionUnit = new PowerDistributionUnitImpl();
        return powerDistributionUnit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MountedPowerDistributionUnit createMountedPowerDistributionUnit() {
        final MountedPowerDistributionUnitImpl mountedPowerDistributionUnit = new MountedPowerDistributionUnitImpl();
        return mountedPowerDistributionUnit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PowerConsumingResource createPowerConsumingResource() {
        final PowerConsumingResourceImpl powerConsumingResource = new PowerConsumingResourceImpl();
        return powerConsumingResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PowerInfrastructureRepository createPowerInfrastructureRepository() {
        final PowerInfrastructureRepositoryImpl powerInfrastructureRepository = new PowerInfrastructureRepositoryImpl();
        return powerInfrastructureRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructurePackage getInfrastructurePackage() {
        return (InfrastructurePackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static InfrastructurePackage getPackage() {
        return InfrastructurePackage.eINSTANCE;
    }

} // InfrastructureFactoryImpl
