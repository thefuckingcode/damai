package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.maps.AMapException;
import com.loc.bj;
import com.loc.bl;
import com.taobao.update.datasource.mtop.MtopUpdater;
import com.taobao.weex.annotation.JSMethod;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import com.youku.live.livesdk.preloader.Preloader;
import io.flutter.stat.StatServices;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.o70;
import tb.p23;
import tb.q23;
import tb.t13;
import tb.v13;
import tb.y13;

/* compiled from: Taobao */
public final class m {
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ArrayList<bj.a> B = new ArrayList<>();
    private static volatile boolean C = false;
    private static Queue<bj.c> D = new LinkedList();
    public static int a = -1;
    public static String b = "";
    private static String c = "6";
    private static String d = "4";
    private static String e = "9";
    private static String f = "8";
    public static Context g = null;
    private static volatile boolean h = true;
    private static Vector<e> i = new Vector<>();
    private static Map<String, Integer> j = new HashMap();
    private static String k = null;
    private static long l = 0;
    public static volatile boolean m = false;
    private static volatile ConcurrentHashMap<String, Long> n = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, Long> o = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, d> p = new ConcurrentHashMap<>(8);
    private static boolean q = false;
    public static int r = 5000;
    public static boolean s = true;
    public static boolean t = false;
    private static int u = 3;
    public static boolean v = true;
    public static boolean w = false;
    private static int x = 3;
    public static boolean y = false;
    private static ConcurrentHashMap<String, Boolean> z = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: Taobao */
    public static class b {
        public long a = 0;
        public JSONObject b;
        public a c;
        private boolean d;

        /* compiled from: Taobao */
        public static class a {
            public boolean a;
            public JSONObject b;
        }

        /* renamed from: com.loc.m$b$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static class C0182b {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c extends p23 {
        private String o;
        private Map<String, String> p = null;
        private String q;
        private String r;
        private String s;

        c(Context context, u1 u1Var, String str, String str2, String str3, String str4) {
            super(context, u1Var);
            this.o = str;
            this.q = str2;
            this.r = str3;
            this.s = str4;
            f(bl.c.HTTPS);
            d(bl.a.FIX);
        }

        private static String U(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // tb.p23
        public final byte[] O() {
            return null;
        }

        @Override // tb.p23
        public final byte[] P() {
            String g0 = o.g0(this.l);
            if (!TextUtils.isEmpty(g0)) {
                g0 = r1.a(new StringBuilder(g0).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.o) ? "" : this.o);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.m.a());
            hashMap.put("version", this.m.e());
            hashMap.put("output", Preloader.KEY_JSON);
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", g0);
            hashMap.put("manufacture", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
            Map<String, String> map = this.p;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.p);
            }
            hashMap.put("abitype", v1.d(this.l));
            hashMap.put("ext", this.m.g());
            return v1.p(v1.f(hashMap));
        }

        /* access modifiers changed from: protected */
        @Override // tb.p23
        public final String Q() {
            return LiveFullInfo.VER;
        }

        @Override // com.loc.bl
        public final Map<String, String> b() {
            if (TextUtils.isEmpty(this.s)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.s);
            return hashMap;
        }

        @Override // com.loc.bl
        public final String j() {
            return U("https://restsdk.amap.com/v3/iasdkauth", this.q);
        }

        @Override // com.loc.bl, tb.l63
        public final String m() {
            return U("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.r);
        }

        /* access modifiers changed from: protected */
        @Override // com.loc.bl
        public final String s() {
            return !TextUtils.isEmpty(this.s) ? this.s : super.s();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d {
        u1 a;
        String b;
        a c;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static class e {
        private String a;
        private String b;
        private AtomicInteger c;

        public e(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = new AtomicInteger(i);
        }

        public static e d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.b = str;
        }

        public final String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.a);
                jSONObject.put("f", this.b);
                jSONObject.put("h", this.c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* compiled from: Taobao */
    public static class f {
        public static boolean a = true;
        public static boolean b = false;
        public static boolean c = true;
        public static int d;
        public static boolean e;
        public static int f;
    }

    private static synchronized void A(String str, long j2) {
        synchronized (m.class) {
            try {
                if (p != null) {
                    if (p.containsKey(str)) {
                        if (n == null) {
                            n = new ConcurrentHashMap<>(8);
                        }
                        n.put(str, Long.valueOf(j2));
                        Context context = g;
                        if (context != null) {
                            SharedPreferences.Editor b2 = y13.b(context, "open_common");
                            y13.h(b2, str, j2);
                            y13.e(b2);
                        }
                    }
                }
            } catch (Throwable th) {
                v13.e(th, "at", "ucut");
            }
        }
    }

    public static synchronized void B(String str, boolean z2) {
        synchronized (m.class) {
            m(str, z2, null, null, null);
        }
    }

    public static boolean C() {
        Integer num;
        Context context = g;
        if (context == null) {
            return false;
        }
        String f0 = o.f0(context);
        return !TextUtils.isEmpty(f0) && (num = j.get(f0.toUpperCase())) != null && num.intValue() == 2;
    }

    public static synchronized long D(String str) {
        synchronized (m.class) {
            try {
                if (n == null) {
                    n = new ConcurrentHashMap<>(8);
                }
                if (n.containsKey(str)) {
                    return n.get(str).longValue();
                }
            } catch (Throwable th) {
                v13.e(th, "at", "glcut");
            }
            return 0;
        }
    }

    private static void E(Context context) {
        if (context != null) {
            s = y13.k(context, "open_common", "a13", true);
            v = y13.k(context, "open_common", "a6", true);
            t = y13.k(context, "open_common", "a7", false);
            r = y13.a(context, "open_common", "a8", 5000);
            u = y13.a(context, "open_common", "a9", 3);
            w = y13.k(context, "open_common", "a10", false);
            x = y13.a(context, "open_common", "a11", 3);
            y = y13.k(context, "open_common", "a12", false);
        }
    }

    public static void F(bj.c cVar) {
        if (cVar != null && y) {
            synchronized (D) {
                D.offer(cVar);
                bj.f();
            }
        }
    }

    public static boolean G() {
        Integer num;
        Context context = g;
        if (context == null) {
            return false;
        }
        String f0 = o.f0(context);
        return !TextUtils.isEmpty(f0) && (num = j.get(f0.toUpperCase())) != null && num.intValue() >= 2;
    }

    public static void H() {
        try {
            e b2 = b(g, "IPV6_CONFIG_NAME", "open_common");
            String c2 = v1.c(System.currentTimeMillis(), "yyyyMMdd");
            if (!c2.equals(b2.b)) {
                b2.c(c2);
                b2.c.set(0);
            }
            b2.c.incrementAndGet();
            i(g, "IPV6_CONFIG_NAME", "open_common", b2);
        } catch (Throwable unused) {
        }
    }

    private static void I(Context context) {
        try {
            if (!q) {
                t13.e = y13.k(context, "open_common", "a4", true);
                t13.k = y13.k(context, "open_common", "a5", true);
                q = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean J(String str) {
        e b2;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (!s) {
                return false;
            }
            if (!(z.get(str) == null)) {
                return false;
            }
            Context context = g;
            return context == null || (b2 = b(context, w(str, "a14"), "open_common")) == null || b2.a() < u;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void K() {
        if (!m) {
            try {
                Context context = g;
                if (context != null) {
                    m = true;
                    q1.a().c(context);
                    x(context);
                    E(context);
                    f.a = y13.k(context, "open_common", "ucf", f.a);
                    f.b = y13.k(context, "open_common", "fsv2", f.b);
                    f.c = y13.k(context, "open_common", "usc", f.c);
                    f.d = y13.a(context, "open_common", "umv", f.d);
                    f.e = y13.k(context, "open_common", "ust", f.e);
                    f.f = y13.a(context, "open_common", "ustv", f.f);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean L(String str) {
        e b2;
        try {
            if (TextUtils.isEmpty(str) || !w) {
                return false;
            }
            if (!(A.get(str) == null)) {
                return false;
            }
            Context context = g;
            return context == null || (b2 = b(context, w(str, "a15"), "open_common")) == null || b2.a() < x;
        } catch (Throwable unused) {
        }
    }

    public static bj.a M() {
        if (C) {
            return null;
        }
        synchronized (B) {
            if (C) {
                return null;
            }
            Collections.sort(B);
            if (B.size() <= 0) {
                return null;
            }
            bj.a a2 = B.get(0).clone();
            C = true;
            return a2;
        }
    }

    public static bj.c N() {
        synchronized (D) {
            bj.c poll = D.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    private static void P() {
        Map<String, Integer> map;
        String str;
        Integer valueOf;
        try {
            Context context = g;
            if (context != null) {
                String f0 = o.f0(context);
                if (!TextUtils.isEmpty(k) && !TextUtils.isEmpty(f0) && k.equals(f0) && System.currentTimeMillis() - l < DateUtils.MILLIS_PER_MINUTE) {
                    return;
                }
                if (!TextUtils.isEmpty(f0)) {
                    k = f0;
                }
            } else if (System.currentTimeMillis() - l < 10000) {
                return;
            }
            l = System.currentTimeMillis();
            j.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i2 = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!u((Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!u(inet4Address) && !inet4Address.getHostAddress().startsWith(v1.v("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            map = j;
                            str = "WIFI";
                            valueOf = Integer.valueOf(i2);
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            map = j;
                            str = "MOBILE";
                            valueOf = Integer.valueOf(i2);
                        }
                        map.put(str, valueOf);
                    }
                }
            }
        } catch (Throwable th) {
            v13.e(th, "at", "ipstack");
        }
    }

    public static b a(Context context, u1 u1Var, String str, String str2, String str3, String str4) {
        return v(context, u1Var, str, str2, str3, str4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    private static synchronized e b(Context context, String str, String str2) {
        e eVar;
        synchronized (m.class) {
            if (!TextUtils.isEmpty(str)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= i.size()) {
                        break;
                    }
                    eVar = i.get(i2);
                    if (eVar != null && str.equals(eVar.a)) {
                        break;
                    }
                    i2++;
                }
                if (eVar == null) {
                    return eVar;
                }
                if (context == null) {
                    return null;
                }
                e d2 = e.d(y13.o(context, str2, str, ""));
                String c2 = v1.c(System.currentTimeMillis(), "yyyyMMdd");
                if (d2 == null) {
                    d2 = new e(str, c2, 0);
                }
                if (!c2.equals(d2.b)) {
                    d2.c(c2);
                    d2.c.set(0);
                }
                i.add(d2);
                return d2;
            }
            eVar = null;
            if (eVar == null) {
            }
        }
    }

    public static void c(Context context) {
        if (context != null) {
            g = context.getApplicationContext();
        }
    }

    private static void d(Context context, u1 u1Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", u1Var.a());
        hashMap.put("amap_sdk_version", u1Var.f());
        String jSONObject = new JSONObject(hashMap).toString();
        if (!TextUtils.isEmpty(jSONObject)) {
            try {
                d0 d0Var = new d0(context, StatServices.CATEGORY, "2.0", "O001");
                d0Var.a(jSONObject);
                bs.d(d0Var, context);
            } catch (k unused) {
            }
        }
    }

    public static synchronized void e(Context context, u1 u1Var, String str, a aVar) {
        synchronized (m.class) {
            if (context != null && u1Var != null) {
                try {
                    if (g == null) {
                        g = context.getApplicationContext();
                    }
                    String a2 = u1Var.a();
                    if (!TextUtils.isEmpty(a2)) {
                        k(u1Var);
                        if (p == null) {
                            p = new ConcurrentHashMap<>(8);
                        }
                        if (o == null) {
                            o = new ConcurrentHashMap<>(8);
                        }
                        if (n == null) {
                            n = new ConcurrentHashMap<>(8);
                        }
                        if (!p.containsKey(a2)) {
                            d dVar = new d((byte) 0);
                            dVar.a = u1Var;
                            dVar.b = str;
                            dVar.c = aVar;
                            p.put(a2, dVar);
                            n.put(a2, Long.valueOf(y13.n(g, "open_common", a2)));
                            I(g);
                        }
                    }
                } catch (Throwable th) {
                    v13.e(th, "at", "rglc");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01fd A[SYNTHETIC, Splitter:B:100:0x01fd] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x029e A[SYNTHETIC, Splitter:B:125:0x029e] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02b6 A[SYNTHETIC, Splitter:B:131:0x02b6] */
    /* JADX WARNING: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    private static void f(Context context, u1 u1Var, String str, b bVar, JSONObject jSONObject) throws JSONException {
        String str2;
        String str3;
        String str4;
        Context context2;
        Throwable th;
        boolean t2;
        String[] strArr;
        b.a aVar = new b.a();
        aVar.a = false;
        bVar.c = aVar;
        try {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String str5 = split[i2];
                    if (jSONObject.has(str5)) {
                        strArr = split;
                        bVar.b.putOpt(str5, jSONObject.get(str5));
                    } else {
                        strArr = split;
                    }
                    i2++;
                    split = strArr;
                }
            }
        } catch (Throwable th2) {
            v13.e(th2, "at", "co");
        }
        if (v1.n(jSONObject, "16H")) {
            try {
                bVar.d = t(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (Throwable th3) {
                v13.e(th3, "AuthConfigManager", "load 16H");
            }
        }
        if (v1.n(jSONObject, "11K")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11K");
                aVar.a = t(jSONObject2.getString("able"), false);
                if (jSONObject2.has("off")) {
                    aVar.b = jSONObject2.getJSONObject("off");
                }
            } catch (Throwable th4) {
                v13.e(th4, "AuthConfigManager", "load 11K");
            }
        }
        if (v1.n(jSONObject, "145")) {
            try {
                jSONObject.getJSONObject("145");
            } catch (Throwable th5) {
                v13.e(th5, "AuthConfigManager", "load 145");
            }
        }
        if (v1.n(jSONObject, "14D")) {
            try {
                jSONObject.getJSONObject("14D");
            } catch (Throwable th6) {
                v13.e(th6, "AuthConfigManager", "load 14D");
            }
        }
        if (v1.n(jSONObject, "151")) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("151");
                new b.C0182b();
                if (jSONObject3 != null) {
                    t(jSONObject3.optString("able"), false);
                }
            } catch (Throwable th7) {
                v13.e(th7, "AuthConfigManager", "load 151");
            }
        }
        if (v1.n(jSONObject, "17S")) {
            try {
                JSONObject jSONObject4 = jSONObject.getJSONObject("17S");
                if (!(jSONObject4 == null || (t2 = t(jSONObject4.optString("able"), false)) == h)) {
                    h = t2;
                    if (context != null) {
                        SharedPreferences.Editor b2 = y13.b(context, "open_common");
                        y13.j(b2, "a2", t2);
                        y13.e(b2);
                    }
                }
                if (jSONObject4 != null) {
                    boolean t3 = t(jSONObject4.optString("static_enable"), true);
                    boolean t4 = t(jSONObject4.optString("static_ip_direct_enable"), false);
                    int optInt = jSONObject4.optInt("static_timeout", 5) * 1000;
                    int optInt2 = jSONObject4.optInt("static_retry", 3);
                    str4 = "ustv";
                    try {
                        boolean t5 = t(jSONObject4.optString("bgp_enable"), true);
                        str3 = "ust";
                        try {
                            boolean t6 = t(jSONObject4.optString("bgp_ip_direct_enable"), false);
                            str2 = "umv";
                            try {
                                int optInt3 = jSONObject4.optInt("bgp_retry", 3);
                                boolean t7 = t(jSONObject4.optString("perf_data_upload_enable"), false);
                                if (!(t3 == s && t4 == t && optInt == r && optInt2 == u && t5 == v && t6 == w && optInt3 == x && t7 == y)) {
                                    s = t3;
                                    t = t4;
                                    r = optInt;
                                    u = optInt2;
                                    v = t5;
                                    w = t6;
                                    x = optInt3;
                                    y = t7;
                                    if (context != null) {
                                        SharedPreferences.Editor b3 = y13.b(context, "open_common");
                                        y13.j(b3, "a13", t3);
                                        y13.j(b3, "a6", t5);
                                        y13.j(b3, "a7", t4);
                                        y13.g(b3, "a8", optInt);
                                        y13.g(b3, "a9", optInt2);
                                        y13.j(b3, "a10", t6);
                                        y13.g(b3, "a11", optInt3);
                                        y13.j(b3, "a12", t7);
                                        y13.e(b3);
                                    }
                                }
                                bj.f();
                                bj.f();
                                bj.f();
                                bj.f();
                                bj.f();
                            } catch (Throwable th8) {
                                th = th8;
                                v13.e(th, "AuthConfigManager", "load 17S");
                                if (v1.n(jSONObject, "15K")) {
                                }
                                context2 = context;
                                if (v1.n(jSONObject, "183")) {
                                }
                                if (v1.n(jSONObject, "17I")) {
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            str2 = "umv";
                            v13.e(th, "AuthConfigManager", "load 17S");
                            if (v1.n(jSONObject, "15K")) {
                            }
                            context2 = context;
                            if (v1.n(jSONObject, "183")) {
                            }
                            if (v1.n(jSONObject, "17I")) {
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        str3 = "ust";
                        str2 = "umv";
                        v13.e(th, "AuthConfigManager", "load 17S");
                        if (v1.n(jSONObject, "15K")) {
                        }
                        context2 = context;
                        if (v1.n(jSONObject, "183")) {
                        }
                        if (v1.n(jSONObject, "17I")) {
                        }
                    }
                    if (v1.n(jSONObject, "15K")) {
                        try {
                            JSONObject jSONObject5 = jSONObject.getJSONObject("15K");
                            if (jSONObject5 != null) {
                                boolean t8 = t(jSONObject5.optString("ucf"), f.a);
                                boolean t9 = t(jSONObject5.optString("fsv2"), f.b);
                                boolean t10 = t(jSONObject5.optString("usc"), f.c);
                                int optInt4 = jSONObject5.optInt(str2, f.d);
                                boolean t11 = t(jSONObject5.optString(str3), f.e);
                                int optInt5 = jSONObject5.optInt(str4, f.f);
                                if (!(t8 == f.a && t9 == f.b && t10 == f.c && optInt4 == f.d && t11 == f.e && optInt5 == f.d)) {
                                    f.a = t8;
                                    f.b = t9;
                                    f.c = t10;
                                    f.d = optInt4;
                                    f.e = t11;
                                    f.f = optInt5;
                                    context2 = context;
                                    try {
                                        SharedPreferences.Editor b4 = y13.b(context2, "open_common");
                                        y13.j(b4, "ucf", f.a);
                                        y13.j(b4, "fsv2", f.b);
                                        y13.j(b4, "usc", f.c);
                                        y13.g(b4, str2, f.d);
                                        y13.j(b4, str3, f.e);
                                        y13.g(b4, str4, f.f);
                                        y13.e(b4);
                                    } catch (Throwable unused) {
                                    }
                                    if (v1.n(jSONObject, "183")) {
                                        try {
                                            y.d(u1Var, jSONObject.getJSONObject("183"));
                                        } catch (Throwable th11) {
                                            v13.e(th11, "AuthConfigManager", "load 183");
                                        }
                                    }
                                    if (v1.n(jSONObject, "17I")) {
                                        try {
                                            JSONObject jSONObject6 = jSONObject.getJSONObject("17I");
                                            boolean t12 = t(jSONObject6.optString("na"), false);
                                            boolean t13 = t(jSONObject6.optString("aa"), false);
                                            t13.e = t12;
                                            t13.k = t13;
                                            SharedPreferences.Editor b5 = y13.b(context2, "open_common");
                                            y13.j(b5, "a4", t12);
                                            y13.j(b5, "a5", t13);
                                            y13.e(b5);
                                            return;
                                        } catch (Throwable th12) {
                                            v13.e(th12, "AuthConfigManager", "load 17I");
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th13) {
                            context2 = context;
                            v13.e(th13, "AuthConfigManager", "load 15K");
                        }
                    }
                    context2 = context;
                    if (v1.n(jSONObject, "183")) {
                    }
                    if (v1.n(jSONObject, "17I")) {
                    }
                }
            } catch (Throwable th14) {
                th = th14;
                str4 = "ustv";
                str3 = "ust";
                str2 = "umv";
                v13.e(th, "AuthConfigManager", "load 17S");
                if (v1.n(jSONObject, "15K")) {
                }
                context2 = context;
                if (v1.n(jSONObject, "183")) {
                }
                if (v1.n(jSONObject, "17I")) {
                }
            }
        }
        str4 = "ustv";
        str3 = "ust";
        str2 = "umv";
        if (v1.n(jSONObject, "15K")) {
        }
        context2 = context;
        if (v1.n(jSONObject, "183")) {
        }
        if (v1.n(jSONObject, "17I")) {
        }
    }

    private static void g(Context context, u1 u1Var, Throwable th) {
        d(context, u1Var, th.getMessage());
    }

    public static void h(Context context, String str) {
        l.b(context, str);
    }

    private static void i(Context context, String str, String str2, e eVar) {
        if (eVar != null && !TextUtils.isEmpty(eVar.a)) {
            String e2 = eVar.e();
            if (!TextUtils.isEmpty(e2) && context != null) {
                SharedPreferences.Editor b2 = y13.b(context, str2);
                b2.putString(str, e2);
                y13.e(b2);
            }
        }
    }

    public static void j(bj.c cVar) {
        if (cVar != null && g != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("serverip", cVar.c);
            hashMap.put("hostname", cVar.e);
            hashMap.put(com.alibaba.security.realidentity.jsbridge.a.V, cVar.d);
            hashMap.put("csid", cVar.a);
            hashMap.put(MtopUpdater.DEGRADE, String.valueOf(cVar.b.a()));
            hashMap.put("errorcode", String.valueOf(cVar.m));
            hashMap.put("errorsubcode", String.valueOf(cVar.n));
            hashMap.put("connecttime", String.valueOf(cVar.h));
            hashMap.put("writetime", String.valueOf(cVar.i));
            hashMap.put("readtime", String.valueOf(cVar.j));
            hashMap.put("datasize", String.valueOf(cVar.l));
            hashMap.put("totaltime", String.valueOf(cVar.f));
            String jSONObject = new JSONObject(hashMap).toString();
            "--埋点--".concat(String.valueOf(jSONObject));
            bj.f();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    d0 d0Var = new d0(g, StatServices.CATEGORY, "2.0", "O008");
                    d0Var.a(jSONObject);
                    bs.d(d0Var, g);
                } catch (k unused) {
                }
            }
        }
    }

    private static void k(u1 u1Var) {
        if (u1Var != null) {
            try {
                if (!TextUtils.isEmpty(u1Var.a())) {
                    String f2 = u1Var.f();
                    if (TextUtils.isEmpty(f2)) {
                        f2 = u1Var.e();
                    }
                    if (!TextUtils.isEmpty(f2)) {
                        t13.b(u1Var.a(), f2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void l(String str, String str2) {
        e b2 = b(g, str, str2);
        String c2 = v1.c(System.currentTimeMillis(), "yyyyMMdd");
        if (!c2.equals(b2.b)) {
            b2.c(c2);
            b2.c.set(0);
        }
        b2.c.incrementAndGet();
        i(g, str, str2, b2);
    }

    public static synchronized void m(final String str, boolean z2, final String str2, final String str3, final String str4) {
        synchronized (m.class) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (o == null) {
                        o = new ConcurrentHashMap<>(8);
                    }
                    o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    if (p != null) {
                        if (p.containsKey(str)) {
                            if (!TextUtils.isEmpty(str)) {
                                if (z2) {
                                    y.j(true, str);
                                }
                                o0.f().d(new ck() {
                                    /* class com.loc.m.AnonymousClass1 */

                                    @Override // com.loc.ck
                                    public final void a() {
                                        d dVar = (d) m.p.get(str);
                                        if (dVar != null) {
                                            a aVar = dVar.c;
                                            b a2 = m.a(m.g, dVar.a, dVar.b, str2, str3, str4);
                                            if (a2 != null && aVar != null) {
                                                aVar.a(a2);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                v13.e(th, "at", "lca");
            }
        }
    }

    public static void n(String str, boolean z2, boolean z3, boolean z4) {
        if (!TextUtils.isEmpty(str) && g != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("downLevel", String.valueOf(z2));
            String str2 = "0";
            hashMap.put("ant", o.a0(g) == 0 ? str2 : "1");
            hashMap.put("type", z4 ? z2 ? e : f : z2 ? c : d);
            if (!z3) {
                str2 = "1";
            }
            hashMap.put("status", str2);
            String jSONObject = new JSONObject(hashMap).toString();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    d0 d0Var = new d0(g, StatServices.CATEGORY, "2.0", "O002");
                    d0Var.a(jSONObject);
                    bs.d(d0Var, g);
                } catch (k unused) {
                }
            }
        }
    }

    public static void o(boolean z2, bj.a aVar) {
        if (C && aVar != null) {
            synchronized (B) {
                if (z2) {
                    Iterator<bj.a> it = B.iterator();
                    while (it.hasNext()) {
                        bj.a next = it.next();
                        if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                            if (next.j == aVar.j) {
                                it.remove();
                            } else {
                                next.j.set(next.j.get() - aVar.j.get());
                            }
                            bj.f();
                        }
                    }
                }
                C = false;
                Iterator<bj.a> it2 = B.iterator();
                while (true) {
                    bj.f();
                    if (it2.hasNext()) {
                        bj.a next2 = it2.next();
                        String str = next2.e;
                        Objects.toString(next2.j);
                    } else {
                        bj.f();
                    }
                }
            }
        }
    }

    public static void p(boolean z2, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            bj.f();
            if (!s && !z2) {
                return;
            }
            if ((!w && z2) || TextUtils.isEmpty(str)) {
                return;
            }
            if (!z2) {
                if (z.get(str) == null) {
                    z.put(str, Boolean.TRUE);
                    l(w(str, "a14"), "open_common");
                }
            } else if (A.get(str) == null) {
                A.put(str, Boolean.TRUE);
                l(w(str, "a15"), "open_common");
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean q() {
        e b2;
        if (g != null) {
            P();
            if (!G()) {
                return false;
            }
            if (C()) {
                return true;
            }
        }
        return h && (b2 = b(g, "IPV6_CONFIG_NAME", "open_common")) != null && b2.a() < 5;
    }

    public static synchronized boolean r(String str) {
        synchronized (m.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (p == null) {
                    return false;
                }
                if (o == null) {
                    o = new ConcurrentHashMap<>(8);
                }
                if (p.containsKey(str) && !o.containsKey(str)) {
                    o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    return true;
                }
                return false;
            } catch (Throwable th) {
                v13.e(th, "at", "cslct");
            }
        }
    }

    public static synchronized boolean s(String str, long j2) {
        synchronized (m.class) {
            boolean z2 = false;
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (j2 > D(str)) {
                    long j3 = 0;
                    if (o != null && o.containsKey(str)) {
                        j3 = o.get(str).longValue();
                    }
                    if (SystemClock.elapsedRealtime() - j3 > 30000) {
                        z2 = true;
                    }
                }
                return z2;
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean t(String str, boolean z2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z2;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z2;
        }
    }

    private static boolean u(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v53, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0142 */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01b1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01b2  */
    private static b v(Context context, u1 u1Var, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        b bVar;
        String str10;
        byte[] bArr;
        q23 q23;
        String str11;
        String str12;
        byte[] bArr2;
        k e2;
        String str13;
        Context context2;
        IllegalBlockSizeException th;
        Context context3;
        k e3;
        Context context4;
        byte[] bArr3;
        StringBuilder sb;
        b bVar2 = new b();
        bVar2.b = new JSONObject();
        if (context != null) {
            g = context.getApplicationContext();
        }
        K();
        String str14 = null;
        try {
            k(u1Var);
            new bg();
            boolean isEmpty = TextUtils.isEmpty(str);
            if (!isEmpty) {
                try {
                    sb = new StringBuilder();
                    str13 = str;
                } catch (k e4) {
                    e3 = e4;
                    str13 = str;
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str9 = "at";
                    str10 = o70.LOWER_PREFIX;
                    try {
                        throw e3;
                    } catch (k e5) {
                        e2 = e5;
                    } catch (IllegalBlockSizeException e6) {
                        th = e6;
                        str8 = str13;
                        q23 = null;
                        context2 = null;
                        g(context, u1Var, th);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str8 = str13;
                        q23 = null;
                        context3 = null;
                        an.m(th, str9, str10);
                        context2 = context3;
                        g(context, u1Var, th);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    }
                } catch (Throwable unused) {
                    str13 = str;
                    str8 = str13;
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str9 = "at";
                    str10 = o70.LOWER_PREFIX;
                    try {
                        throw new k(AMapException.ERROR_UNKNOWN);
                    } catch (k e7) {
                        e2 = e7;
                        q23 = null;
                        bArr2 = null;
                        e2.a();
                        d(context, u1Var, e2.a());
                        an.h(u1Var, "/v3/iasdkauth", e2);
                        bArr = bArr2;
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException e8) {
                        th = e8;
                        q23 = null;
                        context2 = null;
                        g(context, u1Var, th);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        q23 = null;
                        context3 = null;
                        an.m(th, str9, str10);
                        context2 = context3;
                        g(context, u1Var, th);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    }
                }
                try {
                    sb.append(str13);
                    sb.append(";15K;16H;17I;17S;183");
                    str8 = sb.toString();
                } catch (k e9) {
                    e3 = e9;
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str9 = "at";
                    str10 = o70.LOWER_PREFIX;
                    throw e3;
                } catch (Throwable unused2) {
                    str8 = str13;
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str9 = "at";
                    str10 = o70.LOWER_PREFIX;
                    throw new k(AMapException.ERROR_UNKNOWN);
                }
            } else {
                str8 = str;
            }
            try {
                I(context);
                context4 = context;
                str7 = "result";
                bVar = bVar2;
                str6 = "ver";
                str9 = "at";
                str5 = "infocode";
                str10 = o70.LOWER_PREFIX;
            } catch (k e10) {
                e3 = e10;
                str5 = "infocode";
                str7 = "result";
                str6 = "ver";
                bVar = bVar2;
                str9 = "at";
                str10 = o70.LOWER_PREFIX;
                str13 = str8;
                throw e3;
            } catch (Throwable unused3) {
                str5 = "infocode";
                str7 = "result";
                str6 = "ver";
                bVar = bVar2;
                str9 = "at";
                str10 = o70.LOWER_PREFIX;
                throw new k(AMapException.ERROR_UNKNOWN);
            }
            try {
                q23 = bg.c(new c(context4, u1Var, str8, str2, str3, str4));
                if (isEmpty) {
                    return bVar;
                }
                if (q23 != null) {
                    try {
                        byte[] bArr4 = q23.a;
                        try {
                            Map<String, List<String>> map = q23.b;
                            bArr3 = bArr4;
                            if (map != null) {
                                bArr3 = bArr4;
                                if (map.containsKey("lct")) {
                                    List<String> list = map.get("lct");
                                    bArr3 = bArr4;
                                    if (list != null) {
                                        bArr3 = bArr4;
                                        if (list.size() > 0) {
                                            String str15 = list.get(0);
                                            bArr3 = bArr4;
                                            if (!TextUtils.isEmpty(str15)) {
                                                long longValue = Long.valueOf(str15).longValue();
                                                bVar.a = longValue;
                                                bArr3 = bArr4;
                                                if (u1Var != null) {
                                                    bArr3 = bArr4;
                                                    if (longValue != 0) {
                                                        String a2 = u1Var.a();
                                                        bArr3 = bArr4;
                                                        if (!TextUtils.isEmpty(a2)) {
                                                            A(a2, bVar.a);
                                                            bArr3 = bArr4;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            try {
                                an.m(th4, str9, "lct");
                                bArr3 = bArr4;
                            } catch (k e11) {
                                e2 = e11;
                                bArr2 = context4;
                                e2.a();
                                d(context, u1Var, e2.a());
                                an.h(u1Var, "/v3/iasdkauth", e2);
                                bArr = bArr2;
                                if (bArr == null) {
                                }
                            } catch (IllegalBlockSizeException e12) {
                                th = e12;
                                context2 = context4;
                                g(context, u1Var, th);
                                bArr = context2;
                                if (bArr == null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                context3 = context4;
                                an.m(th, str9, str10);
                                context2 = context3;
                                g(context, u1Var, th);
                                bArr = context2;
                                if (bArr == null) {
                                }
                            }
                        }
                    } catch (k e13) {
                        e2 = e13;
                        bArr2 = null;
                        e2.a();
                        d(context, u1Var, e2.a());
                        an.h(u1Var, "/v3/iasdkauth", e2);
                        bArr = bArr2;
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException e14) {
                        th = e14;
                        context2 = null;
                        g(context, u1Var, th);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        context3 = null;
                        an.m(th, str9, str10);
                        context2 = context3;
                        g(context, u1Var, th);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    }
                } else {
                    bArr3 = null;
                }
                byte[] bArr5 = new byte[16];
                byte[] bArr6 = new byte[(bArr3.length - 16)];
                System.arraycopy(bArr3, 0, bArr5, 0, 16);
                System.arraycopy(bArr3, 16, bArr6, 0, bArr3.length - 16);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr5, v1.v("EQUVT"));
                Cipher instance = Cipher.getInstance(v1.v("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
                instance.init(2, secretKeySpec, new IvParameterSpec(v1.w()));
                str14 = v1.g(instance.doFinal(bArr6));
                bArr = bArr3;
                if (bArr == null) {
                    return bVar;
                }
                if (TextUtils.isEmpty(str14)) {
                    str14 = v1.g(bArr);
                }
                if (TextUtils.isEmpty(str14)) {
                    d(context, u1Var, "result is null");
                }
                try {
                    JSONObject jSONObject = new JSONObject(str14);
                    if (jSONObject.has("status")) {
                        int i2 = jSONObject.getInt("status");
                        if (i2 == 1) {
                            a = 1;
                        } else if (i2 == 0) {
                            if (q23 != null) {
                                str11 = q23.c;
                                str12 = q23.d;
                            } else {
                                str11 = "authcsid";
                                str12 = "authgsid";
                            }
                            v1.j(context, str11, str12, jSONObject);
                            a = 0;
                            if (jSONObject.has("info")) {
                                b = jSONObject.getString("info");
                            }
                            String str16 = "";
                            if (jSONObject.has(str5)) {
                                str16 = jSONObject.getString(str5);
                            }
                            an.j(u1Var, "/v3/iasdkauth", b, str12, str11, str16);
                            if (a == 0) {
                                return bVar;
                            }
                        }
                        try {
                            if (jSONObject.has(str6)) {
                                jSONObject.getInt(str6);
                            }
                        } catch (Throwable th7) {
                            v13.e(th7, str9, str10);
                        }
                        if (v1.n(jSONObject, str7)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(str7);
                            f(context, u1Var, str8, bVar, jSONObject2);
                            try {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("15K");
                                boolean t2 = t(jSONObject3.optString("isTargetAble"), false);
                                if (!t(jSONObject3.optString("able"), false)) {
                                    q1.a();
                                    q1.f(context);
                                } else {
                                    q1.a().d(context, t2);
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                } catch (Throwable th8) {
                    v13.e(th8, str9, str10);
                }
                return bVar;
            } catch (k e15) {
                e3 = e15;
                str13 = str8;
                throw e3;
            } catch (Throwable unknown) {
                throw new k(AMapException.ERROR_UNKNOWN);
            }
        } catch (k e16) {
            e2 = e16;
            str13 = str;
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str9 = "at";
            str10 = o70.LOWER_PREFIX;
            str8 = str13;
            q23 = null;
            bArr2 = null;
            e2.a();
            d(context, u1Var, e2.a());
            an.h(u1Var, "/v3/iasdkauth", e2);
            bArr = bArr2;
            if (bArr == null) {
            }
        } catch (IllegalBlockSizeException e17) {
            th = e17;
            str13 = str;
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str9 = "at";
            str10 = o70.LOWER_PREFIX;
            str8 = str13;
            q23 = null;
            context2 = null;
            g(context, u1Var, th);
            bArr = context2;
            if (bArr == null) {
            }
        } catch (Throwable th9) {
            th = th9;
            str13 = str;
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str9 = "at";
            str10 = o70.LOWER_PREFIX;
            str8 = str13;
            q23 = null;
            context3 = null;
            an.m(th, str9, str10);
            context2 = context3;
            g(context, u1Var, th);
            bArr = context2;
            if (bArr == null) {
            }
        }
    }

    private static String w(String str, String str2) {
        String b2 = r1.b(str.getBytes());
        return str2 + JSMethod.NOT_SET + b2;
    }

    public static void x(Context context) {
        if (context != null) {
            h = y13.k(context, "open_common", "a2", true);
        }
    }

    public static void y(bj.c cVar) {
        int i2;
        synchronized (B) {
            boolean z2 = false;
            for (int i3 = 0; i3 < B.size(); i3++) {
                bj.a aVar = B.get(i3);
                if (cVar.c.equals(aVar.b) && cVar.d.equals(aVar.e) && cVar.m == (i2 = aVar.f)) {
                    if (i2 == 1) {
                        aVar.i = ((((long) aVar.j.get()) * aVar.i) + cVar.f) / ((long) (aVar.j.get() + 1));
                    }
                    aVar.j.getAndIncrement();
                    z2 = true;
                }
            }
            if (!z2) {
                B.add(new bj.a(cVar));
            }
            bj.f();
        }
    }

    public static synchronized void z(String str) {
        synchronized (m.class) {
            if (o != null) {
                if (o.containsKey(str)) {
                    o.remove(str);
                }
            }
        }
    }
}
