package tb;

import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class p42 extends b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final p42 a = new p42();
    }

    public static p42 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1610210391") ? (p42) ipChange.ipc$dispatch("-1610210391", new Object[0]) : a.a;
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234030486")) {
            ipChange.ipc$dispatch("-234030486", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("havanaUserId", d20.i());
        c.e().A(hashMap, "screenfloatclick", "screenfloat");
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953576424")) {
            ipChange.ipc$dispatch("-1953576424", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ScreenShot", "true");
        hashMap.put("permission", "before");
        hashMap.put("havanaUserId", d20.i());
        c.e().A(hashMap, "feedback", yd1.FEED_BACK_LIST_PAGE);
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787282219")) {
            ipChange.ipc$dispatch("-787282219", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ScreenShot", "true");
        hashMap.put("permission", "after");
        hashMap.put("havanaUserId", d20.i());
        c.e().A(hashMap, "feedback", yd1.FEED_BACK_LIST_PAGE);
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328035992")) {
            ipChange.ipc$dispatch("328035992", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ScreenShot", "true");
        hashMap.put("permission", "after");
        hashMap.put("havanaUserId", d20.i());
        c.e().A(hashMap, "shotshare", "addscreenshare");
    }
}
