package cn.damai.user.userhome.model;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UserDynamicRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentLabelList;
    public int dataModule = 1;
    public int pageIndex = 1;
    public String pageSize = "15";
    public String publisherId;
    public boolean queryContentLabel = true;
    public boolean queryRelatedInfo = true;
    public String subTypeList = "[23,32,62,65,66,75]";

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "122077141")) {
            return "mtop.damai.wireless.content.card.get";
        }
        return (String) ipChange.ipc$dispatch("122077141", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1944736520")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1944736520", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "633870196")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("633870196", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2005153432")) {
            return "1.1";
        }
        return (String) ipChange.ipc$dispatch("-2005153432", new Object[]{this});
    }
}
