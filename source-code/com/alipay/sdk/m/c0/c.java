package com.alipay.sdk.m.c0;

/* compiled from: Taobao */
public final class c implements Runnable {
    public final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        try {
            this.a.b();
        } catch (Exception e) {
            d.a(e);
        }
    }
}
