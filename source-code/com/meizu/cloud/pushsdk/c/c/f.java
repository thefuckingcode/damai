package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.g.b;
import com.youku.upsplayer.util.YKUpsConvert;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tb.jl1;
import tb.ke1;
import tb.u91;
import tb.v00;

/* compiled from: Taobao */
public class f {
    private static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F};
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    /* access modifiers changed from: package-private */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.f$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[a.EnumC0186a.values().length];
            a = iArr;
            iArr[a.EnumC0186a.SUCCESS.ordinal()] = 1;
            a[a.EnumC0186a.INVALID_HOST.ordinal()] = 2;
            a[a.EnumC0186a.UNSUPPORTED_SCHEME.ordinal()] = 3;
            a[a.EnumC0186a.MISSING_SCHEME.ordinal()] = 4;
            a[a.EnumC0186a.INVALID_PORT.ordinal()] = 5;
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        String a;
        String b = "";
        String c = "";
        String d;
        int e = -1;
        final List<String> f;
        List<String> g;
        String h;

        /* access modifiers changed from: package-private */
        /* renamed from: com.meizu.cloud.pushsdk.c.c.f$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public enum EnumC0186a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private static String a(byte[] bArr) {
            int i = 0;
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                int i5 = i3;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i3;
                if (i6 > i4) {
                    i2 = i3;
                    i4 = i6;
                }
                i3 = i5 + 2;
            }
            b bVar = new b();
            while (i < bArr.length) {
                if (i == i2) {
                    bVar.b(58);
                    i += i4;
                    if (i == 16) {
                        bVar.b(58);
                    }
                } else {
                    if (i > 0) {
                        bVar.b(58);
                    }
                    bVar.d((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return bVar.h();
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = com.meizu.cloud.pushsdk.c.c.m.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.f.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String b2 = f.b(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (!b(b2)) {
                if (c(b2)) {
                    c();
                    return;
                }
                List<String> list = this.f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f;
                    list2.set(list2.size() - 1, b2);
                } else {
                    this.f.add(b2);
                }
                if (z) {
                    this.f.add("");
                }
            }
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            boolean z = false;
            boolean z2 = charAt < 'a' || charAt > 'z';
            if (charAt < 'A' || charAt > 'Z') {
                z = true;
            }
            if (z2 && z) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && ((charAt2 < '0' || charAt2 > '9') && charAt2 != '+' && charAt2 != '-' && charAt2 != '.'))) {
                    if (charAt2 == ':') {
                        return i3;
                    } else {
                        return -1;
                    }
                }
            }
            return -1;
        }

        private boolean b(String str) {
            return ".".equals(str) || "%2e".equalsIgnoreCase(str);
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private void c() {
            List<String> list = this.f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
                return;
            }
            List<String> list2 = this.f;
            list2.set(list2.size() - 1, "");
        }

        private boolean c(String str) {
            return "..".equals(str) || "%2e.".equalsIgnoreCase(str) || ".%2e".equalsIgnoreCase(str) || "%2e%2e".equalsIgnoreCase(str);
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            String b2 = f.b(str, i, i2, false);
            if (!b2.contains(":")) {
                return m.a(b2);
            }
            InetAddress f2 = (!b2.startsWith(jl1.ARRAY_START_STR) || !b2.endsWith(jl1.ARRAY_END_STR)) ? f(b2, 0, b2.length()) : f(b2, 1, b2.length() - 1);
            if (f2 == null) {
                return null;
            }
            byte[] address = f2.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError();
        }

        private static InetAddress f(String str, int i, int i2) {
            byte[] bArr = new byte[16];
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (true) {
                if (i >= i2) {
                    break;
                } else if (i3 == 16) {
                    return null;
                } else {
                    int i6 = i + 2;
                    if (i6 > i2 || !str.regionMatches(i, "::", 0, 2)) {
                        if (i3 != 0) {
                            if (str.regionMatches(i, ":", 0, 1)) {
                                i++;
                            } else if (!str.regionMatches(i, ".", 0, 1) || !a(str, i5, i2, bArr, i3 - 2)) {
                                return null;
                            } else {
                                i3 += 2;
                            }
                        }
                        i5 = i;
                    } else if (i4 != -1) {
                        return null;
                    } else {
                        i3 += 2;
                        i4 = i3;
                        if (i6 == i2) {
                            break;
                        }
                        i5 = i6;
                    }
                    i = i5;
                    int i7 = 0;
                    while (i < i2) {
                        int b2 = f.b(str.charAt(i));
                        if (b2 == -1) {
                            break;
                        }
                        i7 = (i7 << 4) + b2;
                        i++;
                    }
                    int i8 = i - i5;
                    if (i8 == 0 || i8 > 4) {
                        return null;
                    }
                    int i9 = i3 + 1;
                    bArr[i3] = (byte) ((i7 >>> 8) & 255);
                    i3 = i9 + 1;
                    bArr[i9] = (byte) (i7 & 255);
                }
            }
            if (i3 != 16) {
                if (i4 == -1) {
                    return null;
                }
                int i10 = i3 - i4;
                System.arraycopy(bArr, i4, bArr, 16 - i10, i10);
                Arrays.fill(bArr, i4, (16 - i3) + i4, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        private static int g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(f.b(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public int a() {
            int i = this.e;
            return i != -1 ? i : f.a(this.a);
        }

        /* access modifiers changed from: package-private */
        public EnumC0186a a(f fVar, String str) {
            int a2;
            int i;
            int a3 = m.a(str, 0, str.length());
            int b2 = m.b(str, a3, str.length());
            if (b(str, a3, b2) != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.a = "https";
                    a3 += 6;
                } else if (!str.regionMatches(true, a3, "http:", 0, 5)) {
                    return EnumC0186a.UNSUPPORTED_SCHEME;
                } else {
                    this.a = "http";
                    a3 += 5;
                }
            } else if (fVar == null) {
                return EnumC0186a.MISSING_SCHEME;
            } else {
                this.a = fVar.b;
            }
            int c2 = c(str, a3, b2);
            char c3 = jl1.CONDITION_IF;
            char c4 = '#';
            if (c2 >= 2 || fVar == null || !fVar.b.equals(this.a)) {
                int i2 = a3 + c2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = m.a(str, i2, b2, "@/\\?#");
                    char charAt = a2 != b2 ? str.charAt(a2) : 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        int d2 = d(str, i2, a2);
                        int i3 = d2 + 1;
                        this.d = e(str, i2, d2);
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int a4 = m.a(str, i2, a2, (char) jl1.CONDITION_IF_MIDDLE);
                                i = a2;
                                String b3 = f.b(str, i2, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z2) {
                                    b3 = this.b + "%40" + b3;
                                }
                                this.b = b3;
                                if (a4 != i) {
                                    this.c = f.b(str, a4 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i = a2;
                                this.c += "%40" + f.b(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            i2 = i + 1;
                        }
                        c3 = jl1.CONDITION_IF;
                        c4 = '#';
                    }
                }
                int d22 = d(str, i2, a2);
                int i32 = d22 + 1;
                this.d = e(str, i2, d22);
                if (i32 < a2) {
                    int g2 = g(str, i32, a2);
                    this.e = g2;
                    if (g2 == -1) {
                        return EnumC0186a.INVALID_PORT;
                    }
                } else {
                    this.e = f.a(this.a);
                }
                if (this.d == null) {
                    return EnumC0186a.INVALID_HOST;
                }
                a3 = a2;
            } else {
                this.b = fVar.a();
                this.c = fVar.b();
                this.d = fVar.e;
                this.e = fVar.f;
                this.f.clear();
                this.f.addAll(fVar.c());
                if (a3 == b2 || str.charAt(a3) == '#') {
                    a(fVar.d());
                }
            }
            int a5 = m.a(str, a3, b2, "?#");
            a(str, a3, a5);
            if (a5 < b2 && str.charAt(a5) == '?') {
                int a6 = m.a(str, a5, b2, '#');
                this.g = f.b(f.b(str, a5 + 1, a6, " \"'<>#", true, false, true, true));
                a5 = a6;
            }
            if (a5 < b2 && str.charAt(a5) == '#') {
                this.h = f.b(str, 1 + a5, b2, "", true, false, false, false);
            }
            return EnumC0186a.SUCCESS;
        }

        public a a(String str) {
            this.g = str != null ? f.b(f.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(f.a(str, " \"'<>#&=", false, false, true, true));
                this.g.add(str2 != null ? f.a(str2, " \"'<>#&=", false, false, true, true) : null);
                return this;
            }
            throw new IllegalArgumentException("name == null");
        }

        public f b() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.d != null) {
                return new f(this, null);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(ke1.SCHEME_SLASH);
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(jl1.CONDITION_IF_MIDDLE);
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append(jl1.ARRAY_START);
                sb.append(this.d);
                sb.append(jl1.ARRAY_END);
            } else {
                sb.append(this.d);
            }
            int a2 = a();
            if (a2 != f.a(this.a)) {
                sb.append(jl1.CONDITION_IF_MIDDLE);
                sb.append(a2);
            }
            f.a(sb, this.f);
            if (this.g != null) {
                sb.append(jl1.CONDITION_IF);
                f.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    private f(a aVar) {
        this.b = aVar.a;
        this.c = a(aVar.b, false);
        this.d = a(aVar.c, false);
        this.e = aVar.d;
        this.f = aVar.a();
        this.g = a(aVar.f, false);
        List<String> list = aVar.g;
        String str = null;
        this.h = list != null ? a(list, true) : null;
        String str2 = aVar.h;
        this.i = str2 != null ? a(str2, false) : str;
        this.j = aVar.toString();
    }

    /* synthetic */ f(a aVar, AnonymousClass1 r2) {
        this(aVar);
    }

    public static int a(String str) {
        if ("http".equals(str)) {
            return 80;
        }
        return "https".equals(str) ? 443 : -1;
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return b(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    static String a(String str, boolean z) {
        return b(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void a(b bVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        b bVar2 = null;
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt == 43 && z3) {
                bVar.b(z ? jl1.PLUS : "%2B");
            } else if (a(codePointAt, i4, str, i3, str2, z, z2, z3, z4)) {
                if (bVar2 == null) {
                    bVar2 = new b();
                }
                bVar2.a(codePointAt);
                while (!bVar2.c()) {
                    int f2 = bVar2.f() & 255;
                    bVar.b(37);
                    char[] cArr = a;
                    bVar.b((int) cArr[(f2 >> 4) & 15]);
                    bVar.b((int) cArr[f2 & 15]);
                }
            } else {
                bVar.a(codePointAt);
            }
            i4 += Character.charCount(codePointAt);
        }
    }

    private static void a(b bVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int b2 = b(str.charAt(i2 + 1));
                int b3 = b(str.charAt(i4));
                if (!(b2 == -1 || b3 == -1)) {
                    bVar.b((b2 << 4) + b3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                bVar.b(32);
                i2 += Character.charCount(codePointAt);
            }
            bVar.a(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(v00.DIR);
            sb.append(list.get(i2));
        }
    }

    private static boolean a(int i2, int i3, String str, int i4, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        if (i2 < 32 || i2 == 127) {
            return true;
        }
        if ((i2 >= 128 && z4) || str2.indexOf(i2) != -1) {
            return true;
        }
        boolean z5 = !z || (z2 && !a(str, i3, i4));
        if (i2 != 37 || !z5) {
            return i2 == 43 && z3;
        }
        return true;
    }

    private static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && b(str.charAt(i2 + 1)) != -1 && b(str.charAt(i4)) != -1;
    }

    /* access modifiers changed from: private */
    public static int b(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - YKUpsConvert.CHAR_ZERO;
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = YKUpsConvert.CHAR_A;
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    /* access modifiers changed from: private */
    public static String b(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (a(codePointAt, i4, str, i3, str2, z, z2, z3, z4)) {
                b bVar = new b();
                bVar.a(str, i2, i4);
                a(bVar, str, i4, i3, str2, z, z2, z3, z4);
                return bVar.h();
            }
            i4 += Character.charCount(codePointAt);
        }
        return str.substring(i2, i3);
    }

    /* access modifiers changed from: private */
    public static String b(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            boolean z2 = false;
            boolean z3 = charAt == '%';
            if (charAt == '+' && z) {
                z2 = true;
            }
            if (z3 || z2) {
                b bVar = new b();
                bVar.a(str, i2, i4);
                a(bVar, str, i4, i3, z);
                return bVar.h();
            }
        }
        return str.substring(i2, i3);
    }

    static List<String> b(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(str2);
            }
        }
    }

    public static f c(String str) {
        a aVar = new a();
        if (aVar.a((f) null, str) == a.EnumC0186a.SUCCESS) {
            return aVar.b();
        }
        return null;
    }

    public String a() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.b.length() + 3;
        String str = this.j;
        return this.j.substring(length, m.a(str, length, str.length(), ":@"));
    }

    public String b() {
        if (this.d.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.b.length() + 3) + 1, indexOf);
    }

    public List<String> c() {
        int indexOf = this.j.indexOf(47, this.b.length() + 3);
        String str = this.j;
        int a2 = m.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = m.a(this.j, i2, a2, (char) v00.DIR);
            arrayList.add(this.j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String d() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, m.a(str, indexOf + 1, str.length(), '#'));
    }

    public String e() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).j.equals(this.j);
    }

    public a f() {
        a aVar = new a();
        aVar.a = this.b;
        aVar.b = a();
        aVar.c = b();
        aVar.d = this.e;
        aVar.e = this.f != a(this.b) ? this.f : -1;
        aVar.f.clear();
        aVar.f.addAll(c());
        aVar.a(d());
        aVar.h = e();
        return aVar;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }
}
