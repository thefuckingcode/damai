package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.g.k.c;
import com.huawei.hms.framework.network.grs.h.d;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: Taobao */
public class h {
    private final ExecutorService a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
    private final Map<String, com.huawei.hms.framework.network.grs.g.k.b> b = new ConcurrentHashMap(16);
    private final Object c = new Object();
    private com.huawei.hms.framework.network.grs.e.a d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Callable<d> {
        final /* synthetic */ c a;
        final /* synthetic */ String b;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;

        a(c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            this.a = cVar;
            this.b = str;
            this.c = cVar2;
        }

        @Override // java.util.concurrent.Callable
        public d call() {
            return new c(this.a, h.this.d).a(h.this.a, this.b, this.c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Runnable {
        final /* synthetic */ c a;
        final /* synthetic */ String b;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;
        final /* synthetic */ com.huawei.hms.framework.network.grs.b d;

        b(c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, com.huawei.hms.framework.network.grs.b bVar) {
            this.a = cVar;
            this.b = str;
            this.c = cVar2;
            this.d = bVar;
        }

        public void run() {
            h hVar = h.this;
            hVar.a(hVar.a(this.a, this.b, this.c), this.d);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar == null) {
            return;
        }
        if (dVar == null) {
            Logger.v("RequestController", "GrsResponse is null");
            bVar.a();
            return;
        }
        Logger.v("RequestController", "GrsResponse is not null");
        bVar.a(dVar);
    }

    public d a(c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        Future<d> future;
        String str2;
        String str3;
        Throwable e;
        Logger.d("RequestController", "request to server with service name is: " + str);
        String grsParasKey = cVar.b().getGrsParasKey(true, true, cVar.a());
        Logger.v("RequestController", "request spUrlKey: " + grsParasKey);
        synchronized (this.c) {
            if (!NetworkUtil.isNetworkAvailable(cVar.a())) {
                return null;
            }
            d.a a2 = d.a(grsParasKey);
            com.huawei.hms.framework.network.grs.g.k.b bVar = this.b.get(grsParasKey);
            if (bVar != null) {
                if (bVar.b()) {
                    future = bVar.a();
                    return future.get();
                }
            }
            if (a2 != null) {
                if (a2.a()) {
                    return null;
                }
            }
            Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
            future = this.a.submit(new a(cVar, str, cVar2));
            this.b.put(grsParasKey, new com.huawei.hms.framework.network.grs.g.k.b(future));
            try {
                return future.get();
            } catch (CancellationException e2) {
                e = e2;
                str3 = "RequestController";
                str2 = "when check result, find CancellationException, check others";
                Logger.w(str3, str2, e);
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str3 = "RequestController";
                str2 = "when check result, find ExecutionException, check others";
                Logger.w(str3, str2, e);
                return null;
            } catch (InterruptedException e4) {
                e = e4;
                str3 = "RequestController";
                str2 = "when check result, find InterruptedException, check others";
                Logger.w(str3, str2, e);
                return null;
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.e.a aVar) {
        this.d = aVar;
    }

    public void a(c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.a.execute(new b(cVar, str, cVar2, bVar));
    }

    public void a(String str) {
        synchronized (this.c) {
            this.b.remove(str);
        }
    }
}
