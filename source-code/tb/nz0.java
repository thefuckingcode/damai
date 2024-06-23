package tb;

/* compiled from: Taobao */
public class nz0 {
    private static int a;

    public static synchronized int a() {
        int i;
        synchronized (nz0.class) {
            if (a >= Integer.MAX_VALUE) {
                a = 0;
            }
            i = a;
            a = i + 1;
        }
        return i;
    }
}
