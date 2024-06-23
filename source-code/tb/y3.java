package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class y3 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final y3 INSTANCE = new y3();

    private y3() {
    }

    @NotNull
    public final String a(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1289523904")) {
            return (String) ipChange.ipc$dispatch("-1289523904", new Object[]{this, str, str2});
        }
        k21.i(str, "originalUrl");
        k21.i(str2, "param");
        if (str.length() <= 0) {
            z = false;
        }
        if (!z) {
            return "";
        }
        if (StringsKt__StringsKt.Q(str, "?", false, 2, null)) {
            return str + '&' + str2;
        }
        return str + jl1.CONDITION_IF + str2;
    }
}
