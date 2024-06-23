package cn.damai.commonbusiness.wannasee;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.mine.mycollect.net.MyCollectApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class Wanna2SeeRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();
    private boolean needLogin;
    public String pageNo;
    public String pageSize = "15";
    public String subType;
    public String targetHavanaId;
    public String type;

    public Wanna2SeeRequest(String str, int i) {
        this.type = str;
        this.pageNo = i + "";
        this.needLogin = true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1777223119")) {
            return MyCollectApi.MY_COLLECT_API;
        }
        return (String) ipChange.ipc$dispatch("-1777223119", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1310246428")) {
            return this.needLogin;
        }
        return ((Boolean) ipChange.ipc$dispatch("1310246428", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1936291736")) {
            return this.needLogin;
        }
        return ((Boolean) ipChange.ipc$dispatch("1936291736", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "390513604")) {
            return "1.4";
        }
        return (String) ipChange.ipc$dispatch("390513604", new Object[]{this});
    }

    public Wanna2SeeRequest(String str, int i, boolean z) {
        this.type = str;
        this.pageNo = i + "";
        this.needLogin = z;
    }

    public Wanna2SeeRequest(String str, int i, boolean z, int i2) {
        this.type = str;
        this.pageNo = i + "";
        this.needLogin = z;
        this.subType = i2 + "";
    }
}
