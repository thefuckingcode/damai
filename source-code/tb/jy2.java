package tb;

import android.text.TextUtils;
import cn.damai.wantsee.StartConfig;
import cn.damai.wantsee.WantSeeOrangeConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class jy2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final jy2 INSTANCE = new jy2();
    @Nullable
    private static WantSeeOrangeConfig a;

    private jy2() {
    }

    private final WantSeeOrangeConfig a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414054609")) {
            return (WantSeeOrangeConfig) ipChange.ipc$dispatch("414054609", new Object[]{this});
        }
        WantSeeOrangeConfig wantSeeOrangeConfig = a;
        if (wantSeeOrangeConfig != null) {
            k21.g(wantSeeOrangeConfig, "null cannot be cast to non-null type cn.damai.wantsee.WantSeeOrangeConfig");
            return wantSeeOrangeConfig;
        }
        WantSeeOrangeConfig wantSeeOrangeConfig2 = null;
        try {
            String b = d20.b();
            if (!TextUtils.isEmpty(b)) {
                StartConfig startConfig = (StartConfig) s41.a(b, StartConfig.class);
                if ((startConfig != null ? startConfig.wantSeeOrangeConfig : null) != null) {
                    wantSeeOrangeConfig2 = startConfig.wantSeeOrangeConfig;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (wantSeeOrangeConfig2 == null) {
            wantSeeOrangeConfig2 = new WantSeeOrangeConfig();
        }
        a = wantSeeOrangeConfig2;
        return wantSeeOrangeConfig2;
    }

    public final boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1234903651")) {
            return a().isEvaluateListWantSeeOpen;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1234903651", new Object[]{this})).booleanValue();
    }

    public final boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1171307479")) {
            return a().isProjectWantSeeOpen;
        }
        return ((Boolean) ipChange.ipc$dispatch("1171307479", new Object[]{this})).booleanValue();
    }
}
