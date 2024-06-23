package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.huawei.hms.opendevice.c;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.xs1;

/* compiled from: Taobao */
public final class e {
    static boolean v;
    private boolean a = false;
    private boolean b = false;
    String c = null;
    b d = null;
    private long e = 0;
    private eo f = null;
    AMapLocation g = null;
    a h = null;
    Context i = null;
    private n1 j = null;
    ej k = null;
    HashMap<Messenger, Long> l = new HashMap<>();
    l1 m = null;
    long n = 0;
    long o = 0;
    private List<Messenger> p;
    String q = null;
    private boolean r = true;
    private String s = "";
    AMapLocationClientOption t = null;
    AMapLocationClientOption u = new AMapLocationClientOption();

    /* compiled from: Taobao */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x005c A[Catch:{ all -> 0x011c }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x010e A[Catch:{ all -> 0x011c }] */
        public final void handleMessage(Message message) {
            Messenger messenger;
            Bundle bundle;
            int i;
            e eVar;
            String str;
            Throwable th;
            try {
                bundle = message.getData();
                try {
                    messenger = message.replyTo;
                    if (bundle != null) {
                        try {
                            if (!bundle.isEmpty()) {
                                if (!e.this.r(bundle.getString(c.a))) {
                                    if (message.what == 1) {
                                        l1.p(null, 2102);
                                        eo a2 = e.a(10, "invalid handlder scode!!!#1002");
                                        ei eiVar = new ei();
                                        eiVar.f("#1002");
                                        eiVar.e("conitue");
                                        e.this.j(messenger, a2, a2.k(), eiVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                j1.h(th, "ApsServiceCore", "ActionHandler handlerMessage");
                                i = message.what;
                                if (i != 0) {
                                }
                                super.handleMessage(message);
                            } catch (Throwable th3) {
                                j1.h(th3, "actionHandler", "handleMessage");
                                return;
                            }
                        }
                    }
                } catch (Throwable th4) {
                    messenger = null;
                    th = th4;
                    j1.h(th, "ApsServiceCore", "ActionHandler handlerMessage");
                    i = message.what;
                    if (i != 0) {
                    }
                    super.handleMessage(message);
                }
            } catch (Throwable th5) {
                messenger = null;
                th = th5;
                bundle = null;
                j1.h(th, "ApsServiceCore", "ActionHandler handlerMessage");
                i = message.what;
                if (i != 0) {
                }
                super.handleMessage(message);
            }
            i = message.what;
            if (i != 0) {
                e.this.e(bundle);
                e.this.h(messenger, bundle);
            } else if (i != 1) {
                switch (i) {
                    case 9:
                        e.this.e(bundle);
                        e.this.E();
                        break;
                    case 10:
                        e.this.e(bundle);
                        eVar = e.this;
                        str = "FINE_LOC";
                        eVar.i(messenger, bundle, str);
                        break;
                    case 11:
                        e.this.A();
                        break;
                    case 12:
                        e.this.f(messenger);
                        break;
                    case 13:
                        Messenger messenger2 = message.replyTo;
                        if (!(messenger2 == null || e.this.p == null || e.this.p.contains(messenger2))) {
                            e.this.p.add(messenger2);
                            if (e.this.p.size() == 1) {
                                e.this.D();
                                break;
                            }
                        }
                        break;
                    case 14:
                        Messenger messenger3 = message.replyTo;
                        if (!(messenger3 == null || e.this.p == null || !e.this.p.contains(messenger3))) {
                            e.this.p.remove(messenger3);
                        }
                        if (e.this.p != null && e.this.p.size() == 0) {
                            e.this.k.C();
                            break;
                        }
                    case 15:
                        e.this.e(bundle);
                        eVar = e.this;
                        str = "COARSE_LOC";
                        eVar.i(messenger, bundle, str);
                        break;
                }
            } else {
                e.this.e(bundle);
                e.this.y(messenger, bundle);
            }
            super.handleMessage(message);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                e.this.j = new n1(e.this.i);
            } catch (Throwable th) {
                j1.h(th, "APSManager$ActionThread", "onLooperPrepared");
                return;
            }
            try {
                i1.j(e.this.i);
                i1.a(e.this.i);
            } catch (Throwable th2) {
                j1.h(th2, "APSManager$ActionThread", "init 3");
            }
            e.this.k = new ej(false);
            super.onLooperPrepared();
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                j1.h(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public e(Context context) {
        this.i = context;
    }

    public static void C() {
        v = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void D() {
        if (!m1.f0(this.i)) {
            try {
                ej ejVar = this.k;
                if (ejVar != null && ejVar != null) {
                    ejVar.k(this.h);
                    this.k.B();
                }
            } catch (Throwable th) {
                j1.h(th, "ApsServiceCore", "startColl");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void E() {
        try {
            i1.m(this.i);
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    /* access modifiers changed from: private */
    public static eo a(int i2, String str) {
        try {
            eo eoVar = new eo("");
            eoVar.setErrorCode(i2);
            eoVar.setLocationDetail(str);
            return eoVar;
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(Bundle bundle) {
        try {
            if (this.a) {
                ej ejVar = this.k;
                if (ejVar != null) {
                    ejVar.i();
                    return;
                }
                return;
            }
            j1.e(this.i);
            if (bundle != null) {
                this.u = j1.c(bundle.getBundle("optBundle"));
            }
            this.k.j(this.i);
            this.k.q();
            l(this.u);
            this.k.v();
            this.a = true;
            this.r = true;
            this.s = "";
            List<Messenger> list = this.p;
            if (list != null && list.size() > 0) {
                D();
            }
        } catch (Throwable th) {
            this.r = false;
            th.printStackTrace();
            this.s = th.getMessage();
            j1.h(th, "ApsServiceCore", UCCore.LEGACY_EVENT_INIT);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(Messenger messenger) {
        this.l.remove(messenger);
    }

    private static void g(Messenger messenger, int i2, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i2;
                messenger.send(obtain);
            } catch (Throwable th) {
                j1.h(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    if (!this.b) {
                        this.b = true;
                        x(messenger);
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(Messenger messenger, AMapLocation aMapLocation, String str, ei eiVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", eiVar);
        this.l.put(messenger, Long.valueOf(m1.B()));
        g(messenger, 1, bundle);
    }

    private void k(Messenger messenger, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", i1.y() * 3);
        bundle.putInt("I_MIN_GEO_DIS", i1.y());
        bundle.putParcelable("loc", this.g);
        g(messenger, "COARSE_LOC".equals(str) ? 103 : 6, bundle);
    }

    private void l(AMapLocationClientOption aMapLocationClientOption) {
        try {
            ej ejVar = this.k;
            if (ejVar != null) {
                ejVar.m(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                v = aMapLocationClientOption.isKillProcess();
                if (this.t != null) {
                    if (!(aMapLocationClientOption.isOffset() == this.t.isOffset() && aMapLocationClientOption.isNeedAddress() == this.t.isNeedAddress() && aMapLocationClientOption.isLocationCacheEnable() == this.t.isLocationCacheEnable() && this.t.getGeoLanguage() == aMapLocationClientOption.getGeoLanguage())) {
                        this.e = 0;
                    }
                    if (!(aMapLocationClientOption.isOffset() == this.t.isOffset() && this.t.getGeoLanguage() == aMapLocationClientOption.getGeoLanguage())) {
                        this.g = null;
                    }
                }
                this.t = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "setExtra");
        }
    }

    private static AMapLocationClientOption t(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = null;
        try {
            aMapLocationClientOption = j1.c(bundle.getBundle("optBundle"));
            try {
                String string = bundle.getString("d");
                if (!TextUtils.isEmpty(string)) {
                    o.B(string);
                }
            } catch (Throwable th) {
                j1.h(th, "APSManager", "doLocation setUmidToken");
            }
        } catch (Throwable th2) {
            j1.h(th2, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    private void x(Messenger messenger) {
        try {
            this.k.A();
            if (i1.A()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                g(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "initAuth");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014e  */
    private void y(Messenger messenger, Bundle bundle) {
        eo eoVar;
        String str;
        n1 n1Var;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    ei eiVar = new ei();
                    eiVar.e("conitue");
                    AMapLocationClientOption t2 = t(bundle);
                    l(t2);
                    if (this.l.containsKey(messenger) && !t2.isOnceLocation()) {
                        if (m1.B() - this.l.get(messenger).longValue() < 800) {
                            return;
                        }
                    }
                    AMapLocation aMapLocation = null;
                    if (!this.r) {
                        this.f = a(9, "init error : " + this.s + "#0901");
                        eiVar.f("#0901");
                        eo eoVar2 = this.f;
                        j(messenger, eoVar2, eoVar2.k(), eiVar);
                        l1.p(null, 2091);
                        return;
                    }
                    long B = m1.B();
                    if (!m1.r(this.f) || B - this.e >= 600) {
                        eiVar.c(m1.B());
                        try {
                            eo c2 = this.k.c(eiVar);
                            this.f = c2;
                            if (c2.getLocationType() != 6) {
                                if (this.f.getLocationType() != 5) {
                                    if (this.f.getLocationType() == 2) {
                                        this.k.n(this.f, 3);
                                    } else if (this.f.getLocationType() == 4) {
                                        this.k.n(this.f, 4);
                                    }
                                    this.f = this.k.d(this.f);
                                    if (m1.r(this.f)) {
                                        this.e = m1.B();
                                    }
                                    if (this.f == null) {
                                        this.f = a(8, "loc is null#0801");
                                        eiVar.f("#0801");
                                    }
                                    eoVar = this.f;
                                    if (eoVar == null) {
                                        String k2 = eoVar.k();
                                        aMapLocation = this.f.clone();
                                        str = k2;
                                    } else {
                                        str = null;
                                    }
                                    if (t2.isLocationCacheEnable() && (n1Var = this.j) != null) {
                                        aMapLocation = n1Var.a(aMapLocation, str, t2.getLastLocationLifeCycle());
                                    }
                                    j(messenger, aMapLocation, str, eiVar);
                                    return;
                                }
                            }
                            this.k.n(this.f, 2);
                            this.f = this.k.d(this.f);
                        } catch (Throwable th) {
                            l1.p(null, 2081);
                            eiVar.f("#0801");
                            this.f = a(8, "loc error : " + th.getMessage() + "#0801");
                            j1.h(th, "ApsServiceCore", "run part2");
                        }
                        if (m1.r(this.f)) {
                        }
                        if (this.f == null) {
                        }
                        eoVar = this.f;
                        if (eoVar == null) {
                        }
                        try {
                            aMapLocation = n1Var.a(aMapLocation, str, t2.getLastLocationLifeCycle());
                        } catch (Throwable th2) {
                            j1.h(th2, "ApsServiceCore", "fixLastLocation");
                        }
                        j(messenger, aMapLocation, str, eiVar);
                        return;
                    }
                    eo eoVar3 = this.f;
                    j(messenger, eoVar3, eoVar3.k(), eiVar);
                    this.k.n(this.f, 3);
                }
            } catch (Throwable th3) {
                j1.h(th3, "ApsServiceCore", "doLocation");
            }
        }
    }

    public final void A() {
        try {
            HashMap<Messenger, Long> hashMap = this.l;
            if (hashMap != null) {
                hashMap.clear();
                this.l = null;
            }
            try {
                List<Messenger> list = this.p;
                if (list != null) {
                    list.clear();
                }
            } catch (Throwable th) {
                j1.h(th, xs1.DEFAULT_SAVE_DIR, "des1");
            }
            n1 n1Var = this.j;
            if (n1Var != null) {
                n1Var.e();
                this.j = null;
            }
            this.a = false;
            this.b = false;
            this.k.z();
            a aVar = this.h;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.h = null;
            b bVar = this.d;
            if (bVar != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    try {
                        k1.b(bVar, HandlerThread.class, "quitSafely", new Object[0]);
                    } catch (Throwable unused) {
                        this.d.quit();
                    }
                } else {
                    bVar.quit();
                }
            }
            this.d = null;
            if (!(this.m == null || this.n == 0 || this.o == 0)) {
                long B = m1.B() - this.n;
                l1.e(this.i, this.m.w(this.i), this.m.x(this.i), this.o, B);
                this.m.y(this.i);
            }
            l1.c(this.i);
            an.k();
            if (v) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th2) {
            j1.h(th2, xs1.DEFAULT_SAVE_DIR, "tdest");
        }
    }

    public final void c() {
        try {
            this.m = new l1();
            b bVar = new b("amapLocCoreThread");
            this.d = bVar;
            bVar.setPriority(5);
            this.d.start();
            this.h = new a(this.d.getLooper());
            this.p = new ArrayList();
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void d(Intent intent) {
        a aVar;
        if ("true".equals(intent.getStringExtra("as")) && (aVar = this.h) != null) {
            aVar.sendEmptyMessageDelayed(9, 100);
        }
    }

    /* access modifiers changed from: package-private */
    public final void i(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption t2;
        float f2;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    double d2 = bundle.getDouble("lat");
                    double d3 = bundle.getDouble("lon");
                    float f3 = bundle.getFloat(BQCCameraParam.FOCUS_AREA_RADIUS);
                    long j2 = bundle.getLong("time");
                    if ("FINE_LOC".equals(str)) {
                        AMapLocation aMapLocation = new AMapLocation(GeocodeSearch.GPS);
                        aMapLocation.setLatitude(d2);
                        aMapLocation.setLocationType(1);
                        aMapLocation.setLongitude(d3);
                        aMapLocation.setAccuracy(f3);
                        aMapLocation.setTime(j2);
                        this.k.l(aMapLocation);
                    }
                    if (!i1.x() || (t2 = t(bundle)) == null) {
                        return;
                    }
                    if (t2.isNeedAddress()) {
                        l(t2);
                        AMapLocation aMapLocation2 = this.g;
                        if (aMapLocation2 != null) {
                            f2 = m1.e(new double[]{d2, d3, aMapLocation2.getLatitude(), this.g.getLongitude()});
                            if (f2 < ((float) (i1.y() * 3))) {
                                k(messenger, str);
                            }
                        } else {
                            f2 = -1.0f;
                        }
                        if (f2 == -1.0f || f2 > ((float) i1.y())) {
                            e(bundle);
                            eo a2 = this.k.a(d2, d3);
                            this.g = a2;
                            if (a2 != null && !TextUtils.isEmpty(a2.getAdCode())) {
                                k(messenger, str);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                j1.h(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean r(String str) {
        if (TextUtils.isEmpty(this.q)) {
            this.q = j1.o(this.i);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.q);
    }

    public final Handler s() {
        return this.h;
    }

    public final void w(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            m.h(this.i, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.c = stringExtra2;
        l.c(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (!TextUtils.isEmpty(stringExtra3)) {
            o.B(stringExtra3);
        }
    }
}
