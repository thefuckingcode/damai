package com.ut.mini.behavior.expression;

/* compiled from: Taobao */
abstract class BinaryOperator {
    BinaryOperator() {
    }

    public abstract boolean apply(Object obj, Object obj2);

    public abstract String getOperatorSymbol();
}
