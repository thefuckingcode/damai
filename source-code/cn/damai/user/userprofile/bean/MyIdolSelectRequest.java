package cn.damai.user.userprofile.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MyIdolSelectRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int pageIndex = 1;
    public int pageSize = 30;
    public String targetId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-871950800")) {
            return "mtop.damai.wireless.follow.mycircle.query";
        }
        return (String) ipChange.ipc$dispatch("-871950800", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1210895357")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1210895357", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "949193017")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("949193017", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1295785923")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1295785923", new Object[]{this});
    }
}
