package cn.damai.search.model;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class SearchBAccountRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String baccountType;
    public String distanceCityId = d20.c();
    public String keyword;
    public String latitude;
    public String longitude;
    public int pageNumber;
    public int pageSize = 15;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-628926648")) {
            return "mtop.damai.wireless.search.baccount.search";
        }
        return (String) ipChange.ipc$dispatch("-628926648", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "885620197")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("885620197", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1892376865")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1892376865", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1538810075")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1538810075", new Object[]{this});
    }
}
