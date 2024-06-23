package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class gs1<Response> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean a = Boolean.FALSE;
    @Nullable
    private fb0<Response> b;

    @Nullable
    public final fb0<Response> a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1092786299")) {
            return this.b;
        }
        return (fb0) ipChange.ipc$dispatch("1092786299", new Object[]{this});
    }

    @Nullable
    public final Boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "8963219")) {
            return this.a;
        }
        return (Boolean) ipChange.ipc$dispatch("8963219", new Object[]{this});
    }

    public final void c(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820874633")) {
            ipChange.ipc$dispatch("-820874633", new Object[]{this, bool});
            return;
        }
        this.a = bool;
    }

    public final void d(@Nullable fb0<Response> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2133594581")) {
            ipChange.ipc$dispatch("2133594581", new Object[]{this, fb0});
            return;
        }
        this.b = fb0;
    }
}
