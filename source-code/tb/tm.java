package tb;

import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class tm extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ADD_CONTACTS_PAGE = "addbuyperson";
    private static tm b;

    public static void f(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155759020")) {
            ipChange.ipc$dispatch("1155759020", new Object[]{Long.valueOf(j), str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("certificate_type", str);
        c.e().C("popconfirmbtn", "pop", "addbuyperson", "1.0", j, hashMap, 2201);
    }

    public static tm j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-483706523")) {
            return (tm) ipChange.ipc$dispatch("-483706523", new Object[0]);
        }
        if (b == null) {
            b = new tm();
        }
        return b;
    }

    public a.b g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898608148")) {
            return (a.b) ipChange.ipc$dispatch("898608148", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("certificate_type", str);
        return e("addbuyperson", "bottom", "confirmbtn", hashMap, Boolean.FALSE);
    }

    public a.b h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237801244")) {
            return (a.b) ipChange.ipc$dispatch("-237801244", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("certificate_type", str);
        return e("addbuyperson", "pop", "cancel", hashMap, Boolean.FALSE);
    }

    public a.b i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687714238")) {
            return (a.b) ipChange.ipc$dispatch("-1687714238", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("certificate_type", str);
        return e("addbuyperson", "pop", "popconfirmbtn", hashMap, Boolean.FALSE);
    }
}
