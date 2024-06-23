package com.loc;

import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
public final class b1 {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public long e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = -113;
    public int l = 0;
    public short m = 0;
    public boolean n = false;
    public int o = 32767;
    public int p = Integer.MAX_VALUE;
    public int q = Integer.MAX_VALUE;
    public boolean r = true;
    public int s = 99;
    public long t = 0;

    public b1(int i2, boolean z) {
        this.l = i2;
        this.n = z;
    }

    private String e() {
        int i2 = this.l;
        return this.l + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.a + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.b + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + 0L + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + a();
    }

    private String f() {
        return this.l + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.i + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.j;
    }

    public final long a() {
        return this.l == 5 ? this.e : (long) this.d;
    }

    public final String b() {
        int i2 = this.l;
        if (i2 != 1) {
            if (i2 == 2) {
                return f();
            }
            if (!(i2 == 3 || i2 == 4 || i2 == 5)) {
                return null;
            }
        }
        return e();
    }

    public final String c() {
        String b2 = b();
        if (b2 == null || b2.length() <= 0) {
            return "";
        }
        boolean z = this.r;
        return (z ? 1 : 0) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + b2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final b1 clone() {
        b1 b1Var = new b1(this.l, this.n);
        b1Var.a = this.a;
        b1Var.b = this.b;
        b1Var.c = this.c;
        b1Var.d = this.d;
        b1Var.e = this.e;
        b1Var.f = this.f;
        b1Var.g = this.g;
        b1Var.h = this.h;
        b1Var.i = this.i;
        b1Var.j = this.j;
        b1Var.k = this.k;
        b1Var.m = this.m;
        b1Var.o = this.o;
        b1Var.p = this.p;
        b1Var.q = this.q;
        b1Var.r = this.r;
        b1Var.s = this.s;
        b1Var.t = this.t;
        return b1Var;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b1)) {
            b1 b1Var = (b1) obj;
            int i2 = b1Var.l;
            if (i2 != 1) {
                return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 == 5 && this.l == 5 && b1Var.c == this.c && b1Var.e == this.e && b1Var.q == this.q : this.l == 4 && b1Var.c == this.c && b1Var.d == this.d && b1Var.b == this.b : this.l == 3 && b1Var.c == this.c && b1Var.d == this.d && b1Var.b == this.b : this.l == 2 && b1Var.j == this.j && b1Var.i == this.i && b1Var.h == this.h;
            }
            if (this.l == 1 && b1Var.c == this.c && b1Var.d == this.d && b1Var.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int hashCode = String.valueOf(this.l).hashCode();
        if (this.l == 2) {
            i3 = String.valueOf(this.j).hashCode() + String.valueOf(this.i).hashCode();
            i2 = this.h;
        } else {
            i3 = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
            i2 = this.b;
        }
        return hashCode + i3 + String.valueOf(i2).hashCode();
    }
}
