package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import tb.y13;

/* compiled from: Taobao */
public final class q1 {
    private volatile b a = new b((byte) 0);

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        static q1 a = new q1();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private int a;
        protected boolean b;
        private boolean c;

        private b() {
            this.a = 0;
            this.b = true;
            this.c = false;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void a(Context context) {
            if (context != null && this.a <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.a = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z) {
            this.b = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x002e A[RETURN] */
        public final boolean c() {
            boolean z;
            if (!this.c) {
                boolean z2 = Build.VERSION.SDK_INT >= 28;
                if (this.b) {
                    int i = this.a;
                    if (i <= 0) {
                        i = 28;
                    }
                    if (!(i >= 28)) {
                        z = false;
                        return !(!z2 && z);
                    }
                }
                z = true;
                if (!(!z2 && z)) {
                }
            }
        }
    }

    public q1() {
        new y13("HttpsDecisionUtil");
    }

    public static q1 a() {
        return a.a;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.scheme("https");
            return buildUpon.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void f(Context context) {
        g(context, true);
    }

    private static void g(Context context, boolean z) {
        SharedPreferences.Editor b2 = y13.b(context, "open_common");
        y13.j(b2, "a3", z);
        y13.e(b2);
    }

    private static boolean i() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final void c(Context context) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.b(y13.k(context, "open_common", "a3", true));
        this.a.a(context);
        w1.a(context).b();
    }

    /* access modifiers changed from: package-private */
    public final void d(Context context, boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        g(context, z);
        this.a.b(z);
    }

    public final boolean e(boolean z) {
        if (i()) {
            return false;
        }
        return z || h();
    }

    public final boolean h() {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        return this.a.c();
    }
}
