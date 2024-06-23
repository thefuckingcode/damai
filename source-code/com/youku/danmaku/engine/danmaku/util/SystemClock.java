package com.youku.danmaku.engine.danmaku.util;

/* compiled from: Taobao */
public class SystemClock {
    public static final void sleep(long j) {
        android.os.SystemClock.sleep(j);
    }

    public static final long uptimeMillis() {
        return android.os.SystemClock.elapsedRealtime();
    }
}
