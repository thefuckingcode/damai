package tb;

import android.graphics.PointF;

/* compiled from: Taobao */
public class rv1 {
    public static final int POS_START = 0;
    protected int a = 0;
    private PointF b = new PointF();
    private float c;
    private float d;
    private int e = 0;
    private int f = 0;
    private int g;
    private int h = 0;
    private float i = 1.2f;
    private float j = 1.7f;
    private boolean k = false;
    private int l = -1;
    private int m = 0;

    public void A() {
        this.m = this.e;
    }

    /* access modifiers changed from: protected */
    public void B(int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void C(float f2, float f3, float f4, float f5) {
        F(f4, f5 / this.j);
    }

    public final void D(int i2) {
        int i3 = this.e;
        this.f = i3;
        this.e = i2;
        B(i2, i3);
    }

    public void E(int i2) {
        this.g = i2;
        K();
    }

    /* access modifiers changed from: protected */
    public void F(float f2, float f3) {
        this.c = f2;
        this.d = f3;
    }

    public void G(int i2) {
        this.l = i2;
    }

    public void H(int i2) {
        this.i = (((float) this.g) * 1.0f) / ((float) i2);
        this.a = i2;
    }

    public void I(float f2) {
        this.i = f2;
        this.a = (int) (((float) this.g) * f2);
    }

    public void J(float f2) {
        this.j = f2;
    }

    /* access modifiers changed from: protected */
    public void K() {
        this.a = (int) (this.i * ((float) this.g));
    }

    public boolean L(int i2) {
        return i2 < 0;
    }

    public void a(rv1 rv1) {
        this.e = rv1.e;
        this.f = rv1.f;
        this.g = rv1.g;
    }

    public boolean b() {
        return this.f < h() && this.e >= h();
    }

    public float c() {
        int i2 = this.g;
        if (i2 == 0) {
            return 0.0f;
        }
        return (((float) this.e) * 1.0f) / ((float) i2);
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        int i2 = this.l;
        return i2 >= 0 ? i2 : this.g;
    }

    public int h() {
        return this.a;
    }

    public float i() {
        return this.c;
    }

    public float j() {
        return this.d;
    }

    public float k() {
        return this.i;
    }

    public float l() {
        return this.j;
    }

    public boolean m() {
        return this.e >= this.m;
    }

    public boolean n() {
        return this.f != 0 && t();
    }

    public boolean o() {
        return this.f == 0 && q();
    }

    public boolean p() {
        int i2 = this.f;
        int i3 = this.g;
        return i2 < i3 && this.e >= i3;
    }

    public boolean q() {
        return this.e > 0;
    }

    public boolean r() {
        return this.e != this.h;
    }

    public boolean s(int i2) {
        return this.e == i2;
    }

    public boolean t() {
        return this.e == 0;
    }

    public boolean u() {
        return this.e > g();
    }

    public boolean v() {
        return this.e >= h();
    }

    public boolean w() {
        return this.k;
    }

    public final void x(float f2, float f3) {
        PointF pointF = this.b;
        C(f2, f3, f2 - pointF.x, f3 - pointF.y);
        this.b.set(f2, f3);
    }

    public void y(float f2, float f3) {
        this.k = true;
        this.h = this.e;
        this.b.set(f2, f3);
    }

    public void z() {
        this.k = false;
    }
}
