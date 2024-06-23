package tb;

import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.commonbusiness.config.SeatSwitch;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ol1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String GRAB_TICKLET_HIDE_AD_MINUTES = "grad_ticket_hide_ad_time";
    public static final String HOME_OTHER_TIME_ZONE_IN_CHINA = "home_other_time_zone_in_china";
    public static final String IMAGE_TO_WEBP = "image_to_webp";
    public static final String LIVE_PLATFORM_CONFIG = "live_platform_config";
    public static final String LIVE_WEEX_CONFIG = "live_weex_config";
    public static final String WVPLUGIN_NAMESPACE = "wvplugin_namespace";
    public static final String WVPLUGIN_SEND_HOST = "wvplugin_send_host";
    public static String a = "damai_nfc_switch";
    public static String b = "dm_mycoupon_flutter";
    public static String c = "damai_search_downgrage_to_old";
    public static String d = "is_use_old_search_page";
    public static String e = "damai_coupon_tab_control";
    public static String f = "damai_oneservice_switch";

    public static boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1118383259")) {
            return ((Boolean) ipChange.ipc$dispatch("1118383259", new Object[0])).booleanValue();
        }
        return OrangeConfigCenter.c().a(c, d, 0) == 1;
    }

    public static boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619048974")) {
            return ((Boolean) ipChange.ipc$dispatch("-1619048974", new Object[0])).booleanValue();
        }
        return true;
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863296468")) {
            ipChange.ipc$dispatch("-1863296468", new Object[0]);
            return;
        }
        OrangeConfigCenter.c().e(AppConfig.TICKLET_LOCAL_DATA_NAMESPACE);
        OrangeConfigCenter.c().e(WVPLUGIN_NAMESPACE);
        OrangeConfigCenter.c().e(rb0.e);
        OrangeConfigCenter.c().e(rb0.f);
        OrangeConfigCenter.c().e(rb0.g);
        OrangeConfigCenter.c().e(b20.ACCSS_HAVANAID_CONFIG);
        OrangeConfigCenter.c().e(a);
        OrangeConfigCenter.c().e(f);
        SeatSwitch.b(true);
        fh2.b(true);
        y6.c();
        OrangeConfigCenter.c().e(HOME_OTHER_TIME_ZONE_IN_CHINA);
        OrangeConfigCenter.c().e("damai_webp");
        OrangeConfigCenter.c().e(GRAB_TICKLET_HIDE_AD_MINUTES);
        nr.d();
        d72.c();
        OrangeConfigCenter.c().e(e81.a);
        OrangeConfigCenter.c().e(LIVE_WEEX_CONFIG);
        OrangeConfigCenter.c().e(LIVE_PLATFORM_CONFIG);
        OrangeConfigCenter.c().e(b);
        OrangeConfigCenter.c().e(e);
        m01.c();
        h03.f(true);
        l3.a(true);
        OrangeConfigCenter.c().e(c);
        OrangeConfigCenter.c().e("dm_mtop_head_coordinates");
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598233773")) {
            ipChange.ipc$dispatch("-1598233773", new Object[0]);
            return;
        }
        OrangeConfigCenter.c().g(AppConfig.TICKLET_LOCAL_DATA_NAMESPACE);
        OrangeConfigCenter.c().g("damai_image_android_phenix");
        OrangeConfigCenter.c().g(WVPLUGIN_NAMESPACE);
        OrangeConfigCenter.c().g(rb0.e);
        OrangeConfigCenter.c().g(rb0.f);
        OrangeConfigCenter.c().g(rb0.g);
        OrangeConfigCenter.c().g(b20.ACCSS_HAVANAID_CONFIG);
        OrangeConfigCenter.c().g(a);
        fh2.b(false);
        SeatSwitch.b(false);
        y6.e();
        OrangeConfigCenter.c().g(HOME_OTHER_TIME_ZONE_IN_CHINA);
        OrangeConfigCenter.c().g("damai_webp");
        OrangeConfigCenter.c().g(GRAB_TICKLET_HIDE_AD_MINUTES);
        nr.e();
        d72.d();
        OrangeConfigCenter.c().g(e81.a);
        OrangeConfigCenter.c().g(LIVE_WEEX_CONFIG);
        OrangeConfigCenter.c().g(LIVE_PLATFORM_CONFIG);
        OrangeConfigCenter.c().g(b);
        OrangeConfigCenter.c().g(e);
        OrangeConfigCenter.c().g("dm_mtop_head_coordinates");
        m01.d();
        h03.f(false);
        l3.a(false);
    }
}
