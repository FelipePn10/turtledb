package com.db.turtle.a_frontend.common.denominator;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;

public interface E_BinaryOperator {
        void validate(DataType left, DataType right);

}
