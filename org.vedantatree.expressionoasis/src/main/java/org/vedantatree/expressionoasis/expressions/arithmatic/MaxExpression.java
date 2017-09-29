package org.vedantatree.expressionoasis.expressions.arithmatic;

import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.BinaryOperatorExpression;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

public class MaxExpression extends BinaryOperatorExpression {
    static
    {
        addTypePair(MaxExpression.class, Type.LONG, Type.LONG, Type.LONG );
        addTypePair(MaxExpression.class, Type.DOUBLE, Type.DOUBLE, Type.DOUBLE );
        addTypePair(MaxExpression.class, Type.LONG, Type.DOUBLE, Type.DOUBLE );
        addTypePair(MaxExpression.class, Type.DOUBLE, Type.LONG, Type.DOUBLE );
        addTypePair(MaxExpression.class, Type.OBJECT, Type.OBJECT, Type.OBJECT );
        addTypePair(MaxExpression.class, Type.DOUBLE, Type.OBJECT, Type.DOUBLE );
        addTypePair(MaxExpression.class, Type.OBJECT, Type.DOUBLE, Type.DOUBLE );
        addTypePair(MaxExpression.class, Type.LONG, Type.OBJECT, Type.LONG );
        addTypePair(MaxExpression.class, Type.OBJECT, Type.LONG, Type.LONG );
    }
    
    /**
     * Applies the minimum function.
     * 
     * @see org.vedantatree.expressionoasis.expressions.Expression#getValue()
     */
    public ValueObject getValue() throws ExpressionEngineException
    {
        Object leftValue = leftOperandExpression.getValue().getValue();
        Object rightValue = rightOperandExpression.getValue().getValue();
        Object result = null;
        Type returnType = getReturnType();

        if( leftValue != null && rightValue != null )
        {
            if( returnType == Type.LONG )
            {
                result = new Long(Math.max(((Number) leftValue).longValue(), ((Number) rightValue).longValue()));
            }
            else if( returnType == Type.DOUBLE )
            {
                result = new Double(Math.max(((Number) leftValue).doubleValue(), ((Number) rightValue).doubleValue()));
            }
        }

        return new ValueObject( result, returnType );
    }
}
