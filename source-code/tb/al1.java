package tb;

import com.alibaba.android.onescheduler.ILogger;

/* compiled from: Taobao */
public class al1 {
    private static ILogger a = new b50();

    public static void a(String str, Object... objArr) {
        a.e("OneScheduler", String.format(str, objArr));
    }
}
