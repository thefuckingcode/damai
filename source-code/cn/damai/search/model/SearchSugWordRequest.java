package cn.damai.search.model;

import cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchSugWordRequest extends YouKuBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String appCaller = "da_mai_new";
    public String appScene = "product_sug";
    public String keyword;
    public String sdkver = "0";

    public SearchSugWordRequest(String str) {
        this.keyword = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1100165952")) {
            return "mtop.youku.soku.yksearch";
        }
        return (String) ipChange.ipc$dispatch("1100165952", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1747726573")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1747726573", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1447916073")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1447916073", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1027064621")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("-1027064621", new Object[]{this});
    }
}
