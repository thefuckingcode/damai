package cn.damai.discover.main.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BoxReadClearRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String type = "2";

    public BoxReadClearRequest(String str) {
        this.id = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1384246754")) {
            return "mtop.damai.msgbox.user.message.clear";
        }
        return (String) ipChange.ipc$dispatch("1384246754", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-469252469")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-469252469", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1234835527")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1234835527", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-742983819")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-742983819", new Object[]{this});
    }
}
