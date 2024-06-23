package cn.damai.comment.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.network.ApiConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lk1;

/* compiled from: Taobao */
public class FollowUpdateRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String operateType;
    public String targetId;
    public String targetType;

    public FollowUpdateRequest(boolean z, String str) {
        this.operateType = z ? "1" : "0";
        this.targetId = str;
        this.targetType = lk1.h(str, 0.0d) >= 1.0E8d ? "7" : "6";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "528189424")) {
            return ApiConstant.API_NAME_RELATION_UPDATE;
        }
        return (String) ipChange.ipc$dispatch("528189424", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1645941309")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1645941309", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1878442119")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1878442119", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1599041149")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("-1599041149", new Object[]{this});
    }
}
