package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public final class f {
    private long a = 0;
    private double b = 0.0d;
    private double c = 0.0d;
    private double d = Double.NaN;
    private double e = Double.NaN;

    static double g(double d2, double d3) {
        if (Doubles.f(d2)) {
            return d3;
        }
        if (Doubles.f(d3) || d2 == d3) {
            return d2;
        }
        return Double.NaN;
    }

    public void a(double d2) {
        long j = this.a;
        if (j == 0) {
            this.a = 1;
            this.b = d2;
            this.d = d2;
            this.e = d2;
            if (!Doubles.f(d2)) {
                this.c = Double.NaN;
                return;
            }
            return;
        }
        this.a = j + 1;
        if (!Doubles.f(d2) || !Doubles.f(this.b)) {
            this.b = g(this.b, d2);
            this.c = Double.NaN;
        } else {
            double d3 = this.b;
            double d4 = d2 - d3;
            double d5 = d3 + (d4 / ((double) this.a));
            this.b = d5;
            this.c += d4 * (d2 - d5);
        }
        this.d = Math.min(this.d, d2);
        this.e = Math.max(this.e, d2);
    }

    public void b(Iterable<? extends Number> iterable) {
        for (Number number : iterable) {
            a(number.doubleValue());
        }
    }

    public void c(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(((Number) it.next()).doubleValue());
        }
    }

    public void d(double... dArr) {
        for (double d2 : dArr) {
            a(d2);
        }
    }

    public void e(int... iArr) {
        for (int i : iArr) {
            a((double) i);
        }
    }

    public void f(long... jArr) {
        for (long j : jArr) {
            a((double) j);
        }
    }

    public Stats h() {
        return new Stats(this.a, this.b, this.c, this.d, this.e);
    }
}
