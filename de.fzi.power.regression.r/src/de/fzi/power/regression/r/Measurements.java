package de.fzi.power.regression.r;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

public abstract class Measurements implements ModelParameter {

    protected String name;
    protected double[] values;
    private Unit<? extends Quantity> unit;

    public Measurements(String name, Unit<? extends Quantity> unit,  double[] values) {
        this.name = name;
        this.unit = unit;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public double[] getValues() {
        return values;
    }

    public Unit<? extends Quantity> getUnit() {
        return unit;
    }

    public abstract Measurements instantiate(String name, Unit<? extends Quantity> unit, double[] addAll);

}