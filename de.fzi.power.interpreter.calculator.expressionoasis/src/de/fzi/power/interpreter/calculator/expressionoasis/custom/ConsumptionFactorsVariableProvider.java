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
import org.vedantatree.expressionoasis.extensions.DefaultVariableProvider;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.interpreter.InterpreterUtils;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.util.SpecificationSwitch;

final class ConsumptionFactorsVariableProvider extends DefaultVariableProvider {

    private final Map<MetricDescription, String> measuredFactors = InterpreterUtils.createIdentifierMatchingHashMap();
    private final Map<String, Unit<Quantity>> defaultUnits;
    private final Map<MetricDescription, List<Measure<Number, Quantity>>> measuredValues = InterpreterUtils
            .createIdentifierMatchingHashMap();

    private final SpecificationSwitch<Void> consumptionFactorSwitch = new SpecificationSwitch<Void>() {

        @Override
        public Void caseMeasuredFactor(MeasuredFactor object) {
            ConsumptionFactorsVariableProvider.this.measuredFactors.put(object.getMetricType(), object.getName());
            ConsumptionFactorsVariableProvider.this.defaultUnits.put(object.getName(),
                    object.getMetricType().getDefaultUnit());
            return null;
        }
    };

    ConsumptionFactorsVariableProvider(Iterable<FixedFactorValue> fixedFactorValues,
            Iterable<ConsumptionFactor> consumptionFactors) {
        this.defaultUnits = new HashMap<>();

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

    void addMeasurementForMeasuredFactor(MeasuringValue measuringValue) {
        if (measuringValue instanceof BasicMeasurement<?, ?>) {
            MetricDescription description = measuringValue.getMetricDesciption();
            if (this.measuredFactors.containsKey(description)) {
                List<Measure<Number, Quantity>> valuesForFactor = this.measuredValues.get(description);
                if (valuesForFactor == null) {
                    valuesForFactor = new ArrayList<>();
                    this.measuredValues.put(description, valuesForFactor);
                }
                valuesForFactor.add(measuringValue.<Number, Quantity> getMeasureForMetric(description));
            }
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
        // TODO Auto-generated method stub
    }

    @Override
    public Type getVariableType(String variableName) throws ExpressionEngineException {
        if (this.measuredFactors.containsValue(Objects.requireNonNull(variableName))) {
            return CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE;
        }
        return super.getVariableType(variableName);
    }

    @Override
    public ValueObject getVariableValue(String variableName) throws ExpressionEngineException {
        MetricDescription metricOfVariable = null;
        for (Entry<MetricDescription, String> entry : this.measuredFactors.entrySet()) {
            if (entry.getValue().equals(variableName)) {
                metricOfVariable = entry.getKey();
                break;
            }
        }
        if (metricOfVariable == null) {
            return super.getVariableValue(variableName);
        }
        List<Measure<Number, Quantity>> foundMeasures = this.measuredValues.get(metricOfVariable);
        Collection<Double> result = new ArrayList<>(foundMeasures == null ? 0 : foundMeasures.size());
        for (Measure<Number, Quantity> foundMeasure : foundMeasures) {
            result.add(foundMeasure.doubleValue(this.defaultUnits.get(variableName)));
        }
        return new MeasuredValuesCompositeValueObject(result);
    }

    @Override
    public boolean supportsVariable(String variableName) throws ExpressionEngineException {
        return this.measuredFactors.containsValue(Objects.requireNonNull(variableName))
                || super.supportsVariable(variableName);
    }

}
