package de.fzi.power.regression.r;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.measure.quantity.Quantity;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REXPString;
import org.rosuda.REngine.RList;
import org.vedantatree.expressionoasis.expressions.Expression;

import de.fzi.power.regression.r.expressionoasis.ExpressionUtil;
import de.fzi.power.regression.r.io.RRegressionConnection;
import de.fzi.power.regression.r.io.RRegressionConnectionImpl;

public class SymbolicRegression<Q extends Quantity> extends AbstractRegression<Q> {

    private static final String R_PACKAGE_NAME = "rgp";
    private static final String R_COMMAND_PREFIX = "symbolicRegression(";
    private static final String R_SIMPLIFY_PACKAGE = "Deriv";
    private static final String LAPPLY = "lapply(";
    private static final String R_ELITE = "elite";
    private int numberOfSteps;
    
    public SymbolicRegression(List<VariableMeasurements> measurements,
            TargetMeasurements targetMetric) {
        this(measurements, targetMetric, 4000);
    }
    
    public SymbolicRegression(List<VariableMeasurements> measurements,
            TargetMeasurements targetMetric, int numberOfSteps) {
        super(targetMetric, measurements);
        this.numberOfSteps = numberOfSteps;
    }

    @Override
    public String getFunctionName() {
        return R_COMMAND_PREFIX;
    }
    
    @Override
    public Iterable<String> getRequiredPackages() {
        return Arrays.<String>asList(new String[] {R_PACKAGE_NAME, R_SIMPLIFY_PACKAGE});
    }
    
    @Override
    public String getFormula() {
        Iterator<VariableMeasurements> iterator = this.measurements.iterator();
        StringBuilder formulaBuilder = new StringBuilder();
        formulaBuilder.append(iterator.next().getName());
        while(iterator.hasNext()) {
            formulaBuilder.append(" + " + iterator.next().getName());
        }
        return formulaBuilder.toString();
    }
    
    @Override
    protected String getAdditionalParameters() {
        return "functionSet=arithmeticFunctionSet, stopCondition=makeStepsStopCondition("+ this.numberOfSteps + ")";
    }
    
    public List<Expression> getEliteResults() {
        constructModel();
        RRegressionConnection rConnection = RRegressionConnectionImpl.getRRegressionConnection();
        Vector<REXP> rawElite = rConnection.execute(LAPPLY 
                + LAPPLY + R_TARGET_NAME + R_ACCESSOR + R_ELITE + R_PARAM_SEPARATOR + "Simplify" + R_BLOCK_END 
                + R_PARAM_SEPARATOR + "deparse" + R_BLOCK_END);
        RList asList = null;
        try {
            asList = rawElite.get(0).asList();
        } catch (REXPMismatchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Expression> expressionList = new ArrayList<Expression>();
        for(Object curObj : asList) {
            REXPString curString = (REXPString) curObj;
            String expressionString = null;
            expressionString = Arrays.stream(curString.asStrings()).reduce("", String::concat);
            expressionString = Pattern.compile("function \\((.*?)\\)").matcher(expressionString).replaceAll("").trim();
            Expression curExpression = ExpressionUtil.createFromRFunction(expressionString);
            expressionList.add(curExpression);
        }
        return expressionList;
    }
}
