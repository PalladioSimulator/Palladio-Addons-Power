package de.fzi.power.interpreter.calculator.expressionoasis;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;

import de.fzi.power.binding.DistributionPowerBinding;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.AbstractDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculators.CalculatorFactory;
import de.fzi.power.interpreter.calculators.IResourcePowerModelCalculator;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;

/**
 * Implementation of the {@link CalculatorFactory} which is able to create calculators for
 * {@link DeclarativePowerModelSpecification}s.
 * 
 * @author Florian Rosenthal
 *
 */
public class CalculatorFactoryImpl implements CalculatorFactory {

    private static final EClass COMPATIBLE_POWER_MODEL_SPEC_ECLASS = SpecificationPackage.Literals.DECLARATIVE_POWER_MODEL_SPECIFICATION;

    /**
     * Determines whether this instance can handle the given power model.
     * 
     * @param specification
     *            A {@link PowerModelSpecification} instance.
     * @return {@code true} iff the given power model is a
     *         {@link DeclarativePowerModelSpecification}, {@code false} otherwise.
     * @throws NullPointerException
     *             In case {@code specification == null}.
     */
    @Override
    public boolean isCompatibleWith(final PowerModelSpecification specification) {
        return COMPATIBLE_POWER_MODEL_SPEC_ECLASS
                .isInstance(Objects.requireNonNull(specification, "Given specification must not be null."));
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public AbstractDistributionPowerModelCalculator instantiateDistributionPowerModelCalculator(
            final DistributionPowerBinding binding) {
        return new ExpressionOasisDistributionPowerModelCalculator(
                Objects.requireNonNull(binding, "Given DistributionPowerBinding must not be null."));
    }

    @Override
    public IResourcePowerModelCalculator instantiateResourcePowerModelCalculator(final ResourcePowerBinding binding) {
        return new ExpressionOasisResourcePowerModelCalculator(
                Objects.requireNonNull(binding, "Given PowerConsumingResource must not be null."));
    }

}
