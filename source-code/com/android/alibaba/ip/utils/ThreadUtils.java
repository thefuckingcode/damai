package com.android.alibaba.ip.utils;

/* compiled from: Taobao */
public class ThreadUtils {
    public static void asyncExcute(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() {
            /* class com.android.alibaba.ip.utils.ThreadUtils.AnonymousClass1 */

            public void run() {
                runnable.run();
            }
        });
        thread.setName("thread-instantpatch");
        thread.setPriority(10);
        thread.start();
    }

    public static void syncExcute(Runnable runnable) {
        runnable.run();
    }
}
