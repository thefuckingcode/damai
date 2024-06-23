package cn.damai.common.badge.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BadgeMarkRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String apiVersion = "1";
    public String clientPlatform = "android";
    public String markString;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1385808154")) {
            return "mtop.damai.wireless.badge.mark";
        }
        return (String) ipChange.ipc$dispatch("-1385808154", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-824963577")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-824963577", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1301122877")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1301122877", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "781928569")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("781928569", new Object[]{this});
    }
}
