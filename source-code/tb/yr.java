package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class yr {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String NOTIFIY_TIME_ZONE_ID = "notifiy_time_zone_id";

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-449199358")) {
            return yw0.b(NOTIFIY_TIME_ZONE_ID, "", context);
        }
        return (String) ipChange.ipc$dispatch("-449199358", new Object[]{context});
    }

    public static void b(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626966300")) {
            ipChange.ipc$dispatch("1626966300", new Object[]{context, str});
            return;
        }
        yw0.c(NOTIFIY_TIME_ZONE_ID, str, context);
    }
}
