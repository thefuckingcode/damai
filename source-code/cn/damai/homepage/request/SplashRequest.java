package cn.damai.homepage.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.launcher.splash.api.SplashApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class SplashRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityid = d20.c();
    public String type = "720_1280";
    public String viewDate;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1294711568")) {
            return SplashApi.API_SPLASH_ADVERT;
        }
        return (String) ipChange.ipc$dispatch("1294711568", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1683029219")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1683029219", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1268484007")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1268484007", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-832519005")) {
            return "1.1";
        }
        return (String) ipChange.ipc$dispatch("-832519005", new Object[]{this});
    }
}
