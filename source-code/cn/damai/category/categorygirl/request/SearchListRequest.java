package cn.damai.category.categorygirl.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.z52;

/* compiled from: Taobao */
public class SearchListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String distanceCityId = d20.c();
    public String groupId;
    public String keyword;
    public String option = "1073742642";
    public int pageIndex = 1;
    public int pageSize = 15;
    public String returnItemOption = "4";
    public String sortType = "7";
    public String sourceType = "10";
    public String userId = d20.E();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-421119792")) {
            return z52.a;
        }
        return (String) ipChange.ipc$dispatch("-421119792", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1702935901")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1702935901", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1353753241")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1353753241", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1746616931")) {
            return z52.b;
        }
        return (String) ipChange.ipc$dispatch("1746616931", new Object[]{this});
    }
}
