/**
 */
package de.fzi.power.binding.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fzi.power.binding.BindingFactory;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValueDimensionless;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.PowerState;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.StatefulResourcePowerBinding;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class BindingFactoryImpl extends EFactoryImpl implements BindingFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static BindingFactory init() {
        try {
            final BindingFactory theBindingFactory = (BindingFactory) EPackage.Registry.INSTANCE
                    .getEFactory(BindingPackage.eNS_URI);
            if (theBindingFactory != null) {
                return theBindingFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BindingFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public BindingFactoryImpl() {
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
        case BindingPackage.FIXED_FACTOR_VALUE_POWER:
            return this.createFixedFactorValuePower();
        case BindingPackage.POWER_BINDING_REPOSITORY:
            return this.createPowerBindingRepository();
        case BindingPackage.RESOURCE_POWER_BINDING:
            return this.createResourcePowerBinding();
        case BindingPackage.DISTRIBUTION_POWER_BINDING:
            return this.createDistributionPowerBinding();
        case BindingPackage.POWER_STATE:
            return this.createPowerState();
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING:
            return this.createStatefulResourcePowerBinding();
        case BindingPackage.FIXED_FACTOR_VALUE_DIMENSIONLESS:
            return this.createFixedFactorValueDimensionless();
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
    public FixedFactorValuePower createFixedFactorValuePower() {
        final FixedFactorValuePowerImpl fixedFactorValuePower = new FixedFactorValuePowerImpl();
        return fixedFactorValuePower;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerBindingRepository createPowerBindingRepository() {
        final PowerBindingRepositoryImpl powerBindingRepository = new PowerBindingRepositoryImpl();
        return powerBindingRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourcePowerBinding createResourcePowerBinding() {
        final ResourcePowerBindingImpl resourcePowerBinding = new ResourcePowerBindingImpl();
        return resourcePowerBinding;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DistributionPowerBinding createDistributionPowerBinding() {
        final DistributionPowerBindingImpl distributionPowerBinding = new DistributionPowerBindingImpl();
        return distributionPowerBinding;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PowerState createPowerState() {
        final PowerStateImpl powerState = new PowerStateImpl();
        return powerState;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public StatefulResourcePowerBinding createStatefulResourcePowerBinding() {
        final StatefulResourcePowerBindingImpl statefulResourcePowerBinding = new StatefulResourcePowerBindingImpl();
        return statefulResourcePowerBinding;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public FixedFactorValueDimensionless createFixedFactorValueDimensionless() {
        final FixedFactorValueDimensionlessImpl fixedFactorValueDimensionless = new FixedFactorValueDimensionlessImpl();
        return fixedFactorValueDimensionless;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public BindingPackage getBindingPackage() {
        return (BindingPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static BindingPackage getPackage() {
        return BindingPackage.eINSTANCE;
    }

} // BindingFactoryImpl
