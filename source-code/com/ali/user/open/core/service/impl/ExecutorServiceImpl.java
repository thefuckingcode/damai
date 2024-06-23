package com.ali.user.open.core.service.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import tb.jl1;

/* compiled from: Taobao */
public final class ExecutorServiceImpl implements MemberExecutorService {
    private final Handler handler;
    private final HandlerThread handlerThread;
    private ThreadPoolExecutor mExecutor;
    private final BlockingQueue<Runnable> mPoolWorkQueue = new LinkedBlockingQueue(128);
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    public static class CoordinatorRejectHandler implements RejectedExecutionHandler {
        private BlockingQueue<Runnable> mPoolWorkQueue;

        public CoordinatorRejectHandler(BlockingQueue<Runnable> blockingQueue) {
            this.mPoolWorkQueue = blockingQueue;
        }

        private Object getOuterClass(Object obj) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("this$0");
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
                return obj;
            }
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Object[] array = this.mPoolWorkQueue.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append(jl1.ARRAY_START);
            for (Object obj : array) {
                if (obj.getClass().isAnonymousClass()) {
                    sb.append(getOuterClass(obj));
                    sb.append(',');
                    sb.append(' ');
                } else {
                    sb.append(obj.getClass());
                    sb.append(',');
                    sb.append(' ');
                }
            }
            sb.append(jl1.ARRAY_END);
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString() + " in " + sb.toString());
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0029 A[LOOP:0: B:2:0x0029->B:13:0x0029, LOOP_START, SYNTHETIC] */
    public ExecutorServiceImpl() {
        HandlerThread handlerThread2 = new HandlerThread("SDK Looper Thread");
        this.handlerThread = handlerThread2;
        CommonUtils.sendUT("init_step_ucc_init_executor");
        handlerThread2.start();
        synchronized (handlerThread2) {
            while (this.handlerThread.getLooper() == null) {
                this.handlerThread.wait();
            }
        }
        this.handler = new Handler(this.handlerThread.getLooper());
        AnonymousClass1 r9 = new ThreadFactory() {
            /* class com.ali.user.open.core.service.impl.ExecutorServiceImpl.AnonymousClass1 */
            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ExecutorTask #" + this.mCount.getAndIncrement());
            }
        };
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> blockingQueue = this.mPoolWorkQueue;
        this.mExecutor = new ThreadPoolExecutor(4, 8, (long) 1, timeUnit, blockingQueue, r9, new CoordinatorRejectHandler(blockingQueue));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.mExecutor.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    @Override // com.ali.user.open.core.service.MemberExecutorService
    public Looper getDefaultLooper() {
        return this.handlerThread.getLooper();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.mExecutor.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.mExecutor.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.mExecutor.isShutdown();
    }

    public boolean isTerminated() {
        return this.mExecutor.isTerminated();
    }

    @Override // com.ali.user.open.core.service.MemberExecutorService
    public void postHandlerTask(Runnable runnable) {
        this.handler.post(runnable);
    }

    @Override // com.ali.user.open.core.service.MemberExecutorService
    public void postTask(Runnable runnable) {
        if (ExecutorServiceInjectManager.getInjectThreadPoolExecutor() != null) {
            ExecutorServiceInjectManager.getInjectThreadPoolExecutor().execute(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    @Override // com.ali.user.open.core.service.MemberExecutorService
    public void postUITask(final Runnable runnable) {
        this.mainHandler.post(new Runnable() {
            /* class com.ali.user.open.core.service.impl.ExecutorServiceImpl.AnonymousClass2 */

            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    SDKLogger.e(KernelContext.TAG, th.getMessage(), th);
                }
            }
        });
    }

    public void shutdown() {
        this.mExecutor.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.mExecutor.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.mExecutor.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.mExecutor.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.mExecutor.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.mExecutor.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.mExecutor.submit(runnable);
    }
}
