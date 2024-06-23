package tb;

import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class jm0 extends b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static jm0 b;

    public static jm0 g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481950773")) {
            return (jm0) ipChange.ipc$dispatch("1481950773", new Object[0]);
        }
        if (b == null) {
            b = new jm0();
        }
        return b;
    }

    public void f(HashMap<String, String> hashMap, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744469817")) {
            ipChange.ipc$dispatch("-744469817", new Object[]{this, hashMap, str, str2});
            return;
        }
        c.e().A(hashMap, str, str2);
    }
}
