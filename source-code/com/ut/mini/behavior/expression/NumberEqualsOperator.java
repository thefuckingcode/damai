package com.ut.mini.behavior.expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import tb.jl1;

/* compiled from: Taobao */
class NumberEqualsOperator extends BinaryOperator {
    NumberEqualsOperator() {
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public boolean apply(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        if (ExpressionUtils.isBigDecimal(obj2)) {
            return ((BigDecimal) ExpressionUtils.coerceToPrimitiveNumber(obj, BigDecimal.class)).equals((BigDecimal) ExpressionUtils.coerceToPrimitiveNumber(obj2, BigDecimal.class));
        }
        if (ExpressionUtils.isFloatingPointType(obj2)) {
            if (ExpressionUtils.coerceToPrimitiveNumber(obj, Double.class).doubleValue() == ExpressionUtils.coerceToPrimitiveNumber(obj2, Double.class).doubleValue()) {
                return true;
            }
            return false;
        } else if (ExpressionUtils.isBigInteger(obj2)) {
            return ((BigInteger) ExpressionUtils.coerceToPrimitiveNumber(obj, BigInteger.class)).equals((BigInteger) ExpressionUtils.coerceToPrimitiveNumber(obj2, BigInteger.class));
        } else {
            if (!ExpressionUtils.isIntegerType(obj2) || ExpressionUtils.coerceToPrimitiveNumber(obj, Long.class).longValue() != ExpressionUtils.coerceToPrimitiveNumber(obj2, Long.class).longValue()) {
                return false;
            }
            return true;
        }
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public String getOperatorSymbol() {
        return jl1.EQUAL2;
    }
}
