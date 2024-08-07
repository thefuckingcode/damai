package ntk.extern;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
/* compiled from: Taobao */
public class PcdnUtil {
    static Context appContext;
    static volatile boolean inited;

    static native void dumpTcpInfoFromPcdn();

    public static synchronized void init(@NonNull Context context) {
        synchronized (PcdnUtil.class) {
            if (!inited) {
                inited = true;
                context.getApplicationContext();
            }
        }
    }

    static native void initNativeModule();

    static native void onAvailable();

    static native void onUnavailable();
}
