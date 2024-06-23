package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.alibaba.pictures.responsive.page.IResponsivePage;
import com.alibaba.pictures.responsive.state.ResponsivePageStateCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class u02 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Activity a;
    @NotNull
    private final IResponsivePage b;
    private int c;
    private int d;
    @Nullable
    private bn1 e;

    public u02(@NotNull Activity activity, @NotNull IResponsivePage iResponsivePage) {
        k21.i(activity, "activity");
        k21.i(iResponsivePage, "responsivePage");
        this.a = activity;
        this.b = iResponsivePage;
        b();
    }

    private final void a(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540858541")) {
            ipChange.ipc$dispatch("540858541", new Object[]{this, configuration});
        } else if (e70.INSTANCE.e(this.a) && e70.g(this.a)) {
            int requestedOrientation = this.a.getRequestedOrientation();
            if (configuration.orientation == 2 && requestedOrientation == 1) {
                configuration.orientation = 1;
            }
        }
    }

    private final void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855830015")) {
            ipChange.ipc$dispatch("-855830015", new Object[]{this});
            return;
        }
        g12 g12 = g12.INSTANCE;
        if (g12.j(this.a)) {
            int i = g12.i(this.a);
            int g = g12.g(this.a);
            float f = this.a.getResources().getDisplayMetrics().density;
            int i2 = (int) (((float) i) / f);
            int i3 = (int) (((float) g) / f);
            if (Build.VERSION.SDK_INT >= 24 && this.a.isInMultiWindowMode()) {
                this.a.getResources().getConfiguration().screenWidthDp = i2;
                this.a.getResources().getConfiguration().screenHeightDp = i3;
            }
            ResponsivePageStateCache.a aVar = ResponsivePageStateCache.Companion;
            ResponsivePageStateCache a2 = aVar.a();
            Activity activity = this.a;
            a2.g(activity, activity.getResources().getConfiguration().orientation);
            aVar.a().i(this.a, i2);
            ResponsivePageStateCache a3 = aVar.a();
            Activity activity2 = this.a;
            a3.h(activity2, activity2.getResources().getConfiguration().screenHeightDp);
            g(this.a, i2, i3);
            this.d = aVar.a().f(this.a);
            if (!e70.INSTANCE.e(this.a)) {
                this.e = new bn1(this.a);
            }
        } else if (this.a.getRequestedOrientation() != 1) {
            dn1.INSTANCE.b(this.a, 1);
        }
    }

    private final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1249316247")) {
            ipChange.ipc$dispatch("-1249316247", new Object[]{this});
        } else if (this.e != null && e70.g(this.a)) {
            int requestedOrientation = this.a.getRequestedOrientation();
            if (requestedOrientation == 0 || requestedOrientation == 8) {
                ResponsivePageStateCache.a aVar = ResponsivePageStateCache.Companion;
                float d2 = (float) aVar.a().d(this.a);
                float c2 = (float) aVar.a().c(this.a);
                if (Math.abs(((float) aVar.a().e(this.a)) - d2) <= 80.0f && d2 > ((float) bd2.b()) && c2 <= ((float) bd2.b())) {
                    dn1.INSTANCE.b(this.a, 1);
                }
            }
        }
    }

    private final void g(Context context, int i, int i2) {
        int i3;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-754037379")) {
            ipChange.ipc$dispatch("-754037379", new Object[]{this, context, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (!e70.INSTANCE.c() || ((double) i2) * 2.3d > ((double) i)) {
            if (((double) i2) > ((double) i) * 1.25d) {
                z = false;
            }
            i3 = (i < bd2.a() || !z) ? 1000 : 1001;
        } else {
            i3 = 1002;
        }
        ResponsivePageStateCache.Companion.a().j(context, i3);
    }

    private final void h(Context context, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-426785677")) {
            ipChange.ipc$dispatch("-426785677", new Object[]{this, context, configuration});
            return;
        }
        ResponsivePageStateCache a2 = ResponsivePageStateCache.Companion.a();
        a2.g(context, configuration.orientation);
        a2.i(context, configuration.screenWidthDp);
        a2.h(context, configuration.screenHeightDp);
        g(context, configuration.screenWidthDp, configuration.screenHeightDp);
    }

    public final void c(@NotNull Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1384390897")) {
            ipChange.ipc$dispatch("1384390897", new Object[]{this, configuration});
            return;
        }
        k21.i(configuration, "newConfig");
        if (g12.INSTANCE.j(this.a)) {
            a(configuration);
            h(this.a, configuration);
            this.c = this.d;
            this.d = ResponsivePageStateCache.Companion.a().f(this.a);
        }
    }

    public final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403191667")) {
            ipChange.ipc$dispatch("1403191667", new Object[]{this});
            return;
        }
        ResponsivePageStateCache.Companion.a().b(this.a);
        bn1 bn1 = this.e;
        if (bn1 != null) {
            bn1.g();
        }
    }

    public final void e(@Nullable Configuration configuration) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-394463727")) {
            ipChange.ipc$dispatch("-394463727", new Object[]{this, configuration});
        } else if (g12.INSTANCE.j(this.a)) {
            f();
            int i = this.c;
            int i2 = this.d;
            if (i == i2) {
                z = false;
            }
            this.b.onResponsiveLayout(configuration, i2, z);
        }
    }
}
