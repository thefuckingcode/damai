package com.alibaba.pictures.bricks.coupon.order.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class Notice implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private List<NoticeItem> noticeList;
    @Nullable
    private String noticeTitle;

    @Nullable
    public final List<NoticeItem> getNoticeList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-183570225")) {
            return this.noticeList;
        }
        return (List) ipChange.ipc$dispatch("-183570225", new Object[]{this});
    }

    @Nullable
    public final String getNoticeTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1671985596")) {
            return this.noticeTitle;
        }
        return (String) ipChange.ipc$dispatch("-1671985596", new Object[]{this});
    }

    public final void setNoticeList(@Nullable List<NoticeItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372490787")) {
            ipChange.ipc$dispatch("-372490787", new Object[]{this, list});
            return;
        }
        this.noticeList = list;
    }

    public final void setNoticeTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1703070130")) {
            ipChange.ipc$dispatch("1703070130", new Object[]{this, str});
            return;
        }
        this.noticeTitle = str;
    }
}
