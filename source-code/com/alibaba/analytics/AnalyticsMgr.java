package com.alibaba.analytics;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.analytics.IAnalytics;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.kq2;
import tb.t6;
import tb.yi;
import tb.zf2;

/* compiled from: Taobao */
public class AnalyticsMgr {
    private static ServiceConnection A = new a();
    private static Application a;
    public static IAnalytics b;
    private static HandlerThread c;
    public static c d;
    private static final Object e = new Object();
    private static final Object f = new Object();
    public static volatile boolean g;
    public static RunMode h = RunMode.Service;
    private static boolean i = false;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static boolean m = false;
    public static final List<b> mRegisterList = Collections.synchronizedList(new ArrayList());
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    public static boolean r = false;
    private static boolean s = false;
    private static Map<String, String> t = null;
    private static Map<String, String> u = null;
    private static Map<String, String> v = new ConcurrentHashMap();
    private static boolean w = false;
    private static boolean x = false;
    private static String y = null;
    private static int z = 10;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum RunMode {
        Local,
        Service
    }

    /* compiled from: Taobao */
    public static class UTInitTimeoutTask implements Runnable {
        public void run() {
            try {
                if (AnalyticsMgr.w) {
                    Logger.m("AnalyticsMgr", "delay 30 sec to wait the Remote service connected,waiting...");
                    synchronized (AnalyticsMgr.e) {
                        try {
                            AnalyticsMgr.e.wait(30000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (AnalyticsMgr.b == null) {
                    Logger.m("AnalyticsMgr", "cannot get remote analytics object,new local object");
                    AnalyticsMgr.N();
                }
                AnalyticsMgr.n().run();
            } catch (Throwable th) {
                Logger.i("AnalyticsMgr", "7", th);
            }
        }
    }

    /* compiled from: Taobao */
    public static class UtDelayInitTask implements Runnable {
        public void run() {
            try {
                Logger.m("AnalyticsMgr", "延时启动任务");
                synchronized (AnalyticsMgr.f) {
                    int H = AnalyticsMgr.H();
                    if (H > 0) {
                        Logger.m("AnalyticsMgr", "delay " + H + " second to start service,waiting...");
                        try {
                            AnalyticsMgr.f.wait((long) (H * 1000));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                boolean unused = AnalyticsMgr.w = AnalyticsMgr.k();
                Logger.m("AnalyticsMgr", "isBindSuccess", Boolean.valueOf(AnalyticsMgr.w));
                AnalyticsMgr.d.postAtFrontOfQueue(new UTInitTimeoutTask());
            } catch (Throwable th) {
                Logger.i("AnalyticsMgr", "6", th);
            }
        }
    }

    /* compiled from: Taobao */
    static class a implements ServiceConnection {
        a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.f("AnalyticsMgr", "onServiceConnected mConnection", AnalyticsMgr.A);
            if (RunMode.Service == AnalyticsMgr.h) {
                IAnalytics asInterface = IAnalytics.Stub.asInterface(iBinder);
                AnalyticsMgr.b = asInterface;
                Logger.m("AnalyticsMgr", "onServiceConnected iAnalytics", asInterface);
            }
            synchronized (AnalyticsMgr.e) {
                AnalyticsMgr.e.notifyAll();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Logger.f("AnalyticsMgr", "[onServiceDisconnected]");
            synchronized (AnalyticsMgr.e) {
                AnalyticsMgr.e.notifyAll();
            }
            boolean unused = AnalyticsMgr.i = true;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public String a;
        public String b;
        public MeasureSet c;
        public DimensionSet d;
        public boolean e;
    }

    /* compiled from: Taobao */
    public static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                try {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = runnable;
                    sendMessage(obtain);
                } catch (Throwable unused) {
                }
            }
        }

        public void handleMessage(Message message) {
            try {
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    try {
                        ((Runnable) obj).run();
                    } catch (Throwable th) {
                        Logger.h("AnalyticsMgr", th, new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                Logger.h("AnalyticsMgr", th2, new Object[0]);
            }
            super.handleMessage(message);
        }
    }

    private static Runnable A() {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass4 */

            public void run() {
                try {
                    AnalyticsMgr.b.turnOffRealTimeDebug();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Runnable B() {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass9 */

            public void run() {
                try {
                    AnalyticsMgr.b.turnOnDebug();
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable C(final Map<String, String> map) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass3 */

            public void run() {
                try {
                    AnalyticsMgr.b.turnOnRealTimeDebug(map);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Runnable D(final Map<String, String> map) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass11 */

            public void run() {
                try {
                    AnalyticsMgr.b.updateSessionProperties(map);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable E(final String str, final String str2, final String str3, final String str4) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass10 */

            public void run() {
                try {
                    AnalyticsMgr.b.updateUserAccount(str, str2, str3, str4);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public static void F() {
        if (l()) {
            d.a(m());
        }
    }

    public static void G() {
        if (l()) {
            d.a(s());
        }
    }

    /* access modifiers changed from: private */
    public static int H() {
        String f2 = t6.f(a.getApplicationContext(), "UTANALYTICS_REMOTE_SERVICE_DELAY_SECOND");
        int i2 = z;
        if (i2 < 0 || i2 > 30) {
            i2 = 10;
        }
        if (TextUtils.isEmpty(f2)) {
            return i2;
        }
        try {
            int intValue = Integer.valueOf(f2).intValue();
            return (intValue < 0 || intValue > 30) ? i2 : intValue;
        } catch (Throwable unused) {
            return i2;
        }
    }

    public static String I(String str) {
        if (l() && str != null) {
            return v.get(str);
        }
        return null;
    }

    public static String J() {
        return p;
    }

    public static String K(String str) {
        IAnalytics iAnalytics = b;
        if (iAnalytics == null) {
            return null;
        }
        try {
            return iAnalytics.getValue(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void L(Exception exc) {
        Logger.u("AnalyticsMgr", exc, new Object[0]);
        if (exc instanceof DeadObjectException) {
            R();
        }
    }

    public static synchronized void M(Application application) {
        synchronized (AnalyticsMgr.class) {
            try {
                if (!g) {
                    Logger.m("AnalyticsMgr", "[init] start sdk_version", kq2.a().getFullSDKVersion());
                    a = application;
                    HandlerThread handlerThread = new HandlerThread("Analytics_Client");
                    c = handlerThread;
                    Looper looper = null;
                    try {
                        handlerThread.start();
                    } catch (Throwable th) {
                        Logger.i("AnalyticsMgr", "1", th);
                    }
                    for (int i2 = 0; i2 < 3; i2++) {
                        try {
                            looper = c.getLooper();
                            if (looper != null) {
                                break;
                            }
                            try {
                                Thread.sleep(10);
                            } catch (Throwable th2) {
                                Logger.i("AnalyticsMgr", "2", th2);
                            }
                        } catch (Throwable th3) {
                            Logger.i("AnalyticsMgr", "3", th3);
                        }
                    }
                    c cVar = new c(looper);
                    d = cVar;
                    try {
                        cVar.postAtFrontOfQueue(new UtDelayInitTask());
                    } catch (Throwable th4) {
                        Logger.i("AnalyticsMgr", "4", th4);
                    }
                    g = true;
                    Logger.f("AnalyticsMgr", "外面init完成");
                }
            } catch (Throwable th5) {
                Logger.v("AnalyticsMgr", "5", th5);
            }
            Logger.v("AnalyticsMgr", "isInit", Boolean.valueOf(g), "sdk_version", kq2.a().getFullSDKVersion());
        }
    }

    /* access modifiers changed from: private */
    public static void N() {
        h = RunMode.Local;
        b = new AnalyticsImp(a);
        Logger.v("AnalyticsMgr", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    public static void O() {
        if (l()) {
            d.a(o());
        }
    }

    public static void P() {
        if (l()) {
            d.a(p());
        }
    }

    public static void Q(String str) {
        if (l() && !zf2.f(str) && v.containsKey(str)) {
            v.remove(str);
            d.a(r(str));
        }
    }

    public static void R() {
        Map<String, String> map;
        Logger.f("AnalyticsMgr", "[restart]");
        try {
            if (i) {
                i = false;
                N();
                n().run();
                x(m, x, j, l).run();
                v(k).run();
                u(n).run();
                E(o, p, y, q).run();
                D(t).run();
                if (r) {
                    B().run();
                }
                boolean z2 = s;
                if (z2 && (map = u) != null) {
                    y(map).run();
                } else if (z2) {
                    A().run();
                }
                synchronized (mRegisterList) {
                    int i2 = 0;
                    while (true) {
                        List<b> list = mRegisterList;
                        if (i2 < list.size()) {
                            b bVar = list.get(i2);
                            if (bVar != null) {
                                try {
                                    q(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e).run();
                                } catch (Throwable th) {
                                    Logger.i("AnalyticsMgr", "[RegisterTask.run]", th);
                                }
                            }
                            i2++;
                        }
                    }
                }
                for (Map.Entry<String, String> entry : v.entrySet()) {
                    W(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th2) {
            Logger.i("AnalyticsMgr", "[restart]", th2);
        }
    }

    public static void S() {
        if (l()) {
            d.a(t());
        }
    }

    public static void T(String str) {
        Logger.m("AnalyticsMgr", "aAppVersion", str);
        if (l()) {
            d.a(u(str));
            n = str;
        }
    }

    public static void U(String str) {
        if (l()) {
            d.a(v(str));
            k = str;
        }
    }

    public static void V(int i2) {
        if (i2 >= 0 && i2 <= 30) {
            z = i2;
        }
    }

    public static void W(String str, String str2) {
        if (l()) {
            if (zf2.f(str) || str2 == null) {
                Logger.i("AnalyticsMgr", "setGlobalProperty", "key is null or key is empty or value is null,please check it!");
                return;
            }
            v.put(str, str2);
            d.a(w(str, str2));
        }
    }

    public static void X(boolean z2, boolean z3, String str, String str2) {
        if (l()) {
            d.a(x(z2, z3, str, str2));
            m = z2;
            j = str;
            l = str2;
            x = z3;
        }
    }

    public static void Y(Map<String, String> map) {
        if (l()) {
            d.a(y(map));
        }
    }

    public static void Z() {
        if (l()) {
            d.a(z(yi.c().f()));
        }
    }

    public static void a0() {
        if (l()) {
            d.a(A());
            s = false;
        }
    }

    public static void b0() {
        Logger.m("AnalyticsMgr", "turnOnDebug");
        if (l()) {
            d.a(B());
            r = true;
            Logger.s(true);
        }
    }

    public static void c0(Map<String, String> map) {
        if (l()) {
            d.a(C(map));
            u = map;
            s = true;
        }
    }

    public static void d0(Map<String, String> map) {
        if (l()) {
            d.a(D(map));
            t = map;
        }
    }

    @Deprecated
    public static void e0(String str, String str2, String str3) {
        f0(str, str2, str3, null);
    }

    public static void f0(String str, String str2, String str3, String str4) {
        Logger.m("AnalyticsMgr", "userNick", str, "userId", str2, "openId", str3, "userSite", str4);
        if (l()) {
            d.a(E(str, str2, str3, str4));
            g0(str, str2, str3, str4);
        }
    }

    private static void g0(String str, String str2, String str3, String str4) {
        o = str;
        if (TextUtils.isEmpty(str2)) {
            p = null;
            y = null;
        } else if (!TextUtils.isEmpty(str3) || !str2.equals(p)) {
            p = str2;
            y = str3;
        }
        q = str4;
    }

    /* access modifiers changed from: private */
    public static boolean k() {
        boolean z2;
        if (a == null) {
            return false;
        }
        if (h == RunMode.Service) {
            z2 = a.getApplicationContext().bindService(new Intent(a.getApplicationContext(), AnalyticsService.class), A, 1);
            if (!z2) {
                N();
            }
        } else {
            N();
            z2 = false;
        }
        Logger.m("AnalyticsMgr", "bindsuccess", Boolean.valueOf(z2));
        return z2;
    }

    public static boolean l() {
        if (!g) {
            Logger.f("AnalyticsMgr", "Please call init() before call other method");
        }
        return g;
    }

    private static Runnable m() {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass12 */

            public void run() {
                try {
                    AnalyticsMgr.b.dispatchLocalHits();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public static Runnable n() {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass2 */

            public void run() {
                Logger.m("AnalyticsMgr", "call Remote init start...");
                try {
                    AnalyticsMgr.b.initUT();
                } catch (Throwable th) {
                    Logger.i("AnalyticsMgr", "initut error", th);
                }
                try {
                    yi.c().m();
                } catch (Exception unused) {
                }
                Logger.m("AnalyticsMgr", "call Remote init end");
            }
        };
    }

    private static Runnable o() {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass16 */

            public void run() {
                try {
                    Logger.f("AnalyticsMgr", "onBackground");
                    AnalyticsMgr.b.onBackground();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Runnable p() {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass17 */

            public void run() {
                try {
                    Logger.f("AnalyticsMgr", "onForeground");
                    AnalyticsMgr.b.onForeground();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Runnable q(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet, final boolean z2) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass7 */

            public void run() {
                try {
                    Logger.f("register stat event", "module", str, " monitorPoint: ", str2);
                    AnalyticsMgr.b.register4(str, str2, measureSet, dimensionSet, z2);
                } catch (RemoteException e) {
                    AnalyticsMgr.L(e);
                }
            }
        };
    }

    private static Runnable r(final String str) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass19 */

            public void run() {
                try {
                    AnalyticsMgr.b.removeGlobalProperty(str);
                } catch (RemoteException e) {
                    AnalyticsMgr.L(e);
                }
            }
        };
    }

    static Runnable s() {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass13 */

            public void run() {
                try {
                    AnalyticsMgr.b.saveCacheDataToLocal();
                } catch (RemoteException e) {
                    Logger.u("AnalyticsMgr", e, new Object[0]);
                }
            }
        };
    }

    private static Runnable t() {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass15 */

            public void run() {
                try {
                    AnalyticsMgr.b.sessionTimeout();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Runnable u(final String str) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass8 */

            public void run() {
                try {
                    AnalyticsMgr.b.setAppVersion(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable v(final String str) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass6 */

            public void run() {
                try {
                    AnalyticsMgr.b.setChannel(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable w(final String str, final String str2) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass18 */

            public void run() {
                try {
                    AnalyticsMgr.b.setGlobalProperty(str, str2);
                } catch (RemoteException e) {
                    AnalyticsMgr.L(e);
                }
            }
        };
    }

    private static Runnable x(final boolean z2, final boolean z3, final String str, final String str2) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass5 */

            public void run() {
                try {
                    AnalyticsMgr.b.setRequestAuthInfo(z2, z3, str, str2);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable y(final Map<String, String> map) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass14 */

            public void run() {
                try {
                    AnalyticsMgr.b.setSessionProperties(map);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Runnable z(final long j2) {
        return new Runnable() {
            /* class com.alibaba.analytics.AnalyticsMgr.AnonymousClass20 */

            public void run() {
                try {
                    Logger.f("AnalyticsMgr", "startMainProcess");
                    AnalyticsMgr.b.startMainProcess(j2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
