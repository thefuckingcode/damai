package cn.damai.category.ranksquare.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class RankSquareMoreRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String excludeCityId = d20.c();
    public int pageNo;
    public int pageSize = 15;
    public int type = 2;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "63966777")) {
            return "mtop.damai.wireless.search.rankinglist.query";
        }
        return (String) ipChange.ipc$dispatch("63966777", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-380771564")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-380771564", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "365639312")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("365639312", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2063263796")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-2063263796", new Object[]{this});
    }
}
