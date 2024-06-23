package com.loc;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.c63;
import tb.e63;
import tb.o53;
import tb.w53;

/* compiled from: Taobao */
public final class d {
    private static boolean H = true;
    public static volatile boolean I;
    private static boolean J;
    private static AtomicBoolean K = new AtomicBoolean(false);
    private ServiceConnection A = new a();
    AMapLocationQualityReport B = null;
    boolean C = false;
    private volatile boolean D = false;
    HandlerC0181d E = null;
    String F = null;
    boolean G = false;
    eo a;
    private Context b;
    AMapLocationClientOption c = new AMapLocationClientOption();
    public e d;
    e63 e = null;
    private c63 f;
    private boolean g = false;
    private volatile boolean h = false;
    ArrayList<AMapLocationListener> i = new ArrayList<>();
    public boolean j = true;
    public boolean k = true;
    n1 l;
    Messenger m = null;
    Messenger n = null;
    Intent o = null;
    private boolean p;
    b q = null;
    boolean r = false;
    AMapLocationClientOption.AMapLocationMode s = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    Object t = new Object();
    l1 u = null;
    boolean v = false;
    e w = null;
    private AMapLocationClientOption x = new AMapLocationClientOption();
    private i y = null;
    String z = null;

    /* compiled from: Taobao */
    class a implements ServiceConnection {
        a() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.m = new Messenger(iBinder);
                d.this.g = true;
                d.this.v = true;
            } catch (Throwable th) {
                j1.h(th, "ALManager", "onServiceConnected");
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            d dVar = d.this;
            dVar.m = null;
            dVar.g = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends HandlerThread {
        d a = null;

        public b(String str, d dVar) {
            super(str);
            this.a = dVar;
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                this.a.l.b();
                w53.a(this.a.b);
                this.a.v0();
                d dVar = this.a;
                if (!(dVar == null || dVar.b == null)) {
                    i1.j(this.a.b);
                    i1.a(this.a.b);
                }
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            try {
                a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.loc.d$d  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class HandlerC0181d extends Handler {
        public HandlerC0181d(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void handleMessage(Message message) {
            Throwable th;
            String str = null;
            try {
                super.handleMessage(message);
                int i = message.what;
                if (i == 11) {
                    d.this.k(message.getData());
                } else if (i == 12) {
                    d.this.I(message);
                } else if (i != 1011) {
                    switch (i) {
                        case 1002:
                            d.this.U((AMapLocationListener) message.obj);
                            return;
                        case 1003:
                            d.this.o0();
                            d.this.f(13, null);
                            return;
                        case 1004:
                            try {
                                d.this.r0();
                                d.this.f(14, null);
                                return;
                            } catch (Throwable th2) {
                                str = "handleMessage STOP_LOCATION";
                                th = th2;
                                break;
                            }
                        case 1005:
                            d.this.Z((AMapLocationListener) message.obj);
                            return;
                        default:
                            switch (i) {
                                case 1014:
                                    d.this.l(message);
                                    return;
                                case 1015:
                                    d dVar = d.this;
                                    dVar.e.k(dVar.c);
                                    d.this.g(1025, null, 300000);
                                    return;
                                case 1016:
                                    if (m1.f0(d.this.b)) {
                                        d.this.x0();
                                        return;
                                    } else if (d.this.e.v()) {
                                        d.this.g(1016, null, 1000);
                                        return;
                                    } else {
                                        d.this.t0();
                                        return;
                                    }
                                case 1017:
                                    d.this.e.c();
                                    d.this.d(1025);
                                    return;
                                case 1018:
                                    d dVar2 = d.this;
                                    AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                    dVar2.c = aMapLocationClientOption;
                                    if (aMapLocationClientOption != null) {
                                        dVar2.y0();
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i) {
                                        case 1023:
                                            d.this.S(message);
                                            return;
                                        case 1024:
                                            d.this.X(message);
                                            return;
                                        case 1025:
                                            if (d.this.e.F()) {
                                                d.this.e.c();
                                                d dVar3 = d.this;
                                                dVar3.e.k(dVar3.c);
                                            }
                                            d.this.g(1025, null, 300000);
                                            return;
                                        case 1026:
                                            d.this.f.i(d.this.c);
                                            return;
                                        case 1027:
                                            d.this.f.b();
                                            return;
                                        case 1028:
                                            d.this.g0((AMapLocation) message.obj);
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
                    if (str == null) {
                        str = "handleMessage";
                    }
                    j1.h(th, "AMapLocationManage$MHandlerr", str);
                } else {
                    d.this.f(14, null);
                    d.this.i0();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* compiled from: Taobao */
    public class e extends Handler {
        public e() {
        }

        public e(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void handleMessage(Message message) {
            e eVar;
            e eVar2;
            String str = null;
            try {
                super.handleMessage(message);
                d dVar = d.this;
                if (!dVar.r) {
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 13) {
                                switch (i) {
                                    case 5:
                                        Bundle data = message.getData();
                                        data.putBundle("optBundle", j1.a(d.this.c));
                                        d.this.f(10, data);
                                        return;
                                    case 6:
                                        Bundle data2 = message.getData();
                                        e63 e63 = d.this.e;
                                        if (e63 != null) {
                                            e63.h(data2);
                                            return;
                                        }
                                        return;
                                    case 7:
                                        d.this.p = message.getData().getBoolean("ngpsAble");
                                        return;
                                    case 8:
                                        l1.p(null, 2141);
                                        break;
                                    case 9:
                                        boolean unused = d.J = message.getData().getBoolean("installMockApp");
                                        return;
                                    case 10:
                                        dVar.n((AMapLocation) message.obj);
                                        return;
                                    default:
                                        switch (i) {
                                            case 100:
                                                l1.p(null, 2155);
                                                break;
                                            case 101:
                                                break;
                                            case 102:
                                                Bundle data3 = message.getData();
                                                data3.putBundle("optBundle", j1.a(d.this.c));
                                                d.this.f(15, data3);
                                                return;
                                            case 103:
                                                Bundle data4 = message.getData();
                                                if (d.this.f != null) {
                                                    d.this.f.f(data4);
                                                    return;
                                                }
                                                return;
                                            default:
                                                return;
                                        }
                                        Message obtain = Message.obtain();
                                        obtain.what = 1028;
                                        obtain.obj = message.obj;
                                        d.this.E.sendMessage(obtain);
                                        if (d.this.x != null && d.this.x.getCacheCallBack() && (eVar2 = d.this.d) != null) {
                                            eVar2.removeMessages(13);
                                            return;
                                        }
                                        return;
                                }
                            } else {
                                eo eoVar = dVar.a;
                                if (eoVar != null) {
                                    dVar.n(eoVar);
                                    return;
                                }
                                AMapLocation aMapLocation = new AMapLocation("LBS");
                                aMapLocation.setErrorCode(33);
                                d.this.n(aMapLocation);
                                return;
                            }
                        }
                        Message obtain2 = Message.obtain();
                        obtain2.what = 12;
                        obtain2.obj = message.obj;
                        d.this.E.sendMessage(obtain2);
                        if (d.this.x != null && d.this.x.getCacheCallBack() && (eVar = d.this.d) != null) {
                            eVar.removeMessages(13);
                            return;
                        }
                        return;
                    }
                    Message obtainMessage = dVar.E.obtainMessage();
                    obtainMessage.what = 11;
                    obtainMessage.setData(message.getData());
                    d.this.E.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    str = "handleMessage";
                }
                j1.h(th, "AmapLocationManager$MainHandler", str);
            }
        }
    }

    public d(Context context, Intent intent, Looper looper) {
        this.b = context;
        this.o = intent;
        H(looper);
    }

    private static void A(ej ejVar, eo eoVar) {
        if (eoVar != null) {
            try {
                if (eoVar.getErrorCode() == 0) {
                    ejVar.t(eoVar);
                }
            } catch (Throwable th) {
                j1.h(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(19:1|2|(3:3|4|(1:6))|(3:9|10|(1:12))|15|(3:16|17|(3:19|(2:21|(1:23)(2:24|(2:26|(1:30))))|34)(1:31))|35|(5:(1:38)(1:39)|40|41|(1:45)|46)(2:54|55)|(3:57|58|59)(1:61)|(3:62|63|(1:67))|70|71|(1:75)|76|77|(1:79)|80|(1:82)|(1:89)) */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0122, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0123, code lost:
        com.loc.j1.h(r1, "ALManager", "apsLocation:callback");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x00ff */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0106 A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011e A[Catch:{ all -> 0x0122 }] */
    private eo E(ej ejVar) {
        eo eoVar;
        Throwable th;
        eo eoVar2;
        boolean z2;
        String str;
        e eVar;
        n1 n1Var;
        AMapLocation aMapLocation = null;
        this.a = null;
        ei eiVar = new ei();
        try {
            eiVar.c(m1.B());
            try {
                String apikey = AMapLocationClientOption.getAPIKEY();
                if (!TextUtils.isEmpty(apikey)) {
                    m.h(this.b, apikey);
                }
            } catch (Throwable th2) {
                j1.h(th2, "ALManager", "apsLocation setAuthKey");
            }
            try {
                String umidtoken = UmidtokenInfo.getUmidtoken();
                if (!TextUtils.isEmpty(umidtoken)) {
                    o.B(umidtoken);
                }
            } catch (Throwable th3) {
                j1.h(th3, "ALManager", "apsLocation setUmidToken");
            }
            z(ejVar, eiVar);
            boolean B2 = i1.B();
            boolean z3 = false;
            try {
                if (this.x.getCacheCallBack()) {
                    eoVar2 = c(ejVar, this.x.getCacheCallBack());
                    if (eoVar2 != null) {
                        if (!i1.f(eoVar2.getTime())) {
                            if (this.x.getCacheCallBack()) {
                                int cacheTimeOut = this.x.getCacheTimeOut();
                                long g2 = m1.g() - eoVar2.getTime();
                                if (g2 > 0 && g2 < ((long) cacheTimeOut)) {
                                    this.a = eoVar2;
                                    eoVar2.setLocationType(10);
                                }
                            }
                        }
                    }
                    eoVar2 = null;
                } else {
                    eoVar2 = c(ejVar, false);
                }
            } catch (Throwable th4) {
                j1.h(th4, "ALManager", "apscach");
            }
            if (eoVar2 == null) {
                try {
                    eo g3 = ejVar.g(!B2, eiVar);
                    if (g3 != null && g3.getErrorCode() == 0) {
                        z3 = true;
                    }
                    eoVar = g3;
                    z2 = z3;
                    z3 = true;
                } catch (Throwable th5) {
                    th = th5;
                    eoVar = eoVar2;
                    try {
                        j1.h(th, "ALManager", "apsLocation");
                        ejVar.z();
                        return eoVar;
                    } catch (Throwable unused) {
                    }
                }
            } else {
                eoVar = eoVar2;
                z2 = false;
            }
            if (eoVar != null) {
                try {
                    str = eoVar.k();
                    aMapLocation = eoVar.clone();
                } catch (Throwable th6) {
                    th = th6;
                    j1.h(th, "ALManager", "apsLocation");
                    ejVar.z();
                    return eoVar;
                }
            } else {
                str = null;
            }
            try {
                if (this.c.isLocationCacheEnable() && (n1Var = this.l) != null) {
                    aMapLocation = n1Var.a(aMapLocation, str, this.c.getLastLocationLifeCycle());
                }
            } catch (Throwable th7) {
                j1.h(th7, "ALManager", "fixLastLocation");
            }
            if (this.x.getCacheCallBack() && (eVar = this.d) != null) {
                eVar.removeMessages(13);
            }
            Bundle bundle = new Bundle();
            if (aMapLocation != null) {
                bundle.putParcelable("loc", aMapLocation);
                bundle.putString("nb", eoVar.k());
                bundle.putParcelable("statics", eiVar);
            }
            k(bundle);
            if (z2) {
                A(ejVar, eoVar);
            }
            if (z3 && B2 && !I) {
                I = true;
                y(ejVar);
            }
        } catch (Throwable th8) {
            eoVar = null;
            th = th8;
            j1.h(th, "ALManager", "apsLocation");
            ejVar.z();
            return eoVar;
        }
        try {
            ejVar.z();
        } catch (Throwable unused2) {
        }
        return eoVar;
        throw th;
    }

    private void H(Looper looper) {
        if (looper == null) {
            try {
                this.d = Looper.myLooper() == null ? new e(this.b.getMainLooper()) : new e();
            } catch (Throwable th) {
                j1.h(th, "ALManager", "init 1");
            }
        } else {
            this.d = new e(looper);
        }
        try {
            this.l = new n1(this.b);
        } catch (Throwable th2) {
            j1.h(th2, "ALManager", "init 5");
        }
        b bVar = new b("amapLocManagerThread", this);
        this.q = bVar;
        bVar.setPriority(5);
        this.q.start();
        this.E = b(this.q.getLooper());
        try {
            this.e = new e63(this.b, this.d);
            this.f = new c63(this.b, this.d);
        } catch (Throwable th3) {
            j1.h(th3, "ALManager", "init 3");
        }
        if (this.u == null) {
            this.u = new l1();
        }
        h(this.b);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void I(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (this.j && this.m != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", j1.a(this.c));
                f(0, bundle);
                if (this.h) {
                    f(13, null);
                }
                this.j = false;
            }
            o(aMapLocation, null);
            d(1025);
            g(1025, null, 300000);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private void J(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                StringBuilder sb = TextUtils.isEmpty(locationDetail) ? new StringBuilder() : new StringBuilder(locationDetail);
                boolean N = m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean N2 = m1.N(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean N3 = m1.N(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean N4 = m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean N5 = m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean N6 = m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(N ? "#pm1" : "#pm0");
                String str = "1";
                sb.append(N2 ? str : "0");
                sb.append(N3 ? str : "0");
                sb.append(N4 ? str : "0");
                sb.append(N5 ? str : "0");
                if (!N6) {
                    str = "0";
                }
                sb.append(str);
                aMapLocation.setLocationDetail(sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void S(Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    int i2 = data.getInt("i", 0);
                    Intent w0 = w0();
                    w0.putExtra("i", i2);
                    w0.putExtra("h", (Notification) data.getParcelable("h"));
                    w0.putExtra("g", 1);
                    j(w0, true);
                }
            } catch (Throwable th) {
                j1.h(th, "ALManager", "doEnableBackgroundLocation");
            }
        }
    }

    private void T(AMapLocation aMapLocation) {
        Message obtainMessage = this.d.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.d.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void U(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            if (!this.i.contains(aMapLocationListener)) {
                this.i.add(aMapLocationListener);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("listener参数不能为null");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void X(Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    boolean z2 = data.getBoolean("j", true);
                    Intent w0 = w0();
                    w0.putExtra("j", z2);
                    w0.putExtra("g", 2);
                    j(w0, false);
                }
            } catch (Throwable th) {
                j1.h(th, "ALManager", "doDisableBackgroundLocation");
            }
        }
    }

    private synchronized void Y(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (Throwable th) {
                j1.h(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.B == null) {
            this.B = new AMapLocationQualityReport();
        }
        this.B.setLocationMode(this.c.getLocationMode());
        if (this.f != null) {
            this.B.setGPSSatellites(aMapLocation.getSatellites());
            this.B.setGpsStatus(this.f.n());
        }
        this.B.setWifiAble(m1.Y(this.b));
        this.B.setNetworkType(m1.Z(this.b));
        this.B.setNetUseTime(0);
        this.B.setInstallHighDangerMockApp(J);
        aMapLocation.setLocationQualityReport(this.B);
        try {
            if (this.h) {
                l1.h(this.b, aMapLocation);
                T(aMapLocation.clone());
                w53.a(this.b).c(aMapLocation);
                w53.a(this.b).d();
            }
        } catch (Throwable th2) {
            j1.h(th2, "ALManager", "handlerCoarseLocation part");
        }
        if (!this.r) {
            if (this.f != null) {
                r0();
            }
            f(14, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Z(AMapLocationListener aMapLocationListener) {
        if (!this.i.isEmpty() && this.i.contains(aMapLocationListener)) {
            this.i.remove(aMapLocationListener);
        }
        if (this.i.isEmpty()) {
            r0();
        }
    }

    private HandlerC0181d b(Looper looper) {
        HandlerC0181d dVar;
        synchronized (this.t) {
            dVar = new HandlerC0181d(looper);
            this.E = dVar;
        }
        return dVar;
    }

    private eo c(ej ejVar, boolean z2) {
        if (!this.c.isLocationCacheEnable()) {
            return null;
        }
        try {
            return ejVar.f(z2);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "doFirstCacheLoc");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(int i2) {
        synchronized (this.t) {
            HandlerC0181d dVar = this.E;
            if (dVar != null) {
                dVar.removeMessages(i2);
            }
        }
    }

    private void d0(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            AMapLocation aMapLocation2 = null;
            try {
                o53 o53 = n1.g;
                if (o53 == null) {
                    n1 n1Var = this.l;
                    if (n1Var != null) {
                        aMapLocation2 = n1Var.d();
                    }
                } else {
                    aMapLocation2 = o53.a();
                }
                l1.o(aMapLocation2, aMapLocation);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(int i2, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z2 = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z2) {
                    this.m = null;
                    this.g = false;
                }
                j1.h(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.z)) {
            this.z = j1.o(this.b);
        }
        bundle.putString(com.huawei.hms.opendevice.c.a, this.z);
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.setData(bundle);
        obtain.replyTo = this.n;
        Messenger messenger = this.m;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(int i2, Object obj, long j2) {
        synchronized (this.t) {
            if (this.E != null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.E.sendMessageDelayed(obtain, j2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g0(AMapLocation aMapLocation) {
        try {
            if (this.k && this.m != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", j1.a(this.c));
                f(0, bundle);
                if (this.h) {
                    f(13, null);
                }
                this.k = false;
            }
            Y(aMapLocation);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private static void h(final Context context) {
        if (K.compareAndSet(false, true)) {
            o0.f().d(new ck() {
                /* class com.loc.d.AnonymousClass1 */

                @Override // com.loc.ck
                public final void a() {
                    o.M();
                    o.w(context);
                    o.R(context);
                }
            });
        }
    }

    private void i(Intent intent) {
        try {
            this.b.bindService(intent, this.A, 1);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "startServiceImpl");
        }
    }

    private void j(Intent intent, boolean z2) {
        Context context = this.b;
        if (context != null) {
            if (Build.VERSION.SDK_INT < 26 || !z2) {
                context.startService(intent);
            } else if (!z0()) {
                Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
                return;
            } else {
                try {
                    this.b.getClass().getMethod("startForegroundService", Intent.class).invoke(this.b, intent);
                } catch (Throwable unused) {
                    this.b.startService(intent);
                }
            }
            this.G = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: android.os.Bundle */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(Bundle bundle) {
        ei eiVar;
        ei eiVar2;
        AMapLocation aMapLocation;
        ei eiVar3;
        Throwable th;
        AMapLocation aMapLocation2 = null;
        if (bundle != 0) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                this.F = bundle.getString("nb");
                ei eiVar4 = (ei) bundle.getParcelable("statics");
                eiVar2 = eiVar4;
                if (aMapLocation != null) {
                    eiVar2 = eiVar4;
                    if (aMapLocation.getErrorCode() == 0) {
                        e63 e63 = this.e;
                        eiVar2 = eiVar4;
                        if (e63 != null) {
                            e63.x();
                            eiVar2 = eiVar4;
                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                e63.J = aMapLocation;
                                eiVar2 = eiVar4;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                eiVar3 = bundle;
                j1.h(th, "AmapLocationManager", "resultLbsLocationSuccess");
                eiVar = eiVar3;
                o(aMapLocation2, eiVar);
            }
        } else {
            eiVar2 = null;
            aMapLocation = null;
        }
        e63 e632 = this.e;
        if (e632 != null) {
            aMapLocation2 = e632.b(aMapLocation, this.F);
            eiVar = eiVar2;
        } else {
            aMapLocation2 = aMapLocation;
            eiVar = eiVar2;
        }
        o(aMapLocation2, eiVar);
    }

    private void k0() {
        synchronized (this.t) {
            HandlerC0181d dVar = this.E;
            if (dVar != null) {
                dVar.removeCallbacksAndMessages(null);
            }
            this.E = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            d0(aMapLocation);
            if (this.l.c(aMapLocation, string)) {
                this.l.f();
            }
        } catch (Throwable th) {
            j1.h(th, "ALManager", "doSaveLastLocation");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    l1.q("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) || !this.e.v()) {
                aMapLocation.setAltitude(m1.I(aMapLocation.getAltitude()));
                aMapLocation.setBearing(m1.b(aMapLocation.getBearing()));
                aMapLocation.setSpeed(m1.b(aMapLocation.getSpeed()));
                J(aMapLocation);
                Iterator<AMapLocationListener> it = this.i.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private boolean n0() {
        boolean z2 = false;
        int i2 = 0;
        do {
            try {
                if (this.m != null) {
                    break;
                }
                Thread.sleep(100);
                i2++;
            } catch (Throwable th) {
                j1.h(th, "ALManager", "checkAPSManager");
            }
        } while (i2 < 50);
        if (this.m == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            aMapLocation.setLocationDetail(!m1.d0(this.b.getApplicationContext()) ? "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003" : "启动ApsServcie失败#1001");
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.d.sendMessage(obtain);
        } else {
            z2 = true;
        }
        if (!z2) {
            l1.p(null, !m1.d0(this.b.getApplicationContext()) ? 2103 : 2101);
        }
        return z2;
    }

    private synchronized void o(AMapLocation aMapLocation, ei eiVar) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                j1.h(th, "ALManager", "handlerLocation part3");
                return;
            }
        }
        if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.B == null) {
            this.B = new AMapLocationQualityReport();
        }
        this.B.setLocationMode(this.c.getLocationMode());
        e63 e63 = this.e;
        if (e63 != null) {
            this.B.setGPSSatellites(e63.C());
            this.B.setGpsStatus(this.e.A());
        }
        this.B.setWifiAble(m1.Y(this.b));
        this.B.setNetworkType(m1.Z(this.b));
        if (aMapLocation.getLocationType() == 1 || GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            this.B.setNetUseTime(0);
        }
        if (eiVar != null) {
            this.B.setNetUseTime(eiVar.a());
        }
        this.B.setInstallHighDangerMockApp(J);
        aMapLocation.setLocationQualityReport(this.B);
        try {
            if (this.h) {
                p(aMapLocation, this.F);
                if (eiVar != null) {
                    eiVar.d(m1.B());
                }
                l1.i(this.b, aMapLocation, eiVar);
                l1.h(this.b, aMapLocation);
                T(aMapLocation.clone());
                w53.a(this.b).c(aMapLocation);
                w53.a(this.b).d();
            }
        } catch (Throwable th2) {
            j1.h(th2, "ALManager", "handlerLocation part2");
        }
        if (!this.r) {
            if (this.c.isOnceLocation()) {
                r0();
                f(14, null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void o0() {
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 >= 29 || i2 < 23 || m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") || m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) && ((i2 >= 31 || i2 < 29 || m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) && (i2 < 31 || m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") || m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")))) {
            if (this.c == null) {
                this.c = new AMapLocationClientOption();
            }
            if (!this.h) {
                this.h = true;
                int i3 = c.a[this.c.getLocationMode().ordinal()];
                long j2 = 0;
                if (i3 == 1) {
                    g(1027, null, 0);
                    g(1017, null, 0);
                    g(1016, null, 0);
                } else if (i3 != 2) {
                    if (i3 == 3) {
                        if (m1.f0(this.b)) {
                            d(1016);
                            g(1017, null, 0);
                            g(1026, null, 0);
                            return;
                        }
                        g(1027, null, 0);
                        g(1015, null, 0);
                        if (this.c.isGpsFirst() && this.c.isOnceLocation()) {
                            j2 = this.c.getGpsFirstTimeout();
                        }
                        g(1016, null, j2);
                    }
                } else if (m1.f0(this.b)) {
                    d(1016);
                    g(1017, null, 0);
                    g(1026, null, 0);
                } else {
                    d(1016);
                    g(1027, null, 0);
                    g(1015, null, 0);
                }
            }
        } else {
            q0();
        }
    }

    private void p(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        g(1014, bundle, 0);
    }

    private void q0() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.B == null) {
            this.B = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.B = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.B.setGPSSatellites(0);
        this.B.setLocationMode(this.c.getLocationMode());
        this.B.setWifiAble(m1.Y(this.b));
        this.B.setNetworkType(m1.Z(this.b));
        this.B.setNetUseTime(0);
        aMapLocation.setLocationQualityReport(this.B);
        l1.p(null, 2121);
        T(aMapLocation);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r0() {
        try {
            d(1025);
            e63 e63 = this.e;
            if (e63 != null) {
                e63.c();
            }
            c63 c63 = this.f;
            if (c63 != null) {
                c63.b();
            }
            d(1016);
            this.h = false;
        } catch (Throwable th) {
            j1.h(th, "ALManager", "stopLocation");
        }
    }

    private void s0() {
        eo E2 = E(new ej(true));
        if (n0()) {
            Bundle bundle = new Bundle();
            String str = (E2 == null || !(E2.getLocationType() == 2 || E2.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", j1.a(this.c));
            bundle.putString("isCacheLoc", str);
            f(0, bundle);
            if (this.h) {
                f(13, null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void t0() {
        try {
            if (H || (!this.v && !this.D)) {
                H = false;
                this.D = true;
                s0();
            } else {
                try {
                    if (this.v && !C() && !this.C) {
                        this.C = true;
                        v0();
                    }
                } catch (Throwable th) {
                    this.C = true;
                    j1.h(th, "ALManager", "doLBSLocation reStartService");
                }
                if (n0()) {
                    this.C = false;
                    Bundle bundle = new Bundle();
                    bundle.putBundle("optBundle", j1.a(this.c));
                    bundle.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!this.e.v()) {
                        f(1, bundle);
                    }
                }
            }
            try {
                if (!this.c.isOnceLocation()) {
                    u0();
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
    }

    private void u0() {
        if (this.c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            long j2 = 1000;
            if (this.c.getInterval() >= 1000) {
                j2 = this.c.getInterval();
            }
            g(1016, null, j2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void v0() {
        try {
            if (this.n == null) {
                this.n = new Messenger(this.d);
            }
            i(w0());
        } catch (Throwable unused) {
        }
    }

    private Intent w0() {
        String str;
        if (this.o == null) {
            this.o = new Intent(this.b, APSService.class);
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : l.j(this.b);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.o.putExtra("a", str);
        this.o.putExtra("b", l.g(this.b));
        this.o.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.o;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void x0() {
        try {
            StringBuilder sb = new StringBuilder();
            new ei().f("#2001");
            sb.append("模糊权限下不支持低功耗定位#2001");
            l1.p(null, 2153);
            eo eoVar = new eo("");
            eoVar.setErrorCode(20);
            eoVar.setLocationDetail(sb.toString());
            g0(eoVar);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "apsLocation:callback");
        }
    }

    private static void y(ej ejVar) {
        try {
            ejVar.x();
            ejVar.m(new AMapLocationClientOption().setNeedAddress(false));
            ejVar.g(true, new ei());
        } catch (Throwable th) {
            j1.h(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void y0() {
        int i2;
        Context context;
        l1 l1Var;
        this.e.u(this.c);
        this.f.q(this.c);
        if (this.h && !this.c.getLocationMode().equals(this.s)) {
            r0();
            o0();
        }
        this.s = this.c.getLocationMode();
        if (this.u != null) {
            if (this.c.isOnceLocation()) {
                l1Var = this.u;
                context = this.b;
                i2 = 0;
            } else {
                l1Var = this.u;
                context = this.b;
                i2 = 1;
            }
            l1Var.d(context, i2);
            this.u.j(this.b, this.c);
        }
    }

    private void z(ej ejVar, ei eiVar) {
        try {
            ejVar.j(this.b);
            ejVar.m(this.c);
            ejVar.s(eiVar);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "initApsBase");
        }
    }

    private boolean z0() {
        if (m1.c0(this.b)) {
            int i2 = -1;
            try {
                i2 = k1.f(((Application) this.b.getApplicationContext()).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i2 != 0) {
                return false;
            }
        }
        return true;
    }

    public final void B(boolean z2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z2);
            g(1024, bundle, 0);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final boolean C() {
        return this.g;
    }

    public final void G() {
        e eVar;
        try {
            if (this.x.getCacheCallBack() && (eVar = this.d) != null) {
                eVar.sendEmptyMessageDelayed(13, (long) this.x.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            g(1003, null, 0);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "startLocation");
        }
    }

    public final void K(AMapLocationListener aMapLocationListener) {
        try {
            g(1005, aMapLocationListener, 0);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "unRegisterLocationListener");
        }
    }

    public final void R() {
        try {
            g(1004, null, 0);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "stopLocation");
        }
    }

    public final void W() {
        try {
            i iVar = this.y;
            if (iVar != null) {
                iVar.h();
                this.y = null;
            }
            g(1011, null, 0);
            this.r = true;
        } catch (Throwable th) {
            j1.h(th, "ALManager", "onDestroy");
        }
    }

    public final AMapLocation c0() {
        AMapLocation aMapLocation = null;
        try {
            n1 n1Var = this.l;
            if (!(n1Var == null || (aMapLocation = n1Var.d()) == null)) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            j1.h(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    public final void e(int i2, Notification notification) {
        if (i2 != 0 && notification != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("i", i2);
                bundle.putParcelable("h", notification);
                g(1023, bundle, 0);
            } catch (Throwable th) {
                j1.h(th, "ALManager", "disableBackgroundLocation");
            }
        }
    }

    public final void f0() {
        try {
            i iVar = this.y;
            if (iVar != null) {
                iVar.h();
                this.y = null;
            }
        } catch (Throwable th) {
            j1.h(th, "ALManager", "stopAssistantLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void i0() {
        f(12, null);
        this.j = true;
        this.k = true;
        this.g = false;
        this.v = false;
        r0();
        l1 l1Var = this.u;
        if (l1Var != null) {
            l1Var.u(this.b);
        }
        w53.a(this.b).b();
        l1.c(this.b);
        e eVar = this.w;
        if (eVar != null) {
            eVar.s().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.A;
            if (serviceConnection != null) {
                this.b.unbindService(serviceConnection);
            }
        }
        try {
            if (this.G) {
                this.b.stopService(w0());
            }
        } catch (Throwable unused) {
        }
        this.G = false;
        ArrayList<AMapLocationListener> arrayList = this.i;
        if (arrayList != null) {
            arrayList.clear();
            this.i = null;
        }
        this.A = null;
        k0();
        b bVar = this.q;
        if (bVar != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    k1.b(bVar, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused2) {
                    this.q.quit();
                }
            } else {
                bVar.quit();
            }
        }
        this.q = null;
        e eVar2 = this.d;
        if (eVar2 != null) {
            eVar2.removeCallbacksAndMessages(null);
        }
        n1 n1Var = this.l;
        if (n1Var != null) {
            n1Var.e();
            this.l = null;
        }
    }

    public final void m(WebView webView) {
        if (this.y == null) {
            this.y = new i(this.b, webView);
        }
        this.y.c();
    }

    public final void q(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.x = aMapLocationClientOption.clone();
            g(1018, aMapLocationClientOption.clone(), 0);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "setLocationOption");
        }
    }

    public final void r(AMapLocationListener aMapLocationListener) {
        try {
            g(1002, aMapLocationListener, 0);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "setLocationListener");
        }
    }
}
