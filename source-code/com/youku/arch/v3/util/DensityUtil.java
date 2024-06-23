package com.youku.arch.v3.util;

import android.content.res.Resources;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DensityUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    public float density = Resources.getSystem().getDisplayMetrics().density;

    public static int dp2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "690916470")) {
            return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("690916470", new Object[]{Float.valueOf(f)})).intValue();
    }

    public static float px2dp(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1182945086")) {
            return ((float) i) / Resources.getSystem().getDisplayMetrics().density;
        }
        return ((Float) ipChange.ipc$dispatch("1182945086", new Object[]{Integer.valueOf(i)})).floatValue();
    }

    public int dip2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1044240131")) {
            return (int) ((f * this.density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("1044240131", new Object[]{this, Float.valueOf(f)})).intValue();
    }

    public float px2dip(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2118271723")) {
            return ((float) i) / this.density;
        }
        return ((Float) ipChange.ipc$dispatch("-2118271723", new Object[]{this, Integer.valueOf(i)})).floatValue();
    }
}
