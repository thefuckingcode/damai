package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import cn.damai.commonbusiness.faceverify.listener.DMFaceVerifyListener;
import cn.damai.commonbusiness.faceverify.listener.DMFaceVerifyResult;
import cn.damai.commonbusiness.faceverify.manager.DMFaceVerifyManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ActionFaceVerify extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionFaceVerify(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, final WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626085272")) {
            return ((Boolean) ipChange.ipc$dispatch("1626085272", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String param = getParam("idCard");
        String param2 = getParam("name");
        String param3 = getParam("scene");
        String param4 = getParam("idType");
        if (TextUtils.isEmpty(param4)) {
            param4 = "1";
        }
        DMFaceVerifyManager n = DMFaceVerifyManager.n();
        n.w(this.contextReference, param, param4, param2, param3);
        n.v(new DMFaceVerifyListener() {
            /* class cn.damai.h5container.action.ActionFaceVerify.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.faceverify.listener.DMFaceVerifyListener
            public void onAuditResult(DMFaceVerifyResult dMFaceVerifyResult) {
                DMFaceVerifyResult.State state;
                IpChange ipChange = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange, "1272403592")) {
                    ipChange.ipc$dispatch("1272403592", new Object[]{this, dMFaceVerifyResult});
                    return;
                }
                if (dMFaceVerifyResult == null || (state = dMFaceVerifyResult.a) == DMFaceVerifyResult.State.SUCCESS || state == DMFaceVerifyResult.State.EMPTY) {
                    z = true;
                }
                WVResult wVResult = new WVResult();
                wVResult.addData("verifyResult", Boolean.valueOf(z));
                wVCallBackContext.success(wVResult);
            }
        });
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1245281210")) {
            return "gotoFaceVerify";
        }
        return (String) ipChange.ipc$dispatch("-1245281210", new Object[]{this});
    }
}
