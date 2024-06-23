package tb;

import java.util.Iterator;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class qf {
    @NotNull
    public static final String a(@NotNull String str) {
        k21.i(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            z = true;
        }
        if (!z) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        String substring = str.substring(1);
        k21.h(substring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(upperCase) + substring;
    }

    @NotNull
    public static final String b(@NotNull String str) {
        k21.i(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt <= 'Z') {
            z = true;
        }
        if (!z) {
            return str;
        }
        char lowerCase = Character.toLowerCase(charAt);
        String substring = str.substring(1);
        k21.h(substring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(lowerCase) + substring;
    }

    @NotNull
    public static final String c(@NotNull String str, boolean z) {
        Object obj;
        k21.i(str, "<this>");
        if ((str.length() == 0) || !d(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z)) {
            return z ? b(str) : o.t(str);
        }
        Iterator it = StringsKt__StringsKt.Y(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!d(str, ((Number) obj).intValue(), z)) {
                break;
            }
        }
        Integer num = (Integer) obj;
        if (num == null) {
            return e(str, z);
        }
        int intValue = num.intValue() - 1;
        String substring = str.substring(0, intValue);
        k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String e = e(substring, z);
        String substring2 = str.substring(intValue);
        k21.h(substring2, "(this as java.lang.String).substring(startIndex)");
        return k21.r(e, substring2);
    }

    private static final boolean d(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        if (z) {
            return 'A' <= charAt && charAt <= 'Z';
        }
        return Character.isUpperCase(charAt);
    }

    private static final String e(String str, boolean z) {
        if (z) {
            return f(str);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @NotNull
    public static final String f(@NotNull String str) {
        k21.i(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            i++;
            if ('A' <= charAt && charAt <= 'Z') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        k21.h(sb2, "builder.toString()");
        return sb2;
    }
}
