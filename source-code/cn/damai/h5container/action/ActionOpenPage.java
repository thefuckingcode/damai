package cn.damai.h5container.action;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.common.nav.DMNav;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xf2;

/* compiled from: Taobao */
public class ActionOpenPage extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionOpenPage(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1795983707")) {
            return ((Boolean) ipChange.ipc$dispatch("1795983707", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String param = getParam("url");
        if (xf2.j(param)) {
            wVCallBackContext.error("error page url");
            return true;
        }
        DMNav.from(this.contextReference).toUri(Uri.parse(param.trim()));
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1946541129")) {
            return "openPage";
        }
        return (String) ipChange.ipc$dispatch("1946541129", new Object[]{this});
    }
}
