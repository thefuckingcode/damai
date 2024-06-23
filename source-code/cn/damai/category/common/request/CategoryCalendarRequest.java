package cn.damai.category.common.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class CategoryCalendarRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String categoryId;
    public String cityName;
    public String damaiID = d20.c();
    public String endDate;
    public String startDate;
    public String subcategoryId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1658165205")) {
            return "mtop.damai.wireless.search.performance.calendar.get";
        }
        return (String) ipChange.ipc$dispatch("1658165205", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-810429192")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-810429192", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-218480780")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-218480780", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-469065368")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-469065368", new Object[]{this});
    }
}
