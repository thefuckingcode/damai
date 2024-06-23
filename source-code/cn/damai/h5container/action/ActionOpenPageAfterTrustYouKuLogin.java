package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.login.LoginManager;
import cn.damai.login.YouKuTrustListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.su0;
import tb.yz2;

/* compiled from: Taobao */
public class ActionOpenPageAfterTrustYouKuLogin extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionOpenPageAfterTrustYouKuLogin(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053406857")) {
            return ((Boolean) ipChange.ipc$dispatch("-2053406857", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        final String param = getParam("url");
        LoginManager.k().i(this.contextReference, 0, new YouKuTrustListener() {
            /* class cn.damai.h5container.action.ActionOpenPageAfterTrustYouKuLogin.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.login.YouKuTrustListener
            public void showLoading(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-955216455")) {
                    ipChange.ipc$dispatch("-955216455", new Object[]{this, Boolean.valueOf(z)});
                    return;
                }
                Context context = ActionOpenPageAfterTrustYouKuLogin.this.contextReference;
                if (context instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) context;
                    if (z) {
                        baseActivity.startProgressDialog();
                    } else {
                        baseActivity.stopProgressDialog();
                    }
                }
            }

            @Override // cn.damai.login.YouKuTrustListener
            public void trustYouKuFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1505235317")) {
                    ipChange.ipc$dispatch("1505235317", new Object[]{this, str, str2});
                    return;
                }
                ToastUtil.i(str2);
                yz2.a(yz2.i("", "", str, str2, ""), su0.LOGIN_YOUKU_BRIDGE_FAILED_CODE, su0.LOGIN_YOUKU_BRIDGE_FAILED_MSG);
            }

            @Override // cn.damai.login.YouKuTrustListener
            public void trustYouKuSuccess() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1799342856")) {
                    ipChange.ipc$dispatch("1799342856", new Object[]{this});
                } else if (!TextUtils.isEmpty(param)) {
                    DMNav.from(ActionOpenPageAfterTrustYouKuLogin.this.contextReference).toUri(param);
                }
            }
        });
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1819969691")) {
            return "openPageAfterTrustYouKuLogin";
        }
        return (String) ipChange.ipc$dispatch("-1819969691", new Object[]{this});
    }
}
