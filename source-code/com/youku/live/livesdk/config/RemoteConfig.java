package com.youku.live.livesdk.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IRemoteConfig;
import java.util.List;

/* compiled from: Taobao */
public class RemoteConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String namespace;
    private final IRemoteConfig remoteConfig = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class));

    public RemoteConfig(String str) {
        this.namespace = str;
    }

    public boolean getBoolean(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1073439482")) {
            return this.remoteConfig.getBoolean(this.namespace, str, z);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1073439482", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue();
    }

    public double getDouble(String str, double d) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1025478567")) {
            return this.remoteConfig.getDouble(this.namespace, str, d);
        }
        return ((Double) ipChange.ipc$dispatch("-1025478567", new Object[]{this, str, Double.valueOf(d)})).doubleValue();
    }

    public float getFloat(String str, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1468198482")) {
            return this.remoteConfig.getFloat(this.namespace, str, f);
        }
        return ((Float) ipChange.ipc$dispatch("1468198482", new Object[]{this, str, Float.valueOf(f)})).floatValue();
    }

    public int getInt(String str, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1836235733")) {
            return this.remoteConfig.getInt(this.namespace, str, i);
        }
        return ((Integer) ipChange.ipc$dispatch("-1836235733", new Object[]{this, str, Integer.valueOf(i)})).intValue();
    }

    public long getLong(String str, long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1515666928")) {
            return this.remoteConfig.getLong(this.namespace, str, j);
        }
        return ((Long) ipChange.ipc$dispatch("-1515666928", new Object[]{this, str, Long.valueOf(j)})).longValue();
    }

    public String getString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1212301635")) {
            return this.remoteConfig.getString(this.namespace, str, str2);
        }
        return (String) ipChange.ipc$dispatch("1212301635", new Object[]{this, str, str2});
    }

    public List<String> getStringArray(String str, List<String> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "363583748")) {
            return null;
        }
        return (List) ipChange.ipc$dispatch("363583748", new Object[]{this, str, list});
    }
}
