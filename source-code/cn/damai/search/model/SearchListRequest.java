package cn.damai.search.model;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.z52;

/* compiled from: Taobao */
public class SearchListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String channel = "10001";
    public String cityId = "0";
    public String distanceCityId = d20.c();
    public String favourableId;
    public String keyword;
    public String latitude = "";
    public String longitude = "";
    public String option = "";
    public int pageIndex;
    public int pageSize = 15;
    public String returnItemOption = "4";
    public String returnItemStatusOption = "0";
    public String sortType = "4";
    public String sourceType = "10";
    public String userId = d20.E();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1956582277")) {
            return z52.a;
        }
        return (String) ipChange.ipc$dispatch("-1956582277", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-482834158")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-482834158", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1067734286")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1067734286", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "211154446")) {
            return z52.b;
        }
        return (String) ipChange.ipc$dispatch("211154446", new Object[]{this});
    }
}
