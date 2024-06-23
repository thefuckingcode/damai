package tb;

import cn.damai.common.user.a;
import cn.damai.common.user.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class sz0 extends b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    private static class a {
        private static final sz0 a = new sz0();
    }

    public static final sz0 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-184364165") ? (sz0) ipChange.ipc$dispatch("-184364165", new Object[0]) : a.a;
    }

    public a.b f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484333615")) {
            return (a.b) ipChange.ipc$dispatch("-1484333615", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return new a.b().j(hashMap).i("poster");
    }
}
