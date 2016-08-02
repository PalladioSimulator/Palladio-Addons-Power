package de.fzi.power.interpreter.calculators.essential;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.edp2.util.MetricDescriptionUtility;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.specification.resources.PowerModelConstants;

/**
 * Creates a calculator that evaluates the power consumption <code>P</code> of a
 * {@link PowerConsumingResource} by interpolating between the resource's minimum <code>P_min</code>
 * and maximum power consumption <code>P_min</code> using the utilization <code>Util</code> of the
 * specific resource:<br>
 * <br>
 * <code>P = P_min + Util * (P_max - P_min)</code>
 * 
 * @author Christian Stier
 *
 */
public class LinearPowerModelCalculator extends AbstractResourcePowerModelCalculator {

    // Maximum power consumption of the resource.
    private Amount<Power> maximumPower;
    // Minimum power consumption of the resource.
    private Amount<Power> minimumPower;
    private final static MetricDescription UTIL_METRIC = MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE;

    private final Amount<Power> powerDifference;

    /**
     * Create a calculator for a linear power model.
     * 
     * @param powerConsumingResource
     *            The resource for which the calculator is created.
     */
    public LinearPowerModelCalculator(final ResourcePowerBinding binding) {
        super(binding);

        if (!binding.getResourcePowerModelSpecification().getId()
                .equals(PowerModelConstants.LINEAR_POWER_MODEL.getId())) {
            throw new IllegalArgumentException("Referred model wasn't the linear power model from"
                    + PowerModelConstants.LINEAR_POWER_MODEL.eResource().getURI() + ".");
        }

        for (FixedFactorValuePower value : EcoreUtil.<FixedFactorValuePower>getObjectsByType(binding.getFixedFactorValues(), BindingPackage.eINSTANCE.getFixedFactorValuePower())) {
            String boundFactorId = value.getBoundFactor().getId();
            Unit<Power> unit = value.getValue().getUnit();
            Amount<Power> valueInAmount = Amount.valueOf(value.getValue().doubleValue(unit), unit);
            if (boundFactorId.equals(PowerModelConstants.LINEAR_POWER_MODEL_MIN_CONSUMPTION.getId())) {
                this.minimumPower = valueInAmount;
            } else if (boundFactorId.equals(PowerModelConstants.LINEAR_POWER_MODEL_MAX_CONSUMPTION.getId())) {
                this.maximumPower = valueInAmount;
            } else {
                throw new IllegalArgumentException("One of the factor values wasn't a min or max consumption value.");
            }
        }
        // cache difference between both values as it is needed for each calculation
        this.powerDifference = this.maximumPower.minus(this.minimumPower);
    }

    /**
     * Calculate the power consumption using a linear power model.
     * 
     * @param measurements
     *            The {@link MeasuringValue}s used for evaluation. More precisely, this calculator
     *            type requires that the collection contain at least one element of that represents
     *            a utilization measurement.<br>
     *            However, an empty collection is also valid: This is treated like a sole
     *            measurement that represents idleness (zero utilization).
     * @return The evaluated power consumption.
     * @see de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator#calculate(Collection)
     */
    @Override
    public Amount<Power> calculate(Collection<MeasuringValue> measurements) {
        Amount<Power> result = null;
        if (Objects.requireNonNull(measurements, "Passed collection of measurements must not be null!").isEmpty()) {
            // no utilization given, thus we return the minimum power here, according to model!
            result = this.minimumPower;
        } else {
            result = calculateInternal(measurements);
        }
        return result;
    }

    private Amount<Power> calculateInternal(Collection<MeasuringValue> measurements) {
        assert measurements != null;

        MeasuringValue firstMeasurement = measurements.iterator().next();
        if (!MetricDescriptionUtility.isBaseMetricDescriptionSubsumedByMetricDescription(
                (BaseMetricDescription) UTIL_METRIC, firstMeasurement.getMetricDesciption())) {
            throw new IllegalArgumentException(
                    "Linear power model expects measurements of type MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE");
        }
        Measure<Double, Dimensionless> utilization = measurements.iterator().next().getMeasureForMetric(UTIL_METRIC);
        Amount<Dimensionless> utilAmount = Amount.valueOf(utilization.getValue(), utilization.getUnit());
        return this.minimumPower.plus(utilAmount.times(this.powerDifference));
    }

    @Override
    public Set<MetricDescription> getInputMetrics() {
        return Collections.singleton(UTIL_METRIC);
    }
}
