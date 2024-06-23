package tb;

import android.app.Activity;
import android.content.res.Configuration;
import com.alibaba.pictures.responsive.page.IResponsivePage;
import com.alibaba.pictures.responsive.state.ResponsivePageStateCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class w02 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Activity a;
    @NotNull
    private final IResponsivePage b;
    private int c;
    private int d;

    public w02(@NotNull Activity activity, @NotNull IResponsivePage iResponsivePage) {
        k21.i(activity, "activity");
        k21.i(iResponsivePage, "responsivePage");
        this.a = activity;
        this.b = iResponsivePage;
        this.d = ResponsivePageStateCache.Companion.a().f(activity);
    }

    public final int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-853831472")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("-853831472", new Object[]{this})).intValue();
    }

    public final void b(@Nullable Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-72591600")) {
            ipChange.ipc$dispatch("-72591600", new Object[]{this, configuration});
        } else if (g12.INSTANCE.j(this.a)) {
            this.c = this.d;
            this.d = ResponsivePageStateCache.Companion.a().f(this.a);
        }
    }

    public final void c(@Nullable Configuration configuration) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "2134578096")) {
            ipChange.ipc$dispatch("2134578096", new Object[]{this, configuration});
        } else if (g12.INSTANCE.j(this.a)) {
            IResponsivePage iResponsivePage = this.b;
            int i = this.d;
            if (this.c == i) {
                z = false;
            }
            iResponsivePage.onResponsiveLayout(configuration, i, z);
        }
    }
}
