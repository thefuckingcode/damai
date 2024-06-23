package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class fl2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001256183")) {
            ipChange.ipc$dispatch("-2001256183", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(d20.i()) && !d20.i().equals(fs1.c())) {
            fs1.d(xs0.a(), fs1.TICKLET_PREFERENCE_USERCODE, d20.i());
        }
        i30.e().d(xs0.a());
    }
}
