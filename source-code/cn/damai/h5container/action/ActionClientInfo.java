package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import com.ut.device.UTDevice;
import tb.d20;
import tb.g70;
import tb.yb1;

/* compiled from: Taobao */
public class ActionClientInfo extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionClientInfo(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972317893")) {
            return ((Boolean) ipChange.ipc$dispatch("-972317893", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        WVResult wVResult = new WVResult();
        String userId = Login.getUserId();
        if (userId != null) {
            wVResult.addData("client.uid", userId);
            wVResult.addData("client.havanaId", userId);
            try {
                String c = yb1.c(userId);
                if (!TextUtils.isEmpty(c) && c.length() == 32) {
                    wVResult.addData("client.mixId", yb1.c(userId).substring(8, 24));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        wVResult.addData("os.version", g70.e());
        wVResult.addData("os.name", "Android");
        wVResult.addData("client.citycode", d20.c());
        wVResult.addData("client.cityname", d20.d());
        wVResult.addData("client.version", AppConfig.q());
        wVResult.addData("device.id", UTDevice.getUtdid(this.contextReference));
        wVResult.addData("client.ttid", AppConfig.p());
        wVResult.addData("client.usercode", d20.E());
        wVCallBackContext.success(wVResult);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1970198057")) {
            return "getClientInfo";
        }
        return (String) ipChange.ipc$dispatch("1970198057", new Object[]{this});
    }
}
