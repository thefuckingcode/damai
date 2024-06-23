package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.login.LoginManager;
import cn.damai.login.api.IGetAuthCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ActionGetAuthToken extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionGetAuthToken(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, final WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "57490397")) {
            return ((Boolean) ipChange.ipc$dispatch("57490397", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        try {
            LoginManager.k().j(getParam("siteCode"), getParam("target"), getParam("action"), getParam("feature"), new IGetAuthCallback() {
                /* class cn.damai.h5container.action.ActionGetAuthToken.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.login.api.IGetAuthCallback
                public void onAuthTokenFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1688221432")) {
                        ipChange.ipc$dispatch("1688221432", new Object[]{this, str, str2});
                    } else if (wVCallBackContext != null) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("errorCode", str);
                        wVResult.addData("errorMsg", str2);
                        wVCallBackContext.error(wVResult);
                    }
                }

                @Override // cn.damai.login.api.IGetAuthCallback
                public void onAuthTokenSuccess(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1998903377")) {
                        ipChange.ipc$dispatch("-1998903377", new Object[]{this, str});
                    } else if (wVCallBackContext != null) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("token", str);
                        wVCallBackContext.success(wVResult);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1649944651")) {
            return "getAuthToken";
        }
        return (String) ipChange.ipc$dispatch("1649944651", new Object[]{this});
    }
}
