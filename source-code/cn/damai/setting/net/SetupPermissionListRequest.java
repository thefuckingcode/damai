package cn.damai.setting.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class SetupPermissionListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public Map<String, String> setupPermissionMap;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "654741345")) {
            return "mtop.damai.wireless.user.permission.setlist";
        }
        return (String) ipChange.ipc$dispatch("654741345", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "580531948")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("580531948", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "760345704")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("760345704", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1472489228")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1472489228", new Object[]{this});
    }

    public void setSetupPermissionMap(Map<Integer, Integer> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229068069")) {
            ipChange.ipc$dispatch("-1229068069", new Object[]{this, map});
            return;
        }
        this.setupPermissionMap = new HashMap();
        for (Integer num : map.keySet()) {
            this.setupPermissionMap.put(num.toString(), map.get(num).toString());
        }
    }
}
