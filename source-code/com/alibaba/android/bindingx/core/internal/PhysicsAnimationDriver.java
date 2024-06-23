package com.alibaba.android.bindingx.core.internal;

import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.internal.AnimationFrame;
import java.util.Map;

/* compiled from: Taobao */
abstract class PhysicsAnimationDriver implements AnimationFrame.Callback {
    private AnimationFrame a;
    protected OnAnimationUpdateListener b;
    protected OnAnimationEndListener c;
    protected double d;
    protected double e;
    protected boolean f;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface OnAnimationEndListener {
        void onAnimationEnd(@NonNull PhysicsAnimationDriver physicsAnimationDriver, double d, double d2);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(@NonNull PhysicsAnimationDriver physicsAnimationDriver, double d, double d2);
    }

    PhysicsAnimationDriver() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        AnimationFrame animationFrame = this.a;
        if (animationFrame != null) {
            animationFrame.a();
        }
        this.f = false;
    }

    /* access modifiers changed from: package-private */
    public double b() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public double c() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback
    public void doFrame() {
        f(AnimationUtils.currentAnimationTimeMillis());
        OnAnimationUpdateListener onAnimationUpdateListener = this.b;
        if (onAnimationUpdateListener != null) {
            onAnimationUpdateListener.onAnimationUpdate(this, this.d, this.e);
        }
        if (d()) {
            OnAnimationEndListener onAnimationEndListener = this.c;
            if (onAnimationEndListener != null) {
                onAnimationEndListener.onAnimationEnd(this, this.d, this.e);
            }
            AnimationFrame animationFrame = this.a;
            if (animationFrame != null) {
                animationFrame.a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void e(@NonNull Map<String, Object> map);

    /* access modifiers changed from: package-private */
    public abstract void f(long j);

    /* access modifiers changed from: package-private */
    public void g(OnAnimationEndListener onAnimationEndListener) {
        this.c = onAnimationEndListener;
    }

    /* access modifiers changed from: package-private */
    public void h(OnAnimationUpdateListener onAnimationUpdateListener) {
        this.b = onAnimationUpdateListener;
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull Map<String, Object> map) {
        e(map);
        if (this.a == null) {
            this.a = AnimationFrame.b();
        }
        this.a.c(this);
    }
}
