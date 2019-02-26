package de.fzi.power.interpreter.calculators.essential;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.specification.resources.PowerModelConstants;

public class NonlinearRegressionCalculator extends AbstractResourcePowerModelCalculator {

    private Amount<Power> minimumPower;
    private Amount<Power> maximumPower;
    private Amount<Dimensionless> exponent;
    private final static MetricDescription utilMetric = MetricDescriptionConstants.UTILIZATION_OF_ACTIVE_RESOURCE;
    
    public NonlinearRegressionCalculator(final ResourcePowerBinding binding) {
        super(binding);
        
        if (!binding.getResourcePowerModelSpecification().getId().equals(PowerModelConstants.NONLINEAR_REGRESSION_MODEL.getId())) {
            throw new IllegalArgumentException("Referred model wasn't the non-linear regression power model from"
                    + PowerModelConstants.NONLINEAR_REGRESSION_MODEL.eResource().getURI() + ".");
        }
        
        for (FixedFactorValuePower value : EcoreUtil.<FixedFactorValuePower>getObjectsByType(binding.getFixedFactorValues(), BindingPackage.eINSTANCE.getFixedFactorValuePower())) {
            String boundFactorId = value.getBoundFactor().getId();
            Unit<Power> unit = value.getValue().getUnit();
            Amount valueInAmount = Amount.valueOf(value.getValue().doubleValue(unit), unit);
            if (boundFactorId.equals(PowerModelConstants.NONLINEAR_REGRESSION_MODEL_MIN_CONSUMPTION.getId())) {
                minimumPower = valueInAmount;
            } else if (boundFactorId.equals(PowerModelConstants.NONLINEAR_REGRESSION_MODEL_MAX_CONSUMPTION.getId())) {
                maximumPower = valueInAmount;
            } else if (boundFactorId.equals(PowerModelConstants.NONLINEAR_REGRESSION_MODEL_EXPONENT.getId())) {
                exponent = valueInAmount;
            } else {
                throw new IllegalArgumentException("One of the factor values wasn't a min or max consumption value.");
            }
        }
    }

    @Override
    public Amount<Power> calculate(Collection<MeasuringValue> measurements) {
        checkMeasurementConsistency(measurements);
        
        Measure<Double, Dimensionless> utilization = measurements.iterator().next().getMeasureForMetric(utilMetric);
        Amount<Dimensionless> utilAmount = Amount.valueOf(utilization.getValue(), utilization.getUnit());
        return minimumPower.plus((maximumPower.minus(minimumPower).times(utilAmount.times(2).minus(utilAmount).pow((int) exponent.longValue(Dimensionless.UNIT)))));
    }
    
    @Override
    public Set<MetricDescription> getInputMetrics() {
        return Collections.singleton(utilMetric);
    }

    private static void checkMeasurementConsistency(Collection<MeasuringValue> measurements) {
        if(measurements == null || measurements.size() != 1 || measurements.iterator().next().getMeasureForMetric(utilMetric) == null) {
            
        }
    }

}
