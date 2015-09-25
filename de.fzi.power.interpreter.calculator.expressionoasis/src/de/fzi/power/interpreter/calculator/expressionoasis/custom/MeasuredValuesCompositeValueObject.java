package de.fzi.power.interpreter.calculator.expressionoasis.custom;

import java.util.Collection;
import java.util.Objects;

import org.vedantatree.expressionoasis.types.ValueObject;

public final class MeasuredValuesCompositeValueObject extends ValueObject {

    public MeasuredValuesCompositeValueObject(Collection<Double> value) {
        super(Objects.requireNonNull(value, "Given collection of values must not be null."),
                CustomExpressionContext.MEASURED_VALUES_COMPOSITE_TYPE);
    }

    @Override
    public Iterable<Double> getValue() {
        @SuppressWarnings("unchecked")
        // this cast is typesafe, as we pass a collection via this class ctor!
        Collection<Double> value = (Collection<Double>) super.getValue();
        return value;
    }

}
