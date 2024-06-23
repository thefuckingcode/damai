package com.taobao.android.task;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class SaturativeExecutor extends ThreadPoolExecutor {
    private static final boolean DEBUG = false;
    private static final int KEEP_ALIVE = 1;
    private static final int MAX_POOL_SIZE = 128;
    private static final int MIN_THREADS_BEFORE_SATURATION = 3;
    private static final Pattern PATTERN_CPU_ENTRIES = Pattern.compile("cpu[0-9]+");
    private static final int QUEUE_CAPACITY = 1024;
    static final String TAG = "SatuExec";
    private static SaturationAwareBlockingQueue<Runnable> mQueue;
    private static final HashSet<Thread> mThreads = new HashSet<>();
    private static final ThreadFactory sThreadFactory = new b();

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static class CountedTask implements Runnable {
        static final AtomicInteger mNumRunning = new AtomicInteger();
        Runnable mRunnable;

        public CountedTask(Runnable runnable) {
            this.mRunnable = runnable;
        }

        public void run() {
            AtomicInteger atomicInteger = mNumRunning;
            atomicInteger.incrementAndGet();
            try {
                this.mRunnable.run();
                atomicInteger.decrementAndGet();
            } catch (Throwable th) {
                mNumRunning.decrementAndGet();
                throw th;
            }
        }
    }

    /* compiled from: Taobao */
    protected static class SaturationAwareBlockingQueue<T> extends LinkedBlockingQueue<T> {
        private static final long serialVersionUID = 1;
        private SaturativeExecutor mExecutor;

        public SaturationAwareBlockingQueue(int i) {
            super(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractQueue, java.util.concurrent.BlockingQueue, java.util.Queue
        public boolean add(T t) {
            if (!this.mExecutor.isReallyUnsaturated()) {
                return super.add(t);
            }
            throw new IllegalStateException("Unsaturated");
        }

        @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.concurrent.LinkedBlockingQueue
        public boolean offer(T t) {
            if (this.mExecutor.isReallyUnsaturated()) {
                return false;
            }
            return super.offer(t);
        }

        @Override // java.util.concurrent.BlockingQueue, java.util.concurrent.LinkedBlockingQueue
        public void put(T t) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public void setExecutor(SaturativeExecutor saturativeExecutor) {
            this.mExecutor = saturativeExecutor;
        }

        @Override // java.util.concurrent.BlockingQueue, java.util.concurrent.LinkedBlockingQueue
        public boolean offer(T t, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements FileFilter {
        a() {
        }

        public boolean accept(File file) {
            return SaturativeExecutor.PATTERN_CPU_ENTRIES.matcher(file.getName()).matches();
        }
    }

    /* compiled from: Taobao */
    static class b implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        b() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "SaturativeThread #" + this.a.getAndIncrement());
            SaturativeExecutor.collectThread(thread);
            return thread;
        }
    }

    public SaturativeExecutor() {
        this(determineBestMinPoolSize());
    }

    protected static void collectThread(Thread thread) {
        HashSet<Thread> hashSet = mThreads;
        synchronized (hashSet) {
            hashSet.add(thread);
        }
    }

    private static int countCpuCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int determineBestMinPoolSize() {
        int countCpuCores = countCpuCores();
        return countCpuCores > 0 ? countCpuCores : Runtime.getRuntime().availableProcessors() * 2;
    }

    public static final boolean installAsDefaultAsyncTaskExecutor(ThreadPoolExecutor threadPoolExecutor) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("THREAD_POOL_EXECUTOR");
                declaredField.setAccessible(true);
                declaredField.set(null, threadPoolExecutor);
            } catch (Exception unused) {
                Log.d(TAG, "Failed to install THREAD_POOL_EXECUTOR as default executor of AsyncTask.");
            }
        }
        try {
            Method method = AsyncTask.class.getMethod("setDefaultExecutor", Executor.class);
            method.setAccessible(true);
            method.invoke(null, threadPoolExecutor);
            return true;
        } catch (Exception unused2) {
            try {
                Field declaredField2 = AsyncTask.class.getDeclaredField("sDefaultExecutor");
                declaredField2.setAccessible(true);
                declaredField2.set(null, threadPoolExecutor);
                return true;
            } catch (Exception unused3) {
                try {
                    Field declaredField3 = AsyncTask.class.getDeclaredField("sExecutor");
                    declaredField3.setAccessible(true);
                    declaredField3.set(null, threadPoolExecutor);
                    return true;
                } catch (Exception unused4) {
                    Log.d(TAG, "Failed to install as default executor of AsyncTask.");
                    return false;
                }
            }
        }
    }

    public void execute(Runnable runnable) {
        super.execute(new CountedTask(runnable));
    }

    /* access modifiers changed from: protected */
    public boolean isReallyUnsaturated() {
        if (isSaturated()) {
            return false;
        }
        LockSupport.parkNanos(10);
        if (isSaturated()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isSaturated() {
        int i;
        if (getPoolSize() <= 3) {
            return false;
        }
        int corePoolSize = getCorePoolSize();
        int i2 = CountedTask.mNumRunning.get();
        HashSet<Thread> hashSet = mThreads;
        int size = hashSet.size();
        if (i2 < corePoolSize || i2 < size) {
            return true;
        }
        synchronized (hashSet) {
            Iterator<Thread> it = hashSet.iterator();
            i = 0;
            while (it.hasNext()) {
                Thread.State state = it.next().getState();
                if (state != Thread.State.RUNNABLE) {
                    if (state != Thread.State.NEW) {
                        if (state == Thread.State.TERMINATED) {
                            it.remove();
                        }
                    }
                }
                i++;
            }
        }
        if (i >= corePoolSize) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public SaturativeExecutor(int i) {
        super(i, 128, 1, r5, r6, sThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SaturationAwareBlockingQueue<Runnable> saturationAwareBlockingQueue = new SaturationAwareBlockingQueue<>(1024);
        mQueue = saturationAwareBlockingQueue;
        ((SaturationAwareBlockingQueue) getQueue()).setExecutor(this);
    }
}
