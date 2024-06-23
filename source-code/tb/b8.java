package tb;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.j02;

/* compiled from: Taobao */
public final class b8 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static j02 a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1903663640")) {
            return new j02.a(activity);
        }
        return (j02) ipChange.ipc$dispatch("1903663640", new Object[]{activity});
    }
}
