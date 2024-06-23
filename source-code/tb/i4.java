package tb;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import com.ali.alihadeviceevaluator.cpu.AliHACPUTracker;

@Deprecated
/* compiled from: Taobao */
public class i4 {
    public static final String CONFIG_CPUTRACKTICK = "cpuTrackTick";
    public static final int DEVICE_IS_FATAL = 3;
    public static final int DEVICE_IS_GOOD = 0;
    public static final int DEVICE_IS_NORMAL = 1;
    public static final int DEVICE_IS_RISKY = 2;
    public static final int HIGH_END_DEVICE = 0;
    public static final int LOW_END_DEVICE = 2;
    public static final int MEDIUM_DEVICE = 1;
    private Context a;
    private Handler b;
    private volatile c c;
    private volatile b d;
    private volatile AliHACPUTracker e;
    private volatile d f;
    private volatile j4 g;
    private volatile e h;

    /* compiled from: Taobao */
    public class b {
        public int a = 0;
        public float b = 0.0f;
        public float c = -1.0f;
        public float d = -1.0f;
        public int e;
        public int f = -1;
        public int g = -1;

        public b(i4 i4Var) {
        }
    }

    /* compiled from: Taobao */
    public class c {
        public float a = 0.0f;
        public int b = 0;
        public int c = 0;
        public String d = "0";
        public int e = -1;

        public c(i4 i4Var) {
        }
    }

    /* compiled from: Taobao */
    public class d {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public int j = -1;
        public int k = -1;

        public d(i4 i4Var) {
        }
    }

    /* compiled from: Taobao */
    public class e {
        public int a = -1;
        public int b;
        public int c;
        public int d = -1;

        public e(i4 i4Var) {
        }
    }

    /* compiled from: Taobao */
    private static class f {
        private static i4 a = new i4();
    }

    private int a(int i, int... iArr) {
        if (-1 == i) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                i2 = -1;
                break;
            } else if (i >= iArr[i2]) {
                break;
            } else {
                i2++;
            }
        }
        return (i2 != -1 || i < 0) ? i2 : iArr.length;
    }

    public static i4 d() {
        return f.a;
    }

    public b b() {
        if (this.a == null) {
            return new b(this);
        }
        if (this.d == null) {
            g4 g4Var = new g4();
            g4Var.a();
            if (this.e == null) {
                this.e = new AliHACPUTracker(Process.myPid(), this.b);
            }
            this.d = new b(this);
            this.d.a = g4Var.a;
            this.d.b = g4Var.c;
            this.d.e = g4Var.e;
            this.d.f = a(g4Var.e, 8, 5);
        }
        this.d.c = this.e.peakCurProcessCpuPercent();
        this.d.d = this.e.peakCpuPercent();
        this.d.g = a((int) (100.0f - this.d.d), 90, 60, 20);
        return this.d;
    }

    public c c() {
        if (this.a == null) {
            return new c(this);
        }
        if (this.c == null) {
            h4 a2 = h4.a(this.a);
            this.c = new c(this);
            this.c.a = a2.a;
            this.c.c = a2.c;
            this.c.b = a2.b;
            k4 k4Var = new k4();
            k4Var.a(this.a);
            this.c.d = String.valueOf(k4Var.a);
            this.c.e = a(k4Var.b, 8, 6);
        }
        return this.c;
    }

    public d e() {
        if (this.a == null) {
            return new d(this);
        }
        if (this.f == null) {
            this.f = new d(this);
            this.g = new j4();
        }
        try {
            long[] a2 = this.g.a();
            this.f.a = a2[0];
            this.f.b = a2[1];
            long[] b2 = this.g.b();
            this.f.c = b2[0];
            this.f.d = b2[1];
            int i = -1;
            int i2 = b2[0] != 0 ? (int) ((((double) b2[1]) * 100.0d) / ((double) b2[0])) : -1;
            long[] c2 = this.g.c();
            this.f.e = c2[0];
            this.f.f = c2[1];
            if (c2[0] != 0) {
                i = (int) ((((double) c2[1]) * 100.0d) / ((double) c2[0]));
            }
            long[] f2 = this.g.f(this.a, Process.myPid());
            this.f.g = f2[0];
            this.f.h = f2[1];
            this.f.i = f2[2];
            this.f.j = a((int) this.f.a, 5242880, 2621440);
            this.f.k = Math.round(((float) (a(100 - i2, 70, 50, 30) + a(100 - i, 60, 40, 20))) / 2.0f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f;
    }

    @Deprecated
    public e f() {
        if (this.a == null) {
            return new e(this);
        }
        if (this.h == null) {
            this.h = new e(this);
            if (this.f == null) {
                e();
            }
            if (this.d == null) {
                b();
            }
            if (this.c == null) {
                c();
            }
            this.h.b = Math.round((((((float) this.f.j) * 0.9f) + (((float) this.d.f) * 1.5f)) + (((float) this.c.e) * 0.6f)) / 3.0f);
            this.h.d = Math.round(((float) (this.f.k + this.d.g)) / 2.0f);
        } else {
            if (this.f == null) {
                e();
            }
            if (this.d == null) {
                b();
            }
            if (this.c == null) {
                c();
            }
            this.h.d = Math.round(((((float) this.f.k) * 0.8f) + (((float) this.d.g) * 1.2f)) / 2.0f);
        }
        return this.h;
    }

    private i4() {
    }
}
