package com.loc;

/* compiled from: Taobao */
public abstract class ck implements Runnable {
    a e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface a {
        void a(ck ckVar);
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
            an.m(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
