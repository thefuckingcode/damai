package cn.damai.category.category.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class StarListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String currentCityId = d20.c();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "860173910")) {
            return "mtop.damai.wireless.search.artist.list";
        }
        return (String) ipChange.ipc$dispatch("860173910", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1439488873")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1439488873", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "845554515")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("845554515", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1267056663")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1267056663", new Object[]{this});
    }
}
