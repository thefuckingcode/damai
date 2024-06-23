package com.taobao.android.job.core.helper;

/* compiled from: Taobao */
public final class ThreadPoolHelpers {
    private ThreadPoolHelpers() {
    }

    public static int ioIntensivePoolSize() {
        return poolSize(0.9d);
    }

    public static int poolSize(double d) {
        return (int) (((double) Runtime.getRuntime().availableProcessors()) / (1.0d - d));
    }
}
