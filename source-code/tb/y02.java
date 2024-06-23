package tb;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class y02 {
    private static ConcurrentHashMap<Integer, d12> a = new ConcurrentHashMap<>();
    private static volatile y02 b;

    public static y02 d() {
        if (b == null) {
            synchronized (y02.class) {
                if (b == null) {
                    b = new y02();
                }
            }
        }
        return b;
    }

    public void a(Context context) {
        a.remove(Integer.valueOf(context.hashCode()));
    }

    public int b(Context context) {
        int hashCode = context.hashCode();
        d12 d12 = a.get(Integer.valueOf(hashCode));
        if (d12 == null) {
            d12 = new d12();
            a.put(Integer.valueOf(hashCode), d12);
        }
        return d12.a();
    }

    public int c(Context context) {
        int hashCode = context.hashCode();
        d12 d12 = a.get(Integer.valueOf(hashCode));
        if (d12 == null) {
            d12 = new d12();
            a.put(Integer.valueOf(hashCode), d12);
        }
        return d12.b();
    }

    public int e(Context context) {
        if (context == null) {
            return 1000;
        }
        int hashCode = context.hashCode();
        d12 d12 = a.get(Integer.valueOf(hashCode));
        if (d12 == null) {
            d12 = new d12();
            a.put(Integer.valueOf(hashCode), d12);
        }
        return d12.c();
    }

    public void f(Context context, int i) {
        int hashCode = context.hashCode();
        d12 d12 = a.get(Integer.valueOf(hashCode));
        if (d12 == null) {
            d12 = new d12();
            a.put(Integer.valueOf(hashCode), d12);
        }
        d12.d(i);
    }

    public void g(Context context, int i) {
        int hashCode = context.hashCode();
        d12 d12 = a.get(Integer.valueOf(hashCode));
        if (d12 == null) {
            d12 = new d12();
            a.put(Integer.valueOf(hashCode), d12);
        }
        d12.e(i);
    }

    public void h(Context context, int i) {
        int hashCode = context.hashCode();
        d12 d12 = a.get(Integer.valueOf(hashCode));
        if (d12 == null) {
            d12 = new d12();
            a.put(Integer.valueOf(hashCode), d12);
        }
        d12.f(i);
    }

    public void i(Context context, int i) {
        if (context != null) {
            int hashCode = context.hashCode();
            d12 d12 = a.get(Integer.valueOf(hashCode));
            if (d12 == null) {
                d12 = new d12();
                a.put(Integer.valueOf(hashCode), d12);
            }
            d12.g(i);
        }
    }
}
