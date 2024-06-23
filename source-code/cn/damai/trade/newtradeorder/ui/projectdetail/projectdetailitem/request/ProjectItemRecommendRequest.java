package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectItemRecommendRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    public String dmChannel = AppConfig.p();
    public double latitude;
    public double longitude;
    public int pageIndex;
    public int pageSize;
    public String projectIdList;
    public boolean returnDefault;
    public int type;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1415823738")) {
            return "mtop.damai.wireless.search.byrecommend.get";
        }
        return (String) ipChange.ipc$dispatch("1415823738", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-6631008")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("-6631008", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1511798259")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1511798259", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1940894289")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1940894289", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-711406835")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-711406835", new Object[]{this});
    }
}
