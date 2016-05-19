package de.fzi.power.regression.r;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

public class TargetMeasurements extends Measurements {

    public TargetMeasurements(String name, Unit<? extends Quantity> unit, double[] values) {
        super(name, unit, values);
    }

    @Override
    public Measurements instantiate(String name, Unit<? extends Quantity> unit, double[] addAll) {
        return new TargetMeasurements(name, unit, addAll);
    }

}
