package de.fzi.power.regression.r;

import java.util.ArrayList;
import java.util.List;

import javax.measure.quantity.Quantity;

import org.vedantatree.expressionoasis.expressions.Expression;

public class NonLinearSquaresRegression<Q extends Quantity> extends AbstractNonLinearRegression<Q> {    
    public NonLinearSquaresRegression(Expression expression, List<VariableMeasurements> measurements,
            List<ConstantModelParameter<?, Q>> constants, TargetMeasurements targetMetric) {
        super(expression, measurements, constants, targetMetric);
    }

    private static final String R_COMMAND_PREFIX = "nls(";

    @Override
    public String getFunctionName() {
        return R_COMMAND_PREFIX;
    }
}
