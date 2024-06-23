package com.taobao.android.dinamic.expression.parser.resolver;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface ValueResolver {
    boolean canResolve(Object obj, Class<?> cls, String str);

    Object resolve(Object obj, Class<?> cls, String str);
}
