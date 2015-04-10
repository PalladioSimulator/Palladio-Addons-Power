package de.fzi.power.interpreter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.palladiosimulator.commons.designpatterns.AbstractObservable;
import org.palladiosimulator.metricspec.MetricDescription;

import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;

/**
 * Registry through which the power models of the resources and distribution units are managed.
 * 
 * @author stier
 *
 */
public class PowerModelRegistry extends AbstractObservable<PowerModelRegistryChangeListener> {

    // List of calculators per active resource.
    private HashMap<PowerConsumingResource, AbstractResourcePowerModelCalculator> calculatorsPerResource;
    // List of calculators per power distribution unit.
    private HashMap<PowerProvidingEntity, AbstractDistributionPowerModelCalculator> calculatorsPerPdu;

    /**
     * Create a power model registry.
     */
    public PowerModelRegistry() {
        this.calculatorsPerResource = new HashMap<PowerConsumingResource, AbstractResourcePowerModelCalculator>();
        this.calculatorsPerPdu = new HashMap<PowerProvidingEntity, AbstractDistributionPowerModelCalculator>();
    }

    /**
     * Update the power model of a specific resource.
     * 
     * @param powerConsumingResource
     *            The resource for which the power model specification is updated.
     * @param resourceCalculator
     *            The calculator used to evaluate the power consumption of a resource.
     */
    public void updateResourcePowerModel(PowerConsumingResource powerConsumingResource,
            AbstractResourcePowerModelCalculator resourceCalculator) {
        if (resourceCalculator == null || powerConsumingResource == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        if (!calculatorsPerResource.containsKey(powerConsumingResource)
                || !calculatorsPerResource.get(powerConsumingResource).equals(resourceCalculator)) {
            calculatorsPerResource.put(powerConsumingResource, resourceCalculator);
            getEventDispatcher().resourcePowerModelChanged(resourceCalculator, 
                    powerConsumingResource);
        }

    }

    /**
     * Update the power model of a {@link PowerProvidingEntity}.
     * 
     * @param ppe
     *            the entity for which the power model is set.
     * @param pduCalculator
     *            The calculator for the power distribution model of {@code ppe}.
     */
    public void updateDistributionPowerModel(PowerProvidingEntity ppe,
            AbstractDistributionPowerModelCalculator pduCalculator) {
        if (pduCalculator == null || ppe == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        if (!calculatorsPerPdu.containsKey(ppe) || !calculatorsPerPdu.get(ppe).equals(pduCalculator)) {
            calculatorsPerPdu.put(ppe, pduCalculator);
            getEventDispatcher().distributionPowerModelChanged(pduCalculator, ppe);
        }
    }

     /**
     * Get the calculator that is set for a specific {@link PowerConsumingResource}.
     * 
     * @param resource
     *            The resource for which the calculator is retrieved.
     * @return The calculator set for the {@code resource}.
     */
    public AbstractResourcePowerModelCalculator getCalculator(PowerConsumingResource resource) {
        return this.calculatorsPerResource.get(resource);
    }

    /**
     * Gets the calculator set for a specific {@link PowerProvidingEntity}.
     * 
     * @param entity
     *            The entity for which the distribution power model is retrieved.
     * @return The predicted power consumption.
     */
    public AbstractDistributionPowerModelCalculator getCalculator(PowerProvidingEntity entity) {
        return this.calculatorsPerPdu.get(entity);
    }

    /**
     * Gets a map specifying for each {@link PowerConsumingResource} which metrics are required for
     * the associated {@link AbstractResourcePowerModelCalculator} to calculate the power
     * consumption values
     * 
     * @return an UNMODIFIABLE map linking {@link PowerConsumingResource}s to multiple {@link MetricDescription}s
     */
    public Map<PowerConsumingResource, Set<MetricDescription>> getRequiredMetricsForRegisteredCalculators() {
        Map<PowerConsumingResource, Set<MetricDescription>> result = new HashMap<PowerConsumingResource, Set<MetricDescription>>(
                calculatorsPerResource.size());
        for (Entry<PowerConsumingResource, AbstractResourcePowerModelCalculator> entry : calculatorsPerResource
                .entrySet()) {
            result.put(entry.getKey(), entry.getValue().getInputMetrics());
        }
        return Collections.unmodifiableMap(result);
    }

}
