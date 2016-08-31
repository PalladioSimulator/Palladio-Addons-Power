package de.fzi.power.interpreter;

import de.fzi.power.infrastructure.AbstractPowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.IResourcePowerModelCalculator;

/**
 * Listener interface to be implemented by classes which want to be notified upon changes of
 * {@link PowerModelRegistry}s
 * 
 * @author Sebastian Krach
 *
 */
public interface PowerModelRegistryChangeListener {

    /**
     * Method is called just before a new calculator is set for a power consuming resource.
     * 
     * @param calculator
     *            the new calculator
     * @param affectedResource
     *            the affected resource
     */
    void resourcePowerModelChanged(IResourcePowerModelCalculator calculator,
            AbstractPowerConsumingResource affectedResource);

    /**
     * Method is called just before a new calculator is set for a power providing entity.
     * 
     * @param calculator
     *            the new calculator
     * @param affectedEntity
     *            the affected resource
     */
    void distributionPowerModelChanged(AbstractDistributionPowerModelCalculator calculator,
            PowerProvidingEntity affectedEntity);

}
