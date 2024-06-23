package cn.damai.h5container;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import cn.damai.login.authlogin.resp.CookieBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.d20;
import tb.s71;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class DamaiCookieManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_USER_DATA = 1003;
    private static final DamaiCookieManager ourInstance = new DamaiCookieManager();

    private DamaiCookieManager() {
    }

    public static DamaiCookieManager getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1227589851") ? (DamaiCookieManager) ipChange.ipc$dispatch("-1227589851", new Object[0]) : ourInstance;
    }

    public String getUserSecurityKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1713875654")) {
            return d20.F();
        }
        return (String) ipChange.ipc$dispatch("-1713875654", new Object[]{this});
    }

    public void removeAllCookie() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425578107")) {
            ipChange.ipc$dispatch("-425578107", new Object[]{this});
            return;
        }
        CookieSyncManager.createInstance(xs0.a());
        CookieManager.getInstance().removeAllCookie();
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public void resetAll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1008216210")) {
            ipChange.ipc$dispatch("1008216210", new Object[]{this});
            return;
        }
        removeAllCookie();
        d20.y0("");
    }

    public void setCookie(String str, List<CookieBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1244331195")) {
            ipChange.ipc$dispatch("1244331195", new Object[]{this, str, list});
        } else if (!s71.a(list)) {
            CookieSyncManager.createInstance(xs0.a());
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            for (CookieBean cookieBean : list) {
                instance.setCookie(str, cookieBean.toCookieString());
                Log.d("setThirdCookie", "cookie:" + cookieBean.toCookieString());
            }
            CookieSyncManager.getInstance().sync();
        }
    }

    public void setDamaiCookie(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193448894")) {
            ipChange.ipc$dispatch("193448894", new Object[]{this, str, str2});
        } else if (!xf2.j(str2)) {
            CookieSyncManager.createInstance(xs0.a());
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            instance.setCookie(str, "loginkey=" + str2 + ";Domain=damai.cn;Path=/;");
            Log.d("setCookie", "loginkey=" + str2 + ";Domain=damai.cn;Path=/;");
            CookieSyncManager.getInstance().sync();
        }
    }
}
