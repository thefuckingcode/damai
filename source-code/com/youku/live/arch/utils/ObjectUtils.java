package com.youku.live.arch.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ObjectUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String asString(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1585532054")) {
            return obj instanceof String ? (String) obj : str;
        }
        return (String) ipChange.ipc$dispatch("1585532054", new Object[]{obj, str});
    }
}
