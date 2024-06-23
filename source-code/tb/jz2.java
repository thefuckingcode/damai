package tb;

import android.app.Application;
import cn.damai.common.AppConfig;
import cn.damai.live.LiveActivity;
import com.alibaba.aliweex.AliWXSDKEngine;
import com.alibaba.aliweex.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;

/* compiled from: Taobao */
public class jz2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916091754")) {
            ipChange.ipc$dispatch("-1916091754", new Object[]{application});
            return;
        }
        try {
            WXEnvironment.addCustomOptions("appName", "damaiAndroid");
            WXEnvironment.addCustomOptions(LiveActivity.OPTION_TTID, "701088@damai_android_" + AppConfig.q());
            a.l().r(application, new a.C0069a.C0070a().a());
            AliWXSDKEngine.d();
            if (WXSDKEngine.isInitialized()) {
                g91.c("WXSDKEngine", "damai success");
            } else {
                g91.c("WXSDKEngine", "damai fail");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
