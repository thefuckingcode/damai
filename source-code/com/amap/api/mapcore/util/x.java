package com.amap.api.mapcore.util;

import com.amap.api.maps.model.BitmapDescriptor;

/* compiled from: Taobao */
public class x {
    private String a;
    private BitmapDescriptor b;
    private int c;
    private float d = 1.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 1.0f;
    private float h = 1.0f;
    private boolean i = false;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private int n = 0;

    public x(BitmapDescriptor bitmapDescriptor, int i2) {
        this.b = bitmapDescriptor;
        this.c = i2;
        this.a = ei.a();
        BitmapDescriptor bitmapDescriptor2 = this.b;
        if (bitmapDescriptor2 != null) {
            this.d = (float) ((((double) bitmapDescriptor2.getWidth()) * 1.0d) / ((double) this.b.getHeight()));
        }
    }

    public boolean a() {
        return this.i;
    }

    public float b() {
        return this.l;
    }

    public float c() {
        return this.m;
    }

    public float d() {
        return this.j;
    }

    public float e() {
        return this.k;
    }

    public float f() {
        return this.f;
    }

    public float g() {
        return this.e;
    }

    public float h() {
        return this.g;
    }

    public float i() {
        return this.h;
    }

    public BitmapDescriptor j() {
        return this.b;
    }

    public int k() {
        return this.c;
    }

    public float l() {
        return this.d;
    }

    public void m() {
        this.n++;
    }

    public void n() {
        this.n--;
    }

    public int o() {
        return this.n;
    }

    public String p() {
        return this.a;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(float f2) {
        this.m = f2;
    }

    public void c(float f2) {
        this.j = f2;
    }

    public void d(float f2) {
        this.k = f2;
    }

    public void e(float f2) {
        this.f = f2;
    }

    public void f(float f2) {
        this.e = f2;
    }

    public void g(float f2) {
        this.g = f2;
    }

    public void h(float f2) {
        this.h = f2;
    }

    public void a(float f2) {
        this.l = f2;
    }

    public void a(int i2) {
        this.c = i2;
    }
}
