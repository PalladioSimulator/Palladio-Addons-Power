/**
 */
package de.fzi.power.infrastructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.power.infrastructure.InfrastructurePackage
 * @generated
 */
public interface InfrastructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InfrastructureFactory eINSTANCE = de.fzi.power.infrastructure.impl.InfrastructureFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Power Distribution Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Distribution Unit</em>'.
	 * @generated
	 */
	PowerDistributionUnit createPowerDistributionUnit();

	/**
	 * Returns a new object of class '<em>Mounted Power Distribution Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mounted Power Distribution Unit</em>'.
	 * @generated
	 */
	MountedPowerDistributionUnit createMountedPowerDistributionUnit();

	/**
	 * Returns a new object of class '<em>Power Consuming Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Consuming Resource</em>'.
	 * @generated
	 */
	PowerConsumingResource createPowerConsumingResource();

	/**
	 * Returns a new object of class '<em>Power Infrastructure Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Infrastructure Repository</em>'.
	 * @generated
	 */
	PowerInfrastructureRepository createPowerInfrastructureRepository();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InfrastructurePackage getInfrastructurePackage();

} //InfrastructureFactory
