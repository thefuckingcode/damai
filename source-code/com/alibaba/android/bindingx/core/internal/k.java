package com.alibaba.android.bindingx.core.internal;

import androidx.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class k {
    private l a = new l(0.0d, 0.0d, 0.0d, 1.0d);
    private Double b = null;
    private Double c = null;
    private Double d = null;
    private double e = 0.0d;
    private double f = 0.0d;
    private double g = 0.0d;
    private final p h = new p(0.0d, 0.0d, 1.0d);
    private final h i = new h();
    private final l j = new l();
    private final l k = new l(-Math.sqrt(0.5d), 0.0d, 0.0d, Math.sqrt(0.5d));

    k(@Nullable Double d2, @Nullable Double d3, @Nullable Double d4) {
        this.b = d2;
        this.c = d3;
        this.d = d4;
    }

    private void b(l lVar, double d2, double d3, double d4, double d5) {
        this.i.a(d3, d2, -d4, "YXZ");
        lVar.d(this.i);
        lVar.a(this.k);
        lVar.a(this.j.c(this.h, -d5));
    }

    /* access modifiers changed from: package-private */
    public l a(double d2, double d3, double d4, double d5) {
        Double d6 = this.b;
        double radians = Math.toRadians(d6 != null ? d6.doubleValue() : d5 + this.e);
        Double d7 = this.c;
        double radians2 = Math.toRadians(d7 != null ? d7.doubleValue() : this.f + d3);
        Double d8 = this.d;
        b(this.a, radians, radians2, Math.toRadians(d8 != null ? d8.doubleValue() : d4 + this.g), 0.0d);
        return this.a;
    }
}
