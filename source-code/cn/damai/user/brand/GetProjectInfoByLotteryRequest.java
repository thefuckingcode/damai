package cn.damai.user.brand;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class GetProjectInfoByLotteryRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    public String dmChannel = "b@damai_h5";
    public String favourableId;
    public int pageIndex = 1;
    public int pageSize = 1;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1143013797")) {
            return "mtop.damai.wireless.search.favourable.projectlist.get";
        }
        return (String) ipChange.ipc$dispatch("-1143013797", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "257225522")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("257225522", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-699484370")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-699484370", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1024722926")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1024722926", new Object[]{this});
    }
}
