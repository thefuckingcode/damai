package tb;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
public final class cm2 {
    private static final AtomicLong a = new AtomicLong();

    public static String a() {
        return System.currentTimeMillis() + "." + a.incrementAndGet();
    }
}
