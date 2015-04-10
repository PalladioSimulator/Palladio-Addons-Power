/**
 */
package de.fzi.power.specification.impl;

import de.fzi.power.specification.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificationFactoryImpl extends EFactoryImpl implements SpecificationFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static SpecificationFactory init() {
        try {
            SpecificationFactory theSpecificationFactory = (SpecificationFactory) EPackage.Registry.INSTANCE
                    .getEFactory(SpecificationPackage.eNS_URI);
            if (theSpecificationFactory != null) {
                return theSpecificationFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SpecificationFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecificationFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case SpecificationPackage.POWER_MODEL_REPOSITORY:
            return createPowerModelRepository();
        case SpecificationPackage.RESOURCE_POWER_MODEL_SPECIFICATION:
            return createResourcePowerModelSpecification();
        case SpecificationPackage.DISTRIBUTION_POWER_MODEL_SPECIFICATION:
            return createDistributionPowerModelSpecification();
        case SpecificationPackage.FIXED_FACTOR:
            return createFixedFactor();
        case SpecificationPackage.MEASURED_FACTOR:
            return createMeasuredFactor();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerModelRepository createPowerModelRepository() {
        PowerModelRepositoryImpl powerModelRepository = new PowerModelRepositoryImpl();
        return powerModelRepository;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourcePowerModelSpecification createResourcePowerModelSpecification() {
        ResourcePowerModelSpecificationImpl resourcePowerModelSpecification = new ResourcePowerModelSpecificationImpl();
        return resourcePowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DistributionPowerModelSpecification createDistributionPowerModelSpecification() {
        DistributionPowerModelSpecificationImpl distributionPowerModelSpecification = new DistributionPowerModelSpecificationImpl();
        return distributionPowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public FixedFactor createFixedFactor() {
        FixedFactorImpl fixedFactor = new FixedFactorImpl();
        return fixedFactor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MeasuredFactor createMeasuredFactor() {
        MeasuredFactorImpl measuredFactor = new MeasuredFactorImpl();
        return measuredFactor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public SpecificationPackage getSpecificationPackage() {
        return (SpecificationPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SpecificationPackage getPackage() {
        return SpecificationPackage.eINSTANCE;
    }

} //SpecificationFactoryImpl
