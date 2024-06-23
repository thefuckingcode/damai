package cn.damai.common.net.mtop.netfit;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.MtopResponse;
import tb.d20;
import tb.pu0;
import tb.xs0;

/* compiled from: Taobao */
public class DMMtopErrorHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DMMtopErrorHelper dmMtopErrorHelper;
    private boolean isShowLoginUI;

    public static synchronized DMMtopErrorHelper instance() {
        synchronized (DMMtopErrorHelper.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "207739321")) {
                return (DMMtopErrorHelper) ipChange.ipc$dispatch("207739321", new Object[0]);
            }
            if (dmMtopErrorHelper == null) {
                dmMtopErrorHelper = new DMMtopErrorHelper();
            }
            return dmMtopErrorHelper;
        }
    }

    public void error(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254886420")) {
            ipChange.ipc$dispatch("254886420", new Object[]{this, mtopResponse});
        } else if (mtopResponse != null && !mtopResponse.isNoNetwork() && !mtopResponse.isNetworkError() && mtopResponse.isSessionInvalid() && this.isShowLoginUI) {
            pu0.a().b(xs0.a().getApplicationContext());
            d20.r0("");
            d20.x0("");
            d20.k0("");
            ERROR.broadcastLogoutSuccess(xs0.a().getApplicationContext());
        }
    }

    public DMMtopErrorHelper setIsShowLoginUI(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-633207824")) {
            return (DMMtopErrorHelper) ipChange.ipc$dispatch("-633207824", new Object[]{this, Boolean.valueOf(z)});
        }
        this.isShowLoginUI = z;
        return this;
    }
}
