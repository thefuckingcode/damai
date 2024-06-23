package com.youku.live.dsl.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.config.IRemoteConfig;
import java.util.List;

/* compiled from: Taobao */
public class IRemoteConfigVirtualImp implements IRemoteConfig {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.config.IConfigBase
    public boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1564786931")) {
            return z;
        }
        return ((Boolean) ipChange.ipc$dispatch("1564786931", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public double getDouble(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1695207352")) {
            return d;
        }
        return ((Double) ipChange.ipc$dispatch("1695207352", new Object[]{this, str, str2, Double.valueOf(d)})).doubleValue();
    }

    @Override // com.youku.live.dsl.config.IRemoteConfig
    public String getEnv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-302229228")) {
            return "online";
        }
        return (String) ipChange.ipc$dispatch("-302229228", new Object[]{this});
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public float getFloat(String str, String str2, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1704390399")) {
            return f;
        }
        return ((Float) ipChange.ipc$dispatch("1704390399", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue();
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public int getInt(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1556146136")) {
            return i;
        }
        return ((Integer) ipChange.ipc$dispatch("1556146136", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public long getLong(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-714013969")) {
            return j;
        }
        return ((Long) ipChange.ipc$dispatch("-714013969", new Object[]{this, str, str2, Long.valueOf(j)})).longValue();
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String getString(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "685471970")) {
            return str3;
        }
        return (String) ipChange.ipc$dispatch("685471970", new Object[]{this, str, str2, str3});
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public List<String> getStringArray(String str, String str2, List<String> list, String str3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "516548391")) {
            return list;
        }
        return (List) ipChange.ipc$dispatch("516548391", new Object[]{this, str, str2, list, str3});
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String[] getStringArray(String str, String str2, String[] strArr, String str3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-590692557")) {
            return strArr;
        }
        return (String[]) ipChange.ipc$dispatch("-590692557", new Object[]{this, str, str2, strArr, str3});
    }

    @Override // com.youku.live.dsl.config.IRemoteConfig
    public boolean isInited() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "943967374")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("943967374", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dsl.config.IRemoteConfig
    public void registerListener(String[] strArr, IRemoteConfig.OnRemoteConfigUpdateListener onRemoteConfigUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832467743")) {
            ipChange.ipc$dispatch("1832467743", new Object[]{this, strArr, onRemoteConfigUpdateListener});
        }
    }

    @Override // com.youku.live.dsl.config.IRemoteConfig
    public void unregisterListener(String[] strArr, IRemoteConfig.OnRemoteConfigUpdateListener onRemoteConfigUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5105080")) {
            ipChange.ipc$dispatch("5105080", new Object[]{this, strArr, onRemoteConfigUpdateListener});
        }
    }
}
