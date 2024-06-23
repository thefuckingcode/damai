package kotlin.text;

import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.h;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;
import tb.do2;
import tb.ih;
import tb.k21;
import tb.r11;
import tb.u11;
import tb.w11;
import tb.ww1;

public class StringsKt__StringsKt extends o {

    public static final class a extends ih {
        private int a;
        final /* synthetic */ CharSequence b;

        a(CharSequence charSequence) {
            this.b = charSequence;
        }

        @Override // tb.ih
        public char a() {
            CharSequence charSequence = this.b;
            int i = this.a;
            this.a = i + 1;
            return charSequence.charAt(i);
        }

        public boolean hasNext() {
            return this.a < this.b.length();
        }
    }

    public static final Sequence<String> A0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        k21.i(charSequence, "<this>");
        k21.i(strArr, "delimiters");
        return SequencesKt___SequencesKt.v(s0(charSequence, strArr, 0, z, i, 2, null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ Sequence B0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return A0(charSequence, strArr, z, i);
    }

    public static final boolean C0(CharSequence charSequence, char c, boolean z) {
        k21.i(charSequence, "<this>");
        return charSequence.length() > 0 && c.d(charSequence.charAt(0), c, z);
    }

    public static final boolean D0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        k21.i(charSequence, "<this>");
        k21.i(charSequence2, Constants.Name.PREFIX);
        if (z || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return t0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
        }
        return o.L((String) charSequence, (String) charSequence2, false, 2, null);
    }

    public static /* synthetic */ boolean E0(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return C0(charSequence, c, z);
    }

    public static /* synthetic */ boolean F0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return D0(charSequence, charSequence2, z);
    }

    public static final String G0(CharSequence charSequence, w11 w11) {
        k21.i(charSequence, "<this>");
        k21.i(w11, "range");
        return charSequence.subSequence(w11.getStart().intValue(), w11.getEndInclusive().intValue() + 1).toString();
    }

    public static final String H0(String str, char c, String str2) {
        k21.i(str, "<this>");
        k21.i(str2, "missingDelimiterValue");
        int i = e0(str, c, 0, false, 6, null);
        if (i == -1) {
            return str2;
        }
        String substring = str.substring(i + 1, str.length());
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String I0(String str, String str2, String str3) {
        k21.i(str, "<this>");
        k21.i(str2, "delimiter");
        k21.i(str3, "missingDelimiterValue");
        int i = f0(str, str2, 0, false, 6, null);
        if (i == -1) {
            return str3;
        }
        String substring = str.substring(i + str2.length(), str.length());
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String J0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return H0(str, c, str2);
    }

    public static /* synthetic */ String K0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return I0(str, str2, str3);
    }

    public static String L0(String str, char c, String str2) {
        k21.i(str, "<this>");
        k21.i(str2, "missingDelimiterValue");
        int k0 = k0(str, c, 0, false, 6, null);
        if (k0 == -1) {
            return str2;
        }
        String substring = str.substring(k0 + 1, str.length());
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final /* synthetic */ Pair M(CharSequence charSequence, Collection collection, int i, boolean z, boolean z2) {
        return X(charSequence, collection, i, z, z2);
    }

    public static /* synthetic */ String M0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return L0(str, c, str2);
    }

    public static final boolean N(CharSequence charSequence, char c, boolean z) {
        k21.i(charSequence, "<this>");
        return e0(charSequence, c, 0, z, 2, null) >= 0;
    }

    public static final String N0(String str, char c, String str2) {
        k21.i(str, "<this>");
        k21.i(str2, "missingDelimiterValue");
        int i = e0(str, c, 0, false, 6, null);
        if (i == -1) {
            return str2;
        }
        String substring = str.substring(0, i);
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean O(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        k21.i(charSequence, "<this>");
        k21.i(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (f0(charSequence, (String) charSequence2, 0, z, 2, null) >= 0) {
                return true;
            }
        } else if (d0(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static final String O0(String str, String str2, String str3) {
        k21.i(str, "<this>");
        k21.i(str2, "delimiter");
        k21.i(str3, "missingDelimiterValue");
        int i = f0(str, str2, 0, false, 6, null);
        if (i == -1) {
            return str3;
        }
        String substring = str.substring(0, i);
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean P(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return N(charSequence, c, z);
    }

    public static /* synthetic */ String P0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return N0(str, c, str2);
    }

    public static /* synthetic */ boolean Q(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return O(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String Q0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return O0(str, str2, str3);
    }

    public static final boolean R(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return o.w((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!c.d(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    public static String R0(String str, char c, String str2) {
        k21.i(str, "<this>");
        k21.i(str2, "missingDelimiterValue");
        int k0 = k0(str, c, 0, false, 6, null);
        if (k0 == -1) {
            return str2;
        }
        String substring = str.substring(0, k0);
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean S(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return k21.d(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String S0(String str, String str2, String str3) {
        k21.i(str, "<this>");
        k21.i(str2, "delimiter");
        k21.i(str3, "missingDelimiterValue");
        int i = l0(str, str2, 0, false, 6, null);
        if (i == -1) {
            return str3;
        }
        String substring = str.substring(0, i);
        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean T(CharSequence charSequence, char c, boolean z) {
        k21.i(charSequence, "<this>");
        return charSequence.length() > 0 && c.d(charSequence.charAt(Z(charSequence)), c, z);
    }

    public static CharSequence T0(CharSequence charSequence) {
        k21.i(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean c = b.c(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!c) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!c) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final boolean U(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        k21.i(charSequence, "<this>");
        k21.i(charSequence2, Constants.Name.SUFFIX);
        if (z || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return t0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
        }
        return o.v((String) charSequence, (String) charSequence2, false, 2, null);
    }

    public static /* synthetic */ boolean V(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return T(charSequence, c, z);
    }

    public static /* synthetic */ boolean W(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return U(charSequence, charSequence2, z);
    }

    private static final Pair<Integer, String> X(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        T t;
        T t2;
        if (z || collection.size() != 1) {
            u11 w11 = !z2 ? new w11(ww1.a(i, 0), charSequence.length()) : ww1.g(ww1.d(i, Z(charSequence)), 0);
            if (charSequence instanceof String) {
                int a2 = w11.a();
                int b = w11.b();
                int c = w11.c();
                if ((c > 0 && a2 <= b) || (c < 0 && b <= a2)) {
                    while (true) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t2 = null;
                                break;
                            }
                            t2 = it.next();
                            T t3 = t2;
                            if (o.z(t3, 0, (String) charSequence, a2, t3.length(), z)) {
                                break;
                            }
                        }
                        T t4 = t2;
                        if (t4 == null) {
                            if (a2 == b) {
                                break;
                            }
                            a2 += c;
                        } else {
                            return do2.a(Integer.valueOf(a2), t4);
                        }
                    }
                }
            } else {
                int a3 = w11.a();
                int b2 = w11.b();
                int c2 = w11.c();
                if ((c2 > 0 && a3 <= b2) || (c2 < 0 && b2 <= a3)) {
                    while (true) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it2.next();
                            T t5 = t;
                            if (t0(t5, 0, charSequence, a3, t5.length(), z)) {
                                break;
                            }
                        }
                        T t6 = t;
                        if (t6 == null) {
                            if (a3 == b2) {
                                break;
                            }
                            a3 += c2;
                        } else {
                            return do2.a(Integer.valueOf(a3), t6);
                        }
                    }
                }
            }
            return null;
        }
        String str = (String) k.n0(collection);
        int i2 = !z2 ? f0(charSequence, str, i, false, 4, null) : l0(charSequence, str, i, false, 4, null);
        if (i2 < 0) {
            return null;
        }
        return do2.a(Integer.valueOf(i2), str);
    }

    public static w11 Y(CharSequence charSequence) {
        k21.i(charSequence, "<this>");
        return new w11(0, charSequence.length() - 1);
    }

    public static int Z(CharSequence charSequence) {
        k21.i(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int a0(CharSequence charSequence, char c, int i, boolean z) {
        k21.i(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return g0(charSequence, new char[]{c}, i, z);
    }

    public static final int b0(CharSequence charSequence, String str, int i, boolean z) {
        k21.i(charSequence, "<this>");
        k21.i(str, "string");
        if (z || !(charSequence instanceof String)) {
            return d0(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    private static final int c0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        u11 u11;
        if (!z2) {
            u11 = new w11(ww1.a(i, 0), ww1.d(i2, charSequence.length()));
        } else {
            u11 = ww1.g(ww1.d(i, Z(charSequence)), ww1.a(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a2 = u11.a();
            int b = u11.b();
            int c = u11.c();
            if ((c <= 0 || a2 > b) && (c >= 0 || b > a2)) {
                return -1;
            }
            while (!t0(charSequence2, 0, charSequence, a2, charSequence2.length(), z)) {
                if (a2 == b) {
                    return -1;
                }
                a2 += c;
            }
            return a2;
        }
        int a3 = u11.a();
        int b2 = u11.b();
        int c2 = u11.c();
        if ((c2 <= 0 || a3 > b2) && (c2 >= 0 || b2 > a3)) {
            return -1;
        }
        while (!o.z((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z)) {
            if (a3 == b2) {
                return -1;
            }
            a3 += c2;
        }
        return a3;
    }

    static /* synthetic */ int d0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return c0(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int e0(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a0(charSequence, c, i, z);
    }

    public static /* synthetic */ int f0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b0(charSequence, str, i, z);
    }

    public static final int g0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        k21.i(charSequence, "<this>");
        k21.i(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            r11 d = new w11(ww1.a(i, 0), Z(charSequence)).iterator();
            while (d.hasNext()) {
                int nextInt = d.nextInt();
                char charAt = charSequence.charAt(nextInt);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        continue;
                        break;
                    } else if (c.d(cArr[i2], charAt, z)) {
                        z2 = true;
                        continue;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return nextInt;
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(ArraysKt___ArraysKt.K(cArr), i);
    }

    public static final ih h0(CharSequence charSequence) {
        k21.i(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final int i0(CharSequence charSequence, char c, int i, boolean z) {
        k21.i(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return m0(charSequence, new char[]{c}, i, z);
    }

    public static final int j0(CharSequence charSequence, String str, int i, boolean z) {
        k21.i(charSequence, "<this>");
        k21.i(str, "string");
        if (z || !(charSequence instanceof String)) {
            return c0(charSequence, str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int k0(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Z(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return i0(charSequence, c, i, z);
    }

    public static /* synthetic */ int l0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Z(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return j0(charSequence, str, i, z);
    }

    public static final int m0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        k21.i(charSequence, "<this>");
        k21.i(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int i2 = ww1.d(i, Z(charSequence)); -1 < i2; i2--) {
                char charAt = charSequence.charAt(i2);
                int length = cArr.length;
                boolean z2 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (c.d(cArr[i3], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z2) {
                    return i2;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.K(cArr), i);
    }

    public static final Sequence<String> n0(CharSequence charSequence) {
        k21.i(charSequence, "<this>");
        return B0(charSequence, new String[]{SocketClient.NETASCII_EOL, StringUtils.LF, StringUtils.CR}, false, 0, 6, null);
    }

    public static final List<String> o0(CharSequence charSequence) {
        k21.i(charSequence, "<this>");
        return SequencesKt___SequencesKt.B(n0(charSequence));
    }

    public static final CharSequence p0(CharSequence charSequence, int i, char c) {
        k21.i(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            r11 d = new w11(1, i - charSequence.length()).iterator();
            while (d.hasNext()) {
                d.nextInt();
                sb.append(c);
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static String q0(String str, int i, char c) {
        k21.i(str, "<this>");
        return p0(str, i, c).toString();
    }

    private static final Sequence<w11> r0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        w0(i2);
        return new d(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$2(h.d(strArr), z));
    }

    static /* synthetic */ Sequence s0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return r0(charSequence, strArr, i, z, i2);
    }

    public static final boolean t0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        k21.i(charSequence, "<this>");
        k21.i(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!c.d(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String u0(String str, CharSequence charSequence) {
        k21.i(str, "<this>");
        k21.i(charSequence, Constants.Name.PREFIX);
        if (!F0(str, charSequence, false, 2, null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        k21.h(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final CharSequence v0(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        k21.i(charSequence, "<this>");
        k21.i(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            k21.h(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            k21.h(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void w0(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
        }
    }

    public static final List<String> x0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        k21.i(charSequence, "<this>");
        k21.i(strArr, "delimiters");
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                return y0(charSequence, str, z, i);
            }
        }
        Iterable<w11> iterable = SequencesKt___SequencesKt.l(s0(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(n.q(iterable, 10));
        for (w11 w11 : iterable) {
            arrayList.add(G0(charSequence, w11));
        }
        return arrayList;
    }

    private static final List<String> y0(CharSequence charSequence, String str, boolean z, int i) {
        w0(i);
        int i2 = 0;
        int b0 = b0(charSequence, str, 0, z);
        if (b0 == -1 || i == 1) {
            return l.e(charSequence.toString());
        }
        boolean z2 = i > 0;
        int i3 = 10;
        if (z2) {
            i3 = ww1.d(i, 10);
        }
        ArrayList arrayList = new ArrayList(i3);
        do {
            arrayList.add(charSequence.subSequence(i2, b0).toString());
            i2 = str.length() + b0;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            b0 = b0(charSequence, str, i2, z);
        } while (b0 != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List z0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return x0(charSequence, strArr, z, i);
    }
}
