package com.alibaba.pictures.bricks.view.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.bean.VoteActionRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class VoteActionRequest extends DamaiBaseRequest<VoteActionRes> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private String activityId;
    @NotNull
    private String activityOptionId;
    @NotNull
    private String operate;

    public VoteActionRequest(@NotNull String str, @NotNull String str2, boolean z) {
        k21.i(str, "activityId");
        k21.i(str2, "activityOptionId");
        this.activityId = str;
        this.activityOptionId = str2;
        this.operate = z ? "1" : "0";
        this.API_NAME = "mtop.damai.wireless.activity.vote";
        this.VERSION = "2.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    @NotNull
    public final String getActivityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1766268172")) {
            return this.activityId;
        }
        return (String) ipChange.ipc$dispatch("-1766268172", new Object[]{this});
    }

    @NotNull
    public final String getActivityOptionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1142079305")) {
            return this.activityOptionId;
        }
        return (String) ipChange.ipc$dispatch("1142079305", new Object[]{this});
    }

    @NotNull
    public final String getOperate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-910809072")) {
            return this.operate;
        }
        return (String) ipChange.ipc$dispatch("-910809072", new Object[]{this});
    }

    public final void setActivityId(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1029621910")) {
            ipChange.ipc$dispatch("-1029621910", new Object[]{this, str});
            return;
        }
        k21.i(str, "<set-?>");
        this.activityId = str;
    }

    public final void setActivityOptionId(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127074635")) {
            ipChange.ipc$dispatch("-127074635", new Object[]{this, str});
            return;
        }
        k21.i(str, "<set-?>");
        this.activityOptionId = str;
    }

    public final void setOperate(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213436262")) {
            ipChange.ipc$dispatch("213436262", new Object[]{this, str});
            return;
        }
        k21.i(str, "<set-?>");
        this.operate = str;
    }
}
