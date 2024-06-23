package com.taobao.android.ultron.expr;

import java.util.List;
import tb.tr2;

/* compiled from: Taobao */
class d implements ValueResolver {
    d() {
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return obj instanceof List;
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        try {
            return ((List) obj).get(Integer.parseInt(str));
        } catch (Exception e) {
            tr2.g(e.getMessage(), new String[0]);
            return null;
        }
    }
}
