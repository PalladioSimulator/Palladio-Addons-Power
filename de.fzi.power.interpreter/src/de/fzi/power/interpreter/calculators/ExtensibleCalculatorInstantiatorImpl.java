/**
 * 
 */
package de.fzi.power.interpreter.calculators;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;

import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;

/**
 * @author Sebastian Krach
 *
 */
public class ExtensibleCalculatorInstantiatorImpl implements CalculatorInstantiator {

    public static final String CALCULATOR_FACTORY_EXTENSION_POINT = "de.fzi.power.interpreter.calculators.calculatorfactory";
    private static final String CALCULATOR_FACTORY_PROPERTY_NAME = "factory";
    private static final int DEFAULT_SIZE = 4; // required to ensure backward compatibility

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
                CALCULATOR_FACTORY_EXTENSION_POINT, CALCULATOR_FACTORY_PROPERTY_NAME);
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
    public AbstractResourcePowerModelCalculator instantiateResourceCalculator(PowerConsumingResource resource) {
        for (CalculatorFactory factory : factoryQueue) {
            if (factory.isCompatibleWith(resource.getResourcePowerAssemblyContext()
                    .getResourcePowerModelSpecification())) {
                return factory.instantiateResourcePowerModelCalculator(resource);
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

}
