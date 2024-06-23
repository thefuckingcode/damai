package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.lang.ref.WeakReference;
import tb.d33;
import tb.f33;
import tb.r23;
import tb.t13;

/* compiled from: Taobao */
public class bq {
    static int a = 1000;
    static boolean b = false;
    private static WeakReference<r23> c = null;
    static int d = 20;
    private static int e = 10;
    static int f;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends ck {
        private int a;
        private Context b;
        private c0 c;

        a(Context context, int i) {
            this.b = context;
            this.a = i;
        }

        a(Context context, c0 c0Var) {
            this(context, 1);
            this.c = c0Var;
        }

        @Override // com.loc.ck
        public final void a() {
            int i = this.a;
            if (i == 1) {
                try {
                    synchronized (bq.class) {
                        String l = Long.toString(System.currentTimeMillis());
                        r23 d = e0.d(bq.c);
                        e0.e(this.b, d, al.i, bq.a, 2097152, "6");
                        if (d.e == null) {
                            d.e = new q(new s(new u(new s())));
                        }
                        b0.c(l, this.c.b(), d);
                    }
                } catch (Throwable th) {
                    an.m(th, "ofm", "aple");
                }
            } else if (i == 2) {
                try {
                    r23 d2 = e0.d(bq.c);
                    e0.e(this.b, d2, al.i, bq.a, 2097152, "6");
                    d2.h = 14400000;
                    if (d2.g == null) {
                        q qVar = new q(new s(new u()));
                        d2.g = new i0(new h0(this.b, new n0(), qVar, new String(t13.c(10)), l.j(this.b), o.h0(this.b), o.W(this.b), o.R(this.b), o.v(), Build.getMANUFACTURER(), android.os.Build.DEVICE, o.k0(this.b), l.g(this.b), Build.getMODEL(), l.h(this.b), l.e(this.b), o.Q(this.b), o.w(this.b), String.valueOf(Build.VERSION.SDK_INT)));
                    }
                    if (TextUtils.isEmpty(d2.i)) {
                        d2.i = "fKey";
                    }
                    Context context = this.b;
                    d2.f = new f33(context, d2.h, d2.i, new d33(context, bq.b, bq.e * 1024, bq.d * 1024, "offLocKey", bq.f * 1024));
                    b0.a(d2);
                } catch (Throwable th2) {
                    an.m(th2, "ofm", "uold");
                }
            }
        }
    }

    public static synchronized void b(int i, boolean z, int i2, int i3) {
        synchronized (bq.class) {
            a = i;
            b = z;
            if (i2 < 10 || i2 > 100) {
                i2 = 20;
            }
            d = i2;
            if (i2 / 5 > e) {
                e = i2 / 5;
            }
            f = i3;
        }
    }

    public static void c(Context context) {
        o0.f().d(new a(context, 2));
    }

    public static synchronized void d(c0 c0Var, Context context) {
        synchronized (bq.class) {
            o0.f().d(new a(context, c0Var));
        }
    }
}
