package tb;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Taobao */
public class mn0 {
    private final Handler a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        static final mn0 a = new mn0();
    }

    public static mn0 a() {
        return b.a;
    }

    public Handler b() {
        return this.a;
    }

    private mn0() {
        HandlerThread handlerThread = new HandlerThread("APM-FulltraceDump");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper());
    }
}
