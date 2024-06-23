package com.amap.api.mapcore.util;

import java.util.Locale;

/* compiled from: Taobao */
public final class la {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = -113;
    public int k = 0;
    public short l = 0;
    public long m = 0;
    public boolean n = false;
    public int o = 32767;
    public boolean p = true;

    public la(int i2, boolean z) {
        this.k = i2;
        this.n = z;
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final int c() {
        return this.h;
    }

    public final int d() {
        return this.i;
    }

    public final int e() {
        return this.j;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof la)) {
            la laVar = (la) obj;
            int i2 = laVar.k;
            if (i2 != 1) {
                return i2 != 2 ? i2 != 3 ? i2 == 4 && this.k == 4 && laVar.c == this.c && laVar.d == this.d && laVar.b == this.b : this.k == 3 && laVar.c == this.c && laVar.d == this.d && laVar.b == this.b : this.k == 2 && laVar.i == this.i && laVar.h == this.h && laVar.g == this.g;
            }
            if (this.k == 1 && laVar.c == this.c && laVar.d == this.d && laVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int hashCode = String.valueOf(this.k).hashCode();
        if (this.k == 2) {
            i3 = String.valueOf(this.i).hashCode() + String.valueOf(this.h).hashCode();
            i2 = this.g;
        } else {
            i3 = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
            i2 = this.b;
        }
        return hashCode + i3 + String.valueOf(i2).hashCode();
    }

    public final String toString() {
        int i2 = this.k;
        if (i2 == 1) {
            return String.format(Locale.CHINA, "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n));
        } else if (i2 == 2) {
            return String.format(Locale.CHINA, "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.i), Integer.valueOf(this.h), Integer.valueOf(this.g), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n));
        } else if (i2 == 3) {
            return String.format(Locale.CHINA, "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n), Integer.valueOf(this.o));
        } else if (i2 != 4) {
            return "unknown";
        } else {
            return String.format(Locale.CHINA, "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n), Integer.valueOf(this.o));
        }
    }
}
