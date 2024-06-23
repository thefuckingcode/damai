package com.alibaba.pictures.bricks.coupon.order.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class Good implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String desc;
    @Nullable
    private List<String> detailUrlList;
    @Nullable
    private Boolean goCommentButton;
    @Nullable
    private String status = GoodStatus.DEFAULT.getStatus();
    @Nullable
    private String subOrderId;
    @Nullable
    private String title;

    @Nullable
    public final String getDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1655649864")) {
            return this.desc;
        }
        return (String) ipChange.ipc$dispatch("1655649864", new Object[]{this});
    }

    @Nullable
    public final List<String> getDetailUrlList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-159067550")) {
            return this.detailUrlList;
        }
        return (List) ipChange.ipc$dispatch("-159067550", new Object[]{this});
    }

    @Nullable
    public final Boolean getGoCommentButton() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "459628885")) {
            return this.goCommentButton;
        }
        return (Boolean) ipChange.ipc$dispatch("459628885", new Object[]{this});
    }

    @Nullable
    public final String getStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1590436393")) {
            return this.status;
        }
        return (String) ipChange.ipc$dispatch("1590436393", new Object[]{this});
    }

    @Nullable
    public final String getSubOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1250918752")) {
            return this.subOrderId;
        }
        return (String) ipChange.ipc$dispatch("1250918752", new Object[]{this});
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1858302665")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-1858302665", new Object[]{this});
    }

    public final void setDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507218538")) {
            ipChange.ipc$dispatch("-507218538", new Object[]{this, str});
            return;
        }
        this.desc = str;
    }

    public final void setDetailUrlList(@Nullable List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030531262")) {
            ipChange.ipc$dispatch("-2030531262", new Object[]{this, list});
            return;
        }
        this.detailUrlList = list;
    }

    public final void setGoCommentButton(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222610665")) {
            ipChange.ipc$dispatch("222610665", new Object[]{this, bool});
            return;
        }
        this.goCommentButton = bool;
    }

    public final void setStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "663795925")) {
            ipChange.ipc$dispatch("663795925", new Object[]{this, str});
            return;
        }
        this.status = str;
    }

    public final void setSubOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1986107778")) {
            ipChange.ipc$dispatch("-1986107778", new Object[]{this, str});
            return;
        }
        this.subOrderId = str;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "718559775")) {
            ipChange.ipc$dispatch("718559775", new Object[]{this, str});
            return;
        }
        this.title = str;
    }
}
