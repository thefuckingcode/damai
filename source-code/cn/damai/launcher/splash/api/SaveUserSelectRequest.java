package cn.damai.launcher.splash.api;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class SaveUserSelectRequest extends DMBaseMtopRequest implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String categories;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1561782984")) {
            return "mtop.damai.wireless.guide.user.interest.update";
        }
        return (String) ipChange.ipc$dispatch("-1561782984", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1698849291")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1698849291", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "708295985")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("708295985", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "605953739")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("605953739", new Object[]{this});
    }
}
