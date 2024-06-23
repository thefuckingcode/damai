package tb;

import android.view.animation.Interpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class md2 implements Interpolator {
    private static transient /* synthetic */ IpChange $ipChange;
    private final float a;

    public md2(float f) {
        this.a = f;
    }

    public float getInterpolation(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107795099")) {
            return ((Float) ipChange.ipc$dispatch("2107795099", new Object[]{this, Float.valueOf(f)})).floatValue();
        }
        double pow = Math.pow(2.0d, (double) (((float) -10) * f));
        float f2 = this.a;
        return (float) ((pow * Math.sin((((double) (f - (f2 / ((float) 4)))) * 6.283185307179586d) / ((double) f2))) + ((double) 1));
    }
}
