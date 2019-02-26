package de.fzi.power.interpreter.calculators;

import de.fzi.power.infrastructure.PowerConsumingResourceSet;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.StatefulPowerConsumingResourceSet;

public interface CalculatorInstantiator {

    /**
     * Creates a {@link AbstractResourcePowerModelCalculator} for a {@link PowerConsumingResource}.
     * The calculator type is selected based on the
     * {@link PowerConsumingResource#getResourcePowerAssemblyContext()} of the
     * {@link PowerConsumingResource}.
     * 
     * @param resource
     *            The resource for which the calculator is created.
     * @return The created calculator.
     */
    public abstract IResourcePowerModelCalculator instantiateResourceCalculator(PowerConsumingResourceSet resource);

    /**
     * Creates a {@link AbstractDistributionPowerModelCalculator} for a {@link PowerProvidingEntity}
     * . The calculator type is selected based on the
     * {@link PowerProvidingEntity#getDistributionPowerAssemblyContext()}.
     * 
     * @param ppe
     *            The entity for which the calculator is created.
     * @return The created distribution power model calculator.
     */
    public abstract AbstractDistributionPowerModelCalculator instantiatePowerProvidingEntityCalculator(
            PowerProvidingEntity ppe);
    
    
    /**
     * Instantiate the resource power model calculator of a stateful resource.
     *
     * @param resource the resource for which the power model is generated.
     * @return the abstract resource power model calculator
     */
    public abstract IResourcePowerModelCalculator instantiateStatefulResourcePowerModelCalculator(
            StatefulPowerConsumingResourceSet resource);

}