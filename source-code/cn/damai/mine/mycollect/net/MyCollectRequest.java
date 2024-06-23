package cn.damai.mine.mycollect.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MyCollectRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int pageNo;
    public int pageSize = 15;
    public int type;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-147907195")) {
            return MyCollectApi.MY_COLLECT_API;
        }
        return (String) ipChange.ipc$dispatch("-147907195", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1863558472")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1863558472", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1093221316")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1093221316", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2019829528")) {
            return "1.3";
        }
        return (String) ipChange.ipc$dispatch("2019829528", new Object[]{this});
    }
}
