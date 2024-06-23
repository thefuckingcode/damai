package cn.damai.im.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class AliMeTokenRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String from;
    public String sign;
    public String timestamp;
    public String userCode;
    public String v;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1572077258")) {
            return "mtop.damai.mxm.user.accesstoken.get";
        }
        return (String) ipChange.ipc$dispatch("-1572077258", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "324506212")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("324506212", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "143390135")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("143390135", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1573858419")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1573858419", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "595659465")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("595659465", new Object[]{this});
    }

    public Map<String, String> toSignParamMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1036763801")) {
            return (Map) ipChange.ipc$dispatch("-1036763801", new Object[]{this});
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("userCode", this.userCode);
        linkedHashMap.put("from", this.from);
        linkedHashMap.put("v", this.v);
        linkedHashMap.put("timestamp", this.timestamp);
        linkedHashMap.put("key", "166432f6316846fab25e5c39e9e57d71");
        return linkedHashMap;
    }
}
