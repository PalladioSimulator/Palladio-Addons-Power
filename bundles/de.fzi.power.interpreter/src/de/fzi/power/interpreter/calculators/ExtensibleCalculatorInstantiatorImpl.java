/**
 * 
 */
package de.fzi.power.interpreter.calculators;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javax.measure.quantity.Duration;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;

import de.fzi.power.binding.AbstractPowerStateBinding;
import de.fzi.power.binding.PowerStateBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.TransitionStateBinding;
import de.fzi.power.binding.util.BindingSwitch;
import de.fzi.power.infrastructure.PowerConsumingResourceSet;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.StatefulPowerConsumingResourceSet;

/**
 * Implements a central hub for creating power consumption calculators based on a set of registered
 * PowerFactory instances.
 * 
 * @author Sebastian Krach, Christian Stier
 *
 */
public class ExtensibleCalculatorInstantiatorImpl implements CalculatorInstantiator {

    public static final String CALCULATOR_FACTORY_EXTENSION_POINT = "de.fzi.power.interpreter.calculators.calculatorfactory";
    private static final String CALCULATOR_FACTORY_ATTRIBUTE_NAME = "factory";
    private static final int DEFAULT_SIZE = 4; // required to ensure backward compatibility
    private static final String CALCULATOR_FACTORY_ELEMENT_NAME = "calculatorFactory";

    ITimeProvider timeProvider;

    protected final PriorityQueue<CalculatorFactory> factoryQueue = new PriorityQueue<CalculatorFactory>(DEFAULT_SIZE,
            new Comparator<CalculatorFactory>() {

                @Override
                public int compare(CalculatorFactory o1, CalculatorFactory o2) {
                    return Integer.compare(o1.getPriority(), o2.getPriority());
                }
            });

    /**
     * Instantiates the Calculator Factory. The Calculator Factory uses all registered factories to
     * create Power Model Calculators. It calls
     * {@link #ExtensibleCalculatorInstantiatorImpl(ITimeProvider)} using a placeholder
     * {@link ITimeProvider} that always defaults to 0.
     */
    public ExtensibleCalculatorInstantiatorImpl() {
        this(new ITimeProvider() {
            @Override
            public Amount<Duration> getCurrentTime() {
                return Amount.valueOf(0, Duration.UNIT);
            }
        });
    }

    /**
     * Instantiates the extensible Calculator Factory. The Calculator Factory uses all registered
     * factories to create Power Model Calculators. This allows for an extension of supported
     * Calculators in external plugins.
     * 
     * @param provider
     *            The time provider used for time-dependent Power Consumption Calculators like
     *            {@link TransitionStatePowerModelCalculator}.
     */
    public ExtensibleCalculatorInstantiatorImpl(final ITimeProvider provider) {
        this.timeProvider = provider;
        retrieveFactories();
    }

    private void retrieveFactories() {
        // retrieve all registered calculator factories
        Collection<CalculatorFactory> factories = ExtensionHelper.getExecutableExtensions(
                CALCULATOR_FACTORY_EXTENSION_POINT, CALCULATOR_FACTORY_ELEMENT_NAME, CALCULATOR_FACTORY_ATTRIBUTE_NAME);
        this.factoryQueue.addAll(factories);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.fzi.power.interpreter.calculators.CalculatorInstantiator#instantiateResourceCalculator
     * (de.fzi.power.infrastructure.PowerConsumingResource)
     */
    @Override
    public IResourcePowerModelCalculator instantiateResourceCalculator(PowerConsumingResourceSet resource) {
        return this.instantiateResourceCalculator(resource.getResourcePowerAssemblyContext());
    }

    protected IResourcePowerModelCalculator instantiateResourceCalculator(final ResourcePowerBinding binding) {
        for (CalculatorFactory factory : factoryQueue) {
            if (factory.isCompatibleWith(binding.getResourcePowerModelSpecification())) {
                return factory.instantiateResourcePowerModelCalculator(binding);
            }
        }

        throw new IllegalArgumentException("The passed ResourcePowerAssemblyContext refers to an unknown power model.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fzi.power.interpreter.calculators.CalculatorInstantiator#
     * instantiatePowerProvidingEntityCalculator(de.fzi.power.infrastructure.PowerProvidingEntity)
     */
    @Override
    public AbstractDistributionPowerModelCalculator instantiatePowerProvidingEntityCalculator(
            PowerProvidingEntity ppe) {
        for (CalculatorFactory factory : factoryQueue) {
            if (factory.isCompatibleWith(ppe.getDistributionPowerAssemblyContext().getDistributionPowerModel())) {
                return factory.instantiateDistributionPowerModelCalculator(ppe.getDistributionPowerAssemblyContext());
            }
        }

        throw new IllegalArgumentException("The passed PowerProvidingEntity refers to an unknown power model.");
    }

    @Override
    public IResourcePowerModelCalculator instantiateStatefulResourcePowerModelCalculator(
            final StatefulPowerConsumingResourceSet resource) {
        final Map<AbstractPowerStateBinding, IResourcePowerModelCalculator> powerCalculatorsPerState = new HashMap<AbstractPowerStateBinding, IResourcePowerModelCalculator>();
        for (AbstractPowerStateBinding curStateBinding : resource.getStatefulResourcePowerBinding()
                .getPowerStateBindings()) {
            new BindingSwitch<Void>() {
                public Void casePowerStateBinding(PowerStateBinding state) {
                    ResourcePowerBinding binding = state.getBinding();
                    powerCalculatorsPerState.put(state, instantiateResourceCalculator(binding));
                    return null;
                }

                public Void caseTransitionStateBinding(TransitionStateBinding state) {
                    powerCalculatorsPerState.put(state,
                            new TransitionStatePowerModelCalculator(resource, state, timeProvider));
                    return null;
                };
            }.doSwitch(curStateBinding);
        }
        return new StatefulPowerConsumingResourceCalculator(resource, powerCalculatorsPerState);
    }

}
