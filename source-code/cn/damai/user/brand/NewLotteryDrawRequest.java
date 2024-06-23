package cn.damai.user.brand;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class NewLotteryDrawRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String accountapi = "mtop.film.MtopLuckyDrawAPI.newLotteryDraw";
    public String cityCode;
    public String lotteryMixId;
    public int platform = 4;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1747671711")) {
            return this.accountapi;
        }
        return (String) ipChange.ipc$dispatch("-1747671711", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "237166828")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("237166828", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1498947176")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1498947176", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "420065012")) {
            return "9.0";
        }
        return (String) ipChange.ipc$dispatch("420065012", new Object[]{this});
    }
}
