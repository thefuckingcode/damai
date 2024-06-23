package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushsdk.c.b.a;
import com.meizu.cloud.pushsdk.c.c.k;

/* compiled from: Taobao */
public class c<T> {
    private final T a;
    private final a b;
    private k c;

    public c(a aVar) {
        this.a = null;
        this.b = aVar;
    }

    public c(T t) {
        this.a = t;
        this.b = null;
    }

    public static <T> c<T> a(a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>((Object) t);
    }

    public T a() {
        return this.a;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public boolean b() {
        return this.b == null;
    }

    public a c() {
        return this.b;
    }
}
