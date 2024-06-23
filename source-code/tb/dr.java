package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class dr {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final dr INSTANCE = new dr();

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private String a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @Nullable
        private Map<String, String> g;
        @Nullable
        private String h;
        @Nullable
        private String i;
        private boolean j;

        @NotNull
        public final a a(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1996708533")) {
                return (a) ipChange.ipc$dispatch("-1996708533", new Object[]{this, str});
            }
            this.a = str;
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
            if (r1 == null) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x008f, code lost:
            if (r1 == null) goto L_0x0091;
         */
        public final void b() {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "472031520")) {
                ipChange.ipc$dispatch("472031520", new Object[]{this});
            } else if (!yz2.j()) {
                try {
                    hr hrVar = new hr();
                    Map<String, String> map = this.g;
                    if (map != null) {
                        hrVar.setExtral(map);
                    }
                    hrVar.setBizCode(this.e);
                    hrVar.setBizMsg(this.f);
                    String str2 = this.a;
                    if (str2 != null && k21.d("mtop.damai.mec.aristotle.get", str2)) {
                        str2 = this.a + '_' + this.h + '_' + this.i;
                    }
                    hrVar.setBizScene(str2);
                    String str3 = this.c;
                    if (str3 != null) {
                        str = str3.toLowerCase(Locale.ROOT);
                        k21.h(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    }
                    String str4 = this.b;
                    if (str4 != null) {
                        str = ("a2o4t." + str4).toLowerCase(Locale.ROOT);
                        k21.h(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    }
                    str = "a2o4t.null";
                    hrVar.setPageSpm(str);
                    hrVar.setPageName(this.d);
                    hrVar.setResultExpected(this.j);
                    hrVar.release();
                } catch (Exception unused) {
                }
            }
        }

        @NotNull
        public final a c(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-331536101")) {
                return (a) ipChange.ipc$dispatch("-331536101", new Object[]{this, str});
            }
            this.e = str;
            return this;
        }

        @NotNull
        public final a d(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1719962779")) {
                return (a) ipChange.ipc$dispatch("1719962779", new Object[]{this, str});
            }
            this.f = str;
            return this;
        }

        @NotNull
        public final a e(@Nullable Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-974690911")) {
                return (a) ipChange.ipc$dispatch("-974690911", new Object[]{this, map});
            }
            this.g = map;
            return this;
        }

        @NotNull
        public final a f(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1718514345")) {
                return (a) ipChange.ipc$dispatch("1718514345", new Object[]{this, Boolean.valueOf(z)});
            }
            this.j = this.j;
            return this;
        }

        @NotNull
        public final a g(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "728906157")) {
                return (a) ipChange.ipc$dispatch("728906157", new Object[]{this, str});
            }
            this.d = str;
            return this;
        }

        @NotNull
        public final a h(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1040452033")) {
                return (a) ipChange.ipc$dispatch("1040452033", new Object[]{this, str});
            }
            this.h = str;
            return this;
        }

        @NotNull
        public final a i(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1027414422")) {
                return (a) ipChange.ipc$dispatch("-1027414422", new Object[]{this, str});
            }
            this.i = str;
            return this;
        }

        @NotNull
        public final a j(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "717991540")) {
                return (a) ipChange.ipc$dispatch("717991540", new Object[]{this, str});
            }
            this.b = str;
            return this;
        }
    }

    private dr() {
    }

    @NotNull
    public final a a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1375842605")) {
            return new a();
        }
        return (a) ipChange.ipc$dispatch("-1375842605", new Object[]{this});
    }
}
