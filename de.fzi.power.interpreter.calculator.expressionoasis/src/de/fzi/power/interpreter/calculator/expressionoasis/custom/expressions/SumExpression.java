package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

public final class SumExpression extends MeasuredFactorsFoldExpression {

    public SumExpression() {
        super(new EvaluationVisitor() {

            @Override
            protected double fold(Iterable<Double> values) {
                double sum = 0d;
                for (double value : values) {
                    sum += value;
                }
                return sum;
            }
        }, "SUM");
    }

}
