package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.maps.AMapException;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import com.youku.live.livesdk.preloader.Preloader;
import io.flutter.stat.StatServices;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.o70;

/* compiled from: Taobao */
public class gd {
    public static int a = -1;
    public static String b = "";
    private static Context c = null;
    private static volatile boolean d = true;
    private static Vector<c> e = new Vector<>();
    private static Map<String, Integer> f = new HashMap();
    private static String g = null;
    private static long h = 0;

    /* compiled from: Taobao */
    public static class a {
        @Deprecated
        public c A;
        public c B;
        public b C;
        public b D;
        public b E;
        public b F;
        public f G;
        private boolean H;
        public String a;
        public int b = -1;
        @Deprecated
        public JSONObject c;
        @Deprecated
        public JSONObject d;
        @Deprecated
        public JSONObject e;
        @Deprecated
        public JSONObject f;
        @Deprecated
        public JSONObject g;
        @Deprecated
        public JSONObject h;
        @Deprecated
        public JSONObject i;
        @Deprecated
        public JSONObject j;
        @Deprecated
        public JSONObject k;
        @Deprecated
        public JSONObject l;
        @Deprecated
        public JSONObject m;
        @Deprecated
        public JSONObject n;
        @Deprecated
        public JSONObject o;
        @Deprecated
        public JSONObject p;
        @Deprecated
        public JSONObject q;
        @Deprecated
        public JSONObject r;
        @Deprecated
        public JSONObject s;
        @Deprecated
        public JSONObject t;
        @Deprecated
        public JSONObject u;
        @Deprecated
        public JSONObject v;
        public JSONObject w;
        public C0146a x;
        public d y;
        public e z;

        /* renamed from: com.amap.api.mapcore.util.gd$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static class C0146a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* compiled from: Taobao */
        public static class b {
            public boolean a;
            public String b;
            public String c;
            public String d;
            public boolean e;
        }

        /* compiled from: Taobao */
        public static class c {
            public String a;
            public String b;
        }

        /* compiled from: Taobao */
        public static class d {
            public String a;
            public String b;
            public String c;
        }

        /* compiled from: Taobao */
        public static class e {
            public boolean a;
        }

        /* compiled from: Taobao */
        public static class f {
            public boolean a;
            public boolean b;
            public boolean c;
            public String d;
            public String e;
            public String f;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends ie {
        private String f;
        private Map<String, String> g;
        private boolean h;

        b(Context context, gm gmVar, String str, Map<String, String> map) {
            super(context, gmVar);
            this.f = str;
            this.g = map;
            this.h = Build.VERSION.SDK_INT != 19;
        }

        private Map<String, String> l() {
            String w = gg.w(this.d);
            if (TextUtils.isEmpty(w)) {
                w = gg.j(this.d);
            }
            if (!TextUtils.isEmpty(w)) {
                w = gk.b(new StringBuilder(w).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.f);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.e.a());
            hashMap.put("version", this.e.b());
            hashMap.put("output", Preloader.KEY_JSON);
            hashMap.put("androidversion", Build.VERSION.SDK_INT + "");
            hashMap.put("deviceId", w);
            hashMap.put("manufacture", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
            Map<String, String> map = this.g;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.g);
            }
            hashMap.put("abitype", gn.a(this.d));
            hashMap.put("ext", this.e.e());
            return hashMap;
        }

        public boolean a() {
            return this.h;
        }

        @Override // com.amap.api.mapcore.util.ie
        public byte[] e() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ie
        public byte[] f() {
            return gn.a(gn.b(l()));
        }

        /* access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.ie
        public String g() {
            return LiveFullInfo.VER;
        }

        @Override // com.amap.api.mapcore.util.ii
        public Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getURL() {
            return this.h ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        private String a;
        private String b;
        private AtomicInteger c;

        public c(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = new AtomicInteger(i);
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
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

        public int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public static c b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new c(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str) {
        gc.a(context, str);
    }

    private static void b(Context context, JSONObject jSONObject) {
        boolean a2;
        if (jSONObject != null && (a2 = a(jSONObject.optString("able"), false)) != d) {
            d = a2;
            a(context, a2);
        }
    }

    public static boolean c() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String v = gg.v(context);
        if (!TextUtils.isEmpty(v) && (num = f.get(v.toUpperCase())) != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String v = gg.v(context);
        if (!TextUtils.isEmpty(v) && (num = f.get(v.toUpperCase())) != null && num.intValue() >= 2) {
            return true;
        }
        return false;
    }

    private static void e() {
        c b2 = b(c, "IPV6_CONFIG_NAME");
        String a2 = gn.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a2.equals(b2.b)) {
            b2.a(a2);
            b2.c.set(0);
        }
        b2.c.incrementAndGet();
        a(c, b2);
    }

    public static boolean a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            if (split[split.length - 1].charAt(4) % 2 == 1) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return z;
        }
    }

    public static void b() {
        try {
            Context context = c;
            if (context != null) {
                String v = gg.v(context);
                if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(v) && g.equals(v) && System.currentTimeMillis() - h < DateUtils.MILLIS_PER_MINUTE) {
                    return;
                }
                if (!TextUtils.isEmpty(v)) {
                    g = v;
                }
            } else if (System.currentTimeMillis() - h < 10000) {
                return;
            }
            h = System.currentTimeMillis();
            f.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!a((Inet6Address) address)) {
                                i |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(gn.c("FMTkyLjE2OC40My4"))) {
                                i |= 1;
                            }
                        }
                    }
                    if (i != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f.put("WIFI", Integer.valueOf(i));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f.put("MOBILE", Integer.valueOf(i));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ha.a(th, "at", "ipstack");
        }
    }

    public static a a(Context context, gm gmVar, String str, Map<String, String> map) {
        return a(context, gmVar, str, map, false);
    }

    public static a a(Context context, gm gmVar, String str, Map<String, String> map, boolean z) {
        return a(context, gmVar, str, map, z, "DEF_ID");
    }

    public static void a(Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x009d */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00de A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00df  */
    public static a a(Context context, gm gmVar, String str, Map<String, String> map, boolean z, String str2) {
        String str3;
        byte[] bArr;
        ik ikVar;
        String str4;
        String str5;
        gb e2;
        IllegalBlockSizeException e3;
        Throwable th;
        String sb;
        a aVar = new a();
        aVar.w = new JSONObject();
        gi.a().a(context);
        b(context);
        if (context != null) {
            c = context.getApplicationContext();
        }
        try {
            id idVar = new id();
            try {
                StringBuilder sb2 = new StringBuilder();
                str3 = str;
                try {
                    sb2.append(str3);
                    sb2.append(";");
                    sb2.append("15K");
                    sb2.append(";");
                    sb2.append("16H");
                    sb2.append(";");
                    sb2.append("17I");
                    sb2.append(";");
                    sb2.append("17S");
                    sb = sb2.toString();
                    b bVar = new b(context, gmVar, sb, map);
                    ikVar = idVar.a(bVar, bVar.a());
                    if (ikVar != null) {
                        try {
                            bArr = ikVar.a;
                        } catch (gb e4) {
                            e2 = e4;
                            str3 = sb;
                            bArr = null;
                            aVar.a = e2.a();
                            a(context, gmVar, e2.a());
                            hd.a(gmVar, "/v3/iasdkauth", e2);
                            str4 = null;
                            if (bArr == null) {
                            }
                        } catch (IllegalBlockSizeException e5) {
                            e3 = e5;
                            str3 = sb;
                            bArr = null;
                            a(context, gmVar, e3);
                            str4 = null;
                            if (bArr == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str3 = sb;
                            bArr = null;
                            hd.c(th, "at", o70.LOWER_PREFIX);
                            a(context, gmVar, th);
                            str4 = null;
                            if (bArr == null) {
                            }
                        }
                    } else {
                        bArr = null;
                    }
                    try {
                        str3 = sb;
                        str4 = a(bArr);
                    } catch (gb e6) {
                        e2 = e6;
                        str3 = sb;
                        aVar.a = e2.a();
                        a(context, gmVar, e2.a());
                        hd.a(gmVar, "/v3/iasdkauth", e2);
                        str4 = null;
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException e7) {
                        e3 = e7;
                        str3 = sb;
                        a(context, gmVar, e3);
                        str4 = null;
                        if (bArr == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = sb;
                        hd.c(th, "at", o70.LOWER_PREFIX);
                        a(context, gmVar, th);
                        str4 = null;
                        if (bArr == null) {
                        }
                    }
                    if (bArr == null) {
                        return aVar;
                    }
                    if (TextUtils.isEmpty(str4)) {
                        str4 = gn.a(bArr);
                    }
                    if (TextUtils.isEmpty(str4)) {
                        a(context, gmVar, "result is null");
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        if (jSONObject.has("status")) {
                            int i = jSONObject.getInt("status");
                            if (i == 1) {
                                a = 1;
                            } else if (i == 0) {
                                String str6 = "authcsid";
                                String str7 = "authgsid";
                                if (ikVar != null) {
                                    str6 = ikVar.c;
                                    str7 = ikVar.d;
                                }
                                gn.a(context, str6, str7, jSONObject);
                                a = 0;
                                if (jSONObject.has("info")) {
                                    b = jSONObject.getString("info");
                                }
                                if (jSONObject.has("infocode")) {
                                    str5 = jSONObject.getString("infocode");
                                } else {
                                    str5 = "";
                                }
                                hd.a(gmVar, "/v3/iasdkauth", b, str7, str6, str5);
                                if (a == 0) {
                                    aVar.a = b;
                                    return aVar;
                                }
                            }
                            try {
                                if (jSONObject.has("ver")) {
                                    aVar.b = jSONObject.getInt("ver");
                                }
                            } catch (Throwable th4) {
                                ha.a(th4, "at", o70.LOWER_PREFIX);
                            }
                            if (gn.a(jSONObject, "result")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                                a(context, str3, aVar, jSONObject2);
                                if (gn.a(jSONObject2, "17I")) {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("17I");
                                    boolean a2 = a(jSONObject3.optString("na"), false);
                                    boolean a3 = a(jSONObject3.optString("aa"), false);
                                    gy.e = a2;
                                    gy.f = a3;
                                }
                                a(context, jSONObject2);
                            }
                        }
                    } catch (Throwable th5) {
                        ha.a(th5, "at", o70.LOWER_PREFIX);
                    }
                    return aVar;
                } catch (gb e8) {
                    throw e8;
                } catch (Throwable unknown) {
                    throw new gb(AMapException.ERROR_UNKNOWN);
                }
            } catch (gb e9) {
                throw e9;
            } catch (gb e10) {
                throw e10;
            } catch (gb e11) {
                e2 = e11;
                ikVar = null;
                bArr = null;
                aVar.a = e2.a();
                a(context, gmVar, e2.a());
                hd.a(gmVar, "/v3/iasdkauth", e2);
                str4 = null;
                if (bArr == null) {
                }
            } catch (IllegalBlockSizeException e12) {
                e3 = e12;
                ikVar = null;
                bArr = null;
                a(context, gmVar, e3);
                str4 = null;
                if (bArr == null) {
                }
            } catch (Throwable th6) {
                th = th6;
                ikVar = null;
                bArr = null;
                hd.c(th, "at", o70.LOWER_PREFIX);
                a(context, gmVar, th);
                str4 = null;
                if (bArr == null) {
                }
            }
        } catch (gb e13) {
            e2 = e13;
            str3 = str;
            ikVar = null;
            bArr = null;
            aVar.a = e2.a();
            a(context, gmVar, e2.a());
            hd.a(gmVar, "/v3/iasdkauth", e2);
            str4 = null;
            if (bArr == null) {
            }
        } catch (IllegalBlockSizeException e14) {
            e3 = e14;
            str3 = str;
            ikVar = null;
            bArr = null;
            a(context, gmVar, e3);
            str4 = null;
            if (bArr == null) {
            }
        } catch (Throwable th7) {
            th = th7;
            str3 = str;
            ikVar = null;
            bArr = null;
            hd.c(th, "at", o70.LOWER_PREFIX);
            a(context, gmVar, th);
            str4 = null;
            if (bArr == null) {
            }
        }
    }

    public static void b(Context context) {
        if (context != null) {
            d = new hr("IPV6_CONFIG_NAME").b(context, "k", true);
        }
    }

    private static synchronized c b(Context context, String str) {
        synchronized (gd.class) {
            c a2 = a(str);
            if (a2 != null) {
                return a2;
            }
            if (context == null) {
                return null;
            }
            c b2 = c.b(new hr(str).a(context, "i"));
            String a3 = gn.a(System.currentTimeMillis(), "yyyyMMdd");
            if (b2 == null) {
                b2 = new c("IPV6_CONFIG_NAME", a3, 0);
            }
            if (!a3.equals(b2.b)) {
                b2.a(a3);
                b2.c.set(0);
            }
            e.add(b2);
            return b2;
        }
    }

    private static void a(Context context, String str, a aVar, JSONObject jSONObject) throws JSONException {
        a.C0146a aVar2 = new a.C0146a();
        aVar2.a = false;
        aVar2.b = false;
        aVar.x = aVar2;
        try {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    if (jSONObject.has(str2)) {
                        aVar.w.putOpt(str2, jSONObject.get(str2));
                    }
                }
            }
        } catch (Throwable th) {
            ha.a(th, "at", "co");
        }
        if (gn.a(jSONObject, "16H")) {
            aVar.H = a(jSONObject.getJSONObject("16H").optString("able"), false);
        }
        if (gn.a(jSONObject, "11K")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11K");
                aVar2.a = a(jSONObject2.getString("able"), false);
                if (jSONObject2.has("off")) {
                    aVar2.c = jSONObject2.getJSONObject("off");
                }
            } catch (Throwable th2) {
                ha.a(th2, "AuthConfigManager", "loadException");
            }
        }
        if (gn.a(jSONObject, "001")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("001");
            a.d dVar = new a.d();
            a(jSONObject3, dVar);
            aVar.y = dVar;
        }
        if (gn.a(jSONObject, "002")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("002");
            a.c cVar = new a.c();
            a(jSONObject4, cVar);
            aVar.A = cVar;
        }
        if (gn.a(jSONObject, "14S")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("14S");
            a.c cVar2 = new a.c();
            a(jSONObject5, cVar2);
            aVar.B = cVar2;
        }
        a(aVar, jSONObject);
        if (gn.a(jSONObject, "14Z")) {
            JSONObject jSONObject6 = jSONObject.getJSONObject("14Z");
            a.f fVar = new a.f();
            a(jSONObject6, fVar);
            aVar.G = fVar;
        }
        if (gn.a(jSONObject, "151")) {
            JSONObject jSONObject7 = jSONObject.getJSONObject("151");
            a.e eVar = new a.e();
            a(jSONObject7, eVar);
            aVar.z = eVar;
        }
        if (gn.a(jSONObject, "17S")) {
            b(context, jSONObject.getJSONObject("17S"));
        }
        a(aVar, jSONObject);
    }

    private static String a(byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[(bArr.length - 16)];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(gn.c()));
        return gn.a(instance.doFinal(bArr3));
    }

    private static void a(Context context, gm gmVar, Throwable th) {
        a(context, gmVar, th != null ? th.getMessage() : "on exception");
    }

    public static void a(String str, boolean z, boolean z2, boolean z3, long j) {
        if (!TextUtils.isEmpty(str) && c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("downLevel", String.valueOf(z2));
            String str2 = "0";
            hashMap.put("ant", gg.r(c) == 0 ? str2 : "1");
            hashMap.put("type", z ? "6" : "4");
            if (!z3) {
                str2 = "1";
            }
            hashMap.put("status", str2);
            hashMap.put("duration", "" + j);
            String jSONObject = new JSONObject(hashMap).toString();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    is isVar = new is(c, StatServices.CATEGORY, "1.0", "O002");
                    isVar.a(jSONObject);
                    it.a(isVar, c);
                } catch (gb unused) {
                }
            }
        }
    }

    private static void a(Context context, gm gmVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", gmVar.a());
        hashMap.put("amap_sdk_version", gmVar.c());
        String jSONObject = new JSONObject(hashMap).toString();
        if (!TextUtils.isEmpty(jSONObject)) {
            try {
                is isVar = new is(context, StatServices.CATEGORY, "1.0", "O001");
                isVar.a(jSONObject);
                it.a(isVar, context);
            } catch (gb unused) {
            }
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("15K");
            boolean a2 = a(jSONObject2.optString("isTargetAble"), false);
            if (!a(jSONObject2.optString("able"), false)) {
                gi.a().b(context);
            } else {
                gi.a().a(context, a2);
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str);
        }
        return "";
    }

    private static void a(JSONObject jSONObject, a.b bVar) {
        if (bVar != null) {
            try {
                String a2 = a(jSONObject, WXComponent.PROP_FS_MATCH_PARENT);
                String a3 = a(jSONObject, IRequestConst.U);
                String a4 = a(jSONObject, "v");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                bVar.c = a2;
                bVar.b = a3;
                bVar.d = a4;
                bVar.a = a(a5, false);
                bVar.e = a(a6, true);
            } catch (Throwable th) {
                ha.a(th, "at", "pe");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.f fVar) {
        if (fVar != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "md5info");
                String a4 = a(jSONObject, "url");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                String a7 = a(jSONObject, "mobileable");
                fVar.e = a2;
                fVar.f = a3;
                fVar.d = a4;
                fVar.a = a(a5, false);
                fVar.b = a(a6, false);
                fVar.c = a(a7, false);
            } catch (Throwable th) {
                ha.a(th, "at", "pes");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.c cVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                cVar.b = a2;
                cVar.a = a3;
            } catch (Throwable th) {
                ha.a(th, "at", "psc");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.d dVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                String a4 = a(jSONObject, "sdkversion");
                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
                    if (!TextUtils.isEmpty(a4)) {
                        dVar.a = a3;
                        dVar.b = a2;
                        dVar.c = a4;
                    }
                }
            } catch (Throwable th) {
                ha.a(th, "at", "psu");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.e eVar) {
        if (eVar != null && jSONObject != null) {
            eVar.a = a(jSONObject.optString("able"), false);
        }
    }

    private static void a(a aVar, JSONObject jSONObject) {
        try {
            if (gn.a(jSONObject, "11B")) {
                aVar.h = jSONObject.getJSONObject("11B");
            }
            if (gn.a(jSONObject, "11C")) {
                aVar.k = jSONObject.getJSONObject("11C");
            }
            if (gn.a(jSONObject, "11I")) {
                aVar.l = jSONObject.getJSONObject("11I");
            }
            if (gn.a(jSONObject, "11H")) {
                aVar.m = jSONObject.getJSONObject("11H");
            }
            if (gn.a(jSONObject, "11E")) {
                aVar.n = jSONObject.getJSONObject("11E");
            }
            if (gn.a(jSONObject, "11F")) {
                aVar.o = jSONObject.getJSONObject("11F");
            }
            if (gn.a(jSONObject, "13A")) {
                aVar.q = jSONObject.getJSONObject("13A");
            }
            if (gn.a(jSONObject, "13J")) {
                aVar.i = jSONObject.getJSONObject("13J");
            }
            if (gn.a(jSONObject, "11G")) {
                aVar.p = jSONObject.getJSONObject("11G");
            }
            if (gn.a(jSONObject, "006")) {
                aVar.r = jSONObject.getJSONObject("006");
            }
            if (gn.a(jSONObject, "010")) {
                aVar.s = jSONObject.getJSONObject("010");
            }
            if (gn.a(jSONObject, "11Z")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11Z");
                a.b bVar = new a.b();
                a(jSONObject2, bVar);
                aVar.C = bVar;
            }
            if (gn.a(jSONObject, "135")) {
                aVar.j = jSONObject.getJSONObject("135");
            }
            if (gn.a(jSONObject, "13S")) {
                aVar.g = jSONObject.getJSONObject("13S");
            }
            if (gn.a(jSONObject, "121")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("121");
                a.b bVar2 = new a.b();
                a(jSONObject3, bVar2);
                aVar.D = bVar2;
            }
            if (gn.a(jSONObject, "122")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("122");
                a.b bVar3 = new a.b();
                a(jSONObject4, bVar3);
                aVar.E = bVar3;
            }
            if (gn.a(jSONObject, "123")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("123");
                a.b bVar4 = new a.b();
                a(jSONObject5, bVar4);
                aVar.F = bVar4;
            }
            if (gn.a(jSONObject, "011")) {
                aVar.c = jSONObject.getJSONObject("011");
            }
            if (gn.a(jSONObject, "012")) {
                aVar.d = jSONObject.getJSONObject("012");
            }
            if (gn.a(jSONObject, "013")) {
                aVar.e = jSONObject.getJSONObject("013");
            }
            if (gn.a(jSONObject, "014")) {
                aVar.f = jSONObject.getJSONObject("014");
            }
            if (gn.a(jSONObject, "145")) {
                aVar.t = jSONObject.getJSONObject("145");
            }
            if (gn.a(jSONObject, "14B")) {
                aVar.u = jSONObject.getJSONObject("14B");
            }
            if (gn.a(jSONObject, "14D")) {
                aVar.v = jSONObject.getJSONObject("14D");
            }
        } catch (Throwable th) {
            hd.c(th, "at", "pe");
        }
    }

    public static boolean a() {
        c b2;
        if (c != null) {
            b();
            if (!d()) {
                return false;
            }
            if (c()) {
                return true;
            }
        }
        if (d && (b2 = b(c, "IPV6_CONFIG_NAME")) != null && b2.a() < 5) {
            return true;
        }
        return false;
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    public static void a(int i) {
        if (i == 2) {
            try {
                e();
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(Context context, boolean z) {
        if (context != null) {
            new hr("IPV6_CONFIG_NAME").a(context, "k", z);
        }
    }

    private static void a(Context context, c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.a)) {
            String b2 = cVar.b();
            if (!TextUtils.isEmpty(b2) && context != null) {
                new hr("IPV6_CONFIG_NAME").a(context, "i", b2);
            }
        }
    }

    private static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < e.size(); i++) {
            c cVar = e.get(i);
            if (cVar != null && str.equals(cVar.a)) {
                return cVar;
            }
        }
        return null;
    }
}
