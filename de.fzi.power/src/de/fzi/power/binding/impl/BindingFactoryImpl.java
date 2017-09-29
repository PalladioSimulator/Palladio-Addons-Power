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
import de.fzi.power.binding.ConsumptionBehavior;
import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.FixedFactorValueDimensionless;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.PowerStateBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.StatefulResourcePowerBinding;
import de.fzi.power.binding.TransitionStateBinding;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class BindingFactoryImpl extends EFactoryImpl implements BindingFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static BindingFactory init() {
        try {
            BindingFactory theBindingFactory = (BindingFactory) EPackage.Registry.INSTANCE
                    .getEFactory(BindingPackage.eNS_URI);
            if (theBindingFactory != null) {
                return theBindingFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BindingFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public BindingFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case BindingPackage.FIXED_FACTOR_VALUE_POWER:
            return (EObject) createFixedFactorValuePower();
        case BindingPackage.POWER_BINDING_REPOSITORY:
            return (EObject) createPowerBindingRepository();
        case BindingPackage.RESOURCE_POWER_BINDING:
            return (EObject) createResourcePowerBinding();
        case BindingPackage.DISTRIBUTION_POWER_BINDING:
            return (EObject) createDistributionPowerBinding();
        case BindingPackage.FIXED_FACTOR_VALUE_DIMENSIONLESS:
            return (EObject) createFixedFactorValueDimensionless();
        case BindingPackage.CONSUMPTION_BEHAVIOR:
            return (EObject) createConsumptionBehavior();
        case BindingPackage.STATEFUL_RESOURCE_POWER_BINDING:
            return (EObject) createStatefulResourcePowerBinding();
        case BindingPackage.POWER_STATE_BINDING:
            return (EObject) createPowerStateBinding();
        case BindingPackage.TRANSITION_STATE_BINDING:
            return (EObject) createTransitionStateBinding();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public FixedFactorValuePower createFixedFactorValuePower() {
        FixedFactorValuePowerImpl fixedFactorValuePower = new FixedFactorValuePowerImpl();
        return fixedFactorValuePower;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerBindingRepository createPowerBindingRepository() {
        PowerBindingRepositoryImpl powerBindingRepository = new PowerBindingRepositoryImpl();
        return powerBindingRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourcePowerBinding createResourcePowerBinding() {
        ResourcePowerBindingImpl resourcePowerBinding = new ResourcePowerBindingImpl();
        return resourcePowerBinding;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DistributionPowerBinding createDistributionPowerBinding() {
        DistributionPowerBindingImpl distributionPowerBinding = new DistributionPowerBindingImpl();
        return distributionPowerBinding;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public FixedFactorValueDimensionless createFixedFactorValueDimensionless() {
        FixedFactorValueDimensionlessImpl fixedFactorValueDimensionless = new FixedFactorValueDimensionlessImpl();
        return fixedFactorValueDimensionless;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ConsumptionBehavior createConsumptionBehavior() {
        ConsumptionBehaviorImpl consumptionBehavior = new ConsumptionBehaviorImpl();
        return consumptionBehavior;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public StatefulResourcePowerBinding createStatefulResourcePowerBinding() {
        StatefulResourcePowerBindingImpl statefulResourcePowerBinding = new StatefulResourcePowerBindingImpl();
        return statefulResourcePowerBinding;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PowerStateBinding createPowerStateBinding() {
        PowerStateBindingImpl powerStateBinding = new PowerStateBindingImpl();
        return powerStateBinding;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TransitionStateBinding createTransitionStateBinding() {
        TransitionStateBindingImpl transitionStateBinding = new TransitionStateBindingImpl();
        return transitionStateBinding;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public BindingPackage getBindingPackage() {
        return (BindingPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static BindingPackage getPackage() {
        return BindingPackage.eINSTANCE;
    }

} // BindingFactoryImpl
