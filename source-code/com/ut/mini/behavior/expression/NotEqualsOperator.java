package com.ut.mini.behavior.expression;

/* compiled from: Taobao */
class NotEqualsOperator extends EqualsOperator {
    NotEqualsOperator() {
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator, com.ut.mini.behavior.expression.EqualsOperator
    public boolean apply(Object obj, Object obj2) {
        return !super.apply(obj, obj2);
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator, com.ut.mini.behavior.expression.EqualsOperator
    public String getOperatorSymbol() {
        return "!eq";
    }
}
