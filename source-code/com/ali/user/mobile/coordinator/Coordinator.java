package com.ali.user.mobile.coordinator;

import android.os.Looper;
import android.os.Process;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class Coordinator {
    private static final int CORE_POOL_SIZE = 4;
    private static final int KEEP_ALIVE = 4;
    private static final int MAXIMUM_POOL_SIZE = 32;
    public static final int QUEUE_PRIORITY_NORMAL = 30;
    protected static final String TAG = "Coordinator";
    protected static final BlockingQueue<Runnable> mPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    public static CoordThreadPoolExecutor sThreadPoolExecutor;
    public static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    /* compiled from: Taobao */
    public static class CoordThreadPoolExecutor extends ThreadPoolExecutor {
        public CoordThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
            allowCoreThreadTimeOut(true);
        }

        /* access modifiers changed from: protected */
        public void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            if (runnable instanceof StandaloneTask) {
                thread.setName("login-" + ((StandaloneTask) runnable).mRunnable + "");
                return;
            }
            thread.setName("login-" + runnable + "");
        }

        public void execute(Runnable runnable, int i) {
            if (runnable instanceof StandaloneTask) {
                super.execute(runnable);
                return;
            }
            StandaloneTask standaloneTask = new StandaloneTask(runnable);
            if (i < 1) {
                i = 1;
            }
            standaloneTask.mPriorityQueue = i;
            super.execute(standaloneTask);
        }
    }

    /* compiled from: Taobao */
    static class PriorityComparator<Runnable> implements Comparator<Runnable> {
        PriorityComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Runnable runnable, Runnable runnable2) {
            if (!(runnable instanceof StandaloneTask) || !(runnable2 instanceof StandaloneTask)) {
                return 0;
            }
            Runnable runnable3 = runnable;
            Runnable runnable4 = runnable2;
            if (runnable3.getQueuePriority() > runnable4.getQueuePriority()) {
                return 1;
            }
            return runnable3.getQueuePriority() < runnable4.getQueuePriority() ? -1 : 0;
        }
    }

    /* compiled from: Taobao */
    public interface PriorityQueue {
        int getQueuePriority();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class StandaloneTask implements PriorityQueue, Runnable {
        int mPriorityQueue = 30;
        final Runnable mRunnable;

        public StandaloneTask(Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // com.ali.user.mobile.coordinator.Coordinator.PriorityQueue
        public int getQueuePriority() {
            Runnable runnable = this.mRunnable;
            if (runnable instanceof PriorityQueue) {
                return ((PriorityQueue) runnable).getQueuePriority();
            }
            return this.mPriorityQueue;
        }

        public void run() {
            Coordinator.runWithTiming(this.mRunnable);
        }
    }

    static {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(100, new PriorityComparator());
        mPoolWorkQueue = priorityBlockingQueue;
        AnonymousClass1 r7 = new ThreadFactory() {
            /* class com.ali.user.mobile.coordinator.Coordinator.AnonymousClass1 */

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "login#" + runnable.getClass().getName());
            }
        };
        sThreadFactory = r7;
        sThreadPoolExecutor = new CoordThreadPoolExecutor(4, 32, 4, TimeUnit.SECONDS, priorityBlockingQueue, r7, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static void execute(Runnable runnable) {
        sThreadPoolExecutor.execute(runnable, 30);
    }

    protected static void runWithTiming(Runnable runnable) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Process.setThreadPriority(10);
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        scheduledExecutorService.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    public static void execute(Runnable runnable, int i) {
        sThreadPoolExecutor.execute(runnable, i);
    }
}
