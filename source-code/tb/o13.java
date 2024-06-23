package tb;

import android.os.HandlerThread;

/* compiled from: Taobao */
public final class o13 {
    public static HandlerThread a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        a = handlerThread;
        handlerThread.start();
    }
}
