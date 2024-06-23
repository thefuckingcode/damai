package cn.damai.trade.newtradeorder.ui.projectdetail.common.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class EvaluatesRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public long categoryId;
    public int commentType;
    public String ipId;
    public boolean isQueryHotComment;
    public long itemId;
    public int moduleType;
    public int pageIndex;
    public int pageSize;
    public String tourId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1342376558")) {
            return "mtop.damai.wireless.comment.module.get";
        }
        return (String) ipChange.ipc$dispatch("1342376558", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1086640684")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1086640684", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-570776705")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-570776705", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1840674757")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1840674757", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-784854015")) {
            return "1.1";
        }
        return (String) ipChange.ipc$dispatch("-784854015", new Object[]{this});
    }
}
