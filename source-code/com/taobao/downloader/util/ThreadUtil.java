package com.taobao.downloader.util;

import android.annotation.TargetApi;
import android.os.Process;
import com.taobao.downloader.adpater.ThreadExecutor;
import tb.cm;

/* compiled from: Taobao */
public class ThreadUtil {
    @TargetApi(3)
    public static void a(final Runnable runnable, boolean z) {
        ThreadExecutor threadExecutor = cm.d;
        if (threadExecutor != null) {
            threadExecutor.execute(runnable, z);
        } else {
            new Thread(new Runnable() {
                /* class com.taobao.downloader.util.ThreadUtil.AnonymousClass1 */

                public void run() {
                    Process.setThreadPriority(10);
                    runnable.run();
                }
            }).start();
        }
    }
}
