package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class TicketNote implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String content;
    @Nullable
    private String imgUrl;
    @Nullable
    private String title;

    @Nullable
    public final String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-858311155")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("-858311155", new Object[]{this});
    }

    @Nullable
    public final String getImgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1742646030")) {
            return this.imgUrl;
        }
        return (String) ipChange.ipc$dispatch("1742646030", new Object[]{this});
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1428192428")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("1428192428", new Object[]{this});
    }

    public final void setContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840871689")) {
            ipChange.ipc$dispatch("1840871689", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public final void setImgUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1087327376")) {
            ipChange.ipc$dispatch("1087327376", new Object[]{this, str});
            return;
        }
        this.imgUrl = str;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479307446")) {
            ipChange.ipc$dispatch("-479307446", new Object[]{this, str});
            return;
        }
        this.title = str;
    }
}
