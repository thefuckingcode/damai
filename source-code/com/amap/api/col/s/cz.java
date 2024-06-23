package com.amap.api.col.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.df;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* compiled from: Taobao */
public class cz {
    public static int a = 0;
    public static String b = "";
    public static HashMap<String, String> c;
    public static HashMap<String, String> d;
    public static HashMap<String, String> e;
    private static cz f;

    /* compiled from: Taobao */
    public interface a {
        URLConnection a();
    }

    public cz() {
        bl.d();
    }

    public static cz a() {
        if (f == null) {
            f = new cz();
        }
        return f;
    }

    protected static df.b b(df dfVar, boolean z) {
        return dfVar.o() == df.a.FIX ? z ? df.b.FIX_DEGRADE_BYERROR : df.b.FIX_DEGRADE_ONLY : z ? df.b.DEGRADE_BYERROR : df.b.DEGRADE_ONLY;
    }

    protected static boolean c(df dfVar) throws bj {
        d(dfVar);
        try {
            if (!b(dfVar)) {
                return true;
            }
            if (!dfVar.h().equals(dfVar.a()) && dfVar.o() != df.a.SINGLE && bl.h) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    private static dg d(df dfVar, boolean z) throws bj {
        byte[] bArr;
        d(dfVar);
        dfVar.a(z ? df.c.HTTPS : df.c.HTTP);
        dg dgVar = null;
        long j = 0;
        boolean z2 = false;
        if (b(dfVar)) {
            boolean c2 = c(dfVar);
            try {
                j = SystemClock.elapsedRealtime();
                dgVar = a(dfVar, a(dfVar, c2), c(dfVar, c2));
            } catch (bj e2) {
                if (e2.f() == 21 && dfVar.o() == df.a.INTERRUPT_IO) {
                    throw e2;
                } else if (c2) {
                    z2 = true;
                } else {
                    throw e2;
                }
            }
        }
        if (dgVar != null && (bArr = dgVar.a) != null && bArr.length > 0) {
            return dgVar;
        }
        try {
            return a(dfVar, b(dfVar, z2), a(dfVar, j));
        } catch (bj e3) {
            throw e3;
        }
    }

    public static dg a(df dfVar) throws bj {
        return d(dfVar, dfVar.r());
    }

    protected static boolean b(df dfVar) throws bj {
        d(dfVar);
        try {
            String a2 = dfVar.a();
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String host = new URL(a2).getHost();
            if (!TextUtils.isEmpty(dfVar.i())) {
                host = dfVar.i();
            }
            return bl.d(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    private static dg a(df dfVar, df.b bVar, int i) throws bj {
        try {
            d(dfVar);
            dfVar.a(bVar);
            dfVar.c(i);
            return new dc().b(dfVar);
        } catch (bj e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bj(AMapException.ERROR_UNKNOWN);
        }
    }

    protected static int c(df dfVar, boolean z) {
        try {
            d(dfVar);
            int m = dfVar.m();
            int i = bl.e;
            return (dfVar.o() == df.a.FIX || dfVar.o() == df.a.SINGLE || m < i || !z) ? m : i;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    protected static df.b a(df dfVar, boolean z) {
        if (dfVar.o() == df.a.FIX) {
            return df.b.FIX_NONDEGRADE;
        }
        if (dfVar.o() == df.a.SINGLE) {
            return df.b.NEVER_GRADE;
        }
        return z ? df.b.FIRST_NONDEGRADE : df.b.NEVER_GRADE;
    }

    protected static void d(df dfVar) throws bj {
        if (dfVar == null) {
            throw new bj("requeust is null");
        } else if (dfVar.h() == null || "".equals(dfVar.h())) {
            throw new bj("request url is empty");
        }
    }

    protected static int a(df dfVar, long j) {
        try {
            d(dfVar);
            long j2 = 0;
            if (j != 0) {
                j2 = SystemClock.elapsedRealtime() - j;
            }
            int m = dfVar.m();
            if (dfVar.o() != df.a.FIX) {
                if (dfVar.o() != df.a.SINGLE) {
                    long j3 = (long) m;
                    if (j2 < j3) {
                        long j4 = j3 - j2;
                        if (j4 >= 1000) {
                            return (int) j4;
                        }
                    }
                    return Math.min(1000, dfVar.m());
                }
            }
            return m;
        } catch (Throwable unused) {
            return 5000;
        }
    }
}
