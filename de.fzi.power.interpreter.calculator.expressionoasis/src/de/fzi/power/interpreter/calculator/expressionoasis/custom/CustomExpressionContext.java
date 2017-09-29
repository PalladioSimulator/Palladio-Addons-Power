package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import java.util.Collection;
import java.util.Iterator;

import javax.measure.Measure;
import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.EList;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.interpreter.calculator.expressionoasis.ExpressionOasisDistributionPowerModelCalculator;
import de.fzi.power.interpreter.calculator.expressionoasis.ExpressionOasisResourcePowerModelCalculator;
import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.FixedFactor;

/**
 * This class is an extension of the {@link ExpressionContext} class, tailored to deal with
 * {@link Expressions} that contain {@link FixedFactor}s and {@link ConsumptionFactor} s. It is used
 * by the {@link ExpressionOasisDistributionPowerModelCalculator} and the
 * {@link ExpressionOasisResourcePowerModelCalculator} to handle
 * {@link DeclarativePowerModelSpecification}s.<br>
 * The peculiarity of a measured factor is that while it is denoted by a variable within an
 * expression, it might be composed of several values at simulation-time. For example, a measured
 * factor {@code outletConsumption} may refer to all {@link PowerConsumingResource}s that are
 * supplied by a {@link PowerDistributionUnit}. Thus, variables that represent measured factors are
 * polymorphic in some way, but it cannot be determined beforehand whether they are composite
 * variables or not.<br>
 * Moreover, this class also serves as a facade to all other non-public classes in this package.
 * 
 * @author Florian Rosenthal
 *
 */
public class CustomExpressionContext extends ExpressionContext {

    private final ConsumptionFactorsVariableProvider variableProvider;

    /**
     * Initializes a new instance of the {@link CustomExpressionContext} class.
     * 
     * @param eList
     *            An {@link Iterable} of {@link FixedFactorValue}s to be managed by this instance.
     * @param consumptionFactors
     *            An {@link Iterable} of {@link ConsumptionFactor}s to be managed by this instance.
     * @throws ExpressionEngineException
     *             In case something goes wrong in the super-constructor.
     */
    public CustomExpressionContext(EList<AbstractFixedFactorValue<?>> eList,
            Iterable<ConsumptionFactor> consumptionFactors) throws ExpressionEngineException {
        super();
        this.variableProvider = new ConsumptionFactorsVariableProvider(eList, consumptionFactors);
        this.addVariableProvider(this.variableProvider);
        this.addFunctionProvider(new CustomFunctionProvider());
    }

    public void addBasicMeasurement(MeasuringValue measuringValue) {
        this.variableProvider.addMeasuredValue(measuringValue);
    }

    public void addPowerConsumptions(Iterable<Amount<Power>> outletConsumptions) {
        for (Amount<Power> outletConsumption : outletConsumptions) {
            Unit<Power> unit = outletConsumption.getUnit();
            Measure<?, Power> measure = Measure.valueOf(outletConsumption.doubleValue(unit), unit);
            addBasicMeasurement(new BasicMeasurement<>(measure, MetricDescriptionConstants.POWER_CONSUMPTION));
        }
    }

    public void clearMeasurements() {
        this.variableProvider.clearMeasuredValues();
    }

    public Collection<MetricDescription> getMeasuredFactors() {
        return this.variableProvider.getMeasuredFactors();
    }

    public boolean isMeasuredFactorAvailable(String measuredFactorName) {
        return this.variableProvider.providesMeasuredFactor(measuredFactorName);
    }

    public boolean isMeasuredFactorAvailable(MetricDescription measuredFactorMetricDescription) {
        return this.variableProvider.providesMeasuredFactor(measuredFactorMetricDescription);
    }

    public double toDouble(ValueObject valueObject) {
        double result = 0d;
        if (ExpressionOasisHelper.hasCompositeType(valueObject)) {
            Iterable<Double> objectValues = ((MeasuredValuesCompositeValueObject) valueObject).getValue();
            Iterator<Double> valuesIterator = objectValues.iterator();
            if (valuesIterator.hasNext()) {
                result = valuesIterator.next();
            }
        } else if (ExpressionOasisHelper.hasNumericType(valueObject)) {
            result = Double.parseDouble(valueObject.getValue().toString());
        }
        return result;
    }
}
