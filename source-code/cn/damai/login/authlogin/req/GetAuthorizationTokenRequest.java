package cn.damai.login.authlogin.req;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class GetAuthorizationTokenRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ACTION_AUTHORIZATION = "authorization";
    public static final String ACTION_AUTO_LOGIN = "autoLogin";
    public String action;
    public String feature;
    public String siteCode;
    public String target;

    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-42425160")) {
            return this.action;
        }
        return (String) ipChange.ipc$dispatch("-42425160", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1480619065")) {
            return "mtop.damai.wireless.open.api.authorize";
        }
        return (String) ipChange.ipc$dispatch("1480619065", new Object[]{this});
    }

    public String getFeature() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "364159210")) {
            return this.feature;
        }
        return (String) ipChange.ipc$dispatch("364159210", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1965146860")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1965146860", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1800597360")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1800597360", new Object[]{this})).booleanValue();
    }

    public String getSiteCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-306569322")) {
            return this.siteCode;
        }
        return (String) ipChange.ipc$dispatch("-306569322", new Object[]{this});
    }

    public String getTarget() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1775281005")) {
            return this.target;
        }
        return (String) ipChange.ipc$dispatch("-1775281005", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-646611508")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-646611508", new Object[]{this});
    }

    public void setAction(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584695334")) {
            ipChange.ipc$dispatch("1584695334", new Object[]{this, str});
            return;
        }
        this.action = str;
    }

    public void setFeature(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1082747340")) {
            ipChange.ipc$dispatch("1082747340", new Object[]{this, str});
            return;
        }
        this.feature = str;
    }

    public void setSiteCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-796042232")) {
            ipChange.ipc$dispatch("-796042232", new Object[]{this, str});
            return;
        }
        this.siteCode = str;
    }

    public void setTarget(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594228309")) {
            ipChange.ipc$dispatch("-594228309", new Object[]{this, str});
            return;
        }
        this.target = str;
    }
}
