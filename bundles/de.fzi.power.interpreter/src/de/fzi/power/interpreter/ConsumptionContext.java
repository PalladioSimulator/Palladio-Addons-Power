package de.fzi.power.interpreter;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.measure.quantity.Power;

import org.apache.commons.collections15.CollectionUtils;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;

import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.infrastructure.AbstractPowerConsumingResource;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.StatefulPowerConsumingResourceSet;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.IResourcePowerModelCalculator;
import de.fzi.power.specification.DistributionPowerModelSpecification;

/**
 * Subsumes all the required information for evaluating the power consumption of a software system.
 * 
 * @author Christian Stier, Sebastian Krach, Florian Rosenthal
 *
 */
public final class ConsumptionContext implements PowerModelRegistryChangeListener {

    private final PowerBindingRepository bindingRepository;
    private final AbstractEvaluationScope scope;
    private final PowerModelRegistry powerModelRegistry;

    /**
     * Create a consumption context.
     * 
     * Attention: the creation of the consumption context registers a listener upon the
     * powerModelRegistry. Therefore it is necessary to call cleanUp() after usage.
     * 
     * @param bindingRepository
     *            The Binding repository for which the consumption context is created.
     * @param initialScope
     *            The initial scope for which the consumption prediction is performed.
     * @param powerModelRegistry
     *            The registry that keeps track of the power models on a per-resource basis.
     */
    private ConsumptionContext(final PowerBindingRepository bindingRepository,
            final AbstractEvaluationScope initialScope, final PowerModelRegistry powerModelRegistry) {
        if (bindingRepository == null || initialScope == null || powerModelRegistry == null) {
            throw new IllegalArgumentException("One of the given parameters was null!");
        }
        this.bindingRepository = bindingRepository;
        this.scope = initialScope;
        this.powerModelRegistry = powerModelRegistry;

        updateRequiredMetrics();

        powerModelRegistry.addObserver(this);
    }

    /**
     * Creates a consumption context.
     * 
     * Attention: the creation of the consumption context registers a listener upon the
     * powerModelRegistry. Therefore it is necessary to call cleanUp() after usage.
     * 
     * @param bindingRepository
     *            The Binding repository for which the consumption context is created.
     * @param initialScope
     *            The initial scope for which the consumption prediction is performed.
     * @param powerModelRegistry
     *            The registry that keeps track of the power models on a per-resource basis.
     * @return The newly created consumption context.
     * @throws IllegalArgumentException
     *             In case any of the parameters is {@code null}.
     */
    public static ConsumptionContext createConsumptionContext(final PowerBindingRepository bindingRepository,
            final AbstractEvaluationScope initialScope, final PowerModelRegistry powerModelRegistry) {
        ConsumptionContext context = new ConsumptionContext(bindingRepository, initialScope, powerModelRegistry);
        return context;
    }

    /**
     * Creates a consumption context. Calling this method is equivalent to calling
     * {@code createConsumptionContext(ppe.getDistributionPowerAssemblyContext().getPowerBindingRepository(), 
                initialScope, powerModelRegistry)}. <br>
     * Attention: the creation of the consumption context registers a listener upon the
     * powerModelRegistry. Therefore it is necessary to call cleanUp() after usage.
     * 
     * @param ppe
     *            The given {@link PowerProvidingEntity} is used to obtain the
     *            {@link PowerBindingRepository} for the new consumption context.
     * @param initialScope
     *            The initial scope for which the consumption prediction is performed.
     * @param powerModelRegistry
     *            The registry that keeps track of the power models on a per-resource basis.
     * @return The newly created consumption context.
     * @see #createConsumptionContext(PowerBindingRepository, AbstractEvaluationScope,
     *      PowerModelRegistry)
     */
    public static ConsumptionContext createConsumptionContext(final PowerProvidingEntity ppe,
            final AbstractEvaluationScope initialScope, final PowerModelRegistry powerModelRegistry) {

        if (ppe == null || ppe.getDistributionPowerAssemblyContext() == null) {
            throw new IllegalArgumentException("PowerProvidingEntity is null or "
                    + "not associated with a valid PowerBindingRepository instance.");
        }
        return new ConsumptionContext(ppe.getDistributionPowerAssemblyContext().getPowerBindingRepository(),
                initialScope, powerModelRegistry);
    }

    /**
     * Evaluates the power consumption of a passed resource. The consumption is evaluated in context
     * to the current EvaluationScope.
     * 
     * @param resource
     *            The PowerConsumingResource for which the power consumption is being evaluated.
     * @return The power consumed by the resource.
     */
    public Amount<Power> evaluateResourcePowerConsumption(final AbstractPowerConsumingResource resource) {
        IResourcePowerModelCalculator calculator = this.powerModelRegistry
                .getCalculator(Objects.requireNonNull(resource, "Given resource must not be null."));
        if (calculator == null) {
            throw new IllegalArgumentException("Cannot evaluate power consumption of given resource: "
                    + "No corresponding calculator present in underlying power model registry!");
        }

        // TODO: Allow for more than one processing resource.
        Collection<MeasuringValue> args = this.scope.getMeasurements(resource.getProcessingResourceSpecifications().get(0));
        return calculator.calculate(args);
    }

    /**
     * Evaluates the power consumption of a passed stateful resource. The consumption is evaluated
     * in context to the current EvaluationScope.
     * 
     * @param resource
     *            The PowerConsumingResource for which the power consumption is being evaluated.
     * @return The power consumed by the resource.
     */
    public Amount<Power> evaluateStatefulResourcePowerConsumption(final StatefulPowerConsumingResourceSet resource) {
        return this.evaluateResourcePowerConsumption(resource);
    }

    /**
     * Evaluates the consumed power which is supplied by the given power providing entity.
     * 
     * @param powerConsumingProvidingEntity
     *            The {@link PowerConsumingProvidingEntity} which supplies power to consumers
     * @param consumers
     *            A {@link Map} that contains the currently consumed power of all
     *            {@link PowerConsumingEntity} which are supplied by the given power providing
     *            entity.
     * @return The total power usage of the providing entity, expressed in terms of an
     *         {@link Amount}, according to the underlying
     *         {@link DistributionPowerModelSpecification}.
     * @throws IllegalArgumentException
     *             In case no {@link DistributionPowerModelSpecification} (more precisely, no
     *             {@link AbstractDistributionPowerModelCalculator}) could be found.
     * @throws IllegalArgumentException
     *             In case any of the {@link PowerConsumingEntity}s passed in the {@code consumers}
     *             map is not supplied by the given {@code powerConsumingProvidingEntity}.
     * @throws NullPointerException
     *             In case either of the arguments is {@code null}.
     */
    public Amount<Power> evaluateDistributionPowerConsumption(
            final PowerConsumingProvidingEntity powerConsumingProvidingEntity,
            final Map<PowerConsumingEntity, Amount<Power>> consumers) {
        AbstractDistributionPowerModelCalculator distributionPowerCalculator = this.powerModelRegistry
                .getCalculator(Objects.requireNonNull(powerConsumingProvidingEntity, "Given entity must not be null."));
        if (distributionPowerCalculator == null) {
            throw new IllegalArgumentException("Cannot evaluate power consumption of given distribution entity: "
                    + "No corresponding calculator present in underlying power model registry!");
        }
        // sanity check
        Objects.requireNonNull(consumers, "Map of consumers must not be null");
        for (PowerConsumingEntity consumer : consumers.keySet()) {
            if (!powerConsumingProvidingEntity.getId().equals(consumer.getPowerProvidingEntity().getId())) {
                throw new IllegalArgumentException("Power of " + consumer.getClass().getSimpleName() + "'"
                        + consumer.getName() + "' is not supplied by the given providing entity '"
                        + powerConsumingProvidingEntity.getName() + "'!");
            }
        }
        return distributionPowerCalculator.calculate(consumers);
    }

    /**
     * Get the PowerBindingRepository associated with the ConsumptionCotext.
     * 
     * @return The ConsumptionContext for which the power consumption is being evaluated.
     */
    public PowerBindingRepository getPowerBindingRepository() {
        return this.bindingRepository;
    }

    /**
     * Since the ConsumptionContext registers change listener to the referenced PowerModelRegistry
     * it is important to call cleanUp before discarding the ConsumptionContext instance.
     * 
     */
    public void cleanUp() {
        powerModelRegistry.removeObserver(this);
    }

    /**
     * Configures the {@link AbstractEvaluationScope} to evaluate the metrics necessary for all
     * calculators
     */
    private void updateRequiredMetrics() {
        Map<AbstractPowerConsumingResource, Set<MetricDescription>> requiredMetricsPerResource = powerModelRegistry
                .getRequiredMetricsForRegisteredCalculators();

        // TODO allow for more than 1 resource.
        this.scope.setResourceMetricsToEvaluate(requiredMetricsPerResource.entrySet().stream().collect(Collectors
                .toMap(entry -> entry.getKey().getProcessingResourceSpecifications().get(0), entry -> entry.getValue())));
    }

    @Override
    public void resourcePowerModelChanged(final IResourcePowerModelCalculator calculator,
            final AbstractPowerConsumingResource affectedResource) {
        // check if new calculator can work with the same metrics that are already
        // evaluated for the resource. Otherwise throw exception.
        // if necessary, the scope could be updated to evaluate different metrics here
        // currently that is not supported

        Map<AbstractPowerConsumingResource, Set<MetricDescription>> requiredMetricsPerResource = powerModelRegistry
                .getRequiredMetricsForRegisteredCalculators();

        if (!CollectionUtils.isSubCollection(calculator.getInputMetrics(),
                requiredMetricsPerResource.get(affectedResource))) {
            throw new IllegalArgumentException("it is currently not possibly to change the "
                    + "power model calculator of a resource, if the new calculator requires "
                    + "different metrics to be evaluated!");
        }

    }

    @Override
    public void distributionPowerModelChanged(final AbstractDistributionPowerModelCalculator calculator,
            final PowerProvidingEntity affectedEntity) {
        // nothing to do yet
    }

}