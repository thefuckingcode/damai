package cn.damai.mine.presenter;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.g70;

/* compiled from: Taobao */
public class FeedBackSubmitRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bizIdentifiers;
    public String city = d20.d();
    public String content;
    public String extra;
    public String fromPage;
    public String imageAddrs;
    public String loginKey = d20.q();
    public String model = g70.b();
    public String module;
    public String mpopKey = AppConfig.c();
    public String mpopType = "damai_android";
    public String osVersion = g70.e();
    public String resolution;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1875523384")) {
            return "mtop.damai.wireless.user.feedback.add";
        }
        return (String) ipChange.ipc$dispatch("-1875523384", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1649263515")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1649263515", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1115586465")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1115586465", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "292213339")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("292213339", new Object[]{this});
    }
}
