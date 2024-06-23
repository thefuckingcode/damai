package com.alibaba.pictures.bricks.component.script;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class FollowRequest extends DamaiBaseRequest<FollowStateBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String operateType;
    @Nullable
    private String targets;

    public FollowRequest() {
        this.API_NAME = "mtop.damai.wireless.follow.relation.update.batch";
        this.VERSION = "1.1";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    @Nullable
    public final String getOperateType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-654931613")) {
            return this.operateType;
        }
        return (String) ipChange.ipc$dispatch("-654931613", new Object[]{this});
    }

    @Nullable
    public final String getTargets() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "347607687")) {
            return this.targets;
        }
        return (String) ipChange.ipc$dispatch("347607687", new Object[]{this});
    }

    public final void init(boolean z, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1740038409")) {
            ipChange.ipc$dispatch("1740038409", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        this.operateType = z ? "1" : "0";
        this.targets = str;
    }

    public final void setOperateType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127994765")) {
            ipChange.ipc$dispatch("-1127994765", new Object[]{this, str});
            return;
        }
        this.operateType = str;
    }

    public final void setTargets(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "569650127")) {
            ipChange.ipc$dispatch("569650127", new Object[]{this, str});
            return;
        }
        this.targets = str;
    }
}
