package cn.damai.issue.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IssueRenderRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String categoryId;
    public String ipId;
    public String itemId;
    public String performTime;
    public String scriptId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "244272911")) {
            return "mtop.damai.wireless.comment.render";
        }
        return (String) ipChange.ipc$dispatch("244272911", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1948769131")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1948769131", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1834233602")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1834233602", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-547008006")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-547008006", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1882957662")) {
            return "1.1";
        }
        return (String) ipChange.ipc$dispatch("-1882957662", new Object[]{this});
    }
}
