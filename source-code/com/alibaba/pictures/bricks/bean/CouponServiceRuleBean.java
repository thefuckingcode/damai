package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class CouponServiceRuleBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String contexts;
    @Nullable
    private String icon;
    @Nullable
    private String ruleName;

    @Nullable
    public final String getContexts() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "353760837")) {
            return this.contexts;
        }
        return (String) ipChange.ipc$dispatch("353760837", new Object[]{this});
    }

    @Nullable
    public final String getIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1935986842")) {
            return this.icon;
        }
        return (String) ipChange.ipc$dispatch("1935986842", new Object[]{this});
    }

    @Nullable
    public final String getRuleName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "437681608")) {
            return this.ruleName;
        }
        return (String) ipChange.ipc$dispatch("437681608", new Object[]{this});
    }

    public final void setContexts(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800643783")) {
            ipChange.ipc$dispatch("-1800643783", new Object[]{this, str});
            return;
        }
        this.contexts = str;
    }

    public final void setIcon(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406706812")) {
            ipChange.ipc$dispatch("-406706812", new Object[]{this, str});
            return;
        }
        this.icon = str;
    }

    public final void setRuleName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800900118")) {
            ipChange.ipc$dispatch("800900118", new Object[]{this, str});
            return;
        }
        this.ruleName = str;
    }
}
