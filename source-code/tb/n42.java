package tb;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class n42 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1986493943")) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("1986493943", new Object[]{context, Float.valueOf(f)})).intValue();
    }

    public static DisplayMetrics b(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1620607373")) {
            return context.getResources().getDisplayMetrics();
        }
        return (DisplayMetrics) ipChange.ipc$dispatch("-1620607373", new Object[]{context});
    }

    public static DisplayMetrics c(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088374004")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("2088374004", new Object[]{activity});
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        return displayMetrics;
    }
}
