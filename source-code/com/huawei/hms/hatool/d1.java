package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class d1 extends v {

    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[y0.values().length];
            a = iArr;
            iArr[y0.SN.ordinal()] = 1;
            a[y0.IMEI.ordinal()] = 2;
            try {
                a[y0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static e1 a(String str, String str2) {
        e1 a2 = v.a(str, str2);
        x0 c = z0.a().c(str, str2);
        a2.g(z0.a().a(c.c(str, str2)));
        a2.f(c.o(str, str2));
        a2.c(z0.a().f(str, str2));
        int i = a.a[c.a().ordinal()];
        if (i == 1) {
            a2.d(c.b());
        } else if (i == 2) {
            a2.b(c.b());
        } else if (i == 3) {
            a2.e(c.b());
        }
        return a2;
    }

    public static f1 a(String str, String str2, String str3, String str4) {
        f1 a2 = v.a(str, str2, str3, str4);
        String a3 = z0.a().a(c.c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String sha256Encrypt = SHA.sha256Encrypt(b.f() + a3 + currentTimeMillis);
        a2.f(String.valueOf(currentTimeMillis));
        a2.g(sha256Encrypt);
        return a2;
    }

    public static g1 a(String str, String str2, String str3) {
        g1 a2 = v.a(str, str2, str3);
        Pair<String, String> e = z0.a().e(str2, str);
        a2.f((String) e.first);
        a2.g((String) e.second);
        a2.h(f.b());
        a2.d(z0.a().d(str2, str));
        return a2;
    }

    public static C0314r a(List<q> list, String str, String str2, String str3, String str4) {
        y.c("hmsSdk", "generate UploadData");
        C0314r b = v.b(str, str2);
        if (b == null) {
            return null;
        }
        b.a(a(x.d().a(), str, str2, str3));
        b.a(a(str, str2));
        b.a(a(str2, str, str4));
        b.a(c.g(str, str2));
        b.a(list);
        return b;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> c = v.c(str, str3);
        Map<String, String> i = c.i(str, str2);
        if (i == null) {
            return c;
        }
        c.putAll(i);
        return c;
    }
}
