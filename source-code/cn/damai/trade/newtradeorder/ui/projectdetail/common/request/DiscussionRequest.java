package cn.damai.trade.newtradeorder.ui.projectdetail.common.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DiscussionRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public long categoryId;
    public String ipId;
    public long itemId;
    public int moduleType;
    public int pageIndex;
    public int pageSize;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1162763586")) {
            return "mtop.damai.wireless.comment.module.get";
        }
        return (String) ipChange.ipc$dispatch("1162763586", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-608088872")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("-608088872", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-40467669")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-40467669", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "980167911")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("980167911", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-964466987")) {
            return "1.1";
        }
        return (String) ipChange.ipc$dispatch("-964466987", new Object[]{this});
    }
}
