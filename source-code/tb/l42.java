package tb;

import android.content.Context;
import android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class l42 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static long a;

    public static int a(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2033106594")) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("2033106594", new Object[]{context, Float.valueOf(f)})).intValue();
    }

    public static DisplayMetrics b(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-698095906")) {
            return context.getResources().getDisplayMetrics();
        }
        return (DisplayMetrics) ipChange.ipc$dispatch("-698095906", new Object[]{context});
    }

    public static int c(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1107439833")) {
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
        }
        return ((Integer) ipChange.ipc$dispatch("1107439833", new Object[]{context})).intValue();
    }

    public static boolean d() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1705006309")) {
            return ((Boolean) ipChange.ipc$dispatch("1705006309", new Object[0])).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a <= 300) {
            z = true;
        }
        if (!z) {
            a = currentTimeMillis;
        }
        return z;
    }
}
