package com.loc;

import android.os.SystemClock;
import com.loc.u0;
import java.util.List;
import tb.j33;
import tb.m43;
import tb.p43;

/* compiled from: Taobao */
public final class v0 {
    private static volatile v0 f;
    private static Object g = new Object();
    private u0 a = new u0();
    private w0 b = new w0();
    private p43 c;
    private r0 d = new r0();
    private p43 e = new p43();

    /* compiled from: Taobao */
    public static class a {
        public p43 a;
        public List<y0> b;
        public long c;
        public long d;
        public boolean e;
        public long f;
        public byte g;
        public String h;
        public List<dr> i;
        public boolean j;
    }

    private v0() {
    }

    public static v0 a() {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    f = new v0();
                }
            }
        }
        return f;
    }

    public final j33 b(a aVar) {
        j33 j33 = null;
        if (aVar == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        p43 p43 = this.c;
        if (p43 == null || aVar.a.a(p43) >= 10.0d) {
            u0.a a2 = this.a.a(aVar.a, aVar.j, aVar.g, aVar.h, aVar.i);
            List<y0> b2 = this.b.b(aVar.a, aVar.b, aVar.e, aVar.d, currentTimeMillis);
            if (!(a2 == null && b2 == null)) {
                m43.a(this.e, aVar.a, aVar.f, currentTimeMillis);
                j33 = new j33(0, this.d.f(this.e, a2, aVar.c, b2));
            }
            this.c = aVar.a;
        }
        return j33;
    }
}
