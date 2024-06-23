package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.common.app.ShareperfenceConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class ActionGetLoginKey extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionGetLoginKey(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1905333724")) {
            return ((Boolean) ipChange.ipc$dispatch("-1905333724", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        WVResult wVResult = new WVResult();
        wVResult.addData(ShareperfenceConstants.OLD_LOGIN_KEY, d20.q());
        wVCallBackContext.success(wVResult);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1318088750")) {
            return "getLoginkey";
        }
        return (String) ipChange.ipc$dispatch("-1318088750", new Object[]{this});
    }
}
