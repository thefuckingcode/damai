package com.amap.api.mapcore.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: Taobao */
public final class kl {
    Context a = null;
    boolean b = false;
    String c = null;
    long d = 0;
    private js e = null;
    private lb f = null;
    private a g = null;
    private ju h = null;
    private ConnectivityManager i = null;
    private jw j = null;
    private StringBuilder k = new StringBuilder();
    private Inner_3dMap_locationOption l = null;
    private kj m = null;
    private final String n = "\"status\":\"0\"";
    private final String o = "</body></html>";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(kl klVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (kl.this.e != null) {
                                kl.this.e.c();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && kl.this.e != null) {
                            kl.this.e.d();
                        }
                    }
                } catch (Throwable th) {
                    jy.a(th, "MapNetLocation", "onReceive");
                }
            }
        }
    }

    public kl(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            kc.b(applicationContext);
            a(this.a);
            this.l = new Inner_3dMap_locationOption();
            if (this.e == null) {
                js jsVar = new js(this.a, (WifiManager) kc.a(this.a, "wifi"));
                this.e = jsVar;
                jsVar.a(this.b);
            }
            if (this.f == null) {
                this.f = new lb(this.a);
            }
            if (this.h == null) {
                gd.a(this.a);
                this.h = ju.a(this.a);
            }
            if (this.i == null) {
                this.i = (ConnectivityManager) kc.a(this.a, "connectivity");
            }
            this.j = new jw();
            c();
        } catch (Throwable th) {
            jy.a(th, "MapNetLocation", "<init>");
        }
    }

    private static kj a(kj kjVar) {
        return kf.a().a(kjVar);
    }

    private void a(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(gn.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.b = true;
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(long j2) {
        if (kc.b() - j2 < 800) {
            long j3 = 0;
            if (kn.a(this.m)) {
                j3 = kc.a() - this.m.getTime();
            }
            if (j3 <= 10000) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        try {
            if (this.g == null) {
                this.g = new a(this, (byte) 0);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.a.registerReceiver(this.g, intentFilter);
            this.e.b(false);
            this.f.b();
        } catch (Throwable th) {
            jy.a(th, "MapNetLocation", "initBroadcastListener");
        }
    }

    private kj d() throws Exception {
        String str;
        StringBuilder sb;
        String str2 = "";
        kj kjVar = new kj(str2);
        js jsVar = this.e;
        if (jsVar == null || !jsVar.g()) {
            try {
                if (this.j == null) {
                    this.j = new jw();
                }
                this.j.a(this.a, this.l.isNeedAddress(), this.l.isOffset(), this.f, this.e, this.i, this.c);
                km kmVar = new km();
                byte[] bArr = null;
                try {
                    try {
                        ik a2 = this.h.a(this.h.a(this.a, this.j.a(), jy.a(), jy.b()));
                        if (a2 != null) {
                            bArr = a2.a;
                            str2 = a2.c;
                        }
                        if (bArr == null || bArr.length == 0) {
                            kjVar.setErrorCode(4);
                            this.k.append("please check the network");
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb2 = this.k;
                                sb2.append(" #csid:" + str2);
                            }
                            kjVar.setLocationDetail(this.k.toString());
                            return kjVar;
                        }
                        String str3 = new String(bArr, "UTF-8");
                        if (str3.contains("\"status\":\"0\"")) {
                            return kmVar.a(str3, this.a, a2);
                        }
                        if (str3.contains("</body></html>")) {
                            kjVar.setErrorCode(5);
                            js jsVar2 = this.e;
                            if (jsVar2 == null || !jsVar2.a(this.i)) {
                                sb = this.k;
                                str = "request may be intercepted";
                            } else {
                                sb = this.k;
                                str = "make sure you are logged in to the network";
                            }
                            sb.append(str);
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb3 = this.k;
                                sb3.append(" #csid:" + str2);
                            }
                            kjVar.setLocationDetail(this.k.toString());
                            return kjVar;
                        }
                        byte[] a3 = jt.a(bArr);
                        if (a3 == null) {
                            kjVar.setErrorCode(5);
                            this.k.append("decrypt response data error");
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb4 = this.k;
                                sb4.append(" #csid:" + str2);
                            }
                            kjVar.setLocationDetail(this.k.toString());
                            return kjVar;
                        }
                        kj a4 = kmVar.a(a3);
                        this.c = a4.a();
                        if (a4.getErrorCode() != 0) {
                            if (!TextUtils.isEmpty(str2)) {
                                a4.setLocationDetail(a4.getLocationDetail() + " #csid:" + str2);
                            }
                            return a4;
                        } else if (kn.a(a4)) {
                            a4.e();
                            if (a4.getErrorCode() == 0 && a4.getLocationType() == 0) {
                                if ("-5".equals(a4.d()) || "1".equals(a4.d()) || "2".equals(a4.d()) || "14".equals(a4.d()) || "24".equals(a4.d()) || "-1".equals(a4.d())) {
                                    a4.setLocationType(5);
                                } else {
                                    a4.setLocationType(6);
                                }
                                this.k.append(a4.d());
                                if (!TextUtils.isEmpty(str2)) {
                                    StringBuilder sb5 = this.k;
                                    sb5.append(" #csid:" + str2);
                                }
                                a4.setLocationDetail(this.k.toString());
                            }
                            return a4;
                        } else {
                            String b2 = a4.b();
                            a4.setErrorCode(6);
                            StringBuilder sb6 = this.k;
                            StringBuilder sb7 = new StringBuilder("location faile retype:");
                            sb7.append(a4.d());
                            sb7.append(" rdesc:");
                            if (b2 == null) {
                                b2 = "null";
                            }
                            sb7.append(b2);
                            sb6.append(sb7.toString());
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb8 = this.k;
                                sb8.append(" #csid:" + str2);
                            }
                            a4.setLocationDetail(this.k.toString());
                            return a4;
                        }
                    } catch (Throwable th) {
                        jy.a(th, "MapNetLocation", "getApsLoc req");
                        kjVar.setErrorCode(4);
                        this.k.append("please check the network");
                        kjVar.setLocationDetail(this.k.toString());
                        return kjVar;
                    }
                } catch (Throwable th2) {
                    jy.a(th2, "MapNetLocation", "getApsLoc buildV4Dot2");
                    kjVar.setErrorCode(3);
                    StringBuilder sb9 = this.k;
                    sb9.append("buildV4Dot2 error " + th2.getMessage());
                    kjVar.setLocationDetail(this.k.toString());
                    return kjVar;
                }
            } catch (Throwable th3) {
                jy.a(th3, "MapNetLocation", "getApsLoc");
                StringBuilder sb10 = this.k;
                sb10.append("get parames error:" + th3.getMessage());
                kjVar.setErrorCode(3);
                kjVar.setLocationDetail(this.k.toString());
                return kjVar;
            }
        } else {
            kjVar.setErrorCode(15);
            return kjVar;
        }
    }

    public final Inner_3dMap_location a() {
        if (this.k.length() > 0) {
            StringBuilder sb = this.k;
            sb.delete(0, sb.length());
        }
        if (a(this.d) && kn.a(this.m)) {
            return this.m;
        }
        this.d = kc.b();
        if (this.a == null) {
            this.k.append("context is null");
            Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
            inner_3dMap_location.setErrorCode(1);
            inner_3dMap_location.setLocationDetail(this.k.toString());
            return inner_3dMap_location;
        }
        try {
            this.f.b();
        } catch (Throwable th) {
            jy.a(th, "MapNetLocation", "getLocation getCgiListParam");
        }
        try {
            this.e.b(true);
        } catch (Throwable th2) {
            jy.a(th2, "MapNetLocation", "getLocation getScanResultsParam");
        }
        try {
            kj d2 = d();
            this.m = d2;
            this.m = a(d2);
        } catch (Throwable th3) {
            jy.a(th3, "MapNetLocation", "getLocation getScanResultsParam");
        }
        return this.m;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|(1:2)|3|4|5|6|(1:8)(1:9)|10|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033 A[Catch:{ all -> 0x0037 }] */
    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.l = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.l = new Inner_3dMap_locationOption();
        }
        js jsVar = this.e;
        this.l.isWifiActiveScan();
        jsVar.c(this.l.isWifiScan());
        this.h.a(this.l.getHttpTimeOut(), !this.l.getLocationProtocol().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS));
    }

    public final void b() {
        a aVar;
        this.b = false;
        this.c = null;
        try {
            Context context = this.a;
            if (!(context == null || (aVar = this.g) == null)) {
                context.unregisterReceiver(aVar);
            }
            lb lbVar = this.f;
            if (lbVar != null) {
                lbVar.h();
            }
            js jsVar = this.e;
            if (jsVar != null) {
                jsVar.h();
            }
            this.g = null;
        } catch (Throwable unused) {
            this.g = null;
        }
    }
}
