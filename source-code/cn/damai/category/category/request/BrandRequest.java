package cn.damai.category.category.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class BrandRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String currentCityId = d20.c();
    public Double latitude = Double.valueOf(d20.n());
    public Double longitude = Double.valueOf(d20.o());
    public int pageNumber = 1;
    public int pageSize = 15;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-156450417")) {
            return "mtop.damai.wireless.search.brand.search";
        }
        return (String) ipChange.ipc$dispatch("-156450417", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "178761342")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("178761342", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1205849978")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1205849978", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2011286306")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("2011286306", new Object[]{this});
    }
}
