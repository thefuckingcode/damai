package tb;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a;

/* compiled from: Taobao */
public class b61<T> {
    @Nullable
    private final a a;
    @Nullable
    public final T b;
    @Nullable
    public T c;
    @Nullable
    public final Interpolator d;
    @Nullable
    public final Interpolator e;
    @Nullable
    public final Interpolator f;
    public final float g;
    @Nullable
    public Float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;
    public PointF o;
    public PointF p;

    public b61(a aVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = aVar;
        this.b = t;
        this.c = t2;
        this.d = interpolator;
        this.e = null;
        this.f = null;
        this.g = f2;
        this.h = f3;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.h == null) {
                this.n = 1.0f;
            } else {
                this.n = e() + ((this.h.floatValue() - this.g) / this.a.e());
            }
        }
        return this.n;
    }

    public float c() {
        if (this.j == -3987645.8f) {
            this.j = this.c.floatValue();
        }
        return this.j;
    }

    public int d() {
        if (this.l == 784923401) {
            this.l = this.c.intValue();
        }
        return this.l;
    }

    public float e() {
        a aVar = this.a;
        if (aVar == null) {
            return 0.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            this.m = (this.g - aVar.o()) / this.a.e();
        }
        return this.m;
    }

    public float f() {
        if (this.i == -3987645.8f) {
            this.i = this.b.floatValue();
        }
        return this.i;
    }

    public int g() {
        if (this.k == 784923401) {
            this.k = this.b.intValue();
        }
        return this.k;
    }

    public boolean h() {
        return this.d == null && this.e == null && this.f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + ((Object) this.b) + ", endValue=" + ((Object) this.c) + ", startFrame=" + this.g + ", endFrame=" + this.h + ", interpolator=" + this.d + '}';
    }

    public b61(a aVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f2, @Nullable Float f3) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = aVar;
        this.b = t;
        this.c = t2;
        this.d = null;
        this.e = interpolator;
        this.f = interpolator2;
        this.g = f2;
        this.h = f3;
    }

    protected b61(a aVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f2, @Nullable Float f3) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = aVar;
        this.b = t;
        this.c = t2;
        this.d = interpolator;
        this.e = interpolator2;
        this.f = interpolator3;
        this.g = f2;
        this.h = f3;
    }

    public b61(T t) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = null;
        this.b = t;
        this.c = t;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = Float.MIN_VALUE;
        this.h = Float.valueOf(Float.MAX_VALUE);
    }
}
