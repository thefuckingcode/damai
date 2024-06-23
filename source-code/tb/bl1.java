package tb;

import com.alibaba.android.onescheduler.utils.OneSchedulerException;

/* compiled from: Taobao */
public class bl1 {
    public static void a(String str) {
        throw new OneSchedulerException(str);
    }

    public static void b(String str) {
        if (zk1.a) {
            throw new OneSchedulerException(str);
        }
    }
}
