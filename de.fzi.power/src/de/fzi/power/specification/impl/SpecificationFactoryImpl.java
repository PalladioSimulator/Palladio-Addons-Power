/**
 */
package de.fzi.power.specification.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fzi.power.specification.BlackBoxDistributionPowerModelSpecification;
import de.fzi.power.specification.BlackBoxResourcePowerModelSpecification;
import de.fzi.power.specification.DeclarativeDistributionPowerModelSpecification;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.DeclarativeResourcePowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.PowerModelRepository;
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
        case SpecificationPackage.FIXED_FACTOR:
            return this.createFixedFactor();
        case SpecificationPackage.MEASURED_FACTOR:
            return this.createMeasuredFactor();
        case SpecificationPackage.DECLARATIVE_POWER_MODEL_SPECIFICATION:
            return this.createDeclarativePowerModelSpecification();
        case SpecificationPackage.DECLARATIVE_RESOURCE_POWER_MODEL_SPECIFICATION:
            return this.createDeclarativeResourcePowerModelSpecification();
        case SpecificationPackage.DECLARATIVE_DISTRIBUTION_POWER_MODEL_SPECIFICATION:
            return this.createDeclarativeDistributionPowerModelSpecification();
        case SpecificationPackage.BLACK_BOX_DISTRIBUTION_POWER_MODEL_SPECIFICATION:
            return this.createBlackBoxDistributionPowerModelSpecification();
        case SpecificationPackage.BLACK_BOX_RESOURCE_POWER_MODEL_SPECIFICATION:
            return this.createBlackBoxResourcePowerModelSpecification();
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
    public DeclarativeResourcePowerModelSpecification createDeclarativeResourcePowerModelSpecification() {
        final DeclarativeResourcePowerModelSpecificationImpl declarativeResourcePowerModelSpecification = new DeclarativeResourcePowerModelSpecificationImpl();
        return declarativeResourcePowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DeclarativeDistributionPowerModelSpecification createDeclarativeDistributionPowerModelSpecification() {
        final DeclarativeDistributionPowerModelSpecificationImpl declarativeDistributionPowerModelSpecification = new DeclarativeDistributionPowerModelSpecificationImpl();
        return declarativeDistributionPowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public BlackBoxDistributionPowerModelSpecification createBlackBoxDistributionPowerModelSpecification() {
        final BlackBoxDistributionPowerModelSpecificationImpl blackBoxDistributionPowerModelSpecification = new BlackBoxDistributionPowerModelSpecificationImpl();
        return blackBoxDistributionPowerModelSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public BlackBoxResourcePowerModelSpecification createBlackBoxResourcePowerModelSpecification() {
        final BlackBoxResourcePowerModelSpecificationImpl blackBoxResourcePowerModelSpecification = new BlackBoxResourcePowerModelSpecificationImpl();
        return blackBoxResourcePowerModelSpecification;
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
