package com.loc;

import android.os.SystemClock;
import com.loc.u0;
import java.util.List;
import tb.a43;
import tb.c43;
import tb.d43;
import tb.e43;
import tb.f43;
import tb.g43;
import tb.h43;
import tb.i43;
import tb.j43;
import tb.l33;
import tb.l43;
import tb.n33;
import tb.o33;
import tb.p43;
import tb.y43;
import tb.z33;

/* compiled from: Taobao */
public final class r0 extends q0 {
    public r0() {
        super(2048);
    }

    private int b(long j, List<y0> list) {
        g(list);
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            y0 y0Var = list.get(i);
            int b = this.a.b(y0Var.b);
            long j2 = y0Var.a;
            iArr[i] = j43.b(this.a, j2 == j && j2 != -1, j2, (short) y0Var.c, b, y0Var.g, (short) y0Var.d);
        }
        return i43.b(this.a, i43.c(this.a, iArr));
    }

    private int c(u0.a aVar) {
        int i;
        int i2;
        s0 s0Var;
        int i3;
        int i4;
        int i5;
        byte b;
        int i6;
        e(aVar.f);
        int size = aVar.f.size();
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            dr drVar = aVar.f.get(i7);
            if (drVar instanceof dt) {
                dt dtVar = (dt) drVar;
                i5 = !dtVar.i ? d43.b(this.a, dtVar.j, dtVar.k, dtVar.c, dtVar.l) : d43.c(this.a, dtVar.b(), dtVar.c(), dtVar.j, dtVar.k, dtVar.c, dtVar.m, dtVar.n, dtVar.d, dtVar.l);
                i6 = -1;
                b = 1;
            } else if (drVar instanceof du) {
                du duVar = (du) drVar;
                i5 = e43.b(this.a, duVar.b(), duVar.c(), duVar.j, duVar.k, duVar.l, duVar.c, duVar.m, duVar.d);
                i6 = -1;
                b = 3;
            } else if (drVar instanceof ds) {
                ds dsVar = (ds) drVar;
                boolean z = dsVar.i;
                s0 s0Var2 = this.a;
                int i8 = dsVar.j;
                int i9 = dsVar.k;
                int i10 = dsVar.l;
                int i11 = dsVar.m;
                int i12 = dsVar.n;
                int i13 = dsVar.c;
                i5 = !z ? n33.b(s0Var2, i8, i9, i10, i11, i12, i13) : n33.c(s0Var2, i8, i9, i10, i11, i12, i13, dsVar.d);
                i6 = -1;
                b = 2;
            } else if (drVar instanceof dv) {
                dv dvVar = (dv) drVar;
                i5 = h43.b(this.a, dvVar.b(), dvVar.c(), dvVar.j, dvVar.k, dvVar.l, dvVar.c, dvVar.m, dvVar.d);
                i6 = -1;
                b = 4;
            } else {
                i6 = -1;
                b = 0;
                i5 = -1;
            }
            if (i5 == i6) {
                return i6;
            }
            iArr[i7] = a43.b(this.a, drVar.h ? (byte) 1 : 0, drVar.i ? (byte) 1 : 0, (short) drVar.g, b, i5);
        }
        int b2 = this.a.b(aVar.b);
        int c = o33.c(this.a, iArr);
        int size2 = aVar.g.size();
        int[] iArr2 = new int[size2];
        for (int i14 = 0; i14 < size2; i14++) {
            dr drVar2 = aVar.g.get(i14);
            long elapsedRealtime = (SystemClock.elapsedRealtime() - drVar2.e) / 1000;
            if (elapsedRealtime > 32767 || elapsedRealtime < 0) {
                elapsedRealtime = 32767;
            }
            if (drVar2 instanceof dt) {
                dt dtVar2 = (dt) drVar2;
                s0Var = this.a;
                i3 = dtVar2.j;
                i4 = dtVar2.k;
            } else if (drVar2 instanceof du) {
                du duVar2 = (du) drVar2;
                s0Var = this.a;
                i3 = duVar2.j;
                i4 = duVar2.k;
            } else {
                if (drVar2 instanceof ds) {
                    ds dsVar2 = (ds) drVar2;
                    i2 = f43.a(this.a, dsVar2.j, dsVar2.k, dsVar2.l, (short) ((int) elapsedRealtime));
                    i = 2;
                } else if (drVar2 instanceof dv) {
                    dv dvVar2 = (dv) drVar2;
                    s0Var = this.a;
                    i3 = dvVar2.j;
                    i4 = dvVar2.k;
                } else {
                    i2 = 0;
                    i = 0;
                }
                iArr2[i14] = z33.b(this.a, (byte) i, i2);
            }
            i2 = g43.a(s0Var, i3, i4, (short) ((int) elapsedRealtime));
            i = 1;
            iArr2[i14] = z33.b(this.a, (byte) i, i2);
        }
        return o33.b(this.a, b2, aVar.a, c, o33.f(this.a, iArr2));
    }

    private int d(p43 p43) {
        long j = p43.h;
        int i = (int) p43.g;
        int i2 = (int) p43.e;
        short s = (short) ((int) p43.f);
        byte b = p43.i;
        return c43.b(this.a, p43.a, j, (int) (p43.c * 1000000.0d), (int) (p43.b * 1000000.0d), (int) p43.d, i, i2, s, b);
    }

    private static void e(List<dr> list) {
        int i;
        int i2;
        if (!(list == null || list.size() == 0)) {
            for (dr drVar : list) {
                if (drVar instanceof dt) {
                    dt dtVar = (dt) drVar;
                    i = dtVar.j;
                    i2 = dtVar.k;
                } else if (drVar instanceof du) {
                    du duVar = (du) drVar;
                    i = duVar.j;
                    i2 = duVar.k;
                } else if (drVar instanceof dv) {
                    dv dvVar = (dv) drVar;
                    i = dvVar.j;
                    i2 = dvVar.k;
                } else if (drVar instanceof ds) {
                    ds dsVar = (ds) drVar;
                    i = dsVar.k;
                    i2 = dsVar.l;
                }
                drVar.g = l43.b(l43.a(i, i2));
            }
        }
    }

    private static void g(List<y0> list) {
        for (y0 y0Var : list) {
            y0Var.g = l43.d(y0Var.a);
        }
    }

    public final byte[] f(p43 p43, u0.a aVar, long j, List<y0> list) {
        List<dr> list2;
        super.a();
        try {
            int d = d(p43);
            int i = -1;
            int c = (aVar == null || (list2 = aVar.f) == null || list2.size() <= 0) ? -1 : c(aVar);
            if (list != null && list.size() > 0) {
                i = b(j, list);
            }
            l33.a(this.a);
            l33.b(this.a, d);
            if (c > 0) {
                l33.e(this.a, c);
            }
            if (i > 0) {
                l33.d(this.a, i);
            }
            this.a.w(l33.c(this.a));
            return this.a.z();
        } catch (Throwable th) {
            y43.a(th);
            return null;
        }
    }
}
