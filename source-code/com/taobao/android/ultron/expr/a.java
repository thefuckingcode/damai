package com.taobao.android.ultron.expr;

import java.lang.reflect.Array;
import tb.tr2;

/* compiled from: Taobao */
class a implements ValueResolver {
    a() {
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return cls.isArray();
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        try {
            return Array.get(obj, Integer.parseInt(str));
        } catch (Exception e) {
            tr2.g(e.getMessage(), new String[0]);
            return null;
        }
    }
}
