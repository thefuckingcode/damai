package tb;

import java.util.List;
import kotlin.collections.m;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class zu1 {
    @NotNull
    public static final List<og1> a(@NotNull og1 og1) {
        k21.i(og1, "name");
        String b = og1.b();
        k21.h(b, "name.asString()");
        t41 t41 = t41.INSTANCE;
        if (t41.b(b)) {
            return m.k(b(og1));
        }
        if (t41.c(b)) {
            return f(og1);
        }
        return nd.INSTANCE.b(og1);
    }

    @Nullable
    public static final og1 b(@NotNull og1 og1) {
        k21.i(og1, "methodName");
        og1 e = e(og1, gl1.TYPE_OPEN_URL_METHOD_GET, false, null, 12, null);
        return e == null ? e(og1, "is", false, null, 8, null) : e;
    }

    @Nullable
    public static final og1 c(@NotNull og1 og1, boolean z) {
        k21.i(og1, "methodName");
        return e(og1, "set", false, z ? "is" : null, 4, null);
    }

    private static final og1 d(og1 og1, String str, boolean z, String str2) {
        if (og1.g()) {
            return null;
        }
        String d = og1.d();
        k21.h(d, "methodName.identifier");
        boolean z2 = false;
        if (!(o.L(d, str, false, 2, null)) || d.length() == str.length()) {
            return null;
        }
        char charAt = d.charAt(str.length());
        if ('a' <= charAt && charAt <= 'z') {
            z2 = true;
        }
        if (z2) {
            return null;
        }
        if (str2 != null) {
            return og1.f(k21.r(str2, StringsKt__StringsKt.u0(d, str)));
        }
        if (!z) {
            return og1;
        }
        String c = qf.c(StringsKt__StringsKt.u0(d, str), true);
        if (!og1.h(c)) {
            return null;
        }
        return og1.f(c);
    }

    static /* synthetic */ og1 e(og1 og1, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return d(og1, str, z, str2);
    }

    @NotNull
    public static final List<og1> f(@NotNull og1 og1) {
        k21.i(og1, "methodName");
        return m.l(c(og1, false), c(og1, true));
    }
}
