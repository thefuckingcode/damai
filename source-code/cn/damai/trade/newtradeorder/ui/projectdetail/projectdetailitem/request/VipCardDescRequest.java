package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class VipCardDescRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "511769442")) {
            return "mtop.damai.wireless.vip.cardInfo.get";
        }
        return (String) ipChange.ipc$dispatch("511769442", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1837143797")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1837143797", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "951261895")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("951261895", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1615461131")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1615461131", new Object[]{this});
    }
}
