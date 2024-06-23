package com.taobao.android.task;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.taobao.windvane.cache.WVFileInfo;
import android.util.Log;
import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import tb.jl1;

/* compiled from: Taobao */
public class Coordinator {
    public static final int QUEUE_PRIORITY_DECODE_IMAGE = 27;
    public static final int QUEUE_PRIORITY_EMERGENCY = 10;
    public static final int QUEUE_PRIORITY_IMPORTANT = 20;
    public static final int QUEUE_PRIORITY_LOWER = 50;
    public static final int QUEUE_PRIORITY_NORMAL = 30;
    public static final int QUEUE_PRIORITY_NORMAL_DOWNLOAD = 35;
    public static final int QUEUE_PRIORITY_ON_IDLE = 100;
    public static final int QUEUE_PRIORITY_PATCH_DOWNLOAD = 21;
    public static final int QUEUE_PRIORITY_REQUEST_DATA = 23;
    public static final int QUEUE_PRIORITY_REQUEST_IMAGE = 28;
    public static final int QUEUE_PRIORITY_UNIMPORTANT = 90;
    protected static final String TAG = "Coord";
    protected static final Queue<TaggedRunnable> mIdleTasks = new LinkedList();
    protected static final BlockingQueue<Runnable> mPoolWorkQueue;
    protected static Handler sHandler;
    static ThreadInfoListener sThreadInfoListener;
    static CoordThreadPoolExecutor sThreadPoolExecutor;

    /* compiled from: Taobao */
    public static class CoordThreadPoolExecutor extends ThreadPoolExecutor {
        public CoordThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        }

        /* access modifiers changed from: protected */
        @TargetApi(11)
        public void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (runnable instanceof StandaloneTask) {
                Runnable runnable2 = ((StandaloneTask) runnable).mRunnable;
                if (runnable2 instanceof TaggedRunnable) {
                    TaggedRunnable taggedRunnable = (TaggedRunnable) runnable2;
                    if (Build.VERSION.SDK_INT >= 14) {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            if (runnable instanceof StandaloneTask) {
                StandaloneTask standaloneTask = (StandaloneTask) runnable;
                Runnable runnable2 = standaloneTask.mRunnable;
                if (runnable2 instanceof TaggedRunnable) {
                    TaggedRunnable taggedRunnable = (TaggedRunnable) runnable2;
                    thread.setName(taggedRunnable.toString());
                    if (Build.VERSION.SDK_INT >= 14) {
                        TrafficStats.setThreadStatsTag(taggedRunnable.mTraffictag);
                        return;
                    }
                    return;
                }
                thread.setName(standaloneTask.mRunnable + "");
                return;
            }
            thread.setName(runnable + "");
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
    public static class CoordinatorRejectHandler implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Object[] array = Coordinator.mPoolWorkQueue.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append(jl1.ARRAY_START);
            for (Object obj : array) {
                if (obj.getClass().isAnonymousClass()) {
                    sb.append(Coordinator.getOuterClass(obj));
                    sb.append(WVFileInfo.DIVISION);
                    sb.append(' ');
                } else {
                    sb.append(obj);
                    sb.append('>');
                    sb.append(' ');
                }
            }
            sb.append(jl1.ARRAY_END);
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString() + " in " + sb.toString());
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

        @Override // com.taobao.android.task.Coordinator.PriorityQueue
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

    /* compiled from: Taobao */
    public interface ThreadInfoListener {
        void threadInfo(int i, String str, long j, long j2, long j3, String str2, int i2, ThreadPoolExecutor threadPoolExecutor);
    }

    /* compiled from: Taobao */
    static class a implements ThreadFactory {
        a() {
            new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            if (runnable instanceof TaggedRunnable) {
                runnable.toString();
            } else {
                runnable.getClass();
            }
            return new Thread(runnable, Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + runnable.getClass().getName());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Coordinator.sThreadPoolExecutor.execute((StandaloneTask) message.obj);
        }
    }

    /* compiled from: Taobao */
    static class c implements MessageQueue.IdleHandler {
        c() {
        }

        public boolean queueIdle() {
            Queue<TaggedRunnable> queue = Coordinator.mIdleTasks;
            TaggedRunnable poll = queue.poll();
            if (poll == null) {
                return false;
            }
            Coordinator.postTask(poll);
            return !queue.isEmpty();
        }
    }

    /* compiled from: Taobao */
    static class d<Runnable> implements Comparator<Runnable> {
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

    static {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(100, new d());
        mPoolWorkQueue = priorityBlockingQueue;
        CoordThreadPoolExecutor coordThreadPoolExecutor = new CoordThreadPoolExecutor(8, 16, 1, TimeUnit.SECONDS, priorityBlockingQueue, new a(), new CoordinatorRejectHandler());
        sThreadPoolExecutor = coordThreadPoolExecutor;
        coordThreadPoolExecutor.allowCoreThreadTimeOut(true);
        SaturativeExecutor.installAsDefaultAsyncTaskExecutor(sThreadPoolExecutor);
    }

    protected static void dumpTask() {
        Object[] array = mPoolWorkQueue.toArray();
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.ARRAY_START);
        for (Object obj : array) {
            if (obj.getClass().isAnonymousClass()) {
                sb.append(getOuterClass(obj));
                sb.append(WVFileInfo.DIVISION);
                sb.append(' ');
            } else {
                sb.append(obj);
                sb.append('>');
                sb.append(' ');
            }
        }
        sb.append(jl1.ARRAY_END);
        Log.w(TAG, "Task size:" + array.length + " --" + sb.toString());
    }

    public static void execute(Runnable runnable) {
        sThreadPoolExecutor.execute(runnable, 30);
    }

    @Nullable
    static Executor getDefaultAsyncTaskExecutor() {
        if (Build.VERSION.SDK_INT >= 11) {
            return AsyncTask.SERIAL_EXECUTOR;
        }
        try {
            Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
            declaredField.setAccessible(true);
            return (Executor) declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ThreadPoolExecutor getDefaultThreadPoolExecutor() {
        return sThreadPoolExecutor;
    }

    protected static Object getOuterClass(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("this$0");
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return obj;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return obj;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return obj;
        }
    }

    @Deprecated
    public static void postIdleTask(TaggedRunnable taggedRunnable) {
        mIdleTasks.add(taggedRunnable);
    }

    @Deprecated
    public static void postTask(TaggedRunnable taggedRunnable) {
        postTask(taggedRunnable, Priority.DEFAULT);
    }

    @Deprecated
    public static void removeDelayTask(TaggedRunnable taggedRunnable) {
        Handler handler = sHandler;
        if (handler != null) {
            handler.removeMessages(taggedRunnable.hashCode());
        }
    }

    @Deprecated
    public static void runTask(TaggedRunnable taggedRunnable) {
        runWithTiming(taggedRunnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if ((r18 instanceof com.taobao.android.task.Coordinator.PriorityQueue) != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        r16 = ((com.taobao.android.task.Coordinator.PriorityQueue) r18).getQueuePriority();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        r16 = 30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        com.taobao.android.task.Coordinator.sThreadInfoListener.threadInfo(r7, r18.getClass().getName(), r9, r11, r13, r18.getClass().getName(), r16, com.taobao.android.task.Coordinator.sThreadPoolExecutor);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a4, code lost:
        if ((r18 instanceof com.taobao.android.task.Coordinator.PriorityQueue) != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    protected static void runWithTiming(Runnable runnable) {
        long j;
        long threadCpuTimeNanos;
        long currentTimeMillis;
        long j2 = 0;
        if (sThreadInfoListener != null) {
            j = System.currentTimeMillis();
            j2 = Debug.threadCpuTimeNanos();
        } else {
            j = 0;
        }
        int myTid = Process.myTid();
        if (Looper.getMainLooper() != Looper.myLooper()) {
            int i = 10;
            if (runnable instanceof TaggedRunnable) {
                i = ((TaggedRunnable) runnable).mThreadPriority;
            }
            Process.setThreadPriority(i);
        }
        try {
            runnable.run();
            if (sThreadInfoListener != null) {
                threadCpuTimeNanos = (Debug.threadCpuTimeNanos() - j2) / 1000000;
                currentTimeMillis = System.currentTimeMillis() - j;
                if (sThreadInfoListener == null) {
                }
            }
        } catch (Throwable th) {
            if (sThreadInfoListener != null) {
                long threadCpuTimeNanos2 = (Debug.threadCpuTimeNanos() - j2) / 1000000;
                long currentTimeMillis2 = System.currentTimeMillis() - j;
                if (sThreadInfoListener != null) {
                    sThreadInfoListener.threadInfo(myTid, runnable.getClass().getName(), j, currentTimeMillis2, threadCpuTimeNanos2, runnable.getClass().getName(), runnable instanceof PriorityQueue ? ((PriorityQueue) runnable).getQueuePriority() : 30, sThreadPoolExecutor);
                }
            }
            throw th;
        }
    }

    @Deprecated
    public static void scheduleIdleTasks() {
        Looper.myQueue().addIdleHandler(new c());
    }

    public static void setThreadInfoListener(ThreadInfoListener threadInfoListener) {
        sThreadInfoListener = threadInfoListener;
    }

    public static void execute(Runnable runnable, int i) {
        sThreadPoolExecutor.execute(runnable, i);
    }

    @Deprecated
    public static void postTask(TaggedRunnable taggedRunnable, Priority priority) {
        sThreadPoolExecutor.execute(new StandaloneTask(taggedRunnable));
    }

    @Deprecated
    public static void execute(TaggedRunnable taggedRunnable, int i, int i2) {
        StandaloneTask standaloneTask = new StandaloneTask(taggedRunnable);
        if (i < 1) {
            i = 1;
        }
        taggedRunnable.mQueuePriority = i;
        if (i2 > 0) {
            Message obtain = Message.obtain();
            obtain.what = taggedRunnable.hashCode();
            obtain.obj = standaloneTask;
            if (sHandler == null) {
                sHandler = new b(Looper.getMainLooper());
            }
            sHandler.sendMessageDelayed(obtain, (long) i2);
            return;
        }
        sThreadPoolExecutor.execute(standaloneTask);
    }

    @Deprecated
    public static void postTask(TaggedRunnable taggedRunnable, int i) {
        execute(taggedRunnable, 10, i);
    }

    /* compiled from: Taobao */
    public static abstract class TaggedRunnable implements PriorityQueue, Runnable {
        final String mName;
        int mQueuePriority = 30;
        int mThreadPriority = 10;
        int mTraffictag = 0;

        public TaggedRunnable(String str) {
            this.mName = str;
        }

        @Override // com.taobao.android.task.Coordinator.PriorityQueue
        public int getQueuePriority() {
            return this.mQueuePriority;
        }

        public void setThreadPriority(int i) {
            if (i < 1) {
                i = 1;
            }
            this.mThreadPriority = i;
        }

        public void setTrafficTag(int i) {
            this.mTraffictag = i;
        }

        public String toString() {
            return getClass().getName() + '@' + this.mName;
        }

        public TaggedRunnable(String str, int i) {
            this.mName = str;
            if (i < 0) {
                i = 0;
            } else if (i > 100) {
                i = 100;
            }
            this.mQueuePriority = i;
        }
    }

    @Deprecated
    public static void postTask(TaggedRunnable taggedRunnable, Priority priority, int i) {
        execute(taggedRunnable, 10, i);
    }
}
