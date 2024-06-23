package tb;

import anet.channel.request.a;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import mtopsdk.network.util.Constants;
import okhttp3.CookieJar;
import okhttp3.l;
import okhttp3.m;
import okhttp3.o;
import okhttp3.q;
import okio.ByteString;

/* compiled from: Taobao */
public final class qy0 {
    static {
        ByteString.encodeUtf8("\"\\");
        ByteString.encodeUtf8("\t ,=");
    }

    public static long a(l lVar) {
        return j(lVar.c(Constants.Protocol.CONTENT_LENGTH));
    }

    public static long b(q qVar) {
        return a(qVar.j());
    }

    public static boolean c(q qVar) {
        if (qVar.q().g().equals(a.c.HEAD)) {
            return false;
        }
        int e = qVar.e();
        if (((e >= 100 && e < 200) || e == 204 || e == 304) && b(qVar) == -1 && !"chunked".equalsIgnoreCase(qVar.g("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static boolean d(l lVar) {
        return k(lVar).contains(jl1.MUL);
    }

    public static boolean e(q qVar) {
        return d(qVar.j());
    }

    public static int f(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static void g(CookieJar cookieJar, m mVar, l lVar) {
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<ln> f = ln.f(mVar, lVar);
            if (!f.isEmpty()) {
                cookieJar.saveFromResponse(mVar, f);
            }
        }
    }

    public static int h(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int i(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == '\t')) {
            i++;
        }
        return i;
    }

    private static long j(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static Set<String> k(l lVar) {
        Set<String> emptySet = Collections.emptySet();
        int h = lVar.h();
        for (int i = 0; i < h; i++) {
            if ("Vary".equalsIgnoreCase(lVar.e(i))) {
                String j = lVar.j(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : j.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    private static Set<String> l(q qVar) {
        return k(qVar.j());
    }

    public static l m(l lVar, l lVar2) {
        Set<String> k = k(lVar2);
        if (k.isEmpty()) {
            return okhttp3.internal.a.EMPTY_HEADERS;
        }
        l.a aVar = new l.a();
        int h = lVar.h();
        for (int i = 0; i < h; i++) {
            String e = lVar.e(i);
            if (k.contains(e)) {
                aVar.a(e, lVar.j(i));
            }
        }
        return aVar.e();
    }

    public static l n(q qVar) {
        return m(qVar.l().q().e(), qVar.j());
    }

    public static boolean o(q qVar, l lVar, o oVar) {
        for (String str : l(qVar)) {
            if (!Objects.equals(lVar.k(str), oVar.d(str))) {
                return false;
            }
        }
        return true;
    }
}
