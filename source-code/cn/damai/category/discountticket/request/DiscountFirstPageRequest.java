package cn.damai.category.discountticket.request;

import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q80;

/* compiled from: Taobao */
public class DiscountFirstPageRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String distanceCityId;

    public DiscountFirstPageRequest(@Nullable String str) {
        this.distanceCityId = q80.a(str);
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-716407819")) {
            return "mtop.damai.wireless.search.discount.page";
        }
        return (String) ipChange.ipc$dispatch("-716407819", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-267176744")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-267176744", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2138888364")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2138888364", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1451328904")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1451328904", new Object[]{this});
    }
}
