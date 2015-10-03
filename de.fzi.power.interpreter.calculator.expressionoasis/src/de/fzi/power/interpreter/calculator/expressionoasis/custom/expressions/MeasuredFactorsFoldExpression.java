package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

import java.util.Objects;

import org.vedantatree.expressionoasis.EOErrorCodes;
import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.expressions.ExpressionTypeFinder;
import org.vedantatree.expressionoasis.expressions.IdentifierExpression;
import org.vedantatree.expressionoasis.expressions.UnaryOperatorExpression;
import org.vedantatree.expressionoasis.expressions.arithmatic.ParanthesisExpression;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.interpreter.calculator.expressionoasis.custom.CustomExpressionContext;
import de.fzi.power.interpreter.calculator.expressionoasis.helper.ExpressionOasisHelper;

abstract class MeasuredFactorsFoldExpression extends UnaryOperatorExpression {

    private final EvaluationVisitor evaluator;
    private final String opcode;

    MeasuredFactorsFoldExpression(EvaluationVisitor evaluator, String opcode) {
        this.evaluator = Objects.requireNonNull(evaluator);
        this.opcode = Objects.requireNonNull(opcode);
    }

    @Override
    public Type getReturnType() {
        return Type.DOUBLE;
    }

    @Override
    public ValueObject getValue() throws ExpressionEngineException {
        return this.evaluator.evaluate(getOperandExpression());
    }

    @Override
    public void initialize(ExpressionContext expressionContext, Object parameters, boolean validate)
            throws ExpressionEngineException {
        ExpressionOasisHelper.assertCorrectExpressionContext(expressionContext, this.getClass());
        super.initialize(expressionContext, parameters, validate);
    }

    @Override
    protected void validate(ExpressionContext context) throws ExpressionEngineException {
        ExpressionOasisHelper.assertCorrectExpressionContext(context, this.getClass());
        CustomExpressionContext expressionContext = (CustomExpressionContext) context;
        if (ExpressionOasisHelper.isNumericType(getOperandExpression().getReturnType())) {
            ExpressionTypeFinder identifierFinder = new ExpressionTypeFinder(getOperandExpression(),
                    IdentifierExpression.class);
            boolean foundMeasuredFactor = false;
            for (Expression found : identifierFinder.getExpressions()) {
                IdentifierExpression foundIdentifier = (IdentifierExpression) found;
                if (expressionContext.isMeasuredFactorAvailable(foundIdentifier.getIdentifierName())) {
                    foundMeasuredFactor = true;
                    break;
                }
            }
            if (!foundMeasuredFactor) {
                throw new ExpressionEngineException(
                        "Operand is not supported by \"" + this.opcode
                                + "\", for it does not contain any measured factor!",
                        EOErrorCodes.INVALID_OPERAND_TYPE, null);
            }
        }
    }

    @Override
    public Expression getOperandExpression() {
        Expression operand = super.getOperandExpression();
        while (operand instanceof ParanthesisExpression) {
            operand = ((ParanthesisExpression) operand).getOperandExpression();
        }
        return operand;
    }
}
