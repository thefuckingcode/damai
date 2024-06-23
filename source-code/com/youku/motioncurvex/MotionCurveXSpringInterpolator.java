package com.youku.motioncurvex;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
public class MotionCurveXSpringInterpolator implements Interpolator {
    private boolean MassSystem;
    private float d;
    private float iv;
    private float m;
    private float s;

    public MotionCurveXSpringInterpolator() {
        this.m = 0.7f;
        this.s = 380.0f;
        this.d = 10.0f;
        this.iv = -2.0f;
        this.MassSystem = true;
    }

    public float getInterpolation(float f) {
        float f2;
        float f3;
        float f4;
        float sqrt = (float) Math.sqrt((double) (this.s / this.m));
        float sqrt2 = (float) (((double) this.d) / (Math.sqrt((double) (this.s * this.m)) * 2.0d));
        int i = (sqrt2 > 1.0f ? 1 : (sqrt2 == 1.0f ? 0 : -1));
        if (i < 0) {
            f3 = (float) (((double) sqrt) * Math.sqrt((double) (1.0f - (sqrt2 * sqrt2))));
            f2 = ((sqrt2 * sqrt) + (-this.iv)) / f3;
        } else {
            f3 = 0.0f;
            f2 = (-this.iv) + sqrt;
        }
        if (i < 0) {
            double d2 = (double) (f3 * f);
            f4 = (float) (Math.exp((double) ((-f) * sqrt2 * sqrt)) * ((((double) 1.0f) * Math.cos(d2)) + (((double) f2) * Math.sin(d2))));
        } else {
            f4 = (float) (((double) ((f2 * f) + 1.0f)) * Math.exp((double) ((-f) * sqrt)));
        }
        return 1.0f - f4;
    }

    public MotionCurveXSpringInterpolator(float f, float f2, float f3, float f4) {
        this.m = f;
        this.s = f2;
        this.d = f3;
        this.iv = f4;
        this.MassSystem = true;
    }
}
