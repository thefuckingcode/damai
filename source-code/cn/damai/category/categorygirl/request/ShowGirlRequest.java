package cn.damai.category.categorygirl.request;

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
        if (!AndroidInstantRuntime.support(ipChange, "-1898887325")) {
            return "mtop.damai.mec.aristotle.get";
        }
        return (String) ipChange.ipc$dispatch("-1898887325", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1955248938")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1955248938", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-986554074")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-986554074", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "268849398")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("268849398", new Object[]{this});
    }
}
