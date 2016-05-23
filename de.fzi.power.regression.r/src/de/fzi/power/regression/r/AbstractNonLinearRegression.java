package de.fzi.power.regression.r;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
import de.fzi.power.regression.r.io.IRConnection;
import de.fzi.power.regression.r.io.RRegressionConnection;
import de.fzi.power.regression.r.io.RRegressionConnectionImpl;
import de.fzi.power.regression.r.io.RUtils;


public abstract class AbstractNonLinearRegression<Q extends Quantity> {

    private static final String FIT_FNC = "fitFnc";
    private static final String DATA_FRAME_NAME = "df";
    private static final String R_REGRESSION_RELATIONHSIP_OPERATOR = "~";
    private static final String R_PARAMETER_SEPARATOR = ", ";
    private static final String R_START_VALUES_BLOCK = "start=list(";
    private static final String R_START_VALUE_ASSIGNMENT_OPERATOR = "=";
    private static final String R_BLOCK_END = ")";
    private static final String R_COMMAND_POSTFIX = ", control=c(maxiter=1000));";
    private static final String R_TARGET_NAME = "targetValue";
    private static final String R_ASSIGNMENT_OPERATOR = " <- ";
    private static final String R_X_PARAM = "xParam";
    private Expression expression;
    private List<VariableMeasurements> measurements;
    private List<ConstantModelParameter<?, Q>> constants;
    private TargetMeasurements targetMetric;
    
    private static final Logger LOGGER = Logger.getLogger(AbstractNonLinearRegression.class.getName());
    
    public AbstractNonLinearRegression(Expression expression, List<VariableMeasurements> measurements, List<ConstantModelParameter<?, Q>> constants, TargetMeasurements targetMetric) {
        this.expression = expression;
        this.measurements = measurements;
        this.constants = constants;
        this.targetMetric = targetMetric;        
    }
    
    public List<DoubleModelParameter<Q>> constructModel() {
        RRegressionConnection rConnection = RRegressionConnectionImpl.getRRegressionConnection();
        ExportVisitor<String> visitor = new ExportVisitor<String>(createRCompatibleExportVisitorConfiguration());
        RUtils.ensurePackageAvailability(getRequiredPackages(), rConnection);
        expression.accept(visitor);
        
        String targetName = RUtils.sanitizeNameForR(targetMetric.getName());
        rConnection.assign(targetName, targetMetric.getValues());
        
        StringBuilder dataFrameBuilder = new StringBuilder(DATA_FRAME_NAME + R_ASSIGNMENT_OPERATOR + "data.frame(");
        
        for(Measurements variableMeasurements : measurements) {
            rConnection.assign(variableMeasurements.getName(), variableMeasurements.getValues());
            dataFrameBuilder.append(variableMeasurements.getName() + R_PARAMETER_SEPARATOR);
        }
        
        dataFrameBuilder.append(targetName);
        
        dataFrameBuilder.append(R_BLOCK_END);
        
        String dataFrameCommand = dataFrameBuilder.toString();
        rConnection.execute(dataFrameCommand);
        
        StringBuilder commandString = new StringBuilder(getFunctionName());
        commandString.append(RUtils.sanitizeNameForR(targetMetric.getName()));
        commandString.append(R_REGRESSION_RELATIONHSIP_OPERATOR);
        commandString.append(visitor.toString());
        commandString.append(R_PARAMETER_SEPARATOR);
        commandString.append("data = " + DATA_FRAME_NAME + R_PARAMETER_SEPARATOR);
        commandString.append(R_START_VALUES_BLOCK);
        appendRegressionStartValues(commandString, constants);
        commandString.append(R_BLOCK_END);
        commandString.append(R_COMMAND_POSTFIX);
        String command = commandString.toString();
        
        Vector<REXP> rawResults = rConnection.execute(R_TARGET_NAME + " " + R_ASSIGNMENT_OPERATOR + command);        
        rawResults = rConnection.execute(buildReadResultsCommand(R_TARGET_NAME));
        
        double[] values = null;
        String[] names = null;
        try {
            values = rawResults.get(0).asDoubles();
            names = rawResults.get(1).asStrings();
        } catch (REXPMismatchException e) {
            LOGGER.error("Error converting regression results: " + e.toString());
        }

        
        List<DoubleModelParameter<Q>> modelParameters = new ArrayList<DoubleModelParameter<Q>>();
        for (int i = 0; i < values.length; i++) {
            modelParameters.add(new DoubleModelParameter<Q>(names[i], Measure.valueOf(values[i], constants.get(i).getUnit())));
        }
        
        if (values.length != names.length) throw new RuntimeException("The parameter name description and the values"
                + " in the R result vector do not fit.");
        return modelParameters;
    }
    
    public abstract String getFunctionName();

    private void appendRegressionStartValues(StringBuilder commandString, List<ConstantModelParameter<?, Q>> constants) {
        Iterator<ConstantModelParameter<?, Q>> measurementsIt = constants.iterator();
        while (measurementsIt.hasNext()) {
            ConstantModelParameter<?, ? extends Quantity> next = measurementsIt.next();
            commandString.append(RUtils.sanitizeNameForR(next.getName()));
            commandString.append(R_START_VALUE_ASSIGNMENT_OPERATOR);
            commandString.append(next.getValue().getValue().toString());
            if(measurementsIt.hasNext()) {
                commandString.append(R_PARAMETER_SEPARATOR);
            }
        }
    }

    public Map<Class<?>, ExportTripleProvider<String>> createRCompatibleExportVisitorConfiguration() {
        Map<Class<?>, ExportTripleProvider<String>> configuration = 
                new HashMap<Class<?>, ExportTripleProvider<String>>();
        Map<String, ExportTripleProvider<String>> functionExpressions = 
                new HashMap<String, ExportTripleProvider<String>>();
        functionExpressions.put("exp", new SimpleTriple("exp", "", ""));
        functionExpressions.put("pow", new ExportTripleProvider<String>() {
            
            @Override
            public ExportTriple<String> getExportTriple(Expression expression,
                    ExportVisitor<String> rExportVisitor) {
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
            public ExportTriple<String> getExportTriple(Expression expression,
                    ExportVisitor<String> rExportVisitor) {
                return new SimpleTriple("", rExportVisitor.getFunctionParameterSeparatorStack().pop(), "");
            }
        });
        
        configuration.put(FunctionExpression.class, new FunctionExpressionExportTripleProvider<String>(
                functionExpressions));
        configuration.put(IdentifierExpression.class, new ExportTripleProvider<String>() {
            
            @Override
            public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> visitor) {
                return new SimpleTriple(((IdentifierExpression)expression).getIdentifierName(),"", "");
            }
        });
        configuration.put(NumericExpression.class, new ExportTripleProvider<String>() {
            
            @Override
            public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> visitor) {
                try {
                    return new SimpleTriple( 
                            ((NumericExpression)expression).getValue().getValue().toString(), "", "");
                } catch (ExpressionEngineException e) {
                    LOGGER.error("Could not instantiate expression: " + e.toString());
                }
                return null; //Wird nie aufgerufen, da getValue an dieser Stelle NIE eine ExpressionEngineException werfen wird
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
        rConnection.execute(rCommand);
        return pngFile;
    }

    private String generatePlotCommand() {
        StringBuilder rCommandBuilder = new StringBuilder();
        // TODO extract dimension delineation.
        rCommandBuilder.append(FIT_FNC + R_ASSIGNMENT_OPERATOR + "function(" + R_X_PARAM + ") predict(" + R_TARGET_NAME 
                    +  ", list(" + this.measurements.get(0).getName() +"=" + R_X_PARAM + ")" + R_BLOCK_END + "\n");
        rCommandBuilder.append("plot.new()\n");
        rCommandBuilder.append("curve(" + FIT_FNC + ", from=0, to=1" +  ", col=563, " + " xlab=\"" + this.measurements.get(0).getName() + "\"" 
                + ", " + "ylab=\"" + this.targetMetric.getUnit() + "\"" + R_BLOCK_END + "\n");
        rCommandBuilder.append("points(" + DATA_FRAME_NAME + ", pch=3" + R_BLOCK_END + "\n");
        rCommandBuilder.append("curve(" + FIT_FNC + ", add=TRUE, col=563" + R_BLOCK_END + "\n");
        return rCommandBuilder.toString();
    }

    protected Iterable<String> getRequiredPackages() {
        return new ArrayList<String>(0);
    }
    
    private String buildReadResultsCommand(String resultName) {
        return "coef(" + resultName + ");\n"
                + "names(coef(" + resultName + "));\n";
    }
    
}
