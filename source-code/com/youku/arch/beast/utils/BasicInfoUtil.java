package com.youku.arch.beast.utils;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BasicInfoUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getAppKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "258411690")) {
            return (String) ipChange.ipc$dispatch("258411690", new Object[0]);
        }
        return null;
    }

    public static String getDeviceId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234148227")) {
            return (String) ipChange.ipc$dispatch("-234148227", new Object[0]);
        }
        return null;
    }

    public static String getTTID(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999448335")) {
            return (String) ipChange.ipc$dispatch("-999448335", new Object[]{context});
        }
        int identifier = context.getResources().getIdentifier("ttid", "string", context.getPackageName());
        if (identifier <= 0) {
            return "";
        }
        return context.getResources().getString(identifier);
    }
}
