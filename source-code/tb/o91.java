package tb;

import com.airbnb.lottie.LottieLogger;

/* compiled from: Taobao */
public class o91 {
    private static LottieLogger a = new m91();

    public static void a(String str) {
        a.debug(str);
    }

    public static void b(String str, Throwable th) {
        a.error(str, th);
    }

    public static void c(String str) {
        a.warning(str);
    }

    public static void d(String str, Throwable th) {
        a.warning(str, th);
    }
}
