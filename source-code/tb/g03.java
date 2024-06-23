package tb;

import cn.damai.common.user.a;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class g03 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final g03 b = b.INSTANCE.a();

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final g03 a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1946475707")) {
                return g03.b;
            }
            return (g03) ipChange.ipc$dispatch("-1946475707", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        public static final b INSTANCE = new b();
        @NotNull
        private static final g03 a = new g03();

        private b() {
        }

        @NotNull
        public final g03 a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1044093597")) {
                return a;
            }
            return (g03) ipChange.ipc$dispatch("-1044093597", new Object[]{this});
        }
    }

    public final void g(@NotNull String str, long j, long j2, @NotNull String str2, @NotNull String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840778314")) {
            ipChange.ipc$dispatch("-840778314", new Object[]{this, str, Long.valueOf(j), Long.valueOf(j2), str2, str3});
            return;
        }
        k21.i(str, "pageSource");
        k21.i(str2, "module");
        k21.i(str3, "widget");
        c.e().C(str3, str2, str, "1.0", j2 - j, null, 2201);
    }

    @NotNull
    public final a.b h(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1905854701")) {
            return (a.b) ipChange.ipc$dispatch("1905854701", new Object[]{this, str, str2, str3});
        }
        k21.i(str, "pageSource");
        k21.i(str2, "module");
        k21.i(str3, "widget");
        a.b e = e(str, str2, str3, new HashMap(), Boolean.FALSE);
        k21.h(e, "getDamaiUTKeyBuilder(pag…dule, widget, map, false)");
        return e;
    }
}
