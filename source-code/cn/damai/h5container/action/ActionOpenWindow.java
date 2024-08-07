package cn.damai.h5container.action;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ActionOpenWindow extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionOpenWindow(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1437260348")) {
            return ((Boolean) ipChange.ipc$dispatch("1437260348", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String str3 = (String) JSON.parseObject(str2).get("url");
        if (TextUtils.isEmpty(str3)) {
            wVCallBackContext.error();
        } else {
            DMNav.from(this.contextReference).toUri(Uri.parse(str3.trim()));
            wVCallBackContext.success();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-64736790")) {
            return "openWindow";
        }
        return (String) ipChange.ipc$dispatch("-64736790", new Object[]{this});
    }
}
