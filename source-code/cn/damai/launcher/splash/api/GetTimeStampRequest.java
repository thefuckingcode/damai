package cn.damai.launcher.splash.api;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jl1;

/* compiled from: Taobao */
public class GetTimeStampRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "812691636")) {
            return "mtop.common.getTimestamp";
        }
        return (String) ipChange.ipc$dispatch("812691636", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-407242247")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-407242247", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "697116725")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("697116725", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1314538937")) {
            return jl1.MUL;
        }
        return (String) ipChange.ipc$dispatch("-1314538937", new Object[]{this});
    }
}
