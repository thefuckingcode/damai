package com.youku.arch.probe.plugins;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class c {
    private static transient /* synthetic */ IpChange $ipChange;
    public static Map<String, BasePlugin> a = new HashMap();
    public static volatile boolean b;

    public static BasePlugin a(String str) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594750168")) {
            obj = ipChange.ipc$dispatch("-594750168", new Object[]{str});
        } else {
            obj = a.get(str);
        }
        return (BasePlugin) obj;
    }
}
