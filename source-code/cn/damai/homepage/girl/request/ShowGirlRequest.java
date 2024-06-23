package cn.damai.homepage.girl.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ShowGirlRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String args;
    public String patternName = "xiannv_tab";
    public String patternVersion = "2.0";

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "813068433")) {
            return "mtop.damai.mec.aristotle.get";
        }
        return (String) ipChange.ipc$dispatch("813068433", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-244704324")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-244704324", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2017729224")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2017729224", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1314162140")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1314162140", new Object[]{this});
    }
}
