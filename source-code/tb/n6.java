package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class n6 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "656238395")) {
            return "damai_market";
        }
        return (String) ipChange.ipc$dispatch("656238395", new Object[]{context});
    }
}
