package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.b61;
import tb.he1;
import tb.pa1;

/* compiled from: Taobao */
public class b extends e<Float> {
    public b(List<b61<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.Object] */
    /* access modifiers changed from: package-private */
    public float q(b61<Float> b61, float f) {
        A b;
        if (b61.b == null || b61.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        pa1<A> pa1 = this.e;
        if (pa1 == null || (b = pa1.b(b61.g, b61.h.floatValue(), b61.b, b61.c, f, e(), f())) == null) {
            return he1.k(b61.f(), b61.c(), f);
        }
        return b.floatValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public Float i(b61<Float> b61, float f) {
        return Float.valueOf(q(b61, f));
    }
}
