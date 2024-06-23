package com.youku.motioncurvex;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
public class MotionCurveXBounceInterpolator implements Interpolator {
    private float d;
    private float v;

    public MotionCurveXBounceInterpolator() {
        this.v = 1.0f;
        this.d = 1.0f;
    }

    public float getInterpolation(float f) {
        float f2 = this.v * 2.75f;
        float f3 = 1.0f / f2;
        if (f < f3) {
            return ((float) Math.pow((double) f2, 2.0d)) * f * f;
        }
        float f4 = 2.0f / f2;
        if (f < f4) {
            float pow = (float) Math.pow((double) (this.d * f2), 2.0d);
            float f5 = 1.5f / f2;
            float f6 = f - f5;
            double d2 = (double) (f3 - f5);
            return (pow * f6 * f6) + ((float) (1.0d - ((Math.pow((double) (f2 * this.d), 2.0d) * d2) * d2)));
        }
        float f7 = 2.5f / f2;
        if (f < f7) {
            float f8 = 2.25f / f2;
            float f9 = f - f8;
            double d3 = (double) (f4 - f8);
            return (((float) Math.pow((double) (this.d * f2), 2.0d)) * f9 * f9) + ((float) (1.0d - ((Math.pow((double) (f2 * this.d), 2.0d) * d3) * d3)));
        }
        float f10 = 2.625f / f2;
        double d4 = (double) (f - f10);
        double d5 = (double) (f7 - f10);
        return (float) Math.min(1.0d, (Math.pow((double) (this.d * f2), 2.0d) * d4 * d4) + ((double) ((float) (1.0d - ((Math.pow((double) (f2 * this.d), 2.0d) * d5) * d5)))));
    }

    public MotionCurveXBounceInterpolator(float f, float f2) {
        this.v = f;
        this.d = f2;
    }
}
