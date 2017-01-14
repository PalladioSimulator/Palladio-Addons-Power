/**
 */
package de.fzi.power.binding;

import de.fzi.power.state.TransitionState;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Transition State Binding</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.fzi.power.binding.TransitionStateBinding#getTransitionState
 * <em>Transition State</em>}</li>
 * <li>{@link de.fzi.power.binding.TransitionStateBinding#getTransitionConsumption
 * <em>Transition Consumption</em>}</li>
 * </ul>
 *
 * @see de.fzi.power.binding.BindingPackage#getTransitionStateBinding()
 * @model
 * @generated
 */
public interface TransitionStateBinding extends AbstractPowerStateBinding {
    /**
     * Returns the value of the '<em><b>Transition State</b></em>' reference. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Transition State</em>' reference isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Transition State</em>' reference.
     * @see #setTransitionState(TransitionState)
     * @see de.fzi.power.binding.BindingPackage#getTransitionStateBinding_TransitionState()
     * @model required="true"
     * @generated
     */
    TransitionState getTransitionState();

    /**
     * Sets the value of the '{@link de.fzi.power.binding.TransitionStateBinding#getTransitionState
     * <em>Transition State</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Transition State</em>' reference.
     * @see #getTransitionState()
     * @generated
     */
    void setTransitionState(TransitionState value);

    /**
     * Returns the value of the '<em><b>Transition Consumption</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transition Consumption</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Transition Consumption</em>' containment reference.
     * @see #setTransitionConsumption(ConsumptionBehavior)
     * @see de.fzi.power.binding.BindingPackage#getTransitionStateBinding_TransitionConsumption()
     * @model containment="true" required="true"
     * @generated
     */
    ConsumptionBehavior getTransitionConsumption();

    /**
     * Sets the value of the '
     * {@link de.fzi.power.binding.TransitionStateBinding#getTransitionConsumption
     * <em>Transition Consumption</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Transition Consumption</em>' containment reference.
     * @see #getTransitionConsumption()
     * @generated
     */
    void setTransitionConsumption(ConsumptionBehavior value);

} // TransitionStateBinding
