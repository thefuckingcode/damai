package kotlin.text;

import com.taobao.weex.common.Constants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import tb.k21;
import tb.r11;
import tb.w11;
import tb.ww1;

public class o extends n {
    public static /* synthetic */ boolean A(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        return z(str, i, str2, i2, i3, (i4 & 16) != 0 ? false : z);
    }

    public static String B(CharSequence charSequence, int i) {
        k21.i(charSequence, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        } else if (i == 0) {
            return "";
        } else {
            if (i == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i);
                r11 d = new w11(1, i).iterator();
                while (d.hasNext()) {
                    d.nextInt();
                    sb.append(charSequence);
                }
                String sb2 = sb.toString();
                k21.h(sb2, "{\n                    va…tring()\n                }");
                return sb2;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = charAt;
            }
            return new String(cArr);
        }
    }

    public static final String C(String str, char c, char c2, boolean z) {
        k21.i(str, "<this>");
        if (!z) {
            String replace = str.replace(c, c2);
            k21.h(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (c.d(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final String D(String str, String str2, String str3, boolean z) {
        k21.i(str, "<this>");
        k21.i(str2, "oldValue");
        k21.i(str3, "newValue");
        int i = 0;
        int b0 = StringsKt__StringsKt.b0(str, str2, 0, z);
        if (b0 < 0) {
            return str;
        }
        int length = str2.length();
        int i2 = ww1.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i, b0);
                sb.append(str3);
                i = b0 + length;
                if (b0 >= str.length()) {
                    break;
                }
                b0 = StringsKt__StringsKt.b0(str, str2, b0 + i2, z);
            } while (b0 > 0);
            sb.append((CharSequence) str, i, str.length());
            String sb2 = sb.toString();
            k21.h(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String E(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return C(str, c, c2, z);
    }

    public static /* synthetic */ String F(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return D(str, str2, str3, z);
    }

    public static String G(String str, String str2, String str3, boolean z) {
        k21.i(str, "<this>");
        k21.i(str2, "oldValue");
        k21.i(str3, "newValue");
        int i = StringsKt__StringsKt.f0(str, str2, 0, z, 2, null);
        return i < 0 ? str : StringsKt__StringsKt.v0(str, i, str2.length() + i, str3).toString();
    }

    public static /* synthetic */ String H(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return G(str, str2, str3, z);
    }

    public static final boolean I(String str, String str2, int i, boolean z) {
        k21.i(str, "<this>");
        k21.i(str2, Constants.Name.PREFIX);
        if (!z) {
            return str.startsWith(str2, i);
        }
        return z(str, i, str2, 0, str2.length(), z);
    }

    public static boolean J(String str, String str2, boolean z) {
        k21.i(str, "<this>");
        k21.i(str2, Constants.Name.PREFIX);
        if (!z) {
            return str.startsWith(str2);
        }
        return z(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean K(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return I(str, str2, i, z);
    }

    public static /* synthetic */ boolean L(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return J(str, str2, z);
    }

    public static String p(String str) {
        k21.i(str, "<this>");
        Locale locale = Locale.getDefault();
        k21.h(locale, "getDefault()");
        return q(str, locale);
    }

    public static final String q(String str, Locale locale) {
        k21.i(str, "<this>");
        k21.i(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            k21.g(substring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = substring.toUpperCase(locale);
            k21.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
        }
        String substring2 = str.substring(1);
        k21.h(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final boolean r(CharSequence charSequence, CharSequence charSequence2) {
        if (!(charSequence instanceof String) || charSequence2 == null) {
            return StringsKt__StringsKt.S(charSequence, charSequence2);
        }
        return ((String) charSequence).contentEquals(charSequence2);
    }

    public static boolean s(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (z) {
            return StringsKt__StringsKt.R(charSequence, charSequence2);
        }
        return r(charSequence, charSequence2);
    }

    public static String t(String str) {
        k21.i(str, "<this>");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        k21.g(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase();
        k21.h(lowerCase, "this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        k21.h(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    public static final boolean u(String str, String str2, boolean z) {
        k21.i(str, "<this>");
        k21.i(str2, Constants.Name.SUFFIX);
        if (!z) {
            return str.endsWith(str2);
        }
        return z(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean v(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return u(str, str2, z);
    }

    public static boolean w(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean x(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return w(str, str2, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    public static boolean y(CharSequence charSequence) {
        boolean z;
        k21.i(charSequence, "<this>");
        if (charSequence.length() != 0) {
            w11 w11 = StringsKt__StringsKt.Y(charSequence);
            if (!(w11 instanceof Collection) || !((Collection) w11).isEmpty()) {
                Iterator it = w11.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!b.c(charSequence.charAt(((r11) it).nextInt()))) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    return true;
                }
                return false;
            }
            z = true;
            if (!z) {
            }
        }
        return true;
    }

    public static final boolean z(String str, int i, String str2, int i2, int i3, boolean z) {
        k21.i(str, "<this>");
        k21.i(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
