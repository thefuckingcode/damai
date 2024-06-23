package tb;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ft2 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555571831")) {
            return (String) ipChange.ipc$dispatch("555571831", new Object[]{Integer.valueOf(i)});
        } else if (i <= 10000) {
            return String.valueOf(i);
        } else {
            return (i / 10000) + "." + ((i % 10000) / 1000) + "万";
        }
    }
}
