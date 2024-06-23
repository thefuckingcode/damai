package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import tb.ds1;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public abstract class d {

    /* compiled from: Taobao */
    public static final class b {
        private final double a;
        private final double b;

        public d a(double d) {
            ds1.d(!Double.isNaN(d));
            if (b.c(d)) {
                return new C0168d(d, this.b - (this.a * d));
            }
            return new e(this.a);
        }

        private b(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    /* compiled from: Taobao */
    private static final class c extends d {
        static final c a = new c();

        private c() {
        }

        public String toString() {
            return "NaN";
        }
    }

    /* renamed from: com.google.common.math.d$d  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private static final class C0168d extends d {
        final double a;
        final double b;

        C0168d(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.a), Double.valueOf(this.b));
        }
    }

    /* compiled from: Taobao */
    private static final class e extends d {
        final double a;

        e(double d) {
            this.a = d;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.a));
        }
    }

    public static d a() {
        return c.a;
    }

    public static d b(double d) {
        ds1.d(b.c(d));
        return new C0168d(0.0d, d);
    }

    public static b c(double d, double d2) {
        ds1.d(b.c(d) && b.c(d2));
        return new b(d, d2);
    }

    public static d d(double d) {
        ds1.d(b.c(d));
        return new e(d);
    }
}
