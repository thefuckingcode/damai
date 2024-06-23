package com.taobao.android.ultron.expr;

/* compiled from: Taobao */
interface ValueResolver {
    boolean canResolve(Object obj, Class<?> cls, String str);

    Object resolve(Object obj, Class<?> cls, String str);
}
