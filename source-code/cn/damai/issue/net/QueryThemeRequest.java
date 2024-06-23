package cn.damai.issue.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class QueryThemeRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public Long targetId;
    public Integer targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1227640943")) {
            return "mtop.damai.wireless.comment.query.theme";
        }
        return (String) ipChange.ipc$dispatch("1227640943", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1232507381")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("-1232507381", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1134050206")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1134050206", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "115446938")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("115446938", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-899589630")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-899589630", new Object[]{this});
    }
}
