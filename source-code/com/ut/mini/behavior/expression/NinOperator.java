package com.ut.mini.behavior.expression;

/* compiled from: Taobao */
class NinOperator extends InOperator {
    NinOperator() {
    }

    @Override // com.ut.mini.behavior.expression.InOperator, com.ut.mini.behavior.expression.BinaryOperator
    public boolean apply(Object obj, Object obj2) {
        return !super.apply(obj, obj2);
    }

    @Override // com.ut.mini.behavior.expression.InOperator, com.ut.mini.behavior.expression.BinaryOperator
    public String getOperatorSymbol() {
        return "!in";
    }
}
