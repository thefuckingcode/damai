package com.alipay.sdk.m.u;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.n;
import com.vivo.push.PushClientConstants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* compiled from: Taobao */
public class h {
    public static final String j = "failed";
    public static final String k = "scheme_failed";
    public Activity a;
    public volatile IAlixPay b;
    public final Object c = IAlixPay.class;
    public boolean d;
    public g e;
    public final com.alipay.sdk.m.s.a f;
    public boolean g = false;
    public String h = null;
    public String i = null;

    /* compiled from: Taobao */
    public class a implements AlipayResultActivity.a {
        public final /* synthetic */ CountDownLatch a;

        public a(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i, String str, String str2) {
            h.this.h = com.alipay.sdk.m.j.b.a(i, str, str2);
            this.a.countDown();
        }
    }

    /* compiled from: Taobao */
    public class b implements APayEntranceActivity.a {
        public final /* synthetic */ Object a;

        public b(Object obj) {
            this.a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            h.this.i = str;
            synchronized (this.a) {
                try {
                    this.a.notify();
                } catch (Throwable th) {
                    com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "BSAResultEx", th);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements Runnable {
        public final /* synthetic */ APayEntranceActivity.a a;

        public c(APayEntranceActivity.a aVar) {
            this.a = aVar;
        }

        public void run() {
            if (h.this.f != null && !h.this.f.d()) {
                com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.e0, "");
                if (com.alipay.sdk.m.m.a.D().w()) {
                    h.this.f.b(true);
                    this.a.a(com.alipay.sdk.m.j.b.a());
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Object b;

        public d(Intent intent, Object obj) {
            this.a = intent;
            this.b = obj;
        }

        public void run() {
            try {
                if (h.this.a != null) {
                    h.this.a.startActivity(this.a);
                    return;
                }
                com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.c0, "");
                Context a2 = h.this.f.a();
                if (a2 != null) {
                    a2.startActivity(this.a);
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "BSAResultEx", th);
            }
        }
    }

    /* compiled from: Taobao */
    public class e extends IRemoteServiceCallback.Stub {
        public e() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.p, str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (h.this.e != null) {
                    h.this.e.a();
                }
                if (h.this.f != null) {
                    h.this.f.c(true);
                }
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x005d */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0094  */
        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e) {
                com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Z, e);
            }
            intent.setClassName(str, str2);
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                com.alipay.sdk.m.s.a aVar = h.this.f;
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
            }
            try {
                if (h.this.a == null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    h.this.a.startActivity(intent);
                    com.alipay.sdk.m.s.a aVar2 = h.this.f;
                    com.alipay.sdk.m.k.a.a(aVar2, com.alipay.sdk.m.k.b.l, "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                    return;
                }
                com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                Context a2 = h.this.f.a();
                if (a2 != null) {
                    a2.startActivity(intent);
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th);
                throw th;
            }
        }

        public /* synthetic */ e(h hVar, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public class f implements ServiceConnection {
        public f() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "srvCon");
            synchronized (h.this.c) {
                h.this.b = IAlixPay.Stub.asInterface(iBinder);
                h.this.c.notify();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "srvDis");
            h.this.b = null;
        }

        public /* synthetic */ f(h hVar, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public interface g {
        void a();

        void b();
    }

    public h(Activity activity, com.alipay.sdk.m.s.a aVar, g gVar) {
        this.a = activity;
        this.f = aVar;
        this.e = gVar;
        e.d(com.alipay.sdk.m.l.a.z, "alipaySdk");
    }

    private void e(n.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar != null && (packageInfo = cVar.a) != null) {
            String str = packageInfo.packageName;
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
            try {
                this.a.startActivity(intent);
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.g0, th);
            }
            Thread.sleep(200);
        }
    }

    private String f(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String a2 = n.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSAStart", a2 + "|" + elapsedRealtime);
        a.C0134a.a(this.f, a2);
        b bVar = new b(obj);
        APayEntranceActivity.h.put(a2, bVar);
        try {
            HashMap<String, String> a3 = com.alipay.sdk.m.s.a.a(this.f);
            a3.put("ts_intent", String.valueOf(elapsedRealtime));
            jSONObject = new JSONObject(a3);
        } catch (Throwable th) {
            try {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSALocEx", th);
                jSONObject = null;
            } catch (InterruptedException e2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAWaiting", e2);
                com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
                return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEx", th2);
                n.a("alipaySdk", com.alipay.sdk.m.l.b.q, this.a, this.f);
                return k;
            }
        }
        Intent intent = new Intent(this.a, APayEntranceActivity.class);
        intent.putExtra(APayEntranceActivity.d, str);
        intent.putExtra(APayEntranceActivity.e, str2);
        intent.putExtra(APayEntranceActivity.f, a2);
        if (jSONObject != null) {
            intent.putExtra(APayEntranceActivity.g, jSONObject.toString());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new c(bVar), (long) com.alipay.sdk.m.m.a.D().k());
        Activity activity = this.a;
        com.alipay.sdk.m.s.a aVar2 = this.f;
        com.alipay.sdk.m.k.a.a(activity, aVar2, str, aVar2.d);
        if (com.alipay.sdk.m.m.a.D().z()) {
            new Handler(Looper.getMainLooper()).post(new d(intent, obj));
        } else {
            try {
                Activity activity2 = this.a;
                if (activity2 != null) {
                    activity2.startActivity(intent);
                } else {
                    com.alipay.sdk.m.k.a.b(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                    Context a4 = this.f.a();
                    if (a4 != null) {
                        a4.startActivity(intent);
                    }
                }
            } catch (Throwable th3) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th3);
                throw th3;
            }
        }
        synchronized (obj) {
            obj.wait();
        }
        String str3 = this.i;
        String str4 = "unknown";
        try {
            String str5 = l.a(this.f, str3).get(l.a);
            str4 = str5 == null ? "null" : str5;
        } catch (Throwable th4) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAStatEx", th4);
        }
        com.alipay.sdk.m.s.a aVar3 = this.f;
        com.alipay.sdk.m.k.a.a(aVar3, com.alipay.sdk.m.k.b.l, "BSADone-" + str4);
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEmpty");
        return k;
    }

    private String c(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        e.d(com.alipay.sdk.m.l.a.z, "pay payInvokeAct");
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, str2 + "|" + str3);
        Activity activity = this.a;
        com.alipay.sdk.m.s.a aVar2 = this.f;
        com.alipay.sdk.m.k.a.a(activity, aVar2, str, aVar2.d);
        return f(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0188 A[RETURN] */
    private String d(String str, String str2, PackageInfo packageInfo, n.c cVar) {
        String str3;
        com.alipay.sdk.m.s.a aVar;
        Activity activity;
        boolean z = false;
        int i2 = packageInfo != null ? packageInfo.versionCode : 0;
        e.d(com.alipay.sdk.m.l.a.z, "pay bind or scheme");
        com.alipay.sdk.m.s.a aVar2 = this.f;
        if (aVar2 != null && !TextUtils.isEmpty(aVar2.g)) {
            z = this.f.g.toLowerCase().contains("auth");
        }
        if (!z && n.i()) {
            if (cVar != null) {
                try {
                    if (com.alipay.sdk.m.m.a.D().B()) {
                        e(cVar);
                    }
                } catch (Throwable unused) {
                }
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindSkipByModel");
        } else if (z || !n.d(this.f, str2)) {
            if (cVar != null) {
                try {
                    if (!com.alipay.sdk.m.m.a.D().p()) {
                        e(cVar);
                    }
                } catch (Throwable unused2) {
                }
            }
            Pair<String, Boolean> a2 = a(str, str2, this.f);
            str3 = (String) a2.first;
            try {
                if ("failed".equals(str3) && ((Boolean) a2.second).booleanValue() && com.alipay.sdk.m.m.a.D().n()) {
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindRetry");
                    str3 = (String) a(str, str2, this.f).first;
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindRetryEx", th);
            }
            e.d(com.alipay.sdk.m.l.a.z, "pay bind result: " + str3);
            Activity activity2 = this.a;
            com.alipay.sdk.m.s.a aVar3 = this.f;
            com.alipay.sdk.m.k.a.a(activity2, aVar3, str, aVar3.d);
            if ("failed".equals(str3)) {
                return str3;
            }
            if (!"com.eg.android.AlipayGphone".equals(str2)) {
                com.alipay.sdk.m.s.a aVar4 = this.f;
                com.alipay.sdk.m.k.a.a(aVar4, com.alipay.sdk.m.k.b.l, "BSPNotStartByAlipay", str2 + "|" + i2);
                return str3;
            }
            boolean q = com.alipay.sdk.m.m.a.D().q();
            if (i2 >= 460 && q && !z && (activity = this.a) != null && b(str2, activity, this.f)) {
                return c(str, str2, packageInfo);
            }
            if (!com.alipay.sdk.m.m.a.D().i()) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPNotStartByConfig", "");
                return str3;
            } else if (i2 <= 125) {
                com.alipay.sdk.m.s.a aVar5 = this.f;
                com.alipay.sdk.m.k.a.a(aVar5, com.alipay.sdk.m.k.b.l, "BSPNotStartByPkg", str2 + "|" + i2);
                return str3;
            } else if (!com.alipay.sdk.m.m.a.D().m() || (aVar = this.f) == null || n.b(aVar.f) == 0) {
                Activity activity3 = this.a;
                return (activity3 == null || !a(str2, activity3, this.f)) ? k : b(str, str2);
            } else {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPNotStartByUsr");
                return str3;
            }
        } else {
            if (cVar != null) {
                try {
                    if (com.alipay.sdk.m.m.a.D().B()) {
                        e(cVar);
                    }
                } catch (Throwable unused3) {
                }
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindSkipByL");
        }
        str3 = "failed";
        e.d(com.alipay.sdk.m.l.a.z, "pay bind result: " + str3);
        Activity activity22 = this.a;
        com.alipay.sdk.m.s.a aVar32 = this.f;
        com.alipay.sdk.m.k.a.a(activity22, aVar32, str, aVar32.d);
        if ("failed".equals(str3)) {
        }
    }

    public static boolean b(String str, Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail", th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c3  */
    public String a(String str, boolean z) {
        n.c cVar;
        Throwable th;
        String str2 = "";
        PackageInfo packageInfo = null;
        try {
            List<a.b> l = com.alipay.sdk.m.m.a.D().l();
            if (!com.alipay.sdk.m.m.a.D().h || l == null) {
                l = com.alipay.sdk.m.j.a.d;
            }
            cVar = n.a(this.f, this.a, l);
            if (cVar != null) {
                try {
                    if (!cVar.a(this.f)) {
                        if (!cVar.a()) {
                            if (n.a(cVar.a)) {
                                return "failed";
                            }
                            PackageInfo packageInfo2 = cVar.a;
                            if (packageInfo2 == null || "com.eg.android.AlipayGphone".equals(packageInfo2.packageName)) {
                                str2 = n.b();
                            } else {
                                str2 = cVar.a.packageName;
                            }
                            PackageInfo packageInfo3 = cVar.a;
                            if (packageInfo3 != null) {
                                packageInfo = packageInfo3;
                            }
                            String c2 = com.alipay.sdk.m.m.a.D().c();
                            if (c2 != null && c2.length() > 0) {
                                try {
                                    JSONObject optJSONObject = new JSONObject(c2).optJSONObject(str2);
                                    if (optJSONObject != null && optJSONObject.length() > 0) {
                                        Iterator<String> keys = optJSONObject.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            int parseInt = Integer.parseInt(next);
                                            if (packageInfo != null && packageInfo.versionCode >= parseInt) {
                                                try {
                                                    boolean a2 = com.alipay.sdk.m.m.a.D().a(this.a, Integer.parseInt(optJSONObject.getString(next)));
                                                    this.g = a2;
                                                    if (a2) {
                                                        break;
                                                    }
                                                } catch (Exception unused) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                            boolean b2 = n.b(this.f);
                            if ((!z || this.g) && !b2 && b(str2, this.a, this.f)) {
                                return c(str, str2, packageInfo);
                            }
                            return d(str, str2, packageInfo, cVar);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.N, th);
                    boolean b22 = n.b(this.f);
                    if (!z) {
                    }
                    return c(str, str2, packageInfo);
                }
            }
            return "failed";
        } catch (Throwable th3) {
            th = th3;
            cVar = null;
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.N, th);
            boolean b222 = n.b(this.f);
            if (!z) {
            }
            return c(str, str2, packageInfo);
        }
    }

    private String b(String str, String str2) {
        String str3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String a2 = n.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPStart", a2 + "|" + elapsedRealtime);
        a.C0134a.a(this.f, a2);
        AlipayResultActivity.a.put(a2, new a(countDownLatch));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sourcePid", Binder.getCallingPid());
            jSONObject.put(com.alipay.sdk.m.l.b.d, str);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.a.getPackageName());
            jSONObject.put(Preloader.KEY_SESSION, a2);
            String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 2);
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(ALBiometricsKeys.KEY_APP_ID, "20000125");
            appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
            try {
                HashMap<String, String> a3 = com.alipay.sdk.m.s.a.a(this.f);
                a3.put("ts_scheme", String.valueOf(elapsedRealtime));
                appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(a3).toString());
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPLocEx", th);
            }
            String uri = appendQueryParameter.build().toString();
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(Uri.parse(uri));
            Activity activity = this.a;
            com.alipay.sdk.m.s.a aVar2 = this.f;
            com.alipay.sdk.m.k.a.a(activity, aVar2, str, aVar2.d);
            this.a.startActivity(intent);
            e.d(com.alipay.sdk.m.l.a.z, "pay scheme waiting " + uri);
            countDownLatch.await();
            String str4 = this.h;
            try {
                str3 = l.a(this.f, str4).get(l.a);
                if (str3 == null) {
                    str3 = "null";
                }
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPStatEx", th2);
                str3 = "unknown";
            }
            com.alipay.sdk.m.s.a aVar3 = this.f;
            com.alipay.sdk.m.k.a.a(aVar3, com.alipay.sdk.m.k.b.l, "BSPDone-" + str3);
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPEmpty");
            return k;
        } catch (InterruptedException e2) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPWaiting", e2);
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
            return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        } catch (Throwable th3) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPEx", th3);
            return k;
        }
    }

    public static boolean a(String str, Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPDetectFail");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPDetectFail", th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x02ca A[SYNTHETIC, Splitter:B:132:0x02ca] */
    private Pair<String, Boolean> a(String str, String str2, com.alipay.sdk.m.s.a aVar) {
        int i2;
        e eVar;
        f fVar;
        Throwable th;
        Activity activity;
        Activity activity2;
        int i3;
        String str3;
        Activity activity3;
        String str4;
        Pair<String, Boolean> pair;
        Activity activity4;
        Activity activity5;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(n.c(str2));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(elapsedRealtime);
        sb.append("|");
        sb.append(str != null ? str.length() : 0);
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.R, sb.toString());
        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
        try {
            if (!com.alipay.sdk.m.m.a.D().f()) {
                ComponentName startService = this.a.getApplication().startService(intent);
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "stSrv", startService != null ? startService.getPackageName() : "null");
            } else {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "stSrv", "skipped");
            }
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.J, th2);
            n.a("alipaySdk", com.alipay.sdk.m.l.b.n, this.a, this.f);
            return new Pair<>("failed", Boolean.TRUE);
        }
        if (com.alipay.sdk.m.m.a.D().b()) {
            i2 = 65;
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "bindFlg", MonitorType.IMPRESSION);
        } else {
            i2 = 1;
        }
        f fVar2 = new f(this, null);
        if (this.a.getApplicationContext().bindService(intent, fVar2, i2)) {
            synchronized (this.c) {
                if (this.b == null) {
                    try {
                        this.c.wait((long) com.alipay.sdk.m.m.a.D().k());
                    } catch (InterruptedException e2) {
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.L, e2);
                    }
                }
            }
            IAlixPay iAlixPay = this.b;
            if (iAlixPay == null) {
                try {
                    com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, "");
                    n.a("alipaySdk", com.alipay.sdk.m.l.b.o, this.a, this.f);
                    Pair<String, Boolean> pair2 = new Pair<>("failed", Boolean.TRUE);
                    try {
                        this.a.getApplicationContext().unbindService(fVar2);
                    } catch (Throwable th3) {
                        e.a(th3);
                    }
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    this.b = null;
                    if (this.d && (activity5 = this.a) != null) {
                        activity5.setRequestedOrientation(0);
                        this.d = false;
                    }
                    return pair2;
                } catch (Throwable th4) {
                    th = th4;
                    fVar = fVar2;
                    eVar = null;
                    try {
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, th, "in_bind");
                        Pair<String, Boolean> pair3 = new Pair<>("failed", Boolean.TRUE);
                        if (eVar != null) {
                        }
                        try {
                            this.a.getApplicationContext().unbindService(fVar);
                        } catch (Throwable th5) {
                            e.a(th5);
                        }
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                        this.b = null;
                        activity2.setRequestedOrientation(0);
                        this.d = false;
                        return pair3;
                    } catch (Throwable th6) {
                        e.a(th6);
                    }
                }
            } else {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.S, "" + elapsedRealtime2);
                g gVar = this.e;
                if (gVar != null) {
                    gVar.b();
                }
                if (this.a.getRequestedOrientation() == 0) {
                    this.a.setRequestedOrientation(1);
                    this.d = true;
                }
                try {
                    i3 = iAlixPay.getVersion();
                } catch (Throwable th7) {
                    e.a(th7);
                    i3 = 0;
                }
                eVar = new e(this, null);
                if (i3 >= 3) {
                    try {
                        iAlixPay.registerCallback03(eVar, str, null);
                    } catch (Throwable th8) {
                        th = th8;
                        fVar = fVar2;
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, th, "in_bind");
                        Pair<String, Boolean> pair32 = new Pair<>("failed", Boolean.TRUE);
                        if (eVar != null) {
                        }
                        this.a.getApplicationContext().unbindService(fVar);
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                        this.b = null;
                        activity2.setRequestedOrientation(0);
                        this.d = false;
                        return pair32;
                    }
                } else {
                    iAlixPay.registerCallback(eVar);
                }
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                StringBuilder sb2 = new StringBuilder();
                try {
                    sb2.append("");
                    sb2.append(elapsedRealtime3);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.U, sb2.toString());
                    if (i3 >= 3) {
                        iAlixPay.r03(com.alipay.sdk.m.k.b.l, "bind_pay", null);
                    }
                    if (i3 >= 2) {
                        try {
                            HashMap<String, String> a2 = com.alipay.sdk.m.s.a.a(aVar);
                            a2.put("ts_bind", String.valueOf(elapsedRealtime));
                            a2.put("ts_bend", String.valueOf(elapsedRealtime2));
                            a2.put("ts_pay", String.valueOf(elapsedRealtime3));
                            str4 = iAlixPay.pay02(str, a2);
                        } catch (Throwable th9) {
                            th = th9;
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, th, "in_bind");
                            Pair<String, Boolean> pair322 = new Pair<>("failed", Boolean.TRUE);
                            if (eVar != null) {
                                try {
                                    iAlixPay.unregisterCallback(eVar);
                                } catch (Throwable th10) {
                                    e.a(th10);
                                }
                            }
                            this.a.getApplicationContext().unbindService(fVar);
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                            this.b = null;
                            if (this.d && (activity2 = this.a) != null) {
                                activity2.setRequestedOrientation(0);
                                this.d = false;
                            }
                            return pair322;
                        }
                    } else {
                        str4 = iAlixPay.Pay(str);
                    }
                    str3 = str4;
                    fVar = fVar2;
                    try {
                        iAlixPay.unregisterCallback(eVar);
                    } catch (Throwable th11) {
                        e.a(th11);
                    }
                    try {
                        this.a.getApplicationContext().unbindService(fVar);
                    } catch (Throwable th12) {
                        e.a(th12);
                    }
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    this.b = null;
                    if (this.d && (activity3 = this.a) != null) {
                        activity3.setRequestedOrientation(0);
                        this.d = false;
                    }
                    return new Pair<>(str3, Boolean.FALSE);
                } catch (Throwable th13) {
                    th = th13;
                    fVar = fVar2;
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, th, "in_bind");
                    Pair<String, Boolean> pair3222 = new Pair<>("failed", Boolean.TRUE);
                    if (eVar != null) {
                    }
                    this.a.getApplicationContext().unbindService(fVar);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    this.b = null;
                    activity2.setRequestedOrientation(0);
                    this.d = false;
                    return pair3222;
                }
            }
        } else {
            throw new Throwable("bindService fail");
        }
        this.a.getApplicationContext().unbindService(fVar);
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
        this.b = null;
        if (this.d && (activity = this.a) != null) {
            activity.setRequestedOrientation(0);
            this.d = false;
        }
        throw th;
        this.a.getApplicationContext().unbindService(fVar2);
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
        this.b = null;
        if (this.d && (activity4 = this.a) != null) {
            activity4.setRequestedOrientation(0);
            this.d = false;
        }
        return pair;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
        this.b = null;
        activity.setRequestedOrientation(0);
        this.d = false;
        throw th;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
        this.b = null;
        activity4.setRequestedOrientation(0);
        this.d = false;
        return pair;
    }

    public void a() {
        this.a = null;
        this.e = null;
    }
}
