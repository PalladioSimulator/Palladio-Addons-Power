/**
 */
package de.fzi.power.infrastructure.impl;

import de.fzi.power.infrastructure.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class InfrastructureFactoryImpl extends EFactoryImpl implements InfrastructureFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static InfrastructureFactory init() {
        try {
            InfrastructureFactory theInfrastructureFactory = (InfrastructureFactory) EPackage.Registry.INSTANCE
                    .getEFactory(InfrastructurePackage.eNS_URI);
            if (theInfrastructureFactory != null) {
                return theInfrastructureFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new InfrastructureFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case InfrastructurePackage.POWER_DISTRIBUTION_UNIT:
            return (EObject) createPowerDistributionUnit();
        case InfrastructurePackage.MOUNTED_POWER_DISTRIBUTION_UNIT:
            return (EObject) createMountedPowerDistributionUnit();
        case InfrastructurePackage.POWER_INFRASTRUCTURE_REPOSITORY:
            return (EObject) createPowerInfrastructureRepository();
        case InfrastructurePackage.STATEFUL_POWER_CONSUMING_RESOURCE_SET:
            return (EObject) createStatefulPowerConsumingResourceSet();
        case InfrastructurePackage.POWER_CONSUMING_RESOURCE_SET:
            return (EObject) createPowerConsumingResourceSet();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerDistributionUnit createPowerDistributionUnit() {
        PowerDistributionUnitImpl powerDistributionUnit = new PowerDistributionUnitImpl();
        return powerDistributionUnit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MountedPowerDistributionUnit createMountedPowerDistributionUnit() {
        MountedPowerDistributionUnitImpl mountedPowerDistributionUnit = new MountedPowerDistributionUnitImpl();
        return mountedPowerDistributionUnit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerInfrastructureRepository createPowerInfrastructureRepository() {
        PowerInfrastructureRepositoryImpl powerInfrastructureRepository = new PowerInfrastructureRepositoryImpl();
        return powerInfrastructureRepository;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StatefulPowerConsumingResourceSet createStatefulPowerConsumingResourceSet() {
        StatefulPowerConsumingResourceSetImpl statefulPowerConsumingResourceSet = new StatefulPowerConsumingResourceSetImpl();
        return statefulPowerConsumingResourceSet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PowerConsumingResourceSet createPowerConsumingResourceSet() {
        PowerConsumingResourceSetImpl powerConsumingResourceSet = new PowerConsumingResourceSetImpl();
        return powerConsumingResourceSet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public InfrastructurePackage getInfrastructurePackage() {
        return (InfrastructurePackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static InfrastructurePackage getPackage() {
        return InfrastructurePackage.eINSTANCE;
    }

} // InfrastructureFactoryImpl
