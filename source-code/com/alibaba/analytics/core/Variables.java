package com.alibaba.analytics.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.analytics.core.config.AudidConfigListener;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.config.UTDefaultConfMgr;
import com.alibaba.analytics.core.config.UTOrangeConfMgr;
import com.alibaba.analytics.core.config.b;
import com.alibaba.analytics.core.config.d;
import com.alibaba.analytics.core.config.e;
import com.alibaba.analytics.core.config.f;
import com.alibaba.analytics.core.logbuilder.GoogleAdvertisingIdClient;
import com.alibaba.analytics.core.logbuilder.TimeStampAdjustMgr;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.core.sync.UploadMode;
import com.alibaba.analytics.core.sync.g;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.sample.a;
import com.alibaba.wireless.security.aopsdk.replace.com.alibaba.openid.OpenDeviceId;
import com.taobao.orange.OrangeConfig;
import com.uc.webview.export.extension.UCCore;
import com.ut.mini.UTAnalyticsDelegate;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import tb.gj2;
import tb.j82;
import tb.lq2;
import tb.mq2;
import tb.pm2;
import tb.q22;
import tb.rm2;
import tb.sr2;
import tb.t6;
import tb.tp;
import tb.tq2;
import tb.u9;
import tb.wo;
import tb.xq2;
import tb.yq2;
import tb.zc2;
import tb.zf2;

/* compiled from: Taobao */
public class Variables {
    public static final Variables s_instance = new Variables();
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private String D = null;
    private boolean E = false;
    private String a;
    private Context b = null;
    private String c = null;
    private volatile IUTRequestAuthentication d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private boolean m = false;
    private String n = null;
    private Map<String, String> o = null;
    private boolean p = false;
    private volatile boolean q = false;
    private tp r = null;
    private d s = null;
    private volatile String t = null;
    private volatile boolean u = false;
    private String v = "";
    private long w = 0;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;

    private void E() {
        Context context = this.b;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("UTRealTimeDebug", 0);
            long j2 = sharedPreferences.getLong("debug_date", 0);
            Logger.f("", "debugDate", Long.valueOf(j2));
            if (System.currentTimeMillis() - j2 <= 14400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("debug_api_url", sharedPreferences.getString("debug_api_url", ""));
                hashMap.put("debug_key", sharedPreferences.getString("debug_key", ""));
                a(hashMap);
            }
        }
    }

    public static boolean L() {
        return true;
    }

    private void Z(String str) {
        this.a = str;
    }

    private void a(Map<String, String> map) {
        Logger.d();
        if ("0".equalsIgnoreCase(SystemConfigMgr.i().h("real_time_debug"))) {
            Logger.v("Variables", "Server Config turn off RealTimeDebug Mode!");
        } else if (b.a()) {
            Logger.v("Variables", "Server Config(disable_ut_debug) turn off RealTimeDebug Mode!");
        } else if (map != null && map.containsKey("debug_api_url") && map.containsKey("debug_key")) {
            String str = map.get("debug_key");
            if (!zf2.f(map.get("debug_api_url")) && !zf2.f(str)) {
                a0();
                U(str);
            }
            if (map.containsKey("debug_sampling_option")) {
                V();
            }
            T(true);
            g.p().t(UploadMode.REALTIME);
        }
    }

    private void f0(String str) {
        this.k = str;
        if (!zf2.f(str)) {
            this.l = str;
        }
    }

    private void g0(String str) {
        this.i = str;
        if (!zf2.f(str)) {
            this.j = str;
        }
    }

    private void h0(String str) {
        this.g = str;
        if (!zf2.f(str)) {
            this.h = str;
        }
    }

    private void i0(String str) {
        Context context = this.b;
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                if (TextUtils.isEmpty(str)) {
                    edit.putString("_openid", null);
                } else {
                    edit.putString("_openid", new String(u9.c(str.getBytes("UTF-8"), 2)));
                }
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void j0(Map<String, String> map) {
        if (this.b != null) {
            Logger.e("", map);
            SharedPreferences.Editor edit = this.b.getSharedPreferences("UTRealTimeDebug", 0).edit();
            if (map == null || !map.containsKey("debug_store")) {
                edit.putLong("debug_date", 0);
            } else {
                edit.putString("debug_api_url", map.get("debug_api_url"));
                edit.putString("debug_key", map.get("debug_key"));
                edit.putLong("debug_date", System.currentTimeMillis());
            }
            edit.commit();
        }
    }

    private void k0(String str) {
        Context context;
        if (!zf2.f(str) && (context = this.b) != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_luid", new String(u9.c(str.getBytes("UTF-8"), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void l0(String str) {
        Context context = this.b;
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                if (TextUtils.isEmpty(str)) {
                    edit.putString("_usersite", null);
                } else {
                    edit.putString("_usersite", new String(u9.c(str.getBytes("UTF-8"), 2)));
                }
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void m0(String str) {
        Context context;
        if (!zf2.f(str) && (context = this.b) != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_lun", new String(u9.c(str.getBytes("UTF-8"), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Variables n() {
        return s_instance;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n0() {
        try {
            Map<String, String> e2 = t6.e(this.b);
            if (e2 != null && e2.size() > 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(LogField.EVENTID.toString(), "1021");
                hashMap.putAll(e2);
                UTAnalyticsDelegate.getInstance().transferLog(hashMap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void o() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("UTCommon", 0);
        String string = sharedPreferences.getString("_lun", "");
        if (!zf2.f(string)) {
            try {
                this.h = new String(u9.a(string.getBytes(), 2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        String string2 = sharedPreferences.getString("_luid", "");
        if (!zf2.f(string2)) {
            try {
                this.j = new String(u9.a(string2.getBytes(), 2), "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        String string3 = sharedPreferences.getString("_openid", "");
        if (!zf2.f(string3)) {
            try {
                this.a = new String(u9.a(string3.getBytes(), 2), "UTF-8");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        String string4 = sharedPreferences.getString("_usersite", "");
        if (!zf2.f(string4)) {
            try {
                this.l = new String(u9.a(string4.getBytes(), 2), "UTF-8");
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void w0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g0(null);
            Z(null);
        } else if (!TextUtils.isEmpty(str2) || !str.equals(this.i)) {
            g0(str);
            Z(str2);
            k0(str);
            i0(str2);
        }
    }

    public String A() {
        return this.k;
    }

    public String B() {
        return this.i;
    }

    public String C() {
        return this.g;
    }

    public synchronized void D(Application application) {
        Context applicationContext = application.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            Logger.v("Variables", "AnalyticsImp init failed, context is null");
            return;
        }
        Logger.m("Variables", UCCore.LEGACY_EVENT_INIT, Boolean.valueOf(this.q));
        if (!this.q) {
            new Thread("UtOaid") {
                /* class com.alibaba.analytics.core.Variables.AnonymousClass1 */

                public void run() {
                    try {
                        String oaid = OpenDeviceId.getOAID(Variables.this.b);
                        if (!TextUtils.isEmpty(oaid) && TextUtils.isEmpty(Variables.this.v)) {
                            Variables.this.v = oaid;
                        }
                        Logger.f("Variables", "getOAID", Variables.this.v);
                    } catch (Throwable unused) {
                    }
                }
            }.start();
            new Thread("UtGaid") {
                /* class com.alibaba.analytics.core.Variables.AnonymousClass2 */

                public void run() {
                    try {
                        GoogleAdvertisingIdClient.b(Variables.this.b);
                        Logger.f("Variables", "initAdvertisingIdInfo");
                    } catch (Throwable unused) {
                    }
                }
            }.start();
            try {
                sr2.b().d(this.b);
            } catch (Throwable th) {
                Logger.h(null, th, new Object[0]);
            }
            try {
                wo.b().c();
            } catch (Throwable th2) {
                Logger.h(null, th2, new Object[0]);
            }
            try {
                j82.a().b();
            } catch (Throwable th3) {
                Logger.h(null, th3, new Object[0]);
            }
            o();
            new q22(this.b, "ut.db").a();
            this.r = new tp(this.b, "ut.db");
            NetworkUtil.r(this.b);
            if (OrangeConfig.class != 0) {
                this.s = new UTOrangeConfMgr();
            } else {
                this.s = new UTDefaultConfMgr();
            }
            this.s.g(yq2.d());
            this.s.g(new lq2());
            this.s.g(a.h());
            this.s.g(xq2.g());
            try {
                this.s.g(SystemConfigMgr.i());
                pm2.b().e();
                SystemConfigMgr.i().l(com.alibaba.analytics.core.config.a.KEY, new com.alibaba.analytics.core.config.a());
                SystemConfigMgr.i().l(AudidConfigListener.KEY, new AudidConfigListener());
                SystemConfigMgr.i().l(f.KEY, new f());
                SystemConfigMgr.i().l(b.KEY, new b());
                SystemConfigMgr.i().l(e.KEY, e.d());
                rm2.b().f();
            } catch (Throwable unused) {
            }
            this.s.l();
            TimeStampAdjustMgr.k().l();
            com.alibaba.appmonitor.delegate.a.d(application);
            UTAnalyticsDelegate.getInstance().initUT(application);
            E();
            g.p().q(this.b);
            gj2.c().f(new Runnable() {
                /* class com.alibaba.analytics.core.Variables.AnonymousClass3 */

                public void run() {
                    Variables.this.n0();
                }
            });
            this.q = true;
            Logger.m("Variables", UCCore.LEGACY_EVENT_INIT, Boolean.valueOf(this.q));
        } else {
            mq2.a();
        }
    }

    public synchronized boolean F() {
        return this.x;
    }

    public boolean G() {
        return this.u;
    }

    public boolean H() {
        if (this.C) {
            return this.B;
        }
        Context j2 = j();
        if (j2 == null) {
            return false;
        }
        if ("1".equalsIgnoreCase(t6.f(j2, "package_type"))) {
            this.B = true;
            this.C = true;
        }
        return this.B;
    }

    public boolean I() {
        return this.A;
    }

    public synchronized boolean J() {
        return this.y;
    }

    public boolean K() {
        return this.q;
    }

    public synchronized boolean M() {
        return this.m;
    }

    public synchronized boolean N() {
        return this.z;
    }

    public boolean O() {
        return false;
    }

    public synchronized void P() {
        this.m = false;
    }

    public synchronized void Q(boolean z2) {
        this.x = z2;
    }

    public void R(String str) {
        this.f = str;
    }

    public void S(String str) {
        Logger.f(null, str, str);
        this.e = str;
    }

    public void T(boolean z2) {
        Logger.s(z2);
    }

    public synchronized void U(String str) {
        this.n = str;
    }

    public synchronized void V() {
        this.p = true;
        com.alibaba.appmonitor.delegate.a.a = true;
    }

    public void W(boolean z2) {
        this.A = z2;
    }

    public synchronized void X(boolean z2) {
        this.y = z2;
    }

    public void Y(long j2) {
        this.w = j2;
    }

    public synchronized void a0() {
        this.m = true;
    }

    public synchronized void b0(boolean z2) {
        this.z = z2;
    }

    public void c0(IUTRequestAuthentication iUTRequestAuthentication) {
        this.d = iUTRequestAuthentication;
        if (iUTRequestAuthentication != null) {
            this.c = iUTRequestAuthentication.getAppkey();
        }
    }

    public synchronized void d0(Map<String, String> map) {
        this.o = map;
    }

    public void e0(String str) {
        this.t = str;
    }

    public String f() {
        Map<String, String> b2;
        if (TextUtils.isEmpty(this.f) && (b2 = tq2.b(j())) != null) {
            this.f = b2.get(LogField.APPVERSION);
        }
        return this.f;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        if (TextUtils.isEmpty(this.e)) {
            String a2 = zc2.a(j(), "channel");
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        return this.e;
    }

    public d i() {
        return this.s;
    }

    public Context j() {
        return this.b;
    }

    public tp k() {
        return this.r;
    }

    public synchronized String l() {
        return this.n;
    }

    public synchronized boolean m() {
        if (b.a()) {
            return false;
        }
        return this.p;
    }

    @Deprecated
    public void o0() {
    }

    public String p() {
        return this.h;
    }

    public void p0() {
        P();
        U(null);
        g.p().t(UploadMode.INTERVAL);
        j0(null);
        this.u = false;
    }

    public String q() {
        return this.l;
    }

    public void q0() {
    }

    public String r() {
        return this.j;
    }

    public void r0() {
        T(true);
    }

    public long s() {
        return this.w;
    }

    public void s0(Map<String, String> map) {
        a(map);
        j0(map);
    }

    public String t() {
        return this.v;
    }

    public void t0() {
    }

    public String u() {
        return this.a;
    }

    @Deprecated
    public void u0(String str, String str2, String str3) {
        h0(str);
        w0(str2, str3);
        m0(str);
    }

    public String v() {
        if (this.E) {
            return this.D;
        }
        Context j2 = j();
        if (j2 == null) {
            return null;
        }
        String f2 = t6.f(j2, "build_id");
        this.D = f2;
        this.E = true;
        return f2;
    }

    public void v0(String str, String str2, String str3, String str4) {
        h0(str);
        f0(str4);
        w0(str2, str3);
        m0(str);
        l0(str4);
    }

    public IUTRequestAuthentication w() {
        return this.d;
    }

    public synchronized Map<String, String> x() {
        return this.o;
    }

    public String y() {
        return this.t;
    }

    public String z() {
        if (this.t == null) {
            return null;
        }
        return "" + this.t.hashCode();
    }
}
