package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.operator;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DecimalType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.IntegerType;

public final class TypeResolver {
    /*
     * Determina qual será o tipo lógico resultante de uma operação aritmética.
     * */
    public static DataType resolveArithmeticResult(DataType left, DataType right) {
        if (left instanceof DecimalType d1 && right instanceof DecimalType d2) {
            // Estou usando a maior precision entre os dois,
            // é uma regra simplificada, mas coerente para um engine inicial.
            // DECIMAL(10,2) + DECIMAL(8,3) = DECIMAL(10,3)
            int precision = Math.max(d1.getPrecision(), d2.getPrecision());
            int scale = Math.max(
                    d1.getScale() == null ? 0 : d1.getScale(),
                    d2.getScale() == null ? 0 : d2.getScale()
            );
            return new DecimalType(precision, scale);
        }

        if (left instanceof DecimalType d) {
            return new DecimalType(d.getPrecision(), d.getScale());
        }

        if (right instanceof DecimalType d) {
            return new DecimalType(d.getPrecision(), d.getScale());
        }

        return new IntegerType();
    }

}
