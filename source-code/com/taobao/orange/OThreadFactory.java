package com.taobao.orange;

import com.taobao.orange.util.OLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class OThreadFactory {
    private static final int POOL_WAIT_TIMES = 60;
    public static final int PRIORITY = 2;
    private static final String TAG = "OThreadPool";
    private static ScheduledThreadPoolExecutor corePoolExecutor = new TBThreadPoolExecutor(2, new InnerThreadFactory());
    private static ScheduledThreadPoolExecutor diskPoolExecutor = new TBThreadPoolExecutor(1, new DiskThreadFactory());
    private static AtomicInteger threadAtomic = new AtomicInteger();

    /* compiled from: Taobao */
    static class DiskThreadFactory extends InnerThreadFactory {
        @Override // com.taobao.orange.OThreadFactory.InnerThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Orange_Disk");
            thread.setPriority(5);
            return thread;
        }
    }

    /* compiled from: Taobao */
    static class InnerThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            int andIncrement = OThreadFactory.threadAtomic.getAndIncrement();
            Thread thread = new Thread(runnable, "Orange:" + andIncrement);
            thread.setPriority(5);
            return thread;
        }
    }

    /* compiled from: Taobao */
    static class TBThreadPoolExecutor extends ScheduledThreadPoolExecutor {
        TBThreadPoolExecutor(int i, ThreadFactory threadFactory) {
            super(i, threadFactory);
            setKeepAliveTime(60, TimeUnit.SECONDS);
            allowCoreThreadTimeOut(true);
        }
    }

    public static void execute(Runnable runnable) {
        execute(runnable, 0);
    }

    public static void executeDisk(Runnable runnable) {
        executeDisk(runnable, 0);
    }

    private static ScheduledThreadPoolExecutor getCoreExecutor() {
        return corePoolExecutor;
    }

    private static ScheduledThreadPoolExecutor getDiskPoolExecutor() {
        return diskPoolExecutor;
    }

    public static void execute(Runnable runnable, long j) {
        try {
            getCoreExecutor().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            OLog.e(TAG, "execute", th, new Object[0]);
        }
    }

    public static void executeDisk(Runnable runnable, long j) {
        try {
            getDiskPoolExecutor().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            OLog.e(TAG, "execute_config_disk", th, new Object[0]);
        }
    }
}
