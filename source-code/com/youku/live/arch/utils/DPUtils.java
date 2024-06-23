package com.youku.live.arch.utils;

import android.content.res.Resources;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DPUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int dip2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1942150808")) {
            return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("-1942150808", new Object[]{Float.valueOf(f)})).intValue();
    }

    public static int px2dip(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-809698246")) {
            return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("-809698246", new Object[]{Float.valueOf(f)})).intValue();
    }
}
