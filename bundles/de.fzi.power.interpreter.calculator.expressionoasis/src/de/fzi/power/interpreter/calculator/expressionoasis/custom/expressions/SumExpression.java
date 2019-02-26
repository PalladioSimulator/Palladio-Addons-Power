package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

/**
 * Implementation of the {@code (+)} fold operation: All elements of the processed collection are
 * summed up, {@code 0} is returned in case the collection is empty.<br>
 * Within expressions, this function can be used by {@code SUM(collection)}.
 * 
 * @author Florian Rosenthal
 *
 */
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
