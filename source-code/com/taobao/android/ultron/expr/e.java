package com.taobao.android.ultron.expr;

import java.util.Map;

/* compiled from: Taobao */
class e implements ValueResolver {
    e() {
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return obj instanceof Map;
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        return ((Map) obj).get(str);
    }
}
