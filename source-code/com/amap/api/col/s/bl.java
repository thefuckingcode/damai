package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.dc;
import com.amap.api.col.s.df;
import com.amap.api.maps.AMapException;
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

/* compiled from: Taobao */
public final class bl {
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ArrayList<dc.a> B = new ArrayList<>();
    private static volatile boolean C = false;
    private static Queue<dc.c> D = new LinkedList();
    public static int a = -1;
    public static String b = "";
    public static Context c = null;
    public static volatile boolean d = false;
    public static int e = 5000;
    public static boolean f = true;
    public static boolean g = false;
    public static boolean h = true;
    public static boolean i = false;
    public static boolean j = false;
    private static String k = "6";
    private static String l = "4";
    private static String m = "9";
    private static String n = "8";
    private static volatile boolean o = true;
    private static Vector<e> p = new Vector<>();
    private static Map<String, Integer> q = new HashMap();
    private static String r = null;
    private static long s = 0;
    private static volatile ConcurrentHashMap<String, Long> t = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, Long> u = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, d> v = new ConcurrentHashMap<>(8);
    private static boolean w = false;
    private static int x = 3;
    private static int y = 3;
    private static ConcurrentHashMap<String, Boolean> z = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: Taobao */
    public static class b {
        @Deprecated
        public JSONObject a;
        @Deprecated
        public JSONObject b;
        public String c;
        public int d = -1;
        public long e = 0;
        public JSONObject f;
        public a g;
        public C0142b h;
        private boolean i;

        /* compiled from: Taobao */
        public static class a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* renamed from: com.amap.api.col.s.bl$b$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static class C0142b {
            public boolean a;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c extends da {
        private String d;
        private Map<String, String> e = null;
        private String f;
        private String k;
        private String l;

        c(Context context, bv bvVar, String str, String str2, String str3, String str4) {
            super(context, bvVar);
            this.d = str;
            this.f = str2;
            this.k = str3;
            this.l = str4;
            a(df.c.HTTPS);
            a(df.a.FIX);
        }

        @Override // com.amap.api.col.s.df, com.amap.api.col.s.br
        public final String a() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.k);
        }

        @Override // com.amap.api.col.s.da
        public final byte[] b() {
            String q = bo.q(((da) this).a);
            if (!TextUtils.isEmpty(q)) {
                q = bs.a(new StringBuilder(q).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.d) ? "" : this.d);
            hashMap.put("plattype", "android");
            hashMap.put("product", ((da) this).b.b());
            hashMap.put("version", ((da) this).b.c());
            hashMap.put("output", Preloader.KEY_JSON);
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", q);
            hashMap.put("manufacture", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
            Map<String, String> map = this.e;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.e);
            }
            hashMap.put("abitype", bw.a(((da) this).a));
            hashMap.put("ext", ((da) this).b.e());
            return bw.a(bw.a(hashMap));
        }

        /* access modifiers changed from: protected */
        @Override // com.amap.api.col.s.da
        public final String d() {
            return LiveFullInfo.VER;
        }

        @Override // com.amap.api.col.s.df
        public final Map<String, String> f() {
            if (TextUtils.isEmpty(this.l)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.l);
            return hashMap;
        }

        @Override // com.amap.api.col.s.df
        public final String h() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.f);
        }

        /* access modifiers changed from: protected */
        @Override // com.amap.api.col.s.df
        public final String i() {
            if (!TextUtils.isEmpty(this.l)) {
                return this.l;
            }
            return super.i();
        }

        private static String a(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d {
        bv a;
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

        public final void a(String str) {
            this.b = str;
        }

        public final String b() {
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

        public final int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public static e b(String str) {
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

    public static boolean a(String str, boolean z2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z2;
            }
            String[] split = URLDecoder.decode(str).split("/");
            if (split[split.length - 1].charAt(4) % 2 == 1) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return z2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v52, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v53, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0142 */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01b8  */
    private static b b(Context context, bv bvVar, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        b bVar;
        String str10;
        byte[] bArr;
        dg dgVar;
        String str11;
        String str12;
        byte[] bArr2;
        bj e2;
        String str13;
        Context context2;
        IllegalBlockSizeException e3;
        Context context3;
        Throwable th;
        bj e4;
        Context context4;
        byte[] bArr3;
        StringBuilder sb;
        b bVar2 = new b();
        bVar2.f = new JSONObject();
        if (context != null) {
            c = context.getApplicationContext();
        }
        d();
        String str14 = null;
        try {
            a(bvVar);
            new cz();
            boolean isEmpty = TextUtils.isEmpty(str);
            if (!isEmpty) {
                try {
                    sb = new StringBuilder();
                    str13 = str;
                } catch (bj e5) {
                    e4 = e5;
                    str13 = str;
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str9 = "at";
                    str10 = o70.LOWER_PREFIX;
                    try {
                        throw e4;
                    } catch (bj e6) {
                        e2 = e6;
                    } catch (IllegalBlockSizeException e7) {
                        e3 = e7;
                        str8 = str13;
                        dgVar = null;
                        context2 = null;
                        a(context, bvVar, e3);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str8 = str13;
                        dgVar = null;
                        context3 = null;
                        cl.c(th, str9, str10);
                        a(context, bvVar, th);
                        bArr = context3;
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
                        throw new bj(AMapException.ERROR_UNKNOWN);
                    } catch (bj e8) {
                        e2 = e8;
                        dgVar = null;
                        bArr2 = null;
                        bVar.c = e2.a();
                        a(context, bvVar, e2.a());
                        cl.a(bvVar, "/v3/iasdkauth", e2);
                        bArr = bArr2;
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException e9) {
                        e3 = e9;
                        dgVar = null;
                        context2 = null;
                        a(context, bvVar, e3);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        dgVar = null;
                        context3 = null;
                        cl.c(th, str9, str10);
                        a(context, bvVar, th);
                        bArr = context3;
                        if (bArr == null) {
                        }
                    }
                }
                try {
                    sb.append(str13);
                    sb.append(";15K;16H;17I;17S;183");
                    str8 = sb.toString();
                } catch (bj e10) {
                    e4 = e10;
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str9 = "at";
                    str10 = o70.LOWER_PREFIX;
                    throw e4;
                } catch (Throwable unused2) {
                    str8 = str13;
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str9 = "at";
                    str10 = o70.LOWER_PREFIX;
                    throw new bj(AMapException.ERROR_UNKNOWN);
                }
            } else {
                str8 = str;
            }
            try {
                d(context);
                context4 = context;
                str7 = "result";
                bVar = bVar2;
                str6 = "ver";
                str9 = "at";
                str5 = "infocode";
                str10 = o70.LOWER_PREFIX;
            } catch (bj e11) {
                e4 = e11;
                str5 = "infocode";
                str7 = "result";
                str6 = "ver";
                bVar = bVar2;
                str9 = "at";
                str10 = o70.LOWER_PREFIX;
                str13 = str8;
                throw e4;
            } catch (Throwable unused3) {
                str5 = "infocode";
                str7 = "result";
                str6 = "ver";
                bVar = bVar2;
                str9 = "at";
                str10 = o70.LOWER_PREFIX;
                throw new bj(AMapException.ERROR_UNKNOWN);
            }
            try {
                dgVar = cz.a(new c(context4, bvVar, str8, str2, str3, str4));
                if (isEmpty) {
                    return bVar;
                }
                if (dgVar != null) {
                    try {
                        byte[] bArr4 = dgVar.a;
                        try {
                            Map<String, List<String>> map = dgVar.b;
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
                                                bVar.e = longValue;
                                                bArr3 = bArr4;
                                                if (bvVar != null) {
                                                    bArr3 = bArr4;
                                                    if (longValue != 0) {
                                                        String b2 = bvVar.b();
                                                        bArr3 = bArr4;
                                                        if (!TextUtils.isEmpty(b2)) {
                                                            b(b2, bVar.e);
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
                                cl.c(th4, str9, "lct");
                                bArr3 = bArr4;
                            } catch (bj e12) {
                                e2 = e12;
                                bArr2 = context4;
                                bVar.c = e2.a();
                                a(context, bvVar, e2.a());
                                cl.a(bvVar, "/v3/iasdkauth", e2);
                                bArr = bArr2;
                                if (bArr == null) {
                                }
                            } catch (IllegalBlockSizeException e13) {
                                e3 = e13;
                                context2 = context4;
                                a(context, bvVar, e3);
                                bArr = context2;
                                if (bArr == null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                context3 = context4;
                                cl.c(th, str9, str10);
                                a(context, bvVar, th);
                                bArr = context3;
                                if (bArr == null) {
                                }
                            }
                        }
                    } catch (bj e14) {
                        e2 = e14;
                        bArr2 = null;
                        bVar.c = e2.a();
                        a(context, bvVar, e2.a());
                        cl.a(bvVar, "/v3/iasdkauth", e2);
                        bArr = bArr2;
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException e15) {
                        e3 = e15;
                        context2 = null;
                        a(context, bvVar, e3);
                        bArr = context2;
                        if (bArr == null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        context3 = null;
                        cl.c(th, str9, str10);
                        a(context, bvVar, th);
                        bArr = context3;
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
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr5, bw.c("EQUVT"));
                Cipher instance = Cipher.getInstance(bw.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
                instance.init(2, secretKeySpec, new IvParameterSpec(bw.c()));
                str14 = bw.a(instance.doFinal(bArr6));
                bArr = bArr3;
                if (bArr == null) {
                    return bVar;
                }
                if (TextUtils.isEmpty(str14)) {
                    str14 = bw.a(bArr);
                }
                if (TextUtils.isEmpty(str14)) {
                    a(context, bvVar, "result is null");
                }
                try {
                    JSONObject jSONObject = new JSONObject(str14);
                    if (jSONObject.has("status")) {
                        int i2 = jSONObject.getInt("status");
                        if (i2 == 1) {
                            a = 1;
                        } else if (i2 == 0) {
                            if (dgVar != null) {
                                str11 = dgVar.c;
                                str12 = dgVar.d;
                            } else {
                                str11 = "authcsid";
                                str12 = "authgsid";
                            }
                            bw.a(context, str11, str12, jSONObject);
                            a = 0;
                            if (jSONObject.has("info")) {
                                b = jSONObject.getString("info");
                            }
                            String str16 = "";
                            if (jSONObject.has(str5)) {
                                str16 = jSONObject.getString(str5);
                            }
                            cl.a(bvVar, "/v3/iasdkauth", b, str12, str11, str16);
                            if (a == 0) {
                                bVar.c = b;
                                return bVar;
                            }
                        }
                        try {
                            if (jSONObject.has(str6)) {
                                bVar.d = jSONObject.getInt(str6);
                            }
                        } catch (Throwable th7) {
                            ci.a(th7, str9, str10);
                        }
                        if (bw.a(jSONObject, str7)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(str7);
                            a(context, bvVar, str8, bVar, jSONObject2);
                            try {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("15K");
                                boolean a2 = a(jSONObject3.optString("isTargetAble"), false);
                                if (!a(jSONObject3.optString("able"), false)) {
                                    bq.a();
                                    bq.b(context);
                                } else {
                                    bq.a().a(context, a2);
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                } catch (Throwable th8) {
                    ci.a(th8, str9, str10);
                }
                return bVar;
            } catch (bj e16) {
                e4 = e16;
                str13 = str8;
                throw e4;
            } catch (Throwable unknown) {
                throw new bj(AMapException.ERROR_UNKNOWN);
            }
        } catch (bj e17) {
            e2 = e17;
            str13 = str;
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str9 = "at";
            str10 = o70.LOWER_PREFIX;
            str8 = str13;
            dgVar = null;
            bArr2 = null;
            bVar.c = e2.a();
            a(context, bvVar, e2.a());
            cl.a(bvVar, "/v3/iasdkauth", e2);
            bArr = bArr2;
            if (bArr == null) {
            }
        } catch (IllegalBlockSizeException e18) {
            e3 = e18;
            str13 = str;
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str9 = "at";
            str10 = o70.LOWER_PREFIX;
            str8 = str13;
            dgVar = null;
            context2 = null;
            a(context, bvVar, e3);
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
            dgVar = null;
            context3 = null;
            cl.c(th, str9, str10);
            a(context, bvVar, th);
            bArr = context3;
            if (bArr == null) {
            }
        }
    }

    private static void c(Context context) {
        if (context != null) {
            f = co.a(context, "open_common", "a13", true);
            h = co.a(context, "open_common", "a6", true);
            g = co.a(context, "open_common", "a7", false);
            e = co.a(context, "open_common", "a8", 5000);
            x = co.a(context, "open_common", "a9", 3);
            i = co.a(context, "open_common", "a10", false);
            y = co.a(context, "open_common", "a11", 3);
            j = co.a(context, "open_common", "a12", false);
        }
    }

    public static void d() {
        if (!d) {
            try {
                Context context = c;
                if (context != null) {
                    d = true;
                    bq.a().a(context);
                    b(context);
                    c(context);
                    f.a = co.a(context, "open_common", "ucf", f.a);
                    f.b = co.a(context, "open_common", "fsv2", f.b);
                    f.c = co.a(context, "open_common", "usc", f.c);
                    f.d = co.a(context, "open_common", "umv", f.d);
                    f.e = co.a(context, "open_common", "ust", f.e);
                    f.f = co.a(context, "open_common", "ustv", f.f);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean e(String str) {
        e a2;
        try {
            if (TextUtils.isEmpty(str) || !i) {
                return false;
            }
            if (!(A.get(str) == null)) {
                return false;
            }
            Context context = c;
            if (context == null || (a2 = a(context, b(str, "a15"), "open_common")) == null || a2.a() < y) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    public static dc.c f() {
        synchronized (D) {
            dc.c poll = D.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    private static void h() {
        try {
            Context context = c;
            if (context != null) {
                String p2 = bo.p(context);
                if (!TextUtils.isEmpty(r) && !TextUtils.isEmpty(p2) && r.equals(p2) && System.currentTimeMillis() - s < DateUtils.MILLIS_PER_MINUTE) {
                    return;
                }
                if (!TextUtils.isEmpty(p2)) {
                    r = p2;
                }
            } else if (System.currentTimeMillis() - s < 10000) {
                return;
            }
            s = System.currentTimeMillis();
            q.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i2 = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!a((Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(bw.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            q.put("WIFI", Integer.valueOf(i2));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            q.put("MOBILE", Integer.valueOf(i2));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ci.a(th, "at", "ipstack");
        }
    }

    private static boolean i() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String p2 = bo.p(context);
        if (!TextUtils.isEmpty(p2) && (num = q.get(p2.toUpperCase())) != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public static dc.a e() {
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
            dc.a a2 = B.get(0).clone();
            C = true;
            return a2;
        }
    }

    public static b a(Context context, bv bvVar, String str, String str2, String str3, String str4) {
        return b(context, bvVar, str, str2, str3, str4);
    }

    public static void a(Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    public static synchronized long c(String str) {
        synchronized (bl.class) {
            try {
                if (t == null) {
                    t = new ConcurrentHashMap<>(8);
                }
                if (t.containsKey(str)) {
                    return t.get(str).longValue();
                }
            } catch (Throwable th) {
                ci.a(th, "at", "glcut");
            }
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0208 A[SYNTHETIC, Splitter:B:101:0x0208] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02a9 A[SYNTHETIC, Splitter:B:126:0x02a9] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02c1 A[SYNTHETIC, Splitter:B:132:0x02c1] */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    private static void a(Context context, bv bvVar, String str, b bVar, JSONObject jSONObject) throws JSONException {
        String str2;
        String str3;
        String str4;
        Context context2;
        Throwable th;
        boolean a2;
        boolean a3;
        boolean a4;
        String[] strArr;
        b.a aVar = new b.a();
        aVar.a = false;
        aVar.b = false;
        bVar.g = aVar;
        try {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String str5 = split[i2];
                    if (jSONObject.has(str5)) {
                        strArr = split;
                        bVar.f.putOpt(str5, jSONObject.get(str5));
                    } else {
                        strArr = split;
                    }
                    i2++;
                    split = strArr;
                }
            }
        } catch (Throwable th2) {
            ci.a(th2, "at", "co");
        }
        if (bw.a(jSONObject, "16H")) {
            try {
                bVar.i = a(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (Throwable th3) {
                ci.a(th3, "AuthConfigManager", "load 16H");
            }
        }
        if (bw.a(jSONObject, "11K")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11K");
                aVar.a = a(jSONObject2.getString("able"), false);
                if (jSONObject2.has("off")) {
                    aVar.c = jSONObject2.getJSONObject("off");
                }
            } catch (Throwable th4) {
                ci.a(th4, "AuthConfigManager", "load 11K");
            }
        }
        if (bw.a(jSONObject, "145")) {
            try {
                bVar.a = jSONObject.getJSONObject("145");
            } catch (Throwable th5) {
                ci.a(th5, "AuthConfigManager", "load 145");
            }
        }
        if (bw.a(jSONObject, "14D")) {
            try {
                bVar.b = jSONObject.getJSONObject("14D");
            } catch (Throwable th6) {
                ci.a(th6, "AuthConfigManager", "load 14D");
            }
        }
        if (bw.a(jSONObject, "151")) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("151");
                b.C0142b bVar2 = new b.C0142b();
                if (jSONObject3 != null) {
                    bVar2.a = a(jSONObject3.optString("able"), false);
                }
                bVar.h = bVar2;
            } catch (Throwable th7) {
                ci.a(th7, "AuthConfigManager", "load 151");
            }
        }
        if (bw.a(jSONObject, "17S")) {
            try {
                JSONObject jSONObject4 = jSONObject.getJSONObject("17S");
                if (!(jSONObject4 == null || (a4 = a(jSONObject4.optString("able"), false)) == o)) {
                    o = a4;
                    if (context != null) {
                        SharedPreferences.Editor a5 = co.a(context, "open_common");
                        co.a(a5, "a2", a4);
                        co.a(a5);
                    }
                }
                if (jSONObject4 != null) {
                    boolean a6 = a(jSONObject4.optString("static_enable"), true);
                    boolean a7 = a(jSONObject4.optString("static_ip_direct_enable"), false);
                    int optInt = jSONObject4.optInt("static_timeout", 5) * 1000;
                    int optInt2 = jSONObject4.optInt("static_retry", 3);
                    str4 = "ustv";
                    try {
                        a2 = a(jSONObject4.optString("bgp_enable"), true);
                        str3 = "ust";
                        try {
                            a3 = a(jSONObject4.optString("bgp_ip_direct_enable"), false);
                            str2 = "umv";
                        } catch (Throwable th8) {
                            th = th8;
                            str2 = "umv";
                            ci.a(th, "AuthConfigManager", "load 17S");
                            if (bw.a(jSONObject, "15K")) {
                            }
                            context2 = context;
                            if (bw.a(jSONObject, "183")) {
                            }
                            if (bw.a(jSONObject, "17I")) {
                            }
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        str3 = "ust";
                        str2 = "umv";
                        ci.a(th, "AuthConfigManager", "load 17S");
                        if (bw.a(jSONObject, "15K")) {
                        }
                        context2 = context;
                        if (bw.a(jSONObject, "183")) {
                        }
                        if (bw.a(jSONObject, "17I")) {
                        }
                    }
                    try {
                        int optInt3 = jSONObject4.optInt("bgp_retry", 3);
                        boolean a8 = a(jSONObject4.optString("perf_data_upload_enable"), false);
                        if (!(a6 == f && a7 == g && optInt == e && optInt2 == x && a2 == h && a3 == i && optInt3 == y && a8 == j)) {
                            f = a6;
                            g = a7;
                            e = optInt;
                            x = optInt2;
                            h = a2;
                            i = a3;
                            y = optInt3;
                            j = a8;
                            if (context != null) {
                                SharedPreferences.Editor a9 = co.a(context, "open_common");
                                co.a(a9, "a13", a6);
                                co.a(a9, "a6", a2);
                                co.a(a9, "a7", a7);
                                co.a(a9, "a8", optInt);
                                co.a(a9, "a9", optInt2);
                                co.a(a9, "a10", a3);
                                co.a(a9, "a11", optInt3);
                                co.a(a9, "a12", a8);
                                co.a(a9);
                            }
                        }
                        dc.a();
                        dc.a();
                        dc.a();
                        dc.a();
                        dc.a();
                    } catch (Throwable th10) {
                        th = th10;
                        ci.a(th, "AuthConfigManager", "load 17S");
                        if (bw.a(jSONObject, "15K")) {
                        }
                        context2 = context;
                        if (bw.a(jSONObject, "183")) {
                        }
                        if (bw.a(jSONObject, "17I")) {
                        }
                    }
                    if (bw.a(jSONObject, "15K")) {
                        try {
                            JSONObject jSONObject5 = jSONObject.getJSONObject("15K");
                            if (jSONObject5 != null) {
                                boolean a10 = a(jSONObject5.optString("ucf"), f.a);
                                boolean a11 = a(jSONObject5.optString("fsv2"), f.b);
                                boolean a12 = a(jSONObject5.optString("usc"), f.c);
                                int optInt4 = jSONObject5.optInt(str2, f.d);
                                boolean a13 = a(jSONObject5.optString(str3), f.e);
                                int optInt5 = jSONObject5.optInt(str4, f.f);
                                if (!(a10 == f.a && a11 == f.b && a12 == f.c && optInt4 == f.d && a13 == f.e && optInt5 == f.d)) {
                                    f.a = a10;
                                    f.b = a11;
                                    f.c = a12;
                                    f.d = optInt4;
                                    f.e = a13;
                                    f.f = optInt5;
                                    context2 = context;
                                    try {
                                        SharedPreferences.Editor a14 = co.a(context2, "open_common");
                                        co.a(a14, "ucf", f.a);
                                        co.a(a14, "fsv2", f.b);
                                        co.a(a14, "usc", f.c);
                                        co.a(a14, str2, f.d);
                                        co.a(a14, str3, f.e);
                                        co.a(a14, str4, f.f);
                                        co.a(a14);
                                    } catch (Throwable unused) {
                                    }
                                    if (bw.a(jSONObject, "183")) {
                                        try {
                                            db.a(bvVar, jSONObject.getJSONObject("183"));
                                        } catch (Throwable th11) {
                                            ci.a(th11, "AuthConfigManager", "load 183");
                                        }
                                    }
                                    if (bw.a(jSONObject, "17I")) {
                                        try {
                                            JSONObject jSONObject6 = jSONObject.getJSONObject("17I");
                                            boolean a15 = a(jSONObject6.optString("na"), false);
                                            boolean a16 = a(jSONObject6.optString("aa"), false);
                                            cf.d = a15;
                                            cf.e = a16;
                                            SharedPreferences.Editor a17 = co.a(context2, "open_common");
                                            co.a(a17, "a4", a15);
                                            co.a(a17, "a5", a16);
                                            co.a(a17);
                                            return;
                                        } catch (Throwable th12) {
                                            ci.a(th12, "AuthConfigManager", "load 17I");
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th13) {
                            context2 = context;
                            ci.a(th13, "AuthConfigManager", "load 15K");
                        }
                    }
                    context2 = context;
                    if (bw.a(jSONObject, "183")) {
                    }
                    if (bw.a(jSONObject, "17I")) {
                    }
                }
            } catch (Throwable th14) {
                th = th14;
                str4 = "ustv";
                str3 = "ust";
                str2 = "umv";
                ci.a(th, "AuthConfigManager", "load 17S");
                if (bw.a(jSONObject, "15K")) {
                }
                context2 = context;
                if (bw.a(jSONObject, "183")) {
                }
                if (bw.a(jSONObject, "17I")) {
                }
            }
        }
        str4 = "ustv";
        str3 = "ust";
        str2 = "umv";
        if (bw.a(jSONObject, "15K")) {
        }
        context2 = context;
        if (bw.a(jSONObject, "183")) {
        }
        if (bw.a(jSONObject, "17I")) {
        }
    }

    private static void d(Context context) {
        try {
            if (!w) {
                cf.d = co.a(context, "open_common", "a4", true);
                cf.e = co.a(context, "open_common", "a5", true);
                w = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(dc.c cVar) {
        if (cVar != null && j) {
            synchronized (D) {
                D.offer(cVar);
                dc.a();
            }
        }
    }

    public static boolean d(String str) {
        e a2;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f) {
                return false;
            }
            if (!(z.get(str) == null)) {
                return false;
            }
            Context context = c;
            if (context == null || (a2 = a(context, b(str, "a14"), "open_common")) == null || a2.a() < x) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void c() {
        try {
            e a2 = a(c, "IPV6_CONFIG_NAME", "open_common");
            String a3 = bw.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!a3.equals(a2.b)) {
                a2.a(a3);
                a2.c.set(0);
            }
            a2.c.incrementAndGet();
            a(c, "IPV6_CONFIG_NAME", "open_common", a2);
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String p2 = bo.p(context);
        if (!TextUtils.isEmpty(p2) && (num = q.get(p2.toUpperCase())) != null && num.intValue() >= 2) {
            return true;
        }
        return false;
    }

    private static void b(Context context) {
        if (context != null) {
            o = co.a(context, "open_common", "a2", true);
        }
    }

    public static synchronized void b(String str, boolean z2) {
        synchronized (bl.class) {
            a(str, z2, (String) null, (String) null, (String) null);
        }
    }

    public static synchronized void b(String str) {
        synchronized (bl.class) {
            if (u != null) {
                if (u.containsKey(str)) {
                    u.remove(str);
                }
            }
        }
    }

    private static synchronized void b(String str, long j2) {
        synchronized (bl.class) {
            try {
                if (v != null) {
                    if (v.containsKey(str)) {
                        if (t == null) {
                            t = new ConcurrentHashMap<>(8);
                        }
                        t.put(str, Long.valueOf(j2));
                        Context context = c;
                        if (context != null) {
                            SharedPreferences.Editor a2 = co.a(context, "open_common");
                            co.a(a2, str, j2);
                            co.a(a2);
                        }
                    }
                }
            } catch (Throwable th) {
                ci.a(th, "at", "ucut");
            }
        }
    }

    private static String b(String str, String str2) {
        String a2 = bs.a(str.getBytes());
        return str2 + JSMethod.NOT_SET + a2;
    }

    public static void b(dc.c cVar) {
        int i2;
        synchronized (B) {
            boolean z2 = false;
            for (int i3 = 0; i3 < B.size(); i3++) {
                dc.a aVar = B.get(i3);
                if (cVar.c.equals(aVar.b) && cVar.d.equals(aVar.e) && cVar.m == (i2 = aVar.f)) {
                    if (i2 == 1) {
                        aVar.i = ((((long) aVar.j.get()) * aVar.i) + cVar.f) / ((long) (aVar.j.get() + 1));
                    }
                    aVar.j.getAndIncrement();
                    z2 = true;
                }
            }
            if (!z2) {
                B.add(new dc.a(cVar));
            }
            dc.a();
        }
    }

    private static void a(Context context, bv bvVar, Throwable th) {
        a(context, bvVar, th.getMessage());
    }

    public static void a(String str, boolean z2, boolean z3, boolean z4) {
        if (!TextUtils.isEmpty(str) && c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("downLevel", String.valueOf(z2));
            String str2 = "0";
            hashMap.put("ant", bo.n(c) == 0 ? str2 : "1");
            if (z4) {
                hashMap.put("type", z2 ? m : n);
            } else {
                hashMap.put("type", z2 ? k : l);
            }
            if (!z3) {
                str2 = "1";
            }
            hashMap.put("status", str2);
            String jSONObject = new JSONObject(hashMap).toString();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    dl dlVar = new dl(c, StatServices.CATEGORY, "2.0", "O002");
                    dlVar.a(jSONObject);
                    dm.a(dlVar, c);
                } catch (bj unused) {
                }
            }
        }
    }

    public static void a(dc.c cVar) {
        if (cVar != null && c != null) {
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
            dc.a();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    dl dlVar = new dl(c, StatServices.CATEGORY, "2.0", "O008");
                    dlVar.a(jSONObject);
                    dm.a(dlVar, c);
                } catch (bj unused) {
                }
            }
        }
    }

    private static void a(Context context, bv bvVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", bvVar.b());
        hashMap.put("amap_sdk_version", bvVar.d());
        String jSONObject = new JSONObject(hashMap).toString();
        if (!TextUtils.isEmpty(jSONObject)) {
            try {
                dl dlVar = new dl(context, StatServices.CATEGORY, "2.0", "O001");
                dlVar.a(jSONObject);
                dm.a(dlVar, context);
            } catch (bj unused) {
            }
        }
    }

    public static boolean a() {
        e a2;
        if (c != null) {
            h();
            if (!b()) {
                return false;
            }
            if (i()) {
                return true;
            }
        }
        return o && (a2 = a(c, "IPV6_CONFIG_NAME", "open_common")) != null && a2.a() < 5;
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static void a(Context context, String str, String str2, e eVar) {
        if (eVar != null && !TextUtils.isEmpty(eVar.a)) {
            String b2 = eVar.b();
            if (!TextUtils.isEmpty(b2) && context != null) {
                SharedPreferences.Editor a2 = co.a(context, str2);
                a2.putString(str, b2);
                co.a(a2);
            }
        }
    }

    public static synchronized void a(Context context, bv bvVar, String str, a aVar) {
        synchronized (bl.class) {
            if (context != null && bvVar != null) {
                try {
                    if (c == null) {
                        c = context.getApplicationContext();
                    }
                    String b2 = bvVar.b();
                    if (!TextUtils.isEmpty(b2)) {
                        a(bvVar);
                        if (v == null) {
                            v = new ConcurrentHashMap<>(8);
                        }
                        if (u == null) {
                            u = new ConcurrentHashMap<>(8);
                        }
                        if (t == null) {
                            t = new ConcurrentHashMap<>(8);
                        }
                        if (!v.containsKey(b2)) {
                            d dVar = new d((byte) 0);
                            dVar.a = bvVar;
                            dVar.b = str;
                            dVar.c = aVar;
                            v.put(b2, dVar);
                            t.put(b2, Long.valueOf(co.b(c, "open_common", b2)));
                            d(c);
                        }
                    }
                } catch (Throwable th) {
                    ci.a(th, "at", "rglc");
                }
            }
        }
    }

    public static synchronized boolean a(String str, long j2) {
        synchronized (bl.class) {
            boolean z2 = false;
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (j2 > c(str)) {
                    long j3 = 0;
                    if (u != null && u.containsKey(str)) {
                        j3 = u.get(str).longValue();
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

    public static synchronized void a(final String str, boolean z2, final String str2, final String str3, final String str4) {
        synchronized (bl.class) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (u == null) {
                        u = new ConcurrentHashMap<>(8);
                    }
                    u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    if (v != null) {
                        if (v.containsKey(str)) {
                            if (!TextUtils.isEmpty(str)) {
                                if (z2) {
                                    db.a(true, str);
                                }
                                ed.a().b(new ee() {
                                    /* class com.amap.api.col.s.bl.AnonymousClass1 */

                                    @Override // com.amap.api.col.s.ee
                                    public final void a() {
                                        d dVar = (d) bl.v.get(str);
                                        if (dVar != null) {
                                            a aVar = dVar.c;
                                            b a2 = bl.a(bl.c, dVar.a, dVar.b, str2, str3, str4);
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
                ci.a(th, "at", "lca");
            }
        }
    }

    public static synchronized boolean a(String str) {
        synchronized (bl.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (v == null) {
                    return false;
                }
                if (u == null) {
                    u = new ConcurrentHashMap<>(8);
                }
                if (v.containsKey(str) && !u.containsKey(str)) {
                    u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    return true;
                }
                return false;
            } catch (Throwable th) {
                ci.a(th, "at", "cslct");
            }
        }
    }

    private static void a(bv bvVar) {
        if (bvVar != null) {
            try {
                if (!TextUtils.isEmpty(bvVar.b())) {
                    String d2 = bvVar.d();
                    if (TextUtils.isEmpty(d2)) {
                        d2 = bvVar.c();
                    }
                    if (!TextUtils.isEmpty(d2)) {
                        cf.a(bvVar.b(), d2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z2, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            dc.a();
            if (!f && !z2) {
                return;
            }
            if ((!i && z2) || TextUtils.isEmpty(str)) {
                return;
            }
            if (!z2) {
                if (z.get(str) == null) {
                    z.put(str, Boolean.TRUE);
                    a(b(str, "a14"), "open_common");
                }
            } else if (A.get(str) == null) {
                A.put(str, Boolean.TRUE);
                a(b(str, "a15"), "open_common");
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2) {
        e a2 = a(c, str, str2);
        String a3 = bw.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a3.equals(a2.b)) {
            a2.a(a3);
            a2.c.set(0);
        }
        a2.c.incrementAndGet();
        a(c, str, str2, a2);
    }

    public static void a(boolean z2, dc.a aVar) {
        if (C && aVar != null) {
            synchronized (B) {
                if (z2) {
                    Iterator<dc.a> it = B.iterator();
                    while (it.hasNext()) {
                        dc.a next = it.next();
                        if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                            if (next.j == aVar.j) {
                                it.remove();
                                dc.a();
                            } else {
                                next.j.set(next.j.get() - aVar.j.get());
                                dc.a();
                            }
                        }
                    }
                }
                C = false;
                Iterator<dc.a> it2 = B.iterator();
                dc.a();
                while (it2.hasNext()) {
                    dc.a next2 = it2.next();
                    String str = next2.e;
                    Objects.toString(next2.j);
                    dc.a();
                }
                dc.a();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    private static synchronized e a(Context context, String str, String str2) {
        e eVar;
        synchronized (bl.class) {
            if (!TextUtils.isEmpty(str)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= p.size()) {
                        break;
                    }
                    eVar = p.get(i2);
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
                e b2 = e.b(co.b(context, str2, str, ""));
                String a2 = bw.a(System.currentTimeMillis(), "yyyyMMdd");
                if (b2 == null) {
                    b2 = new e(str, a2, 0);
                }
                if (!a2.equals(b2.b)) {
                    b2.a(a2);
                    b2.c.set(0);
                }
                p.add(b2);
                return b2;
            }
            eVar = null;
            if (eVar == null) {
            }
        }
    }
}
