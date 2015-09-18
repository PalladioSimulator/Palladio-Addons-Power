package de.fzi.power.interpreter.calculator.expressionoasis;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.MetricDescription;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.extensions.DefaultVariableProvider;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.interpreter.InterpreterUtils;
import de.fzi.power.interpreter.calculators.AbstractResourcePowerModelCalculator;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.util.SpecificationSwitch;

public class ExpressionOasisPowerModelCalculator extends AbstractResourcePowerModelCalculator {
    public static final String REGRESSION_POWER_MODEL_IDENTIFIER = "RegressionPowerModel";
    public static final String MODEL_NAME_SPECIFICATION_SEPARATOR = "_:";
    
    private final ResourcePowerModelSpecification specification;
    private final ExpressionContext expressionContext;
    private final DefaultVariableProvider variableProvider;
    private final Expression predictorExpression;
    
    private final Map<MetricDescription, String> measuredFactors = 
            InterpreterUtils.createIdentifierMatchingHashMap();
    private final Map<MetricDescription, Measure<Number, Quantity>> measuredValues = 
            InterpreterUtils.createIdentifierMatchingHashMap();
    private final Map<String, Unit<Quantity>> defaultUnits = 
            new HashMap<String, Unit<Quantity>>();

    public ExpressionOasisPowerModelCalculator(PowerConsumingResource powerConsumingResource) {
        super(powerConsumingResource);
        
        specification = binding.getResourcePowerModelSpecification();
    
        String rawPowerModel = determineModelString(binding.getResourcePowerModelSpecification());
        
        try {
            expressionContext = new ExpressionContext();
            variableProvider = new DefaultVariableProvider();
            
            for (FixedFactorValue ffv : binding.getFixedFactorValues()) {
                variableProvider.addVariable(ffv.getBoundFactor().getName(), 
                        new ValueObject(ffv.getValue().getValue(), Type.DOUBLE));
            }
            
            for (ConsumptionFactor cf : specification.getConsumptionFactors()) {
                (new SpecificationSwitch<Void>() {
                    public Void caseMeasuredFactor(MeasuredFactor object) {
                        measuredFactors.put(
                                object.getMetricType(), 
                                object.getName());
                        defaultUnits.put(
                                object.getName(), 
                                object.getMetricType().getDefaultUnit());
                        variableProvider.addVariable(
                                object.getName(), 
                                new ValueObject((Double) 1.0, Type.DOUBLE));
                        return null;
                    };
                }).doSwitch(cf);
            }
            
            expressionContext.addVariableProvider(variableProvider);
            
            predictorExpression = ExpressionEngine.compileExpression(rawPowerModel, 
                    expressionContext, true);

        } catch (ExpressionEngineException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void addBasicMeasurements(MeasuringValue measurement) {
        if (measurement instanceof BasicMeasurement<?, ?>) {
            MetricDescription description = measurement.getMetricDesciption();
            if (measuredFactors.containsKey(description)) {
                measuredValues.put(description, 
                        measurement.<Number, Quantity>getMeasureForMetric(description));
            }
        } else if (measurement instanceof TupleMeasurement) {
            for (MeasuringValue m : ((TupleMeasurement)measurement).getSubsumedMeasurements()) {
                addBasicMeasurements(m);
            }
        }
    }

    
    @Override
    public Amount<Power> calculate(Collection<MeasuringValue> list) {
        for (MeasuringValue measurement : list) {
            addBasicMeasurements(measurement);
        }
        
        for (Entry<MetricDescription, String> factor : measuredFactors.entrySet()) {
            Unit<Quantity> defaultUnit = defaultUnits.get(factor.getValue());
            ValueObject variableValue = new ValueObject(
                    measuredValues.get(factor.getKey()).doubleValue(defaultUnit),
                    Type.DOUBLE);
            variableProvider.addVariable(factor.getValue(), variableValue);
        }
        
        Double result;
        try {
            result = (Double) predictorExpression.getValue().getValue();
            if (result.isInfinite() || (result > 10)) {
                result = 0.0;
            } 
        } catch (ExpressionEngineException e) {
            throw new RuntimeException(e);
        }
        
        return Amount.valueOf(Math.max(result.doubleValue(), 0.0), Power.UNIT);
    }

    @Override
    public Set<MetricDescription> getInputMetrics() {
        return Collections.unmodifiableSet(measuredFactors.keySet());
    }

    protected String determineModelString(ResourcePowerModelSpecification specification) {
        return specification.getName().substring(
                specification.getName().indexOf(MODEL_NAME_SPECIFICATION_SEPARATOR) + 2);
    }
}
