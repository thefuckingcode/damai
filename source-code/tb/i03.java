package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class i03 {
    @NotNull
    public static final i03 INSTANCE = new i03();
    @NotNull
    private static String a = "";

    private i03() {
    }

    @NotNull
    public final String a() {
        return a;
    }

    public final void b(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        k21.i(str, "platform");
        k21.i(str2, "module");
        k21.i(str3, "point");
        new e03(str, str2, str3);
    }

    public final void c(@NotNull String str) {
        k21.i(str, "<set-?>");
        a = str;
    }
}
