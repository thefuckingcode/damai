package com.youku.arch.beast.hostschedule;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
public class HostScheduler {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SingletonClassInstance {
        private static final HostScheduler instance = new HostScheduler();

        private SingletonClassInstance() {
        }
    }

    public static HostScheduler getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "318999107") ? (HostScheduler) ipChange.ipc$dispatch("318999107", new Object[0]) : SingletonClassInstance.instance;
    }

    public String[] getBackUpDomains(RequestCfg requestCfg, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1195952550")) {
            return HostCenter.getInstance().getBackUpDomains(requestCfg, z);
        }
        return (String[]) ipChange.ipc$dispatch("1195952550", new Object[]{this, requestCfg, Boolean.valueOf(z)});
    }

    public DomainCell getDomain(RequestCfg requestCfg) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1531580234")) {
            return HostCenter.getInstance().getDomain(requestCfg);
        }
        return (DomainCell) ipChange.ipc$dispatch("1531580234", new Object[]{this, requestCfg});
    }

    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1194721043")) {
            return HostCenter.getInstance().getVersion();
        }
        return (String) ipChange.ipc$dispatch("-1194721043", new Object[]{this});
    }

    private HostScheduler() {
    }

    public String getDomain(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1808452426")) {
            return HostCenter.getInstance().getDomain(map);
        }
        return (String) ipChange.ipc$dispatch("-1808452426", new Object[]{this, map});
    }
}
