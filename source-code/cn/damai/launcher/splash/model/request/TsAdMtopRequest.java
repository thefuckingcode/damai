package cn.damai.launcher.splash.model.request;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.launcher.splash.api.SplashRequest;
import cn.damai.launcher.splash.api.SplashResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class TsAdMtopRequest extends TimeSensitiveRequest<SplashResponse> {
    private static transient /* synthetic */ IpChange $ipChange;

    public TsAdMtopRequest(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest
    public void callRequest(final OnBizListener<SplashResponse> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243988399")) {
            ipChange.ipc$dispatch("-1243988399", new Object[]{this, onBizListener});
            return;
        }
        final SplashRequest splashRequest = new SplashRequest();
        if (AppConfig.g().equals(AppConfig.EnvMode.prepare) && d20.j()) {
            splashRequest.viewDate = d20.k();
        }
        splashRequest.request(new DMMtopRequestListener<SplashResponse>(SplashResponse.class) {
            /* class cn.damai.launcher.splash.model.request.TsAdMtopRequest.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1615002460")) {
                    ipChange.ipc$dispatch("-1615002460", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onBizFail(str, str2);
            }

            public void onSuccess(SplashResponse splashResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1815212809")) {
                    ipChange.ipc$dispatch("-1815212809", new Object[]{this, splashResponse});
                    return;
                }
                if (splashResponse != null) {
                    splashResponse.setDiffCityId(splashRequest.cityid);
                }
                onBizListener.onBizSuccess(splashResponse);
            }
        });
    }
}
