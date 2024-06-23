package com.airbnb.lottie.animation.keyframe;

import java.util.List;
import tb.a42;
import tb.b61;
import tb.he1;
import tb.pa1;

/* compiled from: Taobao */
public class i extends e<a42> {
    private final a42 i = new a42();

    public i(List<b61<a42>> list) {
        super(list);
    }

    /* renamed from: p */
    public a42 i(b61<a42> b61, float f) {
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
        this.i.d(he1.k(t3.b(), t4.b(), f), he1.k(t3.c(), t4.c(), f));
        return this.i;
    }
}
