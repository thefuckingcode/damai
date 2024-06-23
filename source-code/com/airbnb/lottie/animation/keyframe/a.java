package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.b61;
import tb.he1;
import tb.pa1;
import tb.xr0;

/* compiled from: Taobao */
public class a extends e<Integer> {
    public a(List<b61<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(b61<Integer> b61, float f) {
        A b;
        T t = b61.b;
        if (t == null || b61.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = t.intValue();
        int intValue2 = b61.c.intValue();
        pa1<A> pa1 = this.e;
        if (pa1 == null || (b = pa1.b(b61.g, b61.h.floatValue(), (A) Integer.valueOf(intValue), (A) Integer.valueOf(intValue2), f, e(), f())) == null) {
            return xr0.c(he1.c(f, 0.0f, 1.0f), intValue, intValue2);
        }
        return b.intValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public Integer i(b61<Integer> b61, float f) {
        return Integer.valueOf(q(b61, f));
    }
}
