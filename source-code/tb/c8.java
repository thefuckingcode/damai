package tb;

/* compiled from: Taobao */
public class c8 {
    public static void a(Object obj) {
        b(null, obj);
    }

    public static void b(String str, Object obj) {
        c(str, obj != null);
    }

    public static void c(String str, boolean z) {
        if (!z) {
            d(str);
        }
    }

    public static void d(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }
}
