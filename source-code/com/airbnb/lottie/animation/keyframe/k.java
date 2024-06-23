package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;
import tb.b61;
import tb.pa1;

/* compiled from: Taobao */
public class k extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF i = new PointF();
    private final PointF j = new PointF();
    private final BaseKeyframeAnimation<Float, Float> k;
    private final BaseKeyframeAnimation<Float, Float> l;
    @Nullable
    protected pa1<Float> m;
    @Nullable
    protected pa1<Float> n;

    public k(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.k = baseKeyframeAnimation;
        this.l = baseKeyframeAnimation2;
        m(f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void m(float f) {
        this.k.m(f);
        this.l.m(f);
        this.i.set(this.k.h().floatValue(), this.l.h().floatValue());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).onValueChanged();
        }
    }

    /* renamed from: p */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public PointF i(b61<PointF> b61, float f) {
        Float f2;
        b61<Float> b;
        float f3;
        b61<Float> b2;
        float f4;
        Float f5 = null;
        if (this.m == null || (b2 = this.k.b()) == null) {
            f2 = null;
        } else {
            float d = this.k.d();
            Float f6 = b2.h;
            pa1<Float> pa1 = this.m;
            float f7 = b2.g;
            if (f6 == null) {
                f4 = f7;
            } else {
                f4 = f6.floatValue();
            }
            f2 = pa1.b(f7, f4, b2.b, b2.c, f, f, d);
        }
        if (!(this.n == null || (b = this.l.b()) == null)) {
            float d2 = this.l.d();
            Float f8 = b.h;
            pa1<Float> pa12 = this.n;
            float f9 = b.g;
            if (f8 == null) {
                f3 = f9;
            } else {
                f3 = f8.floatValue();
            }
            f5 = pa12.b(f9, f3, b.b, b.c, f, f, d2);
        }
        if (f2 == null) {
            this.j.set(this.i.x, 0.0f);
        } else {
            this.j.set(f2.floatValue(), 0.0f);
        }
        if (f5 == null) {
            PointF pointF = this.j;
            pointF.set(pointF.x, this.i.y);
        } else {
            PointF pointF2 = this.j;
            pointF2.set(pointF2.x, f5.floatValue());
        }
        return this.j;
    }

    public void r(@Nullable pa1<Float> pa1) {
        pa1<Float> pa12 = this.m;
        if (pa12 != null) {
            pa12.c(null);
        }
        this.m = pa1;
        if (pa1 != null) {
            pa1.c(this);
        }
    }

    public void s(@Nullable pa1<Float> pa1) {
        pa1<Float> pa12 = this.n;
        if (pa12 != null) {
            pa12.c(null);
        }
        this.n = pa1;
        if (pa1 != null) {
            pa1.c(this);
        }
    }
}
