package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import mtopsdk.mtop.domain.JsonTypeEnum;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class a02 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean a;
    @Nullable
    private Boolean b;
    @Nullable
    private Boolean c;
    @Nullable
    private Boolean d;
    @Nullable
    private Map<String, String> e;
    @Nullable
    private JsonTypeEnum f;
    @Nullable
    private String g;
    @Nullable
    private Double[] h;
    private boolean i;

    @Nullable
    public final Map<String, String> a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-573198006")) {
            return this.e;
        }
        return (Map) ipChange.ipc$dispatch("-573198006", new Object[]{this});
    }

    @Nullable
    public final JsonTypeEnum b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1866842620")) {
            return this.f;
        }
        return (JsonTypeEnum) ipChange.ipc$dispatch("1866842620", new Object[]{this});
    }

    @Nullable
    public final Double[] c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-222432703")) {
            return this.h;
        }
        return (Double[]) ipChange.ipc$dispatch("-222432703", new Object[]{this});
    }

    @Nullable
    public final String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2107918065")) {
            return this.g;
        }
        return (String) ipChange.ipc$dispatch("2107918065", new Object[]{this});
    }

    public final boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1363985885")) {
            return this.i;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1363985885", new Object[]{this})).booleanValue();
    }

    @Nullable
    public final Boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2037850763")) {
            return this.c;
        }
        return (Boolean) ipChange.ipc$dispatch("2037850763", new Object[]{this});
    }

    @Nullable
    public final Boolean g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "83253216")) {
            return this.b;
        }
        return (Boolean) ipChange.ipc$dispatch("83253216", new Object[]{this});
    }

    @Nullable
    public final Boolean h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1592663122")) {
            return this.d;
        }
        return (Boolean) ipChange.ipc$dispatch("-1592663122", new Object[]{this});
    }

    @Nullable
    public final Boolean i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "419069988")) {
            return this.a;
        }
        return (Boolean) ipChange.ipc$dispatch("419069988", new Object[]{this});
    }
}
