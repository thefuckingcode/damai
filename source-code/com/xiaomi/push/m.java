package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tb.gl1;
import tb.jl1;

/* compiled from: Taobao */
public class m {
    private static volatile int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, q> f810a = null;
    private static int b = -1;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024 A[Catch:{ all -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ all -> 0x0029 }] */
    public static int a() {
        boolean z;
        if (a == 0) {
            try {
                int i = 1;
                if (TextUtils.isEmpty(m732a("ro.miui.ui.version.code"))) {
                    if (TextUtils.isEmpty(m732a("ro.miui.ui.version.name"))) {
                        z = false;
                        if (z) {
                            i = 2;
                        }
                        a = i;
                        b.b("isMIUI's value is: " + a);
                    }
                }
                z = true;
                if (z) {
                }
                a = i;
            } catch (Throwable th) {
                b.a("get isMIUI failed", th);
                a = 0;
            }
            b.b("isMIUI's value is: " + a);
        }
        return a;
    }

    public static int a(Context context) {
        String a2 = m732a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(a2) || !TextUtils.isDigitsOnly(a2)) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static q a(String str) {
        q b2 = b(str);
        return b2 == null ? q.Global : b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m731a() {
        int a2 = v.a();
        return (!m734a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : Constants.Name.STABLE;
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        String a2;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                }
                sb.append(str);
                sb.append(a.h);
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    a2 = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    a2 = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    a2 = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    a2 = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    a2 = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    a2 = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    a2 = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    a2 = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    a2 = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    a2 = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    a2 = a((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(a2);
                z = false;
            }
        }
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m732a(String str) {
        try {
            return (String) bk.a("android.os.SystemProperties", gl1.TYPE_OPEN_URL_METHOD_GET, str, "");
        } catch (Exception e) {
            b.d("fail to get property. " + e);
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m733a() {
        if (f810a == null) {
            HashMap hashMap = new HashMap();
            f810a = hashMap;
            hashMap.put("CN", q.China);
            Map<String, q> map = f810a;
            q qVar = q.Europe;
            map.put("FI", qVar);
            f810a.put("SE", qVar);
            f810a.put("NO", qVar);
            f810a.put("FO", qVar);
            f810a.put("EE", qVar);
            f810a.put("LV", qVar);
            f810a.put("LT", qVar);
            f810a.put("BY", qVar);
            f810a.put("MD", qVar);
            f810a.put("UA", qVar);
            f810a.put("PL", qVar);
            f810a.put("CZ", qVar);
            f810a.put("SK", qVar);
            f810a.put("HU", qVar);
            f810a.put("DE", qVar);
            f810a.put("AT", qVar);
            f810a.put("CH", qVar);
            f810a.put("LI", qVar);
            f810a.put("GB", qVar);
            f810a.put("IE", qVar);
            f810a.put("NL", qVar);
            f810a.put("BE", qVar);
            f810a.put("LU", qVar);
            f810a.put("FR", qVar);
            f810a.put("RO", qVar);
            f810a.put("BG", qVar);
            f810a.put("RS", qVar);
            f810a.put("MK", qVar);
            f810a.put("AL", qVar);
            f810a.put("GR", qVar);
            f810a.put("SI", qVar);
            f810a.put("HR", qVar);
            f810a.put("IT", qVar);
            f810a.put("SM", qVar);
            f810a.put("MT", qVar);
            f810a.put("ES", qVar);
            f810a.put("PT", qVar);
            f810a.put("AD", qVar);
            f810a.put("CY", qVar);
            f810a.put("DK", qVar);
            f810a.put("IS", qVar);
            f810a.put("UK", qVar);
            f810a.put("EL", qVar);
            f810a.put("RU", q.Russia);
            f810a.put("IN", q.India);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m734a() {
        return a() == 1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m735a(Context context) {
        return context != null && m736a(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m736a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static q b(String str) {
        m733a();
        return f810a.get(str.toUpperCase());
    }

    public static String b() {
        String a2 = u.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = m737b(u.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = u.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            b.m182a("get region from system, region = " + a2);
        }
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String country = Locale.getDefault().getCountry();
        b.m182a("locale.default.country = " + country);
        return country;
    }

    /* renamed from: b  reason: collision with other method in class */
    private static String m737b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split("-");
        return split.length > 0 ? split[0] : str;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m738b() {
        return a() == 2;
    }

    public static String c() {
        return m732a("ro.miui.ui.version.name");
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m739c() {
        if (b < 0) {
            b = !m741e() ? 1 : 0;
        }
        return b > 0;
    }

    public static String d() {
        return m732a("ro.build.characteristics");
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m740d() {
        return !q.China.name().equalsIgnoreCase(a(b()).name());
    }

    public static String e() {
        return m732a("ro.product.manufacturer");
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m741e() {
        String str = "";
        try {
            str = u.a("ro.miui.ui.version.code", str);
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }
}
