package com.youku.live.livesdk.wkit.utils;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IConfig;
import com.youku.live.widgets.WidgetSDKEngine;

/* compiled from: Taobao */
public class BlackUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    static Boolean sIsBlack;

    public static synchronized boolean isBlack() {
        synchronized (BlackUtil.class) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "2006960537")) {
                return ((Boolean) ipChange.ipc$dispatch("2006960537", new Object[0])).booleanValue();
            }
            Boolean bool = sIsBlack;
            if (bool == null) {
                String string = ((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", "immerseBlacklist", "");
                try {
                    if (!TextUtils.isEmpty(string)) {
                        String[] split = string.split(",");
                        for (String str : split) {
                            if (!Build.getMODEL().equals(str)) {
                                if (!RomUtil.check(str)) {
                                }
                            }
                            sIsBlack = Boolean.TRUE;
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sIsBlack = Boolean.FALSE;
                return false;
            }
            if (bool != null) {
                z = bool.booleanValue();
            }
            return z;
        }
    }

    public static void prefetchIsBlack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1379051028")) {
            ipChange.ipc$dispatch("-1379051028", new Object[0]);
        } else {
            WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() {
                /* class com.youku.live.livesdk.wkit.utils.BlackUtil.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-711177582")) {
                        ipChange.ipc$dispatch("-711177582", new Object[]{this});
                        return;
                    }
                    BlackUtil.isBlack();
                }
            });
        }
    }
}
