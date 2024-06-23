package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.a;
import tb.he1;
import tb.k61;

/* compiled from: Taobao */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    @Nullable
    private a composition;
    private float frame = 0.0f;
    private long lastFrameTimeNs = 0;
    private float maxFrame = 2.14748365E9f;
    private float minFrame = -2.14748365E9f;
    private int repeatCount = 0;
    @VisibleForTesting
    protected boolean running = false;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;

    private float getFrameDurationNs() {
        a aVar = this.composition;
        if (aVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / aVar.h()) / Math.abs(this.speed);
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    private void verifyFrame() {
        if (this.composition != null) {
            float f = this.frame;
            if (f < this.minFrame || f > this.maxFrame) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
            }
        }
    }

    @MainThread
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    public void doFrame(long j) {
        postFrameCallback();
        if (this.composition != null && isRunning()) {
            k61.a("LottieValueAnimator#doFrame");
            long j2 = this.lastFrameTimeNs;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float frameDurationNs = ((float) j3) / getFrameDurationNs();
            float f = this.frame;
            if (isReversed()) {
                frameDurationNs = -frameDurationNs;
            }
            float f2 = f + frameDurationNs;
            this.frame = f2;
            boolean z = !he1.e(f2, getMinFrame(), getMaxFrame());
            this.frame = he1.c(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = j;
            notifyUpdate();
            if (z) {
                if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                    notifyRepeat();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        reverseAnimationSpeed();
                    } else {
                        this.frame = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.lastFrameTimeNs = j;
                } else {
                    this.frame = this.speed < 0.0f ? getMinFrame() : getMaxFrame();
                    removeFrameCallback();
                    notifyEnd(isReversed());
                }
            }
            verifyFrame();
            k61.b("LottieValueAnimator#doFrame");
        }
    }

    @MainThread
    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float minFrame2;
        float maxFrame2;
        float minFrame3;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame2 = getMaxFrame() - this.frame;
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        } else {
            minFrame2 = this.frame - getMinFrame();
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        }
        return minFrame2 / (maxFrame2 - minFrame3);
    }

    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedValueAbsolute() {
        a aVar = this.composition;
        if (aVar == null) {
            return 0.0f;
        }
        return (this.frame - aVar.o()) / (this.composition.f() - this.composition.o());
    }

    public long getDuration() {
        a aVar = this.composition;
        if (aVar == null) {
            return 0;
        }
        return (long) aVar.d();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        a aVar = this.composition;
        if (aVar == null) {
            return 0.0f;
        }
        float f = this.maxFrame;
        return f == 2.14748365E9f ? aVar.f() : f;
    }

    public float getMinFrame() {
        a aVar = this.composition;
        if (aVar == null) {
            return 0.0f;
        }
        float f = this.minFrame;
        return f == -2.14748365E9f ? aVar.o() : f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public boolean isRunning() {
        return this.running;
    }

    @MainThread
    public void pauseAnimation() {
        removeFrameCallback();
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        setFrame((float) ((int) (isReversed() ? getMaxFrame() : getMinFrame())));
        this.lastFrameTimeNs = 0;
        this.repeatCount = 0;
        postFrameCallback();
    }

    /* access modifiers changed from: protected */
    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0;
        if (isReversed() && getFrame() == getMinFrame()) {
            this.frame = getMaxFrame();
        } else if (!isReversed() && getFrame() == getMaxFrame()) {
            this.frame = getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(a aVar) {
        boolean z = this.composition == null;
        this.composition = aVar;
        if (z) {
            setMinAndMaxFrames((float) ((int) Math.max(this.minFrame, aVar.o())), (float) ((int) Math.min(this.maxFrame, aVar.f())));
        } else {
            setMinAndMaxFrames((float) ((int) aVar.o()), (float) ((int) aVar.f()));
        }
        float f = this.frame;
        this.frame = 0.0f;
        setFrame((float) ((int) f));
        notifyUpdate();
    }

    public void setFrame(float f) {
        if (this.frame != f) {
            this.frame = he1.c(f, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = 0;
            notifyUpdate();
        }
    }

    public void setMaxFrame(float f) {
        setMinAndMaxFrames(this.minFrame, f);
    }

    public void setMinAndMaxFrames(float f, float f2) {
        if (f <= f2) {
            a aVar = this.composition;
            float o = aVar == null ? -3.4028235E38f : aVar.o();
            a aVar2 = this.composition;
            float f3 = aVar2 == null ? Float.MAX_VALUE : aVar2.f();
            this.minFrame = he1.c(f, o, f3);
            this.maxFrame = he1.c(f2, o, f3);
            setFrame((float) ((int) he1.c(this.frame, f, f2)));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void setMinFrame(int i) {
        setMinAndMaxFrames((float) i, (float) ((int) this.maxFrame));
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }
}
