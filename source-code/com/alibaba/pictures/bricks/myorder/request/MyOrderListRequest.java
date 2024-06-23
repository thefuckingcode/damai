package com.alibaba.pictures.bricks.myorder.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.myorder.bean.MyOrderListResp;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class MyOrderListRequest extends DamaiBaseRequest<MyOrderListResp> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int bizType = 1;
    @Nullable
    private String dmChannel;
    private int pageNum = 1;
    private int pageSize = 20;
    private int queryType;

    public MyOrderListRequest() {
        this.API_NAME = "mtop.damai.wireless.order.secondaryorderlist";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    public final int getBizType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "645785265")) {
            return this.bizType;
        }
        return ((Integer) ipChange.ipc$dispatch("645785265", new Object[]{this})).intValue();
    }

    @Nullable
    public final String getDmChannel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1041765359")) {
            return this.dmChannel;
        }
        return (String) ipChange.ipc$dispatch("1041765359", new Object[]{this});
    }

    public final int getPageNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1692135143")) {
            return this.pageNum;
        }
        return ((Integer) ipChange.ipc$dispatch("1692135143", new Object[]{this})).intValue();
    }

    public final int getPageSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "729404322")) {
            return this.pageSize;
        }
        return ((Integer) ipChange.ipc$dispatch("729404322", new Object[]{this})).intValue();
    }

    public final int getQueryType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1614632996")) {
            return this.queryType;
        }
        return ((Integer) ipChange.ipc$dispatch("-1614632996", new Object[]{this})).intValue();
    }

    public final void setBizType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067767673")) {
            ipChange.ipc$dispatch("1067767673", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.bizType = i;
    }

    public final void setDmChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264750183")) {
            ipChange.ipc$dispatch("264750183", new Object[]{this, str});
            return;
        }
        this.dmChannel = str;
    }

    public final void setPageNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855124477")) {
            ipChange.ipc$dispatch("-855124477", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pageNum = i;
    }

    public final void setPageSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047479872")) {
            ipChange.ipc$dispatch("2047479872", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pageSize = i;
    }

    public final void setQueryType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345428306")) {
            ipChange.ipc$dispatch("-345428306", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.queryType = i;
    }
}
