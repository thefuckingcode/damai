package tb;

import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class se2 {
    private static final ThreadLocal<se2> d = new ThreadLocal<>();
    private long a;
    private List<a> b = new ArrayList();
    private long c;

    /* compiled from: Taobao */
    public static class a {
    }

    public static double a(long j) {
        return ((double) j) / 1000000.0d;
    }

    private static void b() {
        ThreadLocal<se2> threadLocal = d;
        if (threadLocal.get() == null) {
            threadLocal.set(new se2());
        }
    }

    public static void c(String str) {
        if (sx2.b()) {
            try {
                a aVar = new a();
                ThreadLocal<se2> threadLocal = d;
                long j = threadLocal.get().c;
                e();
                threadLocal.get().b.add(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static double d() {
        if (!sx2.b()) {
            return -1.0d;
        }
        try {
            ThreadLocal<se2> threadLocal = d;
            long j = threadLocal.get().a;
            if (j == 0) {
                WXLogUtils.w("Stopwatch", "Should call Stopwatch.tick() before Stopwatch.tack() called");
            }
            threadLocal.get().a = 0;
            return a(System.nanoTime() - j);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1.0d;
        }
    }

    public static double e() {
        double d2 = d();
        f();
        return d2;
    }

    public static void f() {
        if (sx2.b()) {
            try {
                b();
                ThreadLocal<se2> threadLocal = d;
                if (threadLocal.get().a != 0) {
                    WXLogUtils.w("Stopwatch", "Stopwatch is not reset");
                }
                threadLocal.get().a = System.nanoTime();
                threadLocal.get().c = System.currentTimeMillis();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
