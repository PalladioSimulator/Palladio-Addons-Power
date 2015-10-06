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
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.MeasuredFactor;

/**
 * Base class for functions (which are treated as {@link UnaryOperatorExpression}s) that wish to
 * process (more precisely, to fold/reduce) {@link MeasuredFactor}s in functional {@link Expression}
 * s within {@link DeclarativePowerModelSpecification}s.<br>
 * Typical examples of such fold expressions are {@code (+)} or {@link (*)} known from functional
 * programming languages.<br>
 * Trait of such expression is that they take a collection of numeric values (the measurements that
 * belong to a {@link MeasuredFactor} and return a single value, i.e., the collection is folded.
 * <br>
 * <br>
 * <b>Important:</b> Each subclass must be registered to the ExpressionOasis library to become
 * effective. That is, the opcode of the expression must be added to the set of
 * {@code unary operators} in {@code grammar.xml} in the ExpressionOasis plug-in.
 * 
 * @author Florian Rosenthal
 *
 */
abstract class MeasuredFactorsFoldExpression extends UnaryOperatorExpression {

    private final EvaluationVisitor evaluator;
    private final String opcode;

    /**
     * Initializes a new instance of the {@link MeasuredFactorsFoldExpression} class.
     * 
     * @param evaluator
     *            The {@link EvaluationVisitor} that defines the corresponding fold operation.
     * @param opcode
     *            The opcode of the expression, i.e., the function name.
     * @throws NullPointerException
     *             In case either argument is {@code null}.
     * @throws IllegalArgumentException
     *             In case the passed opcode is empty.
     */
    MeasuredFactorsFoldExpression(EvaluationVisitor evaluator, String opcode) {
        this.evaluator = Objects.requireNonNull(evaluator);
        this.opcode = Objects.requireNonNull(opcode);
        if (this.opcode.isEmpty()) {
            throw new IllegalArgumentException("EXpression opcode must not be null!");
        }
    }

    /**
     * @return {@link Type#DOUBLE}.
     */
    @Override
    public Type getReturnType() {
        return Type.DOUBLE;
    }

    /**
     * Evaluates the expression, that is, the corresponding fold operation is executed.
     * 
     * @return A {@link ValueObject} of {@link Type#DOUBLE} that contains the result of the fold
     *         operation.
     */
    @Override
    public final ValueObject getValue() throws ExpressionEngineException {
        return this.evaluator.evaluate(getOperandExpression());
    }

    /**
     * @throws AssertionError
     *             In case the given expression context is not a {@link CustomExpressionContext}
     *             instance.
     */
    @Override
    public void initialize(ExpressionContext expressionContext, Object parameters, boolean validate)
            throws ExpressionEngineException {
        ExpressionOasisHelper.assertCorrectExpressionContext(expressionContext, this.getClass());
        super.initialize(expressionContext, parameters, validate);
    }

    /**
     * @throws AssertionError
     *             In case the given expression context is not a {@link CustomExpressionContext}
     *             instance.
     * @throws ExpressionEngineException
     *             In case the operand does not contain any measured factor.
     */
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
