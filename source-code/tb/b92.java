package tb;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class b92 {
    private static AtomicInteger a = new AtomicInteger();

    public static String a(String str) {
        if (a.get() == Integer.MAX_VALUE) {
            a.set(0);
        }
        if (!TextUtils.isEmpty(str)) {
            return ag2.e(str, ".AWCN", String.valueOf(a.incrementAndGet()));
        }
        return ag2.d("AWCN", String.valueOf(a.incrementAndGet()));
    }
}
