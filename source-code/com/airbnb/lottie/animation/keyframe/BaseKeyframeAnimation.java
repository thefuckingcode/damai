package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import tb.b61;
import tb.k61;
import tb.pa1;

/* compiled from: Taobao */
public abstract class BaseKeyframeAnimation<K, A> {
    final List<AnimationListener> a = new ArrayList(1);
    private boolean b = false;
    private final KeyframesWrapper<K> c;
    protected float d = 0.0f;
    @Nullable
    protected pa1<A> e;
    @Nullable
    private A f = null;
    private float g = -1.0f;
    private float h = -1.0f;

    /* compiled from: Taobao */
    public interface AnimationListener {
        void onValueChanged();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface KeyframesWrapper<T> {
        b61<T> getCurrentKeyframe();

        @FloatRange(from = 0.0d, to = 1.0d)
        float getEndProgress();

        @FloatRange(from = 0.0d, to = 1.0d)
        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f);

        boolean isEmpty();

        boolean isValueChanged(float f);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b<T> implements KeyframesWrapper<T> {
        private b() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public b61<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c<T> implements KeyframesWrapper<T> {
        private final List<? extends b61<T>> a;
        @NonNull
        private b61<T> b;
        private b61<T> c = null;
        private float d = -1.0f;

        c(List<? extends b61<T>> list) {
            this.a = list;
            this.b = a(0.0f);
        }

        private b61<T> a(float f) {
            List<? extends b61<T>> list = this.a;
            b61<T> b61 = (b61) list.get(list.size() - 1);
            if (f >= b61.e()) {
                return b61;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                b61<T> b612 = (b61) this.a.get(size);
                if (this.b != b612 && b612.a(f)) {
                    return b612;
                }
            }
            return (b61) this.a.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        @NonNull
        public b61<T> getCurrentKeyframe() {
            return this.b;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            List<? extends b61<T>> list = this.a;
            return ((b61) list.get(list.size() - 1)).b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return ((b61) this.a.get(0)).e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            b61<T> b61 = this.c;
            b61<T> b612 = this.b;
            if (b61 == b612 && this.d == f) {
                return true;
            }
            this.c = b612;
            this.d = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            if (this.b.a(f)) {
                return !this.b.h();
            }
            this.b = a(f);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class d<T> implements KeyframesWrapper<T> {
        @NonNull
        private final b61<T> a;
        private float b = -1.0f;

        d(List<? extends b61<T>> list) {
            this.a = (b61) list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public b61<T> getCurrentKeyframe() {
            return this.a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return this.a.b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.a.e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            return !this.a.h();
        }
    }

    BaseKeyframeAnimation(List<? extends b61<K>> list) {
        this.c = o(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float g() {
        if (this.g == -1.0f) {
            this.g = this.c.getStartDelayProgress();
        }
        return this.g;
    }

    private static <T> KeyframesWrapper<T> o(List<? extends b61<T>> list) {
        if (list.isEmpty()) {
            return new b();
        }
        if (list.size() == 1) {
            return new d(list);
        }
        return new c(list);
    }

    public void a(AnimationListener animationListener) {
        this.a.add(animationListener);
    }

    /* access modifiers changed from: protected */
    public b61<K> b() {
        k61.a("BaseKeyframeAnimation#getCurrentKeyframe");
        b61<K> currentKeyframe = this.c.getCurrentKeyframe();
        k61.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return currentKeyframe;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float c() {
        if (this.h == -1.0f) {
            this.h = this.c.getEndProgress();
        }
        return this.h;
    }

    /* access modifiers changed from: protected */
    public float d() {
        b61<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return b2.d.getInterpolation(e());
    }

    /* access modifiers changed from: package-private */
    public float e() {
        if (this.b) {
            return 0.0f;
        }
        b61<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return (this.d - b2.e()) / (b2.b() - b2.e());
    }

    public float f() {
        return this.d;
    }

    public A h() {
        A a2;
        float e2 = e();
        if (this.e == null && this.c.isCachedValueEnabled(e2)) {
            return this.f;
        }
        b61<K> b2 = b();
        Interpolator interpolator = b2.e;
        if (interpolator == null || b2.f == null) {
            a2 = i(b2, d());
        } else {
            a2 = j(b2, e2, interpolator.getInterpolation(e2), b2.f.getInterpolation(e2));
        }
        this.f = a2;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public abstract A i(b61<K> b61, float f2);

    /* access modifiers changed from: protected */
    public A j(b61<K> b61, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).onValueChanged();
        }
    }

    public void l() {
        this.b = true;
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (!this.c.isEmpty()) {
            if (f2 < g()) {
                f2 = g();
            } else if (f2 > c()) {
                f2 = c();
            }
            if (f2 != this.d) {
                this.d = f2;
                if (this.c.isValueChanged(f2)) {
                    k();
                }
            }
        }
    }

    public void n(@Nullable pa1<A> pa1) {
        pa1<A> pa12 = this.e;
        if (pa12 != null) {
            pa12.c(null);
        }
        this.e = pa1;
        if (pa1 != null) {
            pa1.c(this);
        }
    }
}
