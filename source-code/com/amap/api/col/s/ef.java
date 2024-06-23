package com.amap.api.col.s;

import com.amap.api.col.s.ee;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Taobao */
public abstract class ef {
    protected ThreadPoolExecutor a;
    protected ee.a b = new ee.a() {
        /* class com.amap.api.col.s.ef.AnonymousClass1 */

        @Override // com.amap.api.col.s.ee.a
        public final void a(ee eeVar) {
            ef.this.a(eeVar);
        }
    };
    private ConcurrentHashMap<ee, Future<?>> c = new ConcurrentHashMap<>();

    private synchronized void a(ee eeVar, Future<?> future) {
        try {
            this.c.put(eeVar, future);
        } catch (Throwable th) {
            cl.c(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean c(ee eeVar) {
        boolean z;
        try {
            z = this.c.containsKey(eeVar);
        } catch (Throwable th) {
            cl.c(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }

    public final void b(ee eeVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (!c(eeVar) && (threadPoolExecutor = this.a) != null && !threadPoolExecutor.isShutdown()) {
            eeVar.e = this.b;
            try {
                Future<?> submit = this.a.submit(eeVar);
                if (submit != null) {
                    a(eeVar, submit);
                }
            } catch (RejectedExecutionException e) {
                cl.c(e, "TPool", "addTask");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void a(ee eeVar) {
        try {
            this.c.remove(eeVar);
        } catch (Throwable th) {
            cl.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
