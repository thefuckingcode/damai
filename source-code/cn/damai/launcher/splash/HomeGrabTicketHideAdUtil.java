package cn.damai.launcher.splash;

import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.ol1;

/* compiled from: Taobao */
public class HomeGrabTicketHideAdUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean isHideAd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1226387972")) {
            return ((Boolean) ipChange.ipc$dispatch("1226387972", new Object[0])).booleanValue();
        }
        try {
            long m = d20.m();
            int a = OrangeConfigCenter.c().a(ol1.GRAB_TICKLET_HIDE_AD_MINUTES, "limit_time", 5) * 60 * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            long j = (long) a;
            if (m <= currentTimeMillis - j || m >= currentTimeMillis + j) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }
}
