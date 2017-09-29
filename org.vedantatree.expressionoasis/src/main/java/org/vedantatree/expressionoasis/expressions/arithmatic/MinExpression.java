package org.vedantatree.expressionoasis.expressions.arithmatic;

import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.BinaryOperatorExpression;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

public class MinExpression extends BinaryOperatorExpression {
    static
    {
        addTypePair( MinExpression.class, Type.LONG, Type.LONG, Type.LONG );
        addTypePair( MinExpression.class, Type.DOUBLE, Type.DOUBLE, Type.DOUBLE );
        addTypePair( MinExpression.class, Type.LONG, Type.DOUBLE, Type.DOUBLE );
        addTypePair( MinExpression.class, Type.DOUBLE, Type.LONG, Type.DOUBLE );
        addTypePair( MinExpression.class, Type.OBJECT, Type.OBJECT, Type.OBJECT );
        addTypePair( MinExpression.class, Type.DOUBLE, Type.OBJECT, Type.DOUBLE );
        addTypePair( MinExpression.class, Type.OBJECT, Type.DOUBLE, Type.DOUBLE );
        addTypePair( MinExpression.class, Type.LONG, Type.OBJECT, Type.LONG );
        addTypePair( MinExpression.class, Type.OBJECT, Type.LONG, Type.LONG );
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
                result = new Long(Math.min(((Number) leftValue).longValue(), ((Number) rightValue).longValue()));
            }
            else if( returnType == Type.DOUBLE )
            {
                result = new Double(Math.min(((Number) leftValue).doubleValue(), ((Number) rightValue).doubleValue()));
            }
        }

        return new ValueObject( result, returnType );
    }
}
