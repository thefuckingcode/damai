package com.google.common.base;

import tb.ds1;

/* compiled from: Taobao */
enum Functions$ToStringFunction implements Function<Object, String> {
    INSTANCE;

    public String toString() {
        return "Functions.toStringFunction()";
    }

    @Override // com.google.common.base.Function
    public String apply(Object obj) {
        ds1.p(obj);
        return obj.toString();
    }
}
