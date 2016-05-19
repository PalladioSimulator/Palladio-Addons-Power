package de.fzi.power.regression.r;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

public class DoubleModelParameter<Q extends Quantity> extends ConstantModelParameter<Double, Q>{

    public DoubleModelParameter(String name, Measure<Double, Q> startMeasure) {
        super(name, startMeasure);
    }

    @Override
    public Measure<Double, Q> asMeasure(Double value) {
        return Measure.valueOf(value, getValue().getUnit());
    }

}
