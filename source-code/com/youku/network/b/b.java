package com.youku.network.b;

import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
public class b<T> implements a<T> {
    @Override // com.youku.network.b.a
    public void a(T t) {
        Map<String, String> k = t.k();
        if (k != null && !k.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = k.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (next == null || next.getKey() == null || next.getValue() == null) {
                    it.remove();
                }
            }
        }
    }
}
