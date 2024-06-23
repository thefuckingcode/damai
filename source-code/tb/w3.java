package tb;

import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class w3 extends b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static w3 b;

    public static w3 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011886555")) {
            return (w3) ipChange.ipc$dispatch("2011886555", new Object[0]);
        }
        if (b == null) {
            b = new w3();
        }
        return b;
    }

    public a.b g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-181626563")) {
            return new a.b().i("addaddress");
        }
        return (a.b) ipChange.ipc$dispatch("-181626563", new Object[]{this});
    }

    public void h(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291143686")) {
            ipChange.ipc$dispatch("-291143686", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("contentlabel", "1");
        } else {
            hashMap.put("contentlabel", "0");
        }
        c.e().x(e("addaddress", "top", "save", hashMap, Boolean.FALSE));
    }
}
