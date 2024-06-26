package com.uc.sandboxExport;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.sandboxExport.h;
import com.uc.sandboxExport.helper.f;
import java.util.concurrent.Executor;
import tb.jl1;

@Api
/* compiled from: Taobao */
public class PreStartup implements h {
    private static c a;
    private static b[] b;
    private static a[] c;
    private static boolean d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements ServiceConnection {
        private static Handler k;
        Context a;
        d b;
        Handler c;
        boolean d;
        int e = 0;
        ComponentName f;
        IBinder g;
        ServiceConnection h;
        final String i;
        final Executor j;

        a(Context context, d dVar) {
            this.i = "sandbox.PreStartup." + h.a.a(dVar.a);
            this.a = context;
            this.b = dVar;
            this.c = PreStartup.a(dVar.a);
            this.j = new a(this);
        }

        private static String a(int i2) {
            if (i2 == 0) {
                return "IDLE";
            }
            if (i2 == 1) {
                return "BIND";
            }
            if (i2 == 2) {
                return "BINDING";
            }
            if (i2 == 3) {
                return "BIND_FAILED";
            }
            if (i2 == 4) {
                return "CONNECTED";
            }
            if (i2 == 5) {
                return "DIS_CONNECTED";
            }
            return "UnknownState_" + i2;
        }

        /* access modifiers changed from: private */
        public void c() {
            if (this.d) {
                com.uc.sandboxExport.helper.c.a(this.i, "unbindService %s", this.f);
                this.a.unbindService(this);
                this.d = false;
            }
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.uc.sandboxExport.helper.c.a(4, this.i, "onServiceConnected", null);
            this.c.post(new e(this, iBinder));
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            com.uc.sandboxExport.helper.c.a(4, this.i, "onServiceDisconnected", null);
            this.c.post(new f(this));
        }

        public final String toString() {
            return jl1.ARRAY_START_STR + this.b + AVFSCacheConstants.COMMA_SEP + a(this.e) + AVFSCacheConstants.COMMA_SEP + a() + jl1.ARRAY_END_STR;
        }

        private void b(int i2) {
            com.uc.sandboxExport.helper.c.a(this.i, "state changed: %s -> %s", a(this.e), a(i2));
            this.e = i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            int i2 = this.e;
            return (i2 == 3 || i2 == 5) ? false : true;
        }

        static /* synthetic */ void a(a aVar) {
            if (aVar.e != 0) {
                com.uc.sandboxExport.helper.c.a(5, aVar.i, "call ChildServiceConnection.start() again!", null);
                return;
            }
            aVar.f = new ComponentName(aVar.a.getPackageName(), aVar.b.b);
            Intent intent = new Intent();
            intent.setComponent(aVar.f);
            aVar.b(1);
            com.uc.sandboxExport.helper.c.a(aVar.i, "bindService %s...", aVar.f);
            Context context = aVar.a;
            Handler handler = aVar.c;
            if (Build.VERSION.SDK_INT >= 24) {
                if (k == null) {
                    HandlerThread handlerThread = new HandlerThread("U4SvcBindHandler");
                    handlerThread.start();
                    k = new Handler(handlerThread.getLooper());
                }
                handler = k;
            }
            boolean a2 = com.uc.sandboxExport.helper.a.a(context, intent, aVar, handler);
            aVar.d = a2;
            if (a2) {
                aVar.b(2);
            } else {
                aVar.b(3);
            }
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (Looper.myLooper() != this.c.getLooper()) {
                this.c.post(new c(this));
            } else {
                c();
            }
        }

        static /* synthetic */ void c(a aVar) {
            com.uc.sandboxExport.helper.c.a(4, aVar.i, "onServiceDisconnectedOnLauncherThread", null);
            aVar.b(5);
            ServiceConnection serviceConnection = aVar.h;
            if (serviceConnection != null) {
                serviceConnection.onServiceDisconnected(aVar.f);
            }
            aVar.b();
        }

        static /* synthetic */ void a(a aVar, IBinder iBinder) {
            com.uc.sandboxExport.helper.c.a(4, aVar.i, "onServiceConnectedOnLauncherThread", null);
            aVar.g = iBinder;
            aVar.b(4);
            ServiceConnection serviceConnection = aVar.h;
            if (serviceConnection != null) {
                serviceConnection.onServiceConnected(aVar.f, aVar.g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b {
        final Object a;
        final HandlerThread b;
        final Handler c;

        b(String str) {
            Object obj = new Object();
            this.a = obj;
            g gVar = new g(this, str);
            this.b = gVar;
            gVar.start();
            if (gVar.getLooper() == null) {
                try {
                    synchronized (obj) {
                        if (gVar.getLooper() == null) {
                            obj.wait(10000);
                        }
                    }
                } catch (Throwable th) {
                    com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "mThread.getLooper() failed", th);
                }
            }
            this.c = new Handler(this.b.getLooper());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c {
        boolean a = f.a("ESUDLT");

        c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
            com.uc.sandboxExport.helper.c.b("sandbox.PreStartup", "No. %d svc cls name is empty", java.lang.Integer.valueOf(r7));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c8, code lost:
            com.uc.sandboxExport.helper.c.b("sandbox.PreStartup", "No. %d proc id(%d) is invalid", java.lang.Integer.valueOf(r7), java.lang.Integer.valueOf(r9));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00dc, code lost:
            com.uc.sandboxExport.helper.c.b("sandbox.PreStartup", "No. %d proc id is empty", java.lang.Integer.valueOf(r7));
         */
        static d[] a() {
            try {
                if (!f.a("enable")) {
                    com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "PreStartup is disable");
                    return null;
                }
                String a2 = f.a("proc_ids", "");
                if (!TextUtils.isEmpty(a2)) {
                    com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "ProcIDs: %s", a2);
                    String[] split = a2.split(",");
                    if (split.length != 0) {
                        String a3 = f.a("svc_names", "");
                        if (!TextUtils.isEmpty(a3)) {
                            com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "SvcClsNames: %s", a3);
                            String[] split2 = a3.split(",");
                            if (split2.length != 0 && split.length == split2.length) {
                                d[] dVarArr = new d[3];
                                int i = 0;
                                while (true) {
                                    if (i >= split.length) {
                                        break;
                                    }
                                    String str = split[i];
                                    if (str != null) {
                                        str = str.trim();
                                    }
                                    if (str == null) {
                                        break;
                                    } else if (str.length() == 0) {
                                        break;
                                    } else {
                                        int intValue = Integer.valueOf(str).intValue();
                                        if (intValue < 0) {
                                            break;
                                        } else if (intValue >= 3) {
                                            break;
                                        } else if (dVarArr[intValue] != null) {
                                            com.uc.sandboxExport.helper.c.b("sandbox.PreStartup", "No. %d proc id(%d) is duplicate", Integer.valueOf(i), Integer.valueOf(intValue));
                                            break;
                                        } else {
                                            String str2 = split2[i];
                                            if (str2 != null) {
                                                str2 = str2.trim();
                                            }
                                            if (str2 == null) {
                                                break;
                                            } else if (str2.length() == 0) {
                                                break;
                                            } else {
                                                d dVar = new d(intValue, str2);
                                                dVarArr[intValue] = dVar;
                                                com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "Found service setting: %s", dVar.toString());
                                                i++;
                                            }
                                        }
                                    }
                                }
                                if (i == split.length) {
                                    return dVarArr;
                                }
                            }
                        }
                    }
                }
                com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "PreStartup is disable or can't found service setting");
                return null;
            } catch (Throwable th) {
                com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "Parse service config from SharedPreferences exception", th);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class d {
        int a;
        String b;

        d(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public final String toString() {
            return jl1.ARRAY_START_STR + h.a.a(this.a) + AVFSCacheConstants.COMMA_SEP + this.b + jl1.ARRAY_END_STR;
        }
    }

    static /* synthetic */ Handler a(int i) {
        b b2 = b(i);
        if (b2 == null) {
            return null;
        }
        return b2.c;
    }

    private static b b(int i) {
        b[] bVarArr = b;
        if (bVarArr == null) {
            return null;
        }
        boolean z = a.a;
        if (!z) {
            i = 0;
        }
        if (bVarArr[i] == null) {
            bVarArr[i] = new b(z ? i == 0 ? "U4_RNProcLauncherThread" : i == 1 ? "U4_RIProcLauncherThread" : "U4_GProcLauncherThread" : "U4_ProLauncherThread");
        }
        return b[i];
    }

    public static int bind(int i, ServiceConnection serviceConnection) {
        a aVar;
        int i2;
        synchronized (PreStartup.class) {
            a[] aVarArr = c;
            if (aVarArr == null || i < 0 || i >= aVarArr.length || (aVar = aVarArr[i]) == null || !aVar.a()) {
                return -1;
            }
            if (Looper.myLooper() == aVar.c.getLooper()) {
                String str = aVar.i;
                com.uc.sandboxExport.helper.c.a(4, str, "bindService " + aVar.f, null);
                aVar.h = serviceConnection;
                int i3 = aVar.e;
                if (i3 == 3) {
                    i2 = 0;
                } else {
                    if (i3 == 4) {
                        aVar.c.post(new d(aVar));
                    }
                    i2 = 1;
                }
                return i2;
            }
            throw new RuntimeException("bindService must be called in the launcher thread");
        }
    }

    public static boolean connectionValid(int i) {
        synchronized (PreStartup.class) {
            d = true;
            a[] aVarArr = c;
            if (aVarArr != null && i >= 0 && i < aVarArr.length) {
                a aVar = aVarArr[i];
                if (aVar == null) {
                    Object[] objArr = {Integer.valueOf(i)};
                    String a2 = com.uc.sandboxExport.helper.c.a("Can't find connection for proc id %d", objArr);
                    Throwable a3 = com.uc.sandboxExport.helper.c.a(objArr);
                    if (a3 != null) {
                        com.uc.sandboxExport.helper.c.a(5, "sandbox.PreStartup", a2, a3);
                    } else {
                        com.uc.sandboxExport.helper.c.a(5, "sandbox.PreStartup", a2, null);
                    }
                } else {
                    com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "check connection: %s", aVar.toString());
                    return aVar.a();
                }
            }
            return false;
        }
    }

    public static HandlerThread getLauncherHandlerThread(int i) {
        HandlerThread handlerThread;
        synchronized (PreStartup.class) {
            d = true;
            b b2 = b(i);
            if (b2 == null) {
                handlerThread = null;
            } else {
                handlerThread = b2.b;
            }
        }
        return handlerThread;
    }

    public static void setContext(Context context) {
        f.a(context);
    }

    public static void setEnable(boolean z) {
        if (f.a() != null) {
            f.a("enable", z);
        }
    }

    public static void startup() {
        startup(f.a());
    }

    public static void unbind(int i) {
        a aVar;
        synchronized (PreStartup.class) {
            a[] aVarArr = c;
            if (aVarArr != null && i >= 0 && i < aVarArr.length && (aVar = aVarArr[i]) != null) {
                aVar.b();
                c[i] = null;
            }
        }
    }

    public static void updateSetting(int i, int[] iArr, String[] strArr, boolean z) {
        if (f.a() != null) {
            setEnable(i > 0);
            synchronized (PreStartup.class) {
                f.a("ESUDLT", z);
                if (i <= 0) {
                    f.b("proc_ids", "");
                    f.b("svc_names", "");
                    com.uc.sandboxExport.helper.c.a(4, "sandbox.PreStartup", "updateSetting: disable", null);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        sb.append(iArr[i2]);
                        sb.append(',');
                    }
                    sb.setLength(sb.length() - 1);
                    String sb2 = sb.toString();
                    f.b("proc_ids", sb2);
                    sb.setLength(0);
                    for (int i3 = 0; i3 < i; i3++) {
                        sb.append(strArr[i3]);
                        sb.append(',');
                    }
                    sb.setLength(sb.length() - 1);
                    String sb3 = sb.toString();
                    f.b("svc_names", sb3);
                    com.uc.sandboxExport.helper.c.a("sandbox.PreStartup", "updateSetting: [%s][%s]", sb2, sb3);
                }
            }
        }
    }

    public static void updateSettingAndStopUnwantedService(int i, int[] iArr, String[] strArr, boolean z) {
        boolean z2;
        if (f.a() != null) {
            updateSetting(i, iArr, strArr, z);
            if (f.a() != null) {
                synchronized (PreStartup.class) {
                    int i2 = 0;
                    if (i <= 0) {
                        if (c != null) {
                            while (true) {
                                a[] aVarArr = c;
                                if (i2 >= aVarArr.length) {
                                    break;
                                }
                                a aVar = aVarArr[i2];
                                if (aVar != null) {
                                    aVar.b();
                                    c[i2] = null;
                                }
                                i2++;
                            }
                            c = null;
                        }
                    } else if (c != null) {
                        int i3 = 0;
                        while (true) {
                            a[] aVarArr2 = c;
                            if (i3 >= aVarArr2.length) {
                                break;
                            }
                            a aVar2 = aVarArr2[i3];
                            if (aVar2 != null) {
                                int length = iArr.length;
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length) {
                                        z2 = true;
                                        break;
                                    } else if (iArr[i4] == aVar2.b.a) {
                                        z2 = false;
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                                if (z2) {
                                    com.uc.sandboxExport.helper.c.a(aVar2.i, "no need anymore - %s", aVar2.b);
                                    aVar2.b();
                                    c[i3] = null;
                                }
                            }
                            i3++;
                        }
                    }
                }
            }
        }
    }

    public static void startup(Context context) {
        String b2;
        if (!(context == null || (b2 = f.b(context)) == null || b2.length() == 0 || b2.contains(":"))) {
            synchronized (PreStartup.class) {
                Context context2 = null;
                if (d) {
                    com.uc.sandboxExport.helper.c.a(5, "sandbox.PreStartup", "U4 core is running, ignore startup", null);
                } else if (a == null) {
                    f.a(context);
                    try {
                        context2 = context.getApplicationContext();
                    } catch (Throwable unused) {
                    }
                    if (context2 != null) {
                        context = context2;
                    }
                    a = new c();
                    d[] a2 = c.a();
                    if (a2 != null) {
                        b = new b[3];
                        c = new a[3];
                        for (d dVar : a2) {
                            if (dVar != null) {
                                a aVar = new a(context, dVar);
                                c[dVar.a] = aVar;
                                aVar.c.post(new b(aVar));
                            }
                        }
                    }
                }
            }
        }
    }
}
