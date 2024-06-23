package tb;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class p52 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static float A = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final float[] B = new float[101];
    private final Interpolator a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private long m;
    private int n;
    private float o;
    private float p;
    private float q;
    private boolean r = true;
    private boolean s;
    private float t;
    private float u;
    private int v;
    private float w = ViewConfiguration.getScrollFriction();
    private float x;
    private final float y;
    private float z;

    /* compiled from: Taobao */
    public static class a implements Interpolator {
        private static transient /* synthetic */ IpChange $ipChange;
        private static final float a;
        private static final float b;

        static {
            float a2 = 1.0f / a(1.0f);
            a = a2;
            b = 1.0f - (a2 * a(1.0f));
        }

        a() {
        }

        private static float a(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1595734725")) {
                return ((Float) ipChange.ipc$dispatch("-1595734725", new Object[]{Float.valueOf(f)})).floatValue();
            }
            float f2 = f * 8.0f;
            if (f2 < 1.0f) {
                return f2 - (1.0f - ((float) Math.exp((double) (-f2))));
            }
            return ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f) + 0.36787945f;
        }

        public float getInterpolation(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1103231081")) {
                return ((Float) ipChange.ipc$dispatch("1103231081", new Object[]{this, Float.valueOf(f)})).floatValue();
            }
            float a2 = a * a(f);
            return a2 > 0.0f ? a2 + b : a2;
        }
    }

    static {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < 100; i2++) {
            float f8 = ((float) i2) / 100.0f;
            float f9 = 1.0f;
            while (true) {
                f2 = ((f9 - f6) / 2.0f) + f6;
                f3 = 1.0f - f2;
                f4 = f2 * 3.0f * f3;
                f5 = f2 * f2 * f2;
                float f10 = (((0.175f * f3) + (0.35000002f * f2)) * f4) + f5;
                if (((double) Math.abs(f10 - f8)) < 1.0E-5d) {
                    break;
                } else if (f10 > f8) {
                    f9 = f2;
                } else {
                    f6 = f2;
                }
            }
            B[i2] = (f4 * ((f3 * 0.5f) + f2)) + f5;
            float f11 = 1.0f;
            while (true) {
                float f12 = ((f11 - f7) / 2.0f) + f7;
                float f13 = 1.0f - f12;
                float f14 = (f12 * 3.0f * f13 * ((f13 * 0.5f) + f12)) + (f12 * f12 * f12);
                if (((double) Math.abs(f14 - f8)) < 1.0E-5d) {
                    break;
                } else if (f14 > f8) {
                    f11 = f12;
                } else {
                    f7 = f12;
                }
            }
        }
        B[100] = 1.0f;
    }

    public p52(Context context, Interpolator interpolator, boolean z2) {
        if (interpolator == null) {
            this.a = new a();
        } else {
            this.a = interpolator;
        }
        this.y = context.getResources().getDisplayMetrics().density * 160.0f;
        this.x = b(ViewConfiguration.getScrollFriction());
        this.s = z2;
        this.z = b(0.84f);
    }

    private float b(float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1293726500")) {
            return this.y * 386.0878f * f2;
        }
        return ((Float) ipChange.ipc$dispatch("1293726500", new Object[]{this, Float.valueOf(f2)})).floatValue();
    }

    private double h(float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1236200690")) {
            return Math.log((double) ((Math.abs(f2) * 0.35f) / (this.w * this.z)));
        }
        return ((Double) ipChange.ipc$dispatch("1236200690", new Object[]{this, Float.valueOf(f2)})).doubleValue();
    }

    private double i(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951155312")) {
            return ((Double) ipChange.ipc$dispatch("-1951155312", new Object[]{this, Float.valueOf(f2)})).doubleValue();
        }
        double h2 = h(f2);
        float f3 = A;
        return ((double) (this.w * this.z)) * Math.exp((((double) f3) / (((double) f3) - 1.0d)) * h2);
    }

    private int j(float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1396610484")) {
            return (int) (Math.exp(h(f2) / (((double) A) - 1.0d)) * 1000.0d);
        }
        return ((Integer) ipChange.ipc$dispatch("1396610484", new Object[]{this, Float.valueOf(f2)})).intValue();
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86049364")) {
            ipChange.ipc$dispatch("86049364", new Object[]{this});
            return;
        }
        this.k = this.e;
        this.l = this.f;
        this.r = true;
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005307599")) {
            return ((Boolean) ipChange.ipc$dispatch("1005307599", new Object[]{this})).booleanValue();
        } else if (this.r) {
            return false;
        } else {
            int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.m);
            int i2 = this.n;
            if (currentAnimationTimeMillis < i2) {
                int i3 = this.b;
                if (i3 == 0) {
                    float interpolation = this.a.getInterpolation(((float) currentAnimationTimeMillis) * this.o);
                    this.k = this.c + Math.round(this.p * interpolation);
                    this.l = this.d + Math.round(interpolation * this.q);
                } else if (i3 == 1) {
                    float f2 = ((float) currentAnimationTimeMillis) / ((float) i2);
                    int i4 = (int) (f2 * 100.0f);
                    float f3 = 1.0f;
                    float f4 = 0.0f;
                    if (i4 < 100) {
                        float f5 = ((float) i4) / 100.0f;
                        int i5 = i4 + 1;
                        float[] fArr = B;
                        float f6 = fArr[i4];
                        f4 = (fArr[i5] - f6) / ((((float) i5) / 100.0f) - f5);
                        f3 = f6 + ((f2 - f5) * f4);
                    }
                    this.u = ((f4 * ((float) this.v)) / ((float) i2)) * 1000.0f;
                    int i6 = this.c;
                    int round = i6 + Math.round(((float) (this.e - i6)) * f3);
                    this.k = round;
                    int min = Math.min(round, this.h);
                    this.k = min;
                    this.k = Math.max(min, this.g);
                    int i7 = this.d;
                    int round2 = i7 + Math.round(f3 * ((float) (this.f - i7)));
                    this.l = round2;
                    int min2 = Math.min(round2, this.j);
                    this.l = min2;
                    int max = Math.max(min2, this.i);
                    this.l = max;
                    if (this.k == this.e && max == this.f) {
                        this.r = true;
                    }
                }
            } else {
                this.k = this.e;
                this.l = this.f;
                this.r = true;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ca  */
    public void d(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-116827866")) {
            ipChange.ipc$dispatch("-116827866", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)});
            return;
        }
        if (!this.s || this.r) {
            i11 = i4;
        } else {
            float e2 = e();
            float f2 = (float) (this.e - this.c);
            float f3 = (float) (this.f - this.d);
            float hypot = (float) Math.hypot((double) f2, (double) f3);
            float f4 = (f2 / hypot) * e2;
            float f5 = (f3 / hypot) * e2;
            i11 = i4;
            float f6 = (float) i11;
            if (Math.signum(f6) == Math.signum(f4)) {
                i10 = i5;
                float f7 = (float) i10;
                if (Math.signum(f7) == Math.signum(f5)) {
                    i11 = (int) (f6 + f4);
                    i10 = (int) (f7 + f5);
                }
                this.b = 1;
                this.r = false;
                float hypot2 = (float) Math.hypot((double) i11, (double) i10);
                this.t = hypot2;
                this.n = j(hypot2);
                this.m = AnimationUtils.currentAnimationTimeMillis();
                this.c = i2;
                this.d = i3;
                float f8 = 1.0f;
                i12 = (hypot2 > 0.0f ? 1 : (hypot2 == 0.0f ? 0 : -1));
                float f9 = i12 != 0 ? 1.0f : ((float) i11) / hypot2;
                if (i12 != 0) {
                    f8 = ((float) i10) / hypot2;
                }
                double i13 = i(hypot2);
                this.v = (int) (((double) Math.signum(hypot2)) * i13);
                this.g = i6;
                this.h = i7;
                this.i = i8;
                this.j = i9;
                int round = i2 + ((int) Math.round(((double) f9) * i13));
                this.e = round;
                int min = Math.min(round, this.h);
                this.e = min;
                this.e = Math.max(min, this.g);
                int round2 = ((int) Math.round(i13 * ((double) f8))) + i3;
                this.f = round2;
                int min2 = Math.min(round2, this.j);
                this.f = min2;
                this.f = Math.max(min2, this.i);
            }
        }
        i10 = i5;
        this.b = 1;
        this.r = false;
        float hypot22 = (float) Math.hypot((double) i11, (double) i10);
        this.t = hypot22;
        this.n = j(hypot22);
        this.m = AnimationUtils.currentAnimationTimeMillis();
        this.c = i2;
        this.d = i3;
        float f82 = 1.0f;
        i12 = (hypot22 > 0.0f ? 1 : (hypot22 == 0.0f ? 0 : -1));
        if (i12 != 0) {
        }
        if (i12 != 0) {
        }
        double i132 = i(hypot22);
        this.v = (int) (((double) Math.signum(hypot22)) * i132);
        this.g = i6;
        this.h = i7;
        this.i = i8;
        this.j = i9;
        int round3 = i2 + ((int) Math.round(((double) f9) * i132));
        this.e = round3;
        int min3 = Math.min(round3, this.h);
        this.e = min3;
        this.e = Math.max(min3, this.g);
        int round22 = ((int) Math.round(i132 * ((double) f82))) + i3;
        this.f = round22;
        int min22 = Math.min(round22, this.j);
        this.f = min22;
        this.f = Math.max(min22, this.i);
    }

    public float e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "500078189")) {
            return ((Float) ipChange.ipc$dispatch("500078189", new Object[]{this})).floatValue();
        } else if (this.b == 1) {
            return this.u;
        } else {
            return this.t - ((this.x * ((float) m())) / 2000.0f);
        }
    }

    public final int f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "270616298")) {
            return this.l;
        }
        return ((Integer) ipChange.ipc$dispatch("270616298", new Object[]{this})).intValue();
    }

    public final int g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-489851204")) {
            return this.f;
        }
        return ((Integer) ipChange.ipc$dispatch("-489851204", new Object[]{this})).intValue();
    }

    public void k(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526324378")) {
            ipChange.ipc$dispatch("-1526324378", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.f = i2;
        this.q = (float) (i2 - this.d);
        this.r = false;
    }

    public final void l(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "600620218")) {
            ipChange.ipc$dispatch("600620218", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        this.x = b(f2);
        this.w = f2;
    }

    public int m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "951806910")) {
            return (int) (AnimationUtils.currentAnimationTimeMillis() - this.m);
        }
        return ((Integer) ipChange.ipc$dispatch("951806910", new Object[]{this})).intValue();
    }
}
