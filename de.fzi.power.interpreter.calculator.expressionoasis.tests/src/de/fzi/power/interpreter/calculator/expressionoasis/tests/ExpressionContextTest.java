package de.fzi.power.interpreter.calculator.expressionoasis.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.ExpressionEngine;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.extensions.DefaultVariableProvider;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

public class ExpressionContextTest {
    ExpressionContext context = null;
    
    @Before
    public void setUpTest() throws ExpressionEngineException {
        context = new ExpressionContext();

    }
    
    @Test
    public void testExpressionContextOne() throws ExpressionEngineException {
        DefaultVariableProvider dvp = new DefaultVariableProvider();
        dvp.addVariable("C1", new ValueObject(2.0, Type.DOUBLE));
        dvp.addVariable("C2", new ValueObject(1.0, Type.DOUBLE));
        dvp.addVariable("C3", new ValueObject(1.0, Type.DOUBLE));
        context.addVariableProvider(dvp);
        
        Expression ex = ExpressionEngine.compileExpression("C1 + C2 + C3", 
                context, true); 
        
        assertThat(ex.getValue().getValue(), equalTo((Object)4.0));
    }

}
