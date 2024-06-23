package cn.damai.ticklet.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TickletTransferManagerSponsorRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String channelId;
    public String targetMobile;
    public String voucherUniqueKey;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "579662971")) {
            return "mtop.damai.wireless.ticklet2.transfer.grant";
        }
        return (String) ipChange.ipc$dispatch("579662971", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1434615534")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1434615534", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1233865998")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1233865998", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1547567602")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1547567602", new Object[]{this});
    }
}
