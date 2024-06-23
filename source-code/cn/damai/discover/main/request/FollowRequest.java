package cn.damai.discover.main.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FollowRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int dataType;
    public int pageSize = 15;
    public String startRow;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1321364729")) {
            return "mtop.damai.wireless.discovery.focus";
        }
        return (String) ipChange.ipc$dispatch("-1321364729", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1637016570")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1637016570", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1278")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1278", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "846371994")) {
            return "1.1";
        }
        return (String) ipChange.ipc$dispatch("846371994", new Object[]{this});
    }
}
