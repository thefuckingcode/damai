package tb;

import android.app.Activity;
import android.view.View;
import cn.damai.common.DamaiConstants;
import cn.damai.common.util.GrayViewBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
public class ht0 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static GrayViewBean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-449970010") ? (GrayViewBean) ipChange.ipc$dispatch("-449970010", new Object[0]) : (GrayViewBean) s41.a(d20.B("GRAY_VIEW_CONFIG"), GrayViewBean.class);
    }

    public static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902423027")) {
            ipChange.ipc$dispatch("902423027", new Object[0]);
            return;
        }
        GrayViewBean grayViewBean = new GrayViewBean();
        Map<String, String> allConfig = pn.d().getAllConfig(DamaiConstants.BLACK_WHITE_VIEW_CONFIG);
        if (allConfig == null || !allConfig.containsKey("enable_config")) {
            g91.c("LauncherApplication_xxx", "orange灰白值 为null");
            return;
        }
        String str = allConfig.get("time_start_config");
        String str2 = allConfig.get("time_end_config");
        String str3 = allConfig.get("classNames");
        g91.c("LauncherApplication_xxx", "orange灰白值enable_config=" + allConfig.get("enable_config") + " startTimeConfig=" + str + " endTimeConfig=" + str2 + " classNames=" + str3);
        grayViewBean.enableConfig = allConfig.get("enable_config");
        grayViewBean.startTimeConfig = str;
        grayViewBean.endTimeConfig = str2;
        grayViewBean.classNames = str3;
        f(grayViewBean);
    }

    public static boolean c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472492199")) {
            return ((Boolean) ipChange.ipc$dispatch("472492199", new Object[]{str})).booleanValue();
        }
        g91.c("BaseActivity", "currentClassName=" + str);
        new GrayViewBean();
        GrayViewBean a = a();
        if (a != null && a.isEnableGrayConfig() && a.isValidTime()) {
            if (a.isPartGray() || a.isPartPageGray()) {
                return a.isContainClass(str);
            }
            if (a.isAllGray()) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-964580099")) {
            return ((Boolean) ipChange.ipc$dispatch("-964580099", new Object[]{str})).booleanValue();
        }
        new GrayViewBean();
        GrayViewBean a = a();
        if (a == null || !a.isPageGray(str)) {
            return false;
        }
        return true;
    }

    public static boolean e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221117592")) {
            return ((Boolean) ipChange.ipc$dispatch("-1221117592", new Object[0])).booleanValue();
        }
        new GrayViewBean();
        GrayViewBean a = a();
        if (a == null || !a.isPartGray() || !a.isValidTime()) {
            return false;
        }
        return true;
    }

    private static void f(GrayViewBean grayViewBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929073453")) {
            ipChange.ipc$dispatch("1929073453", new Object[]{grayViewBean});
            return;
        }
        d20.T("GRAY_VIEW_CONFIG", s41.e(grayViewBean));
    }

    public static void g(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516449818")) {
            ipChange.ipc$dispatch("1516449818", new Object[]{activity, view});
        } else if (activity != null) {
            try {
                if (d(activity.getClass().getSimpleName())) {
                    es.a(view);
                }
            } catch (Exception unused) {
            }
        }
    }
}
