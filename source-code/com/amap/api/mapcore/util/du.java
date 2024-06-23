package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.DPoint;

/* compiled from: Taobao */
public class du {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public du(double d2, double d3, double d4, double d5) {
        this.a = d2;
        this.b = d4;
        this.c = d3;
        this.d = d5;
        this.e = (d2 + d3) / 2.0d;
        this.f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.a <= d2 && d2 <= this.c && this.b <= d3 && d3 <= this.d;
    }

    public boolean b(du duVar) {
        return duVar.a >= this.a && duVar.c <= this.c && duVar.b >= this.b && duVar.d <= this.d;
    }

    public boolean a(DPoint dPoint) {
        return a(dPoint.x, dPoint.y);
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.c && this.a < d3 && d4 < this.d && this.b < d5;
    }

    public boolean a(du duVar) {
        return a(duVar.a, duVar.c, duVar.b, duVar.d);
    }
}
