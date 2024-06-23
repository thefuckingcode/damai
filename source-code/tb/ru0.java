package tb;

import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.constants.LoginConstants;
import java.util.HashMap;

/* compiled from: Taobao */
public class ru0 extends b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ru0 b;

    private ru0() {
    }

    public static ru0 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1665564933")) {
            return (ru0) ipChange.ipc$dispatch("-1665564933", new Object[0]);
        }
        if (b == null) {
            synchronized (ru0.class) {
                b = new ru0();
            }
        }
        return b;
    }

    private a.b i(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670348709")) {
            return (a.b) ipChange.ipc$dispatch("670348709", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("after_click", str);
        hashMap.put("page_source", str2);
        hashMap.put("isDialog", str3);
        return e("login", "legal_dialog", "pro_select", hashMap, Boolean.FALSE);
    }

    private a.b j(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340335939")) {
            return (a.b) ipChange.ipc$dispatch("340335939", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put(LoginConstants.LOGIN_TYPE, i + "");
        hashMap.put("loginTypeName", LoginManager.k().m());
        hashMap.put("status", str);
        return e("login", "login", "result", hashMap, Boolean.FALSE);
    }

    public a.b g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2014225519")) {
            return b("login");
        }
        return (a.b) ipChange.ipc$dispatch("-2014225519", new Object[]{this});
    }

    public a.b h(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1437761599")) {
            return (a.b) ipChange.ipc$dispatch("-1437761599", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        return e("login", "bottom", "item_" + i, hashMap, Boolean.FALSE);
    }

    public void k(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428186599")) {
            ipChange.ipc$dispatch("428186599", new Object[]{this, str, str2, str3});
            return;
        }
        c.e().x(f().i(str, str2, str3));
    }

    public void l(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686702789")) {
            ipChange.ipc$dispatch("1686702789", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        c.e().x(f().j(i, str));
    }
}
