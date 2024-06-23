package com.alibaba.android.bindingx.core.internal;

import androidx.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class l {
    double a;
    double b;
    double c;
    double d;

    l() {
    }

    /* access modifiers changed from: package-private */
    public l a(l lVar) {
        return b(this, lVar);
    }

    /* access modifiers changed from: package-private */
    public l b(l lVar, l lVar2) {
        double d2 = lVar.a;
        double d3 = lVar.b;
        double d4 = lVar.c;
        double d5 = lVar.d;
        double d6 = lVar2.a;
        double d7 = lVar2.b;
        double d8 = lVar2.c;
        double d9 = lVar2.d;
        this.a = (((d2 * d9) + (d5 * d6)) + (d3 * d8)) - (d4 * d7);
        this.b = (((d3 * d9) + (d5 * d7)) + (d4 * d6)) - (d2 * d8);
        this.c = (((d4 * d9) + (d5 * d8)) + (d2 * d7)) - (d3 * d6);
        this.d = (((d5 * d9) - (d2 * d6)) - (d3 * d7)) - (d4 * d8);
        return this;
    }

    /* access modifiers changed from: package-private */
    public l c(p pVar, double d2) {
        double d3 = d2 / 2.0d;
        double sin = Math.sin(d3);
        this.a = pVar.a * sin;
        this.b = pVar.b * sin;
        this.c = pVar.c * sin;
        this.d = Math.cos(d3);
        return this;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public l d(h hVar) {
        if (hVar == null || !hVar.e) {
            return null;
        }
        double cos = Math.cos(hVar.b / 2.0d);
        double cos2 = Math.cos(hVar.c / 2.0d);
        double cos3 = Math.cos(hVar.d / 2.0d);
        double sin = Math.sin(hVar.b / 2.0d);
        double sin2 = Math.sin(hVar.c / 2.0d);
        double sin3 = Math.sin(hVar.d / 2.0d);
        String str = hVar.a;
        if ("XYZ".equals(str)) {
            double d2 = sin * cos2;
            double d3 = cos * sin2;
            this.a = (d2 * cos3) + (d3 * sin3);
            this.b = (d3 * cos3) - (d2 * sin3);
            double d4 = cos * cos2;
            double d5 = sin * sin2;
            this.c = (d4 * sin3) + (d5 * cos3);
            this.d = (d4 * cos3) - (d5 * sin3);
        } else if ("YXZ".equals(str)) {
            double d6 = sin * cos2;
            double d7 = cos * sin2;
            this.a = (d6 * cos3) + (d7 * sin3);
            this.b = (d7 * cos3) - (d6 * sin3);
            double d8 = cos * cos2;
            double d9 = sin * sin2;
            this.c = (d8 * sin3) - (d9 * cos3);
            this.d = (d8 * cos3) + (d9 * sin3);
        } else if ("ZXY".equals(str)) {
            double d10 = sin * cos2;
            double d11 = cos * sin2;
            this.a = (d10 * cos3) - (d11 * sin3);
            this.b = (d11 * cos3) + (d10 * sin3);
            double d12 = cos * cos2;
            double d13 = sin * sin2;
            this.c = (d12 * sin3) + (d13 * cos3);
            this.d = (d12 * cos3) - (d13 * sin3);
        } else if ("ZYX".equals(str)) {
            double d14 = sin * cos2;
            double d15 = cos * sin2;
            this.a = (d14 * cos3) - (d15 * sin3);
            this.b = (d15 * cos3) + (d14 * sin3);
            double d16 = cos * cos2;
            double d17 = sin * sin2;
            this.c = (d16 * sin3) - (d17 * cos3);
            this.d = (d16 * cos3) + (d17 * sin3);
        } else if ("YZX".equals(str)) {
            double d18 = sin * cos2;
            double d19 = cos * sin2;
            this.a = (d18 * cos3) + (d19 * sin3);
            this.b = (d19 * cos3) + (d18 * sin3);
            double d20 = cos * cos2;
            double d21 = sin * sin2;
            this.c = (d20 * sin3) - (d21 * cos3);
            this.d = (d20 * cos3) - (d21 * sin3);
        } else if ("XZY".equals(str)) {
            double d22 = sin * cos2;
            double d23 = cos * sin2;
            this.a = (d22 * cos3) - (d23 * sin3);
            this.b = (d23 * cos3) - (d22 * sin3);
            double d24 = cos * cos2;
            double d25 = sin * sin2;
            this.c = (d24 * sin3) + (d25 * cos3);
            this.d = (d24 * cos3) + (d25 * sin3);
        }
        return this;
    }

    public String toString() {
        return "Quaternion{x=" + this.a + ", y=" + this.b + ", z=" + this.c + ", w=" + this.d + '}';
    }

    l(double d2, double d3, double d4, double d5) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
    }
}
