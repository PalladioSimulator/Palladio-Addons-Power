package de.fzi.power.regression.r;

import java.util.Collections;
import java.util.List;

import javax.measure.quantity.Quantity;

import org.vedantatree.expressionoasis.expressions.Expression;

public class NonLinearSquaresRegression<Q extends Quantity> extends AbstractNonLinearRegression<Q> {    
    
    private static final String R_PACKAGE_NAME = "minpack.lm";
    
    public NonLinearSquaresRegression(Expression expression, List<VariableMeasurements> measurements,
            List<ConstantModelParameter<?, ? extends Quantity>> constants, TargetMeasurements targetMetric) {
        super(expression, measurements, constants, targetMetric);
    }

    private static final String R_COMMAND_PREFIX = "nlsLM(";

    @Override
    public String getFunctionName() {
        return R_COMMAND_PREFIX;
    }
    
    @Override
    public Iterable<String> getRequiredPackages() {
        return Collections.singletonList(R_PACKAGE_NAME);
    }
}
