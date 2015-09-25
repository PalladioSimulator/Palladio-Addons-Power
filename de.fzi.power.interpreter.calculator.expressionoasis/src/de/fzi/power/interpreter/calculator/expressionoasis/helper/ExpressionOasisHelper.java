package de.fzi.power.interpreter.calculator.expressionoasis.helper;

import org.vedantatree.expressionoasis.types.Type;

public final class ExpressionOasisHelper {

    private ExpressionOasisHelper() {
    }

    public static boolean isNumericType(Type type) {
        return typesEqual(type, Type.DOUBLE) || typesEqual(type, Type.INTEGER) || typesEqual(type, Type.LONG)
                || typesEqual(type, Type.FLOAT) || typesEqual(type, Type.SHORT) || typesEqual(type, Type.BYTE);
    }

    public static boolean typesEqual(Type first, Type second) {
        return first.equals(second);
    }

}
