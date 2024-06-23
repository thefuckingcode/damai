package cn.damai.h5container.h5url;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class VipUrlGetter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String VIP_BUY_ONLINE = "https://m.damai.cn/damai/activity/vip/join.html";
    public static final String VIP_BUY_PRE = "https://market.wapa.damai.cn/damai/activity/vip/join.html";
    public static final String VIP_BUY_TEST = "https://market.wapa.taobao.com/app/damai/h5-activity/pages/vip/join.html";
    public static final String VIP_CENTER_ONLINE = "https://m.damai.cn/damai/activity/vip/index.html";
    public static final String VIP_CENTER_PRE = "https://market.wapa.damai.cn/damai/activity/vip/index.html";
    public static final String VIP_CENTER_TEST = "https://market.wapa.taobao.com/app/damai/h5-activity/pages/vip/index.html";

    /* renamed from: cn.damai.h5container.h5url.VipUrlGetter$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cn$damai$common$AppConfig$EnvMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[AppConfig.EnvMode.values().length];
            $SwitchMap$cn$damai$common$AppConfig$EnvMode = iArr;
            iArr[AppConfig.EnvMode.prepare.ordinal()] = 1;
            $SwitchMap$cn$damai$common$AppConfig$EnvMode[AppConfig.EnvMode.test.ordinal()] = 2;
        }
    }

    private VipUrlGetter() {
    }

    public static String vipBuyUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390253593")) {
            return (String) ipChange.ipc$dispatch("390253593", new Object[0]);
        }
        if (!AppConfig.v()) {
            return VIP_BUY_ONLINE;
        }
        int i = AnonymousClass1.$SwitchMap$cn$damai$common$AppConfig$EnvMode[AppConfig.h().ordinal()];
        if (i == 1) {
            return VIP_BUY_PRE;
        }
        if (i != 2) {
            return VIP_BUY_ONLINE;
        }
        return VIP_BUY_TEST;
    }

    public static String vipCenterUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002998208")) {
            return (String) ipChange.ipc$dispatch("2002998208", new Object[0]);
        }
        if (!AppConfig.v()) {
            return VIP_CENTER_ONLINE;
        }
        int i = AnonymousClass1.$SwitchMap$cn$damai$common$AppConfig$EnvMode[AppConfig.h().ordinal()];
        if (i == 1) {
            return VIP_CENTER_PRE;
        }
        if (i != 2) {
            return VIP_CENTER_ONLINE;
        }
        return VIP_CENTER_TEST;
    }
}
