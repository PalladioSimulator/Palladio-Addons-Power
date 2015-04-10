package de.fzi.power.interpreter.calculators.essential;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Power;
import javax.measure.unit.SI;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.specification.resources.PowerModelConstants;

public class InterpolationModelCalculator extends AbstractResourcePowerModelCalculator {
    
    public InterpolationModelCalculator(PowerConsumingResource powerConsumingResource) {
        super(powerConsumingResource);
        if(!binding.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.INTERPOLATION_MODEL.getId())) {
            throw new IllegalArgumentException("Referred model wasn't the linear power model from"
                    + PowerModelConstants.LINEAR_POWER_MODEL.eResource().getURI() + ".");
        }
    }

    private final static MetricDescription utilMetric = MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE;
    
    @Override
    public Amount<Power> calculate(Collection<MeasuringValue> measurements) {
        Measure<Double, Dimensionless> utilization = measurements.iterator().next().getMeasureForMetric(utilMetric);
        Amount<Dimensionless> utilAmount = Amount.valueOf(utilization.getValue(), utilization.getUnit());
        //adjust to "multicores"
        utilAmount = utilAmount.times(16);
        // TODO properly implement this, i.e. with integration of R
        Amount<Power> power = null;
        if(utilAmount.getEstimatedValue() < 1.0) {
        power= Amount.valueOf(((utilAmount.pow(6)).times(8212.668823123)
                .minus((utilAmount.pow(5)).times(23972.189733744))
                .plus((utilAmount.pow(4)).times(25344.996817589))
                .minus((utilAmount.pow(3)).times(11469.130619764))
                .plus((utilAmount.pow(2)).times(1934.889201581))
                .plus(utilAmount.times(39.956358727))
                .plus(Amount.valueOf(270.543705037, Dimensionless.UNIT))).getEstimatedValue(),SI.WATT);   
        } else {
            power = Amount.valueOf((utilAmount.times(7.19455)).plus(Amount.valueOf(352.46688, Dimensionless.UNIT)).getEstimatedValue(), SI.WATT);
        }
        return power;
    }
    
    @Override
    public Set<MetricDescription> getInputMetrics() {
        return Collections.singleton(utilMetric);
    }
}
