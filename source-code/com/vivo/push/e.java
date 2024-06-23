package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.vivo.push.b.c;
import com.vivo.push.b.g;
import com.vivo.push.b.n;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.b;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import com.vivo.push.util.w;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class e {
    private static volatile e a;
    private long b = -1;
    private long c = -1;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private Context h;
    private boolean i = true;
    private b j;
    private String k;
    private String l;
    private SparseArray<a> m = new SparseArray<>();
    private int n = 0;
    private Boolean o;
    private Long p;
    private boolean q;
    private IPushClientFactory r = new d();
    private int s;

    private e() {
    }

    /* access modifiers changed from: private */
    public void m() {
        this.l = null;
        this.j.b("APP_ALIAS");
    }

    private boolean n() {
        if (this.o == null) {
            this.o = Boolean.valueOf(l() >= 1230 && z.d(this.h));
        }
        return this.o.booleanValue();
    }

    public final boolean d() {
        if (this.h == null) {
            p.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(n());
        this.o = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean e() {
        return this.q;
    }

    public final String f() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        b bVar = this.j;
        String b2 = bVar != null ? bVar.b("APP_TOKEN", (String) null) : "";
        c(b2);
        return b2;
    }

    public final boolean g() {
        return this.i;
    }

    public final Context h() {
        return this.h;
    }

    public final void i() {
        this.j.a();
    }

    public final String j() {
        return this.l;
    }

    public final int k() {
        return this.s;
    }

    public final long l() {
        Context context = this.h;
        if (context == null) {
            return -1;
        }
        if (this.p == null) {
            this.p = Long.valueOf(z.a(context));
        }
        return this.p.longValue();
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        m.a(new k(this, str));
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    /* access modifiers changed from: protected */
    public final void b() throws VivoPushException {
        Context context = this.h;
        if (context != null) {
            z.b(context);
        }
    }

    public final List<String> c() {
        String b2 = this.j.b("APP_TAGS", (String) null);
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(b2)) {
                return arrayList;
            }
            Iterator<String> keys = new JSONObject(b2).keys();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            return arrayList;
        } catch (JSONException unused) {
            this.j.b("APP_TAGS");
            arrayList.clear();
            p.d("PushClientManager", "getTags error");
        }
    }

    /* compiled from: Taobao */
    public static class a {
        private IPushActionListener a;
        private c b;
        private IPushActionListener c;
        private Runnable d;
        private Object[] e;

        public a(c cVar, IPushActionListener iPushActionListener) {
            this.b = cVar;
            this.a = iPushActionListener;
        }

        public final void a(int i, Object... objArr) {
            this.e = objArr;
            IPushActionListener iPushActionListener = this.c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i);
            }
            IPushActionListener iPushActionListener2 = this.a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i);
            }
        }

        public final Object[] b() {
            return this.e;
        }

        public final void a(Runnable runnable) {
            this.d = runnable;
        }

        public final void a() {
            Runnable runnable = this.d;
            if (runnable == null) {
                p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.c = iPushActionListener;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public synchronized a d(String str) {
        if (str != null) {
            int parseInt = Integer.parseInt(str);
            a aVar = this.m.get(parseInt);
            this.m.delete(parseInt);
            return aVar;
        }
        return null;
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() > 0) {
                String b2 = this.j.b("APP_TAGS", (String) null);
                if (TextUtils.isEmpty(b2)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(b2);
                }
                for (String str : list) {
                    jSONObject.remove(str);
                }
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    this.j.b("APP_TAGS");
                } else {
                    this.j.a("APP_TAGS", jSONObject2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.j.b("APP_TAGS");
        }
    }

    public final synchronized void a(Context context) {
        if (this.h == null) {
            this.h = ContextDelegate.getContext(context);
            this.q = t.c(context, context.getPackageName());
            w.b().a(this.h);
            a(new g());
            b bVar = new b();
            this.j = bVar;
            bVar.a(this.h, "com.vivo.push_preferences.appconfig_v1");
            this.k = f();
            this.l = this.j.b("APP_ALIAS", (String) null);
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.l)) {
            m();
        }
    }

    private void c(String str) {
        m.c(new f(this, str));
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() > 0) {
                String b2 = this.j.b("APP_TAGS", (String) null);
                if (TextUtils.isEmpty(b2)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(b2);
                }
                for (String str : list) {
                    jSONObject.put(str, System.currentTimeMillis());
                }
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    this.j.b("APP_TAGS");
                } else {
                    this.j.a("APP_TAGS", jSONObject2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.j.b("APP_TAGS");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if ("".equals(this.k)) {
            iPushActionListener.onStateChanged(0);
        } else if (a(this.c)) {
            this.c = SystemClock.elapsedRealtime();
            String packageName = this.h.getPackageName();
            a aVar = null;
            if (this.h != null) {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
                bVar.d();
                bVar.e();
                bVar.g();
                bVar.a(100);
                if (this.q) {
                    if (n()) {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new j(this, bVar, a2));
                    } else if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                    }
                } else if (bVar.a(this.h) == 2) {
                    aVar = a(bVar, iPushActionListener);
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            if (aVar != null) {
                aVar.a(new i(this));
                aVar.a();
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(1002);
        }
    }

    public final void a(String str) {
        this.k = str;
        this.j.a("APP_TOKEN", str);
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        this.i = z;
    }

    /* access modifiers changed from: package-private */
    public final void a(IPushActionListener iPushActionListener) {
        if (this.h != null) {
            String f2 = f();
            this.k = f2;
            if (!TextUtils.isEmpty(f2)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (a(this.b)) {
                this.b = SystemClock.elapsedRealtime();
                String packageName = this.h.getPackageName();
                a aVar = null;
                if (this.h != null) {
                    com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
                    bVar.g();
                    bVar.d();
                    bVar.e();
                    bVar.a(100);
                    if (this.q) {
                        if (n()) {
                            aVar = a(bVar, iPushActionListener);
                        } else if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    } else if (bVar.a(this.h) == 2) {
                        aVar = a(bVar, iPushActionListener);
                    } else {
                        a(bVar);
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(0);
                        }
                    }
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
                if (aVar != null) {
                    aVar.a(new g(this, aVar));
                    aVar.a();
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (!TextUtils.isEmpty(this.l)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.h.getPackageName(), arrayList);
            aVar.a(100);
            if (!this.q) {
                a(aVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (a(this.e)) {
                this.e = SystemClock.elapsedRealtime();
                String a2 = a(new a(aVar, iPushActionListener));
                aVar.b(a2);
                if (TextUtils.isEmpty(this.k)) {
                    a(a2, 30001);
                } else if (TextUtils.isEmpty(str)) {
                    a(a2, com.taobao.android.dinamicx.e.DXError_EngineInitException);
                } else if (((long) str.length()) > 70) {
                    a(a2, com.taobao.android.dinamicx.e.DXError_EngineSizeException);
                } else {
                    a(aVar);
                    e(a2);
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String a2 = a(aVar);
        bVar.b(a2);
        aVar.a(new h(this, bVar, a2));
        return aVar;
    }

    public final void a(String str, int i2, Object... objArr) {
        a d2 = d(str);
        if (d2 != null) {
            d2.a(i2, objArr);
        } else {
            p.d("PushClientManager", "notifyApp token is null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (TextUtils.isEmpty(this.l) || !this.l.equals(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.h.getPackageName(), arrayList);
            aVar.a(100);
            if (!this.q) {
                a(aVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (a(this.d)) {
                this.d = SystemClock.elapsedRealtime();
                String a2 = a(new a(aVar, iPushActionListener));
                aVar.b(a2);
                if (TextUtils.isEmpty(this.k)) {
                    a(a2, 30001);
                } else if (TextUtils.isEmpty(str)) {
                    a(a2, com.taobao.android.dinamicx.e.DXError_EngineInitException);
                } else if (((long) str.length()) > 70) {
                    a(a2, com.taobao.android.dinamicx.e.DXError_EngineSizeException);
                } else {
                    a(aVar);
                    e(a2);
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void b(String str) {
        this.l = str;
        this.j.a("APP_ALIAS", str);
    }

    /* access modifiers changed from: package-private */
    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.h;
        if (context != null) {
            com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, context.getPackageName(), arrayList);
            zVar.a(500);
            if (!this.q) {
                a(zVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (a(this.g)) {
                this.g = SystemClock.elapsedRealtime();
                String a2 = a(new a(zVar, iPushActionListener));
                zVar.b(a2);
                if (TextUtils.isEmpty(this.k)) {
                    a(a2, 20001);
                } else if (arrayList.size() < 0) {
                    a(a2, BaseBioNavigatorActivity.n);
                } else if (arrayList.size() > 500) {
                    a(a2, BaseBioNavigatorActivity.p);
                } else {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((long) it.next().length()) > 70) {
                            a(a2, BaseBioNavigatorActivity.o);
                            return;
                        }
                    }
                    a(zVar);
                    e(a2);
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
    }

    private static boolean a(long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j2 == -1 || elapsedRealtime <= j2 || elapsedRealtime >= j2 + 2000;
    }

    public final void a(String str, int i2) {
        a d2 = d(str);
        if (d2 != null) {
            d2.a(i2, new Object[0]);
        } else {
            p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i2;
        this.m.put(this.n, aVar);
        i2 = this.n;
        this.n = i2 + 1;
        return Integer.toString(i2);
    }

    /* access modifiers changed from: package-private */
    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.h;
        if (context != null) {
            com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, context.getPackageName(), arrayList);
            zVar.a(500);
            if (!this.q) {
                a(zVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (a(this.f)) {
                this.f = SystemClock.elapsedRealtime();
                String a2 = a(new a(zVar, iPushActionListener));
                zVar.b(a2);
                if (TextUtils.isEmpty(this.k)) {
                    a(a2, 20001);
                } else if (arrayList.size() < 0) {
                    a(a2, BaseBioNavigatorActivity.n);
                } else {
                    if (arrayList.size() + c().size() > 500) {
                        a(a2, BaseBioNavigatorActivity.p);
                        return;
                    }
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((long) it.next().length()) > 70) {
                            a(a2, BaseBioNavigatorActivity.o);
                            return;
                        }
                    }
                    a(zVar);
                    e(a2);
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        o createReceiverCommand = this.r.createReceiverCommand(intent);
        Context context = a().h;
        if (createReceiverCommand == null) {
            p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.d.z createReceiveTask = this.r.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context != null) {
                p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                return;
            }
            return;
        }
        if (context != null && !(createReceiverCommand instanceof n)) {
            p.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.a(pushMessageCallback);
        m.a((l) createReceiveTask);
    }

    public final void a(o oVar) {
        Context context = a().h;
        if (oVar == null) {
            p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        l createTask = this.r.createTask(oVar);
        if (createTask == null) {
            p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(oVar)));
            if (context != null) {
                p.c(context, "[执行指令失败]指令" + oVar + "任务空！");
                return;
            }
            return;
        }
        p.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(oVar)));
        m.a(createTask);
    }
}
