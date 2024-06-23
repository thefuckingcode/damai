package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

public final class c {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String a;

    public static final void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148809721")) {
            ipChange.ipc$dispatch("1148809721", new Object[]{str, str2});
            return;
        }
        k21.i(str, "tag");
        k21.i(str2, "msg");
        if (d.Companion.e()) {
            Log.i(str, str2);
        }
    }

    public static /* synthetic */ void b(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = a;
        }
        a(str, str2);
    }
}
