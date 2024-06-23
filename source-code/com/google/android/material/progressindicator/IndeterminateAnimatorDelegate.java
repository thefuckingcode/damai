package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* compiled from: Taobao */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    protected IndeterminateAnimatorDelegate(int i) {
        this.segmentPositions = new float[(i * 2)];
        this.segmentColors = new int[i];
    }

    /* access modifiers changed from: package-private */
    public abstract void cancelAnimatorImmediately();

    /* access modifiers changed from: protected */
    public float getFractionInRange(int i, int i2, int i3) {
        return ((float) (i - i2)) / ((float) i3);
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    /* access modifiers changed from: protected */
    public void registerDrawable(@NonNull IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }

    /* access modifiers changed from: package-private */
    public abstract void requestCancelAnimatorAfterCurrentCycle();

    /* access modifiers changed from: package-private */
    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}
