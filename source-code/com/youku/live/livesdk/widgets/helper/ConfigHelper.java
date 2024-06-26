package com.youku.live.livesdk.widgets.helper;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IRemoteConfig;

/* compiled from: Taobao */
public class ConfigHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1636579232")) {
            return ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getBoolean(str, str2, z);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1636579232", new Object[]{str, str2, Boolean.valueOf(z)})).booleanValue();
    }

    public static double getDouble(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "760653483")) {
            return ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getDouble(str, str2, d);
        }
        return ((Double) ipChange.ipc$dispatch("760653483", new Object[]{str, str2, Double.valueOf(d)})).doubleValue();
    }

    public static float getFloat(String str, String str2, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1674243500")) {
            return ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getFloat(str, str2, f);
        }
        return ((Float) ipChange.ipc$dispatch("1674243500", new Object[]{str, str2, Float.valueOf(f)})).floatValue();
    }

    public static int getInteger(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-426225772")) {
            return ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getInt(str, str2, i);
        }
        return ((Integer) ipChange.ipc$dispatch("-426225772", new Object[]{str, str2, Integer.valueOf(i)})).intValue();
    }

    public static long getLong(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1130628446")) {
            return ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getLong(str, str2, j);
        }
        return ((Long) ipChange.ipc$dispatch("-1130628446", new Object[]{str, str2, Long.valueOf(j)})).longValue();
    }
}
