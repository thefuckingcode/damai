package com.youku.arch.v3.util;

import android.content.Context;
import android.util.TypedValue;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DisplayUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1358418677")) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("1358418677", new Object[]{context, Float.valueOf(f)})).intValue();
    }

    public static int px2dip(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1063744422")) {
            return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        }
        return ((Integer) ipChange.ipc$dispatch("1063744422", new Object[]{context, Integer.valueOf(i)})).intValue();
    }
}
