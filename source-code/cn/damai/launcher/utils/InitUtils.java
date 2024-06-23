package cn.damai.launcher.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.util.PriorityTask;
import cn.damai.launcher.AppPreLauncher;
import cn.damai.launcher.PrivacyDoubleListDelegate;
import cn.damai.launcher.altriax.LaunchTrigger;
import cn.damai.launcher.initialize.CommonBiz;
import cn.damai.launcher.initialize.ProcessUtils;
import cn.damai.wantsee.StartConfig;
import com.alibaba.pictures.bricks.channel.DamaiComponentFilterBridgeImpl;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.b;
import tb.bb0;
import tb.d20;
import tb.g91;
import tb.kr1;
import tb.nc;
import tb.nl;
import tb.ns1;
import tb.ua0;
import tb.xk2;
import tb.xs0;
import tb.z4;

/* compiled from: Taobao */
public class InitUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[IGlobalConfig.Key.values().length];
            a = iArr;
            iArr[IGlobalConfig.Key.IS_GET.ordinal()] = 1;
            a[IGlobalConfig.Key.NEED_LOGIN_FOR_ALL_REQ.ordinal()] = 2;
            a[IGlobalConfig.Key.WUA_SWITCH.ordinal()] = 3;
            a[IGlobalConfig.Key.PROJECT_NAME.ordinal()] = 4;
            a[IGlobalConfig.Key.IS_USE_HTTPS.ordinal()] = 5;
            try {
                a[IGlobalConfig.Key.DOLORES_API_WHITE_LIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756157082")) {
            ipChange.ipc$dispatch("756157082", new Object[0]);
            return;
        }
        ua0.o(xs0.a());
        ua0.p().u(AppConfig.p());
        ua0.t(new DoloresLoginDelegate());
        ua0.s(AppConfig.v());
        ua0.r(new DoloresGlobalInterceptor());
        ua0.q(new IGlobalConfig() {
            /* class cn.damai.launcher.utils.InitUtils.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.alibaba.pictures.dolores.config.IGlobalConfig
            @Nullable
            public String getGlobalConfig(@NonNull IGlobalConfig.Key key, @Nullable String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1598449500")) {
                    return (String) ipChange.ipc$dispatch("1598449500", new Object[]{this, key, str});
                }
                switch (a.a[key.ordinal()]) {
                    case 1:
                        return "true";
                    case 2:
                    case 3:
                        return "false";
                    case 4:
                        return d20.s();
                    case 5:
                        return d20.u() ? "false" : "true";
                    case 6:
                        return "";
                    default:
                        return null;
                }
            }
        });
        bb0.j(new DoloresMonitorDelegate());
    }

    private static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352939865")) {
            ipChange.ipc$dispatch("-1352939865", new Object[0]);
        } else if (ProcessUtils.b(xs0.a())) {
            z4.d(xs0.a(), true);
        }
    }

    private static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864793267")) {
            ipChange.ipc$dispatch("1864793267", new Object[0]);
        } else if (ProcessUtils.b(xs0.a())) {
            kr1.Companion.a().n(xs0.a(), d20.c(), StartConfig.getPopupSceneTypes());
        }
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679756204")) {
            ipChange.ipc$dispatch("-1679756204", new Object[0]);
            return;
        }
        CommonBiz.getInstance().j();
        nc.d();
        new AppPreLauncher().b(xs0.a());
        PrivacyDoubleListDelegate.INSTANCE.b();
        nc.c("initBeforeAtlas");
        b();
        nc.c("initOnlineMonitor");
        LaunchTrigger.c(xs0.a()).f();
        nc.c("AltriaXStart");
        CommonBiz.getInstance().L();
        CommonBiz.getInstance().m();
        nc.c("initLocationSDK");
        a();
        c();
        b.INSTANCE.b(xs0.a());
        nl.INSTANCE.b(new DamaiComponentFilterBridgeImpl());
        ns1.a(new PriorityTask("workerThread", xs0.a(), 1) {
            /* class cn.damai.launcher.utils.InitUtils.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.util.PriorityTask
            public void doTask() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "14768585")) {
                    ipChange.ipc$dispatch("14768585", new Object[]{this});
                    return;
                }
                try {
                    nc.e(120);
                    CommonBiz.getInstance().x();
                    nc.a("SubThreadInitSDK", 120);
                } catch (Exception e) {
                    e.printStackTrace();
                    g91.c("initSDK", "initSDK catch   " + xk2.a(e));
                }
            }
        });
    }
}
