package cn.damai.category.ranksquare.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class RankSquareRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-916986300")) {
            return "mtop.damai.wireless.search.rankinglist.all.get";
        }
        return (String) ipChange.ipc$dispatch("-916986300", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1583327639")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1583327639", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "55453861")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("55453861", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1250750423")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("1250750423", new Object[]{this});
    }
}
