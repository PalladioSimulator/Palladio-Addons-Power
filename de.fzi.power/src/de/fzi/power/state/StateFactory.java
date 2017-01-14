/**
 */
package de.fzi.power.state;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see de.fzi.power.state.StatePackage
 * @generated
 */
public interface StateFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    StateFactory eINSTANCE = de.fzi.power.state.impl.StateFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Power State Repository</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Power State Repository</em>'.
     * @generated
     */
    PowerStateRepository createPowerStateRepository();

    /**
     * Returns a new object of class '<em>Transition State</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Transition State</em>'.
     * @generated
     */
    TransitionState createTransitionState();

    /**
     * Returns a new object of class '<em>Power State</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Power State</em>'.
     * @generated
     */
    PowerState createPowerState();

    /**
     * Returns a new object of class '<em>Power State Machine</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Power State Machine</em>'.
     * @generated
     */
    PowerStateMachine createPowerStateMachine();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    StatePackage getStatePackage();

} // StateFactory
