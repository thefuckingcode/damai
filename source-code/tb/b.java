package tb;

import android.app.Application;
import cn.damai.abtest.ABTestOrangeModel;
import cn.damai.wantsee.StartConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d;

/* compiled from: Taobao */
public final class b {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final b INSTANCE = new b();

    private b() {
    }

    @Nullable
    public final ABTestOrangeModel a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130755606")) {
            return (ABTestOrangeModel) ipChange.ipc$dispatch("2130755606", new Object[]{this});
        }
        StartConfig configFromSp = StartConfig.getConfigFromSp();
        if (configFromSp != null) {
            return configFromSp.abTestOrangeModel;
        }
        return null;
    }

    public final void b(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514085685")) {
            ipChange.ipc$dispatch("-1514085685", new Object[]{this, application});
            return;
        }
        k21.i(application, "application");
        d.b bVar = d.b.INSTANCE;
        bVar.e(2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(fw0.INSTANCE.d());
        bVar.h(arrayList);
        bVar.g(Login.getUserId());
        bVar.f(false);
        try {
            d.Companion.c(application, bVar);
        } catch (Exception e) {
            g91.c("ABTestHelper", "error=" + e);
        }
    }
}
