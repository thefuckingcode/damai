package cn.damai.user.star.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StarIndexRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public long artistId;
    public long currentCityId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "127170880")) {
            return "mtop.damai.wireless.search.artistpage.search";
        }
        return (String) ipChange.ipc$dispatch("127170880", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2071483667")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2071483667", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-911053783")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-911053783", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2000059693")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-2000059693", new Object[]{this});
    }
}
