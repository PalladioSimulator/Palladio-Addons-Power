package de.fzi.power.regression.r;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.apache.log4j.Logger;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.expressions.IdentifierExpression;
import org.vedantatree.expressionoasis.expressions.NumericExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.AddExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.DivideExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.MinusExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.MultiplyExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.ParanthesisExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.SubtractExpression;
import org.vedantatree.expressionoasis.expressions.property.ArgumentExpression;
import org.vedantatree.expressionoasis.expressions.property.FunctionExpression;

import de.fzi.power.regression.r.expressionoasis.ExportTriple;
import de.fzi.power.regression.r.expressionoasis.ExportTripleProvider;
import de.fzi.power.regression.r.expressionoasis.ExportVisitor;
import de.fzi.power.regression.r.expressionoasis.SimpleTriple;
import de.fzi.power.regression.r.io.RRegressionConnection;
import de.fzi.power.regression.r.io.RRegressionConnectionImpl;
import de.fzi.power.regression.r.io.RUtils;

public abstract class AbstractNonLinearRegression<Q extends Quantity> extends AbstractRegression<Q> {

    private static final String R_START_PARAMETERS = "startParameters";
    private static final String R_X_PARAM = "xParam";
    private Expression expression;
    private List<ConstantModelParameter<?, ? extends Quantity>> constants;

    private static final Logger LOGGER = Logger.getLogger(AbstractNonLinearRegression.class.getName());

    public AbstractNonLinearRegression(Expression expression, List<VariableMeasurements> measurements,
            List<ConstantModelParameter<?, ? extends Quantity>> constants, TargetMeasurements targetMetric) {
        super(targetMetric, measurements);
        this.expression = expression;
        this.constants = constants;
    }

    public List<DoubleModelParameter<? extends Quantity>> deriveParameters() {
        assignStartParameters();
        // Try finding better starting values based on nlsLM on log function
        for (int idx = 0; idx < 50; idx++) {
            try {
                constructModel();
                break;
            } catch (IllegalStateException e) {
                calculateLogStartingValues();
                try {
                    LOGGER.error("Trying parameter starting values on log term. Iteration: " + idx
                            + "\nStarting values of log term: " + Arrays.toString(RRegressionConnectionImpl.getRRegressionConnection()
                                    .execute("startParameters").get(0).asDoubles()));
                } catch (REXPMismatchException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
        List<DoubleModelParameter<? extends Quantity>> modelParameters = getResults();
        return modelParameters;
    }

    private void calculateLogStartingValues() {
        StringBuilder commandString = new StringBuilder("coef(" + "nlsLM(");
        commandString.append("log(" + RUtils.sanitizeNameForR(targetMetric.getName()) + R_BLOCK_END);
        commandString.append(R_REGRESSION_RELATIONHSIP_OPERATOR);
        commandString.append("log(" + getFormula() + R_BLOCK_END);
        commandString.append(R_PARAM_SEPARATOR);
        commandString.append("data = " + DATA_FRAME_NAME);
        commandString.append(R_PARAM_SEPARATOR + R_ADDITIONAL_COMMAND + R_PARAM_SEPARATOR);
        commandString.append(getStartValuesAssignString() + R_BLOCK_END + R_COMMAND_POSTFIX);
        RRegressionConnection rConnection = RRegressionConnectionImpl.getRRegressionConnection();
        rConnection.execute(R_START_PARAMETERS + R_ASSIGNMENT_OPERATOR + commandString.toString());
    }

    private List<DoubleModelParameter<? extends Quantity>> getResults() {
        RRegressionConnection rConnection = RRegressionConnectionImpl.getRRegressionConnection();
        Vector<REXP> rawResults;
        rawResults = rConnection.execute(buildReadResultsCommand(R_TARGET_NAME));

        double[] values = null;
        String[] names = null;
        try {
            values = rawResults.get(0).asDoubles();
            names = rawResults.get(1).asStrings();
        } catch (REXPMismatchException e) {
            LOGGER.error("Error converting regression results: " + e.toString());
        }

        List<DoubleModelParameter<? extends Quantity>> modelParameters = new ArrayList<DoubleModelParameter<? extends Quantity>>();
        for (int i = 0; i < values.length; i++) {
            modelParameters
                    .add(new DoubleModelParameter(names[i], Measure.valueOf(values[i], constants.get(i).getUnit())));
        }

        if (values.length != names.length)
            throw new RuntimeException(
                    "The parameter name description and the values" + " in the R result vector do not fit.");
        return modelParameters;
    }

    @Override
    public String getFormula() {
        ExportVisitor<String> visitor = new ExportVisitor<String>(createRCompatibleExportVisitorConfiguration());
        expression.accept(visitor);
        return visitor.toString();
    }

    private String getRegressionStartValues(List<ConstantModelParameter<?, ? extends Quantity>> constants) {
        StringBuilder commandString = new StringBuilder();
        Iterator<ConstantModelParameter<?, ? extends Quantity>> measurementsIt = constants.iterator();
        while (measurementsIt.hasNext()) {
            ConstantModelParameter<?, ? extends Quantity> next = measurementsIt.next();
            commandString.append(RUtils.sanitizeNameForR(next.getName()));
            commandString.append(R_START_VALUE_ASSIGNMENT_OPERATOR);
            commandString.append(next.getValue().getValue().toString());
            if (measurementsIt.hasNext()) {
                commandString.append(R_PARAM_SEPARATOR);
            }
        }
        return commandString.toString();
    }

    public Map<Class<?>, ExportTripleProvider<String>> createRCompatibleExportVisitorConfiguration() {
        Map<Class<?>, ExportTripleProvider<String>> configuration = new HashMap<Class<?>, ExportTripleProvider<String>>();
        Map<String, ExportTripleProvider<String>> functionExpressions = new HashMap<String, ExportTripleProvider<String>>();
        functionExpressions.put("exp", new SimpleTriple("exp", "", ""));
        functionExpressions.put("pow", new ExportTripleProvider<String>() {

            @Override
            public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> rExportVisitor) {
                rExportVisitor.getFunctionParameterSeparatorStack().push("^");
                return new SimpleTriple("", "", "");
            }
        });

        configuration = new HashMap<Class<?>, ExportTripleProvider<String>>();
        configuration.put(MultiplyExpression.class, new SimpleTriple("", "*", ""));
        configuration.put(AddExpression.class, new SimpleTriple("", "+", ""));
        configuration.put(SubtractExpression.class, new SimpleTriple("", "-", ""));
        configuration.put(DivideExpression.class, new SimpleTriple("", "/", ""));
        configuration.put(ParanthesisExpression.class, new SimpleTriple("(", "", ")"));

        configuration.put(MinusExpression.class, new SimpleTriple("-", "", ""));

        configuration.put(ArgumentExpression.class, new ExportTripleProvider<String>() {

            @Override
            public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> rExportVisitor) {
                return new SimpleTriple("", rExportVisitor.getFunctionParameterSeparatorStack().pop(), "");
            }
        });

        configuration.put(FunctionExpression.class,
                new FunctionExpressionExportTripleProvider<String>(functionExpressions));
        configuration.put(IdentifierExpression.class, new ExportTripleProvider<String>() {

            @Override
            public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> visitor) {
                return new SimpleTriple(((IdentifierExpression) expression).getIdentifierName(), "", "");
            }
        });
        configuration.put(NumericExpression.class, new ExportTripleProvider<String>() {

            @Override
            public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> visitor) {
                try {
                    return new SimpleTriple(((NumericExpression) expression).getValue().getValue().toString(), "", "");
                } catch (ExpressionEngineException e) {
                    LOGGER.error("Could not instantiate expression: " + e.toString());
                }
                return null; // Wird nie aufgerufen, da getValue an dieser Stelle NIE eine
                             // ExpressionEngineException werfen wird
            }
        });

        return configuration;
    }

    public File generateVectorPlot(int graphicsWidth, int graphicsHeight, int fontSize) throws IOException {
        RRegressionConnection rConnection = RRegressionConnectionImpl.getRRegressionConnection();
        File pngFile = File.createTempFile("regression_plot", ".png");
        pngFile.deleteOnExit();
        String rCommand = "";
        rCommand += "png(\"" + pngFile.getAbsolutePath().replace("\\", "\\\\") + "\",height=" + graphicsHeight
                + ",width=" + graphicsWidth + ")\n";
        rCommand += generatePlotCommand();
        rCommand += "dev.off()\n";
        try {
            rConnection.execute(rCommand);
        } catch (IllegalStateException e) {

        }
        return pngFile;
    }

    private String generatePlotCommand() {
        StringBuilder rCommandBuilder = new StringBuilder();
        // TODO extract dimension delineation.
        rCommandBuilder.append(FIT_FNC + R_ASSIGNMENT_OPERATOR + "function(" + R_X_PARAM + ") predict(" + R_TARGET_NAME
                + ", list(" + this.measurements.get(0).getName() + "=" + R_X_PARAM + ")" + R_BLOCK_END + "\n");
        rCommandBuilder.append("plot.new()\n");
        rCommandBuilder.append(
                "curve(" + FIT_FNC + ", from=0, to=1" + ", col=563, " + " xlab=\"" + this.measurements.get(0).getName()
                        + "\"" + ", " + "ylab=\"" + this.targetMetric.getUnit() + "\"" + R_BLOCK_END + "\n");
        rCommandBuilder.append("points(" + DATA_FRAME_NAME + ", pch=3" + R_BLOCK_END + "\n");
        rCommandBuilder.append("curve(" + FIT_FNC + ", add=TRUE, col=563" + R_BLOCK_END + "\n");
        return rCommandBuilder.toString();
    }

    public Iterable<String> getRequiredPackages() {
        return new ArrayList<String>(0);
    }

    private String buildReadResultsCommand(String resultName) {
        return "coef(" + resultName + ");\n" + "names(coef(" + resultName + "));\n";
    }

    protected String getAdditionalParameters() {
        return R_ADDITIONAL_COMMAND + R_PARAM_SEPARATOR + this.getStartValuesAssignString();
    }

    private String getStartValuesAssignString() {
        return R_START_PARAM_NAME_ASSIGN + R_START_PARAMETERS;
    }

    private void assignStartParameters() {
        RRegressionConnectionImpl.getRRegressionConnection().execute(R_START_PARAMETERS + R_ASSIGNMENT_OPERATOR
                + R_START_VALUES_BLOCK + getRegressionStartValues(constants) + R_BLOCK_END);
    }

    public Double getAIC() {
        RRegressionConnection rConnection = RRegressionConnectionImpl.getRRegressionConnection();
        Vector<REXP> results = rConnection.execute("AIC(" + R_TARGET_NAME + R_BLOCK_END);
        // Vector<REXP> results = rConnection.execute("BIC(" + R_TARGET_NAME + R_BLOCK_END);
        try {
            return results.get(0).asDouble();
        } catch (REXPMismatchException e) {
            LOGGER.error("Error calculating AIC: " + e.toString());
        }
        return null;
    }

}
