package tb;

import android.os.Process;

/* compiled from: Taobao */
public final /* synthetic */ class em0 implements Runnable {
    public static final /* synthetic */ em0 a = new em0();

    private /* synthetic */ em0() {
    }

    public final void run() {
        Process.setThreadPriority(-10);
    }
}
