package com.taobao.slide.launch;

import android.app.Application;
import com.taobao.slide.api.SlideConfig;
import com.taobao.slide.api.SlideLoad;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.HashMap;
import tb.jl1;
import tb.o22;

/* compiled from: Taobao */
public class TaobaoLaunchSlide implements Serializable {
    private static final String LAUNCH_APPVERSION = "appVersion";
    private static final String LAUNCH_ENVINDEX = "envIndex";
    private static final String LAUNCH_ONLINEAPPKEY = "onlineAppKey";
    private static final String LAUNCH_PREAPPKEY = "preAppKey";
    private static final String LAUNCH_TESTAPPKEY = "dailyAppkey";
    private static final String LAUNCH_TTID = "ttid";
    private static final String TAG = "TaobaoLaunchSlide";

    public void init(Application application, HashMap<String, Object> hashMap) {
        String str;
        String str2;
        Throwable th;
        o22.c(TAG, "init start", new Object[0]);
        SlideConfig.ENV env = SlideConfig.ENV.ONLINE;
        try {
            str = (String) hashMap.get("appVersion");
            try {
                int intValue = ((Integer) hashMap.get("envIndex")).intValue();
                if (intValue == env.ordinal()) {
                    str2 = (String) hashMap.get("onlineAppKey");
                } else {
                    SlideConfig.ENV env2 = SlideConfig.ENV.PREPARE;
                    if (intValue == env2.ordinal()) {
                        try {
                            str2 = (String) hashMap.get("preAppKey");
                            env = env2;
                        } catch (Throwable th2) {
                            th = th2;
                            env = env2;
                            o22.d(TAG, UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
                            str2 = "21646297";
                            SlideLoad.h().j(application, new SlideConfig.b().b(str2).c(str).e(env).f((String) hashMap.get("ttid")).d(false).a());
                        }
                    } else {
                        env = SlideConfig.ENV.TEST;
                        str2 = (String) hashMap.get("dailyAppkey");
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                o22.d(TAG, UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
                str2 = "21646297";
                SlideLoad.h().j(application, new SlideConfig.b().b(str2).c(str).e(env).f((String) hashMap.get("ttid")).d(false).a());
            }
        } catch (Throwable th4) {
            str = jl1.MUL;
            th = th4;
            o22.d(TAG, UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
            str2 = "21646297";
            SlideLoad.h().j(application, new SlideConfig.b().b(str2).c(str).e(env).f((String) hashMap.get("ttid")).d(false).a());
        }
        SlideLoad.h().j(application, new SlideConfig.b().b(str2).c(str).e(env).f((String) hashMap.get("ttid")).d(false).a());
    }
}
