package tb;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class sz1 {
    @NotNull
    public static final String a(@NotNull fn0 fn0) {
        k21.i(fn0, "<this>");
        List<og1> h = fn0.h();
        k21.h(h, "pathSegments()");
        return c(h);
    }

    @NotNull
    public static final String b(@NotNull og1 og1) {
        k21.i(og1, "<this>");
        if (d(og1)) {
            String b = og1.b();
            k21.h(b, "asString()");
            return k21.r(String.valueOf('`') + b, "`");
        }
        String b2 = og1.b();
        k21.h(b2, "asString()");
        return b2;
    }

    @NotNull
    public static final String c(@NotNull List<og1> list) {
        k21.i(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (og1 og1 : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(og1));
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final boolean d(og1 og1) {
        boolean z;
        if (og1.g()) {
            return false;
        }
        String b = og1.b();
        k21.h(b, "asString()");
        if (!c61.KEYWORDS.contains(b)) {
            int i = 0;
            while (true) {
                if (i >= b.length()) {
                    z = false;
                    break;
                }
                char charAt = b.charAt(i);
                if (!Character.isLetterOrDigit(charAt) && charAt != '_') {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return true;
            }
            return false;
        }
        return true;
    }
}
