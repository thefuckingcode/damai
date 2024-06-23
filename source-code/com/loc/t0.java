package com.loc;

import java.util.List;
import tb.b43;
import tb.j33;
import tb.m33;
import tb.q43;
import tb.x43;
import tb.y43;

/* compiled from: Taobao */
public final class t0 extends q0 {
    private static t0 c = new t0();

    private t0() {
        super(5120);
    }

    private static String b(String str) {
        return str == null ? "" : str;
    }

    public static t0 d() {
        return c;
    }

    public final byte[] c(byte[] bArr, byte[] bArr2, List<? extends j33> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int c2 = m33.c(this.a, bArr);
            int[] iArr = new int[size];
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                j33 j33 = (j33) list.get(i2);
                iArr[i2] = b43.b(this.a, (byte) j33.a(), b43.c(this.a, j33.b()));
            }
            int d = m33.d(this.a, iArr);
            if (bArr2 != null) {
                i = m33.f(this.a, bArr2);
            }
            this.a.w(m33.b(this.a, c2, i, d));
            return this.a.z();
        } catch (Throwable th) {
            y43.a(th);
            return null;
        }
    }

    public final byte[] e() {
        super.a();
        try {
            this.a.w(x43.b(this.a, q43.a(), this.a.b(q43.m()), this.a.b(q43.g()), (byte) q43.A(), this.a.b(q43.s()), this.a.b(q43.q()), this.a.b(b(q43.o())), this.a.b(b(q43.u())), y0.a(q43.C()), this.a.b(q43.y()), this.a.b(q43.w()), this.a.b(q43.i()), this.a.b(q43.k())));
            return this.a.z();
        } catch (Exception e) {
            y43.a(e);
            return null;
        }
    }
}
