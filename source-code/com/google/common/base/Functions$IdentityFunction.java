package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
enum Functions$IdentityFunction implements Function<Object, Object> {
    INSTANCE;

    @Override // com.google.common.base.Function
    @NullableDecl
    public Object apply(@NullableDecl Object obj) {
        return obj;
    }

    public String toString() {
        return "Functions.identity()";
    }
}
