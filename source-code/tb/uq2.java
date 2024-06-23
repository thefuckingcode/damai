package tb;

import com.alibaba.pictures.ut.IClkParamsHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class uq2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final uq2 INSTANCE = new uq2();
    private static HashMap<String, String> a = new HashMap<>();
    @Nullable
    private static String b;
    @Nullable
    private static String c;
    @Nullable
    private static String d;
    private static boolean e;
    @NotNull
    private static String f = "";
    @Nullable
    private static IClkParamsHandler g;

    private uq2() {
    }

    public final void a() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1135818775")) {
            ipChange.ipc$dispatch("-1135818775", new Object[]{this});
            return;
        }
        String str = b;
        if (!(str == null || str.length() == 0)) {
            String str2 = c;
            if (!(str2 == null || str2.length() == 0)) {
                yi c2 = yi.c();
                k21.h(c2, "ClientVariables.getInstance()");
                String a2 = c2.a();
                if (a2 == null || a2.length() == 0) {
                    z = true;
                }
                if (z) {
                    yi c3 = yi.c();
                    k21.h(c3, "ClientVariables.getInstance()");
                    c3.k(b);
                    ot2.a("ut初始化成功");
                    return;
                }
                return;
            }
        }
        throw new RuntimeException("com.alibaba.pictures.ut.UTManager:没有配置appkey和UT A位信息，请先在使用之前调用configUt(appKey: String, utAppId: String)来配置");
    }

    @JvmOverloads
    public final void b(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493119503")) {
            ipChange.ipc$dispatch("-1493119503", new Object[]{this, str, str2, str3});
            return;
        }
        k21.i(str, "appKey");
        k21.i(str2, "utAppId");
        b = str;
        c = str2;
        d = str3;
    }

    @NotNull
    public final String c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1146257376")) {
            return f;
        }
        return (String) ipChange.ipc$dispatch("-1146257376", new Object[]{this});
    }

    public final boolean d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1540008665")) {
            return e;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1540008665", new Object[]{this})).booleanValue();
    }

    @Nullable
    public final String e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1936811594")) {
            return d;
        }
        return (String) ipChange.ipc$dispatch("-1936811594", new Object[]{this});
    }

    @Nullable
    public final String f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1697128655")) {
            return c;
        }
        return (String) ipChange.ipc$dispatch("1697128655", new Object[]{this});
    }

    @Nullable
    public final IClkParamsHandler g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-130405374")) {
            return g;
        }
        return (IClkParamsHandler) ipChange.ipc$dispatch("-130405374", new Object[]{this});
    }

    @Nullable
    public final String h(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1307132315")) {
            return (String) ipChange.ipc$dispatch("1307132315", new Object[]{this, str});
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            return null;
        }
        return a.get(str);
    }

    public final void i(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388067436")) {
            ipChange.ipc$dispatch("388067436", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "pageName");
        k21.i(str2, e03.PAGE_SPM_DIMEN);
        a.put(str, str2);
    }
}
