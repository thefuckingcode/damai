package com.meizu.cloud.pushsdk.b;

/* compiled from: Taobao */
public class h<T> {
    private T a;
    private T b;

    protected h(T t) {
        if (t != null) {
            this.b = t;
            return;
        }
        throw new RuntimeException("proxy must be has a default implementation");
    }

    /* access modifiers changed from: protected */
    public T c() {
        T t = this.a;
        return t != null ? t : this.b;
    }
}
