package cn.damai.category.venue.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class VenuesGetRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    public String id;
    public Double latitude;
    public Double longitude;
    public int pageNum;
    public int pageSize;
    public int sortType;
    public String visitorId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1453093945")) {
            return "mtop.damai.wireless.search.venue.search";
        }
        return (String) ipChange.ipc$dispatch("-1453093945", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1571601222")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1571601222", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-304821694")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-304821694", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "714642778")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("714642778", new Object[]{this});
    }
}
