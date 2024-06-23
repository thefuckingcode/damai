package tb;

import com.alibaba.analytics.core.selfmonitor.CrashListener;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
public class wo implements Thread.UncaughtExceptionHandler {
    private static wo c = new wo();
    private Thread.UncaughtExceptionHandler a;
    private List<CrashListener> b = Collections.synchronizedList(new ArrayList());

    public static wo b() {
        return c;
    }

    public void a(CrashListener crashListener) {
        this.b.add(crashListener);
    }

    public void c() {
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        for (int i = 0; i < this.b.size(); i++) {
            try {
                this.b.get(i).onCrash(thread, th);
            } catch (Throwable unused) {
                uncaughtExceptionHandler = this.a;
                if (uncaughtExceptionHandler == null) {
                    return;
                }
            }
        }
        uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
