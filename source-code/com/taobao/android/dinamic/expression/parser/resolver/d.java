package com.taobao.android.dinamic.expression.parser.resolver;

import java.util.Map;

/* compiled from: Taobao */
class d implements ValueResolver {
    d() {
    }

    @Override // com.taobao.android.dinamic.expression.parser.resolver.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return obj instanceof Map;
    }

    @Override // com.taobao.android.dinamic.expression.parser.resolver.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        return ((Map) obj).get(str);
    }
}
