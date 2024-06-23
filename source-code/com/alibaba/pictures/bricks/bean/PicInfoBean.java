package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class PicInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String picDesc;
    @Nullable
    private String picUrl;

    @Nullable
    public final String getPicDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "413060547")) {
            return this.picDesc;
        }
        return (String) ipChange.ipc$dispatch("413060547", new Object[]{this});
    }

    @Nullable
    public final String getPicUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1055719667")) {
            return this.picUrl;
        }
        return (String) ipChange.ipc$dispatch("1055719667", new Object[]{this});
    }

    public final void setPicDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696278509")) {
            ipChange.ipc$dispatch("-1696278509", new Object[]{this, str});
            return;
        }
        this.picDesc = str;
    }

    public final void setPicUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267446603")) {
            ipChange.ipc$dispatch("1267446603", new Object[]{this, str});
            return;
        }
        this.picUrl = str;
    }
}
