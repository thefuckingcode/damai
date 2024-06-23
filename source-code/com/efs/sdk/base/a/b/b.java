package com.efs.sdk.base.a.b;

import androidx.annotation.Nullable;
import java.util.concurrent.ConcurrentHashMap;
import tb.q33;
import tb.t43;

/* compiled from: Taobao */
public final class b {
    private ConcurrentHashMap<Byte, e> a = new ConcurrentHashMap<>();

    @Nullable
    public final e a(byte b) {
        e eVar;
        Byte b2;
        ConcurrentHashMap<Byte, e> concurrentHashMap;
        if (!this.a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                concurrentHashMap = this.a;
                b2 = Byte.valueOf(b);
                eVar = new d();
            } else if (b != 2) {
                t43.b("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)), null);
            } else {
                concurrentHashMap = this.a;
                b2 = Byte.valueOf(b);
                eVar = new q33();
            }
            concurrentHashMap.putIfAbsent(b2, eVar);
        }
        return this.a.get(Byte.valueOf(b));
    }
}
