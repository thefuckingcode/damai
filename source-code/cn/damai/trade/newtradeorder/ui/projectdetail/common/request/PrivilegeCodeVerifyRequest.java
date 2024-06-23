package cn.damai.trade.newtradeorder.ui.projectdetail.common.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PrivilegeCodeVerifyRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public long activityId;
    public long bizObjId;
    public int bizObjType;
    public String buyerId;
    public String channelId;
    public String code;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-685125493")) {
            return "mtop.damai.wireless.mkt.privilege.verifyandsigncode";
        }
        return (String) ipChange.ipc$dispatch("-685125493", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "637903471")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("637903471", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2045118210")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2045118210", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-521529602")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-521529602", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1482611230")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1482611230", new Object[]{this});
    }
}
