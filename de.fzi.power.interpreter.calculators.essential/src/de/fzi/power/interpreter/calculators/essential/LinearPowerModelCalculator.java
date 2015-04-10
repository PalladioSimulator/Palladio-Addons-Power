package de.fzi.power.interpreter.calculators.essential;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.specification.resources.PowerModelConstants;

/**
 * Creates a calculator that evaluates the power consumption of a {@link PowerConsumingResource} by
 * interpolating between the resource's minimum and maximum power consumption using the utilization
 * of the specific resource.
 * 
 * @author stier
 *
 */
public class LinearPowerModelCalculator extends AbstractResourcePowerModelCalculator {

    // Maximum power consumption of the resource.
    private Amount<Power> maximumPower;
    // Minimum power consumption of the resource.
    private Amount<Power> minimumPower;
    private final static MetricDescription utilMetric = MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE;

    /**
     * Create a calculator for a linear power model.
     * 
     * @param powerConsumingResource
     *            The resource for which the calculator is created.
     */
    public LinearPowerModelCalculator(PowerConsumingResource powerConsumingResource) {
        super(powerConsumingResource);

        if (!binding.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.LINEAR_POWER_MODEL.getId())) {
            throw new IllegalArgumentException("Referred model wasn't the linear power model from"
                    + PowerModelConstants.LINEAR_POWER_MODEL.eResource().getURI() + ".");
        }

        for (FixedFactorValue value : binding.getFixedFactorValues()) {
            String boundFactorId = value.getBoundFactor().getId();
            Unit<Power> unit = value.getValue().getUnit();
            Amount<Power> valueInAmount = Amount.valueOf(value.getValue().doubleValue(unit), unit);
            if (boundFactorId.equals(PowerModelConstants.LINEAR_POWER_MODEL_MIN_CONSUMPTION.getId())) {
                minimumPower = valueInAmount;
            } else if (boundFactorId.equals(PowerModelConstants.LINEAR_POWER_MODEL_MAX_CONSUMPTION.getId())) {
                maximumPower = valueInAmount;
            } else {
                throw new IllegalArgumentException("One of the factor values wasn't a min or max consumption value.");
            }
        }

    }

    /**
     * Calculate the power consumption using a linear power model.
     * 
     * @param measurements
     *            The utilization parameter used in the evaluation. The linear power model
     *            calculator expects that the list has a length of {@code 1} and contains a singular
     *            {@link MetricDescriptionConstants#UTILIZATION_OF_ACTIVE_RESOURCE} measurement.
     * @return The evaluated power consumption.
     * @see de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator#calculate(Collection)
     */
    @Override
    public Amount<Power> calculate(Collection<MeasuringValue> measurements) {
        checkMeasurementConsistency(measurements);

        Measure<Double, Dimensionless> utilization = measurements.iterator().next().getMeasureForMetric(utilMetric);
        Amount<Dimensionless> utilAmount = Amount.valueOf(utilization.getValue(), utilization.getUnit());
        return minimumPower.plus(utilAmount.times(maximumPower.minus(minimumPower)));
    }
    

    @Override
    public Set<MetricDescription> getInputMetrics() {
        return Collections.singleton(utilMetric);
    }

    /**
     * Checks the consistency of passed arguments of {@link this#calculate(Collection)}.
     * @param measurements The passed measurement argument.
     */
    private static void checkMeasurementConsistency(Collection<MeasuringValue> measurements) {
        if (measurements == null || measurements.size() != 1 || measurements.iterator().next().getMeasureForMetric(utilMetric) == null) {
            throw new IllegalArgumentException(
                    "Linear power model expects one parameter of type MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE");
        }
    }

}
