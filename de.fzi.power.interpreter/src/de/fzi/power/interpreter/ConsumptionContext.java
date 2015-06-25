package de.fzi.power.interpreter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.measure.quantity.Power;

import org.apache.commons.collections15.CollectionUtils;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;

/**
 * Subsumes all the required information for evaluating the power consumption of a software system.
 * 
 * @author stier
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
     *      powerModelRegistry. Therefore it is necessary to call cleanUp() after usage.
     * 
     * @param bindingRepository
     *            The Binding repository for which the consumption context is created.
     * @param initialScope
     *            The initial scope for which the consumption prediction is performed.
     * @param powerModelRegistry
     *            The registry that keeps track of the power models on a per-resource basis.
     */
    private ConsumptionContext(PowerBindingRepository bindingRepository, AbstractEvaluationScope initialScope,
            PowerModelRegistry powerModelRegistry) {
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
     *      powerModelRegistry. Therefore it is necessary to call cleanUp() after usage.
     * 
     * @param bindingRepository
     *            The Binding repository for which the consumption context is created.
     * @param initialScope
     *            The initial scope for which the consumption prediction is performed.
     * @param powerModelRegistry
     *            The registry that keeps track of the power models on a per-resource basis.
     * @return The newly created consumption context.
     */
    public static ConsumptionContext createConsumptionContext(PowerBindingRepository bindingRepository,
            AbstractEvaluationScope initialScope, PowerModelRegistry powerModelRegistry) {
        ConsumptionContext context = new ConsumptionContext(bindingRepository, initialScope, powerModelRegistry);
        return context;
    }

    /**
     * Creates a consumption context. Calling this method is equivalent to calling
     * {@code createConsumptionContext(ppe.getDistributionPowerAssemblyContext().getPowerBindingRepository(), 
                initialScope, powerModelRegistry)}. 
     * <br>
     * Attention: the creation of the consumption context registers a listener upon the 
     *      powerModelRegistry. Therefore it is necessary to call cleanUp() after usage.
     * 
     * @param ppe
     *            The given {@link PowerProvidingEntity} is used to obtain the {@link PowerBindingRepository}
     *            for the new consumption context.
     * @param initialScope
     *            The initial scope for which the consumption prediction is performed.
     * @param powerModelRegistry
     *            The registry that keeps track of the power models on a per-resource basis.
     * @return The newly created consumption context.
     * @see #createConsumptionContext(PowerBindingRepository, AbstractEvaluationScope, PowerModelRegistry)
     */
    public static ConsumptionContext createConsumptionContext(PowerProvidingEntity ppe, AbstractEvaluationScope initialScope,
            PowerModelRegistry powerModelRegistry) {
        
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
    public Amount<Power> evaluateResourcePowerConsumption(PowerConsumingResource resource) {
        AbstractResourcePowerModelCalculator calculator = this.powerModelRegistry.getCalculator(resource);
        if (calculator == null) {
            throw new IllegalArgumentException(
                    "Cannot evaluate power consumption of given resource: "
                    + "No corresponding calculator present in underlying power model registry!");
        }
        
        Collection<MeasuringValue> args = scope.getMeasurements(resource.getProcessingResourceSpecification());
        return calculator.calculate(args);
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
     * Configures the {@link AbstractEvaluationScope} to evaluate the metrics necessary for
     * all calculators
     */
    private void updateRequiredMetrics() {
        Map<PowerConsumingResource, Set<MetricDescription>> pcrRequiredMetrics =
                powerModelRegistry.getRequiredMetricsForRegisteredCalculators();
        Map<ProcessingResourceSpecification, Set<MetricDescription>> prsRequiredMetrics =
                new HashMap<ProcessingResourceSpecification, Set<MetricDescription>>(pcrRequiredMetrics.size());
        
        for (Entry<PowerConsumingResource, Set<MetricDescription>> entry : pcrRequiredMetrics.entrySet()) {
            prsRequiredMetrics.put(entry.getKey().getProcessingResourceSpecification(), entry.getValue());
        }
        
        scope.setResourceMetricsToEvaluate(prsRequiredMetrics);
    }

    @Override
    public void resourcePowerModelChanged(AbstractResourcePowerModelCalculator calculator,
            PowerConsumingResource affectedResource) {
        //check if new calculator can work with the same metrics that are already 
        //evaluated for the resource. Otherwise throw exception.
        //if necessary, the scope could be updated to evaluate different metrics here
        //currently that is not supported
        
        Map<PowerConsumingResource, Set<MetricDescription>> pcrRequiredMetrics =
                powerModelRegistry.getRequiredMetricsForRegisteredCalculators();
        
        if (!CollectionUtils.isSubCollection(calculator.getInputMetrics(), 
                pcrRequiredMetrics.get(affectedResource))) {
            throw new IllegalArgumentException("it is currently not possibly to change the "
                    + "power model calculator of a resource, if the new calculator requires "
                    + "different metrics to be evaluated!");
        }
        
        
    }

    @Override
    public void distributionPowerModelChanged(AbstractDistributionPowerModelCalculator calculator,
            PowerProvidingEntity affectedEntity) {
        //nothing to do yet
    }

}