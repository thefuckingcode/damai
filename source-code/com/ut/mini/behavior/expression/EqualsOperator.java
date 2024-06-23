package com.ut.mini.behavior.expression;

import tb.o70;

/* compiled from: Taobao */
class EqualsOperator extends BinaryOperator {
    EqualsOperator() {
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public boolean apply(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            obj = "";
        }
        if (obj2 == null) {
            obj2 = "";
        }
        if (obj instanceof String) {
            return ExpressionUtils.coerceToString(obj).equals(ExpressionUtils.coerceToString(obj2));
        }
        return false;
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public String getOperatorSymbol() {
        return o70.EQUAL_PREFIX;
    }
}
