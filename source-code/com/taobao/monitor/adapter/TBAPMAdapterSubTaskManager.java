package com.taobao.monitor.adapter;

import android.os.Looper;
import android.os.SystemClock;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tb.dm2;
import tb.ts1;
import tb.us1;
import tb.ws1;

/* compiled from: Taobao */
public class TBAPMAdapterSubTaskManager {
    private static Map<String, a> a = new HashMap();
    private static Map<String, IProcedure> b = new HashMap();
    private static boolean c = true;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private long a;
        private long b;
        private long c;
        private long d;
        private boolean e;
        private String f;

        private a() {
        }
    }

    private static void e(Runnable runnable) {
        us1.d().b().post(runnable);
    }

    public static void f(final String str) {
        final long a2 = dm2.a();
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e(new Runnable() {
            /* class com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager.AnonymousClass2 */

            public void run() {
                if (!TBAPMAdapterSubTaskManager.c) {
                    IProcedure iProcedure = (IProcedure) TBAPMAdapterSubTaskManager.b.get(str);
                    a aVar = (a) TBAPMAdapterSubTaskManager.a.get(str);
                    if (iProcedure == null && aVar != null) {
                        d f = new d.b().g(false).k(false).i(false).h(ws1.b.getLauncherProcedure()).f();
                        ts1 ts1 = ts1.b;
                        iProcedure = ts1.createProcedure("/" + str, f);
                        iProcedure.begin();
                        iProcedure.stage("taskStart", aVar.a);
                        iProcedure.stage("cpuStartTime", aVar.c);
                        iProcedure.addProperty("isMainThread", Boolean.valueOf(aVar.e));
                        iProcedure.addProperty("threadName", aVar.f);
                        TBAPMAdapterSubTaskManager.a.remove(str);
                    }
                    if (iProcedure != null) {
                        iProcedure.stage("taskEnd", a2);
                        iProcedure.stage("cpuEndTime", currentThreadTimeMillis);
                        iProcedure.end();
                        TBAPMAdapterSubTaskManager.b.remove(str);
                    }
                } else if (TBAPMAdapterSubTaskManager.a.keySet().contains(str)) {
                    a aVar2 = (a) TBAPMAdapterSubTaskManager.a.get(str);
                    aVar2.b = a2;
                    aVar2.d = currentThreadTimeMillis;
                }
            }
        });
    }

    public static void g(final String str) {
        final long a2 = dm2.a();
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        final String name = Thread.currentThread().getName();
        final boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
        e(new Runnable() {
            /* class com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager.AnonymousClass1 */

            public void run() {
                if (!TBAPMAdapterSubTaskManager.c) {
                    d f = new d.b().g(false).k(false).i(false).h(ws1.b.getLauncherProcedure()).f();
                    ts1 ts1 = ts1.b;
                    IProcedure createProcedure = ts1.createProcedure("/" + str, f);
                    TBAPMAdapterSubTaskManager.b.put(str, createProcedure);
                    createProcedure.begin();
                    createProcedure.stage("taskStart", a2);
                    createProcedure.stage("cpuStartTime", currentThreadTimeMillis);
                    createProcedure.addProperty("threadName", name);
                    createProcedure.addProperty("isMainThread", Boolean.valueOf(z));
                } else if (!TBAPMAdapterSubTaskManager.a.keySet().contains(str)) {
                    a aVar = new a();
                    aVar.a = a2;
                    aVar.c = currentThreadTimeMillis;
                    aVar.e = z;
                    aVar.f = name;
                    TBAPMAdapterSubTaskManager.a.put(str, aVar);
                }
            }
        });
    }

    protected static void h() {
        e(new Runnable() {
            /* class com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager.AnonymousClass3 */

            public void run() {
                Iterator it = TBAPMAdapterSubTaskManager.a.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str = (String) entry.getKey();
                    a aVar = (a) entry.getValue();
                    if (aVar.b != 0) {
                        d f = new d.b().g(false).k(false).i(false).h(ws1.b.getLauncherProcedure()).f();
                        ts1 ts1 = ts1.b;
                        IProcedure createProcedure = ts1.createProcedure("/" + str, f);
                        createProcedure.begin();
                        createProcedure.stage("taskStart", aVar.a);
                        createProcedure.stage("cpuStartTime", aVar.c);
                        createProcedure.addProperty("isMainThread", Boolean.valueOf(aVar.e));
                        createProcedure.addProperty("threadName", aVar.f);
                        createProcedure.stage("taskEnd", aVar.b);
                        createProcedure.stage("cpuEndTime", aVar.d);
                        createProcedure.end();
                        it.remove();
                    }
                }
                boolean unused = TBAPMAdapterSubTaskManager.c = false;
            }
        });
    }
}
