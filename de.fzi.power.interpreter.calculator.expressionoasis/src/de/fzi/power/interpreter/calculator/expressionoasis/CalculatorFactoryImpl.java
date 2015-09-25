package de.fzi.power.interpreter.calculator.expressionoasis;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.interpreter.calculators.CalculatorFactory;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;

public class CalculatorFactoryImpl implements CalculatorFactory {

    private static final EClass COMPATIBLE_POWER_MODEL_SPEC_ECLASS = SpecificationPackage.Literals.DECLARATIVE_POWER_MODEL_SPECIFICATION;

    @Override
    public boolean isCompatibleWith(PowerModelSpecification specification) {
        return Objects.requireNonNull(specification, "Given specification must not be null.")
                .eClass() == COMPATIBLE_POWER_MODEL_SPEC_ECLASS;
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public AbstractDistributionPowerModelCalculator instantiateDistributionPowerModelCalculator(
            PowerProvidingEntity forEntity) {
        return new ExpressionOasisDistributionPowerModelCalculator(
                Objects.requireNonNull(forEntity, "Given PowerProvidingEntity must not be null."));
    }

    @Override
    public AbstractResourcePowerModelCalculator instantiateResourcePowerModelCalculator(
            PowerConsumingResource forResource) {
        return new ExpressionOasisResourcePowerModelCalculator(
                Objects.requireNonNull(forResource, "Given PowerConsumingResource must not be null."));
    }

}
