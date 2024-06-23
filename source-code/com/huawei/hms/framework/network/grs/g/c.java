package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.f.b;
import com.huawei.hms.framework.network.grs.g.k.d;
import com.huawei.hms.framework.network.grs.h.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* compiled from: Taobao */
public class c {
    private static final String n = "c";
    private final GrsBaseInfo a;
    private final Context b;
    private final com.huawei.hms.framework.network.grs.e.a c;
    private d d;
    private final Map<String, Future<d>> e = new ConcurrentHashMap(16);
    private final List<d> f = new CopyOnWriteArrayList();
    private final JSONArray g = new JSONArray();
    private final List<String> h = new CopyOnWriteArrayList();
    private final List<String> i = new CopyOnWriteArrayList();
    private final com.huawei.hms.framework.network.grs.g.k.c j;
    private d k;
    private String l = "";
    private long m = 1;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Callable<d> {
        final /* synthetic */ ExecutorService a;
        final /* synthetic */ String b;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;

        a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
            this.a = executorService;
            this.b = str;
            this.c = cVar;
        }

        @Override // java.util.concurrent.Callable
        public d call() {
            return c.this.b(this.a, this.b, this.c);
        }
    }

    public c(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.j = cVar;
        this.a = cVar.b();
        this.b = cVar.a();
        this.c = aVar;
        c();
        d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099 A[LOOP:0: B:1:0x0006->B:37:0x0099, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0091 A[SYNTHETIC] */
    private d a(ExecutorService executorService, List<String> list, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        ExecutionException e2;
        InterruptedException e3;
        d dVar = null;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            String str2 = list.get(i2);
            boolean z = true;
            if (!TextUtils.isEmpty(str2)) {
                Future<d> submit = executorService.submit(new a(str2, i2, this, this.b, str, this.a, cVar).g());
                this.e.put(str2, submit);
                try {
                    d dVar2 = submit.get(this.m, TimeUnit.SECONDS);
                    if (dVar2 != null) {
                        try {
                            if (dVar2.o() || dVar2.m()) {
                                Logger.i(n, "grs request return body is not null and is OK.");
                                dVar = dVar2;
                                if (!z) {
                                    Logger.v(n, "needBreak is true so need break current circulation");
                                    break;
                                }
                                i2++;
                            }
                        } catch (CancellationException unused) {
                            dVar = dVar2;
                            Logger.i(n, "{requestServer} the computation was cancelled");
                            if (!z) {
                            }
                        } catch (ExecutionException e4) {
                            e2 = e4;
                            dVar = dVar2;
                            Logger.w(n, "the computation threw an ExecutionException", e2);
                            z = false;
                            if (!z) {
                            }
                        } catch (InterruptedException e5) {
                            e3 = e5;
                            dVar = dVar2;
                            Logger.w(n, "the current thread was interrupted while waiting", e3);
                            if (!z) {
                            }
                        } catch (TimeoutException unused2) {
                            dVar = dVar2;
                            Logger.w(n, "the wait timed out");
                            z = false;
                            if (!z) {
                            }
                        }
                    }
                    dVar = dVar2;
                } catch (CancellationException unused3) {
                    Logger.i(n, "{requestServer} the computation was cancelled");
                    if (!z) {
                    }
                } catch (ExecutionException e6) {
                    e2 = e6;
                    Logger.w(n, "the computation threw an ExecutionException", e2);
                    z = false;
                    if (!z) {
                    }
                } catch (InterruptedException e7) {
                    e3 = e7;
                    Logger.w(n, "the current thread was interrupted while waiting", e3);
                    if (!z) {
                    }
                } catch (TimeoutException unused4) {
                    Logger.w(n, "the wait timed out");
                    z = false;
                    if (!z) {
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        return b(dVar);
    }

    private void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, e(), this.b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.i.add(sb.toString());
    }

    private d b(d dVar) {
        String str;
        String str2;
        Throwable e2;
        for (Map.Entry<String, Future<d>> entry : this.e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000, TimeUnit.MILLISECONDS);
            } catch (CancellationException unused) {
                Logger.i(n, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e3) {
                e2 = e3;
                str2 = n;
                str = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str2, str, e2);
            } catch (InterruptedException e4) {
                e2 = e4;
                str2 = n;
                str = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str2, str, e2);
            } catch (TimeoutException unused2) {
                Logger.w(n, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private d b(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d a2 = a(executorService, this.i, str, cVar);
        int b2 = a2 == null ? 0 : a2.b();
        String str2 = n;
        Logger.v(str2, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(b2));
        if (b2 == 404 || b2 == 401) {
            if (!TextUtils.isEmpty(e()) || !TextUtils.isEmpty(this.a.getAppName())) {
                this.e.clear();
                Logger.i(str2, "this env has not deploy new interface,so use old interface.");
                a2 = a(executorService, this.h, str, cVar);
            } else {
                Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
        }
        e.a(new ArrayList(this.f), SystemClock.elapsedRealtime() - elapsedRealtime, this.g, this.b);
        this.f.clear();
        return a2;
    }

    private void b(String str, String str2) {
        if (!TextUtils.isEmpty(this.a.getAppName()) || !TextUtils.isEmpty(e())) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            Locale locale = Locale.ROOT;
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(e()) ? this.a.getAppName() : e();
            sb.append(String.format(locale, str, objArr));
            String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, "1.0", this.b);
            if (!TextUtils.isEmpty(grsReqParamJoint)) {
                sb.append("?");
                sb.append(grsReqParamJoint);
            }
            this.h.add(sb.toString());
        }
    }

    private void c() {
        d a2 = com.huawei.hms.framework.network.grs.g.j.a.a(this.b);
        if (a2 == null) {
            Logger.w(n, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a2);
        List<String> a3 = a2.a();
        if (a3 == null || a3.size() <= 0) {
            Logger.v(n, "maybe grs_base_url config with [],please check.");
        } else if (a3.size() <= 10) {
            String c2 = a2.c();
            String b2 = a2.b();
            if (a3.size() > 0) {
                for (String str : a3) {
                    if (!str.startsWith("https://")) {
                        Logger.w(n, "grs server just support https scheme url,please check.");
                    } else {
                        b(c2, str);
                        a(b2, str);
                    }
                }
            }
            Logger.v(n, "request to GRS server url is{%s} and {%s}", this.h, this.i);
        } else {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
    }

    private void d() {
        String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
        com.huawei.hms.framework.network.grs.e.c a2 = this.c.a();
        this.l = a2.a(grsParasKey + "ETag", "");
    }

    private String e() {
        b a2 = b.a(this.b.getPackageName(), this.a);
        com.huawei.hms.framework.network.grs.local.model.a a3 = a2 != null ? a2.a() : null;
        if (a3 == null) {
            return "";
        }
        String b2 = a3.b();
        Logger.v(n, "get appName from local assets is{%s}", b2);
        return b2;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        String str2;
        String str3;
        Throwable e2;
        if (this.h.isEmpty() && this.i.isEmpty()) {
            return null;
        }
        try {
            d b2 = b();
            return (d) executorService.submit(new a(executorService, str, cVar)).get((long) (b2 != null ? b2.d() : 10), TimeUnit.SECONDS);
        } catch (CancellationException unused) {
            Logger.i(n, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e3) {
            e2 = e3;
            str3 = n;
            str2 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.w(str3, str2, e2);
            return null;
        } catch (InterruptedException e4) {
            e2 = e4;
            str3 = n;
            str2 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.w(str3, str2, e2);
            return null;
        } catch (TimeoutException unused2) {
            Logger.w(n, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e5) {
            e2 = e5;
            str3 = n;
            str2 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.w(str3, str2, e2);
            return null;
        }
    }

    public String a() {
        return this.l;
    }

    public synchronized void a(d dVar) {
        this.f.add(dVar);
        d dVar2 = this.d;
        if (dVar2 != null && (dVar2.o() || this.d.m())) {
            Logger.v(n, "grsResponseResult is ok");
        } else if (dVar.n()) {
            Logger.i(n, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.a.getGrsParasKey(true, true, this.b), new d.a(dVar.k(), SystemClock.elapsedRealtime()));
        } else {
            if (dVar.m()) {
                Logger.i(n, "GRS server open 304 Not Modified.");
            }
            if (dVar.o() || dVar.m()) {
                this.d = dVar;
                this.c.a(this.a, dVar, this.b, this.j);
                for (Map.Entry<String, Future<d>> entry : this.e.entrySet()) {
                    if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                        Logger.i(n, "future cancel");
                        entry.getValue().cancel(true);
                    }
                }
                return;
            }
            Logger.v(n, "grsResponseResult has exception so need return");
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.k.d dVar) {
        this.k = dVar;
    }

    public com.huawei.hms.framework.network.grs.g.k.d b() {
        return this.k;
    }
}
