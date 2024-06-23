package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.vpm.track.OnePlayTrack;
import io.flutter.stat.StatServices;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jl1;
import tb.q23;
import tb.t13;
import tb.v13;
import tb.y13;

/* compiled from: Taobao */
public final class y {
    public static volatile ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>(8);
    public static volatile List<String> b = Collections.synchronizedList(new ArrayList(8));
    private static volatile ConcurrentHashMap<String, b> c = new ConcurrentHashMap<>(8);
    private static Random d = new Random();
    private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>(8);
    private static List<d0> f = Collections.synchronizedList(new ArrayList(16));

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        String a;
        int b;
        double c;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* compiled from: Taobao */
    private static class b {
        q23 a;
        long b;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        Map<String, List<a>> a;
        Map<String, String> b;

        private c() {
            this.a = new HashMap(8);
            this.b = new HashMap(8);
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                return this.a.equals(cVar.a) && this.b.equals(cVar.b);
            }
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.a;
            int i = 0;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.b;
            if (map2 != null) {
                i = map2.hashCode();
            }
            return hashCode + i;
        }
    }

    public static synchronized String a(String str, String str2) throws k {
        synchronized (y.class) {
            try {
                System.currentTimeMillis();
                if (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str)) {
                        Context context = m.g;
                        try {
                            if (b == null) {
                                b = Collections.synchronizedList(new ArrayList(8));
                            }
                            if (context != null) {
                                if (!b.contains(str2)) {
                                    b.add(str2);
                                    String c2 = y13.c(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                    if (!TextUtils.isEmpty(c2)) {
                                        h(str2, new JSONObject(c2));
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            v13.e(th, "hlUtil", "llhl");
                        }
                        if (a == null || a.size() <= 0) {
                            return str;
                        }
                        if (!a.containsKey(str2)) {
                            return str;
                        }
                        c cVar = a.get(str2);
                        if (cVar == null) {
                            return str;
                        }
                        if (!m(str, cVar, str2)) {
                            return o(str, cVar, str2);
                        }
                        throw new k("服务QPS超限");
                    }
                }
                return str;
            } catch (k e2) {
                throw e2;
            } catch (Throwable th2) {
                v13.e(th2, "hlUtil", "pcr");
                return str;
            }
        }
    }

    public static void b() {
        try {
            Context context = m.g;
            if (context != null) {
                bs.e(p(), context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(c cVar, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray != null) {
                HashMap hashMap = new HashMap(8);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("api");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!optString.startsWith("/")) {
                                optString = "/".concat(optString);
                            }
                            if (optString.endsWith("/")) {
                                optString = optString.substring(0, optString.length() - 1);
                            }
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    a aVar = new a((byte) 0);
                                    aVar.a = optJSONObject2.optString(OnePlayTrack.PlayType.BEGIN);
                                    aVar.b = optJSONObject2.optInt("duration");
                                    aVar.c = optJSONObject2.optDouble("percent");
                                    arrayList.add(aVar);
                                }
                            }
                            hashMap.put(optString, arrayList);
                        }
                    }
                }
                cVar.a = hashMap;
            }
        } catch (Throwable th) {
            v13.e(th, "hlUtil", "pbr");
        }
    }

    public static synchronized void d(u1 u1Var, JSONObject jSONObject) {
        synchronized (y.class) {
            if (u1Var != null) {
                try {
                    String a2 = u1Var.a();
                    if (!TextUtils.isEmpty(a2)) {
                        if (jSONObject == null) {
                            e(a2);
                        }
                        if (!m.t(jSONObject.optString("able", null), false)) {
                            e(a2);
                            return;
                        }
                        y13.d(m.g, "Yb3Blbl9odHRwX2NvbnRyb2w", a2, jSONObject.toString());
                        h(a2, jSONObject);
                    }
                } catch (Throwable th) {
                    v13.e(th, "hlUtil", "par");
                }
            }
        }
    }

    private static synchronized void e(String str) {
        synchronized (y.class) {
            try {
                if (a.containsKey(str)) {
                    a.remove(str);
                }
                SharedPreferences.Editor b2 = y13.b(m.g, "Yb3Blbl9odHRwX2NvbnRyb2w");
                y13.f(b2, str);
                y13.e(b2);
            } catch (Throwable th) {
                v13.e(th, "hlUtil", "rc");
            }
        }
    }

    private static void f(String str, c cVar) {
        try {
            if (a == null) {
                a = new ConcurrentHashMap<>(8);
            }
            a.put(str, cVar);
        } catch (Throwable th) {
            v13.e(th, "hlUtil", "ucr");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        r1 = new org.json.JSONObject();
        r1.put("timestamp", java.lang.System.currentTimeMillis());
        r1.put("type", tb.t13.j);
        r1.put("name", r5);
        r1.put("version", tb.t13.a(r5));
        r1.put("hostname", r6 + com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + r7);
        r5 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r6 = new com.loc.d0(r0, io.flutter.stat.StatServices.CATEGORY, "2.0", "O005");
        r6.a(r5);
        com.loc.bs.d(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0083, code lost:
        return;
     */
    private static void g(String str, String str2, String str3) {
        try {
            Context context = m.g;
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                if (e == null) {
                    e = new ConcurrentHashMap<>(8);
                }
                synchronized (e) {
                    if (!e.containsKey(str2)) {
                        e.put(str2, str3);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(String str, JSONObject jSONObject) {
        try {
            c cVar = new c((byte) 0);
            c(cVar, jSONObject);
            r(cVar, jSONObject);
            if (cVar.b == null && cVar.a == null) {
                e(str);
            } else {
                f(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(URL url, q23 q23) {
        List<String> list;
        try {
            if (c == null) {
                c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = q23.b;
            if (map != null && map.containsKey("nb") && (list = q23.b.get("nb")) != null) {
                if (list.size() > 0) {
                    String[] split = list.get(0).split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    if (split.length >= 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        long parseInt2 = (long) Integer.parseInt(split[1]);
                        b bVar = new b((byte) 0);
                        bVar.a = q23;
                        if (parseInt2 <= 0) {
                            parseInt2 = 30;
                        }
                        bVar.b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                        if (parseInt == 1) {
                            c.put("app", bVar);
                        } else if (parseInt == 2 && url != null) {
                            c.put(url.getPath(), bVar);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z, String str) {
        try {
            Context context = m.g;
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                jSONObject.put("type", z ? t13.g : t13.f);
                jSONObject.put("name", str);
                jSONObject.put("version", t13.a(str));
                String jSONObject2 = jSONObject.toString();
                d0 d0Var = new d0(context, StatServices.CATEGORY, "2.0", "O005");
                d0Var.a(jSONObject2);
                bs.d(d0Var, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void k(boolean z, String str, String str2, int i) {
        String str3;
        Integer num;
        try {
            Context context = m.g;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    String a2 = t13.a(str);
                    if (z) {
                        str3 = "type";
                        num = t13.i;
                    } else {
                        str3 = "type";
                        num = t13.h;
                    }
                    jSONObject.put(str3, num);
                    jSONObject.put("name", str);
                    jSONObject.put("version", a2);
                    jSONObject.put("uri", Uri.parse(str2).getPath());
                    jSONObject.put("blockLevel", i);
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        d0 d0Var = new d0(context, StatServices.CATEGORY, "2.0", "O005");
                        d0Var.a(jSONObject2);
                        if (f == null) {
                            f = Collections.synchronizedList(new ArrayList(16));
                        }
                        synchronized (f) {
                            f.add(d0Var);
                            if (f.size() >= 15) {
                                b();
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean l(a aVar) {
        if (aVar == null || aVar.c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.a) && aVar.b > 0) {
            long timeInMillis = currentTimeMillis - v1.i(aVar.a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < ((long) (aVar.b * 1000))) {
                if (aVar.c == 0.0d) {
                    return true;
                }
                if (d == null) {
                    d = new Random();
                }
                d.setSeed(((long) UUID.randomUUID().hashCode()) + currentTimeMillis);
                if (d.nextDouble() > aVar.c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(String str, c cVar, String str2) {
        try {
            Map<String, List<a>> map = cVar.a;
            if (map != null) {
                if (map.size() > 0) {
                    if (map.containsKey(jl1.MUL)) {
                        for (Map.Entry<String, List<a>> entry : map.entrySet()) {
                            if (n(entry.getValue())) {
                                k(false, str2, str, 1);
                                return true;
                            }
                        }
                    } else {
                        String path = Uri.parse(str).getPath();
                        if (map.containsKey(path) && n(map.get(path))) {
                            k(false, str2, str, 2);
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            v13.e(th, "hlUtil", "inb");
        }
    }

    private static boolean n(List<a> list) {
        if (list != null && list.size() > 0) {
            for (a aVar : list) {
                if (l(aVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String o(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.b;
            if (map != null) {
                if (map.size() > 0) {
                    Uri parse = Uri.parse(str);
                    String authority = parse.getAuthority();
                    if (!map.containsKey(authority)) {
                        return str;
                    }
                    String str3 = map.get(authority);
                    String builder = parse.buildUpon().authority(str3).toString();
                    g(str2, authority, str3);
                    return builder;
                }
            }
            return str;
        } catch (Throwable th) {
            v13.e(th, "hlUtil", "pdr");
            return str;
        }
    }

    public static List<d0> p() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f) {
                try {
                    List<d0> list = f;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            arrayList.addAll(f);
                            f.clear();
                            arrayList2 = arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable unused) {
                                return arrayList;
                            }
                        }
                    }
                    return arrayList2;
                } catch (Throwable th3) {
                    arrayList = null;
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static q23 q(String str, String str2) {
        Uri parse;
        String str3 = "app";
        try {
            if (c == null) {
                return null;
            }
            if (c.containsKey(str3)) {
                b bVar = c.get(str3);
                if (SystemClock.elapsedRealtime() <= bVar.b) {
                    q23 q23 = bVar.a;
                    k(true, str2, str, 1);
                    return q23;
                }
            } else {
                if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
                    str3 = parse.getPath();
                    if (c.containsKey(str3)) {
                        b bVar2 = c.get(str3);
                        if (SystemClock.elapsedRealtime() <= bVar2.b) {
                            q23 q232 = bVar2.a;
                            k(true, str2, str, 2);
                            return q232;
                        }
                    }
                }
                return null;
            }
            c.remove(str3);
            return null;
        } catch (Throwable unused) {
        }
    }

    private static void r(c cVar, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (!(optJSONObject == null || (names = optJSONObject.names()) == null)) {
                HashMap hashMap = new HashMap(8);
                int length = names.length();
                for (int i = 0; i < length; i++) {
                    String optString = names.optString(i);
                    hashMap.put(optString, optJSONObject.optString(optString));
                }
                cVar.b = hashMap;
            }
        } catch (Throwable th) {
            v13.e(th, "hlUtil", "pdr");
        }
    }
}
