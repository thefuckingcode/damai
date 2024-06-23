package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.ey;

/* compiled from: Taobao */
public abstract class ex<T extends ey<?>> {
    protected T a;

    /* access modifiers changed from: protected */
    public boolean a(T t) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T extends com.amap.api.mapcore.util.ey<T>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T extends com.amap.api.mapcore.util.ey<?>, T extends com.amap.api.mapcore.util.ey<T>] */
    public T b(T t) {
        if (t == null) {
            return null;
        }
        while (t != null) {
            a(t);
            t.f = this.a;
            this.a = t;
            t = t.f;
        }
        return null;
    }
}
