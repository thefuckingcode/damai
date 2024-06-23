package cn.damai.discover.main.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.network.ApiConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FollowPeopleRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int operateType;
    public String targetId;
    public String targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1612884662")) {
            return ApiConstant.API_NAME_RELATION_UPDATE;
        }
        return (String) ipChange.ipc$dispatch("1612884662", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-597197769")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-597197769", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1461513485")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1461513485", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-514345911")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("-514345911", new Object[]{this});
    }
}
