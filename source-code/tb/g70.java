package tb;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import anet.channel.util.c;
import cn.damai.common.util.CompliantUtUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class g70 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String a;
    private static String b;

    public g70(Context context) {
    }

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-579923896")) {
            return c.c(context);
        }
        return (String) ipChange.ipc$dispatch("-579923896", new Object[]{context});
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992921891")) {
            return (String) ipChange.ipc$dispatch("-1992921891", new Object[0]);
        }
        if (a == null) {
            a = Build.getMODEL();
            CompliantUtUtils.a();
        }
        return a;
    }

    public static int c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794718308")) {
            return ((Integer) ipChange.ipc$dispatch("1794718308", new Object[0])).intValue();
        }
        return DisplayMetrics.getheightPixels(xs0.a().getResources().getDisplayMetrics());
    }

    public static int d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30278145")) {
            return ((Integer) ipChange.ipc$dispatch("-30278145", new Object[0])).intValue();
        }
        return DisplayMetrics.getwidthPixels(xs0.a().getResources().getDisplayMetrics());
    }

    public static String e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "984775107")) {
            return (String) ipChange.ipc$dispatch("984775107", new Object[0]);
        }
        if (b == null) {
            b = Build.VERSION.getRELEASE();
            CompliantUtUtils.d();
        }
        return b;
    }

    public static void f(Activity activity) {
        View currentFocus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "407271198")) {
            ipChange.ipc$dispatch("407271198", new Object[]{activity});
        } else if (activity != null && !activity.isFinishing() && (currentFocus = activity.getCurrentFocus()) != null) {
            try {
                ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
