package tb;

import android.app.Application;
import android.content.Context;
import com.alibaba.pictures.piclocation.LocateQueueManager;
import com.alibaba.pictures.piclocation.LocationErrorReporter;
import com.alibaba.pictures.piclocation.LocationInterface;
import com.alibaba.pictures.piclocation.listener.GetBlackListInterface;
import com.alibaba.pictures.piclocation.listener.GetLocationInfoInterface;
import com.alibaba.pictures.piclocation.mtop.LocationRequestDelegate;
import com.alipay.sdk.m.e0.a;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.services.core.ServiceSettings;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class o81 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final o81 INSTANCE = new o81();
    private static LocateQueueManager a;
    private static Application b;
    private static LocationRequestDelegate c;
    private static GetLocationInfoInterface d;
    @Nullable
    private static GetBlackListInterface e;
    private static long f = ((long) a.a);
    @Nullable
    private static LocationErrorReporter g;
    private static List<String> h;

    private o81() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: tb.o81 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(o81 o81, Application application, LocationRequestDelegate locationRequestDelegate, LocationErrorReporter locationErrorReporter, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            locationErrorReporter = null;
        }
        if ((i & 8) != 0) {
            list = null;
        }
        o81.e(application, locationRequestDelegate, locationErrorReporter, list);
    }

    @Nullable
    public final List<String> a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1958767945")) {
            return (List) ipChange.ipc$dispatch("1958767945", new Object[]{this});
        }
        if (h == null) {
            GetBlackListInterface getBlackListInterface = e;
            h = getBlackListInterface != null ? getBlackListInterface.getBlackList() : null;
        }
        return h;
    }

    @Nullable
    public final LocationErrorReporter b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1110493746")) {
            return g;
        }
        return (LocationErrorReporter) ipChange.ipc$dispatch("1110493746", new Object[]{this});
    }

    @NotNull
    public final LocationInterface c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1028073445")) {
            return (LocationInterface) ipChange.ipc$dispatch("-1028073445", new Object[]{this});
        }
        if (a == null) {
            a = LocateQueueManager.Companion.a();
        }
        LocateQueueManager locateQueueManager = a;
        if (locateQueueManager != null) {
            locateQueueManager.s(c);
        }
        Application application = b;
        Context context = null;
        if (!(application == null || application == null)) {
            context = application.getApplicationContext();
        }
        x4 c2 = x4.Companion.c(context, a);
        c2.u(d);
        c2.v(f);
        LocateQueueManager locateQueueManager2 = a;
        if (locateQueueManager2 != null) {
            locateQueueManager2.r(c2);
        }
        return c2;
    }

    @JvmOverloads
    public final void d(@NotNull Application application, @Nullable LocationRequestDelegate locationRequestDelegate, @Nullable LocationErrorReporter locationErrorReporter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552395184")) {
            ipChange.ipc$dispatch("1552395184", new Object[]{this, application, locationRequestDelegate, locationErrorReporter});
            return;
        }
        f(this, application, locationRequestDelegate, locationErrorReporter, null, 8, null);
    }

    @JvmOverloads
    public final void e(@NotNull Application application, @Nullable LocationRequestDelegate locationRequestDelegate, @Nullable LocationErrorReporter locationErrorReporter, @Nullable List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "92854433")) {
            ipChange.ipc$dispatch("92854433", new Object[]{this, application, locationRequestDelegate, locationErrorReporter, list});
            return;
        }
        k21.i(application, "application");
        AMapLocationClient.updatePrivacyShow(application, true, true);
        AMapLocationClient.updatePrivacyAgree(application, true);
        ServiceSettings.updatePrivacyShow(application, true, true);
        ServiceSettings.updatePrivacyAgree(application, true);
        b = application;
        c = locationRequestDelegate;
        g = locationErrorReporter;
    }

    public final void g(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868087338")) {
            ipChange.ipc$dispatch("-1868087338", new Object[]{this, Long.valueOf(j)});
            return;
        }
        f = j;
    }

    public final void h(@Nullable GetBlackListInterface getBlackListInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-267183114")) {
            ipChange.ipc$dispatch("-267183114", new Object[]{this, getBlackListInterface});
            return;
        }
        e = getBlackListInterface;
    }

    public final void i(@Nullable GetLocationInfoInterface getLocationInfoInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264487855")) {
            ipChange.ipc$dispatch("-1264487855", new Object[]{this, getLocationInfoInterface});
            return;
        }
        d = getLocationInfoInterface;
    }
}
