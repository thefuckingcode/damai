package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
public abstract class BaseLottieAnimator extends ValueAnimator {
    private final Set<Animator.AnimatorListener> listeners = new CopyOnWriteArraySet();
    private final Set<ValueAnimator.AnimatorUpdateListener> updateListeners = new CopyOnWriteArraySet();

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.add(animatorUpdateListener);
    }

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    /* access modifiers changed from: package-private */
    public void notifyCancel() {
        for (Animator.AnimatorListener animatorListener : this.listeners) {
            animatorListener.onAnimationCancel(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyEnd(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyRepeat() {
        for (Animator.AnimatorListener animatorListener : this.listeners) {
            animatorListener.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyStart(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyUpdate() {
        for (ValueAnimator.AnimatorUpdateListener animatorUpdateListener : this.updateListeners) {
            animatorUpdateListener.onAnimationUpdate(this);
        }
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.updateListeners.clear();
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.remove(animatorUpdateListener);
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.ValueAnimator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
