package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.taobao.weex.common.Constants;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONObject;
import tb.o53;
import tb.p53;

/* compiled from: Taobao */
public final class n1 {
    static o53 g;
    static j h;
    static long i;
    private Context a;
    String b = null;
    o53 c = null;
    o53 d = null;
    long e = 0;
    boolean f = false;

    public n1(Context context) {
        this.a = context.getApplicationContext();
    }

    private void g() {
        if (g == null || m1.B() - i > 180000) {
            o53 h2 = h();
            i = m1.B();
            if (h2 != null && m1.q(h2.a())) {
                g = h2;
            }
        }
    }

    private o53 h() {
        o53 o53;
        Throwable th;
        byte[] h2;
        byte[] h3;
        String str = null;
        if (this.a == null) {
            return null;
        }
        b();
        try {
            j jVar = h;
            if (jVar == null) {
                return null;
            }
            List f2 = jVar.f("_id=1", o53.class);
            if (f2 == null || f2.size() <= 0) {
                o53 = null;
            } else {
                o53 = (o53) f2.get(0);
                try {
                    byte[] g2 = p1.g(o53.g());
                    String str2 = (g2 == null || g2.length <= 0 || (h3 = e1.h(g2, this.b)) == null || h3.length <= 0) ? null : new String(h3, "UTF-8");
                    byte[] g3 = p1.g(o53.e());
                    if (g3 != null && g3.length > 0 && (h2 = e1.h(g3, this.b)) != null && h2.length > 0) {
                        str = new String(h2, "UTF-8");
                    }
                    o53.d(str);
                    str = str2;
                } catch (Throwable th2) {
                    th = th2;
                    j1.h(th, "LastLocationManager", "readLastFix");
                    return o53;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                AMapLocation aMapLocation = new AMapLocation("");
                j1.f(aMapLocation, new JSONObject(str));
                if (m1.G(aMapLocation)) {
                    o53.c(aMapLocation);
                }
            }
            return o53;
        } catch (Throwable th3) {
            th = th3;
            o53 = null;
            j1.h(th, "LastLocationManager", "readLastFix");
            return o53;
        }
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j) {
        Throwable th;
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            g();
            o53 o53 = g;
            if (o53 != null) {
                if (o53.a() != null) {
                    boolean z = false;
                    if (TextUtils.isEmpty(str)) {
                        long B = m1.B() - g.h();
                        if (B >= 0 && B <= j) {
                            z = true;
                        }
                        aMapLocation.setTrustedLevel(3);
                    } else {
                        z = m1.t(g.e(), str);
                        aMapLocation.setTrustedLevel(2);
                    }
                    if (!z) {
                        return aMapLocation;
                    }
                    AMapLocation a2 = g.a();
                    try {
                        a2.setLocationType(9);
                        a2.setFixLastLocation(true);
                        a2.setLocationDetail(aMapLocation.getLocationDetail());
                        return a2;
                    } catch (Throwable th2) {
                        th = th2;
                        aMapLocation = a2;
                        j1.h(th, "LastLocationManager", "fixLastLocation");
                        return aMapLocation;
                    }
                }
            }
            return aMapLocation;
        } catch (Throwable th3) {
            th = th3;
            j1.h(th, "LastLocationManager", "fixLastLocation");
            return aMapLocation;
        }
    }

    public final void b() {
        if (!this.f) {
            try {
                if (this.b == null) {
                    this.b = e1.b(MessageDigestAlgorithms.MD5, o.h0(this.a));
                }
                if (h == null) {
                    h = new j(this.a, j.c(p53.class));
                }
            } catch (Throwable th) {
                j1.h(th, "LastLocationManager", "<init>:DBOperation");
            }
            this.f = true;
        }
    }

    public final boolean c(AMapLocation aMapLocation, String str) {
        if (this.a != null && aMapLocation != null && m1.q(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            o53 o53 = new o53();
            o53.c(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                o53.d(null);
            } else {
                o53.d(str);
            }
            try {
                g = o53;
                i = m1.B();
                this.c = o53;
                o53 o532 = this.d;
                if ((o532 == null || m1.c(o532.a(), o53.a()) > 500.0f) && m1.B() - this.e > 30000) {
                    return true;
                }
            } catch (Throwable th) {
                j1.h(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final AMapLocation d() {
        g();
        o53 o53 = g;
        if (o53 != null && m1.q(o53.a())) {
            return g.a();
        }
        return null;
    }

    public final void e() {
        try {
            f();
            this.e = 0;
            this.f = false;
            this.c = null;
            this.d = null;
        } catch (Throwable th) {
            j1.h(th, "LastLocationManager", Constants.Event.SLOT_LIFECYCLE.DESTORY);
        }
    }

    public final void f() {
        o53 o53;
        String str;
        try {
            b();
            o53 o532 = this.c;
            if (o532 != null && m1.q(o532.a()) && h != null && (o53 = this.c) != this.d) {
                if (o53.h() == 0) {
                    String str2 = this.c.a().toStr();
                    String e2 = this.c.e();
                    this.d = this.c;
                    String str3 = null;
                    if (!TextUtils.isEmpty(str2)) {
                        String f2 = p1.f(e1.e(str2.getBytes("UTF-8"), this.b));
                        if (!TextUtils.isEmpty(e2)) {
                            str3 = p1.f(e1.e(e2.getBytes("UTF-8"), this.b));
                        }
                        str = str3;
                        str3 = f2;
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        o53 o533 = new o53();
                        o533.f(str3);
                        o533.b(m1.B());
                        o533.d(str);
                        h.i(o533, "_id=1");
                        this.e = m1.B();
                        o53 o534 = g;
                        if (o534 != null) {
                            o534.b(m1.B());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            j1.h(th, "LastLocationManager", "saveLastFix");
        }
    }
}
