package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ak2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1698394635")) {
            return context.getResources().getString(i);
        }
        return (String) ipChange.ipc$dispatch("-1698394635", new Object[]{context, Integer.valueOf(i)});
    }
}
