/**
 * 
 */
package de.fzi.power.interpreter.calculators;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;

import de.fzi.power.binding.PowerState;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;

/**
 * Implements a central hub for creating power consumption calculators based on a set of registered PowerFactory
 * instances.
 * @author Sebastian Krach, Christian Stier
 *
 */
public class ExtensibleCalculatorInstantiatorImpl implements CalculatorInstantiator {

    public static final String CALCULATOR_FACTORY_EXTENSION_POINT = "de.fzi.power.interpreter.calculators.calculatorfactory";
    private static final String CALCULATOR_FACTORY_ATTRIBUTE_NAME = "factory";
    private static final int DEFAULT_SIZE = 4; // required to ensure backward compatibility
    private static final String CALCULATOR_FACTORY_ELEMENT_NAME = "calculatorFactory";

    protected final PriorityQueue<CalculatorFactory> factoryQueue = new PriorityQueue<CalculatorFactory>(DEFAULT_SIZE,
            new Comparator<CalculatorFactory>() {

                @Override
                public int compare(CalculatorFactory o1, CalculatorFactory o2) {
                    return Integer.compare(o1.getPriority(), o2.getPriority());
                }
            });

    public ExtensibleCalculatorInstantiatorImpl() {
        retrieveFactories();
    }

    private void retrieveFactories() {
        //retrieve all registered calculator factories
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
    public IResourcePowerModelCalculator instantiateResourceCalculator(PowerConsumingResource resource) {
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
    public AbstractDistributionPowerModelCalculator instantiatePowerProvidingEntityCalculator(PowerProvidingEntity ppe) {
        for (CalculatorFactory factory : factoryQueue) {
            if (factory.isCompatibleWith(ppe.getDistributionPowerAssemblyContext().getDistributionPowerModel())) {
                return factory.instantiateDistributionPowerModelCalculator(ppe);
            }
        }

        throw new IllegalArgumentException("The passed PowerProvidingEntity refers to an unknown power model.");
    }

    @Override
    public IResourcePowerModelCalculator instantiateStatefulResourcePowerModelCalculator(
            final StatefulPowerConsumingResource resource) {
        final Map<PowerState, IResourcePowerModelCalculator> powerCalculatorsPerState = new HashMap<PowerState, IResourcePowerModelCalculator>();
        for(PowerState state : resource.getStatefulResourcePowerBinding().getPowerStates()) {
            ResourcePowerBinding binding = state.getBinding();
            powerCalculatorsPerState.put(state, this.instantiateResourceCalculator(binding));
        }
        return new StatefulPowerConsumingResourceCalculator(resource, powerCalculatorsPerState);
    }

}
