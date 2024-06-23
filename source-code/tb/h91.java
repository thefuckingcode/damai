package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class h91 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean a;

    public static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176862408")) {
            ipChange.ipc$dispatch("-176862408", new Object[]{str, str2});
        } else if (a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1284717591")) {
            ipChange.ipc$dispatch("1284717591", new Object[]{str, str2});
        } else if (a) {
            Log.e(str, str2);
        }
    }
}
