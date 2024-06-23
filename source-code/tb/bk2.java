package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class bk2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String[] a(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1850717637")) {
            return context.getResources().getStringArray(i);
        }
        return (String[]) ipChange.ipc$dispatch("-1850717637", new Object[]{context, Integer.valueOf(i)});
    }

    public static String b(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1622473052")) {
            return context.getResources().getString(i);
        }
        return (String) ipChange.ipc$dispatch("1622473052", new Object[]{context, Integer.valueOf(i)});
    }

    public static String c(Context context, int i, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-947422381")) {
            return String.format(context.getResources().getString(i), objArr);
        }
        return (String) ipChange.ipc$dispatch("-947422381", new Object[]{context, Integer.valueOf(i), objArr});
    }
}
