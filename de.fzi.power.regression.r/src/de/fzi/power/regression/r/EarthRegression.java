package de.fzi.power.regression.r;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.measure.quantity.Quantity;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;

import de.fzi.power.regression.r.io.RRegressionConnection;
import de.fzi.power.regression.r.io.RRegressionConnectionImpl;

public class EarthRegression<Q extends Quantity> extends AbstractRegression<Q> {

    private static final String R_COMMAND_PREFIX = "earth(";
    
    public EarthRegression(TargetMeasurements targetMetric, List<VariableMeasurements> measurements) {
        super(targetMetric, measurements);
    }
    
    @Override
    public String getFunctionName() {
        return R_COMMAND_PREFIX;
    }

    @Override
    public String getFormula() {
        return " .";
    }

    @Override
    public Iterable<String> getRequiredPackages() {
        return Collections.singleton("earth");
    }

    @Override
    protected String getAdditionalParameters() {
        return "fast.k=20" + R_PARAM_SEPARATOR + "degree=8";
    }
    
    public String getMaximumForm() throws IOException {
        RRegressionConnection rConnection = RRegressionConnectionImpl.getRRegressionConnection();
        this.constructModel();
        String command = "format(" + R_TARGET_NAME + ",style='max')";
        Vector<REXP> result = rConnection.execute(command);
        try {
            return result.get(0).asString();
        } catch (REXPMismatchException e) {
            throw new IOException(e);
        }
    }
}
