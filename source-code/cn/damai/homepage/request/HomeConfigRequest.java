package cn.damai.homepage.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.homepage.bean.HomeConfigBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.k20;

/* compiled from: Taobao */
public class HomeConfigRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();

    public static void requestAppGlobalConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274550862")) {
            ipChange.ipc$dispatch("274550862", new Object[0]);
        } else {
            new HomeConfigRequest().request(new DMMtopRequestListener<HomeConfigBean>(HomeConfigBean.class) {
                /* class cn.damai.homepage.request.HomeConfigRequest.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1761184905")) {
                        ipChange.ipc$dispatch("1761184905", new Object[]{this, str, str2});
                    }
                }

                public void onSuccess(HomeConfigBean homeConfigBean) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1301790557")) {
                        ipChange.ipc$dispatch("-1301790557", new Object[]{this, homeConfigBean});
                    } else if (homeConfigBean == null) {
                        onFail("", "");
                    } else {
                        k20.g(homeConfigBean);
                    }
                }
            });
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "646776490")) {
            return "mtop.damai.wireless.home.appglobalconfig";
        }
        return (String) ipChange.ipc$dispatch("646776490", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1726531901")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1726531901", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-124888449")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-124888449", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1480454083")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1480454083", new Object[]{this});
    }
}
