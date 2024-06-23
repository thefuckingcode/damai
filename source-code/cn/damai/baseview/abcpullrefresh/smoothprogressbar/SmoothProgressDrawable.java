package cn.damai.baseview.abcpullrefresh.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import cn.damai.uikit.R$bool;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$dimen;
import cn.damai.uikit.R$integer;
import cn.damai.uikit.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dc2;

/* compiled from: Taobao */
public class SmoothProgressDrawable extends Drawable implements Animatable {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] A;
    private float[] B;
    private final Runnable C;
    private final Rect a;
    private Callbacks b;
    private Interpolator c;
    private Rect d;
    private Paint e;
    private int[] f;
    private int g;
    private boolean h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private float x;
    private Drawable y;
    private boolean z;

    /* compiled from: Taobao */
    public interface Callbacks {
        void onStart();

        void onStop();
    }

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        private Interpolator a;
        private int b;
        private int[] c;
        private float d;
        private float e;
        private float f;
        private boolean g;
        private boolean h;
        private float i;
        private int j;
        private boolean k;
        private boolean l;
        private boolean m;
        private Drawable n;
        private Callbacks o;

        public a(Context context) {
            g(context);
        }

        private void g(Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-148201447")) {
                ipChange.ipc$dispatch("-148201447", new Object[]{this, context});
                return;
            }
            Resources resources = context.getResources();
            this.a = new AccelerateInterpolator();
            this.b = resources.getInteger(R$integer.spb_default_sections_count);
            this.c = new int[]{resources.getColor(R$color.spb_default_color)};
            float parseFloat = Float.parseFloat(resources.getString(R$string.spb_default_speed));
            this.d = parseFloat;
            this.e = parseFloat;
            this.f = parseFloat;
            this.g = resources.getBoolean(R$bool.spb_default_reversed);
            this.j = resources.getDimensionPixelSize(R$dimen.spb_default_stroke_separator_length);
            this.i = (float) resources.getDimensionPixelOffset(R$dimen.spb_default_stroke_width);
            this.k = resources.getBoolean(R$bool.spb_default_progressiveStart_activated);
            this.m = false;
        }

        public a a(Drawable drawable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-678451930")) {
                return (a) ipChange.ipc$dispatch("-678451930", new Object[]{this, drawable});
            }
            this.n = drawable;
            return this;
        }

        public SmoothProgressDrawable b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1955616095")) {
                return (SmoothProgressDrawable) ipChange.ipc$dispatch("1955616095", new Object[]{this});
            }
            if (this.l) {
                this.n = dc2.a(this.c, this.i);
            }
            return new SmoothProgressDrawable(this.a, this.b, this.j, this.c, this.i, this.d, this.e, this.f, this.g, this.h, this.o, this.k, this.n, this.m);
        }

        public a c(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "353344906")) {
                return (a) ipChange.ipc$dispatch("353344906", new Object[]{this, Integer.valueOf(i2)});
            }
            this.c = new int[]{i2};
            return this;
        }

        public a d(int[] iArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1843731508")) {
                return (a) ipChange.ipc$dispatch("-1843731508", new Object[]{this, iArr});
            } else if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("Your color array must not be empty");
            } else {
                this.c = iArr;
                return this;
            }
        }

        public a e() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1671186139")) {
                return (a) ipChange.ipc$dispatch("-1671186139", new Object[]{this});
            }
            this.l = true;
            return this;
        }

        public a f(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1771160827")) {
                return (a) ipChange.ipc$dispatch("1771160827", new Object[]{this, Boolean.valueOf(z)});
            }
            this.m = z;
            return this;
        }

        public a h(Interpolator interpolator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1228825160")) {
                return (a) ipChange.ipc$dispatch("-1228825160", new Object[]{this, interpolator});
            } else if (interpolator != null) {
                this.a = interpolator;
                return this;
            } else {
                throw new IllegalArgumentException("Interpolator can't be null");
            }
        }

        public a i(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1017445538")) {
                return (a) ipChange.ipc$dispatch("1017445538", new Object[]{this, Boolean.valueOf(z)});
            }
            this.h = z;
            return this;
        }

        public a j(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "454671735")) {
                return (a) ipChange.ipc$dispatch("454671735", new Object[]{this, Boolean.valueOf(z)});
            }
            this.k = z;
            return this;
        }

        public a k(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-321028908")) {
                return (a) ipChange.ipc$dispatch("-321028908", new Object[]{this, Float.valueOf(f2)});
            } else if (f2 >= 0.0f) {
                this.e = f2;
                return this;
            } else {
                throw new IllegalArgumentException("progressiveStartSpeed must be >= 0");
            }
        }

        public a l(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-15250522")) {
                return (a) ipChange.ipc$dispatch("-15250522", new Object[]{this, Float.valueOf(f2)});
            } else if (f2 >= 0.0f) {
                this.f = f2;
                return this;
            } else {
                throw new IllegalArgumentException("progressiveStopSpeed must be >= 0");
            }
        }

        public a m(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1986525538")) {
                return (a) ipChange.ipc$dispatch("1986525538", new Object[]{this, Boolean.valueOf(z)});
            }
            this.g = z;
            return this;
        }

        public a n(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1159182120")) {
                return (a) ipChange.ipc$dispatch("1159182120", new Object[]{this, Integer.valueOf(i2)});
            } else if (i2 > 0) {
                this.b = i2;
                return this;
            } else {
                throw new IllegalArgumentException("SectionsCount must be > 0");
            }
        }

        public a o(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-174863534")) {
                return (a) ipChange.ipc$dispatch("-174863534", new Object[]{this, Integer.valueOf(i2)});
            } else if (i2 >= 0) {
                this.j = i2;
                return this;
            } else {
                throw new IllegalArgumentException("SeparatorLength must be >= 0");
            }
        }

        public a p(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1169916651")) {
                return (a) ipChange.ipc$dispatch("1169916651", new Object[]{this, Float.valueOf(f2)});
            } else if (f2 >= 0.0f) {
                this.d = f2;
                return this;
            } else {
                throw new IllegalArgumentException("Speed must be >= 0");
            }
        }

        public a q(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-80765742")) {
                return (a) ipChange.ipc$dispatch("-80765742", new Object[]{this, Float.valueOf(f2)});
            } else if (f2 >= 0.0f) {
                this.i = f2;
                return this;
            } else {
                throw new IllegalArgumentException("The width must be >= 0");
            }
        }
    }

    private void A(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484551799")) {
            ipChange.ipc$dispatch("-1484551799", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        k(i2);
        this.i = 0.0f;
        this.t = false;
        this.j = 0.0f;
        this.v = 0;
        this.w = 0;
        this.g = i2;
    }

    private void k(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858060826")) {
            ipChange.ipc$dispatch("858060826", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 < 0 || i2 >= this.f.length) {
            throw new IllegalArgumentException(String.format("Index %d not valid", Integer.valueOf(i2)));
        }
    }

    private int l(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58478852")) {
            return ((Integer) ipChange.ipc$dispatch("-58478852", new Object[]{this, Integer.valueOf(i2)})).intValue();
        }
        int i3 = i2 - 1;
        return i3 < 0 ? this.f.length - 1 : i3;
    }

    private void m(Canvas canvas, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292378157")) {
            ipChange.ipc$dispatch("1292378157", new Object[]{this, canvas, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        int save = canvas.save();
        canvas.clipRect(f2, (float) ((int) ((((float) canvas.getHeight()) - this.x) / 2.0f)), f3, (float) ((int) ((((float) canvas.getHeight()) + this.x) / 2.0f)));
        this.y.draw(canvas);
        canvas.restoreToCount(save);
    }

    private void n(Canvas canvas, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649855745")) {
            ipChange.ipc$dispatch("-1649855745", new Object[]{this, canvas, Float.valueOf(f2), Float.valueOf(f3)});
        } else if (this.y != null) {
            this.a.top = (int) ((((float) canvas.getHeight()) - this.x) / 2.0f);
            this.a.bottom = (int) ((((float) canvas.getHeight()) + this.x) / 2.0f);
            Rect rect = this.a;
            rect.left = 0;
            rect.right = this.r ? canvas.getWidth() / 2 : canvas.getWidth();
            this.y.setBounds(this.a);
            if (!isRunning()) {
                if (this.r) {
                    canvas.save();
                    canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                    m(canvas, 0.0f, (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.a));
                    canvas.scale(-1.0f, 1.0f);
                    m(canvas, 0.0f, (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.a));
                    canvas.restore();
                    return;
                }
                m(canvas, 0.0f, (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.a));
            } else if (u() || v()) {
                if (f2 > f3) {
                    f3 = f2;
                    f2 = f3;
                }
                if (f2 > 0.0f) {
                    if (this.r) {
                        canvas.save();
                        canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                        if (this.p) {
                            m(canvas, 0.0f, f2);
                            canvas.scale(-1.0f, 1.0f);
                            m(canvas, 0.0f, f2);
                        } else {
                            m(canvas, ((float) (canvas.getWidth() / 2)) - f2, (float) (canvas.getWidth() / 2));
                            canvas.scale(-1.0f, 1.0f);
                            m(canvas, ((float) (canvas.getWidth() / 2)) - f2, (float) (canvas.getWidth() / 2));
                        }
                        canvas.restore();
                    } else {
                        m(canvas, 0.0f, f2);
                    }
                }
                if (f3 > ((float) canvas.getWidth())) {
                    return;
                }
                if (this.r) {
                    canvas.save();
                    canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                    if (this.p) {
                        m(canvas, f3, (float) (canvas.getWidth() / 2));
                        canvas.scale(-1.0f, 1.0f);
                        m(canvas, f3, (float) (canvas.getWidth() / 2));
                    } else {
                        m(canvas, 0.0f, ((float) (canvas.getWidth() / 2)) - f3);
                        canvas.scale(-1.0f, 1.0f);
                        m(canvas, 0.0f, ((float) (canvas.getWidth() / 2)) - f3);
                    }
                    canvas.restore();
                    return;
                }
                m(canvas, f3, (float) canvas.getWidth());
            }
        }
    }

    private void o(Canvas canvas) {
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1808783919")) {
            ipChange.ipc$dispatch("1808783919", new Object[]{this, canvas});
            return;
        }
        float f2 = 1.0f / ((float) this.l);
        int i5 = this.g;
        float[] fArr = this.B;
        fArr[0] = 0.0f;
        fArr[fArr.length - 1] = 1.0f;
        int i6 = i5 - 1;
        if (i6 < 0) {
            i6 += this.f.length;
        }
        this.A[0] = this.f[i6];
        while (i4 < this.l) {
            float interpolation = this.c.getInterpolation((((float) i4) * f2) + this.i);
            i4++;
            this.B[i4] = interpolation;
            int[] iArr = this.A;
            int[] iArr2 = this.f;
            iArr[i4] = iArr2[i5];
            i5 = (i5 + 1) % iArr2.length;
        }
        int[] iArr3 = this.A;
        iArr3[iArr3.length - 1] = this.f[i5];
        if (!this.p || !this.r) {
            i2 = this.d.left;
        } else {
            Rect rect = this.d;
            i2 = Math.abs(rect.left - rect.right) / 2;
        }
        float f3 = (float) i2;
        if (!this.r) {
            i3 = this.d.right;
        } else if (this.p) {
            i3 = this.d.left;
        } else {
            Rect rect2 = this.d;
            i3 = Math.abs(rect2.left - rect2.right) / 2;
        }
        this.e.setShader(new LinearGradient(f3, ((float) this.d.centerY()) - (this.x / 2.0f), (float) i3, ((float) this.d.centerY()) + (this.x / 2.0f), this.A, this.B, this.r ? Shader.TileMode.MIRROR : Shader.TileMode.CLAMP));
    }

    private void p(Canvas canvas, int i2, float f2, float f3, float f4, float f5, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585884179")) {
            ipChange.ipc$dispatch("1585884179", new Object[]{this, canvas, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i3)});
            return;
        }
        this.e.setColor(this.f[i3]);
        if (!this.r) {
            canvas.drawLine(f2, f3, f4, f5, this.e);
        } else if (this.p) {
            float f6 = (float) i2;
            canvas.drawLine(f6 + f2, f3, f6 + f4, f5, this.e);
            canvas.drawLine(f6 - f2, f3, f6 - f4, f5, this.e);
        } else {
            canvas.drawLine(f2, f3, f4, f5, this.e);
            float f7 = (float) (i2 * 2);
            canvas.drawLine(f7 - f2, f3, f7 - f4, f5, this.e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0112  */
    private void q(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        int i3;
        int i4;
        int i5;
        float f4;
        float f5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558252804")) {
            ipChange.ipc$dispatch("-558252804", new Object[]{this, canvas});
            return;
        }
        float f6 = 1.0f;
        float f7 = 0.0f;
        if (this.p) {
            canvas.translate((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.d), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.d);
        if (this.r) {
            width /= 2;
        }
        int i6 = width;
        int i7 = this.k + i6 + this.l;
        int centerY = this.d.centerY();
        int i8 = this.l;
        float f8 = 1.0f / ((float) i8);
        int i9 = this.g;
        int i10 = this.v;
        int i11 = this.w;
        float width2 = (i10 == i11 && i11 == i8) ? (float) canvas.getWidth() : 0.0f;
        int i12 = i9;
        float f9 = 0.0f;
        float f10 = 0.0f;
        int i13 = 0;
        while (i13 <= this.w) {
            float f11 = (((float) i13) * f8) + this.i;
            float max = Math.max(f7, f11 - f8);
            float f12 = (float) i7;
            float abs = (float) ((int) (Math.abs(this.c.getInterpolation(max) - this.c.getInterpolation(Math.min(f11, f6))) * f12));
            float min = max + abs < f12 ? Math.min(abs, (float) this.k) : 0.0f;
            float f13 = f9 + (abs > min ? abs - min : 0.0f);
            if (f13 <= f9 || i13 < this.v) {
                f3 = f13;
                f2 = f9;
                f4 = f10;
                i3 = i12;
                i2 = i6;
                i4 = i7;
                i5 = i13;
                f5 = width2;
            } else {
                float interpolation = this.c.getInterpolation(Math.min(this.j, f6)) * f12;
                float f14 = (float) i6;
                float max2 = Math.max(interpolation, Math.min(f14, f9));
                float f15 = (float) centerY;
                f3 = f13;
                f2 = f9;
                f4 = f10;
                i2 = i6;
                i5 = i13;
                i3 = i12;
                i4 = i7;
                f5 = width2;
                p(canvas, i6, max2, f15, Math.min(f14, f13), f15, i3);
                if (i5 == this.v) {
                    width2 = max2 - ((float) this.k);
                    f10 = i5 != this.w ? f2 + abs : f4;
                    f9 = f3 + min;
                    i12 = t(i3);
                    i13 = i5 + 1;
                    i7 = i4;
                    i6 = i2;
                    f6 = 1.0f;
                    f7 = 0.0f;
                }
            }
            width2 = f5;
            if (i5 != this.w) {
            }
            f9 = f3 + min;
            i12 = t(i3);
            i13 = i5 + 1;
            i7 = i4;
            i6 = i2;
            f6 = 1.0f;
            f7 = 0.0f;
        }
        n(canvas, width2, f10);
    }

    private int t(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453987936")) {
            return ((Integer) ipChange.ipc$dispatch("-1453987936", new Object[]{this, Integer.valueOf(i2)})).intValue();
        }
        int i3 = i2 + 1;
        if (i3 >= this.f.length) {
            return 0;
        }
        return i3;
    }

    public void B(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1510585590")) {
            ipChange.ipc$dispatch("1510585590", new Object[]{this, drawable});
        } else if (this.y != drawable) {
            this.y = drawable;
            invalidateSelf();
        }
    }

    public void C(Callbacks callbacks) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1304762996")) {
            ipChange.ipc$dispatch("-1304762996", new Object[]{this, callbacks});
            return;
        }
        this.b = callbacks;
    }

    public void D(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387935322")) {
            ipChange.ipc$dispatch("387935322", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        E(new int[]{i2});
    }

    public void E(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1261878236")) {
            ipChange.ipc$dispatch("1261878236", new Object[]{this, iArr});
        } else if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        } else {
            this.g = 0;
            this.f = iArr;
            z();
            invalidateSelf();
        }
    }

    public void F(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401172818")) {
            ipChange.ipc$dispatch("-1401172818", new Object[]{this, interpolator});
        } else if (interpolator != null) {
            this.c = interpolator;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Interpolator cannot be null");
        }
    }

    public void G(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996983720")) {
            ipChange.ipc$dispatch("-996983720", new Object[]{this, Boolean.valueOf(z2)});
        } else if (this.r != z2) {
            this.r = z2;
            invalidateSelf();
        }
    }

    public void H(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888261826")) {
            ipChange.ipc$dispatch("1888261826", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        this.u = z2;
    }

    public void I(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-878452700")) {
            ipChange.ipc$dispatch("-878452700", new Object[]{this, Float.valueOf(f2)});
        } else if (f2 >= 0.0f) {
            this.n = f2;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
        }
    }

    public void J(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987030372")) {
            ipChange.ipc$dispatch("-987030372", new Object[]{this, Float.valueOf(f2)});
        } else if (f2 >= 0.0f) {
            this.o = f2;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
        }
    }

    public void K(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-422269480")) {
            ipChange.ipc$dispatch("-422269480", new Object[]{this, Boolean.valueOf(z2)});
        } else if (this.p != z2) {
            this.p = z2;
            invalidateSelf();
        }
    }

    public void L(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579840904")) {
            ipChange.ipc$dispatch("-579840904", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 > 0) {
            this.l = i2;
            float f2 = 1.0f / ((float) i2);
            this.s = f2;
            this.i %= f2;
            z();
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
    }

    public void M(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673141218")) {
            ipChange.ipc$dispatch("1673141218", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 >= 0) {
            this.k = i2;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
    }

    public void N(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059463163")) {
            ipChange.ipc$dispatch("1059463163", new Object[]{this, Float.valueOf(f2)});
        } else if (f2 >= 0.0f) {
            this.m = f2;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
    }

    public void O(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133216738")) {
            ipChange.ipc$dispatch("1133216738", new Object[]{this, Float.valueOf(f2)});
        } else if (f2 >= 0.0f) {
            this.e.setStrokeWidth(f2);
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        }
    }

    public void P(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736336658")) {
            ipChange.ipc$dispatch("1736336658", new Object[]{this, Boolean.valueOf(z2)});
        } else if (this.z != z2) {
            this.z = z2;
            z();
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187534303")) {
            ipChange.ipc$dispatch("1187534303", new Object[]{this, canvas});
            return;
        }
        Rect bounds = getBounds();
        this.d = bounds;
        canvas.clipRect(bounds);
        if (this.q) {
            this.g = l(this.g);
            this.q = false;
            if (u()) {
                int i2 = this.v + 1;
                this.v = i2;
                if (i2 > this.l) {
                    stop();
                    return;
                }
            }
            int i3 = this.w;
            if (i3 < this.l) {
                this.w = i3 + 1;
            }
        }
        if (this.z) {
            o(canvas);
        }
        q(canvas);
    }

    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1445921208")) {
            return -2;
        }
        return ((Integer) ipChange.ipc$dispatch("-1445921208", new Object[]{this})).intValue();
    }

    public boolean isRunning() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1776247983")) {
            return this.h;
        }
        return ((Boolean) ipChange.ipc$dispatch("1776247983", new Object[]{this})).booleanValue();
    }

    public int[] r() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1564756918")) {
            return this.f;
        }
        return (int[]) ipChange.ipc$dispatch("-1564756918", new Object[]{this});
    }

    public float s() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1115254658")) {
            return this.x;
        }
        return ((Float) ipChange.ipc$dispatch("1115254658", new Object[]{this})).floatValue();
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2021555521")) {
            ipChange.ipc$dispatch("-2021555521", new Object[]{this, runnable, Long.valueOf(j2)});
            return;
        }
        this.h = true;
        super.scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108324053")) {
            ipChange.ipc$dispatch("2108324053", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.e.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746536759")) {
            ipChange.ipc$dispatch("-746536759", new Object[]{this, colorFilter});
            return;
        }
        this.e.setColorFilter(colorFilter);
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1128853538")) {
            ipChange.ipc$dispatch("-1128853538", new Object[]{this});
            return;
        }
        if (this.u) {
            A(0);
        }
        if (!isRunning()) {
            Callbacks callbacks = this.b;
            if (callbacks != null) {
                callbacks.onStart();
            }
            scheduleSelf(this.C, SystemClock.uptimeMillis() + 16);
            invalidateSelf();
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084760776")) {
            ipChange.ipc$dispatch("1084760776", new Object[]{this});
        } else if (isRunning()) {
            Callbacks callbacks = this.b;
            if (callbacks != null) {
                callbacks.onStop();
            }
            this.h = false;
            unscheduleSelf(this.C);
        }
    }

    public boolean u() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "201104575")) {
            return this.t;
        }
        return ((Boolean) ipChange.ipc$dispatch("201104575", new Object[]{this})).booleanValue();
    }

    public boolean v() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-930147708")) {
            return this.w < this.l;
        }
        return ((Boolean) ipChange.ipc$dispatch("-930147708", new Object[]{this})).booleanValue();
    }

    public void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101596563")) {
            ipChange.ipc$dispatch("1101596563", new Object[]{this});
            return;
        }
        x(0);
    }

    public void x(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210215472")) {
            ipChange.ipc$dispatch("-210215472", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        A(i2);
        start();
    }

    public void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "879616115")) {
            ipChange.ipc$dispatch("879616115", new Object[]{this});
            return;
        }
        this.t = true;
        this.v = 0;
    }

    /* access modifiers changed from: protected */
    public void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-248219396")) {
            ipChange.ipc$dispatch("-248219396", new Object[]{this});
        } else if (this.z) {
            int i2 = this.l;
            this.A = new int[(i2 + 2)];
            this.B = new float[(i2 + 2)];
        } else {
            this.e.setShader(null);
            this.A = null;
            this.B = null;
        }
    }

    private SmoothProgressDrawable(Interpolator interpolator, int i2, int i3, int[] iArr, float f2, float f3, float f4, float f5, boolean z2, boolean z3, Callbacks callbacks, boolean z4, Drawable drawable, boolean z5) {
        this.a = new Rect();
        this.C = new Runnable() {
            /* class cn.damai.baseview.abcpullrefresh.smoothprogressbar.SmoothProgressDrawable.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-41246168")) {
                    ipChange.ipc$dispatch("-41246168", new Object[]{this});
                    return;
                }
                if (SmoothProgressDrawable.this.u()) {
                    SmoothProgressDrawable.this.j += SmoothProgressDrawable.this.o * 0.01f;
                    SmoothProgressDrawable.this.i += SmoothProgressDrawable.this.o * 0.01f;
                    if (SmoothProgressDrawable.this.j >= 1.0f) {
                        SmoothProgressDrawable.this.stop();
                    }
                } else if (SmoothProgressDrawable.this.v()) {
                    SmoothProgressDrawable.this.i += SmoothProgressDrawable.this.n * 0.01f;
                } else {
                    SmoothProgressDrawable.this.i += SmoothProgressDrawable.this.m * 0.01f;
                }
                if (SmoothProgressDrawable.this.i >= SmoothProgressDrawable.this.s) {
                    SmoothProgressDrawable.this.q = true;
                    SmoothProgressDrawable.this.i -= SmoothProgressDrawable.this.s;
                }
                if (SmoothProgressDrawable.this.isRunning()) {
                    SmoothProgressDrawable smoothProgressDrawable = SmoothProgressDrawable.this;
                    smoothProgressDrawable.scheduleSelf(smoothProgressDrawable.C, SystemClock.uptimeMillis() + 16);
                }
                SmoothProgressDrawable.this.invalidateSelf();
            }
        };
        this.h = false;
        this.c = interpolator;
        this.l = i2;
        this.v = 0;
        this.w = i2;
        this.k = i3;
        this.m = f3;
        this.n = f4;
        this.o = f5;
        this.p = z2;
        this.f = iArr;
        this.g = 0;
        this.r = z3;
        this.t = false;
        this.y = drawable;
        this.x = f2;
        this.s = 1.0f / ((float) i2);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStrokeWidth(f2);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setDither(false);
        this.e.setAntiAlias(false);
        this.u = z4;
        this.b = callbacks;
        this.z = z5;
        z();
    }
}
