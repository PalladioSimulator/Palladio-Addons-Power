package de.fzi.power.interpreter.calculators.essential;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractCalculatorFactory;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.specification.resources.PowerModelConstants;

public class EssentialCalculatorsFactory extends AbstractCalculatorFactory {
    private static final int ESSENTIAL_POWER_MODEL_CALCULATORS_PRIORITY = 50;
    
    private static final Set<String> SUPPORTED_DISTRIBUTION_MODELS = 
            new HashSet<String>(Arrays.asList(
                    PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION.getId()));
    
    private static final Set<String> SUPPORTED_RESOURCE_MODELS =
            new HashSet<String>(Arrays.asList(
                    PowerModelConstants.LINEAR_POWER_MODEL.getId(),
                    PowerModelConstants.NONLINEAR_REGRESSION_MODEL.getId(),
                    PowerModelConstants.INTERPOLATION_MODEL.getId()));
    
    
    @Override
    public AbstractResourcePowerModelCalculator instantiateResourcePowerModelCalculator(
            PowerConsumingResource forResource) {
        AbstractResourcePowerModelCalculator calculator = null;
        ResourcePowerBinding context = forResource.getResourcePowerAssemblyContext();
        
        if (context.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.LINEAR_POWER_MODEL.getId())) {
            calculator = new LinearPowerModelCalculator(forResource);
        } else if(context.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.NONLINEAR_REGRESSION_MODEL.getId())) {
            calculator = new NonlinearRegressionCalculator(forResource);
        } else if(context.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.INTERPOLATION_MODEL.getId())) {
            calculator = new InterpolationModelCalculator(forResource);
        }
        
        return calculator != null ? calculator : 
            super.instantiateResourcePowerModelCalculator(forResource);
    }
    
    @Override
    public AbstractDistributionPowerModelCalculator instantiateDistributionPowerModelCalculator(
            PowerProvidingEntity forEntity) {
        AbstractDistributionPowerModelCalculator calculator = null;
        DistributionPowerBinding context = forEntity.getDistributionPowerAssemblyContext();
        
        if (context.getDistributionPowerModel().getId().equals(PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION.getId())) {
            calculator = new LinearPassthroughCalculator(forEntity);
        } 
        
        return calculator != null ? calculator : 
            super.instantiateDistributionPowerModelCalculator(forEntity);
    }
    
    
    @Override
    public int getPriority() {
        return ESSENTIAL_POWER_MODEL_CALCULATORS_PRIORITY;
    }
    
    @Override
    protected Set<String> getSupportedDistributionPowerModelIds() {
        return Collections.unmodifiableSet(SUPPORTED_DISTRIBUTION_MODELS);
    }
    
    @Override
    protected Set<String> getSupportedResourcePowerModelIds() {
        return Collections.unmodifiableSet(SUPPORTED_RESOURCE_MODELS);
    }

}
