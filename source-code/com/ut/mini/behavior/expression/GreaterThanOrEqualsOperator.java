package com.ut.mini.behavior.expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import tb.jl1;

/* compiled from: Taobao */
class GreaterThanOrEqualsOperator extends NumberRelationalOperator {
    GreaterThanOrEqualsOperator() {
    }

    @Override // com.ut.mini.behavior.expression.NumberRelationalOperator
    public boolean apply(double d, double d2) {
        return d >= d2;
    }

    @Override // com.ut.mini.behavior.expression.NumberRelationalOperator
    public boolean apply(long j, long j2) {
        return j >= j2;
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator, com.ut.mini.behavior.expression.NumberRelationalOperator
    public boolean apply(Object obj, Object obj2) throws ExpressionException {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return super.apply(obj, obj2);
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public String getOperatorSymbol() {
        return jl1.GE;
    }

    @Override // com.ut.mini.behavior.expression.NumberRelationalOperator
    public boolean apply(String str, String str2) {
        return str.compareTo(str2) >= 0;
    }

    @Override // com.ut.mini.behavior.expression.NumberRelationalOperator
    public boolean apply(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return isGreater(bigDecimal.compareTo(bigDecimal2)) || isEqual(bigDecimal.compareTo(bigDecimal2));
    }

    @Override // com.ut.mini.behavior.expression.NumberRelationalOperator
    public boolean apply(BigInteger bigInteger, BigInteger bigInteger2) {
        return isGreater(bigInteger.compareTo(bigInteger2)) || isEqual(bigInteger.compareTo(bigInteger2));
    }
}
