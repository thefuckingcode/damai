package com.amap.api.mapcore.util;

/* compiled from: Taobao */
public abstract class jk implements Runnable {
    a e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface a {
        void a(jk jkVar);

        void b(jk jkVar);

        void c(jk jkVar);
    }

    public final void cancelTask() {
        try {
            a aVar = this.e;
            if (aVar != null) {
                aVar.c(this);
            }
        } catch (Throwable th) {
            hd.c(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    public final void run() {
        a aVar;
        try {
            a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.a(this);
            }
            if (!Thread.interrupted()) {
                runTask();
                if (!Thread.interrupted() && (aVar = this.e) != null) {
                    aVar.b(this);
                }
            }
        } catch (Throwable th) {
            hd.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
