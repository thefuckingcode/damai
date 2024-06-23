package tb;

import android.view.View;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class gt2 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String USER_HOME_PAGE = "consumer_homepage";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final gt2 a = new gt2();
    }

    public static void f(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361745984")) {
            ipChange.ipc$dispatch("-1361745984", new Object[]{view});
            return;
        }
        c.e().G(view, "DNAshow", "top", USER_HOME_PAGE, a03.f());
    }

    public static final gt2 j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1235411141") ? (gt2) ipChange.ipc$dispatch("-1235411141", new Object[0]) : b.a;
    }

    public a.b g(String str, int i, int i2, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954754460")) {
            return (a.b) ipChange.ipc$dispatch("954754460", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d());
        hashMap.put("titlelabel", str2);
        return e(str, "dynamic_tab_" + i, "card_" + i2, hashMap, Boolean.TRUE);
    }

    public a.b h(String str, int i, int i2, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443229274")) {
            return (a.b) ipChange.ipc$dispatch("443229274", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d());
        hashMap.put("titlelabel", str2);
        return e(str, "dynamic_tab_" + i, "card_more_" + i2, hashMap, Boolean.FALSE);
    }

    public a.b i(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439221375")) {
            return (a.b) ipChange.ipc$dispatch("-439221375", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d());
        hashMap.put("titlelabel", str2);
        return e(str, "dynamic_tab", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b k() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1912055040")) {
            return e(USER_HOME_PAGE, "bottom", "submitbtn", null, Boolean.TRUE);
        }
        return (a.b) ipChange.ipc$dispatch("1912055040", new Object[]{this});
    }

    public a.b l(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696073015")) {
            return (a.b) ipChange.ipc$dispatch("-696073015", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d());
        hashMap.put("titlelabel", str);
        return e(USER_HOME_PAGE, "center", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b m(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2084990161")) {
            return c(USER_HOME_PAGE, "top", str, Boolean.FALSE);
        }
        return (a.b) ipChange.ipc$dispatch("-2084990161", new Object[]{this, str});
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19923378")) {
            ipChange.ipc$dispatch("19923378", new Object[]{this});
            return;
        }
        c.e().x(e(USER_HOME_PAGE, "account_info", "portrait", a03.f(), Boolean.TRUE));
    }

    public void o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053291652")) {
            ipChange.ipc$dispatch("-1053291652", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        c.e().x(e(USER_HOME_PAGE, "top", "DNAshow", a03.f(), Boolean.valueOf(z)));
    }

    private gt2() {
    }
}
