package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import java.util.Objects;

import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;

import de.fzi.power.specification.MeasuredFactor;

/**
 * This class is a specialized {@link ValueObject} to deal with {@link MeasuredFactor}s.<br>
 * Distinctive feature of this value object is its composite character, that is, it can hold more
 * than one value.
 * 
 * @author Florian Rosenthal
 *
 */
public final class MeasuredValuesCompositeValueObject extends ValueObject {

    /**
     * Initializes a new instance of the {@link MeasuredValuesCompositeValueObject} class.
     * 
     * @param value
     *            An {@link Iterable} of all values, each of which related to a measured
     *            value/factor..
     * @throws NullPointerException
     *             In case the given iterable is {@code null}.
     */
    public MeasuredValuesCompositeValueObject(Iterable<Double> value) {
        super(Objects.requireNonNull(value, "Given collection of values must not be null."),
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE);
    }

    @Override
    public Iterable<Double> getValue() {
        @SuppressWarnings("unchecked")
        // this cast is typesafe, as we pass an iterable via the sole ctor!
        Iterable<Double> value = (Iterable<Double>) super.getValue();
        return value;
    }

    /**
     * Gets the type which all instances of this class have.
     * 
     * @return The {@link Type} of all class instances.
     * @see CustomExpressionContext#MEASURED_VALUES_COMPOSITE_TYPE
     */
    public static Type getType() {
        return CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE;
    }

}
