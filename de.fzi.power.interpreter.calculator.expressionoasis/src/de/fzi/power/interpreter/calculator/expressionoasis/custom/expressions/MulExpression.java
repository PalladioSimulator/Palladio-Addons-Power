package de.fzi.power.interpreter.calculator.expressionoasis.custom.expressions;

/**
 * Implementation of the {@code (*)} fold operation: All elements of the processed collection are
 * multiplied by each other, {@code 1} is returned in case the collection is empty.<br>
 * Within expressions, this function can be used by {@code MUL(collection)}.
 * 
 * @author Florian Rosenthal
 *
 */
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
