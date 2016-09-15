package de.fzi.power.regression.r.expressionoasis;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.DecimalExpression;
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

import de.fzi.power.regression.r.AbstractNonLinearRegression;
import de.fzi.power.regression.r.FunctionExpressionExportTripleProvider;

public class ExpressionUtil {

    private static final Map<Class<?>, ExportTripleProvider<String>> STRING_CONVERSION_MAPPING;
    private static final Logger LOGGER = Logger.getLogger(ExpressionUtil.class.getName());
    
    static {
        STRING_CONVERSION_MAPPING = initStringConversionMap();
    }

    public static Expression createFromRFunction(String expressionString) {
        Expression parsedExpression = null;
        try {
            parsedExpression = ExpressionEngine.compileExpression(expressionString, new ExpressionContext(), false);
        } catch (ExpressionEngineException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return parsedExpression;
    }

    private static Map<Class<?>, ExportTripleProvider<String>> initStringConversionMap() {
        Map<Class<?>, ExportTripleProvider<String>> configuration = 
                new HashMap<Class<?>, ExportTripleProvider<String>>();
        Map<String, ExportTripleProvider<String>> functionExpressions = 
                new HashMap<String, ExportTripleProvider<String>>();
        functionExpressions.put("exp", new SimpleTriple("exp", "", ""));
        functionExpressions.put("pow", new SimpleTriple("pow", "", ""));
        
        configuration = new HashMap<Class<?>, ExportTripleProvider<String>>();
        configuration.put(MultiplyExpression.class, new SimpleTriple("", "*", ""));
        configuration.put(AddExpression.class, new SimpleTriple("", "+", ""));
        configuration.put(SubtractExpression.class, new SimpleTriple("", "-", ""));
        configuration.put(DivideExpression.class, new SimpleTriple("", "/", ""));
        configuration.put(ParanthesisExpression.class, new SimpleTriple("(", "", ")"));
        
        configuration.put(MinusExpression.class, new SimpleTriple("-", "", ""));
        
        configuration.put(DecimalExpression.class, new ExportTripleProvider<String>() {
            
            @Override
            public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> visitor) {
                try {
                    return new SimpleTriple(((DecimalExpression)expression).getValue().toString(),"", "");
                } catch (ExpressionEngineException e) {
                    LOGGER.error("Expression " + expression.toString() + " was not a DecimalExpression!");
                }
                // This should never happen
                return null;
            }
        });
        
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
        
        configuration.put(DecimalExpression.class, new ExportTripleProvider<String>() {
            
            @Override
            public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> visitor) {
                try {
                    return new SimpleTriple( 
                            ((DecimalExpression)expression).getValue().getValue().toString(), "", "");
                } catch (ExpressionEngineException e) {
                    LOGGER.error("Could not instantiate expression: " + e.toString());
                }
                return null; //Wird nie aufgerufen, da getValue an dieser Stelle NIE eine ExpressionEngineException werfen wird
            }
        });
        
        return configuration;
    }

    public static String convertToInputString(Expression expression) {
        ExportVisitor<String> exportVisitor = new ExportVisitor<String>(STRING_CONVERSION_MAPPING);
        expression.accept(exportVisitor);
        return exportVisitor.toString();
    }

}
