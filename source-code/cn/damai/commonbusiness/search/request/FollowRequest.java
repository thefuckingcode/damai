package cn.damai.commonbusiness.search.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.network.ApiConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FollowRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String operateType;
    public String targetId;
    public String targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-468405254")) {
            return ApiConstant.API_NAME_RELATION_UPDATE;
        }
        return (String) ipChange.ipc$dispatch("-468405254", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1710527347")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1710527347", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "59198255")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("59198255", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1699331469")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("1699331469", new Object[]{this});
    }
}
