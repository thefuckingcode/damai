package tb;

import com.taobao.monitor.logger.IDataLogger;

/* compiled from: Taobao */
public class i20 {
    private static IDataLogger a;

    public static void a(String str, Object... objArr) {
        IDataLogger iDataLogger = a;
        if (iDataLogger != null) {
            iDataLogger.log(str, objArr);
        }
    }

    public static void b(IDataLogger iDataLogger) {
        a = iDataLogger;
    }
}
