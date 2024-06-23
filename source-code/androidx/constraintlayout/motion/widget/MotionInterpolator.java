package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
public abstract class MotionInterpolator implements Interpolator {
    public abstract float getInterpolation(float f);

    public abstract float getVelocity();
}
