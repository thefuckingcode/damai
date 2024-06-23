package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.Nullable;
import java.util.Collections;
import tb.b61;
import tb.ma1;
import tb.pa1;

/* compiled from: Taobao */
public class n<K, A> extends BaseKeyframeAnimation<K, A> {
    private final A i;

    public n(pa1<A> pa1) {
        this(pa1, null);
    }

    /* access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A h() {
        pa1<A> pa1 = this.e;
        A a = this.i;
        return pa1.b(0.0f, 0.0f, a, a, f(), f(), f());
    }

    /* access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A i(b61<K> b61, float f) {
        return h();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void k() {
        if (this.e != null) {
            super.k();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void m(float f) {
        this.d = f;
    }

    public n(pa1<A> pa1, @Nullable A a) {
        super(Collections.emptyList());
        new ma1();
        n(pa1);
        this.i = a;
    }
}
