package cn.damai.category.common.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class CategoryPerformRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String categoryId;
    public String currentCityId = d20.c();
    public int dateType;
    public String endDate;
    public String startDate;
    public int statisticType = 0;
    public String subcategoryId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2000064840")) {
            return "mtop.damai.wireless.search.project.classfy.statistics";
        }
        return (String) ipChange.ipc$dispatch("-2000064840", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1248162933")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1248162933", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1891372111")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1891372111", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "167671883")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("167671883", new Object[]{this});
    }
}
