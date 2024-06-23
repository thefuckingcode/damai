package com.taobao.monitor.adapter.procedure.getter;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.android.tlog.protocol.model.joint.point.StartupJointPoint;
import com.taobao.monitor.network.a;
import com.taobao.monitor.procedure.IProcedure;
import tb.co1;
import tb.i20;
import tb.us1;

/* compiled from: Taobao */
public class H5ProcedureGetterBridge extends WVApiPlugin {
    private static final String ACTION_PROCEDURE_GETTER = "procedureGetter";
    private static final String TAG = "H5ProcedureGetterBridge";

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!ACTION_PROCEDURE_GETTER.equals(str)) {
            return false;
        }
        try {
            i20.a(TAG, ACTION_PROCEDURE_GETTER);
            String string = JSON.parseObject(str2).getString(ParamsConstants.Key.PARAM_H5URL);
            if (!TextUtils.isEmpty(string)) {
                co1 co1 = us1.PROCEDURE_MANAGER;
                IProcedure launcherProcedure = co1.getLauncherProcedure();
                String str3 = "";
                if (launcherProcedure != null && launcherProcedure.isAlive()) {
                    str3 = a.a(co1.g(launcherProcedure));
                }
                String f = co1.f(string);
                WVResult wVResult = new WVResult();
                wVResult.addData("content", f);
                wVResult.addData(StartupJointPoint.TYPE, str3);
                wVCallBackContext.success(wVResult);
                i20.a(TAG, "content", f);
                i20.a(TAG, StartupJointPoint.TYPE, str3);
                return true;
            }
            throw new IllegalArgumentException("no h5 URL param");
        } catch (Exception e) {
            wVCallBackContext.error(e.getMessage());
        }
    }
}
