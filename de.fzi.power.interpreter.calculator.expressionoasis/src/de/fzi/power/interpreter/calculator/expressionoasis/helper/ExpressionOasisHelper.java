package de.fzi.power.interpreter.calculator.expressionoasis.helper;

import java.util.Objects;

import org.vedantatree.expressionoasis.ExpressionContext;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.interpreter.calculator.expressionoasis.custom.CustomExpressionContext;
import de.fzi.power.interpreter.calculator.expressionoasis.custom.MeasuredValuesCompositeValueObject;

public final class ExpressionOasisHelper {

    private ExpressionOasisHelper() {
    }

    /**
     * Gets whether the given value object has a numeric type.<br>
     * This method call is equivalent to (in case no exception occurs) calling
     * {@code isNumericType(valueObject.getValueType()}.
     * 
     * @param valueObject
     *            A {@link ValueObject}.
     * @return {@code true} if the given value object has a numeric type, {@code false} otherwise.
     * @throws NullPointerException
     *             In case the passed value object is {@code null}.
     * @see #isNumericType(Type)
     */
    public static boolean hasNumericType(ValueObject valueObject) {
        return isNumericType(Objects.requireNonNull(valueObject).getValueType());
    }

    /**
     * Gets whether the given type is numeric.
     * 
     * @param type
     *            The {@link Type} instance to check
     * @return {@code true} if the passed type is equal to {@link Type#Double}, {@link Type#INTEGER}
     *         , {@link Type#LONG}, {@link Type#FLOAT}, {@link Type#SHORT} or {@link Type#BYTE}.
     * @throws NullPointerException
     *             In case the passed type is {@code null}.
     */
    public static boolean isNumericType(Type type) {
        return typesEqual(type, Type.DOUBLE) || typesEqual(type, Type.INTEGER) || typesEqual(type, Type.LONG)
                || typesEqual(type, Type.FLOAT) || typesEqual(type, Type.SHORT) || typesEqual(type, Type.BYTE);
    }

    /**
     * Convenience method to check whether the given two type instances are equal.
     * 
     * @param first
     *            A {@link Type} instance.
     * @param second
     *            A {@link Type} instance.
     * @return {@code true} if both type instances are equal, otherwise {@code false}.
     * @throws NullPointerException
     *             In case either of the passed types is {@code null}.
     */
    public static boolean typesEqual(Type first, Type second) {
        return Objects.requireNonNull(first).equals(Objects.requireNonNull(second));
    }

    /**
     * Gets whether the given value object has a composite type.
     * 
     * @param valueObject
     *            A {@link ValueObject} instance.
     * @return {@code true} <b>iff</b> the given value object is a
     *         {@link MeasuredValuesCompositeValueObject} instance, {@code false} otherwise.
     * @throws NullPointerException
     *             In case the passed value object is {@code null}.
     */
    public static boolean hasCompositeType(ValueObject valueObject) {
        return typesEqual(Objects.requireNonNull(valueObject).getValueType(),
                MeasuredValuesCompositeValueObject.getType());
    }

    /**
     * Asserts that the given expression context instance is a {@link CustomExpressionContext}
     * instance.
     * 
     * @param expressionContext
     *            The {@link ExpressionContext} to check.
     * @param assertingClass
     *            The {@link Class} of the object which is calling this method.<br>
     *            This parameter is only used to construct a message if the passed expression
     *            context has the wrong type.
     * @throws AssertionError
     *             In case the given expression context is not a {@link CustomExpressionContext}
     *             instance.
     */
    public static void assertCorrectExpressionContext(ExpressionContext expressionContext, Class<?> assertingClass) {
        if (!(Objects.requireNonNull(expressionContext) instanceof CustomExpressionContext)) {
            throw new AssertionError(assertingClass.getSimpleName() + " only works with "
                    + CustomExpressionContext.class.getSimpleName() + " instances!");
        }
    }
}
