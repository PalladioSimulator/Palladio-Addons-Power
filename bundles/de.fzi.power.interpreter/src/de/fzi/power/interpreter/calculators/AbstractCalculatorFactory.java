/**
 * 
 */
package de.fzi.power.interpreter.calculators;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.specification.BlackBoxPowerModelSpecification;
import de.fzi.power.specification.BlackBoxResourcePowerModelSpecification;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.DistributionPowerModelSpecification;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.util.SpecificationSwitch;

/**
 * @author Sebastian Krach
 *
 */
public abstract class AbstractCalculatorFactory implements CalculatorFactory {
    private SpecificationSwitch<Boolean> SUPPORTED_POWERMODELS_SWITCH = 
            new SpecificationSwitch<Boolean>() { 
        
        public Boolean caseBlackBoxDistributionPowerModelSpecification(de.fzi.power.specification.BlackBoxDistributionPowerModelSpecification object) {
            return getSupportedDistributionPowerModelIds().contains(object.getId());
        };
        
        public Boolean caseBlackBoxResourcePowerModelSpecification(BlackBoxResourcePowerModelSpecification object) {
            return getSupportedResourcePowerModelIds().contains(object.getId());
        };
        
        public Boolean defaultCase(EObject object) {
            return false;
        };
    };

    /* (non-Javadoc)
     * @see de.fzi.power.interpreter.calculators.CalculatorFactory#isCompatibleWith(de.fzi.power.specification.PowerModelSpecification)
     */
    @Override
    public boolean isCompatibleWith(PowerModelSpecification specification) {
        // TODO Auto-generated method stub
        return SUPPORTED_POWERMODELS_SWITCH.doSwitch(specification);
    }

    /* (non-Javadoc)
     * @see de.fzi.power.interpreter.calculators.CalculatorFactory#getPriority()
     */
    @Override
    public abstract int getPriority();
    
    /* (non-Javadoc)
     * @see de.fzi.power.interpreter.calculators.CalculatorFactory#instantiateDistributionPowerModelCalculator(de.fzi.power.infrastructure.PowerProvidingEntity)
     */
    @Override
    public AbstractDistributionPowerModelCalculator instantiateDistributionPowerModelCalculator(
            DistributionPowerBinding binding) {
        throw new UnsupportedOperationException("This calculator factory does not support"
                + " the instantiation of distribution power model calculators");
    }
    
    /* (non-Javadoc)
     * @see de.fzi.power.interpreter.calculators.CalculatorFactory#instantiateResourcePowerModelCalculator(de.fzi.power.infrastructure.PowerConsumingResource)
     */
    @Override
    public IResourcePowerModelCalculator instantiateResourcePowerModelCalculator(
            final ResourcePowerBinding binding) {
        throw new UnsupportedOperationException("This calculator factory does not support"
                + " the instantiation of resource power model calculators");
    }
    
    protected Set<String> getSupportedDistributionPowerModelIds() {
        return Collections.emptySet();
    }
    
    protected Set<String> getSupportedResourcePowerModelIds() {
        return Collections.emptySet();
    }
}
