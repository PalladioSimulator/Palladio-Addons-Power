package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.MetricDescription;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.extensions.DefaultVariableProvider;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.FixedFactorValueDimensionless;
import de.fzi.power.binding.FixedFactorValuePower;
import de.fzi.power.binding.util.BindingSwitch;
import de.fzi.power.interpreter.InterpreterUtils;
import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.util.SpecificationSwitch;

/**
 * A specialized {@link DefaultVariableProvider}, tailored to handle {@link Expression} variables
 * that represent {@link FixedFactor}s or {@link MeasuredFactor}s.
 * 
 * @see CustomExpressionContext
 * @author Florian Rosenthal
 *
 */
final class ConsumptionFactorsVariableProvider extends DefaultVariableProvider {

    /**
     * maps each measured factor (by its metric) to its name -> only one measured factor per metric
     * description possible
     */
    private final Map<MetricDescription, String> measuredFactors;

    /**
     * maps each measured factor (by its name) to its default unit
     */
    private final Map<String, Unit<Quantity>> defaultUnits;
    private final Map<MetricDescription, List<Measure<Number, Quantity>>> measuredValues;

    private final SpecificationSwitch<Void> consumptionFactorSwitch = new SpecificationSwitch<Void>() {

        @Override
        public Void caseMeasuredFactor(MeasuredFactor object) {
            if (ConsumptionFactorsVariableProvider.this.measuredFactors.containsKey(object.getMetricType())) {
                throw new IllegalStateException(
                        "Consumption factor of metric type '" + object.getMetricType() + "' already present (name: '"
                                + ConsumptionFactorsVariableProvider.this.measuredFactors.get(object.getMetricType())
                                + "'): Only one per type supported!");
            }
            ConsumptionFactorsVariableProvider.this.measuredFactors.put(object.getMetricType(), object.getName());
            ConsumptionFactorsVariableProvider.this.defaultUnits.put(object.getName(),
                    object.getMetricType().getDefaultUnit());
            return null;
        }
    };

    /**
     * Initializes a new instance of the {@link ConsumptionFactorsVariableProvider} class.
     * 
     * @param eList
     *            An {@link Iterable} of {@link FixedFactorValue}s to be managed by this instance.
     * @param consumptionFactors
     *            An {@link Iterable} of {@link ConsumptionFactor}s to be managed by this instance.
     */
    ConsumptionFactorsVariableProvider(EList<AbstractFixedFactorValue<?>> eList,
            Iterable<ConsumptionFactor> consumptionFactors) {
        this.defaultUnits = new HashMap<>();
        this.measuredFactors = InterpreterUtils.createIdentifierMatchingHashMap();
        this.measuredValues = InterpreterUtils.createIdentifierMatchingHashMap();

        for (ConsumptionFactor consumptionFactor : consumptionFactors) {
            this.consumptionFactorSwitch.doSwitch(consumptionFactor);
        }
        for (AbstractFixedFactorValue<?> fixedFactorValue : eList) {
            new BindingSwitch<Void>() {
                public Void caseFixedFactorValueDimensionless(FixedFactorValueDimensionless factor) {
                    Measure<Double, Dimensionless> measure = factor.getValue();
                    addVariable(factor.getBoundFactor().getName(),
                            new ValueObject(measure.doubleValue(measure.getUnit()), Type.DOUBLE));
                    return null;
                };
                public Void caseFixedFactorValuePower(FixedFactorValuePower factor) {
                    Measure<Double, Power> measure = factor.getValue();
                    addVariable(factor.getBoundFactor().getName(),
                            new ValueObject(measure.doubleValue(measure.getUnit()), Type.DOUBLE));
                    return null;
                };
            }.doSwitch(fixedFactorValue);
        }
    }

    Collection<MetricDescription> getMeasuredFactors() {
        return Collections.unmodifiableCollection(this.measuredFactors.keySet());
    }

    /**
     * Gets whether the {@link MeasuredFactor}, denoted by the given name, is known to this class.
     * 
     * @param measuredFactorName
     *            A {@link String} which is the name of a {@link MeasuredFactor}.
     * @return {@code true} if the given measured factor is known to this class, {@code false}
     *         otherwise.
     * @throws NullPointerException
     *             In case the argument is {@code null}.
     */
    boolean providesMeasuredFactor(String measuredFactorName) {
        return this.measuredFactors.containsValue(Objects.requireNonNull(measuredFactorName));
    }

    /**
     * Gets whether the this instance provides a {@link MeasuredFactor} with the given metric.
     * 
     * @param measuredFactorMetric
     *            A {@link MetricDescription}.
     * @return {@code true} if a measured factor with the given metric is known to this class,
     *         {@code false} otherwise.
     * @throws NullPointerException
     *             In case the argument is {@code null}.
     */
    boolean providesMeasuredFactor(MetricDescription measuredFactorMetric) {
        return this.measuredFactors.containsKey(Objects.requireNonNull(measuredFactorMetric));
    }

    private void internalAdd(MeasuringValue measuringValue) {
        assert measuringValue != null;

        MetricDescription description = measuringValue.getMetricDesciption();
        if (providesMeasuredFactor(description)) {
            List<Measure<Number, Quantity>> valuesForFactor = this.measuredValues.get(description);
            if (valuesForFactor == null) {
                valuesForFactor = new ArrayList<>();
                this.measuredValues.put(description, valuesForFactor);
            }
            valuesForFactor.add(measuringValue.<Number, Quantity> getMeasureForMetric(description));
        }
    }

    /**
     * Adds the given measured value (measurement).<br>
     * This method does nothing, if the given measured value is {@code null} or cannot be associated
     * with any known measured factor. This association is done by examining the metric of the given
     * measured value.
     * 
     * @param measuringValue
     *            A {@link MeasuringValue} which should belong to a measured factor known to this
     *            instance.
     */
    void addMeasuredValue(MeasuringValue measuringValue) {
        if (measuringValue instanceof BasicMeasurement<?, ?>) {
            internalAdd(measuringValue);
        } else if (measuringValue instanceof TupleMeasurement) {
            for (MeasuringValue m : ((TupleMeasurement) measuringValue).getSubsumedMeasurements()) {
                addMeasuredValue(m);
            }
        }
    }

    /**
     * Discards all measured values (measurements) that have been added previously via calls to
     * {@link #addMeasuredValue(MeasuringValue)}.
     */
    void clearMeasuredValues() {
        this.measuredValues.clear();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws AssertionError
     *             In case the passed {@link ExpressionContext} is not a
     *             {@link CustomExpressionContext} instance.
     */
    @Override
    public void initialize(ExpressionContext expressionContext) throws ExpressionEngineException {
        ExpressionOasisHelper.assertCorrectExpressionContext(expressionContext, this.getClass());
        super.initialize(expressionContext);
    }

    /**
     * {@inheritDoc}
     * 
     * @return {@link Type#DOUBLE} in case the given {@code variableName} denotes a measured factor
     *         known to this instance, {@code super.getVariableType(variableName)} otherwise.
     * @throws NullPointerException
     *             In case {@code variableName == null}.
     * @see #providesMeasuredFactor(String)
     */
    @Override
    public Type getVariableType(String variableName) throws ExpressionEngineException {
        return providesMeasuredFactor(variableName) ? Type.DOUBLE : super.getVariableType(variableName);
    }

    /**
     * {@inheritDoc}
     * 
     * @return
     *         <ul>
     *         <li>The result of {@code super.getVariableValue(variableName)} is returned in case
     *         the given variable name does not denote a known {@link MeasuredFactor}.</li>
     *         <li>A {@link ValueObject} of {@link Type#DOUBLE} is returned, if the given variable
     *         name denotes a known {@link MeasuredFactor} with 0 or 1 measurements available.</li>
     *         <li>A {@link MeasuredValuesCompositeValueObject} is returned in any other case.</li>
     *         </ul>
     */
    @Override
    public ValueObject getVariableValue(String variableName) throws ExpressionEngineException {
        return !providesMeasuredFactor(variableName) ? super.getVariableValue(variableName)
                : getVariableValueForMeasuredFactor(variableName);
    }

    private ValueObject getVariableValueForMeasuredFactor(String measuredFactorName) {
        assert measuredFactorName != null && !measuredFactorName.isEmpty();
        ValueObject result = null;

        MetricDescription metricOfVariable = null;
        for (Entry<MetricDescription, String> entry : this.measuredFactors.entrySet()) {
            if (entry.getValue().equals(measuredFactorName)) {
                metricOfVariable = entry.getKey();
                break;
            }
        }
        assert metricOfVariable != null;

        if (!this.measuredValues.containsKey(metricOfVariable)) {
            // no measurements (measured values) available for this measured factor
            result = new ValueObject(0d, Type.DOUBLE);
        } else {
            List<Measure<Number, Quantity>> foundMeasures = this.measuredValues.get(metricOfVariable);
            List<Double> resultValues = new ArrayList<>(foundMeasures.size());
            for (Measure<Number, Quantity> foundMeasure : foundMeasures) {
                resultValues.add(foundMeasure.doubleValue(this.defaultUnits.get(measuredFactorName)));
            }
            if (foundMeasures.size() == 1) {
                result = new ValueObject(resultValues.get(0), Type.DOUBLE);
            } else {
                result = new MeasuredValuesCompositeValueObject(resultValues);
            }
        }
        return result;

    }

    @Override
    public boolean supportsVariable(String variableName) throws ExpressionEngineException {
        return providesMeasuredFactor(variableName) || super.supportsVariable(variableName);
    }

    @Override
    public void clear() {
        super.clear();
        this.clearMeasuredValues();
    }
}
