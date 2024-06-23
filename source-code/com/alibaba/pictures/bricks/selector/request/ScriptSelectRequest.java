package com.alibaba.pictures.bricks.selector.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ScriptSelectRequest extends DamaiBaseRequest<ScriptSelectResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String keyword;
    private int pageIndex = 1;
    private int pageSize = 20;
    private int queryType;
    @Nullable
    private String selectedId;
    @Nullable
    private String targetId;

    public ScriptSelectRequest() {
        this.API_NAME = "mtop.damai.wireless.comment.baccount.search";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    @Nullable
    public final String getKeyword() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1195591838")) {
            return this.keyword;
        }
        return (String) ipChange.ipc$dispatch("-1195591838", new Object[]{this});
    }

    public final int getPageIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2090777449")) {
            return this.pageIndex;
        }
        return ((Integer) ipChange.ipc$dispatch("-2090777449", new Object[]{this})).intValue();
    }

    public final int getPageSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1844909978")) {
            return this.pageSize;
        }
        return ((Integer) ipChange.ipc$dispatch("-1844909978", new Object[]{this})).intValue();
    }

    public final int getQueryType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "186002328")) {
            return this.queryType;
        }
        return ((Integer) ipChange.ipc$dispatch("186002328", new Object[]{this})).intValue();
    }

    @Nullable
    public final String getSelectedId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1416560909")) {
            return this.selectedId;
        }
        return (String) ipChange.ipc$dispatch("-1416560909", new Object[]{this});
    }

    @Nullable
    public final String getTargetId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2035425815")) {
            return this.targetId;
        }
        return (String) ipChange.ipc$dispatch("-2035425815", new Object[]{this});
    }

    public final void setKeyword(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24894892")) {
            ipChange.ipc$dispatch("-24894892", new Object[]{this, str});
            return;
        }
        this.keyword = str;
    }

    public final void setPageIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2073962835")) {
            ipChange.ipc$dispatch("2073962835", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pageIndex = i;
    }

    public final void setPageSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446852100")) {
            ipChange.ipc$dispatch("-446852100", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pageSize = i;
    }

    public final void setQueryType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360308110")) {
            ipChange.ipc$dispatch("-360308110", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.queryType = i;
    }

    public final void setSelectedId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1221368651")) {
            ipChange.ipc$dispatch("1221368651", new Object[]{this, str});
            return;
        }
        this.selectedId = str;
    }

    public final void setTargetId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443981333")) {
            ipChange.ipc$dispatch("1443981333", new Object[]{this, str});
            return;
        }
        this.targetId = str;
    }
}
