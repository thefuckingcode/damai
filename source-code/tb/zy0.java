package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class zy0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private volatile boolean a;
    @Nullable
    private JSONObject b;
    @Nullable
    private byte[] c;
    @Nullable
    private Integer d;
    @Nullable
    private String e;
    @Nullable
    private Boolean f;
    @Nullable
    private String g;
    @Nullable
    private Boolean h;
    @Nullable
    private Boolean i;

    public zy0() {
        Boolean bool = Boolean.FALSE;
        this.h = bool;
        this.i = bool;
    }

    public static /* synthetic */ void j(zy0 zy0, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charset.forName("UTF-8");
            k21.h(charset, "Charset.forName(\"UTF-8\")");
        }
        zy0.i(charset);
    }

    @Nullable
    public final String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1166523785")) {
            return this.g;
        }
        return (String) ipChange.ipc$dispatch("-1166523785", new Object[]{this});
    }

    @Nullable
    public final byte[] b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1109391208")) {
            return this.c;
        }
        return (byte[]) ipChange.ipc$dispatch("1109391208", new Object[]{this});
    }

    @Nullable
    public final JSONObject c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579927396")) {
            return (JSONObject) ipChange.ipc$dispatch("1579927396", new Object[]{this});
        }
        if (this.b == null && !this.a) {
            j(this, null, 1, null);
        }
        return this.b;
    }

    @Nullable
    public final Integer d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-849972836")) {
            return this.d;
        }
        return (Integer) ipChange.ipc$dispatch("-849972836", new Object[]{this});
    }

    @Nullable
    public final String e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1822105625")) {
            return this.e;
        }
        return (String) ipChange.ipc$dispatch("1822105625", new Object[]{this});
    }

    @Nullable
    public final Boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1993400695")) {
            return this.f;
        }
        return (Boolean) ipChange.ipc$dispatch("1993400695", new Object[]{this});
    }

    @Nullable
    public final Boolean g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1833966251")) {
            return this.i;
        }
        return (Boolean) ipChange.ipc$dispatch("-1833966251", new Object[]{this});
    }

    @Nullable
    public final Boolean h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2118410111")) {
            return this.h;
        }
        return (Boolean) ipChange.ipc$dispatch("2118410111", new Object[]{this});
    }

    public final void i(@NotNull Charset charset) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279097272")) {
            ipChange.ipc$dispatch("-1279097272", new Object[]{this, charset});
            return;
        }
        k21.i(charset, "charset");
        if (!this.a) {
            synchronized (this) {
                if (!this.a) {
                    byte[] bArr = this.c;
                    if (bArr != null) {
                        this.b = new JSONObject(new String(bArr, charset));
                    }
                    this.a = true;
                }
                ur2 ur2 = ur2.INSTANCE;
            }
        }
    }

    public final void k(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-823290053")) {
            ipChange.ipc$dispatch("-823290053", new Object[]{this, bool});
            return;
        }
        this.f = bool;
    }

    public final void l(@Nullable byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798588912")) {
            ipChange.ipc$dispatch("-1798588912", new Object[]{this, bArr});
            return;
        }
        this.c = bArr;
    }

    public final void m(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165407466")) {
            ipChange.ipc$dispatch("-165407466", new Object[]{this, num});
            return;
        }
        this.d = num;
    }

    public final void n(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744392475")) {
            ipChange.ipc$dispatch("-744392475", new Object[]{this, str});
            return;
        }
        this.e = str;
    }
}
