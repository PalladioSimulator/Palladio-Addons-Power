package de.fzi.power.interpreter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import org.palladiosimulator.commons.designpatterns.AbstractObservable;
import org.palladiosimulator.metricspec.MetricDescription;

import de.fzi.power.infrastructure.AbstractPowerConsumingResource;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.interpreter.calculators.IResourcePowerModelCalculator;

/**
 * Registry through which the power models of the resources and distribution units are managed.
 * 
 * @author Christian Stier, Florian Rosenthal
 *
 */
public class PowerModelRegistry extends AbstractObservable<PowerModelRegistryChangeListener> {

    // List of calculators per active resource.
    private final HashMap<AbstractPowerConsumingResource, IResourcePowerModelCalculator> calculatorsPerResource;
    // List of calculators per power distribution unit.
    private final HashMap<PowerProvidingEntity, AbstractDistributionPowerModelCalculator> calculatorsPerPdu;

    /**
     * Create a power model registry.
     */
    public PowerModelRegistry() {
        this.calculatorsPerResource = new HashMap<AbstractPowerConsumingResource, IResourcePowerModelCalculator>();
        this.calculatorsPerPdu = new HashMap<PowerProvidingEntity, AbstractDistributionPowerModelCalculator>();
    }

    /**
     * Updates the power model of a specific resource.
     * 
     * @param powerConsumingResource
     *            The resource for which the power model specification is updated.
     * @param resourceCalculator
     *            The calculator used to evaluate the power consumption of a resource.
     */
    public void updateResourcePowerModel(PowerConsumingResource powerConsumingResource,
            IResourcePowerModelCalculator resourceCalculator) {
        if (resourceCalculator == null || powerConsumingResource == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        if (!calculatorsPerResource.containsKey(powerConsumingResource)
                || !calculatorsPerResource.get(powerConsumingResource).equals(resourceCalculator)) {
            calculatorsPerResource.put(powerConsumingResource, resourceCalculator);
            getEventDispatcher().resourcePowerModelChanged(resourceCalculator, powerConsumingResource);
        }

    }
    
    public void updateStatefulPowerConsumingResource(StatefulPowerConsumingResource powerConsumingResource,
            IResourcePowerModelCalculator resourceCalculator) {
        if (!calculatorsPerResource.containsKey(powerConsumingResource)
                || !calculatorsPerResource.get(powerConsumingResource).equals(resourceCalculator)) {
            calculatorsPerResource.put(powerConsumingResource, resourceCalculator);
            getEventDispatcher().resourcePowerModelChanged(resourceCalculator, powerConsumingResource);
        }
    }

    /**
     * Updates the power model of a {@link PowerProvidingEntity}.
     * 
     * @param ppe
     *            the entity for which the power model is set.
     * @param pduCalculator
     *            The {@link AbstractDistributionPowerModelCalculator} instance for the power
     *            distribution model of {@code ppe}.
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
     * Gets the calculator that is set for a specific resource.
     * 
     * @param resource
     *            The {@link PowerConsumingResource} for which the calculator shall be retrieved.
     * @return The {@link AbstractResourcePowerModelCalculator} set for the {@code resource}, or
     *         {@code null} if none is found.
     * @throws NullPointerException
     *             In case {@code resource == null}.
     */
    public IResourcePowerModelCalculator getCalculator(AbstractPowerConsumingResource resource) {
        return this.calculatorsPerResource.get(Objects.requireNonNull(resource));
    }

    /**
     * Gets the calculator that is set for a specific power providing entity.
     * 
     * @param entity
     *            The {@link PowerProvidingEntity} for which the calculator shall be retrieved.
     * @return The {@link AbstractDistributionPowerModelCalculator} set for the {@code entity}, or
     *         {@code null} if none is found. * @throws NullPointerException In case
     *         {@code entity == null}.
     */
    public AbstractDistributionPowerModelCalculator getCalculator(PowerProvidingEntity entity) {
        return this.calculatorsPerPdu.get(Objects.requireNonNull(entity));
    }

    /**
     * Gets a map specifying for each {@link PowerConsumingResource} which metrics are required for
     * the associated {@link AbstractResourcePowerModelCalculator} to calculate the power
     * consumption values
     * 
     * @return an UNMODIFIABLE map linking {@link PowerConsumingResource}s to multiple
     *         {@link MetricDescription}s
     */
    public Map<AbstractPowerConsumingResource, Set<MetricDescription>> getRequiredMetricsForRegisteredCalculators() {
        Map<AbstractPowerConsumingResource, Set<MetricDescription>> result = new HashMap<AbstractPowerConsumingResource, Set<MetricDescription>>(
                calculatorsPerResource.size());
        for (Entry<AbstractPowerConsumingResource, IResourcePowerModelCalculator> entry : calculatorsPerResource
                .entrySet()) {
            result.put(entry.getKey(), entry.getValue().getInputMetrics());
        }
        return Collections.unmodifiableMap(result);
    }

}
