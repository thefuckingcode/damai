package com.alibaba.pictures.bricks.coupon.order.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class NoticeItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String content;
    @Nullable
    private String title;

    @Nullable
    public final String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-808189942")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("-808189942", new Object[]{this});
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1070703081")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("1070703081", new Object[]{this});
    }

    public final void setContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900338004")) {
            ipChange.ipc$dispatch("-900338004", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1323424685")) {
            ipChange.ipc$dispatch("1323424685", new Object[]{this, str});
            return;
        }
        this.title = str;
    }
}
