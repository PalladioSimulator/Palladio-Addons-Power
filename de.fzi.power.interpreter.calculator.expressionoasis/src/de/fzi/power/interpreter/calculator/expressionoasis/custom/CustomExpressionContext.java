package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import java.util.Collection;
import java.util.Iterator;

import javax.measure.Measure;
import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.binding.FixedFactorValue;
import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;
import de.fzi.power.specification.ConsumptionFactor;

public class CustomExpressionContext extends ExpressionContext {

    private final ConsumptionFactorsVariableProvider variableProvider;
    public static final Type MEASURED_VALUES_COMPOSITE_TYPE = Type.createType("measuredValuesType");

    public CustomExpressionContext(Iterable<FixedFactorValue> fixedFactorValues,
            Iterable<ConsumptionFactor> consumptionFactors) throws ExpressionEngineException {
        super();
        this.variableProvider = new ConsumptionFactorsVariableProvider(fixedFactorValues, consumptionFactors);
        this.addVariableProvider(this.variableProvider);
        this.addFunctionProvider(new CustomFunctionProvider());
    }

    public void addBasicMeasurement(MeasuringValue measuringValue) {
        this.variableProvider.addMeasurementForMeasuredFactor(measuringValue);
    }

    public void addPowerConsumptions(Iterable<Amount<Power>> outletConsumptions) {
        for (Amount<Power> outletConsumption : outletConsumptions) {
            Unit<Power> unit = outletConsumption.getUnit();
            Measure<?, Power> measure = Measure.valueOf(outletConsumption.doubleValue(unit), unit);
            addBasicMeasurement(new BasicMeasurement<>(measure, MetricDescriptionConstants.POWER_CONSUMPTION));
        }
    }

    public void clearMeasurements() {
        this.variableProvider.clearMeasuredFactors();
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
