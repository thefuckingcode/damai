package cn.damai.dramachannel.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.network.ApiConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FollowRelationUpdateRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int operateType;
    public String targetId;
    public String targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1553814929")) {
            return ApiConstant.API_NAME_RELATION_UPDATE;
        }
        return (String) ipChange.ipc$dispatch("1553814929", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1426729284")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1426729284", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "222617656")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("222617656", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-573415644")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("-573415644", new Object[]{this});
    }
}
