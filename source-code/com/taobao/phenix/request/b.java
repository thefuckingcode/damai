package com.taobao.phenix.request;

import android.text.TextUtils;
import tb.ge;
import tb.i42;
import tb.pb2;

/* compiled from: Taobao */
public class b {
    private static final int[] k = {10, 30, 60, 100, 200, 300, 500, 800, 1100, 1500};
    private final ge a;
    private final i42 b;
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i;
    private String j;

    public b(String str, ge geVar) {
        this.a = geVar;
        this.c = str;
        if (str == null) {
            this.b = new i42(1);
            return;
        }
        i42 d2 = i42.d(str);
        this.b = d2;
        if (d2.c() && d2.g) {
            this.i = pb2.f(d2.e, d2.f);
        }
    }

    private int c(int i2) {
        int length = k.length;
        int i3 = length / 2;
        char c2 = 65535;
        while (i3 >= 0 && i3 < length) {
            int i4 = k[i3];
            if (i2 > i4) {
                if (c2 >= 0) {
                    if (c2 == 2) {
                        break;
                    }
                } else {
                    c2 = 1;
                }
                i3++;
            } else if (i2 >= i4) {
                break;
            } else {
                if (c2 >= 0) {
                    if (c2 == 1) {
                        break;
                    }
                } else {
                    c2 = 2;
                }
                i3--;
            }
        }
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 >= length) {
            i3 = length - 1;
        } else {
            if (c2 == 1) {
                int[] iArr = k;
                if (i2 <= (iArr[i3 - 1] + iArr[i3]) / 2) {
                    i3--;
                }
            }
            if (c2 == 2) {
                int[] iArr2 = k;
                int i5 = i3 + 1;
                if (i2 > (iArr2[i3] + iArr2[i5]) / 2) {
                    i3 = i5;
                }
            }
        }
        return k[i3];
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.j == null) {
                this.j = str;
                return;
            }
            this.j += str;
        }
    }

    public boolean b() {
        return this.b.g;
    }

    public ge d() {
        return this.a;
    }

    public int e() {
        ge geVar = this.a;
        if (geVar != null) {
            return geVar.a(this.c, this.i);
        }
        return this.i;
    }

    public String f() {
        StringBuilder sb;
        if (this.h == null) {
            String str = this.b.b;
            if (str != null) {
                sb = new StringBuilder(str);
            } else {
                sb = new StringBuilder();
            }
            sb.append(this.b.d);
            String sb2 = sb.toString();
            this.h = sb2;
            ge geVar = this.a;
            if (geVar != null) {
                this.h = geVar.b(this.c, sb2);
            }
        }
        return this.h;
    }

    public String g() {
        StringBuilder sb;
        if (this.g == null) {
            String str = this.b.c;
            if (str != null) {
                sb = new StringBuilder(str);
            } else {
                sb = new StringBuilder();
            }
            this.g = sb.toString();
        }
        return this.g;
    }

    public int h() {
        return this.b.f;
    }

    public String i() {
        return this.b.d;
    }

    public String j() {
        StringBuilder sb;
        int i2;
        if (this.f == null) {
            String str = this.b.b;
            if (str != null) {
                sb = new StringBuilder(str);
            } else {
                sb = new StringBuilder();
            }
            int i3 = this.i;
            if (i3 != 0 || ((i2 = this.d) == 0 && this.e == 0)) {
                sb.append(i3);
            } else {
                sb.append(pb2.f(c(i2), c(this.e)));
            }
            String sb2 = sb.toString();
            this.f = sb2;
            ge geVar = this.a;
            if (geVar != null) {
                this.f = geVar.c(this.c, sb2);
            }
            if (!(this.f == null || this.j == null)) {
                this.f += this.j;
            }
        }
        return this.f;
    }

    public String k() {
        return this.c;
    }

    public i42 l() {
        return this.b;
    }

    public int m() {
        return this.b.e;
    }

    public boolean n() {
        return this.b.a();
    }

    /* access modifiers changed from: package-private */
    public void o(int i2, int i3) {
        this.d = i2;
        this.e = i3;
    }

    public String toString() {
        return "path: " + this.c + "\nscheme info: " + this.b + "\nbase cache catalog: " + e() + "\nmemory cache key: " + j() + "\ndisk cache key: " + f() + "\ndisk cache catalog: " + e();
    }
}
