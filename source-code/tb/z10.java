package tb;

import android.util.Base64;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class z10 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654573725")) {
            return (String) ipChange.ipc$dispatch("1654573725", new Object[]{str});
        }
        try {
            byte[] a = kk.a(Base64.decode(str, 2), Base64.decode("qJzGEh6hESZDVJeCnFPGuxzaiB7NLQM3", 2));
            if (a != null) {
                return new String(a);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710716154")) {
            return (String) ipChange.ipc$dispatch("-1710716154", new Object[]{str});
        }
        try {
            return Base64.encodeToString(kk.b(str.getBytes(), Base64.decode("qJzGEh6hESZDVJeCnFPGuxzaiB7NLQM3", 2)), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
