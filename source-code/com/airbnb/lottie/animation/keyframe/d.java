package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.b61;
import tb.he1;
import tb.pa1;

/* compiled from: Taobao */
public class d extends e<Integer> {
    public d(List<b61<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.Object] */
    /* access modifiers changed from: package-private */
    public int q(b61<Integer> b61, float f) {
        A b;
        if (b61.b == null || b61.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        pa1<A> pa1 = this.e;
        if (pa1 == null || (b = pa1.b(b61.g, b61.h.floatValue(), b61.b, b61.c, f, e(), f())) == null) {
            return he1.l(b61.g(), b61.d(), f);
        }
        return b.intValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public Integer i(b61<Integer> b61, float f) {
        return Integer.valueOf(q(b61, f));
    }
}
