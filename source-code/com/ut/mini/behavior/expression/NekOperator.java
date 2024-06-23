package com.ut.mini.behavior.expression;

/* compiled from: Taobao */
class NekOperator extends EkOperator {
    NekOperator() {
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator, com.ut.mini.behavior.expression.EkOperator
    public boolean apply(Object obj, Object obj2) {
        return !super.apply(obj, obj2);
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator, com.ut.mini.behavior.expression.EkOperator
    public String getOperatorSymbol() {
        return "!ek";
    }
}
