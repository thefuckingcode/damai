package cn.damai.tetris.component.brand.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class LotteryRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String accountapi = "mtop.film.MtopLuckyDrawAPI.newLotteryDraw";
    public String cityCode;
    public String lotteryMixId;
    public int platform = 4;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1785900766")) {
            return this.accountapi;
        }
        return (String) ipChange.ipc$dispatch("-1785900766", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "814369611")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("814369611", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2140040455")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("2140040455", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "381835957")) {
            return "9.0";
        }
        return (String) ipChange.ipc$dispatch("381835957", new Object[]{this});
    }
}
