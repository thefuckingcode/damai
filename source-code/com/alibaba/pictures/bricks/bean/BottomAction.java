package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;
import tb.m40;

/* compiled from: Taobao */
public final class BottomAction {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String extra;
    @Nullable
    private String title;

    public BottomAction() {
        this(null, null, 3, null);
    }

    public BottomAction(@Nullable String str, @Nullable String str2) {
        this.title = str;
        this.extra = str2;
    }

    @Nullable
    public final String getExtra() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "444102305")) {
            return this.extra;
        }
        return (String) ipChange.ipc$dispatch("444102305", new Object[]{this});
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "544674025")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("544674025", new Object[]{this});
    }

    public final void setExtra(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921330187")) {
            ipChange.ipc$dispatch("-921330187", new Object[]{this, str});
            return;
        }
        this.extra = str;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2098574163")) {
            ipChange.ipc$dispatch("-2098574163", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomAction(String str, String str2, int i, m40 m40) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
