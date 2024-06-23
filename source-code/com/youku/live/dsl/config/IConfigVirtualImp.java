package com.youku.live.dsl.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IConfigVirtualImp implements IConfig {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.config.IConfig
    public String getString(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "141830588")) {
            return str3;
        }
        return (String) ipChange.ipc$dispatch("141830588", new Object[]{this, str, str2, str3});
    }
}
