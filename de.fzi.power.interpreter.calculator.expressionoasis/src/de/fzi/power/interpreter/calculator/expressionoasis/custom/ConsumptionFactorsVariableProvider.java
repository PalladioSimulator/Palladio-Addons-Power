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
import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

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

import de.fzi.power.binding.FixedFactorValue;
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

    private final Map<MetricDescription, String> measuredFactors;
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
     * @param fixedFactorValues
     *            An {@link Iterable} of {@link FixedFactorValue}s to be managed by this instance.
     * @param consumptionFactors
     *            An {@link Iterable} of {@link ConsumptionFactor}s to be managed by this instance.
     */
    ConsumptionFactorsVariableProvider(Iterable<FixedFactorValue> fixedFactorValues,
            Iterable<ConsumptionFactor> consumptionFactors) {
        this.defaultUnits = new HashMap<>();
        this.measuredFactors = InterpreterUtils.createIdentifierMatchingHashMap();
        this.measuredValues = InterpreterUtils.createIdentifierMatchingHashMap();

        for (ConsumptionFactor consumptionFactor : consumptionFactors) {
            this.consumptionFactorSwitch.doSwitch(consumptionFactor);
        }
        for (FixedFactorValue fixedFactorValue : fixedFactorValues) {
            addVariable(fixedFactorValue.getBoundFactor().getName(),
                    new ValueObject(fixedFactorValue.getValue().doubleValue(Power.UNIT), Type.DOUBLE));
        }
    }

    Collection<MetricDescription> getMeasuredFactors() {
        return Collections.unmodifiableCollection(this.measuredFactors.keySet());
    }

    boolean providesMeasuredFactor(String measuredFactorName) {
        return this.measuredFactors.containsValue(Objects.requireNonNull(measuredFactorName));
    }

    boolean providesMeasuredFactor(MetricDescription measuredFactorMetric) {
        return this.measuredFactors.containsKey(Objects.requireNonNull(measuredFactorMetric));
    }

    private void internalAdd(MeasuringValue measuringValue) {
        assert measuringValue != null;

        MetricDescription description = measuringValue.getMetricDesciption();
        if (this.measuredFactors.containsKey(description)) {
            List<Measure<Number, Quantity>> valuesForFactor = this.measuredValues.get(description);
            if (valuesForFactor == null) {
                valuesForFactor = new ArrayList<>();
                this.measuredValues.put(description, valuesForFactor);
            }
            valuesForFactor.add(measuringValue.<Number, Quantity> getMeasureForMetric(description));
        }
    }

    void addMeasurementForMeasuredFactor(MeasuringValue measuringValue) {
        if (measuringValue instanceof BasicMeasurement<?, ?>) {
            internalAdd(measuringValue);
        } else if (measuringValue instanceof TupleMeasurement) {
            for (MeasuringValue m : ((TupleMeasurement) measuringValue).getSubsumedMeasurements()) {
                addMeasurementForMeasuredFactor(m);
            }
        }
    }

    void clearMeasuredFactors() {
        this.measuredValues.clear();
    }

    @Override
    public void initialize(ExpressionContext expressionContext) throws ExpressionEngineException {
        ExpressionOasisHelper.assertCorrectExpressionContext(expressionContext, this.getClass());
        super.initialize(expressionContext);
    }

    @Override
    public Type getVariableType(String variableName) throws ExpressionEngineException {
        if (this.measuredFactors.containsValue(Objects.requireNonNull(variableName))) {
            return Type.DOUBLE;
        }
        return super.getVariableType(variableName);
    }

    @Override
    public ValueObject getVariableValue(String variableName) throws ExpressionEngineException {
        MetricDescription metricOfVariable = null;
        ValueObject result = null;
        for (Entry<MetricDescription, String> entry : this.measuredFactors.entrySet()) {
            if (entry.getValue().equals(variableName)) {
                metricOfVariable = entry.getKey();
                break;
            }
        }
        if (metricOfVariable == null) {
            result = super.getVariableValue(variableName);
        } else if (!this.measuredValues.containsKey(metricOfVariable)) {
            result = new ValueObject(0d, Type.DOUBLE);
        } else {
            List<Measure<Number, Quantity>> foundMeasures = this.measuredValues.get(metricOfVariable);
            Collection<Double> resultValues = new ArrayList<>(foundMeasures.size());
            for (Measure<Number, Quantity> foundMeasure : foundMeasures) {
                resultValues.add(foundMeasure.doubleValue(this.defaultUnits.get(variableName)));
            }
            if (foundMeasures.size() == 1) {
                result = new ValueObject(resultValues.iterator().next(), Type.DOUBLE);
            } else {
                result = new MeasuredValuesCompositeValueObject(resultValues);
            }
        }
        return result;
    }

    @Override
    public boolean supportsVariable(String variableName) throws ExpressionEngineException {
        return this.measuredFactors.containsValue(Objects.requireNonNull(variableName))
                || super.supportsVariable(variableName);
    }

}
