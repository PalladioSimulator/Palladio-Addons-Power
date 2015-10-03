package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

public class MulExpression extends MeasuredFactorsFoldExpression {

    public MulExpression() {
        super(new EvaluationVisitor() {

            @Override
            protected double fold(Iterable<Double> values) {
                double product = 1d;
                for (double value : values) {
                    product *= value;
                }
                return product;
            }
        }, "MUL");
    }

}
