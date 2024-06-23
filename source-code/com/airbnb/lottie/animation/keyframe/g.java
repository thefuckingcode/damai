package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import tb.b61;
import tb.pa1;

/* compiled from: Taobao */
public class g extends e<PointF> {
    private final PointF i = new PointF();
    private final float[] j = new float[2];
    private final PathMeasure k = new PathMeasure();
    private f l;

    public g(List<? extends b61<PointF>> list) {
        super(list);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.Object] */
    /* renamed from: p */
    public PointF i(b61<PointF> b61, float f) {
        A b;
        f fVar = (f) b61;
        Path j2 = fVar.j();
        if (j2 == null) {
            return b61.b;
        }
        pa1<A> pa1 = this.e;
        if (pa1 != null && (b = pa1.b(fVar.g, fVar.h.floatValue(), fVar.b, fVar.c, e(), f, f())) != null) {
            return b;
        }
        if (this.l != fVar) {
            this.k.setPath(j2, false);
            this.l = fVar;
        }
        PathMeasure pathMeasure = this.k;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.j, null);
        PointF pointF = this.i;
        float[] fArr = this.j;
        pointF.set(fArr[0], fArr[1]);
        return this.i;
    }
}
