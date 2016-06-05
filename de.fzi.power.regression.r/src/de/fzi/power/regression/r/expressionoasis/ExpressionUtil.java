package de.fzi.power.regression.r.expressionoasis;

import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;

public class ExpressionUtil {

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

}
