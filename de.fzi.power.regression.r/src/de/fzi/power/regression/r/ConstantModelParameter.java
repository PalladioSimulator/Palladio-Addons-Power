package de.fzi.power.regression.r;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

public abstract class ConstantModelParameter<T, Q extends Quantity> implements ModelParameter {

    private String name;
    private Measure<T,Q> value;

    public ConstantModelParameter(String name, Measure<T,Q> value) {
        this.name = name;
        this.value = value;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    public Measure<T,Q> getValue() {
        return value;
    }
    
    public abstract Measure<T,Q> asMeasure(T value);

    public Unit<Q> getUnit() {
        return getValue().getUnit();
    }
}

