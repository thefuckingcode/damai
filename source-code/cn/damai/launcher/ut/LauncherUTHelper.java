package cn.damai.launcher.ut;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.launcher.splash.api.SplashResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.util.HashMap;
import tb.d20;
import tb.xf2;

/* compiled from: Taobao */
public class LauncherUTHelper extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EVENT_SPLASH_ADS_NOT_SHOW = "event_splash_ads_not_show";
    public static final String EVENT_SPLASH_ADS_SHOW = "event_splash_ads_show";
    public static final String WELCOME_PAGE = "welcome";
    private static LauncherUTHelper b;

    public static void f(View view, SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439899691")) {
            ipChange.ipc$dispatch("-1439899691", new Object[]{view, splashResponse});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("city", d20.d());
            if (splashResponse != null) {
                hashMap.put("contentlabel", splashResponse.getPic());
                if (!TextUtils.isEmpty(splashResponse.comboDispatchSystem)) {
                    hashMap.put("dispatch_system", splashResponse.comboDispatchSystem);
                }
                if (!TextUtils.isEmpty(splashResponse.comboDispatchId)) {
                    hashMap.put("dispatch_id", splashResponse.comboDispatchId);
                }
            }
            c.e().G(view, BaseCellItem.TYPE_BUTTON, "bottom", "welcome", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static LauncherUTHelper getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63482657")) {
            return (LauncherUTHelper) ipChange.ipc$dispatch("63482657", new Object[0]);
        }
        if (b == null) {
            b = new LauncherUTHelper();
        }
        return b;
    }

    public a.b g(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "144019292")) {
            return b(str);
        }
        return (a.b) ipChange.ipc$dispatch("144019292", new Object[]{this, str});
    }

    public a.b h(SplashResponse splashResponse, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "151940271")) {
            return (a.b) ipChange.ipc$dispatch("151940271", new Object[]{this, splashResponse, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", str + "市");
        hashMap.put("contentlabel", str2);
        if (splashResponse != null) {
            if (!TextUtils.isEmpty(splashResponse.comboDispatchSystem)) {
                hashMap.put("dispatch_system", splashResponse.comboDispatchSystem);
            }
            if (!TextUtils.isEmpty(splashResponse.comboDispatchId)) {
                hashMap.put("dispatch_id", splashResponse.comboDispatchId);
            }
        }
        return e("welcome", "bottom", BaseCellItem.TYPE_BUTTON, hashMap, Boolean.TRUE);
    }

    public void i(long j, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068156183")) {
            ipChange.ipc$dispatch("-1068156183", new Object[]{this, Long.valueOf(j), str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", d20.d());
        hashMap.put("duration", String.valueOf(j));
        if (!xf2.j(str)) {
            hashMap.put("pic", str);
        }
        if (!xf2.j(str2)) {
            hashMap.put("schema", str2);
        }
        c.e().A(hashMap, EVENT_SPLASH_ADS_SHOW, "welcome");
    }

    public void j(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721759201")) {
            ipChange.ipc$dispatch("-1721759201", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", d20.d());
        if (!xf2.j(str)) {
            hashMap.put("pic", str);
        }
        if (!xf2.j(str2)) {
            hashMap.put("schema", str2);
        }
        c.e().A(hashMap, EVENT_SPLASH_ADS_NOT_SHOW, "welcome");
    }
}
