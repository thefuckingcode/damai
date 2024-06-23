package tb;

import cn.damai.common.user.a;
import cn.damai.common.user.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class m30 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_NAME_DRAMA_COMMING = "coming_drama";
    private static m30 b = new m30();

    public static m30 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "216669063") ? (m30) ipChange.ipc$dispatch("216669063", new Object[0]) : b;
    }

    public a.b g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720178847")) {
            return (a.b) ipChange.ipc$dispatch("720178847", new Object[]{this});
        }
        String E = d20.E();
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", E);
        return new a.b().j(hashMap).a(d20.d()).i(PAGE_NAME_DRAMA_COMMING);
    }
}
