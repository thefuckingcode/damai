package tb;

import android.view.animation.Interpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class od2 implements Interpolator {
    private static transient /* synthetic */ IpChange $ipChange;
    private float a;

    public od2(float f) {
        this.a = f;
    }

    public float getInterpolation(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501656101")) {
            return ((Float) ipChange.ipc$dispatch("-501656101", new Object[]{this, Float.valueOf(f)})).floatValue();
        }
        double pow = Math.pow(2.0d, (double) (-10.0f * f));
        float f2 = this.a;
        return (float) ((pow * Math.sin((((double) (f - (f2 / 4.0f))) * 6.283185307179586d) / ((double) f2))) + 1.0d);
    }
}
