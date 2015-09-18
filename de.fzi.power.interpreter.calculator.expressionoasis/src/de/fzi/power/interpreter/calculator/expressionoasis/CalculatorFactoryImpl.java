package de.fzi.power.interpreter.calculator.expressionoasis;

import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.interpreter.calculators.CalculatorFactory;
import de.fzi.power.specification.PowerModelSpecification;

public class CalculatorFactoryImpl implements CalculatorFactory {
    

    @Override
    public boolean isCompatibleWith(PowerModelSpecification specification) {
        return specification.getName().startsWith(
                ExpressionOasisPowerModelCalculator.REGRESSION_POWER_MODEL_IDENTIFIER 
                + ExpressionOasisPowerModelCalculator.MODEL_NAME_SPECIFICATION_SEPARATOR);
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public AbstractDistributionPowerModelCalculator instantiateDistributionPowerModelCalculator(
            PowerProvidingEntity forEntity) {
        throw new UnsupportedOperationException("This calculator factory only supports "
                + "resource power model calculators");
    }

    @Override
    public AbstractResourcePowerModelCalculator instantiateResourcePowerModelCalculator(
            PowerConsumingResource forResource) {
        return new ExpressionOasisPowerModelCalculator(forResource);
    }

}
