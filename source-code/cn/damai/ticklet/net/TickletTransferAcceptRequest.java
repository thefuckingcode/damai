package cn.damai.ticklet.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TickletTransferAcceptRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String acceptInfosStr;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1109453526")) {
            return "mtop.damai.wireless.ticklet2.transfer.accept";
        }
        return (String) ipChange.ipc$dispatch("1109453526", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1928658967")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1928658967", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-769712429")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-769712429", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1017777047")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1017777047", new Object[]{this});
    }
}
