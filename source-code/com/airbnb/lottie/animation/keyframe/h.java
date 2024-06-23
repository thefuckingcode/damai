package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import java.util.List;
import tb.b61;
import tb.pa1;

/* compiled from: Taobao */
public class h extends e<PointF> {
    private final PointF i = new PointF();

    public h(List<b61<PointF>> list) {
        super(list);
    }

    /* renamed from: p */
    public PointF i(b61<PointF> b61, float f) {
        return j(b61, f, f, f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public PointF j(b61<PointF> b61, float f, float f2, float f3) {
        T t;
        A b;
        T t2 = b61.b;
        if (t2 == null || (t = b61.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        T t3 = t2;
        T t4 = t;
        pa1<A> pa1 = this.e;
        if (pa1 != null && (b = pa1.b(b61.g, b61.h.floatValue(), t3, t4, f, e(), f())) != null) {
            return b;
        }
        PointF pointF = this.i;
        float f4 = ((PointF) t3).x;
        float f5 = f4 + (f2 * (((PointF) t4).x - f4));
        float f6 = ((PointF) t3).y;
        pointF.set(f5, f6 + (f3 * (((PointF) t4).y - f6)));
        return this.i;
    }
}
