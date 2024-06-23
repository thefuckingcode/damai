package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: Taobao */
public final class bq {
    private volatile b a = new b((byte) 0);
    private co b = new co("HttpsDecisionUtil");

    /* compiled from: Taobao */
    private static class a {
        static bq a = new bq();
    }

    public static bq a() {
        return a.a;
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final boolean b() {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        return this.a.a();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        protected boolean a;
        private int b;
        private final boolean c;
        private boolean d;

        private b() {
            this.b = 0;
            this.a = true;
            this.c = true;
            this.d = false;
        }

        public final void a(Context context) {
            if (context != null && this.b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z) {
            this.d = z;
        }

        public final void a(boolean z) {
            this.a = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x002e A[RETURN] */
        public final boolean a() {
            boolean z;
            if (!this.d) {
                boolean z2 = Build.VERSION.SDK_INT >= 28;
                if (this.a) {
                    int i = this.b;
                    if (i <= 0) {
                        i = 28;
                    }
                    if (!(i >= 28)) {
                        z = false;
                        if (!(!z2 && z)) {
                            return true;
                        }
                        return false;
                    }
                }
                z = true;
                if (!(!z2 && z)) {
                }
            }
            return true;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final void a(Context context) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.a(co.a(context, "open_common", "a3", true));
        this.a.a(context);
        bx.a(context).a();
    }

    private static void b(Context context, boolean z) {
        SharedPreferences.Editor a2 = co.a(context, "open_common");
        co.a(a2, "a3", z);
        co.a(a2);
    }

    public final boolean b(boolean z) {
        if (c()) {
            return false;
        }
        if (z || b()) {
            return true;
        }
        return false;
    }

    public static void b(Context context) {
        b(context, true);
    }

    public final void a(boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.b(z);
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        b(context, z);
        this.a.a(z);
    }

    public static String a(String str) {
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
}
