package com.alibaba.security.biometrics.logic.view.custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.alibaba.security.common.d.d;

/* compiled from: Taobao */
public class RPDetectCoreView extends View {
    private static final String i = "RPDetectCoreView";
    private static final int j = -1;
    private int A;
    private int B;
    public a a;
    public long b = -1;
    public long c = -1;
    public float d = -1.0f;
    public float e = -1.0f;
    public boolean f = false;
    public ValueAnimator g;
    public ValueAnimator h;
    private final float k = 0.4f;
    private Paint l;
    private Path m;
    private int n = 0;
    private int o = -1;
    private int p = -1;
    private int q;
    private float r;
    private int s;
    private int t;
    private Paint u;
    private int v;
    private Paint w;
    private int x;
    private RectF y;
    private Paint z;

    /* compiled from: Taobao */
    public interface a {
        void a();

        void b();
    }

    public RPDetectCoreView(Context context) {
        super(context);
        c();
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.n = d.a(getContext());
        com.alibaba.security.common.c.a.a(i, "mRadius:" + this.n);
        this.A = d.c(getContext());
        this.B = d.b(getContext());
        com.alibaba.security.common.c.a.a(i, "width:" + this.A);
        com.alibaba.security.common.c.a.a(i, "height:" + this.B);
        this.p = this.A / 2;
        this.o = a(getContext());
        com.alibaba.security.common.c.a.a(i, "mCircleCenterX:" + this.p);
        com.alibaba.security.common.c.a.a(i, "mCircleCenterY:" + this.o);
        this.q = -1;
        Paint paint = new Paint(1);
        this.l = paint;
        paint.setColor(-1);
        this.m = new Path();
        this.t = d.a(getContext(), 7.0f);
        Paint paint2 = new Paint(1);
        this.u = paint2;
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setStrokeWidth((float) d.a(getContext(), 5.0f));
        Paint paint3 = new Paint(1);
        this.w = paint3;
        paint3.setColor(-16776961);
        this.w.setStyle(Paint.Style.STROKE);
        this.w.setStrokeWidth((float) d.a(getContext(), 5.0f));
        Paint paint4 = new Paint(1);
        this.z = paint4;
        paint4.setColor(-16777216);
        this.z.setAlpha(127);
        this.z.setStyle(Paint.Style.FILL);
    }

    private void d() {
        if (this.g == null) {
            ValueAnimator duration = ValueAnimator.ofInt(100, 0).setDuration(1000L);
            this.g = duration;
            duration.setRepeatCount(-1);
            this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RPDetectCoreView.this.u.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    RPDetectCoreView.this.invalidate();
                }
            });
            this.g.start();
        }
        invalidate();
    }

    private void e() {
        if (this.h == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 360).setDuration(2000L);
            this.h = duration;
            duration.setRepeatCount(-1);
            this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.AnonymousClass2 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RPDetectCoreView.this.x = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    RPDetectCoreView.this.invalidate();
                }
            });
            this.h.start();
        }
    }

    private void f() {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.h = null;
            invalidate();
        }
    }

    private float getCurrentScale() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = this.c;
        if (j2 != -1) {
            long j3 = this.b;
            if (j3 != -1) {
                float f2 = this.e;
                if (f2 != -1.0f) {
                    float f3 = this.d;
                    if (f3 != -1.0f && uptimeMillis - j3 <= j2) {
                        float f4 = ((float) (uptimeMillis - j3)) / ((float) j2);
                        return f4 > 0.4f ? f2 : f3 + (f4 * (f2 - f3));
                    }
                }
            }
        }
        return -1.0f;
    }

    public final void b() {
        a();
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.h = null;
            invalidate();
        }
    }

    public int getCircleBottom() {
        return this.o + this.n;
    }

    public int getCircleCenterY() {
        return this.o;
    }

    public int getRadius() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        a aVar;
        super.onDraw(canvas);
        try {
            if (!(getWidth() == 0 || getWidth() == this.A)) {
                this.p = getWidth() / 2;
                int width = getWidth();
                com.alibaba.security.common.c.a.a(i, "mViewWidth:".concat(String.valueOf(width)));
                this.n = (Math.min(d.b(getContext()), width) / 2) - d.a(getContext(), 50.0f);
                this.o = d.a(getContext(), 125.0f) + this.n;
            }
            if (this.y == null) {
                int i2 = this.p;
                int i3 = this.n;
                int i4 = this.t;
                int i5 = this.o;
                this.y = new RectF((float) ((i2 - i3) - i4), (float) ((i5 - i3) - i4), (float) (i2 + i3 + i4), (float) (i5 + i3 + i4));
            }
            this.r = getCurrentScale();
            this.m.addCircle((float) this.p, (float) this.o, (float) this.n, Path.Direction.CW);
            canvas.drawColor(this.q);
            ValueAnimator valueAnimator = this.g;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                canvas.drawCircle((float) this.p, (float) this.o, (float) (this.n + this.t), this.u);
            }
            this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPath(this.m, this.l);
            this.l.setXfermode(null);
            ValueAnimator valueAnimator2 = this.h;
            if (valueAnimator2 != null && valueAnimator2.isStarted()) {
                canvas.drawArc(this.y, (float) (this.x - 90), 45.0f, false, this.w);
                canvas.drawCircle((float) this.p, (float) this.o, (float) this.n, this.z);
            }
            if (this.r != -1.0f) {
                invalidate();
                if (!this.f && (aVar = this.a) != null) {
                    aVar.a();
                    this.f = true;
                    return;
                }
                return;
            }
            a aVar2 = this.a;
            if (aVar2 != null) {
                try {
                    aVar2.b();
                } finally {
                    this.a = null;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setBackgroundColor(int i2) {
        this.q = i2;
        invalidate();
    }

    public void setBreatheColor(int i2) {
        this.s = i2;
        this.u.setColor(i2);
    }

    public void setWaitingColor(int i2) {
        this.v = i2;
        this.w.setColor(i2);
    }

    public final void a() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.u.setAlpha(0);
            this.g = null;
            invalidate();
        }
    }

    private int a(Context context) {
        return d.a(context, 125.0f) + this.n;
    }

    private void a(float f2, float f3, long j2, a aVar) {
        this.d = f2;
        this.e = f3;
        this.c = j2;
        this.a = aVar;
        this.f = false;
        this.b = SystemClock.uptimeMillis();
        invalidate();
    }

    public RPDetectCoreView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public RPDetectCoreView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }
}
