package tb;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class gn2 {
    private static final AtomicInteger a = new AtomicInteger(0);

    public static int a() {
        return a.getAndIncrement();
    }
}
