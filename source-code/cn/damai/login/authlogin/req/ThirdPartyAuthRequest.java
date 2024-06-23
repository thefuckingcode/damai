package cn.damai.login.authlogin.req;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ThirdPartyAuthRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String OPTR_DO_AUTH = "authorizeAndLogin";
    public static final String OPTR_GET_AUTH = "login";
    public String feature;
    public String operator;
    public String target;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-272743886")) {
            return "mtop.damai.wireless.third.account.session.get";
        }
        return (String) ipChange.ipc$dispatch("-272743886", new Object[]{this});
    }

    public String getFeature() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1389203741")) {
            return this.feature;
        }
        return (String) ipChange.ipc$dispatch("-1389203741", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "425155643")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("425155643", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1767571959")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1767571959", new Object[]{this})).booleanValue();
    }

    public String getOperator() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "357280653")) {
            return this.operator;
        }
        return (String) ipChange.ipc$dispatch("357280653", new Object[]{this});
    }

    public String getTarget() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "523463546")) {
            return this.target;
        }
        return (String) ipChange.ipc$dispatch("523463546", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1894992837")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1894992837", new Object[]{this});
    }

    public void setFeature(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731896589")) {
            ipChange.ipc$dispatch("-1731896589", new Object[]{this, str});
            return;
        }
        this.feature = str;
    }

    public void setOperator(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691529487")) {
            ipChange.ipc$dispatch("-1691529487", new Object[]{this, str});
            return;
        }
        this.operator = str;
    }

    public void setTarget(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1947376036")) {
            ipChange.ipc$dispatch("1947376036", new Object[]{this, str});
            return;
        }
        this.target = str;
    }
}
