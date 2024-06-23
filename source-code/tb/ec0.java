package tb;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
public class ec0 implements Interpolator {
    public float getInterpolation(float f) {
        if (f < 0.25f) {
            return (((float) Math.pow(((double) f) - 0.125d, 2.0d)) * -38.4f) + 0.6f;
        }
        double d = (double) f;
        if (d < 0.5d || d >= 0.75d) {
            return 0.0f;
        }
        return (((float) Math.pow(d - 0.625d, 2.0d)) * -19.2f) + 0.3f;
    }
}
