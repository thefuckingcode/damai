package cn.damai.search.model;

import cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import java.util.HashMap;
import tb.d20;
import tb.s41;

/* compiled from: Taobao */
public class SearchListV2Request extends YouKuBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String aaid;
    public String appCaller = "da_mai_new";
    public String appScene = "da_mai_new";
    public String categories;
    public String cityId = d20.c();
    public String extentionParameters;
    public String keyword;
    public String latitude = "";
    public String longitude = "";
    public int pg;
    public int pz = 15;
    public String sdkVersion = "2";

    public SearchListV2Request() {
        HashMap hashMap = new HashMap();
        hashMap.put("withdraw_recall_flag", "1");
        try {
            this.extentionParameters = URLEncoder.encode(s41.e(hashMap), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1239185943")) {
            return "mtop.youku.soku.yksearch";
        }
        return (String) ipChange.ipc$dispatch("1239185943", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-715196682")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-715196682", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1105648114")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1105648114", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-888044630")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("-888044630", new Object[]{this});
    }
}
