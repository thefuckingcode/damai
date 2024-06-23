package com.alibaba.security.realidentity.jsbridge;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.common.d.b;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class g {
    private static final String a = "g";
    private static final List<a> b = new ArrayList();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        public String a;
        public Class<? extends a> b;

        public a(String str, Class<? extends a> cls) {
            this.a = str;
            this.b = cls;
        }

        private boolean a(String str) {
            String str2 = this.a;
            if (str2 == null) {
                return false;
            }
            String[] split = str2.split(",");
            if (TextUtils.equals(str, this.a) || Arrays.asList(split).contains(str)) {
                return true;
            }
            return false;
        }
    }

    public static void a() {
        b.clear();
    }

    public static void a(Class<? extends a>[] clsArr) {
        String str;
        if (clsArr != null) {
            try {
                for (Class<? extends a> cls : clsArr) {
                    f fVar = (f) cls.getAnnotation(f.class);
                    if (fVar != null) {
                        str = fVar.a();
                    } else {
                        str = cls.getName();
                    }
                    b.add(new a(str, cls));
                }
            } catch (Throwable th) {
                a("JSTopic add exception", null, th);
            }
        }
    }

    private static void a(String str, String str2, Throwable th) {
        com.alibaba.security.common.c.a.c(a, th.getMessage());
        g.a.a.a(TrackLog.createSdkExceptionLog(str, str2, b.a(th)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[SYNTHETIC] */
    private static Class<? extends a> a(String str) {
        boolean z;
        for (a aVar : b) {
            String str2 = aVar.a;
            if (str2 != null) {
                String[] split = str2.split(",");
                if (TextUtils.equals(str, aVar.a) || Arrays.asList(split).contains(str)) {
                    z = true;
                    continue;
                    if (z) {
                        return aVar.b;
                    }
                }
            }
            z = false;
            continue;
            if (z) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035 A[SYNTHETIC] */
    public static boolean a(Context context, String str, String str2, h hVar) {
        Class<? extends a> cls;
        boolean z;
        Iterator<a> it = b.iterator();
        while (true) {
            if (!it.hasNext()) {
                cls = null;
                break;
            }
            a next = it.next();
            String str3 = next.a;
            if (str3 != null) {
                String[] split = str3.split(",");
                if (TextUtils.equals(str, next.a) || Arrays.asList(split).contains(str)) {
                    z = true;
                    continue;
                    if (z) {
                        cls = next.b;
                        break;
                    }
                }
            }
            z = false;
            continue;
            if (z) {
            }
        }
        if (cls != null) {
            try {
                ((a) cls.newInstance()).a(context, str2, hVar);
                return true;
            } catch (Throwable th) {
                a(str, str2, th);
            }
        }
        return false;
    }
}
