package cn.damai.category.category.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class StarRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String distanceCityId = d20.c();
    public boolean hasFollowed;
    public Double latitude = Double.valueOf(d20.n());
    public Double longitude = Double.valueOf(d20.o());
    public int pageNumber = 1;
    public int pageSize = 15;
    public String sourceId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2026676200")) {
            return "mtop.damai.wireless.search.artist.search";
        }
        return (String) ipChange.ipc$dispatch("-2026676200", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "356708117")) {
            return this.hasFollowed;
        }
        return ((Boolean) ipChange.ipc$dispatch("356708117", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "414008913")) {
            return this.hasFollowed;
        }
        return ((Boolean) ipChange.ipc$dispatch("414008913", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "141060523")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("141060523", new Object[]{this});
    }
}
