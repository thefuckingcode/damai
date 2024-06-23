package cn.damai.launcher.splash.api;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class GetCouponsRequest extends DMBaseMtopRequest implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1394940021")) {
            return "mtop.damai.wireless.guide.dispatchdata.get";
        }
        return (String) ipChange.ipc$dispatch("-1394940021", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1593192446")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1593192446", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-834691074")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-834691074", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "772796702")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("772796702", new Object[]{this});
    }
}
