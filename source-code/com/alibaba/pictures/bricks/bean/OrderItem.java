package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class OrderItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String nickName;
    @Nullable
    private String text;
    @Nullable
    private String time;

    @Nullable
    public final String getNickName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1253217515")) {
            return this.nickName;
        }
        return (String) ipChange.ipc$dispatch("-1253217515", new Object[]{this});
    }

    @Nullable
    public final String getText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1798484940")) {
            return this.text;
        }
        return (String) ipChange.ipc$dispatch("-1798484940", new Object[]{this});
    }

    @Nullable
    public final String getTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "954091988")) {
            return this.time;
        }
        return (String) ipChange.ipc$dispatch("954091988", new Object[]{this});
    }

    public final void setNickName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-77365143")) {
            ipChange.ipc$dispatch("-77365143", new Object[]{this, str});
            return;
        }
        this.nickName = str;
    }

    public final void setText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211215062")) {
            ipChange.ipc$dispatch("-211215062", new Object[]{this, str});
            return;
        }
        this.text = str;
    }

    public final void setTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780676214")) {
            ipChange.ipc$dispatch("-780676214", new Object[]{this, str});
            return;
        }
        this.time = str;
    }
}
