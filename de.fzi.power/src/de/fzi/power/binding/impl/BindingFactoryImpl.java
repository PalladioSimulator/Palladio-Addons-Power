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
import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.ResourcePowerBinding;

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
		case BindingPackage.FIXED_FACTOR_VALUE:
			return createFixedFactorValue();
		case BindingPackage.POWER_BINDING_REPOSITORY:
			return createPowerBindingRepository();
		case BindingPackage.RESOURCE_POWER_BINDING:
			return createResourcePowerBinding();
		case BindingPackage.DISTRIBUTION_POWER_BINDING:
			return createDistributionPowerBinding();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FixedFactorValue createFixedFactorValue() {
		FixedFactorValueImpl fixedFactorValue = new FixedFactorValueImpl();
		return fixedFactorValue;
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
