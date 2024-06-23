package com.alibaba.android.bindingx.core.internal;

import androidx.annotation.NonNull;
import java.util.Map;

/* compiled from: Taobao */
class n extends PhysicsAnimationDriver {
    private long g;
    private boolean h;
    private double i;
    private double j;
    private double k;
    private double l;
    private boolean m;
    private final b n = new b();
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        double a;
        double b;

        private b() {
        }
    }

    n() {
    }

    private void j(double d) {
        double d2;
        double d3;
        if (!l()) {
            double d4 = 0.064d;
            if (d <= 0.064d) {
                d4 = d;
            }
            this.s += d4;
            double d5 = this.j;
            double d6 = this.k;
            double d7 = this.i;
            double d8 = -this.l;
            double sqrt = d5 / (Math.sqrt(d7 * d6) * 2.0d);
            double sqrt2 = Math.sqrt(d7 / d6);
            double sqrt3 = Math.sqrt(1.0d - (sqrt * sqrt)) * sqrt2;
            double d9 = this.p - this.o;
            double d10 = this.s;
            if (sqrt < 1.0d) {
                double exp = Math.exp((-sqrt) * sqrt2 * d10);
                double d11 = sqrt * sqrt2;
                double d12 = d8 + (d11 * d9);
                double d13 = d10 * sqrt3;
                d2 = this.p - ((((d12 / sqrt3) * Math.sin(d13)) + (Math.cos(d13) * d9)) * exp);
                d3 = ((d11 * exp) * (((Math.sin(d13) * d12) / sqrt3) + (Math.cos(d13) * d9))) - (((Math.cos(d13) * d12) - ((sqrt3 * d9) * Math.sin(d13))) * exp);
            } else {
                double exp2 = Math.exp((-sqrt2) * d10);
                double d14 = this.p - (((((sqrt2 * d9) + d8) * d10) + d9) * exp2);
                d3 = exp2 * ((d8 * ((d10 * sqrt2) - 1.0d)) + (d10 * d9 * sqrt2 * sqrt2));
                d2 = d14;
            }
            b bVar = this.n;
            bVar.a = d2;
            bVar.b = d3;
            if (l() || (this.m && m())) {
                if (this.i > 0.0d) {
                    double d15 = this.p;
                    this.o = d15;
                    this.n.a = d15;
                } else {
                    double d16 = this.n.a;
                    this.p = d16;
                    this.o = d16;
                }
                this.n.b = 0.0d;
            }
        }
    }

    private double k(b bVar) {
        return Math.abs(this.p - bVar.a);
    }

    private boolean m() {
        if (this.i > 0.0d) {
            double d = this.o;
            double d2 = this.p;
            return (d < d2 && this.n.a > d2) || (d > d2 && this.n.a < d2);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.alibaba.android.bindingx.core.internal.PhysicsAnimationDriver
    public void e(@NonNull Map<String, Object> map) {
        b bVar = this.n;
        double d = o.d(map, "initialVelocity", 0.0d);
        bVar.b = d;
        this.e = d;
        this.i = o.d(map, "stiffness", 100.0d);
        this.j = o.d(map, "damping", 10.0d);
        this.k = o.d(map, "mass", 1.0d);
        this.l = this.n.b;
        this.d = o.d(map, "fromValue", 0.0d);
        this.p = o.d(map, "toValue", 1.0d);
        this.q = o.d(map, "restSpeedThreshold", 0.001d);
        this.r = o.d(map, "restDisplacementThreshold", 0.001d);
        this.m = o.b(map, "overshootClamping", false);
        this.f = false;
        this.s = 0.0d;
        this.h = false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.alibaba.android.bindingx.core.internal.PhysicsAnimationDriver
    public void f(long j2) {
        if (!this.h) {
            b bVar = this.n;
            double d = this.d;
            bVar.a = d;
            this.o = d;
            this.g = j2;
            this.s = 0.0d;
            this.h = true;
        }
        j(((double) (j2 - this.g)) / 1000.0d);
        this.g = j2;
        b bVar2 = this.n;
        this.d = bVar2.a;
        this.e = bVar2.b;
        if (l()) {
            this.f = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return Math.abs(this.n.b) <= this.q && (k(this.n) <= this.r || this.i == 0.0d);
    }
}
