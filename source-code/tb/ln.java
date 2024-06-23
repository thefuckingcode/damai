package tb;

import android.taobao.windvane.connect.HttpConnector;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.a;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.l;
import okhttp3.m;

/* compiled from: Taobao */
public final class ln {
    private static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    private ln(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.i = z3;
        this.h = z4;
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || a.M(str)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0128  */
    @Nullable
    static ln d(long j2, m mVar, String str) {
        long j3;
        String m2;
        String str2;
        ln lnVar;
        String str3;
        String str4;
        int lastIndexOf;
        int length = str.length();
        char c2 = d80.TokenSEM;
        int n = a.n(str, 0, length, d80.TokenSEM);
        char c3 = com.alipay.sdk.m.n.a.h;
        int n2 = a.n(str, 0, n, com.alipay.sdk.m.n.a.h);
        if (n2 == n) {
            return null;
        }
        String L = a.L(str, 0, n2);
        if (L.isEmpty() || a.x(L) != -1) {
            return null;
        }
        String L2 = a.L(str, n2 + 1, n);
        if (a.x(L2) != -1) {
            return null;
        }
        int i2 = n + 1;
        String str5 = null;
        String str6 = null;
        long j4 = -1;
        long j5 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i2 < length) {
            int n3 = a.n(str, i2, length, c2);
            int n4 = a.n(str, i2, n3, c3);
            String L3 = a.L(str, i2, n4);
            String L4 = n4 < n3 ? a.L(str, n4 + 1, n3) : "";
            if (L3.equalsIgnoreCase(HttpConnector.EXPIRES)) {
                try {
                    j5 = h(L4, 0, L4.length());
                } catch (IllegalArgumentException unused) {
                }
            } else if (L3.equalsIgnoreCase("max-age")) {
                j4 = i(L4);
            } else {
                if (L3.equalsIgnoreCase("domain")) {
                    str6 = g(L4);
                    z3 = false;
                } else if (L3.equalsIgnoreCase(com.alibaba.security.realidentity.jsbridge.a.V)) {
                    str5 = L4;
                } else if (L3.equalsIgnoreCase("secure")) {
                    z = true;
                } else if (L3.equalsIgnoreCase("httponly")) {
                    z2 = true;
                }
                i2 = n3 + 1;
                c2 = d80.TokenSEM;
                c3 = com.alipay.sdk.m.n.a.h;
            }
            z4 = true;
            i2 = n3 + 1;
            c2 = d80.TokenSEM;
            c3 = com.alipay.sdk.m.n.a.h;
        }
        long j6 = Long.MIN_VALUE;
        if (j4 != Long.MIN_VALUE) {
            if (j4 != -1) {
                j6 = j2 + (j4 <= 9223372036854775L ? j4 * 1000 : AbsPerformance.LONG_NIL);
                if (j6 < j2 || j6 > my0.MAX_DATE) {
                    j3 = 253402300799999L;
                }
            } else {
                j3 = j5;
            }
            m2 = mVar.m();
            if (str6 != null) {
                str2 = m2;
                lnVar = null;
            } else if (!b(m2, str6)) {
                return null;
            } else {
                lnVar = null;
                str2 = str6;
            }
            if (m2.length() == str2.length() && PublicSuffixDatabase.c().d(str2) == null) {
                return lnVar;
            }
            str3 = "/";
            if (str5 != null || !str5.startsWith(str3)) {
                String h2 = mVar.h();
                lastIndexOf = h2.lastIndexOf(47);
                if (lastIndexOf != 0) {
                    str3 = h2.substring(0, lastIndexOf);
                }
                str4 = str3;
            } else {
                str4 = str5;
            }
            return new ln(L, L2, j3, str2, str4, z, z2, z3, z4);
        }
        j3 = j6;
        m2 = mVar.m();
        if (str6 != null) {
        }
        if (m2.length() == str2.length()) {
        }
        str3 = "/";
        if (str5 != null) {
        }
        String h22 = mVar.h();
        lastIndexOf = h22.lastIndexOf(47);
        if (lastIndexOf != 0) {
        }
        str4 = str3;
        return new ln(L, L2, j3, str2, str4, z, z2, z3, z4);
    }

    @Nullable
    public static ln e(m mVar, String str) {
        return d(System.currentTimeMillis(), mVar, str);
    }

    public static List<ln> f(m mVar, l lVar) {
        List<String> k2 = lVar.k(HttpConnector.SET_COOKIE);
        int size = k2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ln e2 = e(mVar, k2.get(i2));
            if (e2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String g(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String d2 = a.d(str);
            if (d2 != null) {
                return d2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long h(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(m).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 != -1 || !matcher.usePattern(l).matches()) {
                if (i7 == -1) {
                    Pattern pattern = k;
                    if (matcher.usePattern(pattern).matches()) {
                        i7 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i4 == -1 && matcher.usePattern(j).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i6 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(a.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long i(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (!str.matches("-?\\d+")) {
                throw e2;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return AbsPerformance.LONG_NIL;
            }
        }
    }

    public String c() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ln)) {
            return false;
        }
        ln lnVar = (ln) obj;
        if (lnVar.a.equals(this.a) && lnVar.b.equals(this.b) && lnVar.d.equals(this.d) && lnVar.e.equals(this.e) && lnVar.c == this.c && lnVar.f == this.f && lnVar.g == this.g && lnVar.h == this.h && lnVar.i == this.i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.c;
        return ((((((((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f ? 1 : 0)) * 31) + (!this.g ? 1 : 0)) * 31) + (!this.h ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public String j(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(com.alipay.sdk.m.n.a.h);
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(my0.a(new Date(this.c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String k() {
        return this.b;
    }

    public String toString() {
        return j(false);
    }
}
