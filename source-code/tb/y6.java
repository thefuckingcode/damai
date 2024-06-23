package tb;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

@Deprecated
/* compiled from: Taobao */
public class y6 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String a;
    private static boolean b;

    public static String a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1085665624")) {
            return (String) ipChange.ipc$dispatch("-1085665624", new Object[0]);
        }
        if (!b) {
            b();
            b = true;
            nu2.a("AppNavBgUtil", "从Orange配置中获取色值");
        }
        nu2.a("AppNavBgUtil", "get color = " + a);
        return "";
    }

    private static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588383180")) {
            ipChange.ipc$dispatch("588383180", new Object[0]);
        } else if (TextUtils.isEmpty(a)) {
            nu2.a("AppNavBgUtil", "onFetch AppNavColor = " + a + "");
        }
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196219360")) {
            ipChange.ipc$dispatch("196219360", new Object[0]);
        } else {
            nu2.a("AppNavBgUtil", "register");
        }
    }

    public static void d(View view) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "671063010")) {
            ipChange.ipc$dispatch("671063010", new Object[]{view});
        } else if (view != null) {
            String a2 = a();
            if (!TextUtils.isEmpty(a2)) {
                try {
                    i = Color.parseColor(a2);
                } catch (Exception e) {
                    nu2.a("AppNavBgUtil", e.getMessage());
                }
                if (i != 0) {
                    view.setBackgroundColor(i);
                }
            }
        }
    }

    public static void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1911520775")) {
            ipChange.ipc$dispatch("1911520775", new Object[0]);
        } else {
            nu2.a("AppNavBgUtil", "unRegister");
        }
    }
}
