package com.scwang.smartrefresh.header.internal;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    public static final byte DEFAULT = 1;
    public static final byte LARGE = 0;
    private static final Interpolator j = new LinearInterpolator();
    static final Interpolator k = new FastOutSlowInInterpolator();
    private static final int[] l = {-16777216};
    private final List<Animation> a = new ArrayList();
    private final b b = new b(this);
    private float c;
    private View d;
    private Animation e;
    float f;
    private float g;
    private float h;
    boolean i;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface ProgressDrawableSize {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Animation.AnimationListener {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
            this.a.j();
            this.a.f();
            b bVar = this.a;
            bVar.d = bVar.e;
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (materialProgressDrawable.i) {
                materialProgressDrawable.i = false;
                animation.setDuration(1332);
                MaterialProgressDrawable.this.l(false);
                return;
            }
            materialProgressDrawable.f = (materialProgressDrawable.f + 1.0f) % 5.0f;
        }

        public void onAnimationStart(Animation animation) {
            MaterialProgressDrawable.this.f = 0.0f;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b {
        final RectF a = new RectF();
        final Paint b;
        final Paint c;
        float d;
        float e;
        float f;
        float g;
        float h;
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p;
        double q;
        int r;
        int s;
        int t;
        final Paint u;
        int v;
        int w;

        b(MaterialProgressDrawable materialProgressDrawable) {
            Paint paint = new Paint();
            this.b = paint;
            Paint paint2 = new Paint();
            this.c = paint2;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 5.0f;
            this.h = 2.5f;
            this.u = new Paint(1);
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        private void b(Canvas canvas, float f2, float f3, Rect rect) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f4 = ((float) (((int) this.h) / 2)) * this.p;
                float sin = (float) ((this.q * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(((float) this.r) * this.p, 0.0f);
                Path path3 = this.o;
                float f5 = this.p;
                path3.lineTo((((float) this.r) * f5) / 2.0f, ((float) this.s) * f5);
                this.o.offset(((float) ((this.q * Math.cos(0.0d)) + ((double) rect.exactCenterX()))) - f4, sin);
                this.o.close();
                this.c.setColor(this.w);
                canvas.rotate((f2 + f3) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.o, this.c);
            }
        }

        private int d() {
            return (this.j + 1) % this.i.length;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            rectF.set(rect);
            float f2 = this.h;
            rectF.inset(f2, f2);
            float f3 = this.d;
            float f4 = this.f;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.e + f4) * 360.0f) - f5;
            if (f6 != 0.0f) {
                this.b.setColor(this.w);
                canvas.drawArc(rectF, f5, f6, false, this.b);
            }
            b(canvas, f5, f6, rect);
            if (this.t < 255) {
                this.u.setColor(this.v);
                this.u.setAlpha(255 - this.t);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) / 2), this.u);
            }
        }

        public int c() {
            return this.i[d()];
        }

        public int e() {
            return this.i[this.j];
        }

        public void f() {
            h(d());
        }

        public void g() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
        }

        public void h(int i2) {
            this.j = i2;
            this.w = this.i[i2];
        }

        public void i(int i2, int i3) {
            double d2;
            float min = (float) Math.min(i2, i3);
            double d3 = this.q;
            if (d3 <= 0.0d || min < 0.0f) {
                d2 = Math.ceil((double) (this.g / 2.0f));
            } else {
                d2 = ((double) (min / 2.0f)) - d3;
            }
            this.h = (float) d2;
        }

        public void j() {
            this.k = this.d;
            this.l = this.e;
            this.m = this.f;
        }
    }

    public MaterialProgressDrawable(View view) {
        this.d = view;
        f(l);
        n(1);
        k();
    }

    private int b(float f2, int i2, int i3) {
        int intValue = Integer.valueOf(i2).intValue();
        int i4 = (intValue >> 24) & 255;
        int i5 = (intValue >> 16) & 255;
        int i6 = (intValue >> 8) & 255;
        int i7 = intValue & 255;
        int intValue2 = Integer.valueOf(i3).intValue();
        return ((i4 + ((int) (((float) (((intValue2 >> 24) & 255) - i4)) * f2))) << 24) | ((i5 + ((int) (((float) (((intValue2 >> 16) & 255) - i5)) * f2))) << 16) | ((i6 + ((int) (((float) (((intValue2 >> 8) & 255) - i6)) * f2))) << 8) | (i7 + ((int) (f2 * ((float) ((intValue2 & 255) - i7)))));
    }

    private void i(int i2, int i3, float f2, float f3, float f4, float f5) {
        float f6 = Resources.getSystem().getDisplayMetrics().density;
        this.g = ((float) i2) * f6;
        this.h = ((float) i3) * f6;
        this.b.h(0);
        float f7 = f3 * f6;
        this.b.b.setStrokeWidth(f7);
        b bVar = this.b;
        bVar.g = f7;
        bVar.q = (double) (f2 * f6);
        bVar.r = (int) (f4 * f6);
        bVar.s = (int) (f5 * f6);
        bVar.i((int) this.g, (int) this.h);
        invalidateSelf();
    }

    private void k() {
        final b bVar = this.b;
        AnonymousClass1 r1 = new Animation() {
            /* class com.scwang.smartrefresh.header.internal.MaterialProgressDrawable.AnonymousClass1 */

            public void applyTransformation(float f, Transformation transformation) {
                MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
                if (materialProgressDrawable.i) {
                    materialProgressDrawable.a(f, bVar);
                    return;
                }
                float c = materialProgressDrawable.c(bVar);
                b bVar = bVar;
                float f2 = bVar.l;
                float f3 = bVar.k;
                float f4 = bVar.m;
                MaterialProgressDrawable.this.m(f, bVar);
                if (f <= 0.5f) {
                    bVar.d = f3 + ((0.8f - c) * MaterialProgressDrawable.k.getInterpolation(f / 0.5f));
                }
                if (f > 0.5f) {
                    bVar.e = f2 + ((0.8f - c) * MaterialProgressDrawable.k.getInterpolation((f - 0.5f) / 0.5f));
                }
                MaterialProgressDrawable.this.g(f4 + (0.25f * f));
                MaterialProgressDrawable materialProgressDrawable2 = MaterialProgressDrawable.this;
                materialProgressDrawable2.h((f * 216.0f) + ((materialProgressDrawable2.f / 5.0f) * 1080.0f));
            }
        };
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(j);
        r1.setAnimationListener(new a(bVar));
        this.e = r1;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, b bVar) {
        m(f2, bVar);
        float c2 = c(bVar);
        float f3 = bVar.k;
        float f4 = bVar.l;
        j(f3 + (((f4 - c2) - f3) * f2), f4);
        float f5 = bVar.m;
        g(f5 + ((((float) (Math.floor((double) (bVar.m / 0.8f)) + 1.0d)) - f5) * f2));
    }

    /* access modifiers changed from: package-private */
    public float c(b bVar) {
        return (float) Math.toRadians(((double) bVar.g) / (bVar.q * 6.283185307179586d));
    }

    public void d(float f2) {
        b bVar = this.b;
        if (bVar.p != f2) {
            bVar.p = f2;
            invalidateSelf();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.c, bounds.exactCenterX(), bounds.exactCenterY());
        this.b.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void e(@ColorInt int i2) {
        this.b.v = i2;
    }

    public void f(int... iArr) {
        b bVar = this.b;
        bVar.i = iArr;
        bVar.h(0);
    }

    public void g(float f2) {
        this.b.f = f2;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.b.t;
    }

    public int getIntrinsicHeight() {
        return (int) this.h;
    }

    public int getIntrinsicWidth() {
        return (int) this.g;
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: package-private */
    public void h(float f2) {
        this.c = f2;
        invalidateSelf();
    }

    public boolean isRunning() {
        List<Animation> list = this.a;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animation animation = list.get(i2);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void j(float f2, float f3) {
        b bVar = this.b;
        bVar.d = f2;
        bVar.e = f3;
        invalidateSelf();
    }

    public void l(boolean z) {
        b bVar = this.b;
        if (bVar.n != z) {
            bVar.n = z;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void m(float f2, b bVar) {
        if (f2 > 0.75f) {
            bVar.w = b((f2 - 0.75f) / 0.25f, bVar.e(), bVar.c());
        }
    }

    public void n(int i2) {
        if (i2 == 0) {
            i(56, 56, 12.5f, 3.0f, 12.0f, 6.0f);
        } else {
            i(40, 40, 8.75f, 2.5f, 10.0f, 5.0f);
        }
    }

    public void setAlpha(int i2) {
        this.b.t = i2;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void start() {
        this.e.reset();
        this.b.j();
        b bVar = this.b;
        if (bVar.e != bVar.d) {
            this.i = true;
            this.e.setDuration(666);
            this.d.startAnimation(this.e);
            return;
        }
        bVar.h(0);
        this.b.g();
        this.e.setDuration(1332);
        this.d.startAnimation(this.e);
    }

    public void stop() {
        this.d.clearAnimation();
        this.b.h(0);
        this.b.g();
        l(false);
        h(0.0f);
    }
}
