package de.fzi.power.interpreter.calculators.essential;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractCalculatorFactory;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.IResourcePowerModelCalculator;
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
    
    public EssentialCalculatorsFactory() {
        super();
    }
    
    @Override
    public IResourcePowerModelCalculator instantiateResourcePowerModelCalculator(
            final ResourcePowerBinding binding) {
        IResourcePowerModelCalculator calculator = null;
        
        if (binding.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.LINEAR_POWER_MODEL.getId())) {
            calculator = new LinearPowerModelCalculator(binding);
        } else if(binding.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.NONLINEAR_REGRESSION_MODEL.getId())) {
            calculator = new NonlinearRegressionCalculator(binding);
        } else if(binding.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.INTERPOLATION_MODEL.getId())) {
            calculator = new InterpolationModelCalculator(binding);
        }
        
        return calculator != null ? calculator : 
            super.instantiateResourcePowerModelCalculator(binding);
    }
    
    @Override
    public AbstractDistributionPowerModelCalculator instantiateDistributionPowerModelCalculator(
            DistributionPowerBinding binding) {
        AbstractDistributionPowerModelCalculator calculator = null;
        
        if (binding.getDistributionPowerModel().getId().equals(PowerModelConstants.LINEAR_PASSTHROUGH_DISTRIBUTION.getId())) {
            calculator = new LinearPassthroughCalculator(binding);
        } 
        
        return calculator != null ? calculator : 
            super.instantiateDistributionPowerModelCalculator(binding);
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
