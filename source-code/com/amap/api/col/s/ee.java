package com.amap.api.col.s;

/* compiled from: Taobao */
public abstract class ee implements Runnable {
    a e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface a {
        void a(ee eeVar);
    }

    public abstract void a();

    public final void run() {
        a aVar;
        try {
            if (!Thread.interrupted()) {
                a();
                if (!Thread.interrupted() && (aVar = this.e) != null) {
                    aVar.a(this);
                }
            }
        } catch (Throwable th) {
            cl.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
