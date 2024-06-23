package cn.damai.comment.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FollowRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String operateType;
    public String targets;

    public FollowRequest(boolean z, String str) {
        this.operateType = z ? "1" : "0";
        this.targets = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "62090247")) {
            return "mtop.damai.wireless.follow.relation.update.batch";
        }
        return (String) ipChange.ipc$dispatch("62090247", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1142973190")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1142973190", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "100499970")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("100499970", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2065140326")) {
            return "1.1";
        }
        return (String) ipChange.ipc$dispatch("-2065140326", new Object[]{this});
    }
}
