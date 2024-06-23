package cn.damai.common.badge.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BadgeQueryRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String apiVersion = "1";
    public String clientPlatform = "android";
    public boolean eCode = true;
    public String queryString;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1015082717")) {
            return "mtop.damai.wireless.badge.query";
        }
        return (String) ipChange.ipc$dispatch("1015082717", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2131472656")) {
            return this.eCode;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2131472656", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1569069932")) {
            return this.eCode;
        }
        return ((Boolean) ipChange.ipc$dispatch("1569069932", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1112147856")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1112147856", new Object[]{this});
    }
}
