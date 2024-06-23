package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class TuanItemBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String name;
    @Nullable
    private String priceLow;

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "9271552")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("9271552", new Object[]{this});
    }

    @Nullable
    public final String getPriceLow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1654129344")) {
            return this.priceLow;
        }
        return (String) ipChange.ipc$dispatch("1654129344", new Object[]{this});
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5338658")) {
            ipChange.ipc$dispatch("-5338658", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public final void setPriceLow(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143925730")) {
            ipChange.ipc$dispatch("-143925730", new Object[]{this, str});
            return;
        }
        this.priceLow = str;
    }
}
