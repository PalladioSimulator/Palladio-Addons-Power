/**
 */
package de.fzi.power.specification.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.DistributionPowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationFactory;
import de.fzi.power.specification.SpecificationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SpecificationFactoryImpl extends EFactoryImpl implements SpecificationFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static SpecificationFactory init() {
        try {
            final SpecificationFactory theSpecificationFactory = (SpecificationFactory) EPackage.Registry.INSTANCE
                    .getEFactory(SpecificationPackage.eNS_URI);
            if (theSpecificationFactory != null) {
                return theSpecificationFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SpecificationFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SpecificationFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case SpecificationPackage.POWER_MODEL_REPOSITORY:
            return this.createPowerModelRepository();
        case SpecificationPackage.RESOURCE_POWER_MODEL_SPECIFICATION:
            return this.createResourcePowerModelSpecification();
        case SpecificationPackage.DISTRIBUTION_POWER_MODEL_SPECIFICATION:
            return this.createDistributionPowerModelSpecification();
        case SpecificationPackage.FIXED_FACTOR:
            return this.createFixedFactor();
        case SpecificationPackage.MEASURED_FACTOR:
            return this.createMeasuredFactor();
        case SpecificationPackage.DECLARATIVE_POWER_MODEL_SPECIFICATION:
            return this.createDeclarativePowerModelSpecification();
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
    public PowerModelRepository createPowerModelRepository() {
        final PowerModelRepositoryImpl powerModelRepository = new PowerModelRepositoryImpl();
        return powerModelRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourcePowerModelSpecification createResourcePowerModelSpecification() {
        final ResourcePowerModelSpecificationImpl resourcePowerModelSpecification = new ResourcePowerModelSpecificationImpl();
        return resourcePowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DistributionPowerModelSpecification createDistributionPowerModelSpecification() {
        final DistributionPowerModelSpecificationImpl distributionPowerModelSpecification = new DistributionPowerModelSpecificationImpl();
        return distributionPowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FixedFactor createFixedFactor() {
        final FixedFactorImpl fixedFactor = new FixedFactorImpl();
        return fixedFactor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MeasuredFactor createMeasuredFactor() {
        final MeasuredFactorImpl measuredFactor = new MeasuredFactorImpl();
        return measuredFactor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DeclarativePowerModelSpecification createDeclarativePowerModelSpecification() {
        final DeclarativePowerModelSpecificationImpl declarativePowerModelSpecification = new DeclarativePowerModelSpecificationImpl();
        return declarativePowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SpecificationPackage getSpecificationPackage() {
        return (SpecificationPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SpecificationPackage getPackage() {
        return SpecificationPackage.eINSTANCE;
    }

} // SpecificationFactoryImpl
