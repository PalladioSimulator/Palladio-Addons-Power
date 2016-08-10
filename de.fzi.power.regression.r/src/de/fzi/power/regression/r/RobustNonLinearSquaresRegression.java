package de.fzi.power.regression.r;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.measure.quantity.Quantity;

import org.vedantatree.expressionoasis.expressions.Expression;

public class RobustNonLinearSquaresRegression<Q extends Quantity> extends AbstractNonLinearRegression<Q> {
    
    private static final String MAXIT = "maxit=1000";

    public RobustNonLinearSquaresRegression(Expression expression, List<VariableMeasurements> measurements,
            List<ConstantModelParameter<?, ? extends Quantity>> constants, TargetMeasurements targetMetric) {
        super(expression, measurements, constants, targetMetric);
    }


    private static final String R_COMMAND_PREFIX = "nlrob(";
    private static final String R_PACKAGE_NAME = "robustbase";

    @Override
    public String getFunctionName() {
        return R_COMMAND_PREFIX;
    }
    
    
    @Override
    public Iterable<String> getRequiredPackages() {
        return Arrays.asList(R_PACKAGE_NAME, "minpack.lm");
    }
    
    @Override
    protected String getAdditionalParameters() {
        return super.getAdditionalParameters() + R_PARAM_SEPARATOR + MAXIT + R_PARAM_SEPARATOR + "method = \"M\"";
    }
}
